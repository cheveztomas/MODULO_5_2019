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
public class ClsMonitor {

    //Argumentos
    private int vgn_idMonitor, vgn_contadorMonitor;
    private String vgc_marca;
    private double vgn_tamanio;

    //Constructor
    public void ClsMonitor() {
        setVgn_idMonitor(0);
        setVgn_contadorMonitor(0);
        setVgc_marca("");
        setVgn_tamanio(0);
    }

    public void ClsMonitor(int pvn_idMonitor, int pvn_contadorMonitor, String pvc_marca, double pvn_tamanio) {
        setVgc_marca(pvc_marca);
        setVgn_contadorMonitor(pvn_contadorMonitor);
        setVgn_idMonitor(pvn_idMonitor);
        setVgn_tamanio(pvn_tamanio);
    }

    //*********************************************************
    //Metodos
    @Override
    public String toString() {
        //Variables
        String vlc_String = "";

        //Incio
        vlc_String = vgc_marca + ", " + vgn_contadorMonitor + ", " + vgn_idMonitor + ", " + vgn_tamanio;

        return vlc_String;
    }

    //*********************************************************
    //Propiedades
    //*********************************************************
    /**
     * @return the vgn_idMonitor
     */
    public int getVgn_idMonitor() {
        return vgn_idMonitor;
    }

    /**
     * @param vgn_idMonitor the vgn_idMonitor to set
     */
    public void setVgn_idMonitor(int vgn_idMonitor) {
        this.vgn_idMonitor = vgn_idMonitor;
    }

    /**
     * @return the vgn_contadorMonitor
     */
    public int getVgn_contadorMonitor() {
        return vgn_contadorMonitor;
    }

    /**
     * @param vgn_contadorMonitor the vgn_contadorMonitor to set
     */
    public void setVgn_contadorMonitor(int vgn_contadorMonitor) {
        this.vgn_contadorMonitor = vgn_contadorMonitor;
    }

    /**
     * @return the vgc_marca
     */
    public String getVgc_marca() {
        return vgc_marca;
    }

    /**
     * @param vgc_marca the vgc_marca to set
     */
    public void setVgc_marca(String vgc_marca) {
        this.vgc_marca = vgc_marca;
    }

    /**
     * @return the vgn_tamanio
     */
    public double getVgn_tamanio() {
        return vgn_tamanio;
    }

    /**
     * @param vgn_tamanio the vgn_tamanio to set
     */
    public void setVgn_tamanio(double vgn_tamanio) {
        this.vgn_tamanio = vgn_tamanio;
    }
}
