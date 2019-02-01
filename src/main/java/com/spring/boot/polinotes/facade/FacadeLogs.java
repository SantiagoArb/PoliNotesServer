/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.boot.polinotes.facade;

import com.spring.boot.polinotes.Dao.DAO_Logs;
import com.spring.boot.polinotes.Dao.ILogsDao;
import com.spring.boot.polinotes.models.Logs;
import java.util.List;

/**
 *
 * @author clan-
 */
public class FacadeLogs implements IFacadeLogs{
    private final  ILogsDao dao;

    public FacadeLogs() {
        this.dao = new DAO_Logs();
    }
    
    @Override
    public boolean setLog(Logs log) {
        boolean result = this.dao.SetLog(log);
        return result;
    }
    
    @Override
    public List<Logs> getLogs() {
        List<Logs> listaLogs = this.dao.getLogs();
        return listaLogs;
    }
    
}
