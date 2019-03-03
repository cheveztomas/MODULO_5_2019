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
import java.sql.ResultSet;
import java.sql.Statement;
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
    
    public ClsRetorno EliminarPelicula(int pvn_idPelicula) throws Exception {
        //Variables
        ClsRetorno vlo_Retorno = new ClsRetorno();
        CallableStatement vlo_CS;

        //Inicio
        try {
            vlo_CS = vgo_Connection.prepareCall("{call SP_ELIMINAR_PELICULA(?,?)}");
            vlo_CS.setInt(1, pvn_idPelicula);
            vlo_CS.setString(2, vlo_Retorno.getVgc_Mensaje());
            vlo_CS.registerOutParameter(2, Types.VARCHAR);
            vlo_Retorno.setVgn_id(vlo_CS.executeUpdate());
            vlo_Retorno.setVgc_Mensaje(vlo_CS.getString(2));
        } catch (Exception e) {
            throw e;
        } finally {
            vgo_Connection = null;
        }
        return vlo_Retorno;
    }
    
    public ClsPeliculas RetornarPelicula(int pvn_idPleicula) throws Exception {
        //Variables
        ClsPeliculas vlo_Pelicula = new ClsPeliculas();
        Statement vlo_Statement;
        ResultSet vlo_RS;
        String vlc_Sentencia = "SELECT ID_PELICULA,TITULO,FECHA_ESTRENO,DURACION FROM PELICULAS WHERE ID_PELICULA='" + pvn_idPleicula + "'";

        //Inicio
        try {
            vlo_Statement = vgo_Connection.createStatement();
            vlo_RS = vlo_Statement.executeQuery(vlc_Sentencia);
            if (vlo_RS.next()) {
                vlo_Pelicula.setVgn_idPelicula(vlo_RS.getInt(1));
                vlo_Pelicula.setVgc_titulo(vlo_RS.getString(2));
                vlo_Pelicula.setVgd_fecha(vlo_RS.getDate(3));
                vlo_Pelicula.setVgn_duracion(vlo_RS.getInt(4));
            }
        } catch (Exception e) {
            throw e;
        }
        return vlo_Pelicula;
    }
    
    public ResultSet ListaPeliculas(String pvc_Condicion){
        
    }
}
