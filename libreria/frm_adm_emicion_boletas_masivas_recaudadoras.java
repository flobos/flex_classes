package libreria;

import java.util.ArrayList;
import java.sql.*;

import libreria.conexion_odbc;
import libreria.obj_un_campo;

public class frm_adm_emicion_boletas_masivas_recaudadoras {
	
	public static ArrayList<obj_dos_campos> muestra_recaudadora(String inicio, String termino) {
        ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
       Connection c=null;
        try {
           String sql;
           c = conexion_odbc.Connexion_datos();
           sql = "{call flex_adm_boleteo_recaudora_muestra_recaudadora (?,?)}" ;
           CallableStatement ps = c.prepareCall(sql);
           ps.setString(1, inicio.trim());
           ps.setString(2, termino.trim());
           ResultSet rs = ps.executeQuery();
           
           
           lista.add(new obj_dos_campos("0","-- Seleccione --"));
                       
            while (rs.next()){
           
     
           lista.add(new obj_dos_campos(rs.getString("idn"),
                                        rs.getString("codigo")));
          
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
	

	
	 public static ArrayList<obj_doce_campos> muestra_cuotas(String lot_pag_idn, String inicio, String termino) {
	      ArrayList<obj_doce_campos> lista = new ArrayList<obj_doce_campos>();
	        Connection c=null;
	         try {
	            String sql;
	            c = conexion_odbc.Connexion_datos();
	            sql = "{call flex_adm_boleteo_recaudora_muestra_cuotas (?,?,?)}" ;
	            CallableStatement ps = c.prepareCall(sql);
	            ps.setString(1,lot_pag_idn);
	            ps.setString(2, inicio.trim());
	            ps.setString(3, termino.trim());
             
	            ResultSet rs = ps.executeQuery();
	            
	            while (rs.next()){
       	
	            	
	            	 lista.add(new obj_doce_campos (rs.getString("pag_idn"), 
                            rs.getString("mat_idn"), 
                            rs.getString("alu_rut"), 
                            rs.getString("nombre"),
                            rs.getString("car_nombre"),
                            rs.getString("pag_num_cuota"),
                            rs.getString("vencimiento"),
                            rs.getString("pag_valor_cancelado"),
                            rs.getString("fecha_pago"),
                            rs.getString("lot_pag_idn"),
                            rs.getString("num_bol"),
                            rs.getString("fecha_impresion")));
	            
	           
	           
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
	 
	 
	 
	 public static ArrayList<obj_dos_campos> muestra_institucion() {
         ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_boleteo_recaudora_muestra_institucion}" ;
            CallableStatement ps = c.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            
            
            lista.add(new obj_dos_campos("0","-- Seleccione --"));
                        
             while (rs.next()){
            
      
            lista.add(new obj_dos_campos(rs.getString("inst_edu_rut"),
                                         rs.getString("inst_edu_nombre")));
           
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
	 
	 public static ArrayList<obj_tres_campos> actualiza_boleta_pagos(ArrayList<?> arreglo_cuotas) {
	      ArrayList<obj_tres_campos> lista = new ArrayList<obj_tres_campos>();
	        Connection c=null;
	        try {
	           
            String sql;
                 
            int size = arreglo_cuotas.size();   
            int x;    
            c = conexion_odbc.Connexion_datos();
	        sql = "{call flex_adm_boleteo_recaudora_actualiza_boleta_pagos (?,?,?)}" ;
	        CallableStatement ps = c.prepareCall(sql);
              
             for (x=0; x<size; x++) 
            {
            	 obj_tres_campos registro_eje = null;
	            registro_eje = (obj_tres_campos) arreglo_cuotas.get(x);
	            ps.setString(1,registro_eje.getcampo_uno());
	            ps.setString(2,registro_eje.getcampo_dos());
	            ps.setString(3,registro_eje.getcampo_tres());
	           
	            ps.execute();
                  
             }
  
        }
	        
	 catch (Exception e) {
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
	 
	 
	 
	 public static ArrayList<obj_tres_campos> actualiza_fecha_impresion(String lote , String fecha_impresion) {
	      ArrayList<obj_tres_campos> lista = new ArrayList<obj_tres_campos>();
	        Connection c=null;
	        try {
	           
           String sql;
                
            
           c = conexion_odbc.Connexion_datos();
	        sql = "{call flex_adm_boleteo_actualiza_fecha_impresion_boteta (?,?)}" ;
	        CallableStatement ps = c.prepareCall(sql);
             ps.setString(1,lote.trim());
	         ps.setString(2,fecha_impresion.trim());
	        ps.execute();
               
           }
	        
	 catch (Exception e) {
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
