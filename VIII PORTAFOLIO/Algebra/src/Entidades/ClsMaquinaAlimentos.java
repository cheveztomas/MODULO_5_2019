/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author Thomas
 */
public class ClsMaquinaAlimentos {

    //Atributos
    private int vgn_Precio, vgn_Ingresado;

    //Constructor
    public ClsMaquinaAlimentos(int vgn_Precio, int vgn_Ingresado) {
        this.vgn_Precio = vgn_Precio;
        this.vgn_Ingresado = vgn_Ingresado;
    }

    public ClsMaquinaAlimentos() {
        vgn_Ingresado = 0;
        vgn_Precio = 0;
    }

    //Propiedades
    public int getVgn_Precio() {
        return vgn_Precio;
    }

    public void setVgn_Precio(int vgn_Precio) {
        this.vgn_Precio = vgn_Precio;
    }

    public int getVgn_Ingresado() {
        return vgn_Ingresado;
    }

    public void setVgn_Ingresado(int vgn_Ingresado) {
        this.vgn_Ingresado = vgn_Ingresado;
    }

}
