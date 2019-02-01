/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.boot.polinotes.facade;

import com.spring.boot.polinotes.models.Logs;
import java.util.List;

/**
 *
 * @author Home
 */
public interface IFacadeLogs {
    public boolean setLog(Logs log);
    
    public List<Logs> getLogs();
}
