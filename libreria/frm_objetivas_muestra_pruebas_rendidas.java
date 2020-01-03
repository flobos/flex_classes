/*
 * frm_muestra_pruebas_rendidas.java
 *
 * Created on 6 de mayo de 2010, 9:33 PM
 */

package libreria;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author  CMedina
 */
public class frm_objetivas_muestra_pruebas_rendidas {

//******************************************************************************************************************************************************    
    public static ArrayList<obj_cuatro_campos> muestra_carrera (String mat_idn) {
         ArrayList<obj_cuatro_campos> lista = new ArrayList<obj_cuatro_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_objetivas_muestra_pruebas_rendidas_muestra_carrera (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, mat_idn.trim());
            ResultSet rs = ps.executeQuery();
            
             while (rs.next()){
            
                 lista.add(new obj_cuatro_campos(rs.getString("car_idn"),
                                             rs.getString("car_nombre"),
                                             rs.getString("alu_rut"),
                                             rs.getString("nombre_alumno")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally 
          {
            try 
            {
                c.close();
            } 
            catch (SQLException e) 
            {
                e.printStackTrace();
            }
          }
         return lista;
   } 
    
//******************************************************************************************************************************************************    
    public static ArrayList<obj_dos_campos> muestra_ramos (String mat_idn) {
         ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_objetivas_muestra_pruebas_rendidas_muestra_ramos (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, mat_idn.trim());
            ResultSet rs = ps.executeQuery();
            
            lista.add(new obj_dos_campos("0", "-- Seleccione --")); 
             while (rs.next()){
            
                 lista.add(new obj_dos_campos(rs.getString("tc_idn"),
                                             rs.getString("cur_nombre")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally 
          {
            try 
            {
                c.close();
            } 
            catch (SQLException e) 
            {
                e.printStackTrace();
            }
          }
         return lista;
   }    

//******************************************************************************************************************************************************    
    public static ArrayList<obj_dos_campos> muestra_pruebas_ramos (String tc_idn) {
         ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_objetivas_muestra_pruebas_rendidas_muestra_pruebas_ramos (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, tc_idn.trim());
            ResultSet rs = ps.executeQuery();
            
            lista.add(new obj_dos_campos("0", "-- Seleccione --")); 
             while (rs.next()){
            
                 lista.add(new obj_dos_campos(rs.getString("trab_idn"),
                                             rs.getString("tip_pru_nombre")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally 
          {
            try 
            {
                c.close();
            } 
            catch (SQLException e) 
            {
                e.printStackTrace();
            }
          }
         return lista;
   }    
    
//******************************************************************************************************************************************************    
    public static ArrayList<obj_cinco_campos> muestra_preguntas_prueba (String trab_idn) {
         ArrayList<obj_cinco_campos> lista = new ArrayList<obj_cinco_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_objetivas_muestra_pruebas_rendidas_muestra_preguntas_prueba (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, trab_idn.trim());
            ResultSet rs = ps.executeQuery();
            
             while (rs.next()){
            
                 lista.add(new obj_cinco_campos(rs.getString("eje_aca_preg_pregunta"),
                                                rs.getString("eje_aca_res_respuesta"),
                                                rs.getString("eje_aca_res_idn"),
                                                rs.getString("eje_aca_res_correcta"),
                                                rs.getString("eje_aca_res_res_idn")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally 
          {
            try 
            {
                c.close();
            } 
            catch (SQLException e) 
            {
                e.printStackTrace();
            }
          }
         return lista;
   }    
//******************************************************************************************************************************************************    
    public static ArrayList<obj_dos_campos> muestra_nota (String trab_idn) {
         ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_objetivas_muestra_pruebas_rendidas_muestra_nota (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, trab_idn.trim());
            ResultSet rs = ps.executeQuery();
            
             while (rs.next()){
            
                 lista.add(new obj_dos_campos(rs.getString("not_nota"),
                                                rs.getString("eva_eje_porcentaje_aprobacion")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally 
          {
            try 
            {
                c.close();
            } 
            catch (SQLException e) 
            {
                e.printStackTrace();
            }
          }
         return lista;
   }    
        
        
//******************************************************************************************************************************************************    
    
     public frm_objetivas_muestra_pruebas_rendidas() {
    }
}
