/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.boot.polinotes.Services;

import com.spring.boot.polinotes.facade.FacadeUsuario;
import com.spring.boot.polinotes.facade.IFacadeUsuario;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Home
 */
@RestController
public class MateriaServices {
    private IFacadeUsuario facade;

    public MateriaServices() {
        this.facade = new FacadeUsuario();
    }
}
