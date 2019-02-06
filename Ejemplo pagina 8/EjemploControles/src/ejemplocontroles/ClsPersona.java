/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplocontroles;

/**
 *
 * @author tomas
 */
public class ClsPersona {

    private int id;
    private String Nombre;

    public ClsPersona(int pvn_id, String pvc_Nombre) {
        id = pvn_id;
        Nombre = pvc_Nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return Nombre;
    }

    @Override
    public String toString() {
        return Nombre;
    }
}
