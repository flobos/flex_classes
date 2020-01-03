/*
 * frm_adm_fuc_ingreso.java
 *
 * Created on 21 de diciembre de 2005, 11:27 AM
 */

package libreria;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author  Esteban
 */
public class frm_adm_fuc_ingreso {
//***********************************************************************************************************                
// FUC - By.Chakalin [13-07-05]    frm_adm_fuc_ingreso
//***********************************************************************************************************                
       public static ArrayList<obj_un_campo_string> devuelve_corre_fuc() {
    
        ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
        Connection c=null;

        try {
         
            c = conexion_odbc.Connexion_datos();
            
            CallableStatement cs;
            cs = c.prepareCall("flex_index_fuc_web_busca_numero_fuc");
            //cs.setString(1, "a string");
            ResultSet rs = cs.executeQuery();
            
            while (rs.next()){
            
      
            lista.add(new obj_un_campo_string(rs.getString("codigo")));
            
            
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
// FUC - By.Chakalin [13-07-05]    frm_adm_fuc_ingreso
//***********************************************************************************************************        
      public static ArrayList<obj_nueve_campos> alumno_muestra_fuc(String matricula) {
    
        ArrayList<obj_nueve_campos> lista = new ArrayList<obj_nueve_campos>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_index_info_alumno_muestra '" + matricula + "'" ;
            cs = c.prepareCall(sql);
           // cs.setString(1, "633174");
            ResultSet rs = cs.executeQuery();
            
            while (rs.next()){
            
      
            lista.add(new obj_nueve_campos(rs.getString("alumno_rut"),
                                           rs.getString("matricula"),
                                           rs.getString("promocion"),
                                           rs.getString("alumno_clave"),
                                           rs.getString("nombre_alumno"), 
                                           rs.getString("producto"),
                                           rs.getString("malla"),
                                           rs.getString("mal_idn"),
                                           rs.getString("division_politica")));
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
// FUC - By.Chakalin [13-07-05]    frm_adm_fuc_ingreso
//***********************************************************************************************************     
    public static ArrayList<obj_dos_campos> busca_mod_cam_por_matricula(String matricula) {
    
        ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_fuc_busca_mod_cam_por_matricula '" + matricula + "'" ;
            cs = c.prepareCall(sql);
           // cs.setString(1, "633174");
            ResultSet rs = cs.executeQuery();
            
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos(rs.getString("modalidad_campus"), 
                                         rs.getString("institucion")));
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
// FUC - By.Chakalin [13-07-05]    frm_adm_fuc_ingreso
//***********************************************************************************************************       
      public static ArrayList<obj_dos_campos> muestra_criterios_consulta(int modalidad_campus, String mat_idn) {
    
        ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_fuc_criterios_consulta_segun_mod_cam " + modalidad_campus + ",'" + mat_idn + "'" ;
            cs = c.prepareCall(sql);
           // cs.setString(1, "633174");
            ResultSet rs = cs.executeQuery();
            
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
// FUC - By.Chakalin [13-07-05]    frm_adm_fuc_ingreso
//***********************************************************************************************************   
      public static ArrayList<obj_un_campo_string> busca_mod_cam_criterio(String criterio, int modalidad_campus) {
    
        ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_fuc_busca_mod_cam_criterio '" + criterio.trim() + "','" + modalidad_campus + "'" ;
            cs = c.prepareCall(sql);
           // cs.setString(1, "633174");
            ResultSet rs = cs.executeQuery();
            
            while (rs.next()){
            
      
            lista.add(new obj_un_campo_string(rs.getString("mod_cam_criterio")));
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
// FUC - By.Chakalin [13-07-05]    frm_adm_fuc_ingreso
//***********************************************************************************************************      
      public static ArrayList<obj_combo_tres_campos> muestra_motivos_consulta(String mod_cam_criterio, String cri_con_idn) {
    
        ArrayList<obj_combo_tres_campos> lista = new ArrayList<obj_combo_tres_campos>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_fuc_motivo_consulta_muestra '" + mod_cam_criterio.trim() + "', '" + cri_con_idn.trim() + "'" ;
            cs = c.prepareCall(sql); 
           // cs.setString(1, "633174");
            ResultSet rs = cs.executeQuery();
            
            while (rs.next()){
            
      
            lista.add(new obj_combo_tres_campos(rs.getString("data"),
                                                rs.getString("data2"),
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
      public static void inserta_fuc_funcionario(String numero_fuc, String matricula , String consulta, String fun_rut) {
    
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "INSERT INTO fuc_web (fuc_web_idn,fuc_web_fecha_ing, mat_idn, fuc_web_consulta, fun_rut) VALUES (ltrim(rtrim(?)), getdate(), ltrim(rtrim(?)),ltrim(rtrim(?)),ltrim(rtrim(?)))" ;
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1,numero_fuc.trim());
            ps.setString(2,matricula.trim());
            ps.setString(3,consulta.trim());
            ps.setString(4, fun_rut.trim());
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
//***********************************************************************************************************
// frm_adm_fuc_ingreso.mxml --by.SyOuS
//***********************************************************************************************************     
        
    public static ArrayList<obj_un_campo_string> inserta_motivos_fuc(String fuc_numero, String motivo, String division_politica ,String criterio,String tc_idn)  {
    ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
        Connection c=null;
           try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_fuc_inserta_motivos_del_fuc (?,?,?,?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,fuc_numero.trim());
            ps.setString(2,motivo.trim());
            ps.setString(3,division_politica.trim());
            ps.setString(4,criterio.trim());
            ps.setString(5,tc_idn.trim());
            ResultSet rs = ps.executeQuery();
            while (rs.next())
                {
                   lista.add(new obj_un_campo_string( rs.getString("campo_uno")));
                }
            
        } catch (Exception e) {
            
            
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
 // frm_adm_fuc_ingreso.mxml --by.SyOuS
 //***********************************************************************************************************      
      public static ArrayList<obj_tres_campos> ro_fuc_ingresa_carga_mat_por_rut(String alu_rut) {
    
        ArrayList<obj_tres_campos> lista = new ArrayList<obj_tres_campos>();
        Connection c=null;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_adm_fuc_ingresa_carga_matriculas_por_rut '" + alu_rut  + "'";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
        
            while (rs.next()){
            
      
            lista.add(new obj_tres_campos(rs.getString("mat_idn")
                                         , rs.getString("mal_nombre")
                                         , rs.getString("pro_nombre")));
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
   public static void inserta_fuc(String numero_fuc, String matricula , String consulta,String fun_rut) {
    
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "INSERT INTO fuc_web (fuc_web_idn,fuc_web_fecha_ing, mat_idn, fuc_web_consulta,fun_rut) VALUES (ltrim(rtrim(?)), getdate(), ltrim(rtrim(?)),ltrim(rtrim(?)),ltrim(rtrim(?)))" ;
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1,numero_fuc.trim());
            ps.setString(2,matricula.trim());
            ps.setString(3,consulta.trim());
            ps.setString(4,fun_rut.trim());
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
 //***********************************************************************************************************     
//***********************************************************************************************************
 // frm_adm_fuc_tutor.mxml --by.RGN --Cloned.by.SyOuS
 //***********************************************************************************************************          
     public static ArrayList<obj_dos_campos> ro_fuc_muestra_toma_cursos(String mat_idn) {
    
        ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
        
        int salida = 1;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_fuc_muestra_toma_cursos '" + mat_idn + "'";
            cs = c.prepareCall(sql);
           // cs.setString(1, "633174");
            ResultSet rs = cs.executeQuery();
            
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
        
        if (salida == 0)
        {
            lista.add(new obj_dos_campos("n", "n"));
        }
        
        return lista;
    }
//***********************************************************************************************************     
    /** Creates a new instance of frm_adm_fuc_ingreso */
    public frm_adm_fuc_ingreso() {
    }
    
}
