/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_DAO;

import ConexionBD.ConexionBD;
import entidades.Candidato;
import entidades.Individual;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rim
 */
public class IndividualDAO {

    private Individual individual;
    private static Connection conn;

    public IndividualDAO() {
        conn = ConexionBD.establecerConexion();
    }

    public IndividualDAO(Individual i) {
        this.individual = i;
        conn = ConexionBD.establecerConexion();
    }
    public static Individual insertarIndividual(Individual i) {
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                int idcandidato = i.getIdcandidato();
                int edad = i.getEdad();
                String sql = "INSERT INTO individual(idcandidato, Edad) "
                        + "VALUES(" + idcandidato + ", " + edad +")";
                pstmt = conn.prepareStatement(sql);
                pstmt.executeUpdate();

                //Se recupera de la BD el registro recien insertado;                 
                Statement stmt = null;
                stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);
                String sqlRec = "SELECT * FROM individual WHERE ";
                sqlRec += " idcandidato=" + idcandidato;
                sqlRec += " and nombre='" + edad + "'";
                sqlRec += " ORDER BY id DESC";
                ResultSet rs = stmt.executeQuery(sqlRec);
                while (rs.next()) {
                    idcandidato = rs.getInt("idcandidato");
                    edad = Integer.parseInt(rs.getString("edad"));
                    i = new Individual(idcandidato, edad);
                    return i;
                }
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(CandidatoDAO.class.getName()).log(Level.SEVERE, null, ex);
                i = null;
            } finally {
                if (conn != null) {
                    ConexionBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(CandidatoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }

    public ArrayList<Individual> filtrarIndividualPorEdad(int ed) {
        ArrayList<Individual> ret = new ArrayList<Individual>();
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                pstmt = conn.prepareStatement("SELECT * FROM individual WHERE edad >= " + ed + " ORDER BY edad ASC");
                ResultSet prs = pstmt.executeQuery();
                while (prs.next()) {
                    int idcandidato = prs.getInt("idcandidato");
                    int edad = prs.getInt("edad");
                    Individual i = new Individual(idcandidato, edad);
                    ret.add(i);
                }
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(CandidatoDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (conn != null) {
                    ConexionBD.cerrarConexion();

                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CandidatoDAO.class.getName()).log(Level.SEVERE, null,
                    ex);
        }
        for (Individual i : ret) {
            System.out.println("idcandidato=" + i.getIdcandidato() + ", edad=" + i.getEdad());
        }
        return ret;

    }

}
