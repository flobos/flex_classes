/*
 * frm_materiales_de_apoyo.java
 *
 * Created on 27 de enero de 2006, 11:53 AM
 */

package libreria_alm;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author  Esteban
 */
public class frm_materiales_de_apoyo {
    public static ArrayList<obj_dos_campos> carga_unidades_materiales(String eje_aca_idn) {
    
        ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_carga_unidades_materiales '" + eje_aca_idn + "'";
            cs = c.prepareCall(sql);
           // cs.setString(1, "633174");
            ResultSet rs = cs.executeQuery();
            lista.add(new obj_dos_campos("", "-- Seleccione --"));
            while (rs.next())
            {
                 lista.add(new obj_dos_campos(rs.getString("data"),
                                     rs.getString("label")
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
    
    
      public static ArrayList<obj_cuatro_campos> materiales_apoyo_carga_menu(String eje_aca_idn, String bib_vir_idn ) {
    
        ArrayList<obj_cuatro_campos> lista = new ArrayList<obj_cuatro_campos>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_materiales_de_apoyo_carga_menu '" + eje_aca_idn + "'," + "'" + bib_vir_idn + "'";
            cs = c.prepareCall(sql);
           // cs.setString(1, "633174");
            ResultSet rs = cs.executeQuery();
            
            while (rs.next())
            {
                 lista.add(new obj_cuatro_campos(rs.getString("codigo")
                                                                , rs.getString("nombre")
                                                                , rs.getString("url")
                                                                , rs.getString("imagen")));
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
      
            public static ArrayList<obj_cuatro_campos> material_apoyo_carga_detalle_materiales(String eje_aca_idn, String tipo_material_idn, int bib_vir_idn )
        {
    
        ArrayList<obj_cuatro_campos> lista = new ArrayList<obj_cuatro_campos>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_material_de_apoyo_carga_detalle_materiales '" + eje_aca_idn + "', '" + tipo_material_idn + "', '" + bib_vir_idn + "'";
            cs = c.prepareCall(sql);
           // cs.setString(1, "633174");
            ResultSet rs = cs.executeQuery();
            
            while (rs.next())
            {
                 lista.add(new obj_cuatro_campos(rs.getString("data")
                                                 , rs.getString("label")
                                                 , rs.getString("url")
                                                 , rs.getString("material")));
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
            
            
    /** Creates a new instance of frm_materiales_de_apoyo */
    public frm_materiales_de_apoyo() {
    }
    
}
