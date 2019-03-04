/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import AccesoDatos.ADPeliculasDirectores;
import Entidades.ClsPeliculasDirectores;
import Entidades.ClsRetorno;

/**
 *
 * @author Thomas Chevez
 */
public class LogicaPeliculasDirectores {

    public ClsRetorno AsignarDirector(ClsPeliculasDirectores pvo_PeliculasDirectores) throws Exception {
        //Variables
        ClsRetorno vlo_Retorno;
        ADPeliculasDirectores vlo_PeliculasDirectores;

        //Inicio
        try {
            vlo_PeliculasDirectores = new ADPeliculasDirectores();
            vlo_Retorno = vlo_PeliculasDirectores.AsiganarDirector(pvo_PeliculasDirectores);
        } catch (Exception e) {
            throw e;
        }
        return vlo_Retorno;
    }

    public ClsRetorno EliminarDirectorPelicula(ClsPeliculasDirectores pvo_PeliculasDirectores) throws Exception {
        //Varaibles
        ClsRetorno vlo_Retorno;
        ADPeliculasDirectores vlo_ADPeliculasDirectores;

        //Inicio
        try {
            vlo_ADPeliculasDirectores = new ADPeliculasDirectores();
            vlo_Retorno = vlo_ADPeliculasDirectores.EliminarDirectorPelicula(pvo_PeliculasDirectores);

        } catch (Exception e) {
            throw e;
        }
        return vlo_Retorno;
    }
}
