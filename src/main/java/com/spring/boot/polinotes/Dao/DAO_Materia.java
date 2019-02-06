/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.boot.polinotes.Dao;

import com.spring.boot.polinotes.utils.Conexion;
import com.spring.boot.polinotes.models.Facultad;
import com.spring.boot.polinotes.models.Materia;
import com.spring.boot.polinotes.models.Usuario;
import com.spring.boot.polinotes.models.estMat;
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
        String sql = "INSERT INTO MATERIA VALUES(?,?,?,?,?)";
        try {
            con = Conexion.getConexion();
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setInt(1, ma.getID_MATERIA());
                ps.setString(2, ma.getCODIGO_MATERIA());
                ps.setString(3, ma.getNOMBRE_MATERIA());
                ps.setInt(4, ma.getFACULTAD_MATERIA());
                ps.setInt(5, ma.getID_MAESTRO());
                
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
    public List<Materia> getMateria(int idx) {
        Connection con;
        Statement stm;
        ResultSet rs;

        String sql = "SELECT * FROM MATERIA WHERE ID_MAESTRO = ?";

        List<Materia> result = new ArrayList<>();

        try {
            con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idx);
            rs = ps.executeQuery();
            while (rs.next()) {
                Facultad fac = new Facultad();
                Materia ma = new Materia();
                
                ma.setID_MATERIA(rs.getInt("ID_MATERIA"));
                ma.setCODIGO_MATERIA(rs.getString("CODIGO_MATERIA"));
                ma.setNOMBRE_MATERIA(rs.getString("NOMBRE_MATERIA"));
                ma.setID_MAESTRO(rs.getInt("ID_MAESTRO"));
                result.add(ma);
            }

            ps.close();
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
        Connection con;

        String sql = "DELETE FROM materia WHERE id_materia = ?";

        try {
            con = Conexion.getConexion();
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setInt(1, ma.getID_MATERIA());
                ps.executeUpdate();
                ps.close();
            }
        } catch (SQLException e) {
            System.out.println("Error: Clase DAO_Usuario, método eliminar: " + e);
            return false;
        }
        return true;
    }
    
    @Override
    public boolean setEstudianteMateria(estMat obj) {
        Connection con;
        String sql = "INSERT INTO ESTUDIANTES_MATERIA VALUES(?,?,?)";
        try {
            con = Conexion.getConexion();
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, obj.getDoc_estudiante());
                ps.setInt(2, obj.getId_materia());
                ps.setString(3, obj.getNom_estudiante());
                
                ps.executeUpdate();
                ps.close();
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase DAO_Materia, método setEstudianteMateria: " + e);
            return false;
        }
        return true; 
    }
    
    @Override
    public List<estMat> getEstudianteMateria(int idx) {
        Connection con;
        Statement stm;
        ResultSet rs;

        String sql = "SELECT * FROM ESTUDIANTES_MATERIA WHERE ID_MATERIA = ? ORDER BY NOM_ESTUDIANTE";

        List<estMat> result = new ArrayList<>();

        try {
            con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idx);
            rs = ps.executeQuery();
            while (rs.next()) {
                estMat es = new estMat();
                
                es.setDoc_estudiante(rs.getString("DOC_ESTUDIANTE"));
                es.setId_materia(rs.getInt(("ID_MATERIA")));
                es.setNom_estudiante(rs.getString(("NOM_ESTUDIANTE")));
                
                
                result.add(es);
            }

            ps.close();
            rs.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase DAO_Materia, método obtener");
        }
        return result;
    }
    
     @Override
    public boolean deleteEstudianteMateria(String idx, String doc) {
        Connection con;

        String sql = "DELETE FROM ESTUDIANTES_MATERIA WHERE DOC_ESTUDIANTE = ? AND ID_MATERIA=?";

        try {
            con = Conexion.getConexion();
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, doc);
                ps.setInt(2, Integer.parseInt(idx));
                ps.executeUpdate();
                ps.close();
            }
        } catch (SQLException e) {
            System.out.println("Error: Clase DAO_Usuario, método eliminar: " + e);
            return false;
        }
        return true;
    }
    
    @Override
    public List<estMat> getMisMaterias(Usuario us) {
        Connection con;
        Statement stm;
        ResultSet rs;

        String sql = "SELECT * FROM ESTUDIANTES_MATERIA est, MATERIA mat WHERE est.doc_estudiante = ? and mat.id_materia=est.id_materia";

        List<estMat> result = new ArrayList<>();

        try {
            con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, us.getDOC_USER());
            rs = ps.executeQuery();
            while (rs.next()) {
                estMat es = new estMat();
                Materia mat = new Materia();
                
                es.setDoc_estudiante(rs.getString("DOC_ESTUDIANTE"));
                es.setId_materia(rs.getInt(("ID_MATERIA")));
                es.setNom_estudiante(rs.getString(("NOM_ESTUDIANTE")));
                
                es.setCODIGO_MATERIA(rs.getString("CODIGO_MATERIA"));
                es.setNOMBRE_MATERIA(rs.getString("NOMBRE_MATERIA"));
                es.setFACULTAD_MATERIA(rs.getInt("FACULTAD_MATERIA"));
                es.setID_MAESTRO(rs.getInt("ID_MAESTRO"));
                es.setID_MATERIA(rs.getInt("ID_MATERIA"));
                result.add(es);
            }

            ps.close();
            rs.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase DAO_Materia, método obtener");
            System.out.println(e);
        }
        return result;
    }
    
   
}
