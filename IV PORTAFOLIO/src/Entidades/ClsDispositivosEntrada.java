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
        vgc_Entrada = "";
        vgc_marca = "";
    }

    public void ClsDispositivosEntrada(String pvc_Entrada, String pvc_marca) {
        vgc_Entrada = pvc_Entrada;
        vgc_marca = pvc_marca;
    }

    //Metodos
    @Override
    public String toString() {
        //Variables
        String vlc_Cadena = "";

        //Inicio
        return vlc_Cadena;
    }

    //Propiedades
}
