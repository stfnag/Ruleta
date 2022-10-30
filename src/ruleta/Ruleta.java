package ruleta;
import java.io.IOException;
import java.util.Scanner;

public class Ruleta {

    static Scanner scanner = new Scanner (System.in);
    
    public static void main(String[] args) throws IOException {
        boolean salir = false;
        String opcion;
        
        while (!salir) {
        System.out.println("Bienvenido al juego de la Ruleta Rusa");
        System.out.println("En este juego uno de los jugadores tomara un revolver (puede ser de 5 o 6 cartuchos) y abrira el tambor. En el pondra uno o mas proyectiles. Luego gira el tambor al azar, cerrandolo rapidamente de modo que ninguno de los jugadores pueda ver en que recamara se encuentran los cartuchos.");
        System.out.println("1 - Iniciar partida");
        System.out.println("2 -Salir");

        System.out.println("Intoduce un numero: ");
        
        opcion = scanner.nextLine();
        switch(opcion){
            case "1" -> { 
                Lista lista = new Lista();
                lista.jugar();
                }
            case "2" -> { 
                System.out.println("Gracias por jugar, vuelva pronto");
                salir = true;
                }
            default -> {
                System.out.println("Opcion invalida, intentenlo nuevamente");
                System.out.println("--------------------------------------");
                }
            }
        } 
    }
}


