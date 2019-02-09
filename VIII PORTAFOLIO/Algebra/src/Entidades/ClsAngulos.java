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
public class ClsAngulos {

    //Atributos
    double vgn_Radianes, vgn_Grados;

    //Constructores
    public ClsAngulos() {
        vgn_Grados = 0;
        vgn_Radianes = 0;
    }

    public ClsAngulos(double vgn_Radianes, double vgn_Grados) {
        this.vgn_Radianes = vgn_Radianes;
        this.vgn_Grados = vgn_Grados;
    }

    //Propiedades
    public double getVgn_Radianes() {
        return vgn_Radianes;
    }

    public void setVgn_Radianes(double vgn_Radianes) {
        this.vgn_Radianes = vgn_Radianes;
    }

    public double getVgn_Grados() {
        return vgn_Grados;
    }

    public void setVgn_Grados(double vgn_Grados) {
        this.vgn_Grados = vgn_Grados;
    }

}
