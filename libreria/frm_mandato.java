/*
 * frm_adm_chat_ingreso.java
 *
 * Created on 26 de diciembre de 2005, 03:16 PM
 */

package libreria;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author  marcelo
 */
public class frm_mandato {
  //*/*********************************************************************************************************************
 ///***************************************************************************************************     
 //***********************************************************************************************************      
       public static ArrayList<obj_dieciseis_campos> ro_carga_datos_del_contrato_alumnos_por_matricula(String matricula) {
    
        ArrayList<obj_dieciseis_campos> lista = new ArrayList<obj_dieciseis_campos>();
        Connection c=null;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_mandato_dato_de_contrato_busca_por_matricula '" + matricula + "'";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
        
            while (rs.next()){
            
           
             lista.add(new obj_dieciseis_campos (rs.getString("dat_cont_idn"), 
                                                rs.getString("mat_idn"), 
                                                rs.getString("dat_cont_año"), 
                                                rs.getString("dat_cont_arancel"),
                                                rs.getString("dat_cont_numero_cuota"), 
                                                rs.getString("dat_cont_fecha_inicio_pago"), 
                                                rs.getString("dat_cont_valor_matricula"),
                                                rs.getString("dat_cont_situacion_pagado"), 
                                                rs.getString("doc_nombre"), 
                                                rs.getString("dat_cont_num_documento"),
                                                rs.getString("ban_nombre"),
                                                rs.getString("dat_cont_num_cuenta"),
                                                rs.getString("nombre"),
                                                rs.getString("doc_idn"), 
                                                rs.getString("ban_idn"),
                                                rs.getString("dat_cont_contrato")));
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
 //***********************************************************************************************************
  public static ArrayList<obj_combo_tres_campos> ro_carga_matriculas_alumno_por_rut(String alu_rut) {
    
        ArrayList<obj_combo_tres_campos> lista = new ArrayList<obj_combo_tres_campos>();
        Connection c=null;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_mandato_busca_datos_alumno_por_rut '" + alu_rut + "'";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            
            lista.add(new obj_combo_tres_campos("0","0"," - Seleccione - "));     
            
            while (rs.next()){
            
      
      
            lista.add(new obj_combo_tres_campos(rs.getString("nombre")
                                            , rs.getString("mat_idn")
                                            , rs.getString("car_nombre")));
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
      public static ArrayList<obj_tres_campos> ro_carga_alumnos_por_matricula(String matricula) {
    
        ArrayList<obj_tres_campos> lista = new ArrayList<obj_tres_campos>();
        Connection c=null;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_mandato_busca_datos_alumno_por_matricula '" + matricula + "'";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
        
            while (rs.next()){
            
      
      
            lista.add(new obj_tres_campos(rs.getString("nombre")
                                       , rs.getString("mat_idn")
                                        , rs.getString("car_nombre")));
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
 //************--------------------------------------------------------------------------
    //------------------------------------------------------------------------------
         
          public static ArrayList<obj_dieciseis_campos> rematricula_llena_grilla_datos_del_pago(String matricula) {
    
        ArrayList<obj_dieciseis_campos> lista = new ArrayList<obj_dieciseis_campos>();
        Connection c=null;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_mandato_llena_grilla_datos_del_pago '" + matricula + "'";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
        
            while (rs.next()){
            
           
             lista.add(new obj_dieciseis_campos (rs.getString("dat_pag_idn"), 
                                                rs.getString("alu_rut"), 
                                                rs.getString("dat_pag_fecha_inicio"), 
                                                rs.getString("dat_pag_valor_arancel"),
                                                rs.getString("dat_pag_descuento"), 
                                                rs.getString("dat_pag_can_cuota"), 
                                                rs.getString("mat_orden_venta"),
                                                rs.getString("dat_pag_ano"), 
                                                rs.getString("for_pag_idn"), 
                                                rs.getString("env_doc_idn"),
                                                rs.getString("env_des_idn"),
                                                rs.getString("med_pag_idn"),
                                                rs.getString("tip_pag_idn"),
                                                rs.getString("lug_pag_idn"), 
                                                rs.getString("dat_pag_actual"),
                                                rs.getString("dat_pag_fecha_ingreso")));
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


         
          public static ArrayList<obj_dos_campos> mandato_muestra_banco() {
      ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_mandato_muestra_banco ()}" ;
            CallableStatement ps = c.prepareCall(sql);
         
                      
            ResultSet rs = ps.executeQuery();
            
             
              lista.add(new obj_dos_campos("0"," - Seleccione - "));
                 
            
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos (rs.getString("ban_idn"), 
                                         rs.getString("ban_nombre")));
           
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
    
//***********************************************************************************************************************
    
     //***********************************************************************************************************


         
          public static ArrayList<obj_dos_campos> mandato_muestra_tipo_mandato() {
      ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_mandato_muestra_tipo_mandato ()}" ;
            CallableStatement ps = c.prepareCall(sql);
         
                      
            ResultSet rs = ps.executeQuery();
            
             
              lista.add(new obj_dos_campos("0"," - Seleccione - "));
                 
            
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos (rs.getString("tip_mand_idn"), 
                                         rs.getString("tip_mand_nombre")));
           
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
    
//----------------------------------------------------------------------------------------------------------------------
          
           public static ArrayList<obj_once_campos> mandato_llena_grilla_mandato_alumno(String dat_pag_idn) {
    
        ArrayList<obj_once_campos> lista = new ArrayList<obj_once_campos>();
        Connection c=null;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_mandato_llena_grilla_mandato_alumno '" + dat_pag_idn + "'";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
        
            while (rs.next()){
            
           
             lista.add(new obj_once_campos (rs.getString("mand_idn"), 
                                                rs.getString("mand_rut"), 
                                                rs.getString("ban_idn"), 
                                                rs.getString("ban_nombre"), 
                                                rs.getString("mand_tipo_cuenta"),
                                                rs.getString("mand_numero_cuenta"), 
                                                rs.getString("mand_sucursal"), 
                                                rs.getString("mand_fecha"),
                                                rs.getString("tip_mand_idn"),
                                                rs.getString("tip_mand_nombre"),
                                                  rs.getString("seg_div_pol_nombre")));
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
 //--------------------------------------------------------------------------------------------------
           
           
           //***********************************************************************************************************************
       public static ArrayList<obj_un_campo_string> mandato_ingresa_mandato_datos_de_pago_mandato(String dat_pag_idn 
       , String mand_rut 
       , String ban_idn
       , String mand_tipo_cuenta
       , String mand_numero_cuenta
       , String mand_sucursal
       , String mand_fecha
       , String tip_mand_idn
       , String seg_div_pol_idn
                                ) {
    ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
        Connection c=null;
         String msg ;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_mandato_ingresa_mandato_datos_de_pago_mandato (?,?,?,?,?,?,?,?,?)}";
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, dat_pag_idn.trim());
            ps.setString(2, mand_rut.trim());
            ps.setString(3, ban_idn.trim());
            ps.setString(4, mand_tipo_cuenta.trim());
            ps.setString(5, mand_numero_cuenta.trim());
            ps.setString(6, mand_sucursal.trim());
            ps.setString(7, mand_fecha.trim());
            ps.setString(8, tip_mand_idn.trim());
            ps.setString(9, seg_div_pol_idn.trim());
            
            
            
            
            
            ResultSet rs = ps.executeQuery();
        
            while (rs.next()){
            
      
            lista.add(new obj_un_campo_string(rs.getString("identidad")));
           
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            lista.remove(0);
            msg = e.getMessage();
            lista.add(new obj_un_campo_string(msg));
            
        } finally {
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
                
         return lista;
   }
           
 ///////-----------------------------------------------------------------------------------------------//////////
    
    
    public static ArrayList<obj_un_campo> mandato_modifica_mandato (String mand_idn
       , String ban_idn
       , String mand_tipo_cuenta 
       , String mand_numero_cuenta
       , String mand_sucursal
       , String mand_fecha
       , String  tip_mand_idn
       , String seg_div_pol_idn)


   {
    ArrayList<obj_un_campo> lista = new ArrayList<obj_un_campo>();
        Connection c=null;
         int salida = 1;
        try {
  
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_mandato_modifica_mandato (?,?,?,?,?,?,?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, mand_idn.trim());
            ps.setString(2, ban_idn.trim());
            ps.setString(3, mand_tipo_cuenta.trim());
            ps.setString(4, mand_numero_cuenta.trim());
            ps.setString(5, mand_sucursal.trim());
            ps.setString(6, mand_fecha.trim());
            ps.setString(7, tip_mand_idn.trim());
            ps.setString(8, seg_div_pol_idn.trim());
            ps.execute();
                       
        } catch (Exception e) {
            e.printStackTrace();
            salida = 0;
            
        } finally {
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        if (salida == 1){
        lista.add(new obj_un_campo(1));
        }else{
        lista.add(new obj_un_campo(0));
        }
        
         return lista;
   }
   
    
    
 
   ///////////////////////////////////////////////////
   
   
   
    //***********************************************************************************************************


public static ArrayList<obj_un_campo> mandato_borra_mandato_dato_pago_mandato(int mand_idn, int dat_pag_idn ) {
    ArrayList<obj_un_campo> lista = new ArrayList<obj_un_campo>();
    Connection c=null;
    int salida = 1;
    try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_mandato_borra_mandato_dato_pago_mandato (?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setInt(1,mand_idn);
             ps.setInt(2,dat_pag_idn);
            ps.execute();
           
        } catch (Exception e) {
            e.printStackTrace();
            salida = 0;
            e.getMessage();
        } finally {
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (salida == 1){
        lista.add(new obj_un_campo(1));
        }else{
        lista.add(new obj_un_campo(0));
        }
        
         return lista;
   }  
   
   ////////////////////////////////////////////////
    
       //***********************************************************************************************************


         
          public static ArrayList<obj_dos_campos> mandato_muestra_comuna_seg_div_politica() {
      ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_mandato_muestra_comuna_seg_div_politica ()}" ;
            CallableStatement ps = c.prepareCall(sql);
         
                      
            ResultSet rs = ps.executeQuery();
            
             
              lista.add(new obj_dos_campos("0"," - Seleccione - "));
                 
            
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos (rs.getString("seg_div_pol_idn"), 
                                         rs.getString("seg_div_pol_nombre")));
           
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
    
//***********************************************************************************************************************
    
        
          
//***********************************************************************************************************************
         
   
        //-------------------------------------------------------------------------------------------
        /** Creates a new instance of frm_adm_chat_ingreso */
                  public frm_mandato() {
    }
    
}
