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
public class frm_dato_de_contrato {
  //*/*********************************************************************************************************************
   
   /*
   
    public static ArrayList dato_de_contrato_muestra(String valor) {
      ArrayList lista = new ArrayList();
        Connection c=null;
         int salida;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_dato_de_contrato_muestra (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,valor.trim());
           
                      
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
      
            lista.add(new obj_doce_campos (rs.getString(" dat_cont_idn"), 
                                             rs.getString("dat_pag_idn"), 
                                             rs.getString("dat_cont_año"), 
                                             rs.getString("dat_cont_arancel"),
                                             rs.getString("dat_cont_numero_cuota"), 
                                             rs.getString("dat_cont_fecha_inicio_pago"), 
                                             rs.getString("dat_cont_valor_matricula"),
                                             rs.getString("dat_cont_situacion_pagado"), 
                                             rs.getString("doc_idn"), 
                                             rs.getString("dat_cont_num_documento"),
                                             rs.getString("ban_idn"),
                                             rs.getString("dat_cont_num_cuenta")));
           
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
 //************
     public static ArrayList<obj_trece_campos> dato_de_contrato_muestra(String valor) {
      ArrayList<obj_trece_campos> lista = new ArrayList<obj_trece_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_dato_de_contrato_muestra (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,valor.trim());
                      
            ResultSet rs = ps.executeQuery();
            
                      
            
            while (rs.next()){
            
      
            lista.add(new obj_trece_campos (rs.getString("dat_cont_idn"), 
                                             rs.getString("mat_idn"), 
                                             rs.getString("dat_cont_año"), 
                                             rs.getString("dat_cont_arancel"),
                                             rs.getString("dat_cont_numero_cuota"), 
                                             rs.getString("dat_cont_fecha_inicio_pago"), 
                                             rs.getString("dat_cont_valor_matricula"),
                                             rs.getString("dat_cont_situacion_pagado"), 
                                             rs.getString("doc_idn"), 
                                             rs.getString("dat_cont_num_documento"),
                                             rs.getString("ban_idn"),
                                             rs.getString("dat_cont_num_cuenta"), 
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
////***************************************************************************************************     
 //***********************************************************************************************************      
      public static ArrayList<obj_dieciseis_campos> ro_carga_datos_del_contrato_alumnos_por_matricula(String matricula) {
    
        ArrayList<obj_dieciseis_campos> lista = new ArrayList<obj_dieciseis_campos>();
        Connection c=null;
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
      public static ArrayList<obj_dieciseis_campos> ro_carga_datos_del_contrato_alumno_por_rut(String alu_rut) {
    
        ArrayList<obj_dieciseis_campos> lista = new ArrayList<obj_dieciseis_campos>();
        Connection c=null;
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
  public static ArrayList<obj_combo_tres_campos> ro_carga_matriculas_alumno_por_rut(String alu_rut) {
    
        ArrayList<obj_combo_tres_campos> lista = new ArrayList<obj_combo_tres_campos>();
        Connection c=null;
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
      public static ArrayList<obj_tres_campos> ro_carga_alumnos_por_matricula(String matricula) {
    
        ArrayList<obj_tres_campos> lista = new ArrayList<obj_tres_campos>();
        Connection c=null;
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
  //***********************************************************************************************************


public static ArrayList<obj_un_campo> dato_de_contrato_borra(int dat_cont_idn) {
    ArrayList<obj_un_campo> lista = new ArrayList<obj_un_campo>();
    Connection c=null;
    int salida = 1;
    try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_dato_de_contrato_borra (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setInt(1,dat_cont_idn);
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
    
     //************
     public static ArrayList<obj_dos_campos> dato_de_contrato_muestra_tipo_documento() {
      ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_dato_de_contrato_muestra_tipo_documento ()}" ;
            CallableStatement ps = c.prepareCall(sql);
         
                      
            ResultSet rs = ps.executeQuery();
            
            lista.add(new obj_dos_campos("0"," - Seleccione - "));     
            
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos (rs.getString("doc_idn"), 
                                         rs.getString("doc_nombre")));
           
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
    
    
   //*********************************************************************************************************************
     
     
      ////////////////////////////////////////////////
    
     //************
     public static ArrayList<obj_dos_campos> dato_de_contrato_muestra_banco() {
      ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_dato_de_contrato_muestra_banco ()}" ;
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
       public static ArrayList<obj_un_campo_string> dato_de_contrato_graba(String mat_idn
       , String dat_cont_año 
       , String dat_cont_arancel
       , String dat_cont_numero_cuota
       , String dat_cont_fecha_inicio_pago
       , String  dat_cont_valor_matricula
       , String dat_cont_situacion_pagado
       , String doc_nombre
       , String dat_cont_num_documento
       , String ban_nombre
       , String dat_cont_num_cuenta
       , String dat_cont_contrato) {
    ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
        Connection c=null;
         String msg ;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_dato_de_contrato_graba (?,?,?,?,?,?,?,?,?,?,?,?)}";
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, mat_idn.trim());
            ps.setString(2, dat_cont_año.trim());
            ps.setString(3, dat_cont_arancel.trim());
            ps.setString(4, dat_cont_numero_cuota.trim());
            ps.setString(5, dat_cont_fecha_inicio_pago.trim());
            ps.setString(6, dat_cont_valor_matricula.trim());
            ps.setString(7, dat_cont_situacion_pagado.trim());
            ps.setString(8, doc_nombre.trim());
            ps.setString(9, dat_cont_num_documento.trim());
            ps.setString(10, ban_nombre.trim());
            ps.setString(11, dat_cont_num_cuenta.trim());
            ps.setString(12, dat_cont_contrato.trim());
            
            
            
            
            
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
       
       
       ////////////////////////////////////////////////
    
    
    public static ArrayList<obj_un_campo> dato_de_contrato_modifica(String dat_cont_idn
       , String mat_idn
       , String dat_cont_año 
       , String dat_cont_arancel
       , String dat_cont_numero_cuota
       , String dat_cont_fecha_inicio_pago
       , String  dat_cont_valor_matricula
       , String dat_cont_situacion_pagado
       , String doc_nombre
       , String dat_cont_num_documento
       , String ban_nombre
       , String dat_cont_num_cuenta
       , String dat_cont_contrato)
   {
    ArrayList<obj_un_campo> lista = new ArrayList<obj_un_campo>();
        Connection c=null;
         int salida = 1;
        try {
  
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_dato_de_contrato_modifica (?,?,?,?,?,?,?,?,?,?,?,?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, dat_cont_idn.trim());
            ps.setString(2, mat_idn.trim());
            ps.setString(3, dat_cont_año.trim());
            ps.setString(4, dat_cont_arancel.trim());
            ps.setString(5, dat_cont_numero_cuota.trim());
            ps.setString(6, dat_cont_fecha_inicio_pago.trim());
            ps.setString(7, dat_cont_valor_matricula.trim());
            ps.setString(8, dat_cont_situacion_pagado.trim());
            ps.setString(9, doc_nombre.trim());
            ps.setString(10, dat_cont_num_documento.trim());
            ps.setString(11, ban_nombre.trim());
            ps.setString(12, dat_cont_num_cuenta.trim());
            ps.setString(13, dat_cont_contrato.trim());
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
   
    
    
 
   ////////////////////////////////////////////////
   
    
 //*/*********************************************************************************************************************
    /** Creates a new instance of frm_adm_chat_ingreso */
    public frm_dato_de_contrato() {
    }
    
}
