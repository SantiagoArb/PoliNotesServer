/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.boot.polinotes.Services;

import com.spring.boot.polinotes.facade.FacadeReportes;
import com.spring.boot.polinotes.facade.IFacadeReportes;
import com.spring.boot.polinotes.models.reportePorConcertacion;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Home
 */
@RestController
public class ReportesServices {
    private IFacadeReportes facade;

    public ReportesServices() {
        this.facade = new FacadeReportes();
    }
    
    @CrossOrigin
    @RequestMapping(value="/reportexcon", method=RequestMethod.GET)
    public List<reportePorConcertacion> getReportePorConcertacion(@RequestParam(value="idx") int idx){
        return this.facade.reportePorConcertacion(idx);
    }
}
