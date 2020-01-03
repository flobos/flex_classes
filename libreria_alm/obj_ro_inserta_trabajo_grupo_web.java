/*
 * obj_ro_inserta_trabajo_grupo_web.java
 *
 * Created on 3 de octubre de 2005, 05:19 PM
 */

package libreria_alm;

/**
 *
 * @author  josephanter
 */
import java.io.Serializable;

public class obj_ro_inserta_trabajo_grupo_web implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String corre_idn;

    /** Creates a new instance of obj_ro_inserta_trabajo_grupo_web */
    public obj_ro_inserta_trabajo_grupo_web(String corre_idn) {
        this.corre_idn = corre_idn;

    }
    //////////////////////////////////////////////////////////////
    
    public String getresultado() {
        return corre_idn;
   }
    

   public void setresultado(String corre_idn) {
        this.corre_idn = corre_idn;
   } 

   


    /////////////////////////////////////////////////////////////
      public obj_ro_inserta_trabajo_grupo_web() {
      
    }
}
