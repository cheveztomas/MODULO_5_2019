/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Configuracion;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Thomas Chevez
 */
public class Conexion {

    public Connection ClsConexionBD() {
        //Variables
        Connection vlo_Connection = null;

        //Inicio
        try {
            //Se establese el nombre de la clase de driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            //Se guarda la cadena de conexion
            String url = "jdbc:sqlserver://localhost;databaseName=REGISTRO_PELICULAS;user=practica;password=practica1";
            vlo_Connection = DriverManager.getConnection(url);
        } catch (Exception e) {
            vlo_Connection = null;
        } finally {
            return vlo_Connection;
        }
    }
}
