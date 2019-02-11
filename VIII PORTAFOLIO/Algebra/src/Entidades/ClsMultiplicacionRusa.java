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
public class ClsMultiplicacionRusa {

    //Atributos
    private int vln_PrimerValor, vln_SegundoValor;

    //Constructor
    public ClsMultiplicacionRusa(int vln_PrimerValor, int vln_SegundoValor) {
        this.vln_PrimerValor = vln_PrimerValor;
        this.vln_SegundoValor = vln_SegundoValor;
    }

    public ClsMultiplicacionRusa() {
        vln_PrimerValor = 0;
        vln_SegundoValor = 0;
    }

    //Propiedades
    public int getVln_PrimerValor() {
        return vln_PrimerValor;
    }

    public void setVln_PrimerValor(int vln_PrimerValor) {
        this.vln_PrimerValor = vln_PrimerValor;
    }

    public int getVln_SegundoValor() {
        return vln_SegundoValor;
    }

    public void setVln_SegundoValor(int vln_SegundoValor) {
        this.vln_SegundoValor = vln_SegundoValor;
    }
}
