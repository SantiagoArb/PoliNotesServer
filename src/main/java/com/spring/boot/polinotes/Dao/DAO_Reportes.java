/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.boot.polinotes.Dao;

import com.spring.boot.polinotes.models.Facultad;
import com.spring.boot.polinotes.models.Materia;
import com.spring.boot.polinotes.models.estMat;
import com.spring.boot.polinotes.models.reportePorConcertacion;
import com.spring.boot.polinotes.utils.Conexion;
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
 * @author Home
 */
public class DAO_Reportes implements IReportesDao{
    
    
    
    @Override
    public List<reportePorConcertacion> reportePorConcertacion(int idx) {
       
    
        Connection con;
        Statement stm;
        ResultSet rs;

        String sql = "select concertacion.NOMBRE_CON, concertacion.ID_CONCERTACION,concertacion.ID_MATERIA,PORCENTAJE_CON, \n" +
"      (select count(*) from nota_estudiante where NOTA_ES >= 3.0 and id_con=concertacion.ID_CONCERTACION) as aprobaron, \n" +
"      (select count(*) from nota_estudiante where NOTA_ES < 3.0 and id_con=concertacion.ID_CONCERTACION) as reprobaron\n" +
"    from concertacion where ID_MATERIA=?";
        //String sql = "SELECT * FROM MATERIA mat, CONCERTACION co where mat.id_materia=co.id_materia and mat.id_maestro = ?";

        List<reportePorConcertacion> result = new ArrayList();

        try {
            con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idx);
            rs = ps.executeQuery();
            while (rs.next()) {
                reportePorConcertacion report = new reportePorConcertacion();

               report.setId_Con(rs.getInt("ID_CONCERTACION"));
               report.setNombre_Con(rs.getString("NOMBRE_CON"));
               report.setId_mat(rs.getInt("ID_MATERIA"));
               report.setPorcentaje(rs.getDouble("PORCENTAJE_CON"));
               report.setAprovaron(rs.getInt("APROBARON"));
               report.setReprovaron(rs.getInt("REPROBARON"));

                result.add(report);
            }

            ps.close();
            rs.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase DAO_Reportes, método reportePorConcertacion");
            e.printStackTrace();
        }
        return result;
    }
    }
