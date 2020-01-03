/*
 * prueba.java
 *
 * Created on 16 de junio de 2009, 10:34 AM
 */

package libreria;
import java.util.*;
/**
 *
 * @author  Administrador
 */
public class prueba {
    
    /** Creates a new instance of prueba */
    public prueba() {
    }
    
    public static ArrayList<obj_un_campo> hola(String variable) 
    {
        ArrayList<obj_un_campo> lista = new ArrayList<obj_un_campo>();

        lista.add(new obj_un_campo ("Hola " + variable));

        return lista;
   }  
    
}
