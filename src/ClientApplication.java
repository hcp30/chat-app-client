import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class ClientApplication {
    public static void main(String[] args) {
        System.out.println("client!");


        try (Socket socket = new Socket("localhost",8080)){
            OutputStream os = socket.getOutputStream();
            os.write("hello from client".getBytes());
            os.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}