/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import AccesoDatos.ADDirectores;
import Entidades.ClsDirectores;
import Entidades.ClsRetorno;
import java.sql.ResultSet;

/**
 *
 * @author Thomas Chevez
 */
public class LogicaDirectores {

    public ClsRetorno GuardarDirector(ClsDirectores pvo_Director) throws Exception {
        //Varaibles
        ClsRetorno vlo_Retorno;
        ADDirectores vlo_ADDirectores;

        //Inicio
        try {
            vlo_ADDirectores = new ADDirectores();
            vlo_Retorno = vlo_ADDirectores.GuardarDirector(pvo_Director);
        } catch (Exception e) {
            throw e;
        }
        return vlo_Retorno;
    }

    public ClsRetorno EliminarDirector(int pvn_idDirector) throws Exception {
        //Variables
        ClsRetorno vlo_Retorno;
        ADDirectores vlo_ADDirectores;

        //Inicio
        try {
            vlo_ADDirectores = new ADDirectores();
            vlo_Retorno = vlo_ADDirectores.EliminarDirector(pvn_idDirector);
        } catch (Exception e) {
            throw e;
        }
        return vlo_Retorno;
    }

    public ClsDirectores RetornarDirector(int pvn_idDirector) throws Exception {
        //Variables
        ClsDirectores vlo_Director;
        ADDirectores vlo_ADDirectores;

        //Inicio
        try {
            vlo_ADDirectores = new ADDirectores();
            vlo_Director = vlo_ADDirectores.RetornarDirector(pvn_idDirector);
        } catch (Exception e) {
            throw e;
        }
        return vlo_Director;
    }

    public ResultSet ListaDirectores(String pvc_Condicion) throws Exception {
        //Variables
        ResultSet vlo_RS;
        ADDirectores vlo_ADDirectores;

        //Inicio
        try {
            vlo_ADDirectores = new ADDirectores();
            vlo_RS = vlo_ADDirectores.ListaDirectores(pvc_Condicion);
        } catch (Exception e) {
            throw e;
        }
        return vlo_RS;
    }
}
