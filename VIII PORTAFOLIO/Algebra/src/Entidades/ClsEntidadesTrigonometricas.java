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
public class ClsEntidadesTrigonometricas {

    //Atributos
    double vgn_Seno, vgn_Coseno, vgn_Tangente;

    //Constructores
    public ClsEntidadesTrigonometricas(double vgn_Seno, double vgn_Coseno, double vgn_Tangente) {
        this.vgn_Seno = vgn_Seno;
        this.vgn_Coseno = vgn_Coseno;
        this.vgn_Tangente = vgn_Tangente;
    }

    public ClsEntidadesTrigonometricas() {
        vgn_Coseno = 0;
        vgn_Seno = 0;
        vgn_Tangente = 0;
    }
    
    //Propiedades

    public double getVgn_Seno() {
        return vgn_Seno;
    }

    public void setVgn_Seno(double vgn_Seno) {
        this.vgn_Seno = vgn_Seno;
    }

    public double getVgn_Coseno() {
        return vgn_Coseno;
    }

    public void setVgn_Coseno(double vgn_Coseno) {
        this.vgn_Coseno = vgn_Coseno;
    }

    public double getVgn_Tangente() {
        return vgn_Tangente;
    }

    public void setVgn_Tangente(double vgn_Tangente) {
        this.vgn_Tangente = vgn_Tangente;
    }
    
}
