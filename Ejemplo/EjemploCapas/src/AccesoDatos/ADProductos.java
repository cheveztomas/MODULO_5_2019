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
import java.sql.Types;

/**
 *
 * @author tomas
 */
public class ADProductos {

    public ClsEntidadRetorno GuardarProducto(ClsEntidaProducto pvo_Producto) {
        //Variables
        ClsEntidadRetorno vlo_Retorno = new ClsEntidadRetorno();
        CallableStatement vlo_CS;
        ClsConexion vlo_Conexion;

        //Inicio
        try {
            vlo_Conexion = new ClsConexion();
            vlo_CS = vlo_Conexion.ConexionBD().prepareCall("{call SP_GUARDAR_PRODUCTO(?,?,?,?)}");
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
        }
        finally{
            return vlo_Retorno;
        }
    }
}
