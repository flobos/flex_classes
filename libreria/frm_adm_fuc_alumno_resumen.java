/*
 * frm_adm_fuc_alumno_resumen.java
 *
 * Created on 12 de diciembre de 2005, 11:32 AM
 */

package libreria;

/**
 *
 * @author  SyOuS [Esteban Ramírez]
 */
import java.util.ArrayList;
import java.sql.*;

public class frm_adm_fuc_alumno_resumen {
 //***********************************************************************************************************
 // frm_adm_fuc_alumno_resumen.mxml --by.SyOuS
 //***********************************************************************************************************      
      public static ArrayList<obj_cinco_campos> ro_fuc_alumno_resumen_carga_fucs_por_matricula(String mat_idn) {
    
        ArrayList<obj_cinco_campos> lista = new ArrayList<obj_cinco_campos>();
        Connection c=null;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_adm_fuc_alumno_resumen_carga_fucs_por_matricula '" + mat_idn + "'";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
        
            while (rs.next()){
            
      
      
            lista.add(new obj_cinco_campos(rs.getString("mat_idn")
                                        , rs.getString("fuc_web_idn")
                                        , rs.getString("fuc_web_consulta")
                                        , rs.getString("fuc_web_fecha_ing")
                                        , rs.getString("fuc_web_cerrado")));
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
 // frm_adm_fuc_alumno_resumen.mxml --by.SyOuS
 //***********************************************************************************************************      
      public static ArrayList<obj_cinco_campos> ro_fuc_alumno_resumen_carga_fucs(String alu_rut) {
    
        ArrayList<obj_cinco_campos> lista = new ArrayList<obj_cinco_campos>();
        Connection c=null;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_adm_fuc_alumno_resumen_carga_fucs '" + alu_rut + "'";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
        
            while (rs.next()){
            
      
      
            lista.add(new obj_cinco_campos(rs.getString("mat_idn")
                                        , rs.getString("fuc_web_idn")
                                        , rs.getString("fuc_web_consulta")
                                        , rs.getString("fuc_web_fecha_ing")
                                        , rs.getString("fuc_web_cerrado")));
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
// F U N C I O N E S   F O R A N E A S 
//***********************************************************************************************************           

 //***********************************************************************************************************
 // frm_adm_solicitudes.mxml --by.SyOuS
 //***********************************************************************************************************      
      public static ArrayList<obj_un_campo_string> ro_solicitud_carga_nombre_producto(String mat_idn) {
    
        ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_adm_solicitudes_carga_nombre_producto '" + mat_idn +"'";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            
            while (rs.next())
            {
                lista.add(new obj_un_campo_string(rs.getString("producto")));
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
 // frm_adm_solicitudes.mxml --by.SyOuS
 //***********************************************************************************************************      
      public static ArrayList<obj_dos_campos> ro_solicitud_carga_datos_alumno(String alu_idn) {
    
        ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_adm_solicitudes_carga_datos_alumno '" + alu_idn + "'";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            
            while (rs.next())
            {
                lista.add(new obj_dos_campos(rs.getString("alu_rut")
                                           , rs.getString("alu_nombre")));
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
      public static ArrayList<obj_dos_campos> ro_carga_alumnos_por_apellido(String alu_ap_paterno) {
    
        ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_adm_info_mat_busca_alumnos_por_apeliido '" + alu_ap_paterno + "'";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
        
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
 // frm_adm_tutor_visualiza_notas.mxml --by.SyOuS
 //***********************************************************************************************************      
      public static ArrayList<obj_un_campo> ro_carga_alumnos_por_matricula(String matricula) {
    
        ArrayList<obj_un_campo> lista = new ArrayList<obj_un_campo>();
        Connection c=null;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_adm_info_mat_busca_alumno_por_matricula '" + matricula + "'";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
        
            while (rs.next()){
            
      
      
            lista.add(new obj_un_campo(rs.getString("alu_rut")));
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
 // frm_adm_info_matriculas.mxml --by.SyOuS
 //***********************************************************************************************************      
      public static ArrayList<obj_tres_campos> ro_carga_matriculas_alumno_por_rut(String alu_rut) {
    
        ArrayList<obj_tres_campos> lista = new ArrayList<obj_tres_campos>();
        Connection c=null;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_adm_info_mat_matriculas_alumno '" + alu_rut + "'";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
        
            while (rs.next()){
            
      
      
            lista.add(new obj_tres_campos(rs.getString("mat_idn")
                                        , rs.getString("mal_nombre")
                                        , rs.getString("alu_idn")));
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
    /** Creates a new instance of frm_adm_fuc_alumno_resumen */
    public frm_adm_fuc_alumno_resumen() {
    }
    
}
