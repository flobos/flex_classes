/*
 * frm_registro_admision_ingreso_registro.java
 *
 * Created on 19 de agosto de 2010, 03:17 PM
 */

package libreria;
import java.util.ArrayList;
import java.sql.*;

public class frm_registro_admision_ver_inscripcion {
	
	//******************************************************************************************************************************************************    
    public static ArrayList<obj_cinco_campos> busca_inscripcion (String insc_idn) {
        ArrayList<obj_cinco_campos> lista = new ArrayList<obj_cinco_campos>();
       Connection c=null;
        try {
           String sql;
           c = conexion_odbc.Connexion_datos();
           sql = "select distinct a.ent_reg_idn, a.pro_mal_idn, cast(day(b.insc_fecha_ingreso) as varchar(2)) + '-' + cast(month(b.insc_fecha_ingreso) as varchar(2)) + '-' + cast(year(b.insc_fecha_ingreso) as varchar(4)) as insc_fecha_ingreso, d.ent_nombre + ' ' + d.ent_ap_paterno + ' ' + d.ent_ap_materno as ent_nombre, cast(day(a.det_insc_fecha_inicio_clases) as varchar(2)) + '-' + cast(month(a.det_insc_fecha_inicio_clases) as varchar(2)) + '-' + cast(year(a.det_insc_fecha_inicio_clases) as varchar(4)) as det_insc_fecha_inicio_clases " ;
           sql = sql + "from detalle_inscripcion a, inscripcion b, entidades_registros c, entidades d " ;
           sql = sql + "where a.insc_idn = "+insc_idn.trim()+" and a.insc_idn = b.insc_idn and a.det_insc_fecha_inicio_clases is not null and a.ent_reg_idn = c.ent_reg_idn and c.ent_idn = d.ent_idn  " ;
           CallableStatement ps = c.prepareCall(sql);
           ResultSet rs = ps.executeQuery();
           
           
            while (rs.next()){
           
               lista.add(new obj_cinco_campos(rs.getString("ent_reg_idn"),
                                            rs.getString("pro_mal_idn"),
                                            rs.getString("insc_fecha_ingreso"),
                                            rs.getString("ent_nombre"),
                                            rs.getString("det_insc_fecha_inicio_clases")));
           }
       } catch (Exception e) {
           e.printStackTrace();
       } finally 
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
        return lista;
  }  
    
  //******************************************************************************************************************************************************    
    public static ArrayList<obj_tres_campos> busca_inscripciones (String ent_idn) {
        ArrayList<obj_tres_campos> lista = new ArrayList<obj_tres_campos>();
       Connection c=null;
        try {
           String sql;
           c = conexion_odbc.Connexion_datos();
           sql = "select distinct a.insc_idn, b.det_insc_idn, cast(day(a.insc_fecha_ingreso) as varchar(2)) + '-' + cast(month(a.insc_fecha_ingreso) as varchar(2)) + '-' + cast(year(a.insc_fecha_ingreso) as varchar(4)) as insc_fecha_ingreso  " ;
           sql = sql + "from inscripcion a, detalle_inscripcion b, entidades_registros c, entidades d " ;
           sql = sql + "where a.insc_idn = b.insc_idn and b.ent_reg_idn = c.ent_reg_idn and c.ent_idn = d.ent_idn and d.ent_codigo_pais = '"+ent_idn.trim()+"'  ";
           sql = sql + "order by insc_fecha_ingreso desc ";
           CallableStatement ps = c.prepareCall(sql);
           ResultSet rs = ps.executeQuery();
           
           
            while (rs.next()){
           
               lista.add(new obj_tres_campos(rs.getString("insc_idn"),
                                            rs.getString("det_insc_idn"),
                                            rs.getString("insc_fecha_ingreso")));
           }
       } catch (Exception e) {
           e.printStackTrace();
       } finally 
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
        return lista;
  } 
    
  //******************************************************************************************************************************************************    
    public static ArrayList<obj_dos_campos> busca_parametro_jornada (String insc_idn, String ent_reg_idn, String pro_mal_idn) {
        ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
       Connection c=null;
        try {
           String sql;
           c = conexion_odbc.Connexion_datos();
           sql = "select c.val_par_idn, c.val_par_valor " ;
           sql = sql + "from detalle_inscripcion a, parametros_detalle_inscripcion b, valores_parametros c " ;
           sql = sql + "where a.det_insc_idn = b.det_insc_idn and b.val_par_idn = c.val_par_idn and c.par_idn = '100' and a.insc_idn = '"+insc_idn.trim()+"' and a.pro_mal_idn = '"+pro_mal_idn.trim()+"' and a.ent_reg_idn = '"+ent_reg_idn.trim()+"'  ";
           
           CallableStatement ps = c.prepareCall(sql);
           ResultSet rs = ps.executeQuery();
           
           
            while (rs.next()){
           
               lista.add(new obj_dos_campos(rs.getString("val_par_idn"),
                                             rs.getString("val_par_valor")));
           }
       } catch (Exception e) {
           e.printStackTrace();
       } finally 
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
        return lista;
  } 
    //******************************************************************************************************************************************************
 	public static ArrayList<obj_un_campo> obtiene_modalidad_campus(String func_mod_fun_idn) {
 	     
 	         ArrayList<obj_un_campo> lista = new ArrayList<obj_un_campo>();
 	        Connection c=null;
 	         try {
 	            String sql;
 	            c = conexion_odbc.Connexion_datos();
 	            sql = "select b.mod_cam_idn from funcion_modalidad_del_funcionario a, funcion_modalidad b where a.func_mod_idn = b.func_mod_idn and func_mod_fun_idn= '"+func_mod_fun_idn.trim()+"' ";
 	            CallableStatement ps = c.prepareCall(sql);
 	            ResultSet rs = ps.executeQuery();
 	                        
 	            while (rs.next())
 	            {

 	                lista.add(new obj_un_campo(rs.getString("mod_cam_idn")));
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
  //******************************************************************************************************************************************************    
	public static ArrayList<obj_doce_campos> busca_promocion_malla(String pro_mal_idn) {
		ArrayList<obj_doce_campos> lista = new ArrayList<obj_doce_campos>();
		Connection c=null;
		try {
			String sql;
			c = conexion_odbc.Connexion_datos();
			
			sql = "select distinct a.car_idn, a.car_nombre, b.mal_idn, b.mal_nombre, c.per_nombre,d.tip_prod_nombre,f.mal_mod_idn, h.pro_idn, h.pro_nombre, d.tip_prod_idn, i.eje_adm_idn, i.eje_adm_nombre  ";
			sql = sql + "from ";
			sql = sql + "carreras a, ";
			sql = sql + "malla_curricular b, ";
			sql = sql + "peririocidad c, ";
			sql = sql + "tipo_producto d, ";
			sql = sql + "malla_campus e, ";
			sql = sql + "malla_modalidad f, ";
			sql = sql + "promociones_dela_malla g, ";
			sql = sql + "promocion h, ";
			sql = sql + "ejecucion_admision i ";
			sql = sql + "where ";		
			sql = sql + "	a.car_idn = b.car_idn ";
			sql = sql + "and b.per_idn = c.per_idn ";
			sql = sql + "and i.eje_adm_idn = g.eje_adm_idn ";
			sql = sql + "and b.tip_prod_idn = d.tip_prod_idn ";
			sql = sql + "and b.mal_idn = e.mal_idn ";
			sql = sql + "and e.mal_cam_idn = f.mal_cam_idn ";
			sql = sql + "and f.mal_mod_idn = g.mal_mod_idn ";
			sql = sql + "and g.pro_idn = h.pro_idn ";
			sql = sql + "and h.pro_activa = 1 ";
			sql = sql + "and g.pro_mal_idn = '"+pro_mal_idn.trim()+"' "; 
			sql = sql + "order by a.car_idn "; 
			
			
			CallableStatement ps = c.prepareCall(sql);
			ResultSet rs = ps.executeQuery();

			
			while (rs.next()){

				lista.add(new obj_doce_campos(	rs.getString("car_idn"),
												rs.getString("car_nombre"),
												rs.getString("mal_idn"),
												rs.getString("mal_nombre"),
												rs.getString("per_nombre"),
												rs.getString("tip_prod_nombre"),
												rs.getString("mal_mod_idn"),
												rs.getString("pro_idn"),
												rs.getString("pro_nombre"),
												rs.getString("tip_prod_idn"),
												rs.getString("eje_adm_idn"),
												rs.getString("eje_adm_nombre")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally 
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
		return lista;
	} 
	
	//******************************************************************************************************************************************************    
	public static ArrayList<obj_nueve_campos> busca_pagadores(String pro_mal_idn, String insc_idn) {
		ArrayList<obj_nueve_campos> lista = new ArrayList<obj_nueve_campos>();
		Connection c=null;
		try {
			String sql;
			c = conexion_odbc.Connexion_datos();
			
			sql = "select * from ";
			sql = sql + "(select b.ent_reg_idn, case when ent_ap_paterno is null then c.ent_nombre else c.ent_nombre + ' ' + c.ent_ap_paterno + ' ' + c.ent_ap_materno end as ent_nombre, e.det_ope_valor,e.det_ope_cuotas, g.med_fin_nombre, f.med_cob_nombre, e.det_ope_fecha_inicio_pago, e.det_ope_dia_vencimiento ";
			sql = sql + "from detalle_inscripcion a, entidades_registros b, entidades c, deudas d, detalle_operaciones e, medio_de_cobro f, medio_de_financiamiento g ";
			sql = sql + "where a.insc_idn = "+insc_idn.trim()+" and e.tip_ope_idn = 0 and  a.pro_mal_idn = "+pro_mal_idn.trim()+" and a.ent_reg_idn = b.ent_reg_idn and b.ent_idn = c.ent_idn and a.det_insc_idn = d.det_insc_idn and d.deu_idn = e.deu_idn and d.med_cob_idn = f.med_cob_idn and d.med_fin_idn = g.med_fin_idn) pagadores,  ";
			sql = sql + "(select sum(e.det_ope_valor) as suma_arancel  ";
			sql = sql + "from detalle_inscripcion a,  entidades_registros b, entidades c, deudas d, detalle_operaciones e, medio_de_cobro f, medio_de_financiamiento g "; 
			sql = sql + "where a.insc_idn = "+insc_idn.trim()+" and a.pro_mal_idn = "+pro_mal_idn.trim()+" and a.ent_reg_idn = b.ent_reg_idn and b.ent_idn = c.ent_idn and a.det_insc_idn = d.det_insc_idn and d.deu_idn = e.deu_idn and d.med_cob_idn = f.med_cob_idn and d.med_fin_idn = g.med_fin_idn group by a.insc_idn, a.pro_mal_idn) arancel_total "; 
			
			
			CallableStatement ps = c.prepareCall(sql);
			ResultSet rs = ps.executeQuery();

			
			while (rs.next()){

				lista.add(new obj_nueve_campos(	rs.getString("ent_reg_idn"),
												rs.getString("ent_nombre"),
												rs.getString("det_ope_valor"),
												rs.getString("det_ope_cuotas"),
												rs.getString("med_fin_nombre"),
												rs.getString("med_cob_nombre"),
												rs.getString("det_ope_fecha_inicio_pago"),
												rs.getString("det_ope_dia_vencimiento"),
												rs.getString("suma_arancel")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally 
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
		return lista;
	} 
	
	 public frm_registro_admision_ver_inscripcion() {
	    }
}
