/*
 * frm_biblioteca_material_recepcion.java
 *
 * Created on 14 de abril de 2009
 */

package libreria;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author Joliveros
 */
public class frm_info_busca_datos_alumno {
    
    
//******************************************************************************************************************************************************    
     public static ArrayList<obj_cuatro_campos> busca_alumno_por_apellido (String alu_apellido) {
         ArrayList<obj_cuatro_campos> lista = new ArrayList<obj_cuatro_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_info_busca_datos_alumno_por_apellido(?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, alu_apellido.trim());
            ResultSet rs = ps.executeQuery();
            
            
             while (rs.next()){
            
                lista.add(new obj_cuatro_campos(rs.getString("alu_idn"),
                                                rs.getString("alu_rut"),
                                                rs.getString("alu_nombre"),
                                                rs.getString("alu_apellidos")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally 
          {
            try 
            {
                c.close();
            } 
            catch (SQLException e) 
            {
                e.printStackTrace();
            }
          }
         return lista;
   }  

//******************************************************************************************************************************************************    
     public static ArrayList<obj_cuatro_campos> busca_alumno_por_matricula (String mat_idn) {
         ArrayList<obj_cuatro_campos> lista = new ArrayList<obj_cuatro_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_info_busca_datos_alumno_por_matricula(?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, mat_idn.trim());
            ResultSet rs = ps.executeQuery();
            
            
             while (rs.next()){
            
                lista.add(new obj_cuatro_campos(rs.getString("alu_idn"),
                                                rs.getString("alu_rut"),
                                                rs.getString("alu_nombre"),
                                                rs.getString("alu_apellidos")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally 
          {
            try 
            {
                c.close();
            } 
            catch (SQLException e) 
            {
                e.printStackTrace();
            }
          }
         return lista;
   }       
     
//******************************************************************************************************************************************************    
     public static ArrayList<obj_cuatro_campos> buscar_institucion (String mat_idn) {
         ArrayList<obj_cuatro_campos> lista = new ArrayList<obj_cuatro_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_info_busca_datos_alumno_buscar_institucion(?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, mat_idn.trim());
            ResultSet rs = ps.executeQuery();
            
            
             while (rs.next()){
            
                lista.add(new obj_cuatro_campos(rs.getString("inst_edu_nombre"),
                                                rs.getString("fac_nombre"),
                                                rs.getString("esc_nombre"),
                                                rs.getString("dpt_edu_nombre")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally 
          {
            try 
            {
                c.close();
            } 
            catch (SQLException e) 
            {
                e.printStackTrace();
            }
          }
         return lista;
   }  
//******************************************************************************************************************************************************    
     public static ArrayList<obj_dos_campos> buscar_matriculas (String alu_idn) {
         ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_info_busca_datos_alumno_busca_matriculas(?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, alu_idn.trim());
            ResultSet rs = ps.executeQuery();
            
             while (rs.next()){
            
                lista.add(new obj_dos_campos(rs.getString("mat_idn"),
                                             rs.getString("mat_carrera")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally 
          {
            try 
            {
                c.close();
            } 
            catch (SQLException e) 
            {
                e.printStackTrace();
            }
          }
         return lista;
   }  

//******************************************************************************************************************************************************    
     public static ArrayList<obj_dos_campos> buscar_matricula_por_toma (String tc_idn) {
         ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_info_busca_datos_alumno_busca_matricula_por_toma(?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, tc_idn.trim());
            ResultSet rs = ps.executeQuery();
            
             while (rs.next()){
            
                lista.add(new obj_dos_campos(rs.getString("mat_idn"),
                                             rs.getString("mat_carrera")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally 
          {
            try 
            {
                c.close();
            } 
            catch (SQLException e) 
            {
                e.printStackTrace();
            }
          }
         return lista;
   }       
     
//******************************************************************************************************************************************************    
     public static ArrayList<obj_dos_campos> buscar_info_matricula (String mat_idn) {
         ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_info_busca_datos_alumno_busca_info_matricula(?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, mat_idn.trim());
            ResultSet rs = ps.executeQuery();
            
             while (rs.next()){
            
                lista.add(new obj_dos_campos(rs.getString("mat_idn"),
                                             rs.getString("mat_carrera")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally 
          {
            try 
            {
                c.close();
            } 
            catch (SQLException e) 
            {
                e.printStackTrace();
            }
          }
         return lista;
   }       
     
//******************************************************************************************************************************************************    
     public static ArrayList<obj_cinco_campos> buscar_cursos (String mat_idn) {
         ArrayList<obj_cinco_campos> lista = new ArrayList<obj_cinco_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_info_busca_datos_alumno_buscar_cursos(?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, mat_idn.trim());
            ResultSet rs = ps.executeQuery();
            
            
             while (rs.next()){
            
                lista.add(new obj_cinco_campos( rs.getString("eje_aca_idn"),
                                                rs.getString("tc_idn"),
                                                rs.getString("pro_cam_idn"),
                                                rs.getString("curso"),
                                                rs.getString("ejecucion")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally 
          {
            try 
            {
                c.close();
            } 
            catch (SQLException e) 
            {
                e.printStackTrace();
            }
          }
         return lista;
   }  
 //******************************************************************************************************************************************************    
     public static ArrayList<obj_cinco_campos> buscar_curso_por_toma (String tc_idn) {
         ArrayList<obj_cinco_campos> lista = new ArrayList<obj_cinco_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_info_busca_datos_alumno_buscar_curso_por_toma(?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, tc_idn.trim());
            ResultSet rs = ps.executeQuery();
            
            
             while (rs.next()){
            
                lista.add(new obj_cinco_campos( rs.getString("eje_aca_idn"),
                                                rs.getString("tc_idn"),
                                                rs.getString("pro_cam_idn"),
                                                rs.getString("curso"),
                                                rs.getString("ejecucion")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally 
          {
            try 
            {
                c.close();
            } 
            catch (SQLException e) 
            {
                e.printStackTrace();
            }
          }
         return lista;
   }  
 //******************************************************************************************************************************************************    
     public static ArrayList<obj_once_campos> buscar_pago (String mat_idn) {
         ArrayList<obj_once_campos> lista = new ArrayList<obj_once_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_info_busca_datos_alumno_buscar_pago(?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, mat_idn.trim());
            ResultSet rs = ps.executeQuery();
            
            
             while (rs.next()){
            
                lista.add(new obj_once_campos(  rs.getString("dat_pag_idn"),
                                                rs.getString("dat_pag_valor_arancel"),
                                                rs.getString("dat_pag_descuento"),
                                                rs.getString("dat_pag_can_cuota"),
                                                rs.getString("med_pag_nom"),
                                                rs.getString("lug_pag_nombre"),
                                                rs.getString("tip_pag_nombre"),
                                                rs.getString("env_doc_nombre"),
                                                rs.getString("for_pag_nombre"),
                                                rs.getString("con_pag_nombre"),
                                                rs.getString("ele_pag_nombre")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally 
          {
            try 
            {
                c.close();
            } 
            catch (SQLException e) 
            {
                e.printStackTrace();
            }
          }
         return lista;
   }  
//******************************************************************************************************************************************************    
     public static ArrayList<obj_siete_campos> buscar_cuotas_pago (String dat_pag_idn) {
         ArrayList<obj_siete_campos> lista = new ArrayList<obj_siete_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_info_busca_datos_alumno_buscar_cuotas_pago(?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, dat_pag_idn.trim());
            ResultSet rs = ps.executeQuery();
            
            
             while (rs.next()){
            
                lista.add(new obj_siete_campos(  rs.getString("pag_idn"),
                                                rs.getString("pag_num_cuota"),
                                                rs.getString("pag_val_cuota"),
                                                rs.getString("pag_fecha_venc"),
                                                rs.getString("pag_estado_nombre"),
                                                rs.getString("pag_valor_cancelado"),
                                                rs.getString("pag_fecha_pago")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally 
          {
            try 
            {
                c.close();
            } 
            catch (SQLException e) 
            {
                e.printStackTrace();
            }
          }
         return lista;
   }           
 //******************************************************************************************************************************************************    
     public static ArrayList<obj_cinco_campos> buscar_curso_por_trabajo (String trab_idn) {
         ArrayList<obj_cinco_campos> lista = new ArrayList<obj_cinco_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_info_busca_datos_alumno_buscar_curso_por_trabajo(?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, trab_idn.trim());
            ResultSet rs = ps.executeQuery();
            
            
             while (rs.next()){
            
                lista.add(new obj_cinco_campos( rs.getString("eje_aca_idn"),
                                                rs.getString("tc_idn"),
                                                rs.getString("pro_cam_idn"),
                                                rs.getString("curso"),
                                                rs.getString("ejecucion")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally 
          {
            try 
            {
                c.close();
            } 
            catch (SQLException e) 
            {
                e.printStackTrace();
            }
          }
         return lista;
   }  
     
//******************************************************************************************************************************************************    
     public static ArrayList<?> eliminar_trabajo (String trab_idn) {
         ArrayList<?> lista = new ArrayList<Object>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_info_busca_datos_alumno_eliminar_trabajo(?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, trab_idn.trim());
            ps.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        } finally 
          {
            try 
            {
                c.close();
            } 
            catch (SQLException e) 
            {
                e.printStackTrace();
            }
          }
         return lista;
   } 
//******************************************************************************************************************************************************    
     public static ArrayList<obj_diez_campos> buscar_pruebas (String tc_idn) {
         ArrayList<obj_diez_campos> lista = new ArrayList<obj_diez_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_info_busca_datos_alumno_buscar_pruebas(?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, tc_idn.trim());
            ResultSet rs = ps.executeQuery();
            
            
             while (rs.next()){
            
                lista.add(new obj_diez_campos( rs.getString("eva_eje_idn"),
                                                rs.getString("eva_eje_archivo_web"),
                                                rs.getString("trab_idn"),
                                                rs.getString("tip_pru_nombre"),
                                                rs.getString("sit_eva_nombre"),
                                                rs.getString("mod_ren_pru_nombre"),
                                                rs.getString("not_nota"),
                                                rs.getString("tc_promedio"),
                                                rs.getString("est_pru_nombre"),
                                                rs.getString("not_idn")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally 
          {
            try 
            {
                c.close();
            } 
            catch (SQLException e) 
            {
                e.printStackTrace();
            }
          }
         return lista;
   } 
//******************************************************************************************************************************************************    
     public static ArrayList<obj_diez_campos> buscar_trabajo (String trab_idn) {
         ArrayList<obj_diez_campos> lista = new ArrayList<obj_diez_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_info_busca_datos_alumno_buscar_prueba_por_trabajo(?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, trab_idn.trim());
            ResultSet rs = ps.executeQuery();
            
            
             while (rs.next()){
            
                lista.add(new obj_diez_campos( rs.getString("eva_eje_idn"),
                                                rs.getString("eva_eje_archivo_web"),
                                                rs.getString("trab_idn"),
                                                rs.getString("tip_pru_nombre"),
                                                rs.getString("sit_eva_nombre"),
                                                rs.getString("mod_ren_pru_nombre"),
                                                rs.getString("not_nota"),
                                                rs.getString("tc_promedio"),
                                                rs.getString("est_pru_nombre"),
                                                rs.getString("not_idn")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally 
          {
            try 
            {
                c.close();
            } 
            catch (SQLException e) 
            {
                e.printStackTrace();
            }
          }
         return lista;
   }      
//******************************************************************************************************************************************************    
     public static ArrayList<obj_dos_campos> buscar_respuestas (String trab_idn) {
         ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_info_busca_datos_alumno_buscar_respuestas_por_trabajo(?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, trab_idn.trim());
            ResultSet rs = ps.executeQuery();
            
            
             while (rs.next()){
            
                lista.add(new obj_dos_campos( rs.getString("eje_aca_preg_pregunta"),
                                              rs.getString("eje_aca_res_respuesta")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally 
          {
            try 
            {
                c.close();
            } 
            catch (SQLException e) 
            {
                e.printStackTrace();
            }
          }
         return lista;
   }     
     //******************************************************************************************************************************************************    
     public static ArrayList<?> recalcular_nota (String trab_idn) {
         ArrayList<?> lista = new ArrayList<Object>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_pruebas_objetiva_rendir_calcula_nota(?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, trab_idn.trim());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally 
          {
            try 
            {
                c.close();
            } 
            catch (SQLException e) 
            {
                e.printStackTrace();
            }
          }
         return lista;
   }     
//******************************************************************************************************************************************************    
     public static ArrayList<obj_nueve_campos> busca_ficha_personal (String alu_idn) {
         ArrayList<obj_nueve_campos> lista = new ArrayList<obj_nueve_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_info_busca_datos_alumno_ficha_personal(?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, alu_idn.trim());
            ResultSet rs = ps.executeQuery();
            
            
             while (rs.next()){
            
                lista.add(new obj_nueve_campos( rs.getString("alu_rut"),
                                                rs.getString("alu_nombre_completo"),
                                                rs.getString("alu_direccion"),
                                                rs.getString("alu_fono"),
                                                rs.getString("alu_fecha_ing"),
                                                rs.getString("alu_clave"),
                                                rs.getString("alu_email"),
                                                rs.getString("alu_region"),
                                                rs.getString("alu_pais")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally 
          {
            try 
            {
                c.close();
            } 
            catch (SQLException e) 
            {
                e.printStackTrace();
            }
          }
         return lista;
   } 
//******************************************************************************************************************************************************        
    public frm_info_busca_datos_alumno() {
    }
    
}
