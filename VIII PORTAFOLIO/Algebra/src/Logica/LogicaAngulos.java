/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Entidades.ClsEntidadesTrigonometricas;

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
        } finally {
            //Se retorna el valor resultante.
            return vln_Radianes;
        }
    }

    public double RadianesAGrados(double pvn_Radianes) {
        //Variables
        double vln_Grados = 0;

        try {
            //Operaciones
            vln_Grados = Math.toDegrees(pvn_Radianes * Math.PI);
        } catch (ArithmeticException ae) {
            vln_Grados = -1;
            throw ae;
        } catch (Exception e) {
            vln_Grados = -1;
            throw e;
        } finally {
            //Se retorna el valor resultante.
            return vln_Grados;
        }

    }

    public ClsEntidadesTrigonometricas CalcularSCT(double pvn_Angulo) {
        //Varaibles
        ClsEntidadesTrigonometricas vlo_Resultado = new ClsEntidadesTrigonometricas();

        //Inicio
        try {
            vlo_Resultado.setVgn_Coseno(Math.cos(pvn_Angulo));
            vlo_Resultado.setVgn_Seno(Math.sin(pvn_Angulo));
            vlo_Resultado.setVgn_Tangente(Math.tan(pvn_Angulo));
        } catch (Exception e) {
            throw e;
        }
        return vlo_Resultado;
    }
}
