/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.boot.polinotes.Dao;

import java.util.List;
import com.spring.boot.polinotes.models.Tipo_Perfil;
/**
 *
 * @author scardonas
 */
public interface ITipo_PerfilDao {
    
    public boolean setPerfil(Tipo_Perfil perfil);

    public List<Tipo_Perfil> getPerfil();

    public boolean updatePerfil(Tipo_Perfil perfil);

    public boolean deletePerfil(Tipo_Perfil perfil);
}
