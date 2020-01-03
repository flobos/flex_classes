/*
 * frm_adm_producto_campus_elemento.java
 *
 * Created on 24 de abril de 2008, 10:53
 */

package libreria;

import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author  Administrador
 */
public class frm_adm_producto_campus_elemento {
    
    /** Creates a new instance of frm_adm_producto_campus_elemento */
  
 //*********************************************************************
  
 public static ArrayList<obj_dos_campos> llena_combo_elemento_academico() {
      ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_adm_producto_campus_elemento_llena_combo_elemento_academico ()}" ;
            CallableStatement ps = c.prepareCall(sql);
         
            ps.execute();
            
            
            
                      
            ResultSet rs = ps.executeQuery();
            
             
              lista.add(new obj_dos_campos("0"," - Seleccione - "));
                 
            
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos (rs.getString("tip_ele_aca_idn"), 
                                         rs.getString("tip_ele_aca_nombre")));
           
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

//*********************************************************************
  
 public static ArrayList<obj_dos_campos> llena_combo_malla_curricular(String  func_mod_fun_idn) {
      ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_adm_producto_campus_elemento_llena_combo_malla_curricular (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
         
                       
            ps.setString(1, func_mod_fun_idn.trim());
            ps.execute();
            
            
            
                      
            ResultSet rs = ps.executeQuery();
            
             
              lista.add(new obj_dos_campos("0"," - Seleccione - "));
                 
            
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos (rs.getString("mal_mod_idn"), 
                                         rs.getString("mal_nombre")));
           
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
//*****************************************************************************
     public static ArrayList<obj_dos_campos> llena_grilla_cursos(String mal_mod_idn) {
         ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_adm_producto_campus_elemento_llena_grilla_cursos (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, mal_mod_idn.trim());
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
      
             lista.add(new obj_dos_campos (rs.getString("pro_cam_idn"), 
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
//************************************************
      public static ArrayList<obj_dos_campos> asigna_elementos_segun_curso(String pro_cam_idn,String tip_ele_aca_idn) {
    ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
        String msg;
        msg = "OK";
        int salida = 1;
       
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_adm_producto_campus_elemento_asigna_elementos_segun_curso(?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,pro_cam_idn .trim());
            ps.setString(2,tip_ele_aca_idn.trim()); 
          
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
//*****************************************************************************
     public static ArrayList<obj_dos_campos> llena_grilla_elementos_producto_campus(String pro_cam_idn) {
         ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_adm_producto_campus_elemento_llena_grilla_elementos_producto_campus (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, pro_cam_idn.trim());
            
            ResultSet rs = ps.executeQuery();
             
            while (rs.next()){
            
       
             lista.add(new obj_dos_campos (rs.getString("pro_cam_ele_idn"), 
                                         rs.getString("tip_ele_aca_nombre")));
           
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
//*********************************************************************
  
 public static ArrayList<obj_dos_campos> llena_combo_periodo() {
      ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_adm_producto_campus_elemento_llena_combo_periodo ()}" ;
            CallableStatement ps = c.prepareCall(sql);
         
            ps.execute();
            
            
            
                      
            ResultSet rs = ps.executeQuery();
            
             
              lista.add(new obj_dos_campos("0"," - Seleccione - "));
                 
            
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos (rs.getString("per_ele_idn"), 
                                         rs.getString("periodo")));
           
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
//************************************************
      public static ArrayList<obj_dos_campos> asigna_perido_segun_elemento_academico_del_curso(String per_ele_idn,String pro_cam_ele_idn) {
    ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
        String msg;
        msg = "OK";
        int salida = 1;
       
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_adm_producto_campus_elemento_asigna_perido(?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,per_ele_idn .trim());
            ps.setString(2,pro_cam_ele_idn.trim()); 
          
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
//*****************************************************************************
     public static ArrayList<obj_dos_campos> llena_grilla_producto_campus_periodo(String pro_cam_ele_idn) {
         ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_adm_producto_campus_elemento_llena_grilla_producto_campus_perido (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, pro_cam_ele_idn.trim());
            
            ResultSet rs = ps.executeQuery();
             
            while (rs.next()){
            
       
             lista.add(new obj_dos_campos (rs.getString("pro_cam_per_idn"), 
                                         rs.getString("periodo")));
           
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
     
//************************************************
      public static ArrayList<obj_dos_campos> borra_elemento_academico(String pro_cam_ele_idn) {
    ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
        String msg;
        msg = "OK";
        int salida = 1;
       
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_adm_producto_campus_elemento_elimina_elemento_academico(?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,pro_cam_ele_idn .trim());
                   
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
//************************************************
      public static ArrayList<obj_dos_campos> borra_periodo(String pro_cam_per_idn) {
    ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
        String msg;
        msg = "OK";
        int salida = 1;
       
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_adm_producto_campus_elemento_elimina_periodo(?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,pro_cam_per_idn .trim());
                   
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
    
//**************************************************    
    public frm_adm_producto_campus_elemento() {
    }


}
