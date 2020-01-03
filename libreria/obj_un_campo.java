/*
 * obj_un_campo.java
 *
 * Created on 27 de julio de 2005, 08:49 AM
 */

package libreria;

/**
 *
 * @author  Esteban 
 */
import java.io.Serializable;
public class obj_un_campo implements Serializable{
   
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String campo_uno;
    
    public obj_un_campo(String campo_uno) {
    
       this.campo_uno = campo_uno;     
    }
     
         
      public String getcampo_uno() {
        return campo_uno;
    }

    public void setcampo_uno(String campo_uno) {
        this.campo_uno = campo_uno;
    }

    /** Creates a new instance of obj_un_campo */
    public obj_un_campo() {
    }


	public obj_un_campo(int i) {
		this.campo_uno = String.valueOf(i);
	}


	
    
}
