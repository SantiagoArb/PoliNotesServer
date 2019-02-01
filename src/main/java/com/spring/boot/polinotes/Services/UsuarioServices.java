/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.boot.polinotes.Services;

import com.google.gson.Gson;
import com.spring.boot.polinotes.models.Usuario;
import com.spring.boot.polinotes.facade.FacadeUsuario;
import java.util.ArrayList;
import java.util.List;
import static org.springframework.http.converter.json.Jackson2ObjectMapperBuilder.json;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Home
 */

@RestController
public class UsuarioServices {
    private FacadeUsuario facade;

    public UsuarioServices() {
        this.facade = new FacadeUsuario();
    }
    
    
    
    @CrossOrigin
    @RequestMapping(value="/allusers", method=RequestMethod.GET)
    public List<Usuario> getUsuarios(){
        return this.facade.getUsers();
    }
    
    @CrossOrigin
    @RequestMapping("/newuser")
    public boolean setUsuario(){
        Usuario user = new Usuario();
        return this.facade.setUser(user);
    }
    
    @CrossOrigin
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Usuario Login(@RequestBody String usuario){
        
         Usuario data = new Gson().fromJson(usuario, Usuario.class);
        System.out.println("Entro al servicio");
        System.out.println(data);
        //
       
        return this.facade.P_Login(data);
    }
    
    @CrossOrigin
    @RequestMapping(value = "/registro", method = RequestMethod.POST)
    public Boolean Registro(@RequestBody String usuario){
        
         Usuario data = new Gson().fromJson(usuario, Usuario.class);
        System.out.println("Entro al servicio");
        System.out.println(data);
        return this.facade.setUser(data);//user;
    }
    
    @CrossOrigin
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Boolean Actualizacion(@RequestBody String usuario){
        
         Usuario data = new Gson().fromJson(usuario, Usuario.class);
        System.out.println("Entro al servicio");
        System.out.println(data);
        return this.facade.updateUser(data);//user;
    }
    
    @CrossOrigin
    @RequestMapping(value = "/getinfouser", method = RequestMethod.POST)
    public Usuario getInfo(@RequestBody String usuario){
        return this.facade.getInfoUser(usuario);//user;
    }
    
    @CrossOrigin
    @RequestMapping(value = "/deleteuser", method = RequestMethod.POST)
    public Boolean deleteUser(@RequestBody String usuario){
        
        Usuario dataDelete = new Gson().fromJson(usuario, Usuario.class);
        return this.facade.deleteUser(dataDelete);//user;
    }
    
    
    
}
