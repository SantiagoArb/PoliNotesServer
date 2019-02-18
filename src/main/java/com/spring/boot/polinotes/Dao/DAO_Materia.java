/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.boot.polinotes.Dao;

import com.spring.boot.polinotes.models.Concertacion;
import com.spring.boot.polinotes.utils.Conexion;
import com.spring.boot.polinotes.models.Facultad;
import com.spring.boot.polinotes.models.Materia;
import com.spring.boot.polinotes.models.Usuario;
import com.spring.boot.polinotes.models.estMat;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.Types;
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
        return true;
    }

    @Override
    public List<Materia> getMateria(int idx) {
        Connection con;
        Statement stm;
        ResultSet rs;

        String sql = "SELECT * FROM MATERIA WHERE ID_MAESTRO = ?";
        //String sql = "SELECT * FROM MATERIA mat, CONCERTACION co where mat.id_materia=co.id_materia and mat.id_maestro = ?";

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
                /* ma.setId_concertacion(rs.getInt("ID_CONCERTACION"));
                 ma.setNom_concertacion(rs.getString("NOMBRE_CON"));
                 ma.setValor_porcentual(rs.getDouble("PORCENTAJE_CON"));
                 ma.setDoc_maestro(rs.getString("DOC_MAESTRO"));
                 ma.setId_usuario(rs.getInt("ID_USUARIO"));*/

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
        con = Conexion.getConexion();

         try (CallableStatement cst = con.prepareCall("{call deleteMateria (?,?)}")) {
             cst.setInt(1, ma.getID_MATERIA());
            cst.registerOutParameter(2, java.sql.Types.INTEGER);

            cst.execute();
            cst.close();
            con.close();

        } catch (SQLException ex) {
            System.out.println("Error: Procedimiento Almacenado, método deleteMateria: " + ex);
            return false;
        }
        return true;
    }

    @Override
    public boolean setEstudianteMateria(estMat obj) {
        Connection con;
        String sql = "INSERT INTO ESTUDIANTES_MATERIA VALUES(?,?,?,?)";
        try {
            con = Conexion.getConexion();
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, obj.getDoc_estudiante());
                ps.setInt(2, obj.getId_materia());
                ps.setString(3, obj.getNom_estudiante());
                ps.setNull(4, Types.INTEGER);

                ps.executeUpdate();
                ps.close();
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase DAO_Materia, método setEstudianteMateria: " + e);
            return false;
        }
        this.callLigarUserEstudiante();
        this.TareasetEstudianteToNotas(obj.getId_materia());
        return true;
    }

    @Override
    public List<estMat> getEstudianteMateria(int idx, int id_con) {
        Connection con;
        Statement stm;
        ResultSet rs;

        // String sql = "SELECT * FROM ESTUDIANTES_MATERIA WHERE ID_MATERIA = ? ORDER BY NOM_ESTUDIANTE";
        String sql = "select * from nota_estudiante nt inner join estudiantes_materia est on est.doc_estudiante=nt.doc_est where id_con = ? and est.id_materia=?";
        List<estMat> result = new ArrayList<>();

        try {
            con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id_con);
            ps.setInt(2, idx);
            rs = ps.executeQuery();
            while (rs.next()) {
                estMat es = new estMat();

                es.setDoc_estudiante(rs.getString("DOC_ESTUDIANTE"));
                es.setId_materia(rs.getInt(("ID_MATERIA")));
                es.setNom_estudiante(rs.getString(("NOM_ESTUDIANTE")));
                es.setId_usuario(rs.getInt("ID_USUARIO"));
                es.setId_nota(rs.getInt("ID_NOTA"));
                es.setNota(rs.getDouble("NOTA_ES"));
                es.setId_con(rs.getInt("ID_CON"));
                es.setComentario(rs.getString("COMENTARIO"));

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
        con = Conexion.getConexion();

         try (CallableStatement cst = con.prepareCall("{call deleteEstudiante (?,?,?)}")) {
             cst.setString(1, doc);
             cst.setInt(2, Integer.parseInt(idx));
            cst.registerOutParameter(2, java.sql.Types.INTEGER);

            cst.execute();
            cst.close();
            con.close();

        } catch (SQLException ex) {
            System.out.println("Error: Procedimiento Almacenado, método deleteEstudianteMateria: " + ex);
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
                es.setId_usuario(rs.getInt("ID_USUARIO"));

                es.setCODIGO_MATERIA(rs.getString("CODIGO_MATERIA"));
                es.setNOMBRE_MATERIA(rs.getString("NOMBRE_MATERIA"));
                es.setFACULTAD_MATERIA(rs.getInt("FACULTAD_MATERIA"));
                es.setID_MAESTRO(rs.getInt("ID_MAESTRO"));
                es.setId_materia(rs.getInt("ID_MATERIA"));
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

    @Override
    public void callLigarUserEstudiante() {
        Connection con;
        con = Conexion.getConexion();

        try (CallableStatement cst = con.prepareCall("{call LigarUsuarioEstudiante (?)}")) {
            cst.registerOutParameter(1, java.sql.Types.INTEGER);

            cst.execute();
            cst.close();
            con.close();

        } catch (SQLException ex) {
            System.out.println("Error: Procedimiento Almacenado, método Login: " + ex);

        }
    }

    @Override
    public boolean setConcertacion(Concertacion co) {
        Connection con;
        String sql = "INSERT INTO CONCERTACION VALUES(?,?,?,?,?,?)";
        try {
            con = Conexion.getConexion();
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setInt(1, 1);
                ps.setString(2, co.getNom_concertacion());
                ps.setDouble(3, co.getValor_porcentual());
                ps.setString(4, co.getDoc_maestro());
                ps.setInt(5, co.getId_materia());
                ps.setInt(6, co.getId_usuario());

                ps.executeUpdate();
                ps.close();
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase DAO_Materia, método setConcertacion: " + e);
            return false;
        }
        this.TareasetEstudianteToNotas(co.getId_materia());
        return true;
    }

    @Override
    public List<Materia> getConcertacionMateria(int idx) {
        Connection con;
        Statement stm;
        ResultSet rs;

        String sql = "select *From Concertacion where id_materia = ?";
        //String sql = "SELECT * FROM MATERIA mat, CONCERTACION co where mat.id_materia=co.id_materia and mat.id_maestro = ?";

        List<Materia> result = new ArrayList<>();

        try {
            con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idx);
            rs = ps.executeQuery();
            while (rs.next()) {
                Facultad fac = new Facultad();
                Materia ma = new Materia();

                ma.setId_concertacion(rs.getInt("ID_CONCERTACION"));
                ma.setNom_concertacion(rs.getString("NOMBRE_CON"));
                ma.setValor_porcentual(rs.getDouble("PORCENTAJE_CON"));
                ma.setDoc_maestro(rs.getString("DOC_MAESTRO"));
                ma.setId_usuario(rs.getInt("ID_USUARIO"));

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
    public boolean callSetNota(estMat nota) {
        Connection con;
        con = Conexion.getConexion();

        try (CallableStatement cst = con.prepareCall("{call setNota (?,?,?,?,?)}")) {
            cst.setNull(1, Types.INTEGER);
            cst.setDouble(2, nota.getNota());
            cst.setInt(3, nota.getId_con());
            cst.setString(4, nota.getDoc_estudiante());
            cst.setString(5, nota.getComentario());

            cst.execute();
            cst.close();
            con.close();

        } catch (SQLException ex) {
            System.out.println("Error: Procedimiento Almacenado, método Login: " + ex);
            return false;
        }
        return true;
    }

    @Override
    public boolean TareasetEstudianteToNotas(int id_materia) {
        Connection con;
        con = Conexion.getConexion();

        try (CallableStatement cst = con.prepareCall("{call setEstudianteToNotas (?)}")) {
            cst.setInt(1, id_materia);

            cst.execute();
            cst.close();

        } catch (SQLException ex) {
            System.out.println("Error: Procedimiento Almacenado, método Login: " + ex);
            return false;
        }
        return true;
    }

    @Override
    public List<estMat> getMisNotas(estMat datos) {
        Connection con;
        Statement stm;
        ResultSet rs;

        String sql = "select * from nota_estudiante nt inner join concertacion on nt.ID_CON = concertacion.ID_CONCERTACION where doc_est = ? and concertacion.ID_MATERIA=?";

        List<estMat> result = new ArrayList<>();

        try {
            con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, datos.getDoc_estudiante());
            ps.setInt(2, datos.getId_materia());
            rs = ps.executeQuery();
            while (rs.next()) {
                estMat es = new estMat();
                Materia mat = new Materia();

                es.setId_nota(rs.getInt("ID_NOTA"));
                es.setNota(rs.getDouble("NOTA_ES"));
                es.setId_con(rs.getInt("ID_CON"));
                es.setDoc_estudiante(rs.getString("DOC_EST"));
                es.setNombre_conertacion(rs.getString("NOMBRE_CON"));
                es.setPorcentaje(rs.getDouble("PORCENTAJE_CON"));
                es.setId_materia(rs.getInt("ID_MATERIA"));
                es.setId_usuario(rs.getInt("ID_USUARIO"));
                es.setComentario(rs.getString("COMENTARIO"));
                es.setDefinitiva(this.CalcularDefinitiva(datos.getId_materia(), datos.getDoc_estudiante()));
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

    @Override
    public double CalcularDefinitiva(int id_materia, String documento) {
        Connection con;
        con = Conexion.getConexion();
        double definitiva = 0;
        try (CallableStatement cst = con.prepareCall("{call calcularDefinitiva (?,?,?)}")) {
            cst.setString(1, documento);
            cst.setInt(2, id_materia);
            cst.registerOutParameter(3, java.sql.Types.DOUBLE);

            cst.execute();
            definitiva = cst.getDouble(3);
            cst.close();

        } catch (SQLException ex) {
            System.out.println("Error: Procedimiento Almacenado, método Login: " + ex);
        }
        return definitiva;
    }

    @Override
    public int getValorConcertado(int idx) {
        Connection con;
        Statement stm;
        ResultSet rs;

        String sql = "select sum(porcentaje_con) as concertado from concertacion where id_materia=?";
        //String sql = "SELECT * FROM MATERIA mat, CONCERTACION co where mat.id_materia=co.id_materia and mat.id_maestro = ?";

        int result = 0;

        try {
            con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idx);
            rs = ps.executeQuery();
            while (rs.next()) {
                result = rs.getInt("concertado");
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
    public boolean updateConcertacion(Concertacion concert) {
        Connection con;
        Statement stm;
        ResultSet rs;

        String sql = "update concertacion set NOMBRE_CON = ?, PORCENTAJE_CON = ? WHERE ID_CONCERTACION=?";
        try {
            con = Conexion.getConexion();
            try (PreparedStatement ps = con.prepareStatement(sql)) {

                ps.setString(1, concert.getNom_concertacion());
                ps.setDouble(2, concert.getValor_porcentual());
                ps.setInt(3, concert.getId_concertacion());
                ps.executeUpdate();
                ps.close();
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase DAO_Materia, método updateConcertacion");
            return false;
        }
        return true;
    }

    @Override
    public boolean SaveAllCalifications(List<estMat> notas) {
        Connection con;
        con = Conexion.getConexion();

        try (CallableStatement cst = con.prepareCall("{call setNota (?,?,?,?,?)}")) {

            for (estMat nota : notas) {
                cst.setNull(1, Types.INTEGER);
                cst.setDouble(2, nota.getNota());
                cst.setInt(3, nota.getId_con());
                cst.setString(4, nota.getDoc_estudiante());
                cst.setString(5, nota.getComentario());
                cst.execute();
            }

            cst.close();
            con.close();

        } catch (SQLException ex) {
            System.out.println("Error: Procedimiento Almacenado, método Login: " + ex);
            return false;
        }
        return true;
    }
    
    @Override
    public boolean deleteConcertacion(estMat concertacion) {
        Connection con;
        con = Conexion.getConexion();
        int result = 0;

        try (CallableStatement cst = con.prepareCall("{call deleteConcertacion (?,?,?)}")) {

            
                cst.setInt(1, concertacion.getId_con());
                cst.setInt(2, concertacion.getId_materia());
                cst.registerOutParameter(3, java.sql.Types.INTEGER);
                cst.execute();
            
                result = cst.getInt(3);
            cst.close();
            con.close();

        } catch (SQLException ex) {
            System.out.println("Error: Procedimiento Almacenado, método deleteConcertacion: " + ex);
            return false;
        }
        if(result == 1){
            return false;
        }else{
            return true;
        }
    }
    
    @Override
    public List<estMat> getCantidadEstudiantes(int idx) {
        Connection con;
        Statement stm;
        ResultSet rs;

        String sql = "select mat.ID_MATERIA, mat.NOMBRE_MATERIA,mat.CODIGO_MATERIA,mat.ID_MAESTRO,mat.FACULTAD_MATERIA, (select count(*) from estudiantes_materia estm where estm.ID_MATERIA=mat.ID_MATERIA) as Estudiantes from materia mat where mat.ID_MAESTRO=?";

        List<estMat> result = new ArrayList<>();

        try {
            con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idx);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                estMat es = new estMat();
               
                
               es.setId_materia(rs.getInt("ID_MATERIA"));
                es.setCODIGO_MATERIA(rs.getString("CODIGO_MATERIA"));
                es.setNOMBRE_MATERIA(rs.getString("NOMBRE_MATERIA"));
                es.setID_MAESTRO(rs.getInt("ID_MAESTRO"));
                es.setCantidad(rs.getInt("ESTUDIANTES"));
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
