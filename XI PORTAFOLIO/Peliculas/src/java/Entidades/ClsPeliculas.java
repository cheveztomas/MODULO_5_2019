/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.sql.Date;

/**
 *
 * @author Thomas Chevez
 */
public class ClsPeliculas {

    //Atributos
    private int vgn_idPelicula, vgn_duracion;
    private String vgc_titulo;
    private java.sql.Date vgd_fecha;

    //Constructores
    public ClsPeliculas(int vgn_idPelicula, int vgn_duracion, String vgc_titulo, Date vgd_fecha) {
        this.vgn_idPelicula = vgn_idPelicula;
        this.vgn_duracion = vgn_duracion;
        this.vgc_titulo = vgc_titulo;
        this.vgd_fecha = vgd_fecha;
    }

    public ClsPeliculas() {
        vgc_titulo = "";
        vgn_duracion = 0;
        vgn_idPelicula = 0;
    }
    
    //Propiedades

    public int getVgn_idPelicula() {
        return vgn_idPelicula;
    }

    public void setVgn_idPelicula(int vgn_idPelicula) {
        this.vgn_idPelicula = vgn_idPelicula;
    }

    public int getVgn_duracion() {
        return vgn_duracion;
    }

    public void setVgn_duracion(int vgn_duracion) {
        this.vgn_duracion = vgn_duracion;
    }

    public String getVgc_titulo() {
        return vgc_titulo;
    }

    public void setVgc_titulo(String vgc_titulo) {
        this.vgc_titulo = vgc_titulo;
    }

    public Date getVgd_fecha() {
        return vgd_fecha;
    }

    public void setVgd_fecha(Date vgd_fecha) {
        this.vgd_fecha = vgd_fecha;
    }
    
}
