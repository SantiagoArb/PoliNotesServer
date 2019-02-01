/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.boot.polinotes.Dao;

import com.spring.boot.polinotes.utils.Conexion;
import com.spring.boot.polinotes.models.Facultad;
import com.spring.boot.polinotes.models.Usuario;
import java.sql.CallableStatement;
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
public class DAO_Facultad implements IFacultadDao {

    @Override
    public boolean setFacultad(Facultad fac) {
        Connection con;
        String sql = "INSERT INTO FACULTAD VALUES(?,?,?,?)";
        try {
            con = Conexion.getConexion();
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setInt(1, fac.getID_FACULTAD());
                ps.setString(2, fac.getCODIGO_FACULTAD());
                ps.setString(3, fac.getNOMBRE_FACULTAD());
                ps.setString(4, fac.getDECANO_FACULTAD());

                ps.executeUpdate();
                ps.close();
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase DAO_Facultad, método registrar: " + e);
            return false;
        }
        return true;
    }

    @Override
    public List<Object> getFacultad() {
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
                Usuario user = new Usuario();

                fac.setID_FACULTAD(rs.getInt("ID_FACULTAD"));
                fac.setCODIGO_FACULTAD(rs.getString("CODIGO_FACULTAD"));
                fac.setNOMBRE_FACULTAD(rs.getString("NOMBRE_FACULTAD"));
                fac.setDECANO_FACULTAD(rs.getString("DECANO_FACULTAD"));
                result.add(fac);

                user.setNOMBRE_USER(rs.getString("NOMBRE_USER"));
                user.setAPELLIDOS_USER(rs.getString("APELLIDOS_USER"));
                user.setCORREO_USER(rs.getString("CORREO_USER"));
                user.setCELULAR_USER(rs.getString("CELULAR_USER"));
                result.add(user);
            }

            stm.close();
            rs.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase DAO_Facultad, método obtener");
        }
        return result;
    }

    @Override
    public boolean updateFacultad(Facultad fac) {
        Connection con;

        String sql = "UPDATE FACULTAD SET "
                + "CODIGO_FACULTAD   = ?, "
                + "NOMBRE_FACULTAD   = ?,"
                + "DECANO_FACULTAD   = ? "
                + "WHERE ID_FACULTAD = ?";
        try {
            con = Conexion.getConexion();
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, fac.getCODIGO_FACULTAD());
                ps.setString(2, fac.getNOMBRE_FACULTAD());
                ps.setString(3, fac.getDECANO_FACULTAD());
                ps.setInt(4, fac.getID_FACULTAD());

                ps.executeUpdate();
                ps.close();
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase DAO_FACULTAD, método actualizar");
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteFacultad(Facultad fac) {
        Connection con;

        String sql = "DELETE FROM FACULTAD WHERE ID_FACULTAD = ?";

        try {
            con = Conexion.getConexion();
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setInt(1, fac.getID_FACULTAD());
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("Error: Clase DAO_FACULTAD, método eliminar: " + e);
            return false;
        }
        return true;
    }

    //**************************************************Procedimientos Almacenados******************************************************
    @Override
    public boolean P_ValidFacultad(String tipo, Facultad fac) {
        Connection con;
        con = Conexion.getConexion();
        int valor;
        try (CallableStatement cst = con.prepareCall("{call Validaciones_Facultad (?,?,?)}")) {

            cst.setString(1, tipo);
            
            if (tipo.equals("ValidarCodigo")) {
                cst.setString(2, fac.getCODIGO_FACULTAD());
            }
            
            if (tipo.equals("ValidarNombre")) {
                cst.setString(2, fac.getNOMBRE_FACULTAD());  
            }
            
            cst.registerOutParameter(3, java.sql.Types.INTEGER);

            cst.execute();

            valor = cst.getInt(3);

            cst.close();

        } catch (SQLException ex) {
            System.out.println("Error: Procedimiento Almacenado, método P_ValidFacultad: " + ex);
            return false;
        }

        if (valor == 1) {
            return true;
        }
        return false;
    }

}
