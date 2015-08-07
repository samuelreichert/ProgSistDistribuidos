import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class HttpFeevale {
  public static void main(String[] args){
    try{
      Socket s = new Socket("www.feevale.br", 80);
      PrintWriter out = new PrintWriter(s.getOutputStream());
      BufferedReader in = new BufferedReader(
        new InputStreamReader(s.getInputStream())
      );
      
      out.print("GET / HTTP/1.0\r\n\r\n");
      out.flush();

      while (in.readLine() != null){
        System.out.println(in.readLine());
      }

    }catch(Exception e){
      e.printStackTrace();
    }
  }
}
