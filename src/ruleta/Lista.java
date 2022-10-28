package ruleta;

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
    
    public void eliminar(Nodo n){
        
      Nodo sig = n.getSiguiente(); 
      Nodo ant = n.getAnterior();
                
      sig.setAnterior(ant);
      ant.setSiguiente(sig);

    }
 }
