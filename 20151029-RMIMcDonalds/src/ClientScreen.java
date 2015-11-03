import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ClientScreen extends UnicastRemoteObject implements Client {
    public PainelCozinha panel;
    
    public ClientScreen() throws RemoteException{
        super();
    }
    
    @Override
    public void notifyOrder(Order o) throws RemoteException {
        panel.txtSaidaPedidos.append(o.getItem());
        panel.txtSaidaPedidos.append("\n");
    }

    @Override
    public void notifyDelivery() throws RemoteException {
        panel.txtSaidaPedidos.setText("");
    }    
}
