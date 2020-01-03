/*
 * frm_informe_trabajos.java
 *
 * Created on 26 de septiembre de 2006, 12:11 PM
 */

package libreria;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author  jose
 */
public class frm_informe_trabajos {
    
    public static ArrayList<obj_dos_campos> carga_ejecucion() {
    
        ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_carga_ejecucion_informe_trabajos ";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            lista.add(new obj_dos_campos("0","Seleccione"));
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos(rs.getString("data")
                                       , rs.getString("label")));
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
    
    //************************************************************
        public static ArrayList<obj_dos_campos> carga_tipo_producto(String eje_idn) {
    
        ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_muestra_tipo_producto_informe_trabajos '" + eje_idn + "'";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            lista.add(new obj_dos_campos("0","Seleccione"));
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos(rs.getString("data")
                                       , rs.getString("label")));
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
    
    
    
    
    
    public frm_informe_trabajos() {
    }
    
}
