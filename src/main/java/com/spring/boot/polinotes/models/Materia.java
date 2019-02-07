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
    private int ID_MATERIA;
    private String CODIGO_MATERIA;
    private String NOMBRE_MATERIA;
    private int FACULTAD_MATERIA;
    private int ID_MAESTRO;
    
    private int id_concertacion;
    private String nom_concertacion;
    private double valor_porcentual;
    private String doc_maestro;
    private int id_materia;
    private int id_usuario;

   

    

    public Materia() {
    }

    public Materia(int ID_MATERIA, String CODIGO_MATERIA, String NOMBRE_MATERIA, int FACULTAD_MATERIA, int ID_MAESTRO) {
        this.ID_MATERIA = ID_MATERIA;
        this.CODIGO_MATERIA = CODIGO_MATERIA;
        this.NOMBRE_MATERIA = NOMBRE_MATERIA;
        this.FACULTAD_MATERIA = FACULTAD_MATERIA;
        this.ID_MAESTRO = ID_MAESTRO;
    }
    
    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_concertacion() {
        return id_concertacion;
    }

    public void setId_concertacion(int id_concertacion) {
        this.id_concertacion = id_concertacion;
    }

    public String getNom_concertacion() {
        return nom_concertacion;
    }

    public void setNom_concertacion(String nom_concertacion) {
        this.nom_concertacion = nom_concertacion;
    }

    public double getValor_porcentual() {
        return valor_porcentual;
    }

    public void setValor_porcentual(double valor_porcentual) {
        this.valor_porcentual = valor_porcentual;
    }

    public String getDoc_maestro() {
        return doc_maestro;
    }

    public void setDoc_maestro(String doc_maestro) {
        this.doc_maestro = doc_maestro;
    }

    public int getId_materia() {
        return id_materia;
    }

    public void setId_materia(int id_materia) {
        this.id_materia = id_materia;
    }

    public int getID_MAESTRO() {
        return ID_MAESTRO;
    }

    public void setID_MAESTRO(int ID_MAESTRO) {
        this.ID_MAESTRO = ID_MAESTRO;
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
