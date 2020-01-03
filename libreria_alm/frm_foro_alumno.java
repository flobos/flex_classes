/*
 * frm_foro_alumno.java
 *
 * Created on 13 de diciembre de 2005, 17:11
 */

package libreria_alm;

import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author  Administrador
 */


public class frm_foro_alumno {
    
     /** Creates a new instance of frm_foro_alumno */
    
      public static ArrayList<obj_cinco_campos> foro_muestra_activos(String ejecucion_aca) {
      ArrayList<obj_cinco_campos> lista = new ArrayList<obj_cinco_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_foro_muestra_activos (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,ejecucion_aca.trim());
                      
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
      
            lista.add(new obj_cinco_campos (rs.getString("for_tem_idn"), 
                                            rs.getString("for_tem_contenido"),
                                            rs.getString("for_tem_fecha_subida"),
                                            rs.getString("for_tem_titulo"),
                                             rs.getString("for_tem_activo")));
           
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
      
      
      /////***************************************************************************
    
      public static ArrayList<obj_cinco_campos> foro_muestra_respuestas(String ejecucion_aca) {
      ArrayList<obj_cinco_campos> lista = new ArrayList<obj_cinco_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_foro_muestra_respuestas (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,ejecucion_aca.trim());
                      
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
             
      
            lista.add(new obj_cinco_campos (rs.getString("for_res_idn"), 
                                            rs.getString("for_res_asunto"),
                                           rs.getString("res_tutor"), 
                                            rs.getString("for_res_fecha_ingreso"),
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
    
     /////***************************************************************************
    
   // 
     
       public static ArrayList<obj_dos_campos> foro_inserta_opinion(int idn, String glosa, String tc_idn) {
    ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
        String msg;
        msg = "OK";
        int salida = 1;
       
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_foro_inserta_opinion (?,?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setInt(1,idn);
            ps.setString(2,glosa.trim());
            ps.setString(3,tc_idn);
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
          
      
      /////***************************************************************************
         
      
      
    
    public frm_foro_alumno() {
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    }
    
}
