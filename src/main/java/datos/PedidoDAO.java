
package datos;

import static datos.Conexion.close;
import static datos.Conexion.getConnection;
import domain.Pedido;
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
public class PedidoDAO {
    private static final String SQL_SELECT = "SELECT id_pedido, fecha, estado, fechaEnvio, id_cliente, id_vendedor FROM pedido";
    private static final String SQL_INSERT = "INSERT INTO pedido(fecha, estado, fechaEnvio, id_cliente, id_vendedor) VALUES(?,?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE pedido SET fecha = ?, estado = ?, fechaEnvio = ?, id_cliente = ?, id_vendedor = ? WHERE id_pedido = ?";
    private static final String SQL_DELETE = "DELETE FROM pedido WHERE id_pedido = ?";
    
    public List<Pedido>seleccionar() throws ClassNotFoundException{
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Pedido pedido = null;
        List<Pedido> pedidos = new ArrayList<>();
        Class.forName("com.mysql.jdbc.Driver");
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                int idPedido = rs.getInt("id_pedido");
                String fecha= rs.getString("fecha");
                String estado= rs.getString("estado");
                String fechaEnvio= rs.getString("fechaEnvio");
                int id_cliente= rs.getInt("id_cliente");
                int id_vendedor= rs.getInt("id_vendedor");
                
                pedido = new Pedido(idPedido, fecha, estado, fechaEnvio, id_cliente, id_vendedor);
                
                pedidos.add(pedido);
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
        return pedidos;
    }
    
    public int insertar(Pedido pedido) throws ClassNotFoundException{
        Connection conn = null;
        PreparedStatement stmt = null;
        
        int registros = 0;
        Class.forName("com.mysql.cj.jdbc.Driver");
        try {
         conn = getConnection();
         stmt = conn.prepareStatement(SQL_INSERT);
         stmt.setString(1,pedido.getFecha());
         stmt.setString(2, pedido.getEstado());
         stmt.setString(3, pedido.getFechaEnvio());
         stmt.setInt(4, pedido.getIdCliente());
         stmt.setInt(5, pedido.getIdVendedor());
        
         
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
    
     public int actualizar(Pedido pedido) throws ClassNotFoundException{
        Connection conn = null;
        PreparedStatement stmt = null;
        
        int registros = 0;
        Class.forName("com.mysql.cj.jdbc.Driver");
        try {
         conn = getConnection();
         stmt = conn.prepareStatement(SQL_UPDATE);
         
         stmt.setString(1,pedido.getFecha());
         stmt.setString(2, pedido.getEstado());
         stmt.setString(3, pedido.getFechaEnvio());
         stmt.setInt(4, pedido.getIdCliente());
         stmt.setInt(5, pedido.getIdVendedor());
         stmt.setInt(6, pedido.getIdPedido());
         
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
     
        public int eliminar(Pedido pedido) throws ClassNotFoundException{
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
       Class.forName("com.mysql.cj.jdbc.Driver");
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, pedido.getIdPedido());
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
