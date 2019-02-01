/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.boot.polinotes.Dao;

import com.spring.boot.polinotes.utils.Conexion;
import com.spring.boot.polinotes.models.Facultad;
import com.spring.boot.polinotes.models.Materia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author scardonas
 */
public class DAO_Materia implements IMateriaDao {

    @Override
    public boolean setMateria(Materia ma) {
        Connection con;
        String sql = "INSERT INTO MATERIA VALUES(?,?,?,?)";
        try {
            con = Conexion.getConexion();
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setInt(1, ma.getID_MATERIA());
                ps.setString(2, ma.getCODIGO_MATERIA());
                ps.setString(3, ma.getNOMBRE_MATERIA());
                ps.setInt(4, ma.getFACULTAD_MATERIA());
                
                ps.executeUpdate();
                ps.close();
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase DAO_Materia, método registrar: " + e);
            return false;
        }
        return true; }

    @Override
    public List<Object> getMateria() {
        Connection con;
        Statement stm;
        ResultSet rs;

        String sql = "SELECT * FROM v_Facultad ORDER BY NOMBRE_FACULTAD";

        List<Object> result = new ArrayList<>();

        try {
            con = Conexion.getConexion();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Facultad fac = new Facultad();
                Materia ma = new Materia();

                fac.setCODIGO_FACULTAD(rs.getString("CODIGO_FACULTAD"));
                fac.setNOMBRE_FACULTAD(rs.getString("NOMBRE_FACULTAD"));
                result.add(fac);

                ma.setID_MATERIA(rs.getInt("ID_MATERIA"));
                ma.setCODIGO_MATERIA(rs.getString("CODIGO_MATERIA"));
                ma.setNOMBRE_MATERIA(rs.getString("NOMBRE_MATERIA"));
                result.add(ma);
            }

            stm.close();
            rs.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase DAO_Materia, método obtener");
        }
        return result;
    }

    @Override
    public boolean updateMateria(Materia ma) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteMateria(Materia ma) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
