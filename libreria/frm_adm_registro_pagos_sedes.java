/*
 * frm_adm_registro_pagos_sedes.java
 *
 * Created on 29 de enero de 2007, 13:46
 */

package libreria;

import java.util.ArrayList;
import java.io.Serializable;
import java.sql.*;


/**
 *
 * @author  Administrador
 */
public class frm_adm_registro_pagos_sedes {
    
    
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
   
   
   public static ArrayList<obj_nueve_campos> pagos_sedes_muestra_datos_del_pagos(String matricula) {
        ArrayList<obj_nueve_campos> lista = new ArrayList<obj_nueve_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_pagos_sedes_busca_datos_del_pago (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, matricula.trim());
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
      
            lista.add(new obj_nueve_campos(rs.getString("dat_pag_idn"),
                                         rs.getString("dat_pag_ano"),
                                         rs.getString("dat_pag_valor_arancel"),
                                         rs.getString("descuento"),
                                         rs.getString("dat_pag_fecha_ingreso"),
                                         rs.getString("for_pag_nombre"),
                                         rs.getString("med_pag_nom"),
                                         rs.getString("valida_forma_de_pago"),
                                         rs.getString("valida_medio_de_pago")));
           
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
   
   
    public static ArrayList<obj_nueve_campos> pagos_sedes_muestra_pagos(String dato_del_pago) {
        ArrayList<obj_nueve_campos> lista = new ArrayList<obj_nueve_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_pagos_sedes_busca_pagos (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, dato_del_pago.trim());
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
      
            lista.add(new obj_nueve_campos(rs.getString("pag_idn"),
                                         rs.getString("pag_num_cuota"),
                                         rs.getString("pag_fecha_venc"),
                                         rs.getString("pag_val_cuota"),
                                         rs.getString("pag_estado_depago"),
                                         rs.getString("pag_valor_cancelado"),
                                         rs.getString("pag_fecha_pago"),
                                         rs.getString("lot_pag_idn"), 
                                         rs.getString("num_bol")));
           
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
    
   public static ArrayList<obj_tres_campos> pagos_sedes_muestra_deuda(String dato_del_pago) {
        ArrayList<obj_tres_campos> lista = new ArrayList<obj_tres_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_pagos_sedes_muestra_deuda (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, dato_del_pago.trim());
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
      
            lista.add(new obj_tres_campos(rs.getString("pago_minimo"),
                                         rs.getString("pago_atrazado"),
                                         rs.getString("pago_maximo")));
           
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
    
   
   
   
   
    public static ArrayList<Serializable> pagos_sedes_inserta_lote(int monto, String dato_del_pago, String rut_func) {
    ArrayList<Serializable> lista = new ArrayList<Serializable>();
        Connection c=null;
           String msg;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_pagos_sedes_inserta_lote (?,?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setInt(1,monto);
            ps.setString(2,dato_del_pago.trim());
            ps.setString(3,rut_func.trim());
            ResultSet rs = ps.executeQuery();
        
            while (rs.next()){
            
      
            lista.add(new obj_un_campo_string(rs.getString("lote")));
           
            }
            
        } catch (Exception e) {
            e.printStackTrace();
             msg = e.getMessage();
            lista.remove(0);
            lista.add(new obj_dos_campos("0",msg));
            
        } finally {
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        
         return lista;
   }  
    
    
    
    
    
    public frm_adm_registro_pagos_sedes() {
    }
    
}
