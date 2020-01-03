/*
 * frm_alumnos_main.java
 *
 * Created on 23 de noviembre de 2005, 9:37
 */

package libreria;


import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author  lobo
 */
public class frm_alumnos_main {
    

    public static ArrayList<obj_tres_campos> muestra_menus_aula_virtual(String mat_idn) {
    
        ArrayList<obj_tres_campos> lista = new ArrayList<obj_tres_campos>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_muestra_menus_alumno_aula_virtual '" + mat_idn + "'" ;
            cs = c.prepareCall(sql);
           // cs.setString(1, "633174");
            ResultSet rs = cs.executeQuery();
            
            while (rs.next())
            {
                 lista.add(new obj_tres_campos(  rs.getString("men_aula_vir_idn"),
                                                                rs.getString("men_aula_vir_nombre"),
                                                                rs.getString("men_aula_vir_url")
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
    
    
       public static ArrayList<obj_cuatro_campos> muestra_toma_cursos_principal(String mat_idn) {
    
        ArrayList<obj_cuatro_campos> lista = new ArrayList<obj_cuatro_campos>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_matricula_toma_curso_muestra '" + mat_idn + "'" ;
            cs = c.prepareCall(sql);
           // cs.setString(1, "633174");
            ResultSet rs = cs.executeQuery();
            
            while (rs.next())
            {
                 lista.add(new obj_cuatro_campos(rs.getString("nombre_completo"),
                                                 rs.getString("label"),
                                                 rs.getString("data"),
                                                 rs.getString("eje_aca_idn")));
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

  ///////////////////////////////////////////////////////////////////////////
  
  public static ArrayList<obj_tres_campos> verifica_deuda_notas (String mat_idn) {
      ArrayList<obj_tres_campos> lista = new ArrayList<obj_tres_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_verifica_pagos_notas(?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,mat_idn.trim());
            
                      
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
      
            lista.add(new obj_tres_campos (rs.getString("mat_idn"), 
                                             rs.getString("dat_pag_ano"), 
                                             rs.getString("n_pagos")));
                                           
           
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

  ///////////////////////////////////////////////////////////////////////////
  
  public static ArrayList<obj_dos_campos> carga_documentos_producto(String tip_prod_idn) {
      ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_alm_main_carga_documentos_producto(?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,tip_prod_idn.trim());
            
                      
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos (rs.getString("doc_nombre"), 
                                             rs.getString("doc_ruta_archivo")));
                                           
           
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

    
    
    
    public frm_alumnos_main() {
    }
    
}
