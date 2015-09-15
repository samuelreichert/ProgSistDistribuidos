/**
 * Created by samuel on 10/09/15.
 */
public class ContagemCrescente implements Runnable {
    Integer value = 0;
    private void contar(){
        while(true){
            System.out.println(value);
            value++;
            try{
                Thread.sleep(400);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
    @Override
    public void run() {
        contar();
    }
}
