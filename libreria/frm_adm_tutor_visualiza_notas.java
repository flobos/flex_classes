/*
 * frm_adm_tutor_visualiza_notas.java
 *
 * Created on 22 de diciembre de 2005, 08:04 AM
 */

package libreria;
import java.util.ArrayList;
import java.io.Serializable;
import java.sql.*;
/**
 *
 * @author  Esteban
 */
public class frm_adm_tutor_visualiza_notas {
  
 //***********************************************************************************************************
 // frm_adm_tutor_visualiza_notas.mxml --by.SyOuS
 //***********************************************************************************************************      
      public static ArrayList<Serializable> ro_carga_ejecuciones_activas() {
    
        ArrayList<Serializable> lista = new ArrayList<Serializable>();
        Connection c=null;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "select eje_idn, eje_nombre from ejecucion where eje_activa = 1 order by eje_nombre";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            lista.add(0,"-- Seleccione --");
            while (rs.next()){
                  lista.add(new obj_dos_campos(rs.getString("eje_idn")
                                            , rs.getString("eje_nombre")));
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
 // frm_adm_tutor_visualiza_notas.mxml --by.SyOuS
 //***********************************************************************************************************          
      public static ArrayList<Serializable> ro_carga_ejecuciones_academicas_por_ejecucion(String ejecucion, String fun_rut) {
    
        ArrayList<Serializable> lista = new ArrayList<Serializable>();
        Connection c=null;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_adm_tutor_carga_eje_academica_por_ejecucion '" + ejecucion + "', '" + fun_rut + "'";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            lista.add(0,"-- Seleccione --");
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos(rs.getString("eje_aca_idn")
                                                 , rs.getString("curso")));
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
 // frm_adm_tutor_visualiza_notas.mxml --by.SyOuS
 //***********************************************************************************************************      
      public static ArrayList<obj_cuatro_campos> ro_carga_datos_alumnos_por_matricula(String mat_idn, String eje_aca) {
    
        ArrayList<obj_cuatro_campos> lista = new ArrayList<obj_cuatro_campos>();
        Connection c=null;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_adm_tutor_visualiza_datos_alumno_por_matricula '" + mat_idn + "', '" + eje_aca + "'";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
        
            while (rs.next()){
            
      
            lista.add(new obj_cuatro_campos(rs.getString("nombre")
                                            , rs.getString("alu_rut")
                                            , rs.getString("mat_idn")
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
 // frm_adm_tutor_visualiza_notas.mxml --by.SyOuS
 //***********************************************************************************************************      
      public static ArrayList<obj_cuatro_campos> ro_carga_datos_alumnos_por_rut(String alu_rut, String eje_aca) {
    
        ArrayList<obj_cuatro_campos> lista = new ArrayList<obj_cuatro_campos>();
        Connection c=null;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_adm_tutor_visualiza_datos_alumno_por_rut '" + alu_rut + "', '" + eje_aca + "'";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
        
            while (rs.next()){
            
      
      
            lista.add(new obj_cuatro_campos(rs.getString("nombre")
                                       , rs.getString("alu_rut")
                                       , rs.getString("mat_idn")
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
 // frm_adm_tutor_visualiza_notas.mxml --by.SyOuS
 //***********************************************************************************************************      
      public static ArrayList<obj_cinco_campos> ro_tutor_busca_notas_por_rut(String alu_rut, String eje_aca) {
    
        ArrayList<obj_cinco_campos> lista = new ArrayList<obj_cinco_campos>();
        Connection c=null;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_adm_tutor_busca_notas_alumno_por_rut '" + alu_rut  + "', '" + eje_aca + "'";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
        
            while (rs.next()){
            
      
            lista.add(new obj_cinco_campos(rs.getString("nombre")
                                                        , rs.getString("tip_pru_nombre")
                                                        , rs.getString("not_nota")
                                                        , rs.getString("not_situacion")
                                                        , rs.getString("est_pru_nombre")));
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
 // frm_adm_tutor_visualiza_notas.mxml --by.SyOuS
 //***********************************************************************************************************      
      public static ArrayList<obj_cinco_campos> ro_tutor_busca_notas_por_matricula(String mat_idn, String eje_aca) {
    
        ArrayList<obj_cinco_campos> lista = new ArrayList<obj_cinco_campos>();
        Connection c=null;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_adm_tutor_busca_notas_alumno_por_matricula '" + mat_idn + "', '" + eje_aca + "'";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
        
            while (rs.next()){
            
      
            lista.add(new obj_cinco_campos(rs.getString("nombre")
                                                        , rs.getString("tip_pru_nombre")
                                                        , rs.getString("not_nota")
                                                        , rs.getString("not_situacion")
                                                        , rs.getString("est_pru_nombre")));
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
// frm_adm_tutor_visualiza_notas.mxml RGN
//***********************************************************************************************************      
      public static ArrayList<obj_tres_campos> ro_tutor_busca_alumno_por_apellido(String alu_ap_paterno, String eje_aca) {
    
        ArrayList<obj_tres_campos> lista = new ArrayList<obj_tres_campos>();
        Connection c=null;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_adm_tutor_busca_alumno_por_apellido '" + alu_ap_paterno  + "', '" + eje_aca + "'";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
        
            while (rs.next()){
            
      
            lista.add(new obj_tres_campos(rs.getString("alu_rut")
                                                        , rs.getString("mat_idn")
                                                        , rs.getString("nombre")));
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
    
    /** Creates a new instance of frm_adm_tutor_visualiza_notas */
    public frm_adm_tutor_visualiza_notas() {
    }
    
}
