/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.boot.polinotes.facade;

import com.spring.boot.polinotes.models.Materia;
import com.spring.boot.polinotes.models.Usuario;
import com.spring.boot.polinotes.models.estMat;
import java.util.List;

/**
 *
 * @author Home
 */
public interface IFacadeMateria {
    
     public boolean setMateria(Materia ma);
    
    public List<Materia> getMateria(int idx);
    
    public boolean updateMateria(Materia ma);
    
    public boolean deleteMateria(Materia ma);
    
    public boolean setEstudianteMateria(estMat obj);
    
    public List<estMat> getEstudianteMateria(int idx);
    
    public boolean deleteEstudianteMateria(String idx, String doc);
    
}
