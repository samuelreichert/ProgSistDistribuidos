import javax.swing.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by samuel on 17/09/15.
 */
public class ChatClient implements Runnable {
    JTextArea txtMsgRecebida;
    String server;
    int porta;
    Socket socket;
    BufferedReader entrada;
    PrintWriter saida;
    Thread threadInitClient;

    public void setServer(String server) {
        this.server = server;
    }

    public void setPorta(int porta) {
        this.porta = porta;
    }

    public void setTxtMsgRecebida(JTextArea txtMsgRecebida) {
        this.txtMsgRecebida = txtMsgRecebida;
    }

    @Override
    public void run() {
        conectar();
        receberMensagem();
    }

    public void initClient() {
        threadInitClient = new Thread(this);
        threadInitClient.start();
    }

    public void conectar() {
        try {
            socket = new Socket(server, porta);
            entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            saida = new PrintWriter(socket.getOutputStream());
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void enviarMensagem(String msg) {
        saida.println(msg);
        saida.flush();
        txtMsgRecebida.append(msg);
        txtMsgRecebida.append("\n");
    }

    public void receberMensagem() {
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
}
