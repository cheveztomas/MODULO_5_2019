/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Configuracion;

import java.sql.*;

/**
 *
 * @author tomas
 */
public class ClsConexion {

    public Connection ConexionBD() throws Exception {
        //Atributos
        Connection vlo_Conexion;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost;databaseName=Ejemplo;user=sa;password=sa";
            vlo_Conexion = DriverManager.getConnection(url);
        } catch (Exception e) {
            vlo_Conexion = null;
            throw e;
        }
        return vlo_Conexion;
    }
}
