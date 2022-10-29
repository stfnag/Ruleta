package ruleta;

public class Nodo {
    private Nodo siguiente;
    private Persona participante;

    public Nodo getSiguiente() {
        return siguiente;
    }

    public Persona getParticipante() {
        return participante;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public void setParticipante(Persona participante) {
        this.participante = participante;
    }   
}
