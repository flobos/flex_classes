/*
 * frm_pruebas_discrimina.java
 *
 * Created on 1 de mayo de 2010, 14:41
 */

package libreria_alm;
import java.util.ArrayList;
import java.io.Serializable;
import java.sql.*;


/**
 *
 * @author  lobo
 */
public class frm_pruebas_discrimina {
    
    
  
      public static ArrayList<Serializable> muestra_info_prueba(String tc_idn, String tipo_prueba, String pro_eva_idn) {
            ArrayList<Serializable> lista = new ArrayList<Serializable>();
            Connection c=null;
            String msg ;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_pruebas_discrimina_muestra_info_prueba_evaluacion (?, ?, ?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, tc_idn.trim());
            ps.setString(2, tipo_prueba.trim());
            ps.setString(3, pro_eva_idn.trim());
                    
            ResultSet rs = ps.executeQuery();
           
            while (rs.next()){
            
            lista.add(new obj_seis_campos(rs.getString("not_fecha_ter_ing_trab"),
                                         rs.getString("fecha_disponibilidad_prueba"),
                                         rs.getString("mod_ren_pru_nombre"),
                                         rs.getString("mod_ren_pru_idn"),
                                         rs.getString("eva_eje_tip_pru_tiempo"),
                                         rs.getString("pro_eva_ponderacion")));       
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            lista.remove(0);
            msg = e.getMessage();
            lista.add(new obj_un_campo_string(msg));
            
        } finally {
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
                
         return lista;
   }
      
      public static ArrayList<Serializable> muestra_proceso_evaluativo(String tc_idn) {
          ArrayList<Serializable> lista = new ArrayList<Serializable>();
          Connection c=null;
          String msg ;
       try {
          String sql;
          c = conexion_odbc.Connexion_datos();
          sql = "{call frm_pruebas_discrimina_muestra_proceso_evaluativo (?)}" ;
          CallableStatement ps = c.prepareCall(sql);
          ps.setString(1, tc_idn.trim());
                  
          ResultSet rs = ps.executeQuery();
          
           lista.add(new obj_dos_campos("0","-Seleccione-"));
      
          while (rs.next()){
          
          lista.add(new obj_dos_campos(rs.getString("pro_eva_idn"),
                                       rs.getString("tip_pro_eva_nombre")));       
          }
          
      } catch (Exception e) {
          e.printStackTrace();
          lista.remove(0);
          msg = e.getMessage();
          lista.add(new obj_un_campo_string(msg));
          
      } finally {
          try {
              c.close();
          } catch (SQLException e) {
              e.printStackTrace();
          }
      }
              
       return lista;
}
      
  public static ArrayList<Serializable> muestra_tipo_prueba(String tc_idn, String pro_eva_idn) {
            ArrayList<Serializable> lista = new ArrayList<Serializable>();
            Connection c=null;
            String msg ;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_pruebas_discrimina_muestra_prueba_evaluacion (?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, tc_idn.trim());
            ps.setString(2, pro_eva_idn.trim());
                    
            ResultSet rs = ps.executeQuery();
            
             lista.add(new obj_dos_campos("0","-Seleccione-"));
        
            while (rs.next()){
            
            lista.add(new obj_dos_campos(rs.getString("tip_pru_idn"),
                                         rs.getString("tip_pru_nombre")));       
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            lista.remove(0);
            msg = e.getMessage();
            lista.add(new obj_un_campo_string(msg));
            
        } finally {
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
                
         return lista;
  }
    
    
    
    /** Creates a new instance of frm_pruebas_discrimina */
    public frm_pruebas_discrimina() {
    }
    
    
    
    
}
