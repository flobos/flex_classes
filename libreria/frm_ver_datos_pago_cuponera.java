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
public class frm_ver_datos_pago_cuponera {
  //*/*********************************************************************************************************************
 
  //********************************************( 1 )***************************************************************
  public static ArrayList<obj_combo_tres_campos> carga_matriculas_alumno_por_rut(String alu_rut) {
    
        ArrayList<obj_combo_tres_campos> lista = new ArrayList<obj_combo_tres_campos>();
        Connection c=null;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_ver_datos_pago_cuponera_busca_por_rut '" + alu_rut + "'";
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
      
 //*********************************************( 2 )**************************************************************      
      public static ArrayList<obj_tres_campos> carga_alumnos_por_matricula(String matricula) {
    
        ArrayList<obj_tres_campos> lista = new ArrayList<obj_tres_campos>();
        Connection c=null;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_ver_datos_pago_cuponera_busca_datos_alumno_por_matricula '" + matricula + "'";
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
 
    
        
         //----------------------------------- ( 3 ) -------------------------------------------
         
          public static ArrayList<obj_dieciseis_campos> llena_grilla_datos_del_pago(String matricula) {
    
        ArrayList<obj_dieciseis_campos> lista = new ArrayList<obj_dieciseis_campos>();
        Connection c=null;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_ver_datos_pago_llena_grilla_datos_del_pago '" + matricula + "'";
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
          
      //--------------------------------------------------------------------------------------
 
    /*      
          public static ArrayList envia_datos_cuponera(String dat_pag_idn) {
    
        ArrayList lista = new ArrayList();
        Connection c=null;
        String exito;
        
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "cuponeras_imprime_individual '" + dat_pag_idn + "'";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            
            lista.add(new obj_combo_tres_campos("0","0"," - Seleccione - "));     
            
            while (rs.next()){
            
      
                 
                lista.add(new obj_diecinueve_campos(rs.getString("mat_idn")
                                            , rs.getString("alu_rut")
                                            , rs.getString("nombre")
                                            , rs.getString("dat_pag_can_cuota")
                                            , rs.getString("dat_pag_valor_arancel")
                                            , rs.getString("eje_nombre")
                                            , rs.getString("env_numero")
                                            , rs.getString("env_fecha_inicio")
                                            , rs.getString("env_fecha_termino")
                                            , rs.getString("lug_pag_nombre")
                                            , rs.getString("seg_div_pol_nombre")
                                            , rs.getString("alu_nacional")
                                            , rs.getString("alu_identificador")
                                            , rs.getString("dat_pag_descuento")
                                            , rs.getString("pag_num_cuota")
                                            , rs.getString("pag_val_cuota")
                                            , rs.getString("pag_fecha_venc")
                                            , rs.getString("dat_pag_idn")
                                            , rs.getString("lugar_recaudadora")));
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
                  public frm_ver_datos_pago_cuponera() {
    }
    
}
