/**
 * Created by samuel on 10/09/15.
 */
public class ContagemDecrescente implements Runnable {
    Integer value = 100000;

    private void diminuir(){
        while(true){
            System.out.println(value);
            value--;
            try{
                Thread.sleep(400);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
    @Override
    public void run() {
        diminuir();
    }
}
