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
public class Logs {
   //Tabla Logs
   int ID_USER_LOGS;
   String ACCION_LOGS;
   String DESCRIPCION_LOGS;
   String FECHA_LOGS;  
   
   //Vista Logs
   String NOMBRE_USER;
   String NOMBRE_TIPO_PERFIL;

    public String getNOMBRE_USER() {
        return NOMBRE_USER;
    }

    public void setNOMBRE_USER(String NOMBRE_USER) {
        this.NOMBRE_USER = NOMBRE_USER;
    }

    public String getNOMBRE_TIPO_PERFIL() {
        return NOMBRE_TIPO_PERFIL;
    }

    public void setNOMBRE_TIPO_PERFIL(String NOMBRE_TIPO_PERFIL) {
        this.NOMBRE_TIPO_PERFIL = NOMBRE_TIPO_PERFIL;
    }

    public Logs() {
    }

    public Logs(int ID_USER_LOGS, String ACCION_LOGS, String DESCRIPCION_LOGS, String FECHA_LOGS) {
        this.ID_USER_LOGS = ID_USER_LOGS;
        this.ACCION_LOGS = ACCION_LOGS;
        this.DESCRIPCION_LOGS = DESCRIPCION_LOGS;
        this.FECHA_LOGS = FECHA_LOGS;
    }

    public int getID_USER_LOGS() {
        return ID_USER_LOGS;
    }

    public void setID_USER_LOGS(int ID_USER_LOGS) {
        this.ID_USER_LOGS = ID_USER_LOGS;
    }

    public String getACCION_LOGS() {
        return ACCION_LOGS;
    }

    public void setACCION_LOGS(String ACCION_LOGS) {
        this.ACCION_LOGS = ACCION_LOGS;
    }

    public String getDESCRIPCION_LOGS() {
        return DESCRIPCION_LOGS;
    }

    public void setDESCRIPCION_LOGS(String DESCRIPCION_LOGS) {
        this.DESCRIPCION_LOGS = DESCRIPCION_LOGS;
    }

    public String getFECHA_LOGS() {
        return FECHA_LOGS;
    }

    public void setFECHA_LOGS(String FECHA_LOGS) {
        this.FECHA_LOGS = FECHA_LOGS;
    }
}
