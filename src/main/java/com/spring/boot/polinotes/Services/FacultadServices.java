/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.boot.polinotes.Services;

import com.spring.boot.polinotes.facade.FacadeFacultad;
import com.spring.boot.polinotes.facade.IFacadeFacultad;
import com.spring.boot.polinotes.models.Facultad;
import com.spring.boot.polinotes.models.Materia;
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
public class FacultadServices {
    private IFacadeFacultad facade;

    public FacultadServices() {
        this.facade = new FacadeFacultad();
    }
    
    
    
    @CrossOrigin
    @RequestMapping(value="/allfacult", method=RequestMethod.GET)
    public List<Facultad> getFacultades(){
        return this.facade.getFacultad();
    }
    
}
