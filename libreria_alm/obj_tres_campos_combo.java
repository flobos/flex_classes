/*
 * obj_dos_campos.java
 *
 * Created on 21 de junio de 2005, 16:30
 */

package libreria_alm;

/**
 *
 * @author  Fernando Lobos
 */

import java.io.Serializable;
public class obj_tres_campos_combo implements Serializable{
   
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String data;
   private String label;
    private String campo_uno;
   
    public obj_tres_campos_combo(String data, String label, String campo_uno) {
    
       this.data= data;
       this.label = label;
       this.campo_uno = campo_uno;
    }
     
         
      public String getdata() {
        return data;
    }

    public void setdata(String data) {
        this.data = data;
    }
    
     public String getlabel() {
        return label;
    }

    public void setlabel(String label) {
        this.label = label;
    }
    
   public String getcampo_uno() {
        return campo_uno;
    }

    public void setcampo_uno(String campo_uno) {
        this.campo_uno = campo_uno;
    }
   
      
   
    /** Creates a new instance of obj_dos_campos */
    public obj_tres_campos_combo() {
    }
    
}