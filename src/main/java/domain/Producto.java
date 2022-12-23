
package domain;

public class Producto {
    private int idProducto;
    private String nombre;
    private String tipo;

    public Producto(){
        
    }
     public Producto(int idProducto){
        this.idProducto = idProducto;
    }
    
    public Producto(int idProducto, String nombre, String tipo) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public Producto(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Producto{");
        sb.append("ID del Producto: ").append(idProducto);
        sb.append(", Nombre: ").append(nombre);
        sb.append(", Tipo: ").append(tipo);
        sb.append('}' + "\n");
        return sb.toString();
    }
    
    
    
    
}
