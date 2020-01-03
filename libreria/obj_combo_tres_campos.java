/*
 * obj_combo_tres_campos.java
 *
 * Created on 19 de diciembre de 2005, 09:38 AM
 */

package libreria;

/**
 *
 * @author  Esteban
 */
import java.io.Serializable;
public class obj_combo_tres_campos implements Serializable{
   
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String data;
   private String data2;
   private String label;
   
    public obj_combo_tres_campos(String data, String data2, String label) 
    {
        this.data= data;
        this.data2 = data2;
        this.label = label;
    }
     
         
    public String getdata() {
        return data;
    }

    public void setdata(String data) {
        this.data = data;
    }    
    
    public String getdata2() {
        return data2;
    }

    public void setdata2(String data2) {
        this.data2 = data2;
    }
    
     public String getlabel() {
        return label;
    }

    public void setlabel(String label) {
        this.label = label;
    }
   
      
   
    /** Creates a new instance of obj_combo_tres_campos */
    public obj_combo_tres_campos() {
    }
    
}
