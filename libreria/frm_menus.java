/*
 * frm_menus.java
 *
 * Created on 20 de julio de 2006, 10:00
 */

package libreria;

/**
 *
 * @author  lobo
 */

import java.util.ArrayList;
import java.sql.*;
public class frm_menus {
    
    
    /** Creates a new instance of frm_menus */
    public frm_menus() {
    }
    
    
        public static ArrayList<obj_dos_campos> llena_combo_menu_principal() {
      ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_menus_llena_combo_menu_principal}" ;
            CallableStatement ps = c.prepareCall(sql);
                                  
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos (rs.getString("men_pri_idn"), 
                                             rs.getString("men_pri_nombre")));
           
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
    
}
