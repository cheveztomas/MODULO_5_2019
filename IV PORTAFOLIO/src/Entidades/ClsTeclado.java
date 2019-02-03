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
public class ClsTeclado extends ClsDispositivosEntrada{

    //Atributos
    private int vgc_idTeclado;
    private int vgc_contadorTeclado;

    //Constructores
    public void ClsTeclado() {
        vgc_contadorTeclado = 0;
        vgc_idTeclado = 0;
    }

    public void ClsTeclado(int pvn_contadorTeclado, int pvn_idTeclado) {
        vgc_contadorTeclado = pvn_contadorTeclado;
        vgc_idTeclado = pvn_idTeclado;
    }

    //Metodos
    public String toString() {
        //Variables
        String vlc_Cadena = "";

        //Inicio
        vlc_Cadena = vgc_contadorTeclado + ", " + vgc_idTeclado;

        return vlc_Cadena;
    }
}
