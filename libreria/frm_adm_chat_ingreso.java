/*
 * frm_adm_chat_ingreso.java
 *
 * Created on 26 de diciembre de 2005, 03:16 PM
 */

package libreria;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author  Esteban
 */
public class frm_adm_chat_ingreso {
   public static ArrayList<obj_un_campo_string> chat_ingresa(String ejecucion_aca, String tema , String sube, String baja, int activo) {
    ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
        Connection c=null;
         String msg ;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_chat_ingresa (?,?,?,?,?)}";
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, ejecucion_aca.trim());
            ps.setString(2, tema.trim());
            ps.setString(3, sube.trim());
            ps.setString(4, baja.trim());
            ps.setInt(5, activo);
            ResultSet rs = ps.executeQuery();
        
            while (rs.next()){
            
      
            lista.add(new obj_un_campo_string(rs.getString("identidad")));
           
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
   
   
   
    public static ArrayList<obj_cinco_campos> chat_muesta(String ejecucion_aca) {
      ArrayList<obj_cinco_campos> lista = new ArrayList<obj_cinco_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_chat_muestra_chat (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,ejecucion_aca.trim());
                      
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
      
            lista.add(new obj_cinco_campos (rs.getString("chat_idn"), 
                                             rs.getString("chat_tema"), 
                                             rs.getString("chat_fecha_subida"), 
                                             rs.getString("chat_fecha_bajada"),
                                             rs.getString("chat_activo")));
           
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
   
   // *****************Borra chat .....marcelo***************************************************
  
 public static ArrayList<obj_un_campo> chat_borra(int chat_idn) {
    ArrayList<obj_un_campo> lista = new ArrayList<obj_un_campo>();
    Connection c=null;
    int salida = 1;
    try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_chat_chat_borra (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setInt(1,chat_idn);
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
        lista.add(new obj_un_campo(1));
        }else{
        lista.add(new obj_un_campo(0));
        }
        
         return lista;
   }  
   
   ////////////////////////////////////////////////
    
    
    public static ArrayList<obj_un_campo> chat_modifica(String chat_idn, String chat_tema ,String chat_fecha_subida, String chat_fecha_bajada,String chat_activo1)
   {
    ArrayList<obj_un_campo> lista = new ArrayList<obj_un_campo>();
        Connection c=null;
         int salida = 1;
        try {
  
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_chat_modifica (?,?,?,?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,chat_idn.trim());
            ps.setString(2,chat_tema.trim());
            ps.setString(3,chat_fecha_subida.trim());
            ps.setString(4,chat_fecha_bajada.trim());
            ps.setString(5,chat_activo1.trim());
            ps.execute();
                       
        } catch (Exception e) {
            e.printStackTrace();
            salida = 0;
            
        } finally {
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        if (salida == 1){
        lista.add(new obj_un_campo(1));
        }else{
        lista.add(new obj_un_campo(0));
        }
        
         return lista;
   }
   
    
    
 
   ////////////////////////////////////////////////
   
    public static ArrayList<obj_un_campo_string> chat_existe(int chat_idn) {
        ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_chat_existe_chat (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setInt(1, chat_idn);
            
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
 
    /** Creates a new instance of frm_adm_chat_ingreso */
    public frm_adm_chat_ingreso() {
    }
    
}
