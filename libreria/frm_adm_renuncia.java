/*
 * frm_adm_pago_elementos_conceptos.java
 *
 * Created on 28 de junio de 2007, 11:09 AM
 */

package libreria;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author  Esteban 
 */
public class frm_adm_renuncia {
    
 //***********************************************************************************************************      
      public static ArrayList<obj_un_campo_string> carga_alumnos_por_matricula(String matricula) {
    
        ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
        Connection c=null;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_adm_renuncia_busca_alumno_por_matricula '" + matricula + "'";
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
      public static ArrayList<obj_cuatro_campos> carga_matriculas_alumno_por_rut(String alu_rut) {
    
        ArrayList<obj_cuatro_campos> lista = new ArrayList<obj_cuatro_campos>();
        Connection c=null;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_adm_renuncia_carga_matriculas_alumno '" + alu_rut + "'";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
        
            while (rs.next()){
            
      
      
            lista.add(new obj_cuatro_campos(rs.getString("mat_idn")
                                        , rs.getString("mal_nombre")
                                        , rs.getString("alu_idn")
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
      public static ArrayList<obj_dos_campos> carga_datos_alumno(String alu_idn) {
    
        ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_adm_renuncia_carga_datos_alumno '" + alu_idn + "'";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            
            while (rs.next())
            {
                lista.add(new obj_dos_campos(rs.getString("alu_rut")
                                           , rs.getString("alu_nombre")));
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
    
    
     public static ArrayList<obj_seis_campos> muestra_pagos_segun_matricula(String mat_idn) {
    
        ArrayList<obj_seis_campos> lista = new ArrayList<obj_seis_campos>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_adm_renuncia_muestra_pagos_segun_matricula '" + mat_idn + "'";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            
            
            //lista.add(new obj_dos_campos("0", "-- Seleccione --")); 
            
            while (rs.next())
            {
                lista.add(new obj_seis_campos(rs.getString("pag_idn")
                                            , rs.getString("dat_pag_ano")
                                            , rs.getString("pag_num_cuota")
                                            , rs.getString("pag_val_cuota")
                                            , rs.getString("pag_estado_depago")
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
    
   //----------------------------------------------------------------------------------------------------------
     
    
     public static ArrayList<obj_cinco_campos> muestra_toma_de_curso_activas_segun_matricula(String mat_idn) {
    
        ArrayList<obj_cinco_campos> lista = new ArrayList<obj_cinco_campos>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_adm_renuncia_muestra_toma_de_curso_activas_segun_matricula '" + mat_idn + "'";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            
            
            //lista.add(new obj_dos_campos("0", "-- Seleccione --")); 
            
            while (rs.next())
            {
                lista.add(new obj_cinco_campos(rs.getString("tc_idn")
                                            , rs.getString("cur_nombre")
                                            , rs.getString("car_nombre")
                                            , rs.getString("pro_nombre")
                                            , rs.getString("eje_nombre")));
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
     
     
     
     public static ArrayList<obj_dos_campos> muestra_despachos_pendientes_segun_matricula(String mat_idn) {
    
        ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_adm_renuncia_muestra_despachos_pendientes_segun_matricula '" + mat_idn + "'";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            
            
            //lista.add(new obj_dos_campos("0", "-- Seleccione --")); 
            
            while (rs.next())
            {
                lista.add(new obj_dos_campos(rs.getString("desp_idn")
                                            , rs.getString("mat_apoyo_nombre")));
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
 //------------------------------------------------------------------------------------------------------------
     /*
     
      public static ArrayList muestra_motivos_de_renuncia() {
    
        ArrayList lista = new ArrayList();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_adm_renuncia_muestra_motivos_de_renuncia";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            
            
            lista.add(new obj_combo_dos_campos("0", "-- Seleccione --")); 
            
            while (rs.next())
            {
                lista.add(new obj_combo_dos_campos(rs.getString("mot_ren_idn")
                                            , rs.getString("mot_ren_nombre")));
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
  //-----------------------------------------------------------------------------------------------------------
      */
      //------------------------------------------------------------------------------------------------------------
     
     
      public static ArrayList<obj_combo_dos_campos> muestra_motivos() {
    
        ArrayList<obj_combo_dos_campos> lista = new ArrayList<obj_combo_dos_campos>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_adm_renuncia_muestra_motivos";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            
            
            lista.add(new obj_combo_dos_campos("0", "-- Seleccione --")); 
            
            while (rs.next())
            {
                lista.add(new obj_combo_dos_campos(rs.getString("mat_est_mot_idn")
                                            , rs.getString("mat_est_mot_detalle")));
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
  //-----------------------------------------------------------------------------------------------------------
      
        
public static ArrayList<obj_un_campo_string> ejecuta_renuncia(String mat_idn , String mot_ren_idn, String func_mod_fun_idn) {
    ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
        Connection c=null;
         
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_renuncia_ejecuta_la_renuncia (?,?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, mat_idn.trim());
            ps.setString(2, mot_ren_idn.trim());
            ps.setString(3, func_mod_fun_idn.trim());
           
           
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
     
      
  //-----------------------------------------------------------------------------------------------------------   
    /** Creates a new instance of frm_adm_pago_elementos_conceptos */
    public frm_adm_renuncia() {
    }
    
}
