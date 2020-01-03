/*
 * frm_adm_chat_tutor.java
 *
 * Created on 26 de diciembre de 2005, 03:20 PM
 */

package libreria;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author  Esteban
 */
public class frm_adm_chat_tutor {
 
//***********************************************************************************************************

 ////////////////////////////////////////////////////////////////////////
 
  public static ArrayList<obj_dos_campos> chat_inserta_conversacion_tutor(int idn, String glosa) {
    ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
        String msg;
        msg = "OK";
        int salida = 1;
       
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_chat_inserta_convesacion_tutor (?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setInt(1,idn);
            ps.setString(2,glosa.trim());
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
 
  ////////////////////////////////////////////////////////////////////
  

  ////////////////////////////////////////////////////////////////////
  
    public static ArrayList<obj_un_campo_string> chat_muestra_conversacion_tutor(String idn) {
        ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_chat_muestra_convesaciones_tutor_con_cursor (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, idn);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
      
           lista.add(new obj_un_campo_string(rs.getString("texto"))); 
                
     /*       lista.add(new obj_tres_campos(rs.getString("hora"),
                                         rs.getString("nombre"),
                                         rs.getString("glosa")));*/
           
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
////////////////////////Chat ///////////////////////////////
       
        public static ArrayList<obj_dos_campos> chat_muesta_activos(String ejecucion_aca) {
      ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_chat_muestra_activos (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,ejecucion_aca.trim());
                      
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos (rs.getString("chat_idn"), 
                                             rs.getString("chat_tema")));
           
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
   public static ArrayList<obj_un_campo_string> chat_muestra_conversacion(int idn) {
        ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_chat_muestra_convesaciones_con_cursor (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setInt(1, idn);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
      
           lista.add(new obj_un_campo_string(rs.getString("texto"))); 
                
     /*       lista.add(new obj_tres_campos(rs.getString("hora"),
                                         rs.getString("nombre"),
                                         rs.getString("glosa")));*/
           
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
    
  public static ArrayList<obj_tres_campos> chat_muestra_usuarios_activos(int idn) {
        ArrayList<obj_tres_campos> lista = new ArrayList<obj_tres_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_chat_usuario_muestra (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setInt(1, idn);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
      
            lista.add(new obj_tres_campos(rs.getString("campo_uno"),
                                         rs.getString("campo_dos"), 
                                         rs.getString("campo_tres")
                                         ));
           
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
  
 //////////////////// 
 public static ArrayList<obj_un_campo_string> chat_desactiva_usuario(int idn, String toma ) {
    ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
        Connection c=null;
         String msg ;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_chat_desactiva_usuario (?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setInt(1, idn);
            ps.setString(2, toma.trim());
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

  ///////////////
  
   public static ArrayList<obj_un_campo_string> chat_bloquea_usuario (int idn, String toma ) {
    ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
        Connection c=null;
         String msg ;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_chat_bloquea_usuario (?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setInt(1, idn);
            ps.setString(2, toma.trim());
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
    /** Creates a new instance of frm_adm_chat_tutor */
    public frm_adm_chat_tutor() {
    }
    
}
