/*
 * frm_adm_registro_pagos_sedes_paga_cuotas.java
 *
 * Created on 5 de marzo de 2007, 13:47
 */

package libreria;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author  Administrador
 */
public class frm_adm_registro_pagos_sedes_paga_cuotas {
    
    
    ///////////////////////////////////////////////
    public static ArrayList<obj_siete_campos> pagos_sedes_muestra_matricula(String rut) {
         ArrayList<obj_siete_campos> lista = new ArrayList<obj_siete_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_pagos_sedes_buscar_matricula (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, rut.trim());
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
      
            lista.add(new obj_siete_campos(rs.getString("alu_idn"),
                                         rs.getString("alu_rut"),
                                         rs.getString("nombre"),
                                         rs.getString("mat_idn"),
                                         rs.getString("mal_nombre"),
                                         rs.getString("pro_nombre"),
                                         rs.getString("lug_mat_nombre")));
           
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
    
    
    public static ArrayList<obj_siete_campos> pagos_sedes_muestra_matricula_x_matricula(String matricula) {
        ArrayList<obj_siete_campos> lista = new ArrayList<obj_siete_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_pagos_sedes_buscar_matricula_x_mat_idn (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, matricula.trim());
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
      
            lista.add(new obj_siete_campos(rs.getString("alu_idn"),
                                         rs.getString("alu_rut"),
                                         rs.getString("nombre"),
                                         rs.getString("mat_idn"),
                                         rs.getString("mal_nombre"),
                                         rs.getString("pro_nombre"),
                                         rs.getString("lug_mat_nombre")));
           
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
    ////////////////////////////////////////////////
     
     
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
  
    
    
    public static ArrayList<obj_tres_campos> orden_pago_muestra_alumno(String rut) {
         ArrayList<obj_tres_campos> lista = new ArrayList<obj_tres_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_pagos_sedes_recauda_muestra_alumno (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, rut.trim());
           
            ResultSet rs = ps.executeQuery();
                        
            while (rs.next()){
            
      
            lista.add(new obj_tres_campos(rs.getString("alu_nombre"),
                                         rs.getString("alu_ap_paterno"),
                                         rs.getString("alu_ap_materno")));
           
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
    
    
     public static ArrayList<obj_dos_campos> orden_pago_muestra_banco() {
         ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_pagos_sedes_recauda_muestra_banco}" ;
            CallableStatement ps = c.prepareCall(sql);
           
            ResultSet rs = ps.executeQuery();
            
            lista.add(new obj_dos_campos("0", "--Seleccione--"));
            
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos(rs.getString("ban_idn"),
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
    
    
    
    
    
    
    public frm_adm_registro_pagos_sedes_paga_cuotas() {
    }
    
     public static ArrayList<obj_ocho_campos> orden_pago_muestra_ordenes(String rut, String rut_funcionario) {
         ArrayList<obj_ocho_campos> lista = new ArrayList<obj_ocho_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_pagos_sedes_recauda_busca_order_pago (?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, rut.trim());
            ps.setString(2, rut_funcionario.trim());
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
      
            lista.add(new obj_ocho_campos(rs.getString("lot_pag_idn"),
                                         rs.getString("dat_pag_idn"),
                                         rs.getString("nombre"),
                                         rs.getString("mat_idn"),
                                         rs.getString("mal_nombre"),
                                         rs.getString("lot_fecha"),
                                         rs.getString("lot_monto"),
                                         rs.getString("dat_pag_ano")));
           
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
     
     
     
      public static ArrayList<obj_dos_campos> orden_pago_muestra_medio_pago() {
         ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_pagos_sedes_recauda_muestra_medio_pago}" ;
            CallableStatement ps = c.prepareCall(sql);
           
            ResultSet rs = ps.executeQuery();
            
            lista.add(new obj_dos_campos("0", "--Seleccione--"));
            
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos(rs.getString("med_pag_idn"),
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
      
      
   public static ArrayList<obj_dos_campos> pagos_sedes_paga_orden_de_pago(int monto, String dato_del_pago, String rut_func, String lote, ArrayList<?> pagos, ArrayList<?> pagos1) {
       
       
        ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
            Connection c=null;
            String lote_insertado, boleta;
             obj_dos_campos registro_lote_insertado = null;
            try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_pagos_sedes_inserta_lote_y_boleta_para_pagar (?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setInt(1, monto);
            ps.setString(2, rut_func.trim());
                       
            ResultSet rs = ps.executeQuery();
        
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos(rs.getString("lote"),rs.getString("boleta")));       
            }
            
                  
              registro_lote_insertado = (obj_dos_campos) lista.get(0);
            
            lote_insertado = registro_lote_insertado.getdata();
            boleta = registro_lote_insertado.getlabel();
            
          //////////
            
            String sql0;
            int size0 = pagos1.size();
            obj_dos_campos registro0 = null;
              
            int x;
            for (x=0; x<size0; x++) 
               {
                    
                       registro0 = (obj_dos_campos) pagos1.get(x);
                        sql0 = "{call flex_adm_pagos_sedes_recauda_paga_cuotas (?,?,?,?)}" ;
                        CallableStatement ps0 = c.prepareCall(sql0);
                        ps0.setString(1,registro0.getdata() );
                        ps0.setInt(2, Integer.parseInt(registro0.getlabel()));
                        ps0.setString(3, lote_insertado );
                        ps0.setString(4, boleta );
                       
                        ps0.execute();
               }
            
            
          ///////////  
            
            
              String sql1;
              int size = pagos.size();
              obj_nueve_campos registro = null;
              
            int j;
            for (j=0; j<size; j++) 
               {
                    
                       registro = (obj_nueve_campos) pagos.get(j);
                        sql1 = "{call flex_adm_pagos_sedes_recauda_inserta_detalle (?,?,?,?,?,?,?,?,?,?)}" ;
                        CallableStatement ps1 = c.prepareCall(sql1);
                        ps1.setString(1, lote_insertado);
                        ps1.setString(2, registro.getcampo_uno() );
                        ps1.setString(3, registro.getcampo_dos() );
                        ps1.setString(4, registro.getcampo_tres() );
                        ps1.setInt(5, Integer.parseInt(registro.getcampo_cuatro()));
                        ps1.setString(6, registro.getcampo_cinco() );
                        ps1.setInt(7, Integer.parseInt(registro.getcampo_seis()));
                        ps1.setString(8, registro.getcampo_siete() );
                        ps1.setString(9, registro.getcampo_ocho() );
                        ps1.setString(10, registro.getcampo_nueve() );
                       
                        ps1.execute();
               }
              
              
              
              
            
        } catch (Exception e) {
            e.printStackTrace();
            lista.remove(0);
            e.getMessage();
            
            
        } finally {
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
                
         return lista;
    
          
          
   }  
   
   
   
   public static ArrayList<obj_dos_campos> pagos_sedes_paga_orden_de_pago_botela_manual (int monto, String dato_del_pago, String rut_func, int boleta_manual, String fecha_boleta , String lote, ArrayList<?> pagos, ArrayList<?> pagos1) {
       
       
        ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
            Connection c=null;
            String lote_insertado, boleta;
             obj_dos_campos registro_lote_insertado = null;
            try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_pagos_sedes_inserta_lote_y_boleta_para_pagar_boleta_manual (?,?,?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setInt(1, monto);
            ps.setString(2, rut_func.trim());
            ps.setInt(3, boleta_manual);
            ps.setString(4, fecha_boleta.trim());
                       
            ResultSet rs = ps.executeQuery();
        
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos(rs.getString("lote"),rs.getString("boleta")));       
            }
            
                  
              registro_lote_insertado = (obj_dos_campos) lista.get(0);
            
            lote_insertado = registro_lote_insertado.getdata();
            boleta = registro_lote_insertado.getlabel();
            
          //////////
            
            String sql0;
            int size0 = pagos1.size();
            obj_dos_campos registro0 = null;
              
            int x;
            for (x=0; x<size0; x++) 
               {
                    
                       registro0 = (obj_dos_campos) pagos1.get(x);
                        sql0 = "{call flex_adm_pagos_sedes_recauda_paga_cuotas (?,?,?,?)}" ;
                        CallableStatement ps0 = c.prepareCall(sql0);
                        ps0.setString(1,registro0.getdata() );
                        ps0.setInt(2, Integer.parseInt(registro0.getlabel()));
                        ps0.setString(3, lote_insertado );
                        ps0.setString(4, boleta );
                       
                        ps0.execute();
               }
            
            
          ///////////  
            
            
              String sql1;
              int size = pagos.size();
              obj_nueve_campos registro = null;
              
            int j;
            for (j=0; j<size; j++) 
               {
                    
                       registro = (obj_nueve_campos) pagos.get(j);
                        sql1 = "{call flex_adm_pagos_sedes_recauda_inserta_detalle (?,?,?,?,?,?,?,?,?,?)}" ;
                        CallableStatement ps1 = c.prepareCall(sql1);
                        ps1.setString(1, lote_insertado);
                        ps1.setString(2, registro.getcampo_uno() );
                        ps1.setString(3, registro.getcampo_dos() );
                        ps1.setString(4, registro.getcampo_tres() );
                        ps1.setInt(5, Integer.parseInt(registro.getcampo_cuatro()));
                        ps1.setString(6, registro.getcampo_cinco() );
                        ps1.setInt(7, Integer.parseInt(registro.getcampo_seis()));
                        ps1.setString(8, registro.getcampo_siete() );
                        ps1.setString(9, registro.getcampo_ocho() );
                        ps1.setString(10, registro.getcampo_nueve() );
                       
                        ps1.execute();
               }
              
              
              
              
            
        } catch (Exception e) {
            e.printStackTrace();
            lista.remove(0);
            e.getMessage();
            
            
        } finally {
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
                
         return lista;
    
          
          
   }  
   
   
   
   
    public static ArrayList<obj_dos_campos> valida_boleta(String boleta ,String rut) {
         ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_pagos_sedes_valida_existe_boleta (?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, boleta.trim());
            ps.setString(2, rut.trim());
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos(rs.getString("valida"),
                                         "validacion"));
           
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
