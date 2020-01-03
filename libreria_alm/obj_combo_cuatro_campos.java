/*
 * obj_combo_cuatro_campos.java
 *
 * Created on 4 de mayo de 2006, 18:10
 */

package libreria_alm;

/**
 *
 * @author  Luis
 */
  import java.io.Serializable;
public class obj_combo_cuatro_campos implements Serializable {
    
    
   
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String data;
   private String data2;
    private String data3;
   private String label;
   
    public obj_combo_cuatro_campos(String data, String data2, String data3, String label) 
    {
        this.data= data;
        this.data2 = data2;
        this.data3 = data3;
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
    
     public String getdata3() {
        return data3;
    }

    public void setdata3(String data3) {
        this.data3 = data3;
    }
    
    
     public String getlabel() {
        return label;
    }

    public void setlabel(String label) {
        this.label = label;
    }
   
      
   

    /** Creates a new instance of obj_combo_cuatro_campos */
    public obj_combo_cuatro_campos() {
    }
    
}
