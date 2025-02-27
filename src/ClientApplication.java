import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientApplication {
    public static void main(String[] args) {
        System.out.println("client!");


        try (Socket socket = new Socket("localhost",8080)){
            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            OutputStream os = socket.getOutputStream();
            PrintWriter printWriter = new PrintWriter(os,true);
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter message: ");
            while (sc.hasNext()) {
                String message = sc.nextLine();
                if (message.equals("exit")) break;
                printWriter.println(message);
                String messageFromServer = br.readLine();
                System.out.println("From Server:" + messageFromServer);
                System.out.print("Enter message: ");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}