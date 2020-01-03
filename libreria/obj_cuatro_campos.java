/*
 * obj_cuatro_campos.java
 *
 * Created on 13 de julio de 2005, 12:26 PM
 */

package libreria;

/**
 *
 * @author  Esteban 
 */
import java.io.Serializable;

public class obj_cuatro_campos implements Serializable {
    
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String campo_uno;
   private String campo_dos;
   private String campo_tres;    
   private String campo_cuatro;
    
    /** Creates a new instance of obj_tres_campos */
    public obj_cuatro_campos(String campo_uno, String campo_dos, String campo_tres, String campo_cuatro) {
        this.campo_uno = campo_uno;
        this.campo_dos = campo_dos;
        this.campo_tres = campo_tres;        
        this.campo_cuatro = campo_cuatro;        
    }
//***********************************************************************************************************    
   public String getcampo_uno() {
        return campo_uno;
   }

   public void setcampo_uno(String campo_uno) {
        this.campo_uno = campo_uno;
   }
//***********************************************************************************************************    
   public String getcampo_dos() {
        return campo_dos;
   }

   public void setcampo_dos(String campo_dos) {
        this.campo_dos = campo_dos;
   }    
//***********************************************************************************************************    
   public String getcampo_tres() {
        return campo_tres;
   }

   public void setcampo_tres(String campo_tres) {
        this.campo_tres = campo_tres;
   }     
//***********************************************************************************************************    
   public String getcampo_cuatro() {
        return campo_cuatro;
   }

   public void setcampo_cuatro(String campo_cuatro) {
        this.campo_cuatro = campo_cuatro;
   }       
//***********************************************************************************************************   
   public obj_cuatro_campos() {
   }          
}