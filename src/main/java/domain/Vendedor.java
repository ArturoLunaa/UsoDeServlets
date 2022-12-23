
package domain;

public class Vendedor extends Persona{
    private int idVendedor;

    public Vendedor(int idVendedor, String nombre, String apellidoP, String apellidoM) {
        super(nombre, apellidoP, apellidoM);
        this.idVendedor = idVendedor;
    }

    public Vendedor(String nombre, String apellidoP, String apellidoM) {
        super(nombre, apellidoP, apellidoM);
    }

    public Vendedor(int idCliente) {
        this.idVendedor = idCliente;
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
        sb.append("Vendedor{");
        sb.append("ID del Vendedor: ").append(idVendedor);
        sb.append('}');
        sb.append(super.toString());
        return sb.toString();
    }
    
    
}
