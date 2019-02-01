/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.boot.polinotes.Dao;

import java.util.List;
import com.spring.boot.polinotes.models.Materia;

/**
 *
 * @author scardonas
 */
public interface IMateriaDao {
    
    public boolean setMateria(Materia ma);
    
    public List<Object> getMateria();
    
    public boolean updateMateria(Materia ma);
    
    public boolean deleteMateria(Materia ma);
}
