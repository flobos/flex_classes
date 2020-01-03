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
public class frm_matricula_apoderado_aval {
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
    */  
 //***********************************************************************************************************
//***********************************************************************************************************      
      public static ArrayList<obj_tres_campos> busca_alumnos_por_matricula(String matricula) {
    
        ArrayList<obj_tres_campos> lista = new ArrayList<obj_tres_campos>();
        Connection c=null;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_matricula_apoderado_aval_busca_por_matricula '" + matricula + "'";
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
      
 //**********----------------------------------------------------------------------------
      
       public static ArrayList<obj_quince_campos> busca_apoderado_aval_segun_matricula(String matricula) {
    
        ArrayList<obj_quince_campos> lista2 = new ArrayList<obj_quince_campos>();
        Connection c=null;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_matricula_apoderado_aval_busca_apoderado_aval_segun_matricula '" + matricula + "'";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
        
            while (rs.next()){
            
      
      
            lista2.add(new obj_quince_campos(rs.getString("apo_aval_rut")
                                       , rs.getString("apo_aval_nombre")
                                       , rs.getString("apo_aval_ape_p")
                                       , rs.getString("apo_aval_ape_m")
                                       , rs.getString("apo_aval_dir_par")
                                       , rs.getString("apo_aval_num_casa")
                                       , rs.getString("apo_aval_fono_par")
                                       , rs.getString("apo_aval_dir_par_comuna")
                                       , rs.getString("apo_aval_email")
                                       , rs.getString("apo_aval_dir_lab")
                                       , rs.getString("apo_aval_num_trab")
                                       , rs.getString("apo_aval_fono_lab")
                                       , rs.getString("apo_aval_dir_lab_comuna")
                                       
                                       ,  rs.getString("seg_div_pol_nombre")
                                      // , rs.getString("div_pol_nombre")
                                        ,  rs.getString("seg_div_pol_nombre2")
                                     //  , rs.getString("div_pol_nombre2")
                                       
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
        return lista2;
    } 
      
      
      
      
 //************--------------------------------------------------------------------------
 
      public static ArrayList<obj_dos_campos> muestra_comuna_1() {
      ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_matricula_apoderado_aval_muestra_comuna ()}" ;
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
      
      //-----------------------------------------------------------------------------------------------------------------
      
       public static ArrayList<obj_un_campo_string> busca_region_1(String seg_div_pol_idn) {
    
        ArrayList<obj_un_campo_string> lista2 = new ArrayList<obj_un_campo_string>();
        Connection c=null;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_matricula_apoderado_aval_busca_region_1 '" + seg_div_pol_idn + "'";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
        
            while (rs.next()){
            
      
      
            lista2.add(new obj_un_campo_string(rs.getString("div_pol_nombre")
                                       
                                       
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
        return lista2;
    } 
      
      //-----------------------------------------------------------------------------------------------------------------
      
       public static ArrayList<obj_un_campo_string> busca_region_2(String seg_div_pol_idn) {
    
        ArrayList<obj_un_campo_string> lista2 = new ArrayList<obj_un_campo_string>();
        Connection c=null;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_matricula_apoderado_aval_busca_region_2 '" + seg_div_pol_idn + "'";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
        
            while (rs.next()){
            
      
      
            lista2.add(new obj_un_campo_string(rs.getString("div_pol_nombre")
                                       
                                       
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
        return lista2;
    } 
      
 //---------------------------------------------------------------------------------------------------------------------
       //-----------------------------------------------------------------------------------------------------------------
      
       public static ArrayList<obj_dos_campos> busca_requicitos_asignados(String apo_aval_rut) {
    
        ArrayList<obj_dos_campos> lista2 = new ArrayList<obj_dos_campos>();
        Connection c=null;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_matricula_apoderado_aval_busca_requicitos_asignados '" + apo_aval_rut + "'";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
        
            while (rs.next()){
            
      
      
            lista2.add(new obj_dos_campos(rs.getString("req_apo_aval_idn")
                                       ,rs.getString("req_apo_aval_nombre")
                                       
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
        return lista2;
    } 
      
 
 //---------------------------------------------------------------------------------------------------------------------
        //-----------------------------------------------------------------------------------------------------------------
      
       public static ArrayList<obj_dos_campos> busca_requicitos_no_asignados(String apo_aval_rut) {
    
        ArrayList<obj_dos_campos> lista2 = new ArrayList<obj_dos_campos>();
        Connection c=null;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_matricula_apoderado_aval_busca_requicitos_no_asignados '" + apo_aval_rut + "'";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
        
            while (rs.next()){
            
      
      
            lista2.add(new obj_dos_campos(rs.getString("req_apo_aval_idn")
                                       ,rs.getString("req_apo_aval_nombre")
                                       
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
        return lista2;
    } 
      
 //---------------------------------------------------------------------------------------------------------------------
   
       
     public static ArrayList<obj_un_campo>  inserta_requicitos_asignados(ArrayList<?> arreglo, String apo_aval_rut) 
     {
        
        ArrayList<obj_un_campo> lista = new ArrayList<obj_un_campo>();
        int salida = 1;
        Connection c=null;
        String sql;
      
        try {

                int size= arreglo.size();
                int i;
                for (i=0; i<size; i++) 
                {
                        c = conexion_odbc.Connexion_datos();
                        sql = "{call flex_matricula_apoderado_aval_inserta_requicitos_asignados (?,?)}" ;
                        CallableStatement ps = c.prepareCall(sql);
                        ps.setString(1,arreglo.get(i).toString().trim());
                        ps.setString(2,apo_aval_rut);
                        ps.execute();
                }
           } 
         catch (Exception e) 
            {
                e.printStackTrace();
                salida = 0;
            }
         finally
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
        
        if (salida == 1)
            {
            lista.add(new obj_un_campo(1));
            }
        else
            {
                lista.add(new obj_un_campo(0));
            }
        
         return lista;
    }
  
  //******************************************************************** 
       
        public static ArrayList<obj_un_campo_string> inserta_en_dos_tablas(String apo_aval_rut ,
                                                        String apo_aval_nombre ,
                                                        String apo_aval_ape_p ,
                                                        String apo_aval_ape_m ,
                                                        String apo_aval_dir_par ,
                                                        String apo_aval_num_casa ,
                                                        String apo_aval_fono_par ,
                                                        String apo_aval_dir_par_comuna ,
                                                        String apo_aval_email ,
                                                        String apo_aval_dir_lab ,
                                                        String apo_aval_num_trab,
                                                        String apo_aval_fono_lab ,
                                                        String apo_aval_dir_lab_comuna ,
                                                        String mat_idn  
                                                                  
                                                                    ) {
    ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
        Connection c=null;
         String msg ;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_matricula_apoderado_aval_inserta_en_dos_tablas (?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, apo_aval_rut.trim());
            ps.setString(2, apo_aval_nombre.trim());
            ps.setString(3, apo_aval_ape_p.trim());
            ps.setString(4, apo_aval_ape_m.trim());
            ps.setString(5, apo_aval_dir_par.trim());
            ps.setString(6, apo_aval_num_casa.trim());
            ps.setString(7, apo_aval_fono_par.trim());
            ps.setString(8, apo_aval_dir_par_comuna.trim());
            ps.setString(9, apo_aval_email.trim());
            ps.setString(10, apo_aval_dir_lab.trim());
            ps.setString(11, apo_aval_num_trab.trim());
            ps.setString(12, apo_aval_fono_lab.trim());
            ps.setString(13, apo_aval_dir_lab_comuna.trim());
            ps.setString(14, mat_idn.trim());
           
            
            
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
         
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////           




    public static ArrayList<obj_un_campo> borra_apoderado_aval(String mat_idn, String apo_aval_rut) {
    ArrayList<obj_un_campo> lista = new ArrayList<obj_un_campo>();
    Connection c=null;
    int salida = 1;
    try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_matricula_apoderado_aval_elimina_apoderado_aval (?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,mat_idn);
             ps.setString(2,apo_aval_rut);
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
   

       //******************************************************************************





    public static ArrayList<obj_un_campo> elimina_requicitos_antes_de_grabar(String apo_aval_rut) {
    ArrayList<obj_un_campo> lista = new ArrayList<obj_un_campo>();
    Connection c=null;
    int salida = 1;
    try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_matricula_apoderado_aval_elimina_requicitos_antes_de_grabar (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            
             ps.setString(1,apo_aval_rut);
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
        lista.add(new obj_un_campo('1'));
        }else{
        lista.add(new obj_un_campo('0'));
        }
        
         return lista;
   }  
//----------------------------------------------------------------------------------------------------------------------
    
    
       public static ArrayList<obj_un_campo_string> actualiza_apoderado_aval(String apo_aval_rut ,
                                                        String apo_aval_nombre ,
                                                        String apo_aval_ape_p ,
                                                        String apo_aval_ape_m ,
                                                        String apo_aval_dir_par ,
                                                        String apo_aval_num_casa ,
                                                        String apo_aval_fono_par ,
                                                        String apo_aval_dir_par_comuna ,
                                                        String apo_aval_email ,
                                                        String apo_aval_dir_lab ,
                                                        String apo_aval_num_trab,
                                                        String apo_aval_fono_lab ,
                                                        String apo_aval_dir_lab_comuna 
                                                         
                                                                  
                                                                    ) {
    ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
        Connection c=null;
         String msg ;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_matricula_apoderado_aval_actualiza_apoderado (?,?,?,?,?,?,?,?,?,?,?,?,?)}";
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, apo_aval_rut.trim());
            ps.setString(2, apo_aval_nombre.trim());
            ps.setString(3, apo_aval_ape_p.trim());
            ps.setString(4, apo_aval_ape_m.trim());
            ps.setString(5, apo_aval_dir_par.trim());
            ps.setString(6, apo_aval_num_casa.trim());
            ps.setString(7, apo_aval_fono_par.trim());
            ps.setString(8, apo_aval_dir_par_comuna.trim());
            ps.setString(9, apo_aval_email.trim());
            ps.setString(10, apo_aval_dir_lab.trim());
            ps.setString(11, apo_aval_num_trab.trim());
            ps.setString(12, apo_aval_fono_lab.trim());
            ps.setString(13, apo_aval_dir_lab_comuna.trim());
           
           
            
            
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
         
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////           

    
    
 //---------------------------------------------------------------------------------------------------------------------
    /*
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
   */   
      //*/*********************************************************************************************************************
   /*
        
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
            
      
            lista.add(new obj_ocho_campos (rs.getString("pro_eje_idn"), 
                                             rs.getString("eje_idn"), 
                                             rs.getString("eje_nombre"), 
                                             rs.getString("pro_mal_idn"),
                                             rs.getString("mal_nombre"),
                                             rs.getString("pro_mal_eje_con_pag_arancel"),
                                             rs.getString("pro_mal_eje_con_pag_fecha_ingreso"),
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
            
       lista.add(new obj_dos_campos(rs.getString("alu_idn")
                                            , rs.getString("alu_foto")));
       
       
       //    lista.add(new obj_dos_campos (rs.getString("alu_idn")),
         //                               (rs.getString("alu_foto")));
            
            
            
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
         
    //-----------------------------------------------------------------------------------------------
                  
          public static ArrayList rematricula_busca_ejecuciones_en_pro_dela_malla_ejecucion_arancel() {
      ArrayList lista = new ArrayList();
        Connection c=null;
         int salida;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_rematricula_busca_ejecuciones_en_pro_dela_malla_ejecucion_arancel ()}" ;
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
     
 //--------------------------------------------------------------------------------------------------
          
            public static ArrayList rematricula_ingresa_ejecucion_para_continuar_rematricula(String mat_idn, String eje_idn) {
      ArrayList lista = new ArrayList();
        Connection c=null;
         int salida;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_rematricula_muestra_pro_dela_malla_ejecucion_arancel_para_continuar_rematricula (?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,mat_idn.trim());
            ps.setString(2,eje_idn.trim());          
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
      
            lista.add(new obj_ocho_campos (rs.getString("pro_eje_idn"), 
                                             rs.getString("eje_idn"), 
                                             rs.getString("eje_nombre"), 
                                             rs.getString("pro_mal_idn"),
                                             rs.getString("mal_nombre"),
                                             rs.getString("pro_mal_eje_con_pag_arancel"),
                                             rs.getString("pro_mal_eje_con_pag_fecha_ingreso"),
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
         
          
     */     
        //-------------------------------------------------------------------------------------------
        /** Creates a new instance of frm_adm_chat_ingreso */
            public frm_matricula_apoderado_aval() {
    }
    
}
