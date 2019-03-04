/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Configuracion.Conexion;
import Entidades.ClsPeliculasDirectores;
import Entidades.ClsRetorno;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;

/**
 *
 * @author Thomas Chevez
 */
public class ADPeliculasDirectores {

    //Atributos
    private Connection vgo_Connection;

    //Metodos
    public ADPeliculasDirectores() {
        //Se instancia la conexion
        Conexion vlo_ClsConexion = new Conexion();
        try {
            //Se guarda en una variable global la conexion
            vgo_Connection = vlo_ClsConexion.ClsConexionBD();
        } catch (Exception e) {
            throw e;
        }
    }

    public ClsRetorno AsiganarDirector(ClsPeliculasDirectores pvo_PeliculasDirectores) throws Exception {
        //Variables
        CallableStatement vlo_CS;
        ClsRetorno vlo_Retorno = new ClsRetorno();

        //Inicio
        try {
            vlo_CS = vgo_Connection.prepareCall("{call SP_ASIGNAR_DIRECTOR_PELICULA(?,?,?)}");
            vlo_CS.setInt(1, pvo_PeliculasDirectores.getVgn_idPelicula());
            vlo_CS.setInt(2, pvo_PeliculasDirectores.getVgn_idDirector());
            vlo_CS.setString(3, vlo_Retorno.getVgc_Mensaje());
            vlo_CS.registerOutParameter(3, Types.VARCHAR);
            vlo_Retorno.setVgn_id(vlo_CS.executeUpdate());
            vlo_Retorno.setVgc_Mensaje(vlo_CS.getNString(3));
        } catch (Exception e) {
            throw e;
        } finally {
            vgo_Connection = null;
        }
        return vlo_Retorno;
    }

    public ClsRetorno EliminarDirectorPelicula(ClsPeliculasDirectores pvo_PeliculasDirectores) throws Exception {
        //Variables
        ClsRetorno vlo_Retorno = new ClsRetorno();
        CallableStatement vlo_CS;

        //Inicio
        try {
            vlo_CS = vgo_Connection.prepareCall("{call SP_ELIMINAR_ASIGNACION_DE_PELICULA(?,?,?)}");
            vlo_CS.setInt(1, pvo_PeliculasDirectores.getVgn_idPelicula());
            vlo_CS.setInt(2, pvo_PeliculasDirectores.getVgn_idDirector());
            vlo_CS.setString(3, vlo_Retorno.getVgc_Mensaje());
            vlo_CS.registerOutParameter(3, Types.VARCHAR);
            vlo_Retorno.setVgn_id(vlo_CS.executeUpdate());
            vlo_Retorno.setVgc_Mensaje(vlo_CS.getString(3));
        } catch (Exception e) {
            throw e;
        } finally {
            vgo_Connection = null;
        }
        return vlo_Retorno;
    }

    public ResultSet ListaDirectoresPelicula(int pvn_idPelicula) throws Exception {
        //Variables
        String vlc_Sentencia = "SELECT DIRECTORES.ID_DIRECTOR,NOMBRE FROM PELICULAS INNER JOIN PELICULAS_DIRECTORES ON PELICULAS.ID_PELICULA=PELICULAS_DIRECTORES.ID_PELICULA INNER JOIN DIRECTORES ON PELICULAS_DIRECTORES.ID_DIRECTOR=DIRECTORES.ID_DIRECTOR WHERE PELICULAS.ID_PELICULA='" + pvn_idPelicula + "'";
        ResultSet vlo_RS;
        Statement vlo_Statement;

        //Inicio
        try {
            vlo_Statement = vgo_Connection.createStatement();
            vlo_RS = vlo_Statement.executeQuery(vlc_Sentencia);
        } catch (Exception e) {
            throw e;
        } finally {
            vgo_Connection = null;
        }
        return vlo_RS;
    }
    
}
