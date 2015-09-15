/**
 * Created by samuel on 10/09/15.
 */
public class ExemploThread {
    public static void main(String[] args) {
        ContagemCrescente contagemUp = new ContagemCrescente();
        ContagemDecrescente contagemDown = new ContagemDecrescente();

        Thread threadUp = new Thread(contagemUp);
        Thread segundaThreadUp = new Thread(contagemUp);
        Thread threadDown = new Thread(contagemDown);

        threadUp.start();
        segundaThreadUp.start();
        threadDown.start();
    }
}
