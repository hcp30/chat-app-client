import java.io.BufferedReader;
import java.io.IOException;

public class ClientListener implements Runnable {

    BufferedReader br;

    public ClientListener (BufferedReader br) {
        this.br = br;
    }

    @Override
    public void run() {
        String messageFromServer;
        try {
            while ((messageFromServer = br.readLine()) != null) {
                System.out.println(messageFromServer);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
