/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.boot.polinotes.Dao;

import com.spring.boot.polinotes.models.Concertacion;
import java.util.List;
import com.spring.boot.polinotes.models.Materia;
import com.spring.boot.polinotes.models.Usuario;
import com.spring.boot.polinotes.models.estMat;

/**
 *
 * @author scardonas
 */
public interface IMateriaDao {
    
    public boolean setMateria(Materia ma);
    
    public List<Materia> getMateria(int idx);
    
    public boolean updateMateria(Materia ma);
    
    public boolean deleteMateria(Materia ma);
    
    public boolean setEstudianteMateria(estMat obj);
    
    public List<estMat> getEstudianteMateria(int idx);
    public boolean deleteEstudianteMateria(String idx, String doc);
    public List<estMat> getMisMaterias(Usuario us);
    public void callLigarUserEstudiante();
    public boolean setConcertacion(Concertacion con);
    public List<Materia> getConcertacionMateria(int idx);
}
