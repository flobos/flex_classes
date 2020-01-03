/*
 * frm_alumnos_main.java
 *
 * Created on 23 de noviembre de 2005, 9:37
 */

package libreria_alm;


import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author  lobo
 */
public class frm_alumnos_main {
    
	public static void registro_login (String alu_idn) {
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "insert into registro_login_alumno values ('"+alu_idn.trim()+"', getdate())   " ;
            CallableStatement ps = c.prepareCall(sql);
            ps.execute();
            
           
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
       
   }     
	public static void registro_acceso_menu (String tc_idn, String men_aula_vir_idn) {
	        Connection c=null;
	         try {
	            String sql;
	            c = conexion_odbc.Connexion_datos();
	            sql = "insert into registro_acceso_menu_alumno values ('"+tc_idn.trim()+"','"+ men_aula_vir_idn.trim()+"', getdate())   " ;
	            CallableStatement ps = c.prepareCall(sql);
	            ps.execute();
	            
	           
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                c.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	       
	   }     
	
	
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
    
    public static ArrayList<obj_un_campo_string> verifica_email_alumno(String alu_idn) {
        
        ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "select alu_email from alumnos where alu_idn = '" + alu_idn.trim() + "'" ;
            cs = c.prepareCall(sql);
           // cs.setString(1, "633174");
            ResultSet rs = cs.executeQuery();
            
            while (rs.next())
            {
                 lista.add(new obj_un_campo_string(rs.getString("alu_email")));
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
    
    
public static ArrayList<obj_un_campo_string> guardar_email(String alu_idn, String email) {
        
        ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            
            sql = "update alumnos set alu_email = '"+email.trim()+"', alu_fecha_ingreso_email = getdate() where alu_idn = '" + alu_idn.trim() + "' " ;
            cs = c.prepareCall(sql);
            cs.execute();
            System.out.println("\n\nActualice\n");
            sql = "select alu_email from alumnos where alu_idn = '" + alu_idn.trim() + "'" ;
            cs = c.prepareCall(sql);
           // cs.setString(1, "633174");
            ResultSet rs = cs.executeQuery();
            
            while (rs.next())
            {
                 lista.add(new obj_un_campo_string(rs.getString("alu_email")));
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
    
    public static ArrayList<obj_cinco_campos> muestra_toma_cursos_principal(String mat_idn) {
    
        ArrayList<obj_cinco_campos> lista = new ArrayList<obj_cinco_campos>();
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
                 lista.add(new obj_cinco_campos(rs.getString("nombre_completo"),
                                                 rs.getString("label"),
                                                 rs.getString("data"),
                                                 rs.getString("eje_aca_idn"),
                                                 rs.getString("eje_idn")));
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
