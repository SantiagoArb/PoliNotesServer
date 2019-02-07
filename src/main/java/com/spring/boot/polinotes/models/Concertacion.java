/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.boot.polinotes.models;

/**
 *
 * @author Home
 */
public class Concertacion {
    private int id_concertacion;
    private String nom_concertacion;
    private double valor_porcentual;
    private String doc_maestro;
    private int id_materia;
    private int id_usuario;

    public Concertacion(int id_concertacion, String nom_concertacion, double valor_porcentual, String doc_maestro, int id_materia) {
        this.id_concertacion = id_concertacion;
        this.nom_concertacion = nom_concertacion;
        this.valor_porcentual = valor_porcentual;
        this.doc_maestro = doc_maestro;
        this.id_materia = id_materia;
    }

    public Concertacion() {
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
    
    
    
}
