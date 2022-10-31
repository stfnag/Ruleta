package ruleta;

import java.io.*;
import java.util.Scanner;

public class Lista {
    private Nodo cabeza;
    private Integer participantes, partidas;

    public Lista() throws IOException {
    
    cabeza = null;
    participantes = 0;
    this.partidas = 1;
    this.reiniciarArchivos();
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
    
    private void reiniciarArchivos() throws IOException {
        try(FileWriter fw = new FileWriter("Perdedores.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {
            out.println();
        } catch (IOException e) {
            //exception handling left as an exercise for the reader
        }
        
         try(FileWriter fw = new FileWriter("Ganador.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {
            out.println();
        } catch (IOException e) {
            //exception handling left as an exercise for the reader
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
            nodo.setSiguiente(nodo);
            nodo.setAnterior(nodo);            
            cabeza = nodo;
        } else {
            Nodo ultimo = cabeza.getAnterior();
            nodo.setSiguiente(cabeza);
            nodo.setAnterior(ultimo);
            cabeza.setAnterior(nodo);
            ultimo.setSiguiente(nodo);
        }
       
       this.participantes++;
    }
    
    public void eliminar(Nodo n) throws IOException {
        if (n == cabeza) {
                if (this.participantes == 1) {
                    this.cabeza =null;
                } else {
                    Nodo ultimo= cabeza.getAnterior();    
                    cabeza = cabeza.getSiguiente();
                    ultimo.setSiguiente(cabeza);
                    cabeza.setAnterior(ultimo);
                } 
            } else {
                Nodo aux = cabeza;
                while (aux != n) {
                    aux = aux.getSiguiente();
                }
                
                Nodo anterior = aux.getAnterior();
                aux = aux.getSiguiente();
                anterior.setSiguiente(aux);
                aux.setAnterior(anterior);
            }
                
      this.guardarArchivo(n.getParticipante(), Boolean.TRUE);
      this.participantes--;
      System.out.println("Se ha eliminado a : " + n.getParticipante().getNombre());
    }
    
    public void mostrarJugadores(){
        Nodo aux = cabeza;
        
        do{
            if (!aux.getParticipante().getVivo()){
                System.out.println(aux.getParticipante().getNombre() + ": Ha muerto" + " en la partida N: "+ aux.getParticipante().rondasJugadas);
            }else{
                System.out.println("El Ganador ha sido : " + aux.getParticipante().getNombre());
            }
            
            aux = aux.getSiguiente();
        }while(aux != cabeza);
        
    }
    
    public void jugar2() throws IOException {
        Nodo aux = cabeza;        
        
        while (this.participantes > 1) {
            //this.mostrarJugadores();
            if (aux.getParticipante().getArma().disparar()) // aumenta un num, y dice si disparo o no en base al arreglo boolean
            {
                aux.getParticipante().rondasJugadas ++;
                aux.getParticipante().setVivo(Boolean.FALSE);
                this.eliminar(aux);
            }
            aux = aux.getSiguiente();
        }
        
        this.guardarArchivo(aux.getParticipante(), Boolean.FALSE);
        this.mostrarJugadores();
        
        System.out.println("Quieres jugar otra partida?");
        System.out.println("1 - Si");
        System.out.println("2 - Salir del juego");
    }
 }
