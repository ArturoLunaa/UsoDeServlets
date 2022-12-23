
package datos;

import static datos.Conexion.close;
import static datos.Conexion.getConnection;
import domain.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ClienteDAO {
    private static final String SQL_SELECT = "SELECT id_cliente, nombre, apellidoP, apellidoM FROM cliente";
    private static final String SQL_INSERT = "INSERT INTO cliente(nombre, apellidoP, apellidoM) VALUES(?,?,?)";
    private static final String SQL_UPDATE = "UPDATE cliente SET nombre = ?, apellidoP = ?, apellidoM = ? WHERE id_cliente = ?";
    private static final String SQL_DELETE = "DELETE FROM cliente WHERE id_cliente = ?";
    
     public List<Cliente>seleccionar() throws ClassNotFoundException{
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cliente cliente = null;
        List<Cliente> clientes = new ArrayList<>();
        Class.forName("com.mysql.jdbc.Driver");
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                int idCliente = rs.getInt("id_cliente");
                String nombre= rs.getString("nombre");
                String apellidoP= rs.getString("apellidoP");
                String apellidoM= rs.getString("apellidoM");
                
                cliente = new Cliente(idCliente, nombre, apellidoP, apellidoM);
                
                clientes.add(cliente);
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
        return clientes;
    }
     
      public int insertar(Cliente cliente) throws ClassNotFoundException{
        Connection conn = null;
        PreparedStatement stmt = null;
        
        int registros = 0;
        Class.forName("com.mysql.jdbc.Driver");
        try {
         conn = getConnection();
         stmt = conn.prepareStatement(SQL_INSERT);
         stmt.setString(1, cliente.getNombre());
         stmt.setString(2, cliente.getApellidoP());
         stmt.setString(3, cliente.getApellidoM());
         
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
      
       public int actualizar(Cliente cliente) throws ClassNotFoundException{
        Connection conn = null;
        PreparedStatement stmt = null;
        Class.forName("com.mysql.jdbc.Driver");
        
        int registros = 0;
        
        try {
         conn = getConnection();
         stmt = conn.prepareStatement(SQL_UPDATE);
         
         stmt.setString(1,cliente.getNombre());
         stmt.setString(2, cliente.getApellidoP());
         stmt.setString(3,cliente.getApellidoM());
         stmt.setInt(4, cliente.getIdCliente());
         
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
       
       
        public int eliminar(Cliente cliente){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
       
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, cliente.getIdCliente());
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

