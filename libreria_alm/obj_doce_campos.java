/*
 * obj_doce_campos.java
 *
 * Created on 8 de julio de 2005, 06:19 PM
 */

package libreria_alm;

/**
 *
 * @author  CMEDINA 
 */
import java.io.Serializable;

public class obj_doce_campos implements Serializable {
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
   private String campo_siete;
   private String campo_ocho;
   private String campo_nueve;
   private String campo_diez;
   private String campo_once;   
   private String campo_doce; 
       
    /** Creates a new instance of obj_siete_campos */
    public obj_doce_campos(String campo_uno
                            , String campo_dos
                            , String campo_tres
                            , String campo_cuatro
                            , String campo_cinco
                            , String campo_seis
                            , String campo_siete
                            , String campo_ocho
                            , String campo_nueve
                            , String campo_diez
                            , String campo_once
                            , String campo_doce) {
                                
        this.campo_uno = campo_uno;
        this.campo_dos = campo_dos;
        this.campo_tres = campo_tres;                                   
        this.campo_cuatro = campo_cuatro;
        this.campo_cinco = campo_cinco;
        this.campo_seis = campo_seis;           
        this.campo_siete = campo_siete;    
        this.campo_ocho = campo_ocho;
        this.campo_nueve = campo_nueve;
        this.campo_diez = campo_diez;           
        this.campo_once = campo_once;       
        this.campo_doce = campo_doce; 
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
   public String getcampo_siete() {
        return campo_siete;
   }

   public void setcampo_siete(String campo_siete) {
        this.campo_siete = campo_siete;
   }     
//***********************************************************************************************************    
   public String getcampo_ocho() {
        return campo_ocho;
   }

   public void setcampo_ocho(String campo_ocho) {
        this.campo_ocho = campo_ocho;
   }
//***********************************************************************************************************    
   public String getcampo_nueve() {
        return campo_nueve;
   }

   public void setcampo_nueve(String campo_nueve) {
        this.campo_nueve = campo_nueve;
   }    
//***********************************************************************************************************    
   public String getcampo_diez() {
        return campo_diez;
   }

   public void setcampo_diez(String campo_diez) {
        this.campo_diez = campo_diez;
   }     
//***********************************************************************************************************    
   public String getcampo_once() {
        return campo_once;
   }

   public void setcampo_once(String campo_once) {
        this.campo_once = campo_once;
   }      
 //***********************************************************************************************************    
   public String getcampo_doce() {
        return campo_doce;
   }

   public void setcampo_doce(String campo_doce) {
        this.campo_doce = campo_doce;
   }      
//***********************************************************************************************************   
   public obj_doce_campos() {
   }       
}