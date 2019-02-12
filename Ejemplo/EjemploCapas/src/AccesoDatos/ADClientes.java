/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import java.sql.*;
import Entidades.*;

/**
 *
 * @author tomas
 */
public class ADClientes {

    //Atributos
    private Connection vgo_Conexion;
    private String vgc_Mensaje = "";

    //Constructor
    public ADClientes() throws Exception {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost;databaseName=Ejemplo;user=sa;password=sa";
        } catch (Exception e) {
            throw e;
        }
    }

    //Propiedades
    public String getVgc_Mensaje() {
        return vgc_Mensaje;
    }

}
