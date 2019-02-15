/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Entidades.ClsEntidaProducto;
import Entidades.ClsEntidadRetorno;
import java.sql.CallableStatement;
import Configuracion.ClsConexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;

/**
 *
 * @author tomas
 */
public class ADProductos {

    public ClsEntidadRetorno GuardarProducto(ClsEntidaProducto pvo_Producto) {
        //Variables
        ClsEntidadRetorno vlo_Retorno = new ClsEntidadRetorno();
        //Se instancia CS.
        CallableStatement vlo_CS;
        ClsConexion vlo_Conexion;
        Connection vlo_Connec;

        //Inicio
        try {
            vlo_Conexion = new ClsConexion();
            vlo_Connec = vlo_Conexion.ConexionBD();
            vlo_CS = vlo_Connec.prepareCall("{call SP_GUARDAR_PRODUCTO(?,?,?,?)}");
            vlo_CS.setInt(1, pvo_Producto.getVgn_idPorducto());
            vlo_CS.setString(2, pvo_Producto.getVgc_Descripcion());
            vlo_CS.setDouble(3, pvo_Producto.getVgn_Precio());
            vlo_CS.setString(4, vlo_Retorno.getVgc_Mensaje());
            vlo_CS.registerOutParameter(4, Types.VARCHAR);

            vlo_Retorno.setVgn_Resultado(vlo_CS.executeUpdate());

            vlo_Retorno.setVgc_Mensaje(vlo_CS.getString(4));
        } catch (Exception e) {
            vlo_Retorno.setVgc_Mensaje("Error al realizar la conexión.");
            vlo_Retorno.setVgn_Resultado(-1);
            throw e;
        } finally {
            vlo_Connec = null;
            return vlo_Retorno;
        }
    }

    public ClsEntidadRetorno EliminarProductos(int pvn_idProducto) {
        //Variables
        ClsEntidadRetorno vlo_Retorno = new ClsEntidadRetorno();
        CallableStatement vlo_CS;
        ClsConexion vlo_conexion;
        Connection vlo_Connec;

        try {
            //Se instancia la conexión.
            vlo_conexion = new ClsConexion();

            //Se establese la conexión y se invoca el metodo.
            vlo_Connec = vlo_conexion.ConexionBD();
            vlo_CS = vlo_Connec.prepareCall("{call SP_ELIMINAR_PRODUCTO(?,?)}");

            //Se establecem los paarmetros.
            vlo_CS.setInt(1, pvn_idProducto);
            vlo_CS.setString(2, vlo_Retorno.getVgc_Mensaje());

            //Se ejecuta la sentencia
            vlo_CS.registerOutParameter(2, Types.VARCHAR);

            vlo_Retorno.setVgn_Resultado(vlo_CS.executeUpdate());
            vlo_Retorno.setVgc_Mensaje(vlo_CS.getString(2));
        } catch (Exception e) {
            vlo_Retorno.setVgn_Resultado(-1);
            vlo_Retorno.setVgc_Mensaje("Error al eliminar producto. (Acceso a datos.)");
            throw e;
        } finally {
            vlo_Connec = null;
            return vlo_Retorno;
        }
    }

    public ResultSet ListaProductos(String pvc_Condicion) {
        //Varaibles
        ResultSet vlo_RS = null;
        ClsEntidaProducto vlo_Producto;
        ClsConexion vlo_ObtenerConec;
        Connection vlo_Conexion;
        Statement vlo_CS;
        String vlc_Sentencia = "";

        //Inicio
        vlc_Sentencia = "SELECT ID_PRODUCTO, DESCRIPCION, PRECIO FROM PRODUCTOS WHERE DESCRIPCION LIKE '%" + pvc_Condicion + "%'";
        try {
            vlo_Producto = new ClsEntidaProducto();
            vlo_ObtenerConec = new ClsConexion();
            vlo_Conexion = vlo_ObtenerConec.ConexionBD();
            vlo_CS = vlo_Conexion.createStatement();

            vlo_RS = vlo_CS.executeQuery(vlc_Sentencia);
        } catch (Exception e) {
            throw e;
        } finally {
            vlo_Conexion = null;
            return vlo_RS;
        }
    }
}
