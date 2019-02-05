/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.boot.polinotes.Services;

import com.spring.boot.polinotes.facade.FacadeTipoPerfil;
import com.spring.boot.polinotes.facade.IFacadeTipoPerfil;
import com.spring.boot.polinotes.models.Facultad;
import com.spring.boot.polinotes.models.Tipo_Perfil;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Home
 */
@RestController
public class Tipo_PerfilServices {
    
    private IFacadeTipoPerfil facade;

    public Tipo_PerfilServices() {
        this.facade = new FacadeTipoPerfil();
    }
    
    
    
     @CrossOrigin
    @RequestMapping(value="/allperfil", method=RequestMethod.GET)
    public List<Tipo_Perfil> getFacultades(){
         System.out.println("perfiles");
        return this.facade.getPerfil();
    }
    
    
}
