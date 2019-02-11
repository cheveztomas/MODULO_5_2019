/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Entidades.ClsMultiplicacionRusa;

/**
 *
 * @author Thomas
 */
public class LogicaMultiplicacionRusa {

    public String Calcular(ClsMultiplicacionRusa pvo_Valores) {
        //variables
        int vln_Resultado = 0, vln_PrimerValor = pvo_Valores.getVln_PrimerValor(), vln_SegundoValor = pvo_Valores.getVln_SegundoValor();

        //Inicio
        try {
            while (vln_PrimerValor != 0) {
                if (vln_PrimerValor % 2 != 0) {
                    vln_Resultado = vln_Resultado + vln_SegundoValor;
                }
                vln_PrimerValor = vln_PrimerValor / 2;
                vln_SegundoValor = vln_SegundoValor * 2;
            }
            return pvo_Valores.getVln_PrimerValor() + " x " + pvo_Valores.getVln_SegundoValor() + " = " + vln_Resultado;
        } catch (Exception e) {
            return "n";
        }
    }
}
