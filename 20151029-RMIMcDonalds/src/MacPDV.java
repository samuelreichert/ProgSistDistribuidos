import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MacPDV extends Remote{
    public String connectionOk() throws RemoteException;
    public void registerClient(Client c) throws RemoteException;
    public void unregisterClient(Client c) throws RemoteException;
    public void notifyOrderDone() throws RemoteException;
}
