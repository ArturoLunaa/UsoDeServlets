
package domain;

public class Cliente extends Persona {
     private int idCliente;

    public Cliente(int idCliente, String nombre, String apellidoP, String apellidoM) {
        super(nombre, apellidoP, apellidoM);
        this.idCliente = idCliente;
    }

    public Cliente(String nombre, String apellidoP, String apellidoM) {
        super(nombre, apellidoP, apellidoM);
    }

    public Cliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cliente{");
        sb.append("ID del Cliente: ").append(idCliente);
        sb.append('}');
        sb.append(super.toString());
      
        return sb.toString();
    }

    
     
}
