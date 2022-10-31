package ruleta;
import java.math.*;
public class Revolver {
    private Integer balacargada, posiciongatillo;
    private Boolean cargado;
   
    public Revolver(){
        this.balacargada = (int)(Math.random()* 5 + 1);
        this.posiciongatillo = (int)(Math.random()* 5 + 1);
        this.cargado = true;
    }
    
    public boolean disparar(){
        if (!cargado) {
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






