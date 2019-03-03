/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Configuracion.Conexion;
import Entidades.ClsPeliculas;
import Entidades.ClsRetorno;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

/**
 *
 * @author Thomas Chevez
 */
public class ADPeliculas {

    //Atributos
    private Connection vgo_Connection;

    //Metodos
    public ADPeliculas() {
        //Se instancia la conexion
        Conexion vlo_ClsConexion = new Conexion();
        try {
            //Se guarda en una variable global la conexion
            vgo_Connection = vlo_ClsConexion.ClsConexionBD();
        } catch (Exception e) {
            throw e;
        }
    }

    public ClsRetorno GuardarPelicula(ClsPeliculas pvo_Pelicula) throws Exception {
        //Variables
        ClsRetorno vlo_Retorno = new ClsRetorno();
        CallableStatement vlo_CS;

        //Inicio
        try {
            vlo_CS = vgo_Connection.prepareCall("{call SP_GUARDAR_PELICULAS(?,?,?,?,?)}");
            vlo_CS.setInt(1, pvo_Pelicula.getVgn_idPelicula());
            vlo_CS.setString(2, pvo_Pelicula.getVgc_titulo());
            vlo_CS.setDate(3, pvo_Pelicula.getVgd_fecha());
            vlo_CS.setInt(4, pvo_Pelicula.getVgn_duracion());
            vlo_CS.setString(5, vlo_Retorno.getVgc_Mensaje());
            vlo_CS.registerOutParameter(1, Types.INTEGER);
            vlo_CS.registerOutParameter(5, Types.VARCHAR);
            vlo_CS.executeUpdate();
            vlo_Retorno.setVgc_Mensaje(vlo_CS.getString(5));
            vlo_Retorno.setVgn_id(vlo_CS.getInt(1));
        } catch (Exception e) {
            throw e;
        } finally {
            vgo_Connection = null;
        }
        return vlo_Retorno;
    }

    public ClsRetorno EliminarPelicula(int pvn_idPelicula) {
        //Variables
        ClsRetorno vlo_Retorno = new ClsRetorno();
        CallableStatement vlo_CS;
        
        //Inicio
    }
}
