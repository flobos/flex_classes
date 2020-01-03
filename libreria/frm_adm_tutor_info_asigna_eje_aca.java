/*
 * frm_adm_tutor_info_asigna_eje_aca.java
 *
 * Created on 19 de diciembre de 2005, 03:40 PM
 */

package libreria;
import java.util.ArrayList;
import java.io.Serializable;
import java.sql.*;
/**
 *
 * @author  Esteban
 */
public class frm_adm_tutor_info_asigna_eje_aca {

//***********************************************************************************************************       
   
      public static ArrayList<obj_dos_campos> muestra_campus_modalidad(String rut, String funcion) {
      ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_funcion_ejecucion_academica_muestra_funcion_modalidad_funcionario (?, ?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,rut.trim());
            ps.setString(2,funcion.trim());
                                
            ResultSet rs = ps.executeQuery();
            
            
               lista.add(new obj_dos_campos ("0", "--Seleccione--"));
            
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos (rs.getString("func_mod_fun_idn"), 
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
//***********************************************************************************************************    
  public static ArrayList<Serializable> ro_info_tutor_eje_aca_carga_funcion(String fun_rut) {
    
        ArrayList<Serializable> lista = new ArrayList<Serializable>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_adm_info_tutor_eje_aca_carga_funcion '" + fun_rut + "'";
            cs = c.prepareCall(sql);
           // cs.setString(1, "633174");
            ResultSet rs = cs.executeQuery();
            lista.add(0,"-- Seleccione --");
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos(rs.getString("func_idn"),
                                         rs.getString("func_nombre")));
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
    
//***********************************************************************************************************
// frm_adm_tutor_info_asigna_eje_aca.mxml --by.SyOuS  
//***********************************************************************************************************          
  
  public static ArrayList<Serializable> muestra_ejecuciones() {
    
        ArrayList<Serializable> lista = new ArrayList<Serializable>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_adm_evaluaciones_eje_aca_muestra_ejecuciones" ;
            cs = c.prepareCall(sql);
           // cs.setString(1, "633174");
            ResultSet rs = cs.executeQuery();
            lista.add(0,"-- Seleccione --");
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos(rs.getString("data"),
                                         rs.getString("label")));
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
    
//***********************************************************************************************************
// frm_adm_tutor_info_asigna_eje_aca.mxml --by.SyOuS
//***********************************************************************************************************         
   public static ArrayList<obj_ocho_campos> muestra_ejecuciones_academicas(String ejecucion, String fun_rut, String fun_mod_func) {
    
        ArrayList<obj_ocho_campos> lista = new ArrayList<obj_ocho_campos>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_adm_info_tutor_muestra_ejecuciones_academicas '" + ejecucion.trim() + "', '" + fun_rut + "', '" + fun_mod_func + "'";
            cs = c.prepareCall(sql);
           // cs.setString(1, "633174");
            ResultSet rs = cs.executeQuery();
            
            while (rs.next()){
            
      
            lista.add(new obj_ocho_campos(rs.getString("eje_aca_idn"),
                                                rs.getString("cur_nombre"),
                                                rs.getString("sec_nombre"),
                                                rs.getString("tip_prod_nombre"),
                                                rs.getString("cam_nombre"),
                                                rs.getString("eje_nombre"),
                                                rs.getString("fun_nombre"),
                                                rs.getString("tip_jor_nombre")));
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

//***********************************************************************************************************
// frm_adm_tutor_info_asigna_eje_aca.mxml --by.SyOuS
//***********************************************************************************************************           
   public static ArrayList<obj_siete_campos> muestra_ejecuciones_academicas_asignadas(String ejecucion, String fun_rut, String fun_mod_func) {
    
        ArrayList<obj_siete_campos> lista = new ArrayList<obj_siete_campos>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_adm_info_tutor_muestra_ejecuciones_academicas_asignadas '" + ejecucion.trim() + "', '" + fun_rut + "', '" + fun_mod_func + "'";
            cs = c.prepareCall(sql);
           // cs.setString(1, "633174");
            ResultSet rs = cs.executeQuery();
            
            while (rs.next()){
            
      
            lista.add(new obj_siete_campos(rs.getString("eje_aca_idn"),
                                  rs.getString("cur_nombre"),
                                  rs.getString("sec_nombre"),
                                  rs.getString("tip_prod_nombre"),
                                  rs.getString("cam_nombre"),
                                  rs.getString("eje_nombre"),
                                  rs.getString("tip_jor_nombre")));
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
   
//***********************************************************************************************************
// frm_adm_tutor_info_asigna_eje_aca.mxml --by.SyOuS   
//***********************************************************************************************************   
    
     public static ArrayList<obj_un_campo_string> muestra_funcion_mod_funcionario(String rut) {
    
        ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
             sql = "flex_adm_info_tutor_busca_fun_mod_func '" + rut + "'" ;
            cs = c.prepareCall(sql);
           // cs.setString(1, "633174");
            ResultSet rs = cs.executeQuery();
            
            while (rs.next()){
            
      
            lista.add(new obj_un_campo_string(rs.getString("func_mod_fun_idn")));
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
   
//***********************************************************************************************************
// frm_adm_tutor_info_asigna_eje_aca.mxml --by.SyOuS
//***********************************************************************************************************                   
   public static ArrayList<?> actualiza_eje_aca_fun_mod_func(String fun_mod_func, String ejecucion_academica) {
    
        ArrayList<?> lista = new ArrayList<Object>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
             sql = "flex_adm_info_tutor_actualiza_eje_aca_fun_mod_func '" + fun_mod_func + "', '" + ejecucion_academica + "'";
            cs = c.prepareCall(sql);
           cs.executeQuery();
            
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
//***********************************************************************************************************    
    /** Creates a new instance of frm_adm_tutor_info_asigna_eje_aca */
    public frm_adm_tutor_info_asigna_eje_aca() {
    }
    
}
