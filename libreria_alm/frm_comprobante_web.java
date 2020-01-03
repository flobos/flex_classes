/*
 * frm_comprobante_web.java
 *
 * Created on 26 de enero de 2006, 11:45
 */

package libreria_alm;

import java.util.ArrayList;
import java.sql.*;


/**
 *
 * @author  lobo
 */
public class frm_comprobante_web {
    

    
    /** Creates a new instance of frm_comprobante_web */
    public frm_comprobante_web() {
    }
    
     public static ArrayList<obj_dos_campos> ro_llena_grilla_comprobante(String trab_idn) {
    
        ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;

        try {
            
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_envio_prueba_muestra_parti_trabajo (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,trab_idn.trim());
                    
            ResultSet rs = ps.executeQuery();
        
            
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos(rs.getString("data"),
                                  rs.getString("label")));
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
