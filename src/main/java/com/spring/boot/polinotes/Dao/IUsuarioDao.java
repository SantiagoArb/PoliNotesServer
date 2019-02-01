/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.boot.polinotes.Dao;

import java.util.List;
import com.spring.boot.polinotes.models.Usuario;
/**
 *
 * @author clan-
 */
public interface IUsuarioDao {

    public boolean setUser(Usuario user);

    public List<Usuario> getUser();

    public boolean updateUser(Usuario user);

    public boolean deleteUser(Usuario user);
    
    //Vistas
    public List<Usuario> getUserDecano_reg();
    
    public List<Usuario> getUserDecano_mod();
    
    //Procedimientos Almacenados
    public Usuario P_Login(Usuario user);
    
    public boolean P_ValidUser(String tipo, Usuario user);
    
    public Usuario getInfoUser(String user);
}
