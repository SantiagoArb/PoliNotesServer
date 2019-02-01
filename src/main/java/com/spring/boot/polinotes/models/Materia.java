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
public class Materia {
    int ID_MATERIA;
    String CODIGO_MATERIA;
    String NOMBRE_MATERIA;
    int FACULTAD_MATERIA;

    public Materia() {
    }

    public Materia(int ID_MATERIA, String CODIGO_MATERIA, String NOMBRE_MATERIA, int FACULTAD_MATERIA) {
        this.ID_MATERIA = ID_MATERIA;
        this.CODIGO_MATERIA = CODIGO_MATERIA;
        this.NOMBRE_MATERIA = NOMBRE_MATERIA;
        this.FACULTAD_MATERIA = FACULTAD_MATERIA;
    }

    public int getID_MATERIA() {
        return ID_MATERIA;
    }

    public void setID_MATERIA(int ID_MATERIA) {
        this.ID_MATERIA = ID_MATERIA;
    }

    public String getCODIGO_MATERIA() {
        return CODIGO_MATERIA;
    }

    public void setCODIGO_MATERIA(String CODIGO_MATERIA) {
        this.CODIGO_MATERIA = CODIGO_MATERIA;
    }

    public String getNOMBRE_MATERIA() {
        return NOMBRE_MATERIA;
    }

    public void setNOMBRE_MATERIA(String NOMBRE_MATERIA) {
        this.NOMBRE_MATERIA = NOMBRE_MATERIA;
    }

    public int getFACULTAD_MATERIA() {
        return FACULTAD_MATERIA;
    }

    public void setFACULTAD_MATERIA(int FACULTAD_MATERIA) {
        this.FACULTAD_MATERIA = FACULTAD_MATERIA;
    }
    
}
