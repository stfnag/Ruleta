package ruleta;

public class Persona {
    private String Nombre, Apellido, Cedula;
    private Integer Edad;
    private Boolean Arma;
 
    public Persona() {
     Revolver revolver = new Revolver(); 
     this.Arma = revolver.disparar();// genera 1 integer al azar entre 1 a 6
    }
    public boolean isArma() {
        return Arma;
    }

    public String getNombre() {
        return Nombre;
    }

    @Override
    public String toString() {
        return Nombre + "," + Apellido + "," + Cedula + "," + Edad + ",";
    }

    public void setArma(Boolean Arma) {
        this.Arma = Arma;
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
    
    
    
    
}