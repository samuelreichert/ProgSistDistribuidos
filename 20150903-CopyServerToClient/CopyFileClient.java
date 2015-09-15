import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.Socket;

/**
 * Created by samuel on 03/09/15.
 */
public class CopyFileClient {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost",8880);
            InputStream in = s.getInputStream();
            byte buffer[] = new byte[128];
            int bytesLidos = 0;
            int nBytes = in.read();
            byte fileNameBytes[] = new byte[nBytes];
            in.read(fileNameBytes);

            FileOutputStream fileOut = new FileOutputStream("/home/samuel/Downloads/" +
                new String(fileNameBytes));

            while((bytesLidos = in.read(buffer)) > -1){
                fileOut.write(buffer, 0, bytesLidos);
            }
            fileOut.flush();
            fileOut.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
