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
    ClsMonitor vlo_Monitor;
    ClsTeclado vlo_Teclado;
    ClsRaton vlo_Raton;

    //Constructores
    public ClsComputadora() {
        vgc_nombre = "";
        vgn_idComputadora = 0;
        vlo_Monitor = new ClsMonitor();
        vlo_Raton = new ClsRaton();
        vlo_Teclado = new ClsTeclado();
    }

}
