/*
 * frm_adm_notas_muestra_historial.java
 *
 * Created on 12 de diciembre de 2007, 9:34
 */

package libreria;

import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author  villanueva
 */
public class frm_adm_notas_muestra_historial {
    
//********************************************************************************  
 public static ArrayList<obj_seis_campos> notas_historial_muestra_matricula_x_matricula(String matricula) {
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
     public static ArrayList<obj_seis_campos> notas_historial_muestra_matricula(String rut) {
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
  
 public static ArrayList<obj_dos_campos> llena_combo_cursos(String mat_idn) {
      ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_adm_evaluaciones_incluidas_promedio_llena_combo_cursos_historial (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
         
                       
            ps.setString(1,mat_idn.trim());
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
     public static ArrayList<obj_seis_campos> llena_grilla_notas(String tc_idn) {
         ArrayList<obj_seis_campos> lista = new ArrayList<obj_seis_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_adm_notas_muestra_historial_llena_grilla_notas (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, tc_idn.trim());
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
      
            lista.add(new obj_seis_campos(rs.getString("not_idn"),
                                         rs.getString("not_nota"),                              
                                         rs.getString("est_pru_idn"),
                                         rs.getString("est_pru_nombre"), 
                                         rs.getString("tip_pru_idn"), 
                                         rs.getString("tip_pru_nombre")
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
     public static ArrayList<obj_cuatro_campos> llena_grilla_notas_historial(String not_idn) {
         ArrayList<obj_cuatro_campos> lista = new ArrayList<obj_cuatro_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_adm_notas_muestra_historial_muestra_notas (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, not_idn.trim());
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
      
            lista.add(new obj_cuatro_campos(rs.getString("not_his_nota_original"),
                                         rs.getString("est_pru_nombre"),                              
                                         rs.getString("not_his_fecha_ingreso"),
                                         rs.getString("tip_not_his_nombre")  
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
     
    
    
//**************************************************    
    public frm_adm_notas_muestra_historial() {
    }
    
}
