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
public class ClsComputadora {

    //Atributos
    private int vgn_idComputadora;
    private String vgc_nombre;
    ClsMonitor vgo_Monitor;
    ClsTeclado vgo_Teclado;
    ClsRaton vgo_Raton;

    //Constructores
    public ClsComputadora() {
        vgc_nombre = "";
        vgn_idComputadora = 0;
        vgo_Monitor = new ClsMonitor();
        vgo_Raton = new ClsRaton();
        vgo_Teclado = new ClsTeclado();
    }

    public ClsComputadora(int pvn_idComputadora, String pvc_nombre, ClsMonitor pvo_Monitor, ClsRaton pvo_Raton, ClsTeclado pvo_Teclado) {
        vgc_nombre = pvc_nombre;
        vgn_idComputadora = pvn_idComputadora;
        vgo_Monitor = pvo_Monitor;
        vgo_Raton = pvo_Raton;
        vgo_Teclado = pvo_Teclado;
    }

    //Metodos
    @Override
    public String toString() {
        //Variables
        String vlc_Cadena;

        //Inicio
        vlc_Cadena = vgc_nombre + ", " + vgn_idComputadora + ", " + vgo_Monitor + ", " + vgo_Raton + ", " + vgo_Teclado;

        return vlc_Cadena;
    }
}
