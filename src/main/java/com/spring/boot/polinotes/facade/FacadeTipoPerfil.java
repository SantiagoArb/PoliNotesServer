/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.boot.polinotes.facade;

import com.spring.boot.polinotes.Dao.DAO_Tipo_Perfil;
import com.spring.boot.polinotes.Dao.ITipo_PerfilDao;
import com.spring.boot.polinotes.models.Tipo_Perfil;
import java.util.List;

/**
 *
 * @author scardonas
 */
public class FacadeTipoPerfil {
        public final ITipo_PerfilDao dao;

    public FacadeTipoPerfil() {
        this.dao = new DAO_Tipo_Perfil();
    }
        
        
        
    public boolean setPerfil(Tipo_Perfil perfil) {
        boolean result = this.dao.setPerfil(perfil);
        return result;
    }

    public boolean updatePerfil(Tipo_Perfil perfil) {
        boolean result = this.dao.updatePerfil(perfil);
        return result;
    }

    public boolean deletePerfil(Tipo_Perfil perfil) {
        boolean result = this.dao.deletePerfil(perfil);
        return result;
    }

    public List<Tipo_Perfil> getPerfil() {
        List<Tipo_Perfil> listaPerfil = this.dao.getPerfil();
        return listaPerfil;
    }
}
