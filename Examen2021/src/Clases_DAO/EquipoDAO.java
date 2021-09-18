/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases_DAO;

import Connexion.ConexionBD;
import examen2021.Equipo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Rim
 */
public class EquipoDAO {
    private Equipo p;
    private static Connection conn;

    public Equipo insertarEvento(Equipo e) {

        try {
            if (conn == null || conn.isClosed()) {
                conn = ConexionBD.establecerConexion();
            }

            try {
                PreparedStatement pstmt = null;
                int idequipo = p.getIdequipo();
                int ram = p.getRam();
                String so = p.getSo();
                int discoduro = p.getDiscoduro();

                Statement st = conn.createStatement();

                String sql = "INSERT INTO Eventos (id,idequipo, ram, so, discduro ) "
                        + "VALUES ('" + idequipo + "', '" + ram + "', '" + so + "', '" + discoduro + "')";
                pstmt = conn.prepareStatement(sql);
                pstmt.executeUpdate();

                Statement stmt = null;
                stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                String sqlRec = "SELECT * FROM incidencias WHERE ";
                sqlRec += " idequipo'" + idequipo + "'";
                sqlRec += " and ram='" + ram + "'";
                sqlRec += " and so='" + so + "'";
                sqlRec += " and discoduro ='" + discoduro + "'";
                ResultSet rs = stmt.executeQuery(sqlRec);

                while (rs.next()) {
                    idequipo = rs.getInt("idequipo");
                    ram = rs.getInt("ram");
                    so = rs.getString("so");
                    discoduro = rs.getInt("discoduro");

                    e = new Equipo(idequipo, ram, so, discoduro);
                    return e;
                }
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
            } finally {
                if (conn != null) {
                    ConexionBD.cerrarConexion();
                }
            }
        } catch (SQLException ex) {
            System.out.println("Se ha producido una SQLException:" + ex.getMessage());
        }
        return p;
    }

    
}
