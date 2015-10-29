
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
public class Carro implements Serializable{
    private String marca;
    private String modelo;
    private Integer nPortas;

    @Override
    public String toString() {
        return getMarca() + " " + getModelo() + " com " + getnPortas() + " portas.";
    }

    /**
     * @return the marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * @return the modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * @return the nPortas
     */
    public Integer getnPortas() {
        return nPortas;
    }

    /**
     * @param nPortas the nPortas to set
     */
    public void setnPortas(Integer nPortas) {
        this.nPortas = nPortas;
    }
    
    
}
