import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Client extends Remote{
    public void notifyOrder(Order p) throws RemoteException;
    public void notifyDelivery() throws RemoteException;
}
