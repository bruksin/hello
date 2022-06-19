import java.io.*;
import java.net.Socket;

public class Client {
    private static Socket clientSocket;
    private static BufferedReader input; // для чтения из сокета
    private static BufferedWriter output;  // для записи в сокет

    public static void main(String[] args) throws IOException {
        try {

            int serverPort = 2022;
            String serverAddress = "localhost";
            clientSocket = new Socket(serverAddress, serverPort);
            // для чтения с консоли
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                output = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            String exitMessage = "exit";
            System.out.println("Пишите ващи сообщения сюда (" + exitMessage + " - завершить):");
                String message = reader.readLine();

                output.write(message + "\n");
                output.flush();
                String answer = input.readLine();
                System.out.println(answer);


        }
        finally {
            System.out.println("Осторожно, клиент закрывается!");
            clientSocket.close();
            input.close();
            output.close();
        }
    }
}
