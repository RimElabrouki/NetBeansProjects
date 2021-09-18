/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_DAO;

import ConexionBD.ConexionBD;
import entidades.Individual;
import entidades.Persona;
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
public class PersonaDAO {

    private Persona persona;
    private static Connection conn;

    public PersonaDAO() {
        conn = ConexionBD.establecerConexion();
    }

    public PersonaDAO(Persona p) {
        this.persona = p;
        conn = ConexionBD.establecerConexion();
    }

    public static Persona insertarPersona(Persona p) {
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;

                int idpersona = p.getIdpersona();
                String nombre = p.getNombre();
                String email = p.getEmail();
                String dni = p.getDni();
                String telefono = p.getTelefono();
                int idcandidato = p.getIdcandidato();

                String sql = "INSERT INTO persona(idpersona,nombre, email, dni, telefono,idcandidato) "
                        + "VALUES(" + idpersona + ",'" + nombre + "', '" + email + "','" + dni + "','" + telefono + "'," + idcandidato + ")";
                pstmt = conn.prepareStatement(sql);
                pstmt.executeUpdate();

                //Se recupera de la BD el registro recien insertado;                 
                Statement stmt = null;
                stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                String sqlRec = "SELECT * FROM persona WHERE ";
                sqlRec += " idpersona=" + idpersona;
                sqlRec += " and nombre='" + nombre + "'";
                sqlRec += " and email='" + email + "'";
                sqlRec += " and dni='" + dni + "'";
                sqlRec += " and telefono=" + telefono;
                sqlRec += " and idcandidato=" + idcandidato;
                sqlRec += " ORDER BY idpersona DESC";
                ResultSet rs = stmt.executeQuery(sqlRec);
                while (rs.next()) {
                    idpersona = rs.getInt("idpersona");
                    nombre = rs.getString("nombre");
                    email = rs.getString("email");
                    dni = rs.getString("dni");
                    telefono = rs.getString("telefono");
                    idcandidato = rs.getInt("idcandidato");
                    p = new Persona(idpersona, nombre, email, dni, telefono, idcandidato);
                    return p;
                }
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(CandidatoDAO.class.getName()).log(Level.SEVERE, null, ex);
                p = null;
            } finally {
                if (conn != null) {
                    ConexionBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(CandidatoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }

}
