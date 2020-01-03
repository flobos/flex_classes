/*
 * frm_adm_evaluaciones_includidas_promedio.java
 *
 * Created on 6 de septiembre de 2007, 17:46
 */
package libreria;

import java.util.ArrayList;
import java.sql.*;


/**
 *
 * @author  villanueva
 */
public class frm_adm_evaluaciones_includidas_promedio {
    
//********************************************************************************  
 public static ArrayList<obj_seis_campos> pagos_sedes_muestra_matricula_x_matricula(String matricula) {
        ArrayList<obj_seis_campos> lista = new ArrayList<obj_seis_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_pagos_sedes_buscar_matricula_x_mat_idn (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, matricula.trim());
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
      
            lista.add(new obj_seis_campos(rs.getString("alu_idn"),
                                         rs.getString("alu_rut"),
                                         rs.getString("nombre"),
                                         rs.getString("mat_idn"),
                                         rs.getString("mal_nombre"),
                                         rs.getString("pro_nombre")));
           
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
//*****************************************************************************
     public static ArrayList<obj_seis_campos> pagos_sedes_muestra_matricula(String rut) {
         ArrayList<obj_seis_campos> lista = new ArrayList<obj_seis_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_pagos_sedes_buscar_matricula (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, rut.trim());
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
      
            lista.add(new obj_seis_campos(rs.getString("alu_idn"),
                                         rs.getString("alu_rut"),
                                         rs.getString("nombre"),
                                         rs.getString("mat_idn"),
                                         rs.getString("mal_nombre"),
                                         rs.getString("pro_nombre")));
           
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
 //*********************************************************************
  
 public static ArrayList<obj_dos_campos> llena_combo_cursos(String mat_idn, String activa) {
      ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_adm_evaluaciones_incluidas_promedio_llena_combo_cursos (?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
         
                       
            ps.setString(1,mat_idn.trim());
            ps.setString(2,activa.trim());
            ps.execute();
            
            
            
                      
            ResultSet rs = ps.executeQuery();
            
             
              lista.add(new obj_dos_campos("0"," - Seleccione - "));
                 
            
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos (rs.getString("tc_idn"), 
                                         rs.getString("cur_nombre")));
           
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
 
 //*****************************************************************************
     public static ArrayList<obj_diecisiete_campos> llena_grilla_notas_incluidas(String tc_idn) {
         ArrayList<obj_diecisiete_campos> lista = new ArrayList<obj_diecisiete_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_adm_evaluaciones_incluidas_promedio_grilla (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, tc_idn.trim());
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
      
            lista.add(new obj_diecisiete_campos(rs.getString("not_idn"),
                                         rs.getString("not_nota"),
                                         rs.getString("not_fecha"),
                                         rs.getString("trab_idn"),
                                         rs.getString("est_pru_idn"),
                                         rs.getString("est_pru_nombre"), 
                                         rs.getString("fecha_toma_prue"), 
                                         rs.getString("tip_pru_idn"), 
                                         rs.getString("tip_pru_nombre"), 
                                         rs.getString("not_ponderacion"), 
                                         rs.getString("not_fecha_ter_ing_trab"), 
                                         rs.getString("not_fecha_ter_ing_nota"),
                                         rs.getString("not_incluye_promedio"),
                                         rs.getString("incluye"),
                                         rs.getString("pro_eva_idn"),
                                         rs.getString("pro_eva_ponderacion"),
                                         rs.getString("tip_pro_eva_nombre")
                                         
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
     

//*****************************************************************************
     public static ArrayList<obj_doce_campos> llena_grilla_notas_NO_incluidas(String tc_idn) {
         ArrayList<obj_doce_campos> lista = new ArrayList<obj_doce_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_adm_evaluaciones_incluidas_promedio_llena_grilla_notas_NO_incluidas (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, tc_idn.trim());
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
      
            lista.add(new obj_doce_campos(rs.getString("not_idn"),
                                         rs.getString("not_nota"),
                                         rs.getString("not_fecha"),
                                         rs.getString("trab_idn"),
                                         rs.getString("est_pru_idn"),
                                         rs.getString("est_pru_nombre"), 
                                         rs.getString("fecha_toma_prue"), 
                                         rs.getString("tip_pru_idn"), 
                                         rs.getString("tip_pru_nombre"), 
                                         rs.getString("not_ponderacion"), 
                                         rs.getString("not_fecha_ter_ing_trab"), 
                                         rs.getString("not_fecha_ter_ing_nota")
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
 //****************************************************************************
        public static void modifica_evaluaciones_incluidas_promedio(String not_idn_no,String not_idn_si)
                                                    
       {
     
        Connection c=null;

        try {
                String sql;
                c = conexion_odbc.Connexion_datos();
                  
                sql = "{call frm_adm_evaluaciones_incluidas_promedio_modifica_evaluciones_incluye_promedio (?,?)}";//
                PreparedStatement ps = c.prepareStatement(sql);
                ps.setString(1,not_idn_no.trim());
                ps.setString(2,not_idn_si.trim());
               
                ps.execute();
           }
        
                catch (Exception e) 
           {
                e.printStackTrace();
            } 
        finally {
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
    }
//******************************************************************************
             
     public static ArrayList<obj_dos_campos> llena_combo_estado_prueba() {
      ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_adm_evaluciones_incluidas_promedio_combo_estado_prueba()}" ;
            CallableStatement ps = c.prepareCall(sql);
         
                      
            ResultSet rs = ps.executeQuery();
            
             
              lista.add(new obj_dos_campos("0"," - Seleccione - "));
                 
            
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos (rs.getString("est_pru_idn"), 
                                         rs.getString("est_pru_nombre")));
           
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

 //**************************************************************************
 public static ArrayList<obj_dos_campos> guarda_datos_notas(String not_idn,String not_fecha_ter_ing_trab,String not_fecha_ter_ing_nota,String est_pru_idn) {
    ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
        String msg;
        msg = "OK";
        int salida = 1;
       
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_adm_evaluaciones_incluidas_promedio_modifica_datos_notas (?,?,?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,not_idn .trim());
            ps.setString(2,not_fecha_ter_ing_trab.trim()); 
            ps.setString(3,not_fecha_ter_ing_nota.trim());
            ps.setString(4,est_pru_idn.trim());
            ps.execute();
            
        } catch (Exception e) {
            e.printStackTrace();
           
            msg = e.getMessage();
            salida = 0;
            
        } finally {
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        if (salida == 1){
        lista.add(new obj_dos_campos("1", msg));
        }else{
        lista.add(new obj_dos_campos("0", msg));
        }
        
         return lista;
   } 
 //*****************************************************************************
     public static ArrayList<obj_cinco_campos> llena_grilla_evaluaciones_ejecucion_academica(String tc_idn) {
         ArrayList<obj_cinco_campos> lista = new ArrayList<obj_cinco_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_adm_evaluaciones_incluidas_promedio_llena_grilla_evaluaciones_ejecuacion_academica (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, tc_idn.trim());
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
      
              lista.add(new obj_cinco_campos (rs.getString("eva_eje_idn"), 
                                          rs.getString("tip_pru_nombre"),
                                          rs.getString("eva_eje_ponderacion"),
                                              rs.getString("eva_eje_fecha"),
                                                   rs.getString("eva_eje_disponible")
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
     
//******************************************************************************
  public static ArrayList<?> incluye_evaluacion_prueba_extension(String tc_idn,String eva_eje_idn,String not_idn,String not_ponderacion) {
    
           
   ArrayList<?> lista = new ArrayList<Object>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_adm_evaluaciones_incluidas_promedio_incluye_prueba_extension(?,?,?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, tc_idn.trim());
            ps.setString(2, eva_eje_idn.trim());
            ps.setString(3, not_idn.trim());
            ps.setString(4, not_ponderacion.trim());
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
         return lista;
   } 
  
//******************************************************************************
  public static ArrayList<?> incluye_evaluacion_repechaje(String tc_idn,String eva_eje_idn) {
    
           
   ArrayList<?> lista = new ArrayList<Object>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_adm_evaluaciones_incluidas_promedio_incluye_repechaje(?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, tc_idn.trim());
            ps.setString(2, eva_eje_idn.trim());
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
         return lista;
   } 
     
     
 
 
//*****************************************************************************    
  
    public static ArrayList<obj_diecisiete_campos> elimina_evaluacion_repechaje(String tc_idn,String not_idn) {
    
           
   ArrayList<obj_diecisiete_campos> lista = new ArrayList<obj_diecisiete_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_adm_evaluaciones_incluidas_promedio_elimina_nota(?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, tc_idn.trim());
            ps.setString(2, not_idn.trim());
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
                lista.add(new obj_diecisiete_campos(rs.getString("not_idn"),
                                         rs.getString("not_nota"),
                                         rs.getString("not_fecha"),
                                         rs.getString("trab_idn"),
                                         rs.getString("est_pru_idn"),
                                         rs.getString("est_pru_nombre"), 
                                         rs.getString("fecha_toma_prue"), 
                                         rs.getString("tip_pru_idn"), 
                                         rs.getString("tip_pru_nombre"), 
                                         rs.getString("not_ponderacion"), 
                                         rs.getString("not_fecha_ter_ing_trab"), 
                                         rs.getString("not_fecha_ter_ing_nota"),
                                         rs.getString("not_incluye_promedio"),
                                         rs.getString("incluye"),
                                         rs.getString("pro_eva_idn"),
                                         rs.getString("pro_eva_ponderacion"),
                                         rs.getString("tip_pro_eva_nombre")
                                         
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
     
     
 
 
//*****************************************************************************    
  
   public static ArrayList<?> cambio_estado_nota(String not_idn, String not_incluye_promedio) {
    
           
         ArrayList<?> lista = new ArrayList<Object>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_adm_evaluaciones_incluidas_promedio_cambia_estado_nota(?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, not_idn.trim());
            ps.setString(2, not_incluye_promedio.trim());
            
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
         return lista;
   } 
     
     
 
 
//*****************************************************************************    
 
    public static ArrayList<obj_diecisiete_campos> modifica_nota(String not_fecha, String not_idn, String tc_idn, String nota) {
    
           
        ArrayList<obj_diecisiete_campos> lista = new ArrayList<obj_diecisiete_campos>();
        Connection c=null;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_adm_evaluaciones_incluidas_promedio_modifica_nota(?,?,?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, not_fecha.trim());
            ps.setString(2, not_idn.trim());
            ps.setString(3, tc_idn.trim());
            ps.setString(4, nota.trim());
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
                lista.add(new obj_diecisiete_campos(rs.getString("not_idn"),
                                         rs.getString("not_nota"),
                                         rs.getString("not_fecha"),
                                         rs.getString("trab_idn"),
                                         rs.getString("est_pru_idn"),
                                         rs.getString("est_pru_nombre"), 
                                         rs.getString("fecha_toma_prue"), 
                                         rs.getString("tip_pru_idn"), 
                                         rs.getString("tip_pru_nombre"), 
                                         rs.getString("not_ponderacion"), 
                                         rs.getString("not_fecha_ter_ing_trab"), 
                                         rs.getString("not_fecha_ter_ing_nota"),
                                         rs.getString("not_incluye_promedio"),
                                         rs.getString("incluye"),
                                         rs.getString("pro_eva_idn"),
                                         rs.getString("pro_eva_ponderacion"),
                                         rs.getString("tip_pro_eva_nombre")
                                         
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
     
     
 
 
//*****************************************************************************   
    
  
    /** Creates a new instance of frm_adm_evaluaciones_includidas_promedio */
    public frm_adm_evaluaciones_includidas_promedio() {

    }
   
}
