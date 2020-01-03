/*
 * frm_pagos.java
 *
 * Created on 17 de enero de 2006, 11:01 AM
 */

package libreria_alm;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author  Esteban
 */
public class frm_pagos {
public static ArrayList<obj_cinco_campos> pagos_muestra (String mat_idn)
        {
    
        ArrayList<obj_cinco_campos> lista = new ArrayList<obj_cinco_campos>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_pagos_muestra '" + mat_idn + "'";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            
            while (rs.next())
            {
                 lista.add(new obj_cinco_campos(rs.getString("cuota")
                                     ,rs.getString("fecha")
                                     ,rs.getString("valor")
                                     ,rs.getString("cancelado")
                                     ,rs.getString("estado")
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
    
    /** Creates a new instance of frm_pagos */
    public frm_pagos() {
    }
    
}
