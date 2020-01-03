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
 * @author  Marcelo
 */
public class frm_adm_noticias_ingreso {
 ////***************************************************************************************************
    
       public static ArrayList<obj_un_campo_string> noticia_ingresa(String noti_contenido,  String fun_rut , int activo) {
    ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
        Connection c=null;
         String msg ;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_noticia_ingresa (?,?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, noti_contenido.trim());
            ps.setString(2, fun_rut.trim());
             ps.setInt(3, activo);
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
   
    
    
    
//***************************************************************************************************
    
    
    
     public static ArrayList<obj_cinco_campos> noticia_muestra(String fun_rut) {
      ArrayList<obj_cinco_campos> lista = new ArrayList<obj_cinco_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_noticia_muestra_noticia (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,fun_rut.trim());
                      
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
      
            lista.add(new obj_cinco_campos (rs.getString("noti_idn"), 
                                             rs.getString("noti_contenido"), 
                                             rs.getString("fun_rut"),
                                             rs.getString("noti_fecha"),
                                             rs.getString("noti_activa")));
           
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
     
     //      
      
       public static ArrayList<obj_un_campo> noticia_borra(int noti_idn) {
    ArrayList<obj_un_campo> lista = new ArrayList<obj_un_campo>();
    Connection c=null;
    int salida = 1;
    try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_noticia_borra_noticia (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setInt(1,noti_idn);
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
     
     
     
     
      public static ArrayList<obj_un_campo> noticia_modifica(String noti_idn, String noti_contenido, int activo)
   {
    ArrayList<obj_un_campo> lista = new ArrayList<obj_un_campo>();
        Connection c=null;
         int salida = 1;
        try {
  
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_noticia_modifica_noticia (?,?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,noti_idn.trim());
            ps.setString(2,noti_contenido.trim());
            ps.setInt(3, activo);
           
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
   
//////***************************************************************************************************      
     
     
    
     public static ArrayList<obj_cinco_campos> muestra_noticias_pop_up() {
      ArrayList<obj_cinco_campos> lista = new ArrayList<obj_cinco_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_noticia_muestra_noticias_pop_up ()}" ;
            CallableStatement ps = c.prepareCall(sql);
           
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
      
            lista.add(new obj_cinco_campos (rs.getString("noti_idn"), 
                                             rs.getString("noti_contenido"), 
                                             rs.getString("fun_rut"),
                                             rs.getString("noti_fecha"),
                                             rs.getString("noti_activa")));
           
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
     
     
     
//      
//     public static ArrayList foro_existe(int for_tem_idn) {
//        ArrayList lista = new ArrayList();
//        Connection c=null;
//         int salida;
//        try {
//            String sql;
//            c = conexion_odbc.Connexion_datos();
//            sql = "{call flex_adm_foro_existe (?)}" ;
//            CallableStatement ps = c.prepareCall(sql);
//            ps.setInt(1, for_tem_idn);
//            
//            ResultSet rs = ps.executeQuery();
//            
//            while (rs.next()){
//            
//      
//            lista.add(new obj_un_campo_string(rs.getString("campo_uno")));
//           
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                c.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//         return lista;
//   }
   
       
    /** Creates a new instance of frm_adm_foro_ingreso */
     public frm_adm_noticias_ingreso() {
    }
    
}
