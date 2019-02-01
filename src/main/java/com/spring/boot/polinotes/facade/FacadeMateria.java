/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.boot.polinotes.facade;

import com.spring.boot.polinotes.Dao.DAO_Materia;
import com.spring.boot.polinotes.Dao.IMateriaDao;

/**
 *
 * @author Home
 */
public class FacadeMateria implements IFacadeMateria{
    public final IMateriaDao dao;

    public FacadeMateria() {
        this.dao = new DAO_Materia();
    }
    
    
    
    
    
}
