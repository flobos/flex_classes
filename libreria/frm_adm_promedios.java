/*
 * frm_adm_promedios.java
 *
 * Created on 26 de enero de 2007, 11:53 AM
 */

package libreria;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author  msandana
 */
public class frm_adm_promedios {
    
    public static ArrayList<obj_siete_campos> muestra_detalles_promedio(String eje_academica) {
        ArrayList<obj_siete_campos> lista = new ArrayList<obj_siete_campos>();
        Connection c=null;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_muestra_listado_promedios (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,eje_academica.trim());
                   
          
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
           
           lista.add(new obj_siete_campos(rs.getString("mat_idn"),rs.getString("nombre"),
                                            rs.getString("pro_nombre"),rs.getString("tc_idn"),
                                            rs.getString("tc_promedio"),rs.getString("estado_promedio"),rs.getString("sit_tom_nombre"))); 
           
           
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
       
     public static ArrayList<obj_siete_campos> muestra_detalles_notas(String cod_toma) {
        ArrayList<obj_siete_campos> lista = new ArrayList<obj_siete_campos>();
        Connection c=null;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_muestra_listado_notas (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,cod_toma.trim());
                   
          
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
           
           lista.add(new obj_siete_campos(rs.getString("not_idn"),rs.getString("not_nota"),
                                            rs.getString("tip_pru_nombre"),rs.getString("not_fecha"),
                                            rs.getString("estado_nota"),rs.getString("trab_idn"),
                                            rs.getString("not_fecha_ter_ing_trab"))); 
           
           
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
     
   public static ArrayList<obj_un_campo_string> recalcula_promedio(String cod_toma) {
        ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
        Connection c=null;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_recalcula_promedios2 (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,cod_toma.trim());
                   
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){   
                
               lista.add(new obj_un_campo_string(rs.getString("promedio")));     
               
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
   
  public static ArrayList<obj_dos_campos> muestra_ejecuciones_academicas(String funcion_modalidad, String eje_idn) {
      ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
        
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_informe_promedios_carga_ejecuciones_academicas (?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,funcion_modalidad.trim());
            ps.setString(2,eje_idn.trim());
            
                                
            ResultSet rs = ps.executeQuery();
            
            lista.add(new obj_dos_campos ("0", "-- Seleccione --"));
                                     
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos (rs.getString("eje_aca_idn"), 
                                             rs.getString("cur_nombre") + " - " + rs.getString("eje_nombre")));
           
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

   
  public static ArrayList<obj_dos_campos> carga_ejecuciones_funcionario(String func_mod_fun_idn, String eje_activa) {
      ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
        
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_informe_promedios_carga_ejecuciones (?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,func_mod_fun_idn.trim());
            ps.setString(2,eje_activa.trim());
            
                                
            ResultSet rs = ps.executeQuery();
            
            lista.add(new obj_dos_campos ("0", "-- Seleccione --"));
                                     
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos (rs.getString("eje_idn"), 
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
  //***********************************************************************************************************          
  
    public static ArrayList<obj_dos_campos> muestra_ejecuciones_academicas_completa(String eje_idn) {
      ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
        
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_informe_promedios_completo_carga_ejecuciones_academicas (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,eje_idn.trim());
            
                                
            ResultSet rs = ps.executeQuery();
            
            lista.add(new obj_dos_campos ("0", "-- Seleccione --"));
                                     
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos (rs.getString("eje_aca_idn"), 
                                             rs.getString("cur_nombre")));
           
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

   
  public static ArrayList<obj_dos_campos> carga_ejecuciones_funcionario_completo(String eje_activa) {
      ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
        
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_informe_promedios_completo_carga_ejecuciones (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,eje_activa.trim());
            
                                
            ResultSet rs = ps.executeQuery();
            
            lista.add(new obj_dos_campos ("0", "-- Seleccione --"));
                                     
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos (rs.getString("eje_idn"), 
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
  
  
    public frm_adm_promedios() {
    }
    
}
