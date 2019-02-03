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
public class ClsDispositivosEntrada {

    //Atributos
    private String vgc_Entrada, vgc_marca;

    //Constructores
    public void ClsDispositivosEntrada() {
        setVgc_Entrada("");
        setVgc_marca("");
    }

    public void ClsDispositivosEntrada(String pvc_Entrada, String pvc_marca) {
        setVgc_Entrada(pvc_Entrada);
        setVgc_marca(pvc_marca);
    }

    //Metodos
    @Override
    public String toString() {
        //Variables
        String vlc_Cadena = "";

        //Inicio
        vlc_Cadena = getVgc_Entrada() + ", " + getVgc_marca();

        return vlc_Cadena;
    }

    //Propiedades

    /**
     * @return the vgc_Entrada
     */
    public String getVgc_Entrada() {
        return vgc_Entrada;
    }

    /**
     * @param vgc_Entrada the vgc_Entrada to set
     */
    public void setVgc_Entrada(String vgc_Entrada) {
        this.vgc_Entrada = vgc_Entrada;
    }

    /**
     * @return the vgc_marca
     */
    public String getVgc_marca() {
        return vgc_marca;
    }

    /**
     * @param vgc_marca the vgc_marca to set
     */
    public void setVgc_marca(String vgc_marca) {
        this.vgc_marca = vgc_marca;
    }
    
}
