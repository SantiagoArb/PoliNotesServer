/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.boot.polinotes.facade;

import com.spring.boot.polinotes.methods.SecurityPass;
import com.spring.boot.polinotes.models.Usuario;
import java.util.List;

/**
 *
 * @author Home
 */
public interface IFacadeUsuario {
    public boolean setUser(Usuario user);

    public boolean updateUser(Usuario user);

    public boolean deleteUser(Usuario user);

    public List<Usuario> getUsers();
    public Usuario getInfoUser(String user);

    //****************************************VISTAS****************************************************
    public List<Usuario> getUserDecano_reg();
    
    public List<Usuario> getUserDecano_mod();

    //**********************************PROCEDIMIENTOS ALMACENADOS**************************************
    public Usuario P_Login(Usuario user);
    public boolean P_ValidUser(String tipo, Usuario user);
}
