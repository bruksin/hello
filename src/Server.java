import java.io.*;
import java.net.*;
import java.util.LinkedList;

class ServerSomthing extends Thread {

    private Socket socket; // сокет, через который сервер общается с клиентом,
    private BufferedReader in; // поток чтения из сокета
    private BufferedWriter out; // поток завписи в сокет


    public ServerSomthing(Socket socket) throws IOException {
        this.socket = socket;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        Server.story.printStory(out); // поток вывода передаётся для передачи истории последних 10
        // сооюбщений новому поключению
        start(); // вызываем run()
    }
    @Override
    public void run() {
        String word;
        try {
            // первое сообщение отправленное сюда - это никнейм
            word = in.readLine();
            try {
                out.write(word + "\n");
                out.flush(); // flush() нужен для выталкивания оставшихся данных
                // если такие есть, и очистки потока для дьнейших нужд
            } catch (IOException ignored) {}
            try {
                while (true) {
                    word = in.readLine();
                    if(word.equals("stop")) {
                        this.downService(); // харакири
                        break; // если пришла пустая строка - выходим из цикла прослушки
                    }
                    System.out.println("Лог: " + word);
                    Server.story.addStoryEl(word);
                    for (ServerSomthing vr : Server.serverList) {
                        vr.send(word); // отослать принятое сообщение с привязанного клиента всем остальным влючая его
                    }
                }
            } catch (NullPointerException ignored) {}


        } catch (IOException e) {
            this.downService();
        }
    }

    /**
     * отсылка одного сообщения клиенту по указанному потоку
     * @param msg
     */
    private void send(String msg) {
        try {
            out.write(msg + "\n");
            out.flush();
        } catch (IOException ignored) {}

    }

    /**
     * закрытие сервера
     * прерывание себя как нити и удаление из списка нитей
     */
    private void downService() {
        try {
            if(!socket.isClosed()) {
                socket.close();
                in.close();
                out.close();
                for (ServerSomthing vr : Server.serverList) {
                    if(vr.equals(this)) vr.interrupt();
                    Server.serverList.remove(this);
                }
            }
        } catch (IOException ignored) {}
    }
}

/**
 * класс хранящий в ссылочном приватном
 * списке информацию о последних 10 (или меньше) сообщениях
 */

class Story {

    private LinkedList<String> story = new LinkedList<>();

    /**
     * добавить новый элемент в список
     * @param el
     */

    public void addStoryEl(String el) {
        // если сообщений больше 10, удаляем первое и добавляем новое
        // иначе просто добавить
        if (story.size() >= 10) {
            story.removeFirst();
            story.add(el);
        } else {
            story.add(el);
        }
    }

    /**
     * отсылаем последовательно каждое сообщение из списка
     * в поток вывода данному клиенту (новому подключению)
     * @param writer
     */

    public void printStory(BufferedWriter writer) {
        if(story.size() > 0) {
            try {
                writer.write("История сообщений" + "\n");
                for (String vr : story) {
                    writer.write(vr + "\n");
                }
                writer.write("/...." + "\n");
                writer.flush();
            } catch (IOException ignored) {}

        }

    }
}

public class Server {
    public static final int serverPort = 2022;
    public static LinkedList<ServerSomthing> serverList = new LinkedList<>(); // список всех - экземпляров соединений
    public static Story story; // история переписки
    private static ServerSocket serverSocket; // серверсокет

    public static void main(String[] args) throws IOException {

            try {
                serverSocket = new ServerSocket(serverPort); // сервер слушает порт
                story = new Story();
                System.out.println("Сервер запущен и слушает порт " + serverPort);
                // ждем соединения
                try {
                    while (true) {
                        // Блокируется до возникновения нового соединения:
                        Socket socket = serverSocket.accept();
                        try {
                            serverList.add(new ServerSomthing(socket)); // добавить новое соединенние в список
                        } catch (IOException e) {
                            // Если завершится неудачей, закрывается сокет,
                            // в противном случае, нить закроет его:
                            socket.close();
                        }
                    }

                } finally {
                    serverSocket.close();
                }
            }
            finally {
                System.out.println("Осторожно, сервер закрывается!");
                serverSocket.close();
            }




    }
}
