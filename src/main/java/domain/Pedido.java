
package domain;


public class Pedido {
    private int idPedido;
    private String fecha;
    private String estado;
    private String fechaEnvio;
    private int idCliente;
    private int idVendedor;

    public Pedido(int idPedido, String fecha, String estado, String fechaEnvio, int idCliente, int idVendedor) {
        this.idPedido = idPedido;
        this.fecha = fecha;
        this.estado = estado;
        this.fechaEnvio = fechaEnvio;
        this.idCliente = idCliente;
        this.idVendedor = idVendedor;
    }

    public Pedido(String fecha, String estado, String fechaEnvio, int idCliente, int idVendedor) {
        this.fecha = fecha;
        this.estado = estado;
        this.fechaEnvio = fechaEnvio;
        this.idCliente = idCliente;
        this.idVendedor = idVendedor;
    }

    public Pedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(String fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(int idVendedor) {
        this.idVendedor = idVendedor;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pedido{");
        sb.append("ID del pedido: ").append(idPedido);
        sb.append(", Fecha del pedido: ").append(fecha);
        sb.append(", Estado: ").append(estado);
        sb.append(", Fecha del Envio: ").append(fechaEnvio);
        sb.append(", ID del Cliente: ").append(idCliente);
        sb.append(", ID del Vendedor: ").append(idVendedor);
        sb.append('}' + "\n");
        return sb.toString();
    }

    
      
    
    
}
