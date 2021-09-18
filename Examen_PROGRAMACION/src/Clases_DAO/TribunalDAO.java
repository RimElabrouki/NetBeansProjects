/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_DAO;

import ConexionBD.ConexionBD;
import entidades.Individual;
import entidades.Tribunal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rim
 */
public class TribunalDAO {

    private Tribunal tirbunal;
    private static Connection conn;

    /*public TribunalDAO

    {
        conn = ConexionBD.establecerConexion();
    }*/

    public TribunalDAO(Tribunal i) {
        this.tirbunal = i;
        conn = ConexionBD.establecerConexion();

    }

    public static Tribunal insertarTribunal(Tribunal i) {
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                int idtribunal = i.getIdtribunal();
                String nombre = i.getNombre();
                String email = i.getEmail();
                String dni = i.getDni();
                String telefono = i.getTelefono();
                String sql = "INSERT INTO tribunal (idtribunal, nombre, email, dni, telefono) "
                        + "VALUES(" + idtribunal + ", " + nombre + ", " + email + ", " + dni + " , " + telefono + ")";
                pstmt = conn.prepareStatement(sql);
                pstmt.executeUpdate();

                //Se recupera de la BD el registro recien insertado;                 
                Statement stmt = null;
                stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);
                String sqlRec = "SELECT * FROM tribunal WHERE ";
                sqlRec += " idtribunal=" + idtribunal;
                sqlRec += " and nombre='" + nombre + "'";
                sqlRec += " and email='" + email + "'";
                sqlRec += " and dni='" + dni + "'";
                sqlRec += " and telefono='" + telefono + "'";

                sqlRec += " ORDER BY id ascending";
                ResultSet rs = stmt.executeQuery(sqlRec);
                while (rs.next()) {
                    idtribunal = rs.getInt("idcandidato");
                    nombre = rs.getString("nombre");
                    email = rs.getString("email");
                    dni = rs.getString("dni");
                    telefono = rs.getString("telefono");
                    i = new Tribunal(idtribunal, nombre, email, dni, telefono);
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
}
