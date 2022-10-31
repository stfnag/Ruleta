package ruleta;

public class Persona {
    private String Nombre, Apellido, Cedula;
    private Integer Edad, RondasJugadas;
    private Revolver Arma;
    private Boolean vivo;
 
    public Persona() {
     this.Arma = new Revolver(); 
     this.vivo = true;
     this.RondasJugadas = 0;
    }

    public Revolver getArma() {
        return Arma;
    }
    
    public void aumentarRondas() {
        this.RondasJugadas++;
    }

    public void setArma(Revolver Arma) {
        this.Arma = Arma;
    }

    public String getNombre() {
        return Nombre;
    }

    @Override
    public String toString() {
        return Nombre + "," + Apellido + "," + Cedula + "," + Edad;
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
    
    public void setEdad(Integer Edad) {
        this.Edad = Edad;
    }

    public Boolean getVivo() {
        return vivo;
    }

    public void setVivo(Boolean vivo) {
        this.vivo = vivo;
    }

    public int getRondasJugadas() {
        return RondasJugadas;
    }

}