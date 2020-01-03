/*
 * frm_adm_chat_ingreso.java
 *
 * Created on 26 de diciembre de 2005, 03:16 PM
 */

package libreria;
import java.util.ArrayList;
import java.io.Serializable;
import java.sql.*;
/**
 *
 * @author  marcelo
 */
public class frm_busca_evaluacion_ejecucion {
  //*/*********************************************************************************************************************
 ///***************************************************************************************************     
 //***********************************************************************************************************      
  /*    public static ArrayList ro_carga_datos_del_contrato_alumnos_por_matricula(String matricula) {
    
        ArrayList lista = new ArrayList();
        Connection c=null;
        String exito;
        
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_dato_de_contrato_busca_por_matricula '" + matricula + "'";
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
      public static ArrayList ro_carga_datos_del_contrato_alumno_por_rut(String alu_rut) {
    
        ArrayList lista = new ArrayList();
        Connection c=null;
        String exito;
        
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_dato_de_contrato_busca_por_rut '" + alu_rut + "'";
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
  public static ArrayList ro_carga_matriculas_alumno_por_rut(String alu_rut) {
    
        ArrayList lista = new ArrayList();
        Connection c=null;
        String exito;
        
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_dato_de_contrato_busca_datos_alumno_por_rut '" + alu_rut + "'";
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
      public static ArrayList ro_carga_alumnos_por_matricula(String matricula) {
    
        ArrayList lista = new ArrayList();
        Connection c=null;
        String exito;
        
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_dato_de_contrato_busca_datos_alumno_por_matricula '" + matricula + "'";
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
 
      public static ArrayList rematricula_muestra_formadepago() {
      ArrayList lista = new ArrayList();
        Connection c=null;
         int salida;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_rematricula_muestra_formadepago ()}" ;
            CallableStatement ps = c.prepareCall(sql);
         
                      
            ResultSet rs = ps.executeQuery();
            
             
              lista.add(new obj_dos_campos("0"," - Seleccione - "));
                 
            
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos (rs.getString("for_pag_idn"), 
                                         rs.getString("for_pag_nombre")));
           
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
 //************--------------------------------------------------------------------------
 
      public static ArrayList rematricula_muestra_envio_documentacion() {
      ArrayList lista = new ArrayList();
        Connection c=null;
         int salida;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_rematricula_muestra_envio_documentacion ()}" ;
            CallableStatement ps = c.prepareCall(sql);
         
                      
            ResultSet rs = ps.executeQuery();
            
             
              lista.add(new obj_dos_campos("0"," - Seleccione - "));
                 
            
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos (rs.getString("Env_doc_idn"), 
                                         rs.getString("env_doc_nombre")));
           
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
 
      //************--------------------------------------------------------------------------
 
      public static ArrayList rematricula_muestra_medio_pago() {
      ArrayList lista = new ArrayList();
        Connection c=null;
         int salida;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_rematricula_muestra_medio_pago ()}" ;
            CallableStatement ps = c.prepareCall(sql);
         
                      
            ResultSet rs = ps.executeQuery();
            
             
              lista.add(new obj_dos_campos("0"," - Seleccione - "));
                 
            
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos (rs.getString("med_pag_idn"), 
                                         rs.getString("med_pag_nom")));
           
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
   //************--------------------------------------------------------------------------
 
      public static ArrayList rematricula_muestra_tipo_pago() {
      ArrayList lista = new ArrayList();
        Connection c=null;
         int salida;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_rematricula_muestra_tipo_pago ()}" ;
            CallableStatement ps = c.prepareCall(sql);
         
                      
            ResultSet rs = ps.executeQuery();
            
             
              lista.add(new obj_dos_campos("0"," - Seleccione - "));
                 
            
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos (rs.getString("tip_pag_idn"), 
                                         rs.getString("tip_pag_nombre")));
           
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

      
        public static ArrayList rematricula_muestra_lugar_pago() {
      ArrayList lista = new ArrayList();
        Connection c=null;
         int salida;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_rematricula_muestra_lugar_pago ()}" ;
            CallableStatement ps = c.prepareCall(sql);
         
                      
            ResultSet rs = ps.executeQuery();
            
             
              lista.add(new obj_dos_campos("0"," - Seleccione - "));
                 
            
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos (rs.getString("lug_pag_idn"), 
                                         rs.getString("lug_pag_nombre")));
           
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

      
        public static ArrayList rematricula_muestra_envio_despacho() {
      ArrayList lista = new ArrayList();
        Connection c=null;
         int salida;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_rematricula_muestra_envio_despacho ()}" ;
            CallableStatement ps = c.prepareCall(sql);
         
                      
            ResultSet rs = ps.executeQuery();
            
             
             
            
            while (rs.next()){
            
      
           lista.add(new obj_un_campo_string (rs.getString("env_des_idn")));
           
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
      
      ///*********************************************************************************************************************
   
    */ /*   
         public static ArrayList rematricula_muestra_pro_dela_malla_ejecucion_arancel(String valor) {
      ArrayList lista = new ArrayList();
        Connection c=null;
         int salida;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_rematricula_muestra_pro_dela_malla_ejecucion_arancel (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,valor.trim());
                      
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
      
            lista.add(new obj_ocho_campos (rs.getString("pro_eje_ara_idn"), 
                                             rs.getString("eje_idn"), 
                                             rs.getString("eje_nombre"), 
                                             rs.getString("pro_mal_idn"),
                                             rs.getString("mal_nombre"),
                                             rs.getString("pro_eje_ara_arancel"),
                                             rs.getString("pro_eje_ara_fecha_ingreso"),
                                             rs.getString("mat_orden_venta")));
           
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
         
         //------------------------------------------------------------------------------------------
          
         public static ArrayList rematricula_muestra_año_pago_suma_uno(String mat_idn) {
      ArrayList lista = new ArrayList();
        Connection c=null;
         int salida;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_rematricula_muestra_año_pago_suma_uno (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,mat_idn.trim());
                      
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos (rs.getString("año_ultimo_registrado"), 
                                             rs.getString("año_actual")));
           
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
         
         //------------------------------------------------------------------------------
         
          public static ArrayList rematricula_llena_grilla_datos_del_pago(String matricula) {
    
        ArrayList lista = new ArrayList();
        Connection c=null;
        String exito;
        
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_rematricula_llena_grilla_datos_del_pago '" + matricula + "'";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
        
            while (rs.next()){
            
           
             lista.add(new obj_dieciseis_campos (rs.getString("dat_pag_idn"), 
                                                rs.getString("mat_idn"), 
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



//------------------------------------------------------------------------------------------
          
         public static ArrayList rematricula_busca_foto_con_matricula(String mat_idn) {
      ArrayList lista = new ArrayList();
        Connection c=null;
         int salida;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_rematricula_busca_foto_con_matricula (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,mat_idn.trim());
                      
            ResultSet rs = ps.executeQuery();
            
        
             while (rs.next()){
            
      
           lista.add(new obj_un_campo_string (rs.getString("alu_identificador")));
            
            
            
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
         
         //------------------------------------------------------------------------------
       

         public static ArrayList rematricula_ingresa_datos_del_pago(String mat_idn
                                                                    , String dat_pag_fecha_inicio
                                                                    , String dat_pag_valor_arancel 
                                                                    , String dat_pag_descuento
                                                                    , String dat_pag_can_cuota
                                                                    , int mat_orden_venta
                                                                    , String dat_pag_ano
                                                                    , String for_pag_idn
                                                                    , String env_doc_idn
                                                                    , String env_des_idn
                                                                    , String med_pag_idn
                                                                    , String tip_pag_idn
                                                                    
                                                                    ) {
    ArrayList lista = new ArrayList();
        Connection c=null;
         int salida = 1;
      String msg ;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_rematricula_ingresa_datos_del_pago (?,?,?,?,?,?,?,?,?,?,?,?)}";
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, mat_idn.trim());
            ps.setString(2, dat_pag_fecha_inicio.trim());
            ps.setString(3, dat_pag_valor_arancel.trim());
            ps.setString(4, dat_pag_descuento.trim());
            ps.setString(5, dat_pag_can_cuota.trim());
            ps.setInt(6, mat_orden_venta);
            
             ps.setString(7, dat_pag_ano.trim());
            ps.setString(8, for_pag_idn.trim());
            ps.setString(9, env_doc_idn.trim());
            ps.setString(10, env_des_idn.trim());
            ps.setString(11, med_pag_idn.trim());
            
             ps.setString(12, tip_pag_idn.trim());

           
            
            
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
    //-----------------------------------------------------------------------------------------------
                  public static ArrayList rematricula_ingresa_datos_del_pago_y_despacho(String mat_idn
                                                                    , String dat_pag_fecha_inicio
                                                                    , String dat_pag_valor_arancel 
                                                                    , String dat_pag_descuento
                                                                    , String dat_pag_can_cuota
                                                                    , int mat_orden_venta
                                                                    , String dat_pag_ano
                                                                    , String for_pag_idn
                                                                    , String env_doc_idn
                                                                    , String env_des_idn
                                                                    , String med_pag_idn
                                                                    , String tip_pag_idn
                                                                  
                                                                    ) {
    ArrayList lista = new ArrayList();
        Connection c=null;
         int salida = 1;
      String msg ;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_rematricula_ingresa_datos_del_pago_y_despacho (?,?,?,?,?,?,?,?,?,?,?,?)}";
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, mat_idn.trim());
            ps.setString(2, dat_pag_fecha_inicio.trim());
            ps.setString(3, dat_pag_valor_arancel.trim());
            ps.setString(4, dat_pag_descuento.trim());
            ps.setString(5, dat_pag_can_cuota.trim());
            ps.setInt(6, mat_orden_venta);
            
             ps.setString(7, dat_pag_ano.trim());
            ps.setString(8, for_pag_idn.trim());
            ps.setString(9, env_doc_idn.trim());
            ps.setString(10, env_des_idn.trim());
            ps.setString(11, med_pag_idn.trim());
            
             ps.setString(12, tip_pag_idn.trim());
          
           
            
            
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
         
         
     */    
   //------------------------------------------------------------------------------------------------
    
      public static ArrayList<obj_dos_campos> llena_combo_ejecucion() {
      ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_busca_ejecucion_llena_combo_ejecucion ()}" ;
            CallableStatement ps = c.prepareCall(sql);
         
                      
            ResultSet rs = ps.executeQuery();
            
             
              lista.add(new obj_dos_campos("0"," - Seleccione - "));
                 
            
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos (rs.getString("eje_idn"), 
                                         rs.getString("eje_nombre")));
           
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
     
   //------------------------------------------------------------------------------------------------
      
    
    public static ArrayList<obj_dos_campos> llena_combo_tipo_producto(String eje_idn) {
      ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_busca_ejecucion_llena_combo_tipo_producto (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
          ps.setString(1, eje_idn.trim());
                      
            ResultSet rs = ps.executeQuery();
                         
              lista.add(new obj_dos_campos("0"," - Seleccione - "));
                 
            
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos (rs.getString("tip_prod_idn"), 
                                         rs.getString("tip_prod_nombre")));
           
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
    
  //-------------------------------------------------------------------------------------------------
    
    
     public static ArrayList<Serializable> llena_grilla_ejecucion_academica(String eje_idn, String tip_prod_idn  ) {
      ArrayList<Serializable> lista = new ArrayList<Serializable>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_busca_ejecucion_llena_grilla_ejecucion_Academica (?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
          ps.setString(1, eje_idn.trim());
          ps.setString(2, tip_prod_idn.trim());
                      
            ResultSet rs = ps.executeQuery();
                         
                    lista.add(new obj_dos_campos("0"," - Seleccione - "));
            
            while (rs.next()){
            
      
            lista.add(new obj_combo_dos_campos (rs.getString("eje_aca_idn"), 
                                                rs.getString("detalle")));
           
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
     
     
     
        //-------------------------------------------------------------------------------------------
        /** Creates a new instance of frm_adm_chat_ingreso */
                  public frm_busca_evaluacion_ejecucion() {
    }
    
}
