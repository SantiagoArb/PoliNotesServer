/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.boot.polinotes.Dao;

import com.spring.boot.polinotes.models.reportePorConcertacion;
import java.util.List;

/**
 *
 * @author Home
 */
public interface IReportesDao {
     public List<reportePorConcertacion> reportePorConcertacion(int idx);
}