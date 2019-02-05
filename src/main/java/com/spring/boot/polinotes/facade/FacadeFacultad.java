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
public class FacadeFacultad implements IFacadeFacultad{
    private final IFacultadDao dao;

    public FacadeFacultad() {
        this.dao = new DAO_Facultad();
    }
    
    @Override
    public boolean setFacultad(Facultad fac) {
        boolean result = this.dao.setFacultad(fac);
        return result; 
    }
    @Override
    public List<Facultad> getFacultad() {
        return this.dao.getFacultad(); 
    }
    @Override
    public boolean updateFacultad(Facultad fac){
        boolean result = this.dao.updateFacultad(fac);
        return result; 
    }
    @Override
    public boolean deleteFacultad(Facultad fac) {
        boolean result = this.dao.deleteFacultad(fac);
        return result; 
    }
    
    //**********************************PROCEDIMIENTOS ALMACENADOS**************************************
    @Override
    public boolean P_ValidFacultad(String tipo, Facultad fac) {
        boolean result = this.dao.P_ValidFacultad(tipo, fac);
        return result; 
    }
    
}
