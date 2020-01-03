/*
 * frm_despacho.java
 *
 * Created on 17 de enero de 2006, 09:48 AM
 */

package libreria_alm;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author  Esteban
 */
public class frm_despacho {
    
public static ArrayList<obj_seis_campos> despacho_muestra (String mat_idn)
        {
    
        ArrayList<obj_seis_campos> lista = new ArrayList<obj_seis_campos>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_despacho_muestra '" + mat_idn + "'";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            
            while (rs.next())
            {
                 lista.add(new obj_seis_campos(rs.getString("tipo_material_nombre")
                                     ,rs.getString("fecha")
                                     ,rs.getString("fecha_recep")
                                     ,rs.getString("boleta")
                                     ,rs.getString("via_despacho_nombre")
                                     ,rs.getString("nombre")
                                     ));
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
    
    /** Creates a new instance of frm_despacho */
    public frm_despacho() {
    }
    
}
