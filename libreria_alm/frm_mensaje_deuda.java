/*
 * frm_mensaje_deuda.java
 *
 * Created on 26 de septiembre de 2006, 10:15
 */

package libreria_alm;


import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author  lobo
 */
public class frm_mensaje_deuda {
    
    /** Creates a new instance of frm_mensaje_deuda */
    public frm_mensaje_deuda() {
    }
    
    
     public static ArrayList<obj_siete_campos> muestra_mensaje_deuda (String idn_alumno) {
      ArrayList<obj_siete_campos> lista = new ArrayList<obj_siete_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_mensaje_deuda (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,idn_alumno.trim());
            
                      
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
      
            lista.add(new obj_siete_campos (rs.getString("mal_nombre"), 
                                             rs.getString("dat_pag_ano"), 
                                             rs.getString("cuotas"),
                                             rs.getString("valor"), 
                                             rs.getString("dia"),
                                             rs.getString("mes"),
                                             rs.getString("año")));
                                           
           
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
