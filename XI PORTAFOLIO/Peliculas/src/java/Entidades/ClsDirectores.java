/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author Thomas Chevez
 */
public class ClsDirectores {

    //Atributos
    private int vgn_idDirector;
    private String vgc_Nombre;

    //Constructores
    public ClsDirectores(int vgn_idDirector, String vgc_Nombre) {
        this.vgn_idDirector = vgn_idDirector;
        this.vgc_Nombre = vgc_Nombre;
    }

    public ClsDirectores() {
        vgc_Nombre = "";
        vgn_idDirector = 0;
    }
    
    //Propiedades

    public int getVgc_idDirector() {
        return vgn_idDirector;
    }

    public void setVgc_idDirector(int vgn_idDirector) {
        this.vgn_idDirector = vgn_idDirector;
    }

    public String getVgc_Nombre() {
        return vgc_Nombre;
    }

    public void setVgc_Nombre(String vgc_Nombre) {
        this.vgc_Nombre = vgc_Nombre;
    }
    
}
