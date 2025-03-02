import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientApplication {
    public static void main(String[] args) {
        System.out.println("client!");


        try (Socket socket = new Socket("localhost",8080)){
            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String connectionStatus = br.readLine();
            System.out.println(connectionStatus);
            OutputStream os = socket.getOutputStream();
            PrintWriter printWriter = new PrintWriter(os,true);
            ClientListener clientListener = new ClientListener(br);
            Thread thread = new Thread(clientListener);
            thread.start();
            Scanner sc = new Scanner(System.in);
            while (sc.hasNext()) {
                String message = sc.nextLine();
                if (message.equals("exit")) break;
                printWriter.println(message);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}