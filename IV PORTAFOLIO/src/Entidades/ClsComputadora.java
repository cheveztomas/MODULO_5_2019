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
public class ClsComputadora {

    //Atributos
    private int vgn_idComputadora;
    private String vgc_nombre;
    private ClsMonitor vgo_Monitor;
    private ClsTeclado vgo_Teclado;
    private ClsRaton vgo_Raton;

    //Constructores
    public ClsComputadora() {
        vgc_nombre = "";
        vgn_idComputadora = 0;
        vgo_Monitor = new ClsMonitor();
        vgo_Raton = new ClsRaton();
        vgo_Teclado = new ClsTeclado();
    }

    public ClsComputadora(int pvn_idComputadora, String pvc_nombre, ClsMonitor pvo_Monitor, ClsRaton pvo_Raton, ClsTeclado pvo_Teclado) {
        vgc_nombre = pvc_nombre;
        vgn_idComputadora = pvn_idComputadora;
        vgo_Monitor = pvo_Monitor;
        vgo_Raton = pvo_Raton;
        vgo_Teclado = pvo_Teclado;
    }

    //Metodos
    @Override
    public String toString() {
        //Variables
        String vlc_Cadena;

        //Inicio
        vlc_Cadena = getVgc_nombre() + ", " + getVgn_idComputadora() + ", " + getVgo_Monitor() + ", " + getVgo_Raton() + ", " + getVgo_Teclado();

        return vlc_Cadena;
    }

    /**
     * @return the vgn_idComputadora
     */
    public int getVgn_idComputadora() {
        return vgn_idComputadora;
    }

    /**
     * @param vgn_idComputadora the vgn_idComputadora to set
     */
    public void setVgn_idComputadora(int vgn_idComputadora) {
        this.vgn_idComputadora = vgn_idComputadora;
    }

    /**
     * @return the vgc_nombre
     */
    public String getVgc_nombre() {
        return vgc_nombre;
    }

    /**
     * @param vgc_nombre the vgc_nombre to set
     */
    public void setVgc_nombre(String vgc_nombre) {
        this.vgc_nombre = vgc_nombre;
    }

    /**
     * @return the vgo_Monitor
     */
    public ClsMonitor getVgo_Monitor() {
        return vgo_Monitor;
    }

    /**
     * @param vgo_Monitor the vgo_Monitor to set
     */
    public void setVgo_Monitor(ClsMonitor vgo_Monitor) {
        this.vgo_Monitor = vgo_Monitor;
    }

    /**
     * @return the vgo_Teclado
     */
    public ClsTeclado getVgo_Teclado() {
        return vgo_Teclado;
    }

    /**
     * @param vgo_Teclado the vgo_Teclado to set
     */
    public void setVgo_Teclado(ClsTeclado vgo_Teclado) {
        this.vgo_Teclado = vgo_Teclado;
    }

    /**
     * @return the vgo_Raton
     */
    public ClsRaton getVgo_Raton() {
        return vgo_Raton;
    }

    /**
     * @param vgo_Raton the vgo_Raton to set
     */
    public void setVgo_Raton(ClsRaton vgo_Raton) {
        this.vgo_Raton = vgo_Raton;
    }
}
