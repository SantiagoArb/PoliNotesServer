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
public class estMat extends Materia {
    private int id_materia;
    private String doc_estudiante;
    private String nom_estudiante;
    private int id_usuario;

    public estMat(int id_materia, String doc_estudiante, String nom_estudiante, int id) {
        this.id_materia = id_materia;
        this.doc_estudiante = doc_estudiante;
        this.nom_estudiante = nom_estudiante;
        this.id_usuario = id;
    }

    public estMat() {
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
