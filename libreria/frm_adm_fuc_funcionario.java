/*
 * frm_adm_fuc_funcionario.java
 *
 * Created on 20 de diciembre de 2005, 03:19 PM
 */

package libreria;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author  Esteban
 */
public class frm_adm_fuc_funcionario {
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
 // ffrm_adm_fuc_funcionario.mxml --by.SyOuS
 //***********************************************************************************************************
      public static ArrayList<obj_dos_campos> ro_carga_ejecucion_fuc(String fun_rut) {
    
        ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
                
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_adm_fuc_funcionario_carga_ejecuciones '" + fun_rut + "'";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
           
	    lista.add(new obj_dos_campos("0"," - Seleccione - "));

            while (rs.next()){
            
      
            lista.add(new obj_dos_campos(rs.getString("data")
                                        , rs.getString("label")));
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
 // ffrm_adm_fuc_funcionario.mxml --by.SyOuS
 //***********************************************************************************************************
      public static ArrayList<obj_dos_campos> ro_carga_ejecuciones_academicas_tutor(String fun_rut, String eje_idn) {
    
        ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
                
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_adm_fuc_funcionario_carga_ejecuciones_academicas '" + fun_rut + "', '" + eje_idn + "'";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
           
            lista.add(new obj_dos_campos("0"," - Seleccione - "));

            while (rs.next()){
            
      
            lista.add(new obj_dos_campos(rs.getString("data")
                                        , rs.getString("label")));
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
      public static ArrayList<obj_cinco_campos> ro_carga_fucs(String rut_funcionario, String fecha_ingreso, Integer resuelto) {
    
        ArrayList<obj_cinco_campos> lista = new ArrayList<obj_cinco_campos>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_adm_fuc_funcionario_carga_fucs '" + rut_funcionario + "','" + fecha_ingreso + "', " + resuelto + "";
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
 // frm_adm_fuc_funcionario.mxml --by.SyOuS
 //***********************************************************************************************************      
      public static ArrayList<obj_cinco_campos> ro_carga_fucs_por_rut(String rut_funcionario, String rut_alumno) {
    
        ArrayList<obj_cinco_campos> lista = new ArrayList<obj_cinco_campos>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_adm_fuc_funcionario_carga_fucs_por_rut '" + rut_funcionario + "','" + rut_alumno + "'";
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
 // frm_adm_fuc_funcionario.mxml --by.SyOuS
 //***********************************************************************************************************      
      public static ArrayList<obj_cinco_campos> ro_carga_fucs_por_codigo(String rut_funcionario, String fuc_web) {
    
        ArrayList<obj_cinco_campos> lista = new ArrayList<obj_cinco_campos>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_adm_fuc_funcionario_carga_fucs_por_codigo '" + rut_funcionario + "','" + fuc_web + "'";
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
      
    /** Creates a new instance of frm_adm_fuc_funcionario */
    public frm_adm_fuc_funcionario() {
    }
    
}
