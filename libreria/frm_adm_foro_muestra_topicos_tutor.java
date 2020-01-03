/*
 * frm_adm_foro_muestra_topicos_tutor.java
 *
 * Created on 26 de diciembre de 2005, 02:41 PM
 */

package libreria;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author  Esteban
 */
public class frm_adm_foro_muestra_topicos_tutor {
        
      public static ArrayList<obj_cuatro_campos> foro_muestra_activos(String ejecucion_aca) {
      ArrayList<obj_cuatro_campos> lista = new ArrayList<obj_cuatro_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_foro_muestra_activos (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,ejecucion_aca.trim());
                      
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
      
            lista.add(new obj_cuatro_campos (rs.getString("for_tem_idn"), 
                                            rs.getString("for_tem_contenido"),
                                            rs.getString("for_tem_fecha_subida"),
                                             rs.getString("for_tem_titulo")));
           
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
    
      public static ArrayList<obj_seis_campos> foro_muestra_respuestas(String ejecucion_aca) {
      ArrayList<obj_seis_campos> lista = new ArrayList<obj_seis_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_foro_muestra_respuestas (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,ejecucion_aca.trim());
                      
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
             
      
            lista.add(new obj_seis_campos (rs.getString("for_res_idn"), 
                                           rs.getString("for_res_asunto"),
                                           rs.getString("res_tutor"), 
                                           rs.getString("for_res_fecha_ingreso"),
                                           rs.getString("nombre"),
                                           rs.getString("for_res_activo")));
                                             
           
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

////***************************************************************************************************      
     
      public static ArrayList<obj_un_campo_string> foro_bloquea_texto(int for_res_idn) {
    ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
    Connection c=null;
    int salida = 1;
    try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_foro_tutor_bloquea_texto (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setInt(1,for_res_idn);
            ps.execute();
           
        } catch (Exception e) {
            e.printStackTrace();
            salida = 0;
            e.getMessage();
        } finally {
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
                   
            }
        }
        
        if (salida == 1){
        lista.add(new obj_un_campo_string("1"));
        }else{
        lista.add(new obj_un_campo_string("0"));
        }
        
         return lista;
   }
////***************************************************************************************************      
     
      public static ArrayList<obj_un_campo_string> foro_des_bloquea_texto(int for_res_idn) {
    ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
    Connection c=null;
    int salida = 1;
    try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_foro_tutor_des_bloquea_texto (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setInt(1,for_res_idn);
            ps.execute();
           
        } catch (Exception e) {
            e.printStackTrace();
            salida = 0;
            e.getMessage();
        } finally {
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
                   
            }
        }
        
        if (salida == 1){
        lista.add(new obj_un_campo_string("1"));
        }else{
        lista.add(new obj_un_campo_string("0"));
        }
        
         return lista;
   }

    ////***************************************************************************************************      
 
       
      public static ArrayList<obj_un_campo_string> foro_respuesta_tutor(int for_res_idn, String for_res_contenido) {
    ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
    Connection c=null;
    int salida = 1;
    try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_foro_inserta_respuesta_tutor (?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setInt(1,for_res_idn);
            ps.setString(2,for_res_contenido);
            ps.execute();
           
        } catch (Exception e) {
            e.printStackTrace();
            salida = 0;
            e.getMessage();
        } finally {
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
                   
            }
        }
        
        if (salida == 1){
        lista.add(new obj_un_campo_string("1"));
        }else{
        lista.add(new obj_un_campo_string("0"));
        }
        
         return lista;
   }      
    /** Creates a new instance of frm_adm_foro_muestra_topicos_tutor */
    public frm_adm_foro_muestra_topicos_tutor() {
    }
    
}
