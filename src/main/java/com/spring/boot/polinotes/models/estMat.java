/*
p
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.boot.polinotes.models;

/**
 *
 * @author Home
 */
public class estMat {
    private int id_materia;
    private String doc_estudiante;
    private String nom_estudiante;
    private int id_usuario;
    private double nota;
    private int id_con;
    private int id_nota;   
     private String CODIGO_MATERIA;
     private String NOMBRE_MATERIA;
     private int FACULTAD_MATERIA;
     private int ID_MAESTRO;
     private String nombre_conertacion;
     private double porcentaje;
    private double definitiva;
    private String comentario;

    public estMat(int id_materia, String doc_estudiante, String nom_estudiante, int id) {
        this.id_materia = id_materia;
        this.doc_estudiante = doc_estudiante;
        this.nom_estudiante = nom_estudiante;
        this.id_usuario = id;
    }

    public estMat() {
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public double getDefinitiva() {
        return definitiva;
    }

    public void setDefinitiva(double definitiva) {
        this.definitiva = definitiva;
    }

    public String getNombre_conertacion() {
        return nombre_conertacion;
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public void setNombre_conertacion(String nombre_conertacion) {
        this.nombre_conertacion = nombre_conertacion;
    }

    public double getNota() {
        return nota;
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

    public int getID_MAESTRO() {
        return ID_MAESTRO;
    }

    public void setID_MAESTRO(int ID_MAESTRO) {
        this.ID_MAESTRO = ID_MAESTRO;
    }

   

    public void setNota(double nota) {
        this.nota = nota;
    }

    public int getId_con() {
        return id_con;
    }

    public void setId_con(int id_con) {
        this.id_con = id_con;
    }

    public int getId_nota() {
        return id_nota;
    }

    public void setId_nota(int id_nota) {
        this.id_nota = id_nota;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_materia() {
        return id_materia;
    }

    public void setId_materia(int id_materia) {
        this.id_materia = id_materia;
    }

    public String getDoc_estudiante() {
        return doc_estudiante;
    }

    public void setDoc_estudiante(String doc_estudiante) {
        this.doc_estudiante = doc_estudiante;
    }

    public String getNom_estudiante() {
        return nom_estudiante;
    }

    public void setNom_estudiante(String nom_estudiante) {
        this.nom_estudiante = nom_estudiante;
    }
    
    
}
