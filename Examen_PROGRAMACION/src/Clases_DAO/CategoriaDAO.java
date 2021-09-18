/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_DAO;

import ConexionBD.ConexionBD;
import entidades.Candidato;
import entidades.Categoria;
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
public class CategoriaDAO {

    private Categoria categoria;
    private static Connection conn;

    public CategoriaDAO() {
        conn = ConexionBD.establecerConexion();
    }

    public CategoriaDAO(Categoria c) {
        this.categoria = c;
        conn = ConexionBD.establecerConexion();
    }

    public static Categoria insertarCategoria(Categoria c) {
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                int idcategoria = c.getIdcategoria();
                String categoria = c.getCategoria();

                String sql = "INSERT INTO categoria(idcategoria, idcategoria) "
                        + "VALUES(" + idcategoria + ",'" + categoria + ")";
                pstmt = conn.prepareStatement(sql);
                pstmt.executeUpdate();

                //Se recupera de la BD el registro recien insertado;                 
                Statement stmt = null;
                stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
                String sqlRec = "SELECT * FROM categoria WHERE ";
                sqlRec += " idcategoria=" + idcategoria;
                sqlRec += " and categoria ='" + categoria + "'";

                sqlRec += " ORDER BY idcandidato DESC";
                ResultSet rs = stmt.executeQuery(sqlRec);
                while (rs.next()) {
                    idcategoria = rs.getInt("idcategoria");
                    categoria = rs.getString("categoria");

                    c = new Categoria(idcategoria, categoria);
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
            Logger.getLogger(CandidatoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }

}
