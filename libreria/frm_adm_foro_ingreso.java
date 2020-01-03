/*
 * frm_adm_foro_ingreso.java
 *
 * Created on 26 de diciembre de 2005, 02:30 PM
 */

package libreria;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author  Esteban
 */
public class frm_adm_foro_ingreso {
 ////***************************************************************************************************
    
       public static ArrayList<obj_un_campo_string> foro_ingresa(String ejecucion_aca, String titulo , String tema , String sube, String baja, int activo) {
    ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
        Connection c=null;
         String msg ;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_foro_ingresa (?,?,?,?,?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, ejecucion_aca.trim());
            ps.setString(2, titulo.trim());
             ps.setString(3, tema.trim());
            ps.setString(4, sube.trim());
            ps.setString(5, baja.trim());
            ps.setInt(6, activo);
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
   
    
    
    
////***************************************************************************************************
    
    
    
     public static ArrayList<obj_seis_campos> foro_muestra(String ejecucion_aca) {
      ArrayList<obj_seis_campos> lista = new ArrayList<obj_seis_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_foro_muestra_foro (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,ejecucion_aca.trim());
                      
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
      
            lista.add(new obj_seis_campos (rs.getString("for_tem_idn"), 
                                             rs.getString("for_tem_titulo"), 
                                             rs.getString("for_tem_contenido"),
                                             rs.getString("for_tem_fecha_subida"), 
                                             rs.getString("for_tem_fecha_bajada"),
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
    
    
////***************************************************************************************************     
     
     
      public static ArrayList<obj_un_campo> foro_modifica(String foro_idn, String foro_titulo , String foro_tema, String foro_fecha_subida, String foro_fecha_bajada,String foro_activo)
   {
    ArrayList<obj_un_campo> lista = new ArrayList<obj_un_campo>();
        Connection c=null;
         int salida = 1;
        try {
  
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_foro_modifica (?,?,?,?,?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,foro_idn.trim());
            ps.setString(2,foro_titulo.trim());
            ps.setString(3,foro_tema.trim());
            ps.setString(4,foro_fecha_subida.trim());
            ps.setString(5,foro_fecha_bajada.trim());
            ps.setString(6,foro_activo.trim());
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
   
////***************************************************************************************************      
      
      
       public static ArrayList<obj_un_campo> foro_borra(int foro_idn) {
    ArrayList<obj_un_campo> lista = new ArrayList<obj_un_campo>();
    Connection c=null;
    int salida = 1;
    try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_foro_borra (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setInt(1,foro_idn);
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
      
////***************************************************************************************************      
      
     public static ArrayList<obj_un_campo_string> foro_existe(int for_tem_idn) {
        ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_foro_existe (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setInt(1, for_tem_idn);
            
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
   
       
    /** Creates a new instance of frm_adm_foro_ingreso */
    public frm_adm_foro_ingreso() {
    }
    
}
