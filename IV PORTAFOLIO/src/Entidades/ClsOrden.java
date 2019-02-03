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
    
    //Metodos
    
}
