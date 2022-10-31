package ruleta;

public class Nodo {
    private Nodo siguiente,anterior;

    public Nodo getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }
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
