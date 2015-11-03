import java.io.Serializable;

public class Order implements Serializable{
    private String item;

    public Order(String item) {
        this.item = item;
    }

    public String getItem() {
        return item;
    }
}
