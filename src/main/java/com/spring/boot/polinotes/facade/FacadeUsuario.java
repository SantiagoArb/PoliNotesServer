/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.boot.polinotes.facade;

import com.spring.boot.polinotes.Dao.DAO_Usuario;
import com.spring.boot.polinotes.Dao.IUsuarioDao;
import com.spring.boot.polinotes.methods.SecurityPass;
import com.spring.boot.polinotes.models.Usuario;
import java.util.List;

/**
 *
 * @author clan-
 */
public class FacadeUsuario implements IFacadeUsuario{

    
    public final IUsuarioDao dao;
    public FacadeUsuario() {
        this.dao = new DAO_Usuario();
    }
    
    

    @Override
    public boolean setUser(Usuario user) {
        SecurityPass md5 = new SecurityPass();
        String hash = md5.getMD5(user.getPASSWORD_USER());
        user.setPASSWORD_USER(hash);

        boolean result = this.dao.setUser(user);
        return result;
    }

    @Override
    public boolean updateUser(Usuario user) {
        boolean result = this.dao.updateUser(user);
        return result;
    }

    @Override
    public boolean deleteUser(Usuario user) {
        boolean result = this.dao.deleteUser(user);
        return result;
    }

    @Override
    public List<Usuario> getUsers() {
        List<Usuario> listaUsers = this.dao.getUser();
        return listaUsers;
    }
    @Override
    public Usuario getInfoUser(String user) {
        Usuario result = this.dao.getInfoUser(user);
        return result;
    }

    //****************************************VISTAS****************************************************
    @Override
    public List<Usuario> getUserDecano_reg() {
        List<Usuario> listaDecanos = this.dao.getUserDecano_reg();
        return listaDecanos;
    }
    
    @Override
    public List<Usuario> getUserDecano_mod() {
        List<Usuario> listaDecanos = this.dao.getUserDecano_mod();
        return listaDecanos;
    }

    //**********************************PROCEDIMIENTOS ALMACENADOS**************************************
    @Override
    public Usuario P_Login(Usuario user) {
        SecurityPass md5 = new SecurityPass();
        String hash = md5.getMD5(user.getPASSWORD_USER());
        user.setPASSWORD_USER(hash);

        Usuario result = this.dao.P_Login(user);
        return result;
    }

    @Override
    public boolean P_ValidUser(String tipo, Usuario user) {
        boolean result = this.dao.P_ValidUser(tipo, user);
        return result;
    }
}
