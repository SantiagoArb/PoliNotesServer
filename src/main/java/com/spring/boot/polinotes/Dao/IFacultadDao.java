/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.boot.polinotes.Dao;

import java.util.List;
import com.spring.boot.polinotes.models.Facultad;

/**
 *
 * @author clan-
 */
public interface IFacultadDao {
    
    public boolean setFacultad(Facultad fac);
    
    public List<Facultad> getFacultad();
    
    public boolean updateFacultad(Facultad fac);
    
    public boolean deleteFacultad(Facultad fac);
    
    //Procedimientos Almacenados
    public boolean P_ValidFacultad(String tipo, Facultad fac);
}
