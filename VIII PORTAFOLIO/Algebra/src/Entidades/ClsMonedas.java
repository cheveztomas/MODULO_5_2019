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
public class ClsMonedas {

    //Atributos
    int vgn_Monedas10, vgn_Monedas50, vgn_Monedas100;

    //Cosntructor
    public ClsMonedas(int vgn_Monedas10, int vgn_Monedas50, int vgn_Monedas100) {
        this.vgn_Monedas10 = vgn_Monedas10;
        this.vgn_Monedas50 = vgn_Monedas50;
        this.vgn_Monedas100 = vgn_Monedas100;
    }

    public ClsMonedas() {
        vgn_Monedas10 = 0;
        vgn_Monedas100 = 0;
        vgn_Monedas50 = 0;
    }

    //Propiedades
    public int getVgn_Monedas10() {
        return vgn_Monedas10;
    }

    public void setVgn_Monedas10(int vgn_Monedas10) {
        this.vgn_Monedas10 = vgn_Monedas10;
    }

    public int getVgn_Monedas50() {
        return vgn_Monedas50;
    }

    public void setVgn_Monedas50(int vgn_Monedas50) {
        this.vgn_Monedas50 = vgn_Monedas50;
    }

    public int getVgn_Monedas100() {
        return vgn_Monedas100;
    }

    public void setVgn_Monedas100(int vgn_Monedas100) {
        this.vgn_Monedas100 = vgn_Monedas100;
    }

}
