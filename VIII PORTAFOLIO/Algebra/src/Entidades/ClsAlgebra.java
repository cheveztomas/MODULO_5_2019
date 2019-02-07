/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author tomas
 */
public class ClsAlgebra {

    //Atributos
    private int vgn_PrimerValor;
    //Atributos
    private int vgn_SegundoValor;

    //Constructor
    public ClsAlgebra() {
        vgn_PrimerValor = 0;
        vgn_SegundoValor = 0;
    }

    public ClsAlgebra(int pvn_PrimerValor, int pvn_SegundoValor) {
        vgn_PrimerValor = pvn_PrimerValor;
        vgn_SegundoValor = pvn_SegundoValor;
    }
    
    //Propiedades

    public int getVgn_PrimerValor() {
        return vgn_PrimerValor;
    }

    public void setVgn_PrimerValor(int vgn_PrimerValor) {
        this.vgn_PrimerValor = vgn_PrimerValor;
    }

    public int getVgn_SegundoValor() {
        return vgn_SegundoValor;
    }

    public void setVgn_SegundoValor(int vgn_SegundoValor) {
        this.vgn_SegundoValor = vgn_SegundoValor;
    }
    
}
