/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.boot.polinotes.models;

/**
 *
 * @author scardonas
 */
public class Tipo_Perfil {
    int ID_TIPO_PERFIL;
    String NOMBRE_TIPO_PERFIL;

    public Tipo_Perfil() {
    }

    public Tipo_Perfil(int ID_TIPO_PERFIL, String NOMBRE_TIPO_PERFIL) {
        this.ID_TIPO_PERFIL = ID_TIPO_PERFIL;
        this.NOMBRE_TIPO_PERFIL = NOMBRE_TIPO_PERFIL;
    }

    public int getID_TIPO_PERFIL() {
        return ID_TIPO_PERFIL;
    }

    public void setID_TIPO_PERFIL(int ID_TIPO_PERFIL) {
        this.ID_TIPO_PERFIL = ID_TIPO_PERFIL;
    }

    public String getNOMBRE_TIPO_PERFIL() {
        return NOMBRE_TIPO_PERFIL;
    }

    public void setNOMBRE_TIPO_PERFIL(String NOMBRE_TIPO_PERFIL) {
        this.NOMBRE_TIPO_PERFIL = NOMBRE_TIPO_PERFIL;
    }
    
}
