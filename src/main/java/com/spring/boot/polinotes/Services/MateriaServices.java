/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.boot.polinotes.Services;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.spring.boot.polinotes.facade.FacadeMateria;
import com.spring.boot.polinotes.facade.FacadeUsuario;
import com.spring.boot.polinotes.facade.IFacadeMateria;
import com.spring.boot.polinotes.facade.IFacadeUsuario;
import com.spring.boot.polinotes.models.Concertacion;
import com.spring.boot.polinotes.models.Materia;
import com.spring.boot.polinotes.models.Usuario;
import com.spring.boot.polinotes.models.estMat;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.lang.reflect.Type;

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
    public List<estMat> getEstudianteMateria(@RequestParam("idx") int idx,@RequestParam("id_con") int id_con){
        return this.facade.getEstudianteMateria(idx,id_con);
    }
    
     @CrossOrigin
    @RequestMapping(value = "/deletestmat")
    public Boolean deleteEstudianteMateria(@RequestParam(value="doc") String doc,@RequestParam(value="idx")String idx){
        
        return this.facade.deleteEstudianteMateria(idx,doc);
    }
    
     @CrossOrigin
    @RequestMapping(value = "/deletemat", method = RequestMethod.GET)
    public Boolean deleteMateria(@RequestParam(value="idx") int idx){
        Materia mat = new Materia();
        mat.setID_MATERIA(idx);
        return this.facade.deleteMateria(mat);
    }
    
    @CrossOrigin
    @RequestMapping(value="/mymats", method=RequestMethod.GET)
    public List<estMat> getMisMaterias(@RequestParam(value="doc") String doc){
        Usuario us = new Usuario();
        us.setDOC_USER(doc);
        return this.facade.getMisMaterias(us);
    }
    
     @CrossOrigin
    @RequestMapping(value = "/setconcer", method = RequestMethod.POST)
    public Boolean setConcertacion(@RequestBody String concert){
        
         Concertacion data = new Gson().fromJson(concert, Concertacion.class);
        System.out.println(concert);
        return this.facade.setConcertacion(data);
    }
    
    @CrossOrigin
    @RequestMapping(value="/getconcert", method=RequestMethod.GET)
    public List<Materia> getConcertacion(@RequestParam(value="idx") int idx){
        return this.facade.getConcertacionMateria(idx);
    }
    
    @CrossOrigin
    @RequestMapping(value = "/setnota", method = RequestMethod.POST)
    public Boolean setNota(@RequestBody String obj){
        
         estMat data = new Gson().fromJson(obj, estMat.class);
        System.out.println(data);
        return this.facade.callSetNota(data);
    }
    
    @CrossOrigin
    @RequestMapping(value = "/getnotas", method = RequestMethod.POST)
    public List<estMat> getMisNota(@RequestBody String obj){
        
         estMat data = new Gson().fromJson(obj, estMat.class);
        System.out.println(data);
        return this.facade.getMisNotas(data);
    }
    
    @CrossOrigin
    @RequestMapping(value="/concertado", method=RequestMethod.GET)
    public int getValorConcertado(@RequestParam(value="idx") int idx){
        return this.facade.getValorConcertado(idx);
    }
    
    @CrossOrigin
    @RequestMapping(value = "/updconcertacion", method = RequestMethod.POST)
    public boolean updateConcertacion(@RequestBody String obj){
        
         Concertacion data = new Gson().fromJson(obj, Concertacion.class);
        System.out.println(data);
        return this.facade.updateConcertacion(data);
    }
    
    @CrossOrigin
    @RequestMapping(value = "/guardarnotas", method = RequestMethod.POST)
    public boolean GuardarNotas(@RequestBody String obj){
        
        Type listType = new TypeToken<ArrayList<estMat>>() {
                    }.getType();
        List<estMat> data = new Gson().fromJson(obj, listType);
        
        //ArrayList<estMat> data = new Gson().fromJson(obj, ArrayList.class);
        System.out.println(data);
        return this.facade.SaveAllCalifications(data);
    }
    
    @CrossOrigin
    @RequestMapping(value = "/deleteconcert", method = RequestMethod.POST)
    public boolean deleteConcertacion(@RequestBody String obj){
        
         estMat data = new Gson().fromJson(obj, estMat.class);
        return this.facade.deleteConcertacion(data);
    }
    
     @CrossOrigin
    @RequestMapping(value="/getcantest", method=RequestMethod.GET)
    public List<estMat> getReportePorConcertacion(@RequestParam(value="idx") int idx){
        return this.facade.getCantidadEstudiantes(idx);
    }
    
    @CrossOrigin
    @RequestMapping(value="/getallestudiantes", method=RequestMethod.GET)
    public List<estMat> getEstudiantesPorMateria(@RequestParam(value="idx") int idx){
        return this.facade.getEstudiantesPorMateria(idx);
    }
    
     @CrossOrigin
    @RequestMapping(value = "/deleteestudiante", method = RequestMethod.POST)
    public boolean deleteEstudiante(@RequestBody String obj){
        
         estMat data = new Gson().fromJson(obj, estMat.class);
        return this.facade.deleteEstudiante(data);
    }
}
