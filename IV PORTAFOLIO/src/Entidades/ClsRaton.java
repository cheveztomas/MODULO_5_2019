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
        vgn_contadorRatones = 0;
        vgn_idRaton = 0;
    }

    public void ClsRatones(int pvn_idRaton, int pvn_contadorRatones) {
        vgn_contadorRatones = pvn_contadorRatones;
        vgn_idRaton = pvn_idRaton;
    }
}
