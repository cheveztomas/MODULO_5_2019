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
public class ClsRaton {

    //Atributos
    private int vgn_idRaton, vgn_contadorRatones;

    //Constructores
    public void ClsRatones() {
        setVgn_contadorRatones(0);
        setVgn_idRaton(0);
    }

    public void ClsRatones(int pvn_idRaton, int pvn_contadorRatones) {
        setVgn_contadorRatones(pvn_contadorRatones);
        setVgn_idRaton(pvn_idRaton);
    }

    //Metodos
    public String toString() {
        //Variables
        String vlc_Cadena = "";

        //Inicio
        vlc_Cadena = getVgn_contadorRatones() + ", " + getVgn_idRaton();

        return vlc_Cadena;
    }

    //Propiedades

    /**
     * @return the vgn_idRaton
     */
    public int getVgn_idRaton() {
        return vgn_idRaton;
    }

    /**
     * @param vgn_idRaton the vgn_idRaton to set
     */
    public void setVgn_idRaton(int vgn_idRaton) {
        this.vgn_idRaton = vgn_idRaton;
    }

    /**
     * @return the vgn_contadorRatones
     */
    public int getVgn_contadorRatones() {
        return vgn_contadorRatones;
    }

    /**
     * @param vgn_contadorRatones the vgn_contadorRatones to set
     */
    public void setVgn_contadorRatones(int vgn_contadorRatones) {
        this.vgn_contadorRatones = vgn_contadorRatones;
    }
    
}
