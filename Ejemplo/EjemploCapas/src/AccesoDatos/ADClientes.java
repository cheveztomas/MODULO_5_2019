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
            //String url = "jdbc:sqlserver://tomaschevez.database.windows.net;databaseName=EJEMPLO;user=tomaschevez;password=and.eli0895";
            vgo_Conexion = DriverManager.getConnection(url);
        } catch (Exception e) {
            vgo_Conexion = null;
            throw e;
        }
    }

    public int Insertar(ClsEntidadCliente pvo_ClsEntidadCliente) {
        //Variables
        CallableStatement vlo_CS;
        int vln_Resultado = 0;

        try {
            vlo_CS = vgo_Conexion.prepareCall("{call SP_GUARDAR_CLIENTE(?,?,?,?,?)}");
            vlo_CS.setInt(1, pvo_ClsEntidadCliente.getVgn_idCliente());
            vlo_CS.setString(2, pvo_ClsEntidadCliente.getVgc_Nombre());
            vlo_CS.setString(3, pvo_ClsEntidadCliente.getVgc_Direccion());
            vlo_CS.setString(4, pvo_ClsEntidadCliente.getVgc_Telefono());
            vlo_CS.setString(5, vgc_Mensaje);
            //vlo_CS.registerOutParameter(5, Types.VARCHAR);

            
            
            vln_Resultado=vlo_CS.executeUpdate();
            //vgc_Mensaje = vlo_CS.getString(2);
        } catch (Exception e) {
            vln_Resultado = -1;
            throw e;
        } finally {
            vgo_Conexion = null;
            return vln_Resultado;
        }
    }

    public int eliminar(ClsEntidadCliente pvo_EntidadCliente) throws Exception {
        //Variables
        CallableStatement vlo_CS;
        int vln_Resultado = 0;

        try {
            vlo_CS = vgo_Conexion.prepareCall("{call SP_ELIMINAR_CLIENTES(?,?)}");
            vlo_CS.setInt(1, pvo_EntidadCliente.getVgn_idCliente());
            vlo_CS.setString(2, vgc_Mensaje);

            vlo_CS.registerOutParameter(2, Types.VARCHAR);
            vln_Resultado = vlo_CS.executeUpdate();

            vgc_Mensaje = vlo_CS.getString(2);
        } catch (Exception e) {
            vln_Resultado = -1;
            throw e;
        } finally {
            vgo_Conexion = null;
            return vln_Resultado;
        }
    }

    public ResultSet ListarRegistros(String pvc_Condicion, String pvn_Orden) throws SQLException {
        //Varibles
        ResultSet vlo_ResultSet = null;
        Statement vlo_CS = vgo_Conexion.createStatement();
        String vlc_Sentemcia;

        //Inicio
        vlc_Sentemcia = "SELECT ID_CLIENTE,NOMBRE,DIRECCION,TELEFONO FROM CLIENTES";

        if (!pvc_Condicion.equals("")) {
            vlc_Sentemcia = String.format("%s WHERE %s", vlc_Sentemcia, pvc_Condicion);
        }

        if (!pvn_Orden.equals("")) {
            vlc_Sentemcia = String.format("%s order by %s", vlc_Sentemcia, pvc_Condicion);
        }

        try {
            vlo_ResultSet = vlo_CS.executeQuery(vlc_Sentemcia);
        } catch (Exception e) {
            throw e;
        } finally {
            vgo_Conexion = null;
            return vlo_ResultSet;
        }
    }

    public ClsEntidadCliente ObtenerRegistro(String pvc_Condicion) throws SQLException {
        ResultSet vlo_ResultSet;
        Statement vlo_CS = vgo_Conexion.createStatement();
        ClsEntidadCliente vlo_Cliente = new ClsEntidadCliente();
        String vlc_Sentencia;

        vlc_Sentencia = "SELECT ID_CLIENTE, NOMBRE, DIRECCION, TELEFONO FROM CLIENTES";

        if (!pvc_Condicion.equals("")) {
            vlc_Sentencia = String.format("%s where %s", vlc_Sentencia, pvc_Condicion);
        }

        try {
            vlo_ResultSet = vlo_CS.executeQuery(vlc_Sentencia);

            if (vlo_ResultSet.next()) {
                vlo_Cliente.setVgn_idCliente(vlo_ResultSet.getInt(1));
                vlo_Cliente.setVgc_Nombre(vlo_ResultSet.getString(2));
                vlo_Cliente.setVgc_Direccion(vlo_ResultSet.getString(3));
                vlo_Cliente.setVgc_Telefono(vlo_ResultSet.getString(4));
                vlo_Cliente.setVgb_ExisteRegistro(true);
            } else {
                vlo_Cliente.setVgb_ExisteRegistro(false);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            vgo_Conexion = null;
            return vlo_Cliente;
        }
    }

    //Propiedades
    public String getVgc_Mensaje() {
        return vgc_Mensaje;
    }

}
