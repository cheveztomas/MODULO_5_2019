/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import AccesoDatos.ADPeliculas;
import Entidades.ClsPeliculas;
import Entidades.ClsRetorno;
import java.sql.ResultSet;

/**
 *
 * @author Thomas Chevez
 */
public class LogicaPeliculas {

    public ClsRetorno GuardarPelicula(ClsPeliculas pvo_Pelicula) throws Exception {
        //Variables
        ClsRetorno vlo_Retorno;
        ADPeliculas vlo_ADPeliculas;

        //Inicio
        try {
            vlo_ADPeliculas = new ADPeliculas();
            vlo_Retorno = vlo_ADPeliculas.GuardarPelicula(pvo_Pelicula);
        } catch (Exception e) {
            throw e;
        }
        return vlo_Retorno;
    }

    public ClsRetorno EliminarPelicula(int pvn_idPelicula) throws Exception {
        //Variables
        ClsRetorno vlo_Retorno;
        ADPeliculas vlo_Pelicula;

        //Inicio
        try {
            vlo_Pelicula = new ADPeliculas();
            vlo_Retorno = vlo_Pelicula.EliminarPelicula(pvn_idPelicula);
        } catch (Exception e) {
            throw e;
        }
        return vlo_Retorno;
    }

    public ClsPeliculas RetornarPelicula(int pvn_idPelicula) throws Exception {
        //Varaibles
        ClsPeliculas vlo_Pelicula;
        ADPeliculas vlo_ADPeliculas;

        //Inicio
        try {
            vlo_ADPeliculas = new ADPeliculas();
            vlo_Pelicula = vlo_ADPeliculas.RetornarPelicula(pvn_idPelicula);
        } catch (Exception e) {
            throw e;
        }
        return vlo_Pelicula;
    }

    public ResultSet ListaPeliculas(String pvc_Condicion) throws Exception {
        //Varaibles
        ResultSet vlo_RS;
        ADPeliculas vlo_ADPeliculas;

        //Inicio
        try {
            vlo_ADPeliculas = new ADPeliculas();
            vlo_RS = vlo_ADPeliculas.ListaPeliculas(pvc_Condicion);
        } catch (Exception e) {
            throw e;
        }
        return vlo_RS;
    }
}
