/*
 * obj_combo_dos_campos.java
 *
 * Created on 21 de junio de 2005, 16:30
 */

package libreria_alm;

/**
 *
 */

import java.io.Serializable;
public class obj_combo_dos_campos implements Serializable{
   
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String data;
   private String label;
   
    public obj_combo_dos_campos(String data, String label) {
    
       this.data= data;
       this.label = label;
        
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
   
      
   
    /** Creates a new instance of obj_dos_campos */
    public obj_combo_dos_campos() {
    }
    
}
