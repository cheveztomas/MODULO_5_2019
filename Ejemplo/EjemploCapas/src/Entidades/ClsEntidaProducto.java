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
public class ClsEntidaProducto {

    //Atributos
    private int vgn_idPorducto;
    private String vgc_Descripcion;
    private double vgn_Precio;

    //Constructores
    public ClsEntidaProducto(int vgn_idPorducto, String vgc_Descripcion, double vgn_Precio) {
        this.vgn_idPorducto = vgn_idPorducto;
        this.vgc_Descripcion = vgc_Descripcion;
        this.vgn_Precio = vgn_Precio;
    }

    public ClsEntidaProducto() {
        vgc_Descripcion = "";
        vgn_Precio = 0;
        vgn_idPorducto = 0;
    }
    
    //Propiedades

    public int getVgn_idPorducto() {
        return vgn_idPorducto;
    }

    public void setVgn_idPorducto(int vgn_idPorducto) {
        this.vgn_idPorducto = vgn_idPorducto;
    }

    public String getVgc_Descripcion() {
        return vgc_Descripcion;
    }

    public void setVgc_Descripcion(String vgc_Descripcion) {
        this.vgc_Descripcion = vgc_Descripcion;
    }

    public double getVgn_Precio() {
        return vgn_Precio;
    }

    public void setVgn_Precio(double vgn_Precio) {
        this.vgn_Precio = vgn_Precio;
    }
    
}
