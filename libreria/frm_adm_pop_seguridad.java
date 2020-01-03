/*
 * frm_adm_pop_seguridad.java
 *
 * Created on 16 de diciembre de 2005, 11:33 AM
 */

package libreria;

/**
 *
 * @author  Esteban
 */
import java.util.ArrayList;
import java.sql.*;

public class frm_adm_pop_seguridad {
//***********************************************************************************************************  
    
       public static ArrayList<obj_cinco_campos> autentifica_funcionario(String usuario, String password) {
    
        ArrayList<obj_cinco_campos> lista = new ArrayList<obj_cinco_campos>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_adm_autentifica_usuario '" + usuario + "' , '" + password + "'";
            cs = c.prepareCall(sql);
           // cs.setString(1, "633174");
            ResultSet rs = cs.executeQuery();
            
            while (rs.next()){
            
      
            lista.add(new obj_cinco_campos(rs.getString("fun_rut"),
                                  rs.getString("fun_ap_paterno"),
                                  rs.getString("fun_ap_materno"),
                                  rs.getString("fun_nombre"),
                                  rs.getString("sed_nombre")));
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
    /** Creates a new instance of frm_adm_pop_seguridad */
    public frm_adm_pop_seguridad() {
    }
    
}
