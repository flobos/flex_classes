/*
 * frm_adm_funcion_ejecucion_academica.java
 *
 * Created on 14 de diciembre de 2005, 8:34
 */

package libreria;





import java.util.ArrayList;
import java.io.Serializable;
import java.sql.*;
/**
/**
 *
 * @author  lobo
 */
public class frm_adm_funcion_ejecucion_academica {
    
   
//***********************************************************************************************************      
    
    public static ArrayList<obj_combo_tres_campos> muestra_funcion(String rut) {
      ArrayList<obj_combo_tres_campos> lista = new ArrayList<obj_combo_tres_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call  flex_adm_funcion_ejecucion_academica_muestra_funcion  (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,rut.trim());
                                
            ResultSet rs = ps.executeQuery();
            
          lista.add(new obj_combo_tres_campos ("0", "0", "-- Seleccione --"));
          
            while (rs.next()){
            
      
            lista.add(new obj_combo_tres_campos (rs.getString("func_idn"), 
                                                rs.getString("tip_fun_idn"),
                                                rs.getString("func_nombre")));
           
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
   
     public static ArrayList<Serializable> muestra_campus_modalidad(String rut, String funcion) {
      ArrayList<Serializable> lista = new ArrayList<Serializable>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_funcion_ejecucion_academica_muestra_funcion_modalidad_funcionario (?, ?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,rut.trim());
            ps.setString(2,funcion.trim());
                                
            ResultSet rs = ps.executeQuery();
            
            
               lista.add(new obj_dos_campos ("0", "--Seleccione--"));
            
            while (rs.next()){
            
      
            lista.add(new obj_combo_tres_campos (rs.getString("func_mod_fun_idn"), 
                                                rs.getString("mod_idn"), 
                                                rs.getString("nombre")));
           
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
  
  public static ArrayList<obj_tres_campos> muestra_ejecuciones_academicas(int funcion_modalidad) {
      ArrayList<obj_tres_campos> lista = new ArrayList<obj_tres_campos>();
        Connection c=null;
        
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_funcion_ejecucion_academica_muestra_ejecucion_academicas (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setInt(1,funcion_modalidad);
            
                                
            ResultSet rs = ps.executeQuery();
            
                                     
            while (rs.next()){
            
      
            lista.add(new obj_tres_campos (rs.getString("eje_aca_idn"), 
                                             rs.getString("cur_nombre"), 
                                              rs.getString("eje_nombre")));
           
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
    
    
    
    public frm_adm_funcion_ejecucion_academica() {
    }
    
}
