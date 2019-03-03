/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Configuracion.Conexion;
import java.sql.Connection;

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
    
    
}
