/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_DAO;

import ConexionBD.ConexionBD;
import entidades.Candidato;
import entidades.Grupo;
import entidades.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rim
 */
public class GrupoDAO {

    private Grupo grupo;
    private static Connection conn;

    public GrupoDAO() {
        conn = ConexionBD.establecerConexion();
    }

    public GrupoDAO(Grupo c) {
        this.grupo = c;
        conn = ConexionBD.establecerConexion();
    }

    public static Grupo insertarGrupo(Grupo c) {
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                int idcandidato = c.getIdcandidato();
                Persona idportavoz = c.getIdportavoz();
                String sql = "INSERT INTO grupo(idcandidato, idportavoz) "
                        + "VALUES(" + idcandidato + ",'" + idportavoz + ")";
                pstmt = conn.prepareStatement(sql);
                pstmt.executeUpdate();

                //Se recupera de la BD el registro recien insertado;                 
                Statement stmt = null;
                stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);
                String sqlRec = "SELECT * FROM candidato WHERE ";
                sqlRec += " idcandidato=" + idcandidato;
                sqlRec += " and idaudicion=" + idportavoz;
                sqlRec += " ORDER BY idcandidato DESC";
                ResultSet rs = stmt.executeQuery(sqlRec);
                while (rs.next()) {
                    idcandidato = rs.getInt("idcandidato");
                    
                    c = new Grupo(idcandidato, idportavoz);
                    return c;
                }
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(CandidatoDAO.class.getName()).log(Level.SEVERE, null, ex);
                c = null;
            } finally {
                if (conn != null) {
                    ConexionBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(GrupoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }

}
