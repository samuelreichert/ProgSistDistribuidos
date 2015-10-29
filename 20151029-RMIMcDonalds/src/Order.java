
import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gabriel
 */
public class Order implements Serializable{
    private String item;

    public Order(String item) {
        this.item = item;
    }

    public String getItem() {
        return item;
    }
}
