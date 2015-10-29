
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.rmi.RemoteException;
import javax.swing.JOptionPane;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Gabriel
 */
public class ImplementacaoRMIInverteString implements InterfaceRMIInverteString {
    
    public String inverteString(String s) throws RemoteException {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }

    public String concatenaString(String s) throws RemoteException {
        return s + " foi concatenado a este texto!";
    }

    public String somaNumeros(String n1, String n2) throws RemoteException {
        int v1 = Integer.parseInt(n1);
        int v2 = Integer.parseInt(n2);
        return v1 + v2 + "";
    }

    public void exibeMsg(String msg) throws RemoteException {
        JOptionPane.showMessageDialog(null, msg);
    }

    public void transfereBytes(byte[] bytes, String n) throws RemoteException {
        try {
            FileOutputStream fDest = new FileOutputStream("c:\\temp\\" + n);
            fDest.write(bytes);
            fDest.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(bytes.length + "");
    }

    public void passaFile(File f) throws RemoteException {
        FileInputStream fSource = null;
        try {
            System.out.println(f.length() + "");
            fSource = new FileInputStream(f);
            int bufferSize = (int) f.length();
            byte[] buffer = new byte[bufferSize];
            fSource.read(buffer);
            String fileName = f.getName();

            FileOutputStream fDest = new FileOutputStream("c:\\temp\\RMI\\" + fileName);
            fDest.write(buffer);
            fDest.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String converteMaiusculo(String txt) throws RemoteException {
        return txt.toUpperCase();
    }
}
