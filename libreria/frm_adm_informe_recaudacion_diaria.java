/*
 * frm_adm_informe_recaudacion_diaria.java
 *
 * Created on 10 de mayo de 2007, 7:26
 */

package libreria;


import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author  Administrador
 */
public class frm_adm_informe_recaudacion_diaria {
    
    /** Creates a new instance of frm_adm_informe_recaudacion_diaria */
    public frm_adm_informe_recaudacion_diaria() {
    }
    
    
     public static ArrayList<obj_dos_campos> muestra_tipo_plazo() {
         ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_pagos_sedes_informe_recaudacion_diaria_muestra_plazo}" ;
            CallableStatement ps = c.prepareCall(sql);
           
            ResultSet rs = ps.executeQuery();
            
            lista.add(new obj_dos_campos("0", "--Seleccione--"));
            
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos(rs.getString("tip_pla_idn"),
                                         rs.getString("tip_pla_nombre")));
           
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
    
     
     public static ArrayList<obj_un_campo_string> obtiene_sede_funcionario(String rut) {
         ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_pagos_sedes_informe_recaudacion_diaria_obtiene_sede (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, rut.trim());
           
            ResultSet rs = ps.executeQuery();
                        
            while (rs.next()){
            
      
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
     
     
       public static ArrayList<obj_dos_campos> muestra_tipo_ingreso_boleta() {
         ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_pagos_sedes_informe_recaudacion_diaria_muestra_tipo_boleta}" ;
            CallableStatement ps = c.prepareCall(sql);
           
            ResultSet rs = ps.executeQuery();
            
            lista.add(new obj_dos_campos("0", "--Seleccione--"));
            
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos(rs.getString("tip_ing_bol_idn"),
                                         rs.getString("tip_ing_bol_nombre")));
           
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
     
     
     public static ArrayList<obj_un_campo_string> obtiene_envio_caja(String fecha , String funcionario, int tipo_ingreso_boleta) {
         ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_pagos_sedes_informe_recaudacion_diaria_crea_envio (?,?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,fecha.trim() );
            ps.setString(2,funcionario.trim() );
            ps.setInt(3,tipo_ingreso_boleta);
            
           
            ResultSet rs = ps.executeQuery();
                        
            while (rs.next()){
            
      
            lista.add(new obj_un_campo_string(rs.getString("identidad")));
           
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
       
     
  
     
    
    
}
