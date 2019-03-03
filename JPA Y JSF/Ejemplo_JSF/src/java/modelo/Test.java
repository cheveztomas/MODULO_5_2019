/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author Thomas Chevez
 */
@Named(value = "test")
@ApplicationScoped
public class Test {

    //Atributos
    private String vgc_pwd, vgc_user;

    public Test() {
    }
    
    //Propiedades

    public String getVgc_pwd() {
        return vgc_pwd;
    }

    public void setVgc_pwd(String vgc_pwd) {
        this.vgc_pwd = vgc_pwd;
    }

    public String getVgc_user() {
        return vgc_user;
    }

    public void setVgc_user(String vgc_user) {
        this.vgc_user = vgc_user;
    }
    
}
