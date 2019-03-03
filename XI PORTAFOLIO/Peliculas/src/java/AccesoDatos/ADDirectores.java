/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Configuracion.Conexion;
import Entidades.ClsDirectores;
import Entidades.ClsRetorno;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

/**
 *
 * @author Thomas Chevez
 */
public class ADDirectores {

    //Atributos
    private Connection vgo_Connection;

    //Metodos
    public ADDirectores() {
        //Se instancia la conexion
        Conexion vlo_ClsConexion = new Conexion();
        try {
            //Se guarda en una variable global la conexion
            vgo_Connection = vlo_ClsConexion.ClsConexionBD();
        } catch (Exception e) {
            throw e;
        }
    }

    public ClsRetorno GuardarDirector(ClsDirectores pvo_Director) throws Exception {
        //Variables
        ClsRetorno vlo_Retorno = new ClsRetorno();
        CallableStatement vlo_CS;

        //Inicio
        try {
            vlo_CS = vgo_Connection.prepareCall("{call SP_GUARDAR_DIRECTORES(?,?,?)}");
            vlo_CS.setInt(1, pvo_Director.getVgc_idDirector());
            vlo_CS.setString(2, pvo_Director.getVgc_Nombre());
            vlo_CS.setString(3, vlo_Retorno.getVgc_Mensaje());
            vlo_CS.registerOutParameter(1, Types.INTEGER);
            vlo_CS.registerOutParameter(3, Types.VARCHAR);
            vlo_CS.executeUpdate();
            vlo_Retorno.setVgc_Mensaje(vlo_CS.getString(3));
            vlo_Retorno.setVgn_id(vlo_CS.getInt(1));
        } catch (Exception e) {
            throw e;
        } finally {
            vgo_Connection = null;
        }
        return vlo_Retorno;
    }

    public ClsRetorno EliminarDirector(int pvn_idDirector) throws Exception {
        //Varaibles
        ClsRetorno vlo_Retorno = new ClsRetorno();
        CallableStatement vlo_CS;

        //Inicio
        try {
            vlo_CS = vgo_Connection.prepareCall("{call SP_ELIMINAR_DIRECTOR(?,?)}");
            vlo_CS.setInt(1, pvn_idDirector);
            vlo_CS.setString(2, vlo_Retorno.getVgc_Mensaje());
            vlo_CS.registerOutParameter(3, Types.VARCHAR);
            vlo_Retorno.setVgn_id(vlo_CS.executeUpdate());
            vlo_Retorno.setVgc_Mensaje(vlo_CS.getString(2));
        } catch (Exception e) {
            throw e;
        } finally {
            vgo_Connection = null;
        }
        return vlo_Retorno;
    }
}
