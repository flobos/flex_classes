/*
 * obj_tres_campos.java
 *
 * Created on 8 de julio de 2005, 05:17 PM
 */

package libreria;

/**
 *
 * @author  Esteban 
 */
import java.io.Serializable;

public class obj_tres_campos implements Serializable {
    
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String campo_uno;
   private String campo_dos;
   private String campo_tres;    
    
    /** Creates a new instance of obj_tres_campos */
    public obj_tres_campos(String campo_uno, String campo_dos, String campo_tres) {
        this.campo_uno = campo_uno;
        this.campo_dos = campo_dos;
        this.campo_tres = campo_tres;        
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
   public obj_tres_campos() {
   }          
}
