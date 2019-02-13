/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import AccesoDatos.ADClientes;
import Entidades.ClsEntidadCliente;

/**
 *
 * @author Thomas
 */
public class LogicaClientes {

    public LogicaClientes() {
    }

    public int InsertarCliente(ClsEntidadCliente pvo_EntidadCliente) {
        //Variables
        ADClientes vlo_AccesoDatos;
        int vln_Resultado = 0;

        //Inicio
        try {
            //Se instancia el acceso a datos.
            vlo_AccesoDatos = new ADClientes();

            //Se invoca el metodo.
            vln_Resultado = vlo_AccesoDatos.Insertar(pvo_EntidadCliente);
        } catch (Exception e) {
            vln_Resultado = -1;
            throw e;
        } finally {
            return vln_Resultado;
        }
    }

    public int EliminarCliente(ClsEntidadCliente pvo_EntidadCliente) {
        //Variables
        ADClientes vlo_ADClientes;
        int vln_Resultado = 0;

        try {
            //Se instancia el acceso a datos del cliente.
            vlo_ADClientes = new ADClientes();

            //Se invoca el metodo que elimina de la base de datos a un cliente.
            vln_Resultado = vlo_ADClientes.eliminar(pvo_EntidadCliente);
        } catch (Exception e) {
            vln_Resultado = -1;
            throw e;
        } finally {
            return vln_Resultado;
        }
    }
}
