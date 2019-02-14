/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author tomas
 */
public class ClsEntidadRetorno {

    //Atributos
    private int vgn_Resultado;
    private String vgc_Mensaje;

    //Constructores.
    public ClsEntidadRetorno(int vgn_Resultado, String vgc_Mensaje) {
        this.vgn_Resultado = vgn_Resultado;
        this.vgc_Mensaje = vgc_Mensaje;
    }

    public ClsEntidadRetorno() {
        vgc_Mensaje = "";
        vgn_Resultado = 0;
    }
    
    //Propiedades

    public int getVgn_Resultado() {
        return vgn_Resultado;
    }

    public void setVgn_Resultado(int vgn_Resultado) {
        this.vgn_Resultado = vgn_Resultado;
    }

    public String getVgc_Mensaje() {
        return vgc_Mensaje;
    }

    public void setVgc_Mensaje(String vgc_Mensaje) {
        this.vgc_Mensaje = vgc_Mensaje;
    }
    
}
