/*
 * obj_un_campo.java
 *
 * Created on 12 de julio de 2005, 18:14
 */

package libreria_alm;

/**
 *
 * @author  Fernando Lobos
 */
import java.io.Serializable;

public class obj_un_campo implements Serializable {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int valor;
 
    
    public obj_un_campo(int valor) {

        this.valor=valor;
        
   }
    
    public int getvalor() {
        return valor;
    }

    public void setvalor(int valor) {
        this.valor = valor;
    }
    
    public obj_un_campo() {
    }
    
    
    
}
