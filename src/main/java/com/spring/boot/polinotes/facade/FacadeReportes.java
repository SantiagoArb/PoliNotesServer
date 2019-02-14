/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.boot.polinotes.facade;

import com.spring.boot.polinotes.Dao.DAO_Reportes;
import com.spring.boot.polinotes.Dao.IReportesDao;
import com.spring.boot.polinotes.models.reportePorConcertacion;
import java.util.List;

/**
 *
 * @author Home
 */
public class FacadeReportes implements IFacadeReportes{
    public final IReportesDao dao;

    public FacadeReportes() {
        this.dao = new DAO_Reportes();
    }
    
    @Override
    public List<reportePorConcertacion> reportePorConcertacion(int idx) {
        return this.dao.reportePorConcertacion(idx);
                }
    
    
    
}
