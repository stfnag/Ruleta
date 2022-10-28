package ruleta;

public class Persona {
    private String Nombre, Apellido, Cedula;
    private Integer Edad;
    private Boolean vivo; 

    public Persona() {}

    public Boolean getVivo() {
        return vivo;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public String getCedula() {
        return Cedula;
    }

    public Integer getEdad() {
        return Edad;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public void setCedula(String Cedula) {
        this.Cedula = Cedula;
    }

    public void setVivo(Boolean vivo) {
        this.vivo = vivo;
    }
    
    public void setEdad(Integer Edad) {
        this.Edad = Edad;
    }
    
    
    
    
}
