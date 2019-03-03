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
public class ClsRetorno {

    //Atributos
    private int vgn_id;
    private String vgc_Mensaje;

    //Constructores
    public ClsRetorno(int vgn_id, String vgc_Mensaje) {
        this.vgn_id = vgn_id;
        this.vgc_Mensaje = vgc_Mensaje;
    }

    public ClsRetorno() {
        vgc_Mensaje = "";
        vgn_id = 0;
    }
    
    //Propiedades
    public int getVgn_id() {
        return vgn_id;
    }

    public void setVgn_id(int vgn_id) {
        this.vgn_id = vgn_id;
    }

    public String getVgc_Mensaje() {
        return vgc_Mensaje;
    }

    public void setVgc_Mensaje(String vgc_Mensaje) {
        this.vgc_Mensaje = vgc_Mensaje;
    }
    
}
