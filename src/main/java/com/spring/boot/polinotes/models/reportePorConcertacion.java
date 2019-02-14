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
public class reportePorConcertacion {
    private String nombre_Con;
    private int id_Con;
    private int id_mat;
    private double porcentaje;
    private int aprovaron;
    private int reprovaron;

    public reportePorConcertacion() {
    }

    public String getNombre_Con() {
        return nombre_Con;
    }

    public void setNombre_Con(String nombre_Con) {
        this.nombre_Con = nombre_Con;
    }

    public int getId_Con() {
        return id_Con;
    }

    public void setId_Con(int id_Con) {
        this.id_Con = id_Con;
    }

    public int getId_mat() {
        return id_mat;
    }

    public void setId_mat(int id_mat) {
        this.id_mat = id_mat;
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public int getAprovaron() {
        return aprovaron;
    }

    public void setAprovaron(int aprovaron) {
        this.aprovaron = aprovaron;
    }

    public int getReprovaron() {
        return reprovaron;
    }

    public void setReprovaron(int reprovaron) {
        this.reprovaron = reprovaron;
    }
    
    
    
}
