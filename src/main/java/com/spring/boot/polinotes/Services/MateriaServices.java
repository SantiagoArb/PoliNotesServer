/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.boot.polinotes.Services;

import com.google.gson.Gson;
import com.spring.boot.polinotes.facade.FacadeMateria;
import com.spring.boot.polinotes.facade.FacadeUsuario;
import com.spring.boot.polinotes.facade.IFacadeMateria;
import com.spring.boot.polinotes.facade.IFacadeUsuario;
import com.spring.boot.polinotes.models.Materia;
import com.spring.boot.polinotes.models.Usuario;
import com.spring.boot.polinotes.models.estMat;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Home
 */
@RestController
public class MateriaServices {
    private IFacadeMateria facade;

    public MateriaServices() {
        this.facade = new FacadeMateria();
    }
    
    @CrossOrigin
    @RequestMapping(value = "/newmat", method = RequestMethod.POST)
    public Boolean setMateria(@RequestBody String materia){
        
         Materia data = new Gson().fromJson(materia, Materia.class);
        System.out.println("Entro al servicio");
        System.out.println(materia);
        return this.facade.setMateria(data);
    }
    
    @CrossOrigin
    @RequestMapping(value="/allmats", method=RequestMethod.GET)
    public List<Materia> getUsuarios(@RequestParam(value="idx") int idx){
        return this.facade.getMateria(idx);
    }
    
     @CrossOrigin
    @RequestMapping(value = "/estmat", method = RequestMethod.POST)
    public Boolean setEstudianteMateria(@RequestBody String obj){
        
         estMat data = new Gson().fromJson(obj, estMat.class);
        System.out.println("Entro al servicio");
        System.out.println(obj);
        return this.facade.setEstudianteMateria(data);
    }
    @CrossOrigin
    @RequestMapping(value="/getestmat", method=RequestMethod.GET)
    public List<estMat> getEstudianteMateria(@RequestParam(value="idx") int idx){
        return this.facade.getEstudianteMateria(idx);
    }
    
     @CrossOrigin
    @RequestMapping(value = "/deletestmat", method = RequestMethod.GET)
    public Boolean deleteEstudianteMateria(@RequestParam(value="doc") String doc,@RequestParam(value="idx")String idx){
        
        return this.facade.deleteEstudianteMateria(idx,doc);
    }
}
