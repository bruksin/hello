import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static ServerSocket serverSocket;
    private static BufferedReader input;
    private static BufferedWriter output;

    public static void main(String[] args) throws IOException {

            try {
                int serverPort = 2022;
                serverSocket = new ServerSocket(serverPort); // сервер слушает порт
                System.out.println("Сервер запущен и слушает порт " + serverPort);
                // ждем соединения
                try (Socket clientSocket = serverSocket.accept()) {
                    input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); // для принятия сообщений
                    output = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream())); // для отправки сообщений

                    String message = input.readLine(); // ждем сообщения от клиента
                    System.out.println(message);

                    output.write("Сообщение " + message + " принято сервером");
                    output.flush(); // необходимо вытолкнуть сообщение из буфера

                } finally {
                    input.close();
                    output.close();
                }
            }
            finally {
                System.out.println("Осторожно, сервер закрывается!");
                serverSocket.close();
            }




    }
}
