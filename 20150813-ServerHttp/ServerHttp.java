import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by samuel on 14/08/15.
 */
public class ServerHttp {
  public static void main(String[] args) {
    try {
      ServerSocket ss = new ServerSocket(8088);
      System.out.println("Porta 8088 aberta!");
      Socket cliente = ss.accept();
      
      BufferedReader in = new BufferedReader(
        new InputStreamReader(cliente.getInputStream()));

      String r;
      while ((r = in.readLine()) != null) {
        System.out.println(r);
      }
      // imprime o ip do cliente
      // System.out.println("IP do cliente: " + cliente.getInetAddress().getHostAddress());
    } catch (Exception e){
      e.printStackTrace();
    }
  }
}
