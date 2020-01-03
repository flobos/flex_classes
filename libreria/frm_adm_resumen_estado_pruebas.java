/*
 * frm_adm_resumen_estado_pruebas.java
 *
 * Created on 13 de junio de 2006, 11:58
 */

package libreria;



import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author  Administrador
 */
public class frm_adm_resumen_estado_pruebas {
    
    
    
 public static ArrayList<obj_tres_campos> muestra_cantidad_nota_x_estado(String eje_academica, String tipo_prueba ) {
        ArrayList<obj_tres_campos> lista = new ArrayList<obj_tres_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_pruebas_muestra_cantidad_x_estado (?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,eje_academica.trim());
            ps.setString(2,tipo_prueba.trim());
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
      
           lista.add(new obj_tres_campos(rs.getString("est_pru_idn"),rs.getString("est_pru_nombre"),rs.getString("contador"))); 
    
           
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
    
   public static ArrayList<obj_dos_campos> muestra_tipo_pruebas(String eje_academica) {
        ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_pruebas_muestra_tipo_pruebas (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,eje_academica.trim());
            
            ResultSet rs = ps.executeQuery();
            lista.add(new obj_dos_campos("0","-Seleccione-"));
            
            while (rs.next()){
            
      
           lista.add(new obj_dos_campos(rs.getString("tip_pru_idn"),rs.getString("tip_pru_nombre"))); 
    
           
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
   
   
   
   public static ArrayList<obj_siete_campos> muestra_dellate_estado_pruebas(String eje_academica, String tipo_prueba , String estado_prueba) {
        ArrayList<obj_siete_campos> lista = new ArrayList<obj_siete_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_pruebas_muestra_detalle_estado_pruebas (?,?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,eje_academica.trim());
            ps.setString(2,tipo_prueba.trim());
            ps.setString(3,estado_prueba.trim());
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
      
           lista.add(new obj_siete_campos(rs.getString("mat_idn"),rs.getString("nombre"),
                                            rs.getString("pro_nombre"),rs.getString("tc_idn"),
                                            rs.getString("not_nota"),rs.getString("not_fecha"),
                                            rs.getString("fecha_toma_prue"))); 
    
           
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
    
    public frm_adm_resumen_estado_pruebas() {
    }
    
    
    
    
    
    
}
