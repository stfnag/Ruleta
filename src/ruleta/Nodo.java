/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */package ruleta;

public class Nodo {
    private Nodo siguiente, anterior;
    private Persona participante;

    public Nodo getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }

    public Nodo() {
    }

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
