/*
 * obj_siete_campos.java
 *
 * Created on 8 de julio de 2005, 05:47 PM
 */

package libreria_alm;

/**
 *
 * @author  Esteban 
 */
import java.io.Serializable;

public class obj_seis_campos implements Serializable {
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String campo_uno;
   private String campo_dos;
   private String campo_tres;
   private String campo_cuatro;
   private String campo_cinco;
   private String campo_seis;
       
    /** Creates a new instance of obj_siete_campos */
    public obj_seis_campos(String campo_uno
                            , String campo_dos
                            , String campo_tres
                            , String campo_cuatro
                            , String campo_cinco
                            , String campo_seis) {
                                
        this.campo_uno = campo_uno;
        this.campo_dos = campo_dos;
        this.campo_tres = campo_tres;                                   
        this.campo_cuatro = campo_cuatro;
        this.campo_cinco = campo_cinco;
        this.campo_seis = campo_seis;           
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
   public String getcampo_cinco() {
        return campo_cinco;
   }

   public void setcampo_cinco(String campo_cinco) {
        this.campo_cinco = campo_cinco;
   }    
//***********************************************************************************************************    
   public String getcampo_seis() {
        return campo_seis;
   }

   public void setcampo_seis(String campo_seis) {
        this.campo_seis = campo_seis;
   }       
//***********************************************************************************************************   
   public obj_seis_campos() {
   }       
}
