
import java.io.ObjectInputStream;
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
public class Cliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            Socket s = new Socket("localhost",8084);
            ObjectInputStream oIn = new ObjectInputStream(s.getInputStream());
            Moto mX = (Moto) oIn.readObject();
            Carro cX = (Carro) oIn.readObject();
            
            System.out.println(mX);
            System.out.println(cX);
        } catch (Exception e) {
            e.printStackTrace();;
        }
    }
    
}
