/*
 * frm_adm_info_matriculas.java
 *
 * Created on 22 de diciembre de 2005, 09:05 AM
 */

package libreria;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author  Esteban
 */
public class frm_adm_info_matriculas {
      //***********************************************************************************************************
 // frm_adm_info_matriculas.mxml --by.RGN
 //***********************************************************************************************************      
      public static ArrayList<obj_dos_campos> busca_promocion_envio_matricula(String matricula) {
    
        ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_busca_promocion_envio_matricula '" + matricula +"'" ;
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
        
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos(rs.getString("data"),rs.getString("label")));
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
// frm_adm_info_matriculas.xmls     
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
      public static ArrayList<obj_tres_campos> ro_carga_matriculas_alumno_por_rut_ipla(String alu_rut) {
    	    
          ArrayList<obj_tres_campos> lista = new ArrayList<obj_tres_campos>();
          Connection c=null;
          try {
              String sql;
              c = conexion_odbc.Connexion_datos();
              CallableStatement cs;
              sql = "flex_adm_info_mat_matriculas_alumno_ipla '" + alu_rut + "'";
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
 // frm_adm_info_matriculas.mxml --by.SyOuS
 //***********************************************************************************************************      
      public static ArrayList<obj_once_campos> ro_carga_datos_alumno(String alu_idn) {
    
        ArrayList<obj_once_campos> lista = new ArrayList<obj_once_campos>();
        Connection c=null;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_adm_info_mat_datos_alumno '" + alu_idn + "'";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
        
            while (rs.next()){
            
      
      
            lista.add(new obj_once_campos(rs.getString("alu_nombre")
                                        , rs.getString("alu_clave")
                                        , rs.getString("alu_direccion")
                                        , rs.getString("alu_fono")
                                        , rs.getString("alu_email")
                                        , rs.getString("alu_fecha_ing")
                                        , rs.getString("seg_div_pol_nombre")                
                                        , rs.getString("est_nombre")
                                        , rs.getString("est_direccion")
                                        , rs.getString("est_fono")                                       
                                        , rs.getString("est_seg_div_pol_nombre")));
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
      public static ArrayList<obj_siete_campos> ro_carga_despacho_alumno(String matricula) {
    
        ArrayList<obj_siete_campos> lista = new ArrayList<obj_siete_campos>();
        Connection c=null;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_adm_info_mat_muestra_despacho '" + matricula + "'";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
        
            while (rs.next()){
            
      
      
            lista.add(new obj_siete_campos(rs.getString("desp_idn")
                                        , rs.getString("desp_estado")
                                        , rs.getString("mat_apoyo_nombre")
                                        , rs.getString("paq_desp_fecha")
                                        , rs.getString("via_despacho_nombre")
                                        , rs.getString("paq_desp_num_boleta")
                                        , rs.getString("est_gest_nombre")));
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
 // frm_adm_info_matriculas.mxml --by.SyOuS
 //***********************************************************************************************************      
      public static ArrayList<obj_doce_campos> ro_carga_notas_alumno(String toma_curso) {
    
        ArrayList<obj_doce_campos> lista = new ArrayList<obj_doce_campos>();
        Connection c=null;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_adm_info_mat_detalle_notas '" + toma_curso + "'";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
        
            while (rs.next()){
            
      
      
            lista.add(new obj_doce_campos(rs.getString("not_idn")
                                        , rs.getString("cur_nombre")
                                        , rs.getString("not_nota")
                                        , rs.getString("not_fecha")
                                        , rs.getString("pond_porcent_calif")
                                        , rs.getString("fecha_toma_prue")
                                        , rs.getString("tip_pru_nombre")
                                        , rs.getString("est_pru_nombre")
                                        , rs.getString("mod_nombre")                                        
                                        , rs.getString("trab_idn")
                                        , rs.getString("fecha_disponibilidad_prueba")                                        
                                        , rs.getString("not_fecha_ter_ing_trab")));
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
      public static ArrayList<obj_cuatro_campos> busca_productos(String mat_idn) {
    
        ArrayList<obj_cuatro_campos> lista = new ArrayList<obj_cuatro_campos>();
        Connection c=null;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_adm_info_mat_muestra_productos '" + mat_idn + "'";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
        
            while (rs.next()){
            
      
      
            lista.add(new obj_cuatro_campos(rs.getString("pro_cam_idn")
            							, rs.getString("cur_nombre")
                                        , rs.getString("sem_nombre")
                                        , rs.getString("sem_idn")));
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
 // frm_adm_info_matriculas.mxml --by.SyOuS
 //***********************************************************************************************************      
      public static ArrayList<obj_nueve_campos> ro_carga_datos_pago_alumno(String matricula) {
    
        ArrayList<obj_nueve_campos> lista = new ArrayList<obj_nueve_campos>();
        Connection c=null;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_adm_info_mat_muestra_datos_pago '" + matricula + "'";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
        
            while (rs.next()){
            
      
      
            lista.add(new obj_nueve_campos(rs.getString("dat_pag_idn")
                                        , rs.getString("mat_idn")
                                        , rs.getString("dat_pag_fecha_inicio")
                                        , rs.getString("dat_pag_valor_arancel")
                                        , rs.getString("dat_pag_descuento")
                                        , rs.getString("dat_pag_can_cuota")
                                        , rs.getString("mat_orden_venta")
                                        , rs.getString("for_pag_nombre")
                                        , rs.getString("concepto_pago")));
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
      public static ArrayList<obj_seis_campos> ro_carga_toma_curso_alumno(String matricula) {
    
        ArrayList<obj_seis_campos> lista = new ArrayList<obj_seis_campos>();
        Connection c=null;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_adm_info_mat_muestra_toma_curso '" + matricula + "'";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
        
            while (rs.next()){
            
      
      
            lista.add(new obj_seis_campos(rs.getString("tc_idn")
                                        , rs.getString("cur_nombre")
                                        , rs.getString("eje_aca_idn")
                                        , rs.getString("eje_nombre")
                                        , rs.getString("sit_tom_nombre")
                                        , rs.getString("tc_promedio")));
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
 // frm_adm_info_matriculas.mxml --by.SyOuS
 //***********************************************************************************************************      
      public static ArrayList<obj_ocho_campos> ro_carga_pagos_alumno(String dato_pago) {
    
        ArrayList<obj_ocho_campos> lista = new ArrayList<obj_ocho_campos>();
        Connection c=null;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_adm_info_mat_detalle_pagos '" + dato_pago + "'";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
        
            while (rs.next()){

            lista.add(new obj_ocho_campos(rs.getString("pag_idn")
                                        , rs.getString("pag_num_cuota")
                                        , rs.getString("pag_fecha_venc")
                                        , rs.getString("pag_val_cuota")
                                        , rs.getString("pag_estado_depago")
                                        , rs.getString("pag_valor_cancelado")
                                        , rs.getString("bol_idn")
                                        , rs.getString("lot_pag_idn")));
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
      
      public static ArrayList<obj_dos_campos> ro_carga_alumnos_por_apellido_ipla(String alu_ap_paterno) {
    	    
          ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
          Connection c=null;
          try {
              String sql;
              c = conexion_odbc.Connexion_datos();
              CallableStatement cs;
              sql = "flex_adm_info_mat_busca_alumnos_por_apeliido_ipla '" + alu_ap_paterno + "'";
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
 // frm_adm_tutor_visualiza_notas.mxml --by.SyOuS
 //***********************************************************************************************************      
      public static ArrayList<obj_un_campo_string> ro_carga_alumnos_por_matricula(String matricula) {
    
        ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
        Connection c=null;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_adm_info_mat_busca_alumno_por_matricula '" + matricula + "'";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
        
            while (rs.next()){
            
      
      
            lista.add(new obj_un_campo_string(rs.getString("alu_rut")));
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
      public static ArrayList<obj_un_campo_string> ro_carga_alumnos_por_matricula_ipla(String matricula) {
    	    
          ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
          Connection c=null;
          try {
              String sql;
              c = conexion_odbc.Connexion_datos();
              CallableStatement cs;
              sql = "flex_adm_info_mat_busca_alumno_por_matricula_ipla '" + matricula + "'";
              cs = c.prepareCall(sql);
              ResultSet rs = cs.executeQuery();
          
              while (rs.next()){
              
        
        
              lista.add(new obj_un_campo_string(rs.getString("alu_rut")));
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
 // frm_adm_info_matriculas.mxml --by.SyOuS
 //***********************************************************************************************************      
      public static ArrayList<obj_un_campo_string> ro_carga_coordinador(String matricula) {
    
        ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
        Connection c=null;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "SELECT b.cor_vend_nombre FROM matriculas a, coordinadores_vendedores b WHERE a.mat_idn = '" + matricula  + "' and b.cor_vend_rut = a.cor_vend_rut";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
        
            while (rs.next()){
            
      
            lista.add(new obj_un_campo_string(rs.getString("cor_vend_nombre")));
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
 // frm_adm_info_matriculas.mxml --by.SyOuS
 //***********************************************************************************************************      
      public static ArrayList<obj_un_campo_string> ro_carga_estado_renuncia(String matricula) {
    
        ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
        Connection c=null;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "SELECT est_ren_nombre FROM matriculas a, estado_renuncia b WHERE a.mat_idn = '" + matricula  + "' and b.est_ren_idn = a.est_ren_idn";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
        
            while (rs.next()){
            
      
            lista.add(new obj_un_campo_string(rs.getString("est_ren_nombre")));
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
    /** Creates a new instance of frm_adm_info_matriculas */
    public frm_adm_info_matriculas() {
    }
    
}
