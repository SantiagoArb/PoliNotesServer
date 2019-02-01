/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.boot.polinotes.models;

/**
 *
 * @author clan-
 */
public class Usuario { 
    private String DOC_USER;
    private String NICK_USER; 
    private String PASSWORD_USER;
    private String NOMBRE_USER; 
    private String APELLIDOS_USER;
    private String CELULAR_USER;
    private String CORREO_USER; 
    private int ID_PERFIL_USER;
    private int ESTADO_USER; 

    public Usuario() {
    }

    public Usuario(String DOC_USER, String NICK_USER, String PASSWORD_USER, String NOMBRE_USER, String APELLIDOS_USER, String CELULAR_USER, String CORREO_USER, int ID_PERFIL_USER, int ESTADO_USER) {
        this.DOC_USER = DOC_USER;
        this.NICK_USER = NICK_USER;
        this.PASSWORD_USER = PASSWORD_USER;
        this.NOMBRE_USER = NOMBRE_USER;
        this.APELLIDOS_USER = APELLIDOS_USER;
        this.CELULAR_USER = CELULAR_USER;
        this.CORREO_USER = CORREO_USER;
        this.ID_PERFIL_USER = ID_PERFIL_USER;
        this.ESTADO_USER = ESTADO_USER;
    }

    public String getDOC_USER() {
        return DOC_USER;
    }

    public void setDOC_USER(String DOC_USER) {
        this.DOC_USER = DOC_USER;
    }

    public String getNICK_USER() {
        return NICK_USER;
    }

    public void setNICK_USER(String NICK_USER) {
        this.NICK_USER = NICK_USER;
    }

    public String getPASSWORD_USER() {
        return PASSWORD_USER;
    }

    public void setPASSWORD_USER(String PASSWORD_USER) {
        this.PASSWORD_USER = PASSWORD_USER;
    }

    public String getNOMBRE_USER() {
        return NOMBRE_USER;
    }

    public void setNOMBRE_USER(String NOMBRE_USER) {
        this.NOMBRE_USER = NOMBRE_USER;
    }

    public String getAPELLIDOS_USER() {
        return APELLIDOS_USER;
    }

    public void setAPELLIDOS_USER(String APELLIDOS_USER) {
        this.APELLIDOS_USER = APELLIDOS_USER;
    }

    public String getCELULAR_USER() {
        return CELULAR_USER;
    }

    public void setCELULAR_USER(String CELULAR_USER) {
        this.CELULAR_USER = CELULAR_USER;
    }

    public String getCORREO_USER() {
        return CORREO_USER;
    }

    public void setCORREO_USER(String CORREO_USER) {
        this.CORREO_USER = CORREO_USER;
    }

    public int getID_PERFIL_USER() {
        return ID_PERFIL_USER;
    }

    public void setID_PERFIL_USER(int ID_PERFIL_USER) {
        this.ID_PERFIL_USER = ID_PERFIL_USER;
    }

    public int getESTADO_USER() {
        return ESTADO_USER;
    }

    public void setESTADO_USER(int ESTADO_USER) {
        this.ESTADO_USER = ESTADO_USER;
    }
    
    
  
}
