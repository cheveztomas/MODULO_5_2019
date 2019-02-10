/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Entidades.ClsMaquinaAlimentos;

/**
 *
 * @author Thomas
 */
public class LogicaMaquinaAlimentos {

    public int Pagar(ClsMaquinaAlimentos pvo_Transaccion) {
        //Variables
        ClsMaquinaAlimentos vlo_Maquina = new ClsMaquinaAlimentos();
        int vln_Vuelto = 0;

        //Inicio
        try {
            //Se hace la resta del valor ingresado y el precio.
            vln_Vuelto = pvo_Transaccion.getVgn_Ingresado() - pvo_Transaccion.getVgn_Precio();
        } catch (ArithmeticException ae) {
        }

        //Retorno
        return vln_Vuelto;
    }
}
