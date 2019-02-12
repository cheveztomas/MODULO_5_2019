/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author tomas
 */
public class ClsEntidadCliente {

    //Atributos
    private int vgn_idCliente;
    private String vgc_Nombre, vgc_Direccion, vgc_Telefono;
    private boolean vgb_ExisteRegistro;

    //Constructores
    public ClsEntidadCliente(int vgn_idCliente, String vgc_Nombre, String vgc_Direccion, String vgc_Telefono, boolean vgb_ExisteRegistro) {
        this.vgn_idCliente = vgn_idCliente;
        this.vgc_Nombre = vgc_Nombre;
        this.vgc_Direccion = vgc_Direccion;
        this.vgc_Telefono = vgc_Telefono;
        this.vgb_ExisteRegistro = vgb_ExisteRegistro;
    }

    public ClsEntidadCliente() {
        vgb_ExisteRegistro = false;
        vgc_Direccion = "";
        vgc_Nombre = "";
        vgc_Telefono = "";
        vgn_idCliente = 0;
    }

    public ClsEntidadCliente(int pvn_idCliente, String pvc_Nombre) {
        vgn_idCliente = pvn_idCliente;
        vgc_Nombre = pvc_Nombre;
    }

    public String toString() {
        //Varaibles
        String vln_Cadena;
        //Inicio
        vln_Cadena = vgc_Nombre;

        return vln_Cadena;
    }
    //Propiedades

    public int getVgn_idCliente() {
        return vgn_idCliente;
    }

    public void setVgn_idCliente(int vgn_idCliente) {
        this.vgn_idCliente = vgn_idCliente;
    }

    public String getVgc_Nombre() {
        return vgc_Nombre;
    }

    public void setVgc_Nombre(String vgc_Nombre) {
        this.vgc_Nombre = vgc_Nombre;
    }

    public String getVgc_Direccion() {
        return vgc_Direccion;
    }

    public void setVgc_Direccion(String vgc_Direccion) {
        this.vgc_Direccion = vgc_Direccion;
    }

    public String getVgc_Telefono() {
        return vgc_Telefono;
    }

    public void setVgc_Telefono(String vgc_Telefono) {
        this.vgc_Telefono = vgc_Telefono;
    }

    public boolean isVgb_ExisteRegistro() {
        return vgb_ExisteRegistro;
    }

    public void setVgb_ExisteRegistro(boolean vgb_ExisteRegistro) {
        this.vgb_ExisteRegistro = vgb_ExisteRegistro;
    }

}
