package ruleta;
import java.math.*;
public class Revolver {
    private int balacargada, posiciongatillo;
    private boolean disparo;
   
    public Revolver(){
        balacargada = (int)(Math.random()* 6 + 1);
        posiciongatillo = (int)(Math.random()* 6 + 1);
    }
    
    public boolean disparar(){
        if (balacargada == posiciongatillo){
            disparo = true;
            if(balacargada ==6){
                balacargada = 1;
            }else{
                balacargada ++;
            }
        }else{
            disparo = false;
            if(balacargada ==6){
                balacargada = 1;
            }else{
                balacargada ++;
            }
        }        
        return disparo;
    }
    
    
   
}






