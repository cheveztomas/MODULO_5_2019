/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Entidades.ClsMaquinaAlimentos;
import Entidades.ClsMonedas;

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

    public ClsMonedas Cantidad_Monedas(int pvn_Vuelto) {
        //Variables
        ClsMonedas vlo_Monedas = new ClsMonedas();
        int vln_Restante;

        //Inicio
        vln_Restante = pvn_Vuelto;
        while (vln_Restante > 0) {

            //Se realiza cada operaciópn hasta llegar a 0
            if (vln_Restante >= 100) {
                //Se le resta a la cantidad de dinero al valor inicial.
                vln_Restante = vln_Restante - 100;
                vlo_Monedas.setVgn_Monedas100(vlo_Monedas.getVgn_Monedas100() + 1);
            } else if (vln_Restante >= 50) {
                vln_Restante = vln_Restante - 50;
                vlo_Monedas.setVgn_Monedas50(vlo_Monedas.getVgn_Monedas50() + 1);
            } else if (vln_Restante >= 10) {
                vln_Restante = vln_Restante - 10;
                vlo_Monedas.setVgn_Monedas10(vlo_Monedas.getVgn_Monedas10() + 1);
            }
        }
        return vlo_Monedas;
    }
}
