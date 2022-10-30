package ruleta;

import java.io.*;
import java.util.Scanner;

public class Lista {
    private Nodo cabeza, cola;
    private Integer participantes;
    private int partidas;

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
    
    private void guardarArchivoR(Persona p) throws IOException {
        Nodo aux = cabeza;
        if (aux.getSiguiente() != cabeza){
            String archivo = "Perdedores.txt";
            try(FileWriter fw = new FileWriter(archivo, true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw))
            {
                out.println(p.toString());
            } catch (IOException e) {
                //exception handling left as an exercise for the reader
            }
        }else{
            String archivo = "Ganador.txt";
            
            try(FileWriter fw = new FileWriter(archivo, true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw))
            {
                out.println(p.toString());
            } catch (IOException e) {
                //exception handling left as an exercise for the reader
            }
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
                
      System.out.println("Se ha eliminado a : " + n.getParticipante().getNombre());
      this.guardarArchivo(n.getParticipante(), Boolean.TRUE);
      this.participantes--;
    }
    
    public void mostrarJugadores(){
        Nodo aux = cabeza;
        do{
            if (aux.getParticipante().getVivo() == false){
                System.out.println(aux.getParticipante().getNombre() + ": Ha muerto" + " en la partida N: "+ aux.getParticipante().rondasJugadas);
            }else{
                System.out.println(aux.getParticipante().getNombre() + ": Ha sobrevivido");
            }
            
            
            aux = aux.getSiguiente();
        }while(aux != cabeza);
        
    }
    
    public void jugar() throws IOException {
        Nodo aux = cabeza;        
        while (aux != null && this.participantes > 1) {
            
            if (aux.getParticipante().isArma() == true) // aumenta un num, y dice si disparo o no en base al arreglo boolean
            {
                Nodo aux2 = aux;
                this.eliminar(aux2);
            } else {
            }
            aux = aux.getSiguiente();
        }
        
        this.guardarArchivo(aux.getParticipante(), Boolean.FALSE);
    }
    
    public void jugar2() throws IOException {
        Nodo aux = cabeza;
        //Nodo prev = null;
        do{
            
            if (aux.getParticipante().isArma() == true) // aumenta un num, y dice si disparo o no en base al arreglo boolean
            {
                aux.getParticipante().rondasJugadas ++;
                aux.getParticipante().setVivo(Boolean.FALSE);
                guardarArchivoR(aux.getParticipante());
                //Nodo aux2 = aux;
                //eliminarJugador(aux2);
            } else {
                aux.getParticipante().rondasJugadas ++;
                aux.getParticipante().setVivo(Boolean.TRUE);
            }
            //prev = aux;
            aux = aux.getSiguiente();
        }while(aux != cabeza ); //|| this.participantes > 1
        this.partidas ++;
        System.out.println("Partida N: "+ this.partidas);
        this.mostrarJugadores();
        System.out.println("Quieres avanzar a la otra partida");
        
        
    }
 }
