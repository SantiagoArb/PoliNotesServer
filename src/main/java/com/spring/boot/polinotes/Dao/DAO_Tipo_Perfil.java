/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.boot.polinotes.Dao;

import com.spring.boot.polinotes.utils.Conexion;
import com.spring.boot.polinotes.models.Tipo_Perfil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author scardonas
 */
public class DAO_Tipo_Perfil implements ITipo_PerfilDao {

    @Override
    public boolean setPerfil(Tipo_Perfil perfil) {
       Connection con;
        String sql = "INSERT INTO TIPO_PERFIL VALUES(?,?)";
        try {
            con = Conexion.getConexion();
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setInt(1, perfil.getID_TIPO_PERFIL());
                ps.setString(2, perfil.getNOMBRE_TIPO_PERFIL());
                ps.executeUpdate();
                ps.close();
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase DAO_Tipo_Perfil, método registrar: " + e);
            return false;
        }
        return true;
    }

    @Override
    public List<Tipo_Perfil> getPerfil() {
        Connection con;
        Statement stm;
        ResultSet rs;

        String sql = "SELECT * FROM TIPO_PERFIL ORDER BY NOMBRE_TIPO_PERFIL";

        List<Tipo_Perfil> listaPerfil = new ArrayList<>();

        try {
            con = Conexion.getConexion();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Tipo_Perfil p = new Tipo_Perfil();
                p.setID_TIPO_PERFIL(rs.getInt("ID_TIPO_PERFIL"));
                p.setNOMBRE_TIPO_PERFIL(rs.getString("NOMBRE_TIPO_PERFIL"));
                listaPerfil.add(p);
            }
            stm.close();
            rs.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase DAO_Tipo_Perfil, método obtener");
        }
        return listaPerfil;
     }

    @Override
    public boolean updatePerfil(Tipo_Perfil perfil) {
        Connection con;

        String sql = "UPDATE TIPO_PERFIL SET "
                + "NOMBRE_TIPO_PERFIL = ? "
                + "WHERE ID_TIPO_PERFIL = ?";
        try {
            con = Conexion.getConexion();
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, perfil.getNOMBRE_TIPO_PERFIL());
                ps.setInt(2, perfil.getID_TIPO_PERFIL());
                ps.executeUpdate();
                ps.close();
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase DAO_Tipo_Perfil, método actualizar");
            return false;
        }
        return true;
    }

    @Override
    public boolean deletePerfil(Tipo_Perfil perfil) {
       Connection con;

        String sql = "DELETE FROM TIPO_PERFIL WHERE ID_TIPO_PERFIL = ?";

        try {
            con = Conexion.getConexion();
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setInt(1, perfil.getID_TIPO_PERFIL());
                ps.executeUpdate();
                ps.close();
            }
        } catch (SQLException e) {
            System.out.println("Error: Clase DAO_Tipo_Perfil, método eliminar: " + e);
            return false;
        }
        return true;
    }
    
}
