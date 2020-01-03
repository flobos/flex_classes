/*
 * frm_bajada_pruebas.java
 *
 * Created on 27 de enero de 2006, 09:18 AM
 */

package libreria_alm;
import java.util.ArrayList;
import java.io.Serializable;
import java.sql.*;
/**
 *
 * @author  Esteban
 */
public class frm_bajada_pruebas {
       public static ArrayList<Serializable> bajada_pruebas_verifica (String eje_aca_idn, String mat_idn)
        {
    
        ArrayList<Serializable> lista = new ArrayList<Serializable>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_bajada_prueba_verifica_prueba '" + eje_aca_idn + "','" + mat_idn +"'";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            
            
            lista.add(new obj_dos_campos("1","-- Seleccione --"));
            
            
            while (rs.next())
            {
                 lista.add(new obj_combo_tres_campos(rs.getString("data")
                                                    , rs.getString("data2")
                                                    , rs.getString("tip_pru_nombre")));
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
    /** Creates a new instance of frm_bajada_pruebas */
    public frm_bajada_pruebas() {
    }
    
}
