package ConexionBD;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rim
 */
public class ConexionBD {

    static final String DB_URL = "jdbc:mysql://localhost:3306/concurso";
    // Credenciales de la base de datos
    static final String USER = "root";
    static final String PASS = "1234";

    static Connection conn = null;
    Statement stmt = null;
    PreparedStatement pstmt = null;

    public static Connection establecerConexion() {
        try {
            System.out.println("Conectando a la Base de Datos...");
            //conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        //A value of 0 indicates a timeout is not applied to thedatabase operation. 
             if(conn.isValid(0)){
                System.out.println("Connection successfully");
            }else{
                System.out.println("Connection not Valid");
            }
        } catch (SQLException ex) {
            System.out.println("Se ha producido una SQLException:" + ex.getMessage());
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            System.out.println("Se ha producido una ClassNotFoundException:" + ex.getMessage());
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return conn;
        }
    }

    public static void cerrarConexion() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                System.out.println("Se ha producido una SQLException:" + ex.getMessage());
                Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

   
}







