/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.boot.polinotes.facade;

import com.spring.boot.polinotes.Dao.DAO_Materia;
import com.spring.boot.polinotes.Dao.IMateriaDao;
import com.spring.boot.polinotes.models.Concertacion;
import com.spring.boot.polinotes.models.Materia;
import com.spring.boot.polinotes.models.Usuario;
import com.spring.boot.polinotes.models.estMat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Home
 */
public class FacadeMateria implements IFacadeMateria{
    public final IMateriaDao dao;

    public FacadeMateria() {
        this.dao = new DAO_Materia();
    }

    @Override
    public boolean setMateria(Materia ma) {
        return this.dao.setMateria(ma);
    }

    @Override
    public List<Materia> getMateria(int idx) {
        return this.dao.getMateria(idx);
                }

    @Override
    public boolean updateMateria(Materia ma) {
        return this.dao.updateMateria(ma);
    }

    @Override
    public boolean deleteMateria(Materia ma) {
    return this.dao.deleteMateria(ma);
    }
    @Override
    public boolean setEstudianteMateria(estMat obj){
        return this.dao.setEstudianteMateria(obj);
    }
    
    @Override
    public List<estMat> getEstudianteMateria(int idx, int id_con){
        return this.dao.getEstudianteMateria(idx,id_con);
    }
    
    @Override
    public boolean deleteEstudianteMateria(String idx, String doc){
        return this.dao.deleteEstudianteMateria(idx, doc);
    }
    @Override
    public List<estMat> getMisMaterias(Usuario us){
        return this.dao.getMisMaterias(us);
    }
    
    @Override
    public boolean setConcertacion(Concertacion con) {
        return this.dao.setConcertacion(con);
    }
    
    
    @Override
    public List<Materia> getConcertacionMateria(int idx) {
        return this.dao.getConcertacionMateria(idx);
    }
    
    @Override
     public boolean callSetNota(estMat nota){
         return this.dao.callSetNota(nota);
     }
    
    @Override
    public List<estMat> getMisNotas(estMat datos){
        return this.dao.getMisNotas(datos);
    }
    
    @Override
    public int getValorConcertado(int idx){
        return this.dao.getValorConcertado(idx);
    }
    
    @Override
    public boolean updateConcertacion(Concertacion concert){
        return this.dao.updateConcertacion(concert);
    }
    @Override
    public boolean SaveAllCalifications(List<estMat> notas){
        return this.dao.SaveAllCalifications(notas);
    }
    @Override
    public boolean deleteConcertacion(estMat concertacion){
        return this.dao.deleteConcertacion(concertacion);
    }
}
