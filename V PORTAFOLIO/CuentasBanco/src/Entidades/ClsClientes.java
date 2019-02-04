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
public class ClsClientes {

    //Varaibles
    private String vgc_Nombre, vgc_TipoCuenta;
    private double vgn_NumeroCuenta, vgn_Saldo;

    //Constructor
    public void ClsClientes() {
        setVgc_Nombre("");
        setVgc_TipoCuenta("");
        setVgn_NumeroCuenta(0);
        setVgn_Saldo(0);
    }

    public void ClsClientes(String pvc_Nombre, String pvc_TipoCuenta, double pvn_NumeroCuenta, double pvn_Saldo) {
        vgc_Nombre = pvc_Nombre;
        vgc_TipoCuenta = pvc_TipoCuenta;
        vgn_NumeroCuenta = pvn_NumeroCuenta;
        vgn_Saldo = pvn_Saldo;
    }
    
    //Propiedades
    /**
     * @return the vgc_Nombre
     */
    public String getVgc_Nombre() {
        return vgc_Nombre;
    }

    /**
     * @param vgc_Nombre the vgc_Nombre to set
     */
    public void setVgc_Nombre(String vgc_Nombre) {
        this.vgc_Nombre = vgc_Nombre;
    }

    /**
     * @return the vgc_TipoCuenta
     */
    public String getVgc_TipoCuenta() {
        return vgc_TipoCuenta;
    }

    /**
     * @param vgc_TipoCuenta the vgc_TipoCuenta to set
     */
    public void setVgc_TipoCuenta(String vgc_TipoCuenta) {
        this.vgc_TipoCuenta = vgc_TipoCuenta;
    }

    /**
     * @return the vgn_NumeroCuenta
     */
    public double getVgn_NumeroCuenta() {
        return vgn_NumeroCuenta;
    }

    /**
     * @param vgn_NumeroCuenta the vgn_NumeroCuenta to set
     */
    public void setVgn_NumeroCuenta(double vgn_NumeroCuenta) {
        this.vgn_NumeroCuenta = vgn_NumeroCuenta;
    }

    /**
     * @return the vgn_Saldo
     */
    public double getVgn_Saldo() {
        return vgn_Saldo;
    }

    /**
     * @param vgn_Saldo the vgn_Saldo to set
     */
    public void setVgn_Saldo(double vgn_Saldo) {
        this.vgn_Saldo = vgn_Saldo;
    }
}
