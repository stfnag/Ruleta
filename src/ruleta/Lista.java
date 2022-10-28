/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ruleta;

/**
 *
 * @author estef
 */
public class Lista {
    private Nodo cabeza, cola;

    public Lista() {
    
    cabeza = null;
    cola = null;
  }  
    public void ingresar(Persona p){
       
       Nodo nodo = new Nodo();
       nodo.setParticipante(p);
               
       if(cabeza==null) {
           cabeza = nodo;
           cabeza.setSiguiente(cabeza);
           cola = cabeza;
           
       }else{
         cola.setSiguiente(nodo);
         nodo.setSiguiente(cabeza);
         nodo.setAnterior(cola);
         cola = nodo;
         cabeza.setAnterior(cola);
       }
    }
    
    
}
