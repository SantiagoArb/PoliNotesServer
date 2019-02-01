/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.boot.polinotes.Dao;

import java.util.List;
import com.spring.boot.polinotes.models.Logs;

/**
 *
 * @author clan-
 */
public interface ILogsDao {
    
    public boolean SetLog(Logs log);
    
    public List<Logs> getLogs();
    
}
