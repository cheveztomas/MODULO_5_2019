/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import AccesoDatos.ADProductos;
import Entidades.ClsEntidaProducto;
import Entidades.ClsEntidadRetorno;
import java.sql.ResultSet;

/**
 *
 * @author tomas
 */
public class LogicaProducto {

    public ClsEntidadRetorno GuardarProducto(ClsEntidaProducto pvo_producto) {
        //Variables
        ClsEntidadRetorno vlo_Retorno = new ClsEntidadRetorno();
        ADProductos vlo_ADProductos;

        //Inicio
        try {
            vlo_ADProductos = new ADProductos();
            vlo_Retorno = vlo_ADProductos.GuardarProducto(pvo_producto);
        } catch (Exception e) {
            if (vlo_Retorno.getVgn_Resultado() == 0) {
                vlo_Retorno.setVgc_Mensaje("Error al insertar producto.");
                vlo_Retorno.setVgn_Resultado(-1);
            }
            throw e;
        } finally {
            return vlo_Retorno;
        }
    }

    public ClsEntidadRetorno EliminarProducto(int pvn_idProducto) {
        //Variables
        ClsEntidadRetorno vlo_Retorno = new ClsEntidadRetorno();
        ADProductos vlo_AccesoProductos = new ADProductos();

        //Inicio
        try {
            vlo_Retorno = vlo_AccesoProductos.EliminarProductos(pvn_idProducto);
        } catch (Exception e) {
            throw e;
        } finally {
            return vlo_Retorno;
        }
    }

    public ResultSet ListaProductos(String pvc_Condicion) {
        //Varaibles
        ResultSet vlo_ResultSet = null;
        ADProductos vlo_ADProductos;
        try {
            vlo_ADProductos = new ADProductos();
            vlo_ResultSet = vlo_ADProductos.ListaProductos(pvc_Condicion);
        } catch (Exception e) {
            throw e;
        } finally {
            return vlo_ResultSet;
        }
    }

    public ClsEntidaProducto ObtnerProducto(int pvn_idProducto) {
        //Variables
        ClsEntidaProducto vlo_Producto = new ClsEntidaProducto();
        ADProductos vlo_ADProductos;

        //Inicio
        try {
            vlo_ADProductos = new ADProductos();
            vlo_Producto = vlo_ADProductos.ObtnerProducto(pvn_idProducto);
        } catch (Exception e) {
            throw e;
        } finally {
            return vlo_Producto;
        }
    }
}
