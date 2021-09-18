package ClasesDAO;

import ConexionBD.ConexionBD;
import entidades.Candidato;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import static jdk.nashorn.internal.runtime.Debug.id;

/**
 *
 * @author Rim 
 */
public class CandidatoDAO {

    private Candidato cadidato;
    private static Connection conn;

    public CandidatoDAO() {
        conn = ConexionBD.establecerConexion();
    }

    public CandidatoDAO(Candidato c) {
        this.cadidato = c;
        conn = ConexionBD.establecerConexion();
    }

    public Candidato insertarCandidato(Candidato c) {
        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }
            try {
                PreparedStatement pstmt = null;
                int idcandidato = c.getIdaudicion();
                String nombre = c.getNombre();
                String ciudad = c.getCiudad();
                Date fechainscripcion = c.getFechainscripcion();
                int idCategoria = c.
                boolean finalista = c.getFinalista();
                String 
                String sql = "INSERT INTO candidatos(idaudicion, nombre, ciudad, fechainscripcion,Finalista) "
                        + "VALUES(" + idcandidato + ", " + nombre + ", " + ciudad + ",'" + fechainscripcion + ",'" + finalista + "')";
                pstmt = conn.prepareStatement(sql);
                pstmt.execute();

                //Se recupera de la BD el registro recien insertado;                 
                Statement stmt = null; 
                stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);
                String sqlRec = "SELECT * FROM candidatos WHERE ";
                sqlRec += " idaudicion=" + idcandidato;
                sqlRec += " and nombre='" + nombre + "'";
                sqlRec += " and ciudad=" + ciudad + "";
                sqlRec += " and fechainscripcion=" + fechainscripcion;
                sqlRec += " and finalista=" + finalista;
                sqlRec += " ORDER BY id DESC";
                ResultSet rs = stmt.executeQuery(sqlRec);
                while (rs.next()) {
                    idcandidato = rs.getInt("idcandidato");
                    nombre = rs.getString("nombre");
                    ciudad = rs.getString("ciudad");
                    fechainscripcion = rs.getDate("fechainscripcion");
                    finalista = rs.getBoolean("finalista");

                    c = new Candidato(idcandidato, nombre, ciudad, fechainscripcion, finalista);
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

