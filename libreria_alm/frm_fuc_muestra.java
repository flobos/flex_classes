/*
 * frm_fuc_muestra.java
 *
 * Created on 17 de enero de 2006, 02:53 PM
 */

package libreria_alm;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author  Esteban
 */
public class frm_fuc_muestra {
    public static ArrayList<obj_cuatro_campos> muestra_fuc_web(String matricula) {
    
        ArrayList<obj_cuatro_campos> lista = new ArrayList<obj_cuatro_campos>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
             sql = "flex_fuc_muestra_fuc '" + matricula + "'" ;
            cs = c.prepareCall(sql);
           // cs.setString(1, "633174");
            ResultSet rs = cs.executeQuery();
            
            while (rs.next()){
            
      
            lista.add(new obj_cuatro_campos(rs.getString("fuc_web_idn"),
                                            rs.getString("fecha"),
                                            rs.getString("mat_idn"),
                                            rs.getString("estado")));
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
    /** Creates a new instance of frm_fuc_muestra */
    public frm_fuc_muestra() {
    }
    
}
