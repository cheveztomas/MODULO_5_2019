/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author Thomas Chevez
 */
public class ClsPeliculasDirectores {

    //Atributos
    private int vgn_idPelicula, vgn_idDirector;

    //Constructores
    public ClsPeliculasDirectores(int vgn_idPelicula, int vgn_idDirector) {
        this.vgn_idPelicula = vgn_idPelicula;
        this.vgn_idDirector = vgn_idDirector;
    }

    public ClsPeliculasDirectores() {
        vgn_idDirector = 0;
        vgn_idPelicula = 0;
    }
    
    //Propiedades
    public int getVgn_idPelicula() {
        return vgn_idPelicula;
    }

    public void setVgn_idPelicula(int vgn_idPelicula) {
        this.vgn_idPelicula = vgn_idPelicula;
    }

    public int getVgn_idDirector() {
        return vgn_idDirector;
    }

    public void setVgn_idDirector(int vgn_idDirector) {
        this.vgn_idDirector = vgn_idDirector;
    }
    
}
