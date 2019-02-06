/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author Programacion
 */
public class ClsFracciones {

    //Atributos
    private int vgn_Numerador;
    private int vgn_Denominador;

    //Constructores
    public ClsFracciones() {
        vgn_Denominador = 0;
        vgn_Numerador = 0;
    }

    public ClsFracciones(int pvn_Numerador, int pvn_Denominador) {
        //Variables
        int vln_NumeradorSim = 0, vln_DenominadorSim = 0, vln_Menor = 0, i = 0;
        boolean vlb_EsMenor = false;

        //Inicio
        //Se verifica cual es el valor menor
        if (pvn_Denominador > pvn_Numerador) {
            vlb_EsMenor = true;
        }

        //Se guarda el número menor en una variable.
        if (vlb_EsMenor == true) {
            vln_Menor = pvn_Numerador;
        } else {
            vln_Menor = pvn_Denominador;
        }

        //Se establece los valores iniciales.
        vln_DenominadorSim = pvn_Denominador;
        vln_NumeradorSim = pvn_Numerador;

        //Se hace un ciclo el cual itera la cantidad de veces del menor de los dos números
        i = 2;
        while (i <= vln_Menor) {

            //Se verifica si ambos números se pueden simplificar.
            if (pvn_Denominador % i == 0 && pvn_Numerador % i == 0) {
                vln_NumeradorSim = vln_NumeradorSim / i;
                vln_DenominadorSim = vln_DenominadorSim / i;
                if (vln_NumeradorSim == 0) {
                    vln_NumeradorSim = 1;
                    i++;
                }
                if (vln_DenominadorSim == 0) {
                    vln_DenominadorSim = 1;
                    i++;
                }
            } else {
                i++;
            }
        }

        vgn_Numerador = vln_NumeradorSim;
        vgn_Denominador = vln_DenominadorSim;
    }

    //Propiedades
    //***********************************
    /**
     * @return the vgn_Numerador
     */
    public int getVgn_Numerador() {
        return vgn_Numerador;
    }

    /**
     * @param vgn_Numerador the vgn_Numerador to set
     */
    public void setVgn_Numerador(int vgn_Numerador) {
        this.vgn_Numerador = vgn_Numerador;
    }

    /**
     * @return the vgn_Denominador
     */
    public int getVgn_Denominador() {
        return vgn_Denominador;
    }

    /**
     * @param vgn_Denominador the vgn_Denominador to set
     */
    public void setVgn_Denominador(int vgn_Denominador) {
        this.vgn_Denominador = vgn_Denominador;
    }

}
