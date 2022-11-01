package ruleta;

public class Persona {
    private String Nombre, Apellido, N_jugador;
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
        return Nombre + "," + Apellido + "," + Edad + "," + N_jugador;
    }
    
    public String getApellido() {
        return Apellido;
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

    public String getN_jugador() {
        return N_jugador;
    }

    public void setN_jugador(String N_jugador) {
        this.N_jugador = N_jugador;
    }

    public void setRondasJugadas(Integer RondasJugadas) {
        this.RondasJugadas = RondasJugadas;
    }
    

}