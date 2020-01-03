/*
 * frm_adm_fuc_tutor.java
 *
 * Created on 20 de diciembre de 2005, 05:50 PM
 */

package libreria;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author  Esteban
 */
public class frm_adm_fuc_tutor {
 //***********************************************************************************************************
 // frm_adm_fuc_tutor.mxml --by.SyOuS
 //***********************************************************************************************************      
      public static ArrayList<obj_dos_campos> ro_carga_ejecuciones_academicas_tutor(String func_mod_fun_idn) {
    
        ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_adm_funcionario_carga_eje_aca '" + func_mod_fun_idn + "'";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            
            lista.add(new obj_dos_campos("0", "-- Seleccione --"));
            
            while (rs.next())
            {
                lista.add(new obj_dos_campos(rs.getString("eje_aca_idn")
                                           , rs.getString("cur_nombre")));
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
 //***********************************************************************************************************
 // frm_adm_fuc_funcionario.mxml --by.SyOuS
 //***********************************************************************************************************      
      public static ArrayList<obj_cinco_campos> ro_carga_fucs_tutor(String func_mod_fun_idn , String resuelto, String eje_aca) {
    
        ArrayList<obj_cinco_campos> lista = new ArrayList<obj_cinco_campos>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_adm_fuc_funcionario_carga_fucs_tutor '" + func_mod_fun_idn  + "', " + resuelto + ", '" + eje_aca +"'" ;
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            
            while (rs.next()){
            
      
            lista.add(new obj_cinco_campos(rs.getString("fuc_web_idn"),
                                                        rs.getString("fuc_web_fecha_ing"),
                                                        rs.getString("mat_idn"),
                                                        rs.getString("fuc_web_consulta"),
                                                        rs.getString("fuc_web_cerrado")));
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
    
 //***********************************************************************************************************
 // frm_adm_fuc_tutor.mxml --by.SyOuS
 //***********************************************************************************************************      
      public static ArrayList<obj_cinco_campos> ro_carga_fucs_tutor_por_rut(String alu_rut, String func_mod_fun_idn, String eje_aca_idn) {
    
        ArrayList<obj_cinco_campos> lista = new ArrayList<obj_cinco_campos>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_adm_fuc_funcionario_carga_fucs_tutor_por_rut '" + alu_rut + "', '" + func_mod_fun_idn + "', " + eje_aca_idn + "'";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
                      
            while (rs.next()){
            
      
            lista.add(new obj_cinco_campos(rs.getString("fuc_web_idn"),
                                                        rs.getString("fuc_web_fecha_ing"),
                                                        rs.getString("mat_idn"),
                                                        rs.getString("fuc_web_consulta"),
                                                        rs.getString("fuc_web_cerrado")));
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
    
    
      
 //***********************************************************************************************************
 // frm_adm_fuc_tutor.mxml --by.SyOuS
 //***********************************************************************************************************      
      public static ArrayList<obj_cinco_campos> ro_carga_fucs_tutor_por_codigo(String func_mod_fun_idn, String fuc_web_idn, String eje_aca_idn) {
    
        ArrayList<obj_cinco_campos> lista = new ArrayList<obj_cinco_campos>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_adm_fuc_funcionario_carga_fucs_tutor_por_codigo '" + func_mod_fun_idn + "', '" + fuc_web_idn + "', " + eje_aca_idn + "'";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
                      
            while (rs.next()){
            
      
            lista.add(new obj_cinco_campos(rs.getString("fuc_web_idn"),
                                                        rs.getString("fuc_web_fecha_ing"),
                                                        rs.getString("mat_idn"),
                                                        rs.getString("fuc_web_consulta"),
                                                        rs.getString("fuc_web_cerrado")));
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
    /** Creates a new instance of frm_adm_fuc_tutor */
    public frm_adm_fuc_tutor() {
    }
    
}
