/*
 * frm_pruebas_sube_tutor.java
 *
 * Created on 27 de diciembre de 2005, 09:21 AM
 */

package libreria;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author  Esteban
 */
public class frm_pruebas_sube_tutor {
      public static ArrayList<obj_siete_campos> prueba_sube_tutor_muetra_detalle_subida(String ejecucion_aca) {
      ArrayList<obj_siete_campos> lista = new ArrayList<obj_siete_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_prueba_sube_tutor_muesta_detalle (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,ejecucion_aca.trim());
                      
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
      
            lista.add(new obj_siete_campos (rs.getString("eva_eje_idn"), 
                                             rs.getString("tip_pru_nombre"), 
                                             rs.getString("eva_eje_ponderacion"), 
                                             rs.getString("eva_eje_disponible"),
                                             rs.getString("eva_eje_archivo_web"), 
                                             rs.getString("eva_eje_fecha_subida_archivo"), 
                                             rs.getString("func_mod_fun_idn")));
           
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
///////////////////////////////////////////////////////////////////
    public static ArrayList<obj_siete_campos> prueba_sube_tutor_muestra_pruebas(String ejecucion_aca) {
      ArrayList<obj_siete_campos> lista = new ArrayList<obj_siete_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_prueba_sube_tutor_muesta_pruebas (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,ejecucion_aca.trim());
                      
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
      
            lista.add(new obj_siete_campos (rs.getString("eva_eje_idn"), 
                                             rs.getString("tip_pru_nombre"), 
                                             rs.getString("eva_eje_ponderacion"), 
                                             rs.getString("eva_eje_fecha"),
                                             rs.getString("eva_eje_archivo_web"), 
                                             rs.getString("eva_eje_fecha_subida_archivo"), 
                                             ""));
           
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
    
    
    /////////////////////////////////////////////////////////////
    
   public static ArrayList<obj_dos_campos> prueba_sube_tutor_actualiza_archivo(String evaluacion, String Archivo) {
    ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
        String msg;
        msg = "OK";
        int salida = 1;
       
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_prueba_sube_tutor_actualiza_archivo (?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,evaluacion.trim());
            ps.setString(2,Archivo.trim());
            ps.execute();
            
        } catch (Exception e) {
            e.printStackTrace();
           
            msg = e.getMessage();
            salida = 0;
            
        } finally {
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        if (salida == 1){
        lista.add(new obj_dos_campos("1", msg));
        }else{
        lista.add(new obj_dos_campos("0", msg));
        }
        
         return lista;
   } 
//////////////////////////////////////////////
       public static ArrayList<obj_un_campo_string> comprueba_fecha_subida_prueba(String eva_eje_idn) {
      ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_comprueba_fecha_subida_prueba_tutor (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,eva_eje_idn.trim());
                      
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
      
           lista.add(new obj_un_campo_string(rs.getString("campo_uno")));
           
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
//////////////////////////////////////////////
    
    /** Creates a new instance of frm_pruebas_sube_tutor */
    public frm_pruebas_sube_tutor() {
    }
    
}
