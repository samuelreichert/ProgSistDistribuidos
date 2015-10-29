
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
public class Moto implements Serializable{
    private String marca;
    private String modelo;
    private Boolean mataCachorro;

    @Override
    public String toString() {        
        String saida = getMarca() + " " + getModelo();
        saida += (getMataCachorro())? " com mata-cachorro":"";
        return saida;
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
     * @return the mataCachorro
     */
    public Boolean getMataCachorro() {
        return mataCachorro;
    }

    /**
     * @param mataCachorro the mataCachorro to set
     */
    public void setMataCachorro(Boolean mataCachorro) {
        this.mataCachorro = mataCachorro;
    }
    
    
}
