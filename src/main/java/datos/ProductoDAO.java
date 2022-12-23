
package datos;

import static datos.Conexion.close;
import static datos.Conexion.getConnection;
import domain.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author artur
 */
public class ProductoDAO {
    private static final String SQL_SELECT = "SELECT id_producto, nombre, tipo FROM producto";
    private static final String SQL_INSERT = "INSERT INTO producto(nombre, tipo) VALUES(?,?)";
    private static final String SQL_UPDATE = "UPDATE producto SET nombre = ?, tipo = ? WHERE id_producto = ?";
    private static final String SQL_DELETE = "DELETE FROM producto WHERE id_producto = ?";
    
     public List<Producto>seleccionar() throws ClassNotFoundException{
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Producto producto = null;
        List<Producto> productos = new ArrayList<>();
         Class.forName("com.mysql.jdbc.Driver");
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                int idProducto = rs.getInt("id_producto");
                String nombre= rs.getString("nombre");
                String tipo= rs.getString("tipo");
                
                producto = new Producto(idProducto, nombre, tipo);
                
                productos.add(producto);
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
        return productos;
    }
     
      public int insertar(Producto producto) throws ClassNotFoundException{
        Connection conn = null;
        PreparedStatement stmt = null;
        
        int registros = 0;
         Class.forName("com.mysql.jdbc.Driver");
        try {
         conn = getConnection();
         stmt = conn.prepareStatement(SQL_INSERT);
         stmt.setString(1,producto.getNombre());
         stmt.setString(2, producto.getTipo());
         
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
      
        public int actualizar(Producto producto) throws ClassNotFoundException{
        Connection conn = null;
        PreparedStatement stmt = null;
        
        int registros = 0;
         Class.forName("com.mysql.jdbc.Driver");
        try {
         conn = getConnection();
         stmt = conn.prepareStatement(SQL_UPDATE);
         
         stmt.setString(1,producto.getNombre());
         stmt.setString(2, producto.getTipo());
         stmt.setInt(3, producto.getIdProducto());
         
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
       
    
    public int eliminar(Producto producto) throws ClassNotFoundException{
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        Class.forName("com.mysql.jdbc.Driver");
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, producto.getIdProducto());
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
