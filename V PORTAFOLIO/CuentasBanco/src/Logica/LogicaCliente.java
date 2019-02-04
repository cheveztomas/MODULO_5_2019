/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Entidades.ClsClientes;

/**
 *
 * @author Programacion
 */
public class LogicaCliente {

    public double CalcularInteresCuentaCorriente(double pvc_Saldo) {
        //Varaibles
        double vln_Interes = 0;
        //Constantes
        double Interes = 0.02;

        //inicio
        //Se calcula el interes
        vln_Interes = pvc_Saldo * Interes;
        return vln_Interes;
    }

    public double CalcularinteresCuentaAhorros(double pvc_Saldo) {
        //Varaibles
        double vln_Interes = 0;
        //Constantes
        double Interes = 0.01;

        //inicio
        //Se calcula el interes
        vln_Interes = pvc_Saldo * Interes;
        return vln_Interes;
    }

    public double RetiroCuenta(double pvn_Saldo, double pvn_MontoRetiro) {
        //Variables
        double vln_respuesta = 0;
        //Inicio
        if (pvn_MontoRetiro > pvn_Saldo) {
            vln_respuesta = -1;
        } else {
            vln_respuesta = pvn_Saldo - pvn_MontoRetiro;
        }
        return vln_respuesta;
    }

    public double DepositoCuenta(double pvn_Saldo, double pvn_MontoDeposito) {
        //variables
        double vln_SaldoActualizado = 0;

        //inicio
        //Se suma al saldo de la cuenta.
        vln_SaldoActualizado = pvn_MontoDeposito + pvn_Saldo;

        return vln_SaldoActualizado;
    }

    public double RetencionMontos(double pvn_saldo) {
        //Varaibles
        double vln_Retencion = 0;

        //Constantes
        double Retencion = 0.05;

        //Inicio
        //Se establece el 5 porciento de retención.
        vln_Retencion = pvn_saldo * Retencion;

        return vln_Retencion;
    }
}
