/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.boot.polinotes.facade;

import com.spring.boot.polinotes.Dao.DAO_Facultad;
import com.spring.boot.polinotes.Dao.IFacultadDao;
import com.spring.boot.polinotes.models.Facultad;
import java.util.List;

/**
 *
 * @author clan-
 */
public class FacadeFacultad {
    private final IFacultadDao dao;

    public FacadeFacultad() {
        this.dao = new DAO_Facultad();
    }
    
    public boolean setFacultad(Facultad fac) {
        boolean result = this.dao.setFacultad(fac);
        return result; 
    }
    
    public List<Object> getFacultad() {
        List<Object> listaFacultad = this.dao.getFacultad();
        return listaFacultad; 
    }
    
    public boolean updateFacultad(Facultad fac){
        boolean result = this.dao.updateFacultad(fac);
        return result; 
    }
    
    public boolean deleteFacultad(Facultad fac) {
        boolean result = this.dao.deleteFacultad(fac);
        return result; 
    }
    
    //**********************************PROCEDIMIENTOS ALMACENADOS**************************************
    
    public boolean P_ValidFacultad(String tipo, Facultad fac) {
        boolean result = this.dao.P_ValidFacultad(tipo, fac);
        return result; 
    }
    
}
