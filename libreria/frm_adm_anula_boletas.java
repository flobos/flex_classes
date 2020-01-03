/*
 * frm_adm_anula_boletas.java
 *
 * Created on 23 de mayo de 2007, 10:04 AM
 */

package libreria;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author  Esteban 
 */
public class frm_adm_anula_boletas {
//***********************************************************************************************************                 
        
public static ArrayList<obj_combo_tres_campos> carga_sedes_institucion(String inst_edu_rut) {
    ArrayList<obj_combo_tres_campos> lista = new ArrayList<obj_combo_tres_campos>();
        Connection c=null;
         
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_anula_boletas_carga_sedes_inst (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, inst_edu_rut.trim());
            ResultSet rs = ps.executeQuery();
            
            lista.add(new obj_combo_tres_campos("0","0","-- Seleccione --"));
            
            while (rs.next())
            {
                lista.add(new obj_combo_tres_campos(rs.getString("sed_idn")
                                                    , rs.getString("env_bol_sed_contador")
                                                   , rs.getString("sed_nombre")));
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
    
public static ArrayList<obj_seis_campos> carga_pagos_asignados_boleta(String num_bol) {
    ArrayList<obj_seis_campos> lista = new ArrayList<obj_seis_campos>();
        Connection c=null;
         
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_anula_boletas_carga_pagos_asociados (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, num_bol.trim());
            ResultSet rs = ps.executeQuery();
            
            while (rs.next())
            {
                lista.add(new obj_seis_campos(rs.getString("pag_idn")
                                            , rs.getString("pag_num_cuota")
                                            , rs.getString("pag_fecha_venc")
                                            , rs.getString("pag_val_cuota")
                                            , rs.getString("lot_pag_idn")
                                            , rs.getString("pag_fecha_pago")));
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
    
public static ArrayList<obj_dos_campos> carga_limite_boleta_envio(String fun_rut) {
    ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_anula_boletas_limite_boleta_envio (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, fun_rut.trim());
            ResultSet rs = ps.executeQuery();
            
            while (rs.next())
            {
                lista.add(new obj_dos_campos(rs.getString("env_bol_sed_hasta")
                                                , rs.getString("env_bol_sed_contador")));
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

public static ArrayList<obj_un_campo_string> inserta_nueva_boleta(String fun_rut, String bol_idn_delete) {
    ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
        Connection c=null;
         
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_anula_boletas_inserta_nueva_boleta (?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, fun_rut.trim());
            ps.setString(2, bol_idn_delete.trim());
            ResultSet rs = ps.executeQuery();
            
            rs.next();
            
            lista.add(new obj_un_campo_string(rs.getString("salida")));
       
             
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

public static ArrayList<obj_un_campo_string> verifica_boleta_emitida_sede(String num_bol, String fun_rut) {
    ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
        Connection c=null;
         
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_anula_boletas_verifica_boleta_emitida_sede (?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, num_bol.trim());
            ps.setString(2, fun_rut.trim());
            ResultSet rs = ps.executeQuery();
            
            while (rs.next())
            {
                lista.add(new obj_un_campo_string(rs.getString("salida")));
                                                
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
public static ArrayList<obj_un_campo_string> verifica_funcionario_sede(String fun_rut) {
    ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
        Connection c=null;
         
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_anula_boletas_verifica_sede_funcionario (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, fun_rut.trim());
            ResultSet rs = ps.executeQuery();
            
            while (rs.next())
            {
                lista.add(new obj_un_campo_string(rs.getString("sed_idn")));
                                                
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
    /** Creates a new instance of frm_adm_anula_boletas */
    public frm_adm_anula_boletas() {
    }
        
                    
    
    
}
