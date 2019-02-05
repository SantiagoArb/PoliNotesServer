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
 * @author Home
 */
public interface IFacadeFacultad {
    
   
    
    public boolean setFacultad(Facultad fac);
    
    public List<Facultad> getFacultad();
    
    public boolean updateFacultad(Facultad fac);
    
    public boolean deleteFacultad(Facultad fac);
    
    //**********************************PROCEDIMIENTOS ALMACENADOS**************************************
    
    public boolean P_ValidFacultad(String tipo, Facultad fac);
    
}
