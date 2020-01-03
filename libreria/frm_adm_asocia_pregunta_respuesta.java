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
 * @author  luis
 */
public class frm_adm_asocia_pregunta_respuesta {
 ////***************************************************************************************************
 ////***************************************************************************************************
////***************************************************************************************************
    
    
    
     public static ArrayList<obj_dos_campos> asocia_muestra_preguntas(String mod_cam_idn, String tip_prod_idn, String tem_idn) {
      ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_asocia_muestra_pregunta (?,?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,mod_cam_idn.trim());
            ps.setString(2,tip_prod_idn.trim());
             ps.setString(3,tem_idn.trim());   
             
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos (rs.getString("preg_frec_idn"), 
                                             rs.getString("preg_frec_pregunta")));
           
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
  /* public static ArrayList asocia_muestra_respuestas(String mod_cam_idn, String tip_prod_idn, String tem_idn, String preg_frec_idn) {
      ArrayList lista = new ArrayList();
        Connection c=null;
         int salida;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_asocia_muestra_respuestas (?,?,?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,mod_cam_idn.trim());
            ps.setString(2,tip_prod_idn.trim());
             ps.setString(3,tem_idn.trim());
             ps.setString(4,preg_frec_idn.trim());
                         
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos (rs.getString("preg_frec_idn"), 
                                             rs.getString("preg_frec_pregunta")));
           
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
    
    */
////***************************************************************************************************     
 
 
     public static ArrayList<obj_dos_campos> asocia_muestra_preguntas_resto(String mod_cam_idn, String tip_prod_idn, String tem_idn) {
      ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_asocia_muestra_pregunta_resto (?,?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,mod_cam_idn.trim());
            ps.setString(2,tip_prod_idn.trim());
             ps.setString(3,tem_idn.trim());   
             
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos (rs.getString("preg_frec_idn"), 
                                             rs.getString("preg_frec_pregunta")));
           
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
 public static ArrayList<obj_dos_campos> asocia_muestra_respuestas_resto(String mod_cam_idn, String tip_prod_idn, String tem_idn, String preg_frec_idn) {
      ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_asocia_muestra_respuesta_resto (?,?,?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,mod_cam_idn.trim());
            ps.setString(2,tip_prod_idn.trim());
             ps.setString(3,tem_idn.trim()); 
             ps.setString(4,preg_frec_idn.trim());
             
             
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos (rs.getString("res_preg_frec_idn"), 
                                             rs.getString("res_preg_frec_respuesta")));
           
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

    
     public static ArrayList<obj_un_campo_string> asocia_nueva_pregunta(String mod_cam_idn, String tip_prod_idn ,String tem_idn , String preg_frec_idn, String res_preg_frec_idn ) {
    ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
        Connection c=null;
         String msg ;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_asocia_nueva_pregunta_ingresa (?,?,?,?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, mod_cam_idn.trim());
            ps.setString(2, tip_prod_idn.trim());
            ps.setString(3, tem_idn.trim());
            ps.setString(4, preg_frec_idn.trim());
            ps.setString(5, res_preg_frec_idn.trim());
            
            
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

    
     public static ArrayList<obj_un_campo_string> asocia_nueva_respuesta(String mod_cam_idn, String tip_prod_idn ,String tem_idn , String preg_frec_idn, String res_preg_frec_idn ) {
    ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
        Connection c=null;
         String msg ;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_asocia_nueva_respuesta_ingresa (?,?,?,?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, mod_cam_idn.trim());
            ps.setString(2, tip_prod_idn.trim());
            ps.setString(3, tem_idn.trim());
            ps.setString(4, preg_frec_idn.trim());
            ps.setString(5, res_preg_frec_idn.trim());
            
            
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
    //////**************************************************************************************************
      public static ArrayList<obj_un_campo_string> asocia_borra_respuesta(String mod_cam_idn, String tip_prod_idn ,String tem_idn , String preg_frec_idn, String res_preg_frec_idn ) {
    ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
        Connection c=null;
         String msg ;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_asocia_borra_respuesta (?,?,?,?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, mod_cam_idn.trim());
            ps.setString(2, tip_prod_idn.trim());
            ps.setString(3, tem_idn.trim());
            ps.setString(4, preg_frec_idn.trim());
             ps.setString(5, res_preg_frec_idn.trim());
            
           
            
            
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
   
////*******************************************************************************************************
      
    
  //////**************************************************************************************************

     //////**************************************************************************************************
      public static ArrayList<obj_un_campo_string> asocia_borra_pregunta(String mod_cam_idn, String tip_prod_idn ,String tem_idn , String preg_frec_idn ) {
    ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
        Connection c=null;
         String msg ;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_asocia_borra_pregunta (?,?,?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, mod_cam_idn.trim());
            ps.setString(2, tip_prod_idn.trim());
            ps.setString(3, tem_idn.trim());
            ps.setString(4, preg_frec_idn.trim());
           
            
            
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
   
////*******************************************************************************************************
      
    
     public static ArrayList<obj_dos_campos> asocia_muestra_respuestas(String mod_cam_idn, String tip_prod_idn, String tem_idn, String preg_frec_idn) {
      ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_asocia_muestra_respuesta (?,?,?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,mod_cam_idn.trim());
            ps.setString(2,tip_prod_idn.trim());
             ps.setString(3,tem_idn.trim());   
             ps.setString(4,preg_frec_idn.trim());
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos (rs.getString("res_preg_frec_idn"), 
                                             rs.getString("res_preg_frec_respuesta")));
           
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
 
  /*
   
       public static ArrayList respuesta_ingresa(String res_preg_frec_respuesta ) {
    ArrayList lista = new ArrayList();
        Connection c=null;
         int salida = 1;
      String msg ;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_respuesta_pregunta_frec_ingresa (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, res_preg_frec_respuesta.trim());
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
   
      public static ArrayList respuesta_modifica(String res_preg_frec_idn, String res_preg_frec_respuesta)
   {
    ArrayList lista = new ArrayList();
        Connection c=null;
         int salida = 1;
        try {
  
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_respuesta_pregunta_frec_modifica (?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,res_preg_frec_idn.trim());
            ps.setString(2,res_preg_frec_respuesta.trim());
           
           
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
 
      
     public static ArrayList respuesta_borra(int res_preg_frec_idn) {
    ArrayList lista = new ArrayList();
    Connection c=null;
    int salida = 1;
    String msg;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_respuesta_pregunta_frec_borra (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setInt(1,res_preg_frec_idn);
            ps.execute();
           
        } catch (Exception e) {
            e.printStackTrace();
            salida = 0;
            msg = e.getMessage();
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
 
    */ 
     
      /** Creates a new instance of frm_adm_foro_ingreso */
     public frm_adm_asocia_pregunta_respuesta() {
    }
    
}
