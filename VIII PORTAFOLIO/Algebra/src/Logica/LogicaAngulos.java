/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Entidades.ClsAngulos;

/**
 *
 * @author Thomas
 */
public class LogicaAngulos {

    public double GradosARadianes(double pvn_Grados) {
        //Variables
        double vln_Radianes = 0;

        try {
            //Operación
            vln_Radianes = Math.toRadians(pvn_Grados) / Math.PI;
        } catch (ArithmeticException ae) {
            vln_Radianes = -1;
            throw ae;
        } catch (Exception e) {
            vln_Radianes = -1;
            throw e;
        }

        //Se retorna el valor resultante.
        return vln_Radianes;
    }
;
}
