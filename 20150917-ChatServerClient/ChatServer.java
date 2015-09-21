import javax.swing.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by samuel on 17/09/15.
 */
public class ChatServer implements Runnable {
    JTextArea txtMsgRecebida;
    int porta;
    ServerSocket serverSocket;
    Socket socket;
    BufferedReader entrada;
    PrintWriter saida;
    Thread threadInitServer;

    public void setPorta(int porta) {
        this.porta = porta;
    }

    public void setTxtMsgRecebida(JTextArea txtMsgRecebida) {
        this.txtMsgRecebida = txtMsgRecebida;
    }

    @Override
    public void run() {
        aguardarConexao();
        receberMensagem();
    }

    public void initServer() {
        threadInitServer = new Thread(this);
        threadInitServer.start();
    }

    public void aguardarConexao(){
        try {
            serverSocket = new ServerSocket(porta);
            socket = serverSocket.accept();
            entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            saida = new PrintWriter(socket.getOutputStream());
        } catch(Exception e) {
            e.printStackTrace();
            System.out.println("Deu erro aqui: " + e);
        }
    }

    public void receberMensagem(){
        try {
            String msgRecebida;
            while ((msgRecebida = entrada.readLine()) != null) {
                txtMsgRecebida.append(msgRecebida);
                txtMsgRecebida.append("\n");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void enviarMensagem(String msg){
        saida.println(msg);
        saida.flush();
        txtMsgRecebida.append(msg);
        txtMsgRecebida.append("\n");
    }
}
