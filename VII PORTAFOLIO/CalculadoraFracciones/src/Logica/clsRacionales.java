/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Entidades.ClsFracciones;

/**
 *
 * @author Programacion
 */
public class clsRacionales {

    //Variables Globales
    private ClsFracciones vgn_PrimerFraccion = new ClsFracciones();
    private ClsFracciones vgn_SegundaFraccion = new ClsFracciones();
    private ClsFracciones vgn_ResultadoFracciones;

    //Inicio
    public void SumaFracciones() {
        //Variables
        int vln_NumeradorRes, vln_DenominadorRes;

        //Inicio
        //Se guarda el denominador y el denominador.
        vln_DenominadorRes = vgn_PrimerFraccion.getVgn_Denominador() * vgn_SegundaFraccion.getVgn_Denominador();
        vln_NumeradorRes = ((vln_DenominadorRes / vgn_PrimerFraccion.getVgn_Denominador() * vgn_PrimerFraccion.getVgn_Numerador()) + (vln_DenominadorRes / vgn_SegundaFraccion.getVgn_Denominador() * vgn_SegundaFraccion.getVgn_Numerador()));

        vgn_ResultadoFracciones = new ClsFracciones(vln_NumeradorRes, vln_DenominadorRes);
    }

    public void MultiplicarFracciones() {
        //Variables
        int vln_NumeradorRes, vln_DenominadorRes;

        //Inicio
        vln_NumeradorRes = vgn_PrimerFraccion.getVgn_Numerador() * vgn_SegundaFraccion.getVgn_Numerador();
        vln_DenominadorRes = vgn_PrimerFraccion.getVgn_Denominador() * vgn_SegundaFraccion.getVgn_Denominador();

        vgn_ResultadoFracciones = new ClsFracciones(vln_NumeradorRes, vln_DenominadorRes);
    }

    public String PuntoFlotante(double pvn_Numerador, double pvn_Denominador) {
        //Variables
        double vln_resultado = 0;
        String vlc_Resultado = "";

        //Inicio
        vln_resultado = pvn_Numerador / pvn_Denominador;
        vlc_Resultado = Double.toString(vln_resultado);

        return vlc_Resultado;
    }

    public String FraccionLinea(int pvn_Numerador, int pvn_Denominador) {
        //Variables
        String vlc_Fraccion = "";

        //Inicio
        vlc_Fraccion = Integer.toString(pvn_Numerador) + "/" + Integer.toString(pvn_Denominador);

        return vlc_Fraccion;
    }

    //Propiedades
    public ClsFracciones getVgn_ResultadoFracciones() {
        return vgn_ResultadoFracciones;
    }

    public void setVgn_PrimerFraccion(ClsFracciones vgn_PrimerFraccion) {
        this.vgn_PrimerFraccion = vgn_PrimerFraccion;
    }

    public void setVgn_SegundaFraccion(ClsFracciones vgn_SegundaFraccion) {
        this.vgn_SegundaFraccion = vgn_SegundaFraccion;
    }
}
