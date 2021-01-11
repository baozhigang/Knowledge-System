import java.io.*;
import java.net.Socket;

public class SocketTest {
    public static void main(String[] args) {
        try {
            Socket chatSocket = new Socket("127.0.0.1", 5000);
            InputStreamReader stream = new InputStreamReader(chatSocket.getInputStream());
            BufferedReader reader = new BufferedReader(stream);
            String message = reader.readLine();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}