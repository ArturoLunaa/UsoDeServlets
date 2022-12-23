
package datos;

import static datos.Conexion.close;
import static datos.Conexion.getConnection;
import domain.Vendedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VendedorDAO {
    private static final String SQL_SELECT = "SELECT id_vendedor, nombre, apellidoP, apellidoM FROM vendedor";
    private static final String SQL_INSERT = "INSERT INTO vendedor(nombre, apellidoP, apellidoM) VALUES(?,?,?)";
    private static final String SQL_UPDATE = "UPDATE vendedor SET nombre = ?, apellidoP = ?, apellidoM = ? WHERE id_vendedor = ?";
    private static final String SQL_DELETE = "DELETE FROM vendedor WHERE id_vendedor = ?";
    
    public List<Vendedor>seleccionar() throws ClassNotFoundException{
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Vendedor vendedor = null;
        List<Vendedor> vendedores = new ArrayList<>();
         Class.forName("com.mysql.cj.jdbc.Driver");
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                int idVendedor = rs.getInt("id_vendedor");
                String nombre= rs.getString("nombre");
                String apellidoP= rs.getString("apellidoP");
                String apellidoM= rs.getString("apellidoM");
                
                vendedor = new Vendedor(idVendedor, nombre, apellidoP, apellidoM);
                
                vendedores.add(vendedor);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            try{
            close(rs);
            close(stmt);
            close(conn);
            }catch(SQLException ex){
                ex.printStackTrace(System.out);
            }
        }
        return vendedores;
    }
    
     public int insertar(Vendedor vendedor) throws ClassNotFoundException{
        Connection conn = null;
        PreparedStatement stmt = null;
        
        int registros = 0;
         Class.forName("com.mysql.cj.jdbc.Driver");
        try {
         conn = getConnection();
         stmt = conn.prepareStatement(SQL_INSERT);
         stmt.setString(1,vendedor.getNombre());
         stmt.setString(2, vendedor.getApellidoP());
         stmt.setString(3,vendedor.getApellidoM());
         
         registros = stmt.executeUpdate();//actualiza el registro que se creo en la db que iba vacio
         
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
     
     public int actualizar(Vendedor vendedor) throws ClassNotFoundException{
        Connection conn = null;
        PreparedStatement stmt = null;
        
        int registros = 0;
         Class.forName("com.mysql.cj.jdbc.Driver");
        try {
         conn = getConnection();
         stmt = conn.prepareStatement(SQL_UPDATE);
         
         stmt.setString(1,vendedor.getNombre());
         stmt.setString(2, vendedor.getApellidoP());
         stmt.setString(3,vendedor.getApellidoM());
         stmt.setInt(4, vendedor.getIdVendedor());
         
         registros = stmt.executeUpdate();//actualiza el registro que se creo en la db que iba vacio
         
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
     
     public int eliminar(Vendedor vendedor) throws ClassNotFoundException{
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        Class.forName("com.mysql.cj.jdbc.Driver");
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, vendedor.getIdVendedor());
            registros = stmt.executeUpdate();
            
        } catch (SQLException ex) {
               ex.printStackTrace(System.out);
        }
        finally{
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
       return registros;
    }
}
