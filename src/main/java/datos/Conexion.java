
package datos;

import java.sql.*;


public class Conexion {
    private static final String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/SegundoParcial?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "lgja010306mys";
    
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(JDBC_URL,JDBC_USER, JDBC_PASSWORD);
    }
    
    //ResultSet devuelve los valores
    public static void close(ResultSet rs) throws SQLException{
        rs.close();
    }
    //Statement ejecuta la instrucción
    public static void close(Statement stmt) throws SQLException{
        stmt.close();
    }
    //PreparedStatement guarda la conexión
    public static void close(PreparedStatement stmt) throws SQLException{
        stmt.close();
    }
    //Connection guarda y abre la conexión
    public static void close(Connection conn)throws SQLException{
        conn.close();
    }
}
