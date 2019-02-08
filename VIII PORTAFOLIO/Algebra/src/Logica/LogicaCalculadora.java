/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Entidades.ClsAlgebra;

/**
 *
 * @author tomas
 */
public class LogicaCalculadora {

    public double Suma(ClsAlgebra pvo_Valores) {
        //Variables
        double vln_Resultado = 0;

        try {
            //Inicio
            //Se realiza la suma de los valores.
            vln_Resultado = pvo_Valores.getVgn_PrimerValor() + pvo_Valores.getVgn_SegundoValor();

            //Se retornan los valores.
            return vln_Resultado;
        } catch (ArithmeticException ae) {
            throw ae;
        }
    }

    public double Resta(ClsAlgebra pvo_Valores) {
        //Variables
        double vln_Resultado = 0;

        try {
            //Inicio
            //Se realiza la suma de los valores.
            vln_Resultado = pvo_Valores.getVgn_PrimerValor() - pvo_Valores.getVgn_SegundoValor();

            //Se retornan los valores.
            return vln_Resultado;
        } catch (ArithmeticException ae) {
            throw ae;
        }

    }

    public double Multiplicar(ClsAlgebra pvo_Valores) {
        //Variables
        double vln_Reultado = 0;

        try {
            //Inicio
            //Se calcula la multiplicasión delos valores.
            vln_Reultado = pvo_Valores.getVgn_PrimerValor() * pvo_Valores.getVgn_SegundoValor();

            //Se retorna el valor.
            return vln_Reultado;
        } catch (ArithmeticException ae) {
            throw ae;
        }

    }

    public double Dividir(ClsAlgebra pvo_Valores) {
        //Variables
        double vln_Reultado = 0;

        try {
            //Inicio
            //Se calcula la multiplicasión delos valores.
            vln_Reultado = pvo_Valores.getVgn_PrimerValor() / pvo_Valores.getVgn_SegundoValor();

            //Se retorna el valor.
            return vln_Reultado;
        } catch (ArithmeticException ae) {
            throw ae;
        }

    }

    public double Potencia(ClsAlgebra pvo_Valores) {
        //Variables
        double vln_Resultado = 0;

        try {
            //Inicio
            //Se calcula la potencia.
            vln_Resultado = Math.pow(pvo_Valores.getVgn_PrimerValor(), pvo_Valores.getVgn_SegundoValor());

            //Se retorna el resultado.
            return vln_Resultado;
        } catch (ArithmeticException ae) {
            throw ae;
        }

    }
}
