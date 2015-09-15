import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by samuel on 03/09/15.
 */
public class CopyFileServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8880);

            while (true) {
                Socket socket = serverSocket.accept();
                String fileName = "exemplo.txt";
                FileInputStream fIn = new FileInputStream("/home/samuel/" + fileName);
                byte buffer[] = new byte[512];
                OutputStream out = socket.getOutputStream();
                out.write(fileName.length());
                out.write(fileName.getBytes());
                out.flush();

                int bytesLidos = 0;
                while((bytesLidos = fIn.read(buffer)) > -1){
                    out.write(buffer,0, bytesLidos);
                }
                out.flush();
                out.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
