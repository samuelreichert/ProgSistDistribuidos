
import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gabriel
 */
public class Servidor {
    public static void main(String args[]){
        try {
            ServerSocket ss = new ServerSocket(8084);
            Socket s = ss.accept();
            ObjectOutputStream oOut = new ObjectOutputStream(s.getOutputStream());
           
            Moto m1 = new Moto();
            m1.setMarca("Yamaha");
            m1.setModelo("RD350");
            m1.setMataCachorro(false);
            
            Carro c1 = new Carro();
            c1.setMarca("VW");
            c1.setModelo("Fusca");
            c1.setnPortas(2);
            
            oOut.writeObject(m1);
            oOut.writeObject(c1);
            oOut.flush();                      
            
            oOut.close();
            s.close();
            
        } catch (Exception e) {
            e.printStackTrace();;
        }
    }
}
