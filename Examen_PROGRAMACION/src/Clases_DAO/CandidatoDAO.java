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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rim
 */
public class CandidatoDAO {

    private Candidato candidato;
    private static Connection conn;

    public CandidatoDAO() {
        conn = ConexionBD.establecerConexion();
    }

    public CandidatoDAO(Candidato c) {
        this.candidato = c;
        conn = ConexionBD.establecerConexion();
    }

    public static Candidato insertarCandidato(Candidato c) {
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                int idcandidato = c.getIdcandidato();
                String nombre = c.getNombre();
                String ciudad = c.getCiudad();
                Date fechainscripcion = c.getFechainscripcion();
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                String mysqlDateString = formatter.format(fechainscripcion);
                boolean finalista = c.getFinalista();
                int idcategoria = c.getIdcategoria();
                int idaudicion = c.getIdaudicion();
                String sql = "INSERT INTO candidato(idcandidato,nombre, ciudad, fechainscripcion,Finalista,idcategoria,idaudicion) "
                        + "VALUES(" + idcandidato + ",'" + nombre + "', '" + ciudad + "','" + mysqlDateString + "'," + finalista + "," + idcategoria + "," + idaudicion + ")";
                pstmt = conn.prepareStatement(sql);
                pstmt.executeUpdate();

                //Se recupera de la BD el registro recien insertado;                 
                Statement stmt = null;
                stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);
                String sqlRec = "SELECT * FROM candidato WHERE ";
                sqlRec += " idcandidato=" + idcandidato;
                sqlRec += " and nombre='" + nombre + "'";
                sqlRec += " and ciudad='" + ciudad + "'";
                sqlRec += " and fechainscripcion='" + mysqlDateString + "'";
                sqlRec += " and finalista=" + finalista;
                sqlRec += " and idcategoria=" + idcategoria;
                sqlRec += " and idaudicion=" + idaudicion;
                sqlRec += " ORDER BY idcandidato DESC";
                ResultSet rs = stmt.executeQuery(sqlRec);
                while (rs.next()) {
                    idcandidato = rs.getInt("idcandidato");
                    nombre = rs.getString("nombre");
                    ciudad = rs.getString("ciudad");
                    fechainscripcion = rs.getDate("fechainscripcion");
                    finalista = rs.getBoolean("finalista");
                    idcategoria = rs.getInt("idcategoria");
                    idaudicion = rs.getInt("idaudicion");
                    c = new Candidato(idcandidato, nombre, ciudad, fechainscripcion, finalista, idcategoria, idaudicion);
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

    public static int getLastId() {
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                String sql = "SELECT idcandidato FROM candidato ORDER BY idcandidato DESC LIMIT 1";
                pstmt = conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    int idcandidato = rs.getInt("idcandidato");
                    return idcandidato;
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
            Logger.getLogger(CandidatoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    /*
Luego, realizar una consulta para seleccionar todas las candidatos 
cuyo estado sea 3 (“desarrollo”) y
    muestre por la salida estándar, 
para cada una de ellas, el idcandidato, la ciudad así
como el nombre del candidati individual que la registró y el nombre del candidatos de groupo que la gestiona.  
     */
    public void seleccionarCandidatos() {
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                pstmt = conn.prepareStatement("SELECT i.idcandidato, i.ciudad, t.tnombre, g.gnombre FROM candidato i, individual t, grupo g WHERE i.idcandidato= t.idcandidato and i.idcandidato = g.idcandidato ORDER BY i.candidato AS");
                ResultSet prs = pstmt.executeQuery();
                while (prs.next()) {
                    int id = prs.getInt("idcandidato");
                    String ciudad = prs.getString("ciudad");
                    String tnombre = prs.getString("tnombre");
                    String gnombre = prs.getString("gnombre");
                    System.out.println("Candidato id=" + id + ", ciudad=" + ciudad + ", Individual=" + tnombre + ", Grupo=" + gnombre + "\n");
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
            Logger.getLogger(CandidatoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Candidato> filtrarCandidatosPorCiudad(String ciu) {
        ArrayList<Candidato> candidatos = new ArrayList<Candidato>();
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                String sql;
                Statement stmt = null;
                stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

                sql = "SELECT * FROM candidatos WHERE ciudad LIKE '" + ciu + "'";
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    int idcandidato = rs.getInt("idcandidato");
                    String nombre = rs.getString("nombre");
                    String ciudad = rs.getString("ciudad");
                    Candidato c = new Candidato(idcandidato, nombre, ciudad);
                    candidatos.add(c);
                }
                rs.close();
                stmt.close();

            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(CandidatoDAO.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (conn != null) {
                    ConexionBD.cerrarConexion();
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(CandidatoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return candidatos;
    }



    public HashMap<String, String> buscarCandidatos_Finalistas() {
        HashMap<String, String> ret = new HashMap<String, String>();
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                pstmt = conn.prepareStatement("SELECT idcandidato, nombre, ciudad FROM Candidato");
ResultSet prs = pstmt.executeQuery();
                while (prs.next()) {
                    int idcandidato = prs.getInt("id");
                    String nombre = prs.getString("nombre");
                    String ciudad = prs.getString("ciudad");
                    ret.put(nombre, ciudad);
                }
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(CandidatoDAO .class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                if (conn != null) {
                    ConexionBD.cerrarConexion();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CandidatoDAO .class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }
}
