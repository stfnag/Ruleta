package ruleta;

import java.io.*;
import java.util.Scanner;

public class Lista {
    private Nodo cabeza, cola;
    private Integer participantes;

    public Lista() throws IOException {
    
    cabeza = null;
    cola = null;
    participantes = 0;
    this.cargarArchivo();
  }  
    
    private void cargarArchivo() throws IOException {
      Scanner file = new Scanner(new File("Jugadores.txt"));
            while(file.hasNextLine()){
                String [] datos;
                // nombre, apellido, edad, cedula
                datos = file.nextLine().split(";");
                Persona p = new Persona();
                p.setNombre(datos[0]);
                p.setApellido(datos[1]);
                p.setEdad(Integer.valueOf(datos[2]));
                p.setCedula(datos[3]);
                this.ingresar(p);
            }
    }
    
    private void guardarArchivo(Persona p, Boolean muerto) throws IOException {
    
        String archivo = "Perdedores.txt";
        if (!muerto) {
            archivo = "Ganador.txt";
        }
        
        try(FileWriter fw = new FileWriter(archivo, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {
            out.println(p.toString());
        } catch (IOException e) {
            //exception handling left as an exercise for the reader
        }
    
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
         cola = nodo;
       }
       
       this.participantes++;
    }
    
    public void eliminar(Nodo n) throws IOException {
        
      Nodo sig = n.getSiguiente(); 
                
      System.out.println("Eliminando a: " + n.getParticipante().getNombre());
      this.guardarArchivo(n.getParticipante(), Boolean.TRUE);
      this.participantes--;
    }
    
    public void jugar() throws IOException {
        Nodo aux = cabeza;        
        while (aux != null && this.participantes > 1) {
            
            if (!aux.getParticipante().getArma()) // aumenta un num, y dice si disparo o no en base al arreglo boolean
            {
            } else {
                Nodo aux2 = aux;
                this.eliminar(aux2);
            }
            aux = aux.getSiguiente();
        }
        
        this.guardarArchivo(aux.getParticipante(), Boolean.FALSE);
    }
 }
