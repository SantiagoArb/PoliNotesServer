/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.boot.polinotes.Dao;

import com.spring.boot.polinotes.utils.Conexion;
import com.spring.boot.polinotes.models.Logs;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author clan-
 */
public class DAO_Logs implements ILogsDao{

    @Override
    public boolean SetLog(Logs log) {
        Connection con;
        String sql = "INSERT INTO LOGS (ID_USER_LOGS, ACCION_LOGS, DESCRIPCION_LOGS, FECHA_LOGS) VALUES(?,?,?,?)";
        try {
            con = Conexion.getConexion();
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setInt(1, log.getID_USER_LOGS());
                ps.setString(2, log.getACCION_LOGS());
                ps.setString(3, log.getDESCRIPCION_LOGS());
                ps.setString(4, log.getFECHA_LOGS());
                
                ps.executeUpdate();
                ps.close();
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase DAO_Logs, método registrar: " + e);
            return false;
        }
        return true;
    }

    @Override
    public List<Logs> getLogs() {
        Connection con;
        Statement stm;
        ResultSet rs;

        String sql = "SELECT * FROM v_Logs ORDER BY NOMBRE_USER";

        List<Logs> listaLogs = new ArrayList<>();

        try {
            con = Conexion.getConexion();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Logs log = new Logs();
                log.setNOMBRE_USER(rs.getString("NOMBRE_USER"));
                log.setNOMBRE_TIPO_PERFIL(rs.getString("NOMBRE_TIPO_PERFIL"));
                log.setACCION_LOGS(rs.getString("ACCION_LOGS"));
                log.setDESCRIPCION_LOGS(rs.getString("DESCRIPCION_LOGS"));
                log.setFECHA_LOGS(rs.getString("FECHA_LOGS"));
                 
                listaLogs.add(log);
            }
            stm.close();
            rs.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase DAO_Logs, método obtener");
        }
        return listaLogs;
    }
    
}
