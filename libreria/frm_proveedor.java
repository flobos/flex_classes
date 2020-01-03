/*
 * frm_proveedor.java
 *
 * Created on 4 de agosto de 2009, 11:54 AM
 */

/**
 *
 * @author  Administrador
 */
package libreria;
import java.util.ArrayList;
import java.io.Serializable;
import java.sql.*;

public class frm_proveedor {
    
    /** Creates a new instance of frm_proveedor */
    //***********************************************************************************************************      
    
public static ArrayList<Serializable> muestra_region() {
      ArrayList<Serializable> lista = new ArrayList<Serializable>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call  frm_proveedor_muestra_region}" ;
            CallableStatement ps = c.prepareCall(sql);
                                          
            ResultSet rs = ps.executeQuery();
            
          lista.add(new obj_combo_tres_campos ("0", "0", "-- Seleccione --"));
          
            while (rs.next()){
            
      
            lista.add(new obj_combo_dos_campos (rs.getString("reg_idn"), 
                                                rs.getString("reg_nombre")));
           
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
         return lista;
   }
//***********************************************************************************************************   
    
    
    
    public frm_proveedor() {
    }
    
}
