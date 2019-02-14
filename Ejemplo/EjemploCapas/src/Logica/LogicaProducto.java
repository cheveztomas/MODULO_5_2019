/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import AccesoDatos.ADProductos;
import Entidades.ClsEntidaProducto;
import Entidades.ClsEntidadRetorno;

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
}
