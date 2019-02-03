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
public class ClsOrden {

    //Atributos
    private int vgn_idOrden, vgn_contadorOrdenes, vgn_contadorComputadoras, vgn_maxComputadoras;
    private ClsComputadora vgo_Computadora;

    //Constructores
    public ClsOrden() {
        vgn_contadorComputadoras = 0;
        vgn_contadorOrdenes = 0;
        vgn_idOrden = 0;
        vgn_maxComputadoras = 0;
        vgo_Computadora = new ClsComputadora();
    }

    public ClsOrden(int pvn_idOrden, int pvn_contadorOrdenes, int pvn_contadorComputadoras, int pvn_maxComputadoras, ClsComputadora pvo_Computadora) {
        vgn_contadorComputadoras = pvn_contadorComputadoras;
        vgn_contadorOrdenes = pvn_contadorOrdenes;
        vgn_idOrden = pvn_idOrden;
        vgn_maxComputadoras = pvn_maxComputadoras;
        vgo_Computadora = pvo_Computadora;
    }

    /**
     * @return the vgn_idOrden
     */
    public int getVgn_idOrden() {
        return vgn_idOrden;
    }

    /**
     * @param vgn_idOrden the vgn_idOrden to set
     */
    public void setVgn_idOrden(int vgn_idOrden) {
        this.vgn_idOrden = vgn_idOrden;
    }

    /**
     * @return the vgn_contadorOrdenes
     */
    public int getVgn_contadorOrdenes() {
        return vgn_contadorOrdenes;
    }

    /**
     * @param vgn_contadorOrdenes the vgn_contadorOrdenes to set
     */
    public void setVgn_contadorOrdenes(int vgn_contadorOrdenes) {
        this.vgn_contadorOrdenes = vgn_contadorOrdenes;
    }

    /**
     * @return the vgn_contadorComputadoras
     */
    public int getVgn_contadorComputadoras() {
        return vgn_contadorComputadoras;
    }

    /**
     * @param vgn_contadorComputadoras the vgn_contadorComputadoras to set
     */
    public void setVgn_contadorComputadoras(int vgn_contadorComputadoras) {
        this.vgn_contadorComputadoras = vgn_contadorComputadoras;
    }

    /**
     * @return the vgn_maxComputadoras
     */
    public int getVgn_maxComputadoras() {
        return vgn_maxComputadoras;
    }

    /**
     * @param vgn_maxComputadoras the vgn_maxComputadoras to set
     */
    public void setVgn_maxComputadoras(int vgn_maxComputadoras) {
        this.vgn_maxComputadoras = vgn_maxComputadoras;
    }

    /**
     * @return the vgo_Computadora
     */
    public ClsComputadora getVgo_Computadora() {
        return vgo_Computadora;
    }

    /**
     * @param vgo_Computadora the vgo_Computadora to set
     */
    public void setVgo_Computadora(ClsComputadora vgo_Computadora) {
        this.vgo_Computadora = vgo_Computadora;
    }
    
}
