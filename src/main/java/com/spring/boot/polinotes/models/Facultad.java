/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.boot.polinotes.models;

/**
 *
 * @author clan-
 */
public class Facultad {
    int ID_FACULTAD;
    String CODIGO_FACULTAD;
    String NOMBRE_FACULTAD;
    String DECANO_FACULTAD;
    
    

    public Facultad() {
    }

    public Facultad(int ID_FACULTAD, String CODIGO_FACULTAD, String NOMBRE_FACULTAD, String DECANO_FACULTAD) {
        this.ID_FACULTAD = ID_FACULTAD;
        this.CODIGO_FACULTAD = CODIGO_FACULTAD;
        this.NOMBRE_FACULTAD = NOMBRE_FACULTAD;
        this.DECANO_FACULTAD = DECANO_FACULTAD;
    }

    public String getDECANO_FACULTAD() {
        return DECANO_FACULTAD;
    }

    public void setDECANO_FACULTAD(String DECANO_FACULTAD) {
        this.DECANO_FACULTAD = DECANO_FACULTAD;
    }
    
    public int getID_FACULTAD() {
        return ID_FACULTAD;
    }

    public void setID_FACULTAD(int ID_FACULTAD) {
        this.ID_FACULTAD = ID_FACULTAD;
    }

    public String getCODIGO_FACULTAD() {
        return CODIGO_FACULTAD;
    }

    public void setCODIGO_FACULTAD(String CODIGO_FACULTAD) {
        this.CODIGO_FACULTAD = CODIGO_FACULTAD;
    }

    public String getNOMBRE_FACULTAD() {
        return NOMBRE_FACULTAD;
    }

    public void setNOMBRE_FACULTAD(String NOMBRE_FACULTAD) {
        this.NOMBRE_FACULTAD = NOMBRE_FACULTAD;
    }


    
    
}
