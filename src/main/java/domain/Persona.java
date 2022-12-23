
package domain;

public class Persona {
    private static int contador = 0;
    private int idPersona;
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    
    //Constructores
    public Persona(){
        
    }
    public Persona(int idPersona){
        this.idPersona = idPersona;
    }
    
    public Persona(String nombre, String apellidoP, String apellidoM){
        super();
        this.nombre = nombre;
        this.apellidoP = apellidoP;
         this.apellidoM = apellidoM;
        this.idPersona = getContador();
    }

    public Persona(int idPersona, String nombre, String apellidoP, String apellidoM) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
    }

    public int getContador() {
        contador++;
        return contador;
    }
    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }


    
     //el string builder hace un append en lugar de un return + cadena etc
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Persona{");
        sb.append("Nombre: ").append(nombre);
        sb.append(", Apellido Paterno: ").append(apellidoP);
        sb.append(", Apellido Materno: ").append(apellidoM);
        sb.append('}' + "\n");
        return sb.toString();
    }
    
}
