package ruleta;
import java.math.*;
public class Revolver {
    private int balacargada, posiciongatillo;
    private boolean cargado;
   
    public Revolver(){
        balacargada = (int)(Math.random()* 5 + 1);
        posiciongatillo = (int)(Math.random()* 5 + 1);
        this.cargado = true;
    }
    
    public boolean disparar(){
        if (!this.cargado) {
            return false;
        }
        
        if (this.posiciongatillo >= 6) {
            this.posiciongatillo = 0;
        }
        
        if (balacargada == posiciongatillo) {
            this.cargado = false;
            
            return true;
        }
        
        this.posiciongatillo++;
        return false;
    }
    
    
   
}






