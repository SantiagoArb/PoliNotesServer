/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.boot.polinotes.Dao;

import com.spring.boot.polinotes.utils.Conexion;
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
public class DAO_Usuario implements IUsuarioDao {

    @Override
    public boolean setUser(Usuario user) {
        Connection con;
        String sql = "INSERT INTO USUARIO VALUES(?,?,?,?,?,?,?,?,?)";
        try {
            con = Conexion.getConexion();
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, user.getDOC_USER());
                ps.setString(2, user.getNICK_USER());
                ps.setString(3, user.getPASSWORD_USER());
                ps.setString(4, user.getNOMBRE_USER());
                ps.setString(5, user.getAPELLIDOS_USER());
                ps.setString(6, user.getCELULAR_USER());
                ps.setString(7, user.getCORREO_USER());
                ps.setInt(8, user.getID_PERFIL_USER());
                ps.setInt(9, user.getESTADO_USER());
                ps.executeUpdate();
                ps.close();
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase DAO_Usuario, método registrar: " + e);
            return false;
        }
        return true;
    }

    @Override
    public List<Usuario> getUser() {
        System.out.println("Llego hasta el dao!!!!");
        
        Connection con;
        Statement stm;
        ResultSet rs;

        String sql = "SELECT * FROM USUARIO ORDER BY NOMBRE_USER";

        List<Usuario> listaUsuario = new ArrayList<>();

        try {
            con = Conexion.getConexion();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Usuario u = new Usuario();
                u.setDOC_USER(rs.getString("DOC_USER"));
                u.setNOMBRE_USER(rs.getString("NOMBRE_USER"));
                u.setAPELLIDOS_USER(rs.getString("APELLIDOS_USER"));
                u.setCELULAR_USER(rs.getString("CELULAR_USER"));
                u.setCORREO_USER(rs.getString("CORREO_USER"));
                u.setID_PERFIL_USER(rs.getInt("ID_PERFIL_USER"));
                u.setESTADO_USER(rs.getInt("ESTADO_USER"));
                listaUsuario.add(u);
            }
            stm.close();
            rs.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase DAO_USUARIO, método obtener");
        }
        return listaUsuario;
    }
    
    @Override
    public Usuario getInfoUser(String user) {
        System.out.println("Llego hasta el dao!!!!");
        Usuario result = new Usuario();
        Connection con;
        Statement stm;
        ResultSet rs;

        String sql = "SELECT * FROM USUARIO WHERE NICK_USER = ?";

        

       try {
            con = Conexion.getConexion();
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, user);
              rs =  ps.executeQuery();
                
            while(rs.next()){
            result.setDOC_USER(rs.getString("DOC_USER"));
            result.setNOMBRE_USER(rs.getString("NOMBRE_USER"));
            result.setAPELLIDOS_USER(rs.getString("APELLIDOS_USER"));
            result.setCORREO_USER(rs.getString("CORREO_USER"));
            result.setCELULAR_USER(rs.getString("CELULAR_USER"));
            result.setID_PERFIL_USER(rs.getInt("ID_PERFIL_USER"));
            result.setESTADO_USER(rs.getInt("ESTADO_USER"));
            result.setNICK_USER(rs.getString("NICK_USER"));
            
                }
                ps.close();
                rs.close();
                
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase DAO_Usuario, método getInfoUser: " + e);
            return null;
        }
        return result;
    }

    @Override
    public boolean updateUser(Usuario user) {
        Connection con;

        String sql = "UPDATE USUARIO SET "
                
                + "NOMBRE_USER        = ?, "
                + "APELLIDOS_USER     = ?, "
                + "CELULAR_USER       = ?, "
                + "CORREO_USER        = ? "
                + "WHERE DOC_USER     = ?";
        try {
            con = Conexion.getConexion();
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                
                ps.setString(1, user.getNOMBRE_USER());
                ps.setString(2, user.getAPELLIDOS_USER());
                ps.setString(3, user.getCELULAR_USER());
                ps.setString(4, user.getCORREO_USER());
                ps.setString(5, user.getDOC_USER());
                ps.executeUpdate();
                ps.close();
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase DAO_USUARIO, método actualizar");
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteUser(Usuario user) {
        Connection con;

        String sql = "DELETE FROM USUARIO WHERE DOC_USER = ?";

        try {
            con = Conexion.getConexion();
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, user.getDOC_USER());
                ps.executeUpdate();
                ps.close();
            }
        } catch (SQLException e) {
            System.out.println("Error: Clase DAO_Usuario, método eliminar: " + e);
            return false;
        }
        return true;
    }

    //**************************************************Vistas******************************************************
    @Override
    public List<Usuario> getUserDecano_reg() {
        Connection con;
        Statement stm;
        ResultSet rs;

        String sql = "SELECT * FROM v_Decanos_Reg ORDER BY NOMBRE_USER";

        List<Usuario> listaUsuario = new ArrayList<>();

        try {
            con = Conexion.getConexion();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Usuario u = new Usuario();
                u.setDOC_USER(rs.getString("DOC_USER"));
                u.setNOMBRE_USER(rs.getString("NOMBRE_USER"));
                u.setAPELLIDOS_USER(rs.getString("APELLIDOS_USER"));
                listaUsuario.add(u);
            }
            stm.close();
            rs.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase DAO_USUARIO, método obtener");
        }
        return listaUsuario;
    }

    @Override
    public List<Usuario> getUserDecano_mod() {
        Connection con;
        Statement stm;
        ResultSet rs;

        String sql = "SELECT * FROM v_Decanos_Mod ORDER BY NOMBRE_USER";

        List<Usuario> listaUsuario = new ArrayList<>();

        try {
            con = Conexion.getConexion();
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                Usuario u = new Usuario();
                u.setDOC_USER(rs.getString("DOC_USER"));
                u.setNOMBRE_USER(rs.getString("NOMBRE_USER"));
                u.setAPELLIDOS_USER(rs.getString("APELLIDOS_USER"));
                listaUsuario.add(u);
            }
            stm.close();
            rs.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase DAO_USUARIO, método obtener");
        }
        return listaUsuario;
    }

    //**************************************************Procedimientos Almacenados******************************************************
    @Override
    public Usuario P_Login(Usuario user) {
        Connection con;
        con = Conexion.getConexion();
        Usuario result = new Usuario();
        int valor;
        
        try (CallableStatement cst = con.prepareCall("{call LoginUsuario (?,?,?,?,?,?,?,?,?,?,?)}")) {

            cst.setString(1, user.getNICK_USER());
            cst.setString(2, user.getPASSWORD_USER());

            cst.registerOutParameter(3, java.sql.Types.INTEGER);
            cst.registerOutParameter(4, java.sql.Types.VARCHAR);
            cst.registerOutParameter(5, java.sql.Types.VARCHAR);
            cst.registerOutParameter(6, java.sql.Types.VARCHAR);
            cst.registerOutParameter(7, java.sql.Types.VARCHAR);
            cst.registerOutParameter(8, java.sql.Types.VARCHAR);
            cst.registerOutParameter(9, java.sql.Types.INTEGER);
            cst.registerOutParameter(10, java.sql.Types.INTEGER);
            cst.registerOutParameter(11, java.sql.Types.VARCHAR);

            cst.execute();
            
            valor = cst.getInt(3);
            result.setDOC_USER(cst.getString(4));
            result.setNOMBRE_USER(cst.getString(5));
            result.setAPELLIDOS_USER(cst.getString(6));
            result.setCORREO_USER(cst.getString(7));
            result.setCELULAR_USER(cst.getString(8));
            result.setID_PERFIL_USER(cst.getInt(9));
            result.setESTADO_USER(cst.getInt(10));
            result.setNICK_USER(cst.getString(11));

            cst.close();

        } catch (SQLException ex) {
            System.out.println("Error: Procedimiento Almacenado, método Login: " + ex);
            return null;
        }

        if (valor == 1) {
            return result;
        }else{
            return null;
        }
        
    }

    @Override
    public boolean P_ValidUser(String tipo, Usuario user) {
        Connection con;
        con = Conexion.getConexion();
        int valor;
        try (CallableStatement cst = con.prepareCall("{call Validaciones_Usuario (?,?,?)}")) {

            cst.setString(1, tipo);
            
            if (tipo.equals("ValidarNick")) {
                cst.setString(2, user.getNICK_USER());
            }
            
            if (tipo.equals("ValidarEmail")) {
                cst.setString(2, user.getCORREO_USER());
            }
            
            if (tipo.equals("ValidarDoc")) {
                cst.setString(2, user.getDOC_USER());
            }   
            cst.registerOutParameter(3, java.sql.Types.INTEGER);

            cst.execute();

            valor = cst.getInt(3);

            cst.close();

        } catch (SQLException ex) {
            System.out.println("Error: Procedimiento Almacenado, método P_ValidUser: " + ex);
            return false;
        }

        if (valor == 1) {
            return true;
        }
        return false;
    }
}
