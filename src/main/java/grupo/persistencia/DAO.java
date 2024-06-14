package grupo.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract  class DAO {

    protected Connection conn = null;
    protected Statement stmt = null;
    protected ResultSet resultSet = null;
    protected PreparedStatement pstmt = null;

    protected final String DRIVER = "org.h2.Driver";
    protected final String URL = "jdbc:h2:tcp://localhost/~/test";
    protected final String USER = "Matias Castillo";
    protected final String PASS = "";

    protected  void conectarBase(){
        try {
            Class.forName(DRIVER);

            conn = DriverManager.getConnection(URL, USER, PASS);

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
    }

    protected void desconectarBase(){

        try {
            
            if (conn != null){
                conn.close();
            }
            if (stmt != null){
                stmt.close();
            }
            if (resultSet != null){
                resultSet.close();
            }
            if (pstmt != null){
                pstmt.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected void insertarModificarEliminar(String sql){

        conectarBase();
        try {

            stmt = conn.createStatement();

            stmt.executeUpdate(sql);

        } catch (Exception e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }finally{
            desconectarBase();
        }

    }

    protected void consultarBase(String sql){

        conectarBase();

        try {

            stmt = conn.createStatement();

            resultSet = stmt.executeQuery(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
