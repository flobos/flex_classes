/*
 * frm_registro_admision_ingreso_inscripcion.java
 *
 * Created on 23 de septiembre de 2010, 07:28 PM
 */

package libreria;
import java.util.ArrayList;
import java.sql.*;
/**
 * 
 * @author  cmedina
 */
public class frm_registro_admision_ingreso_inscripcion {
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
	public static ArrayList<obj_tres_campos> ingreso_detalle_operaciones
	(String deu_idn,
	String det_ope_valor,
	String tip_mov_idn,
	String tip_ope_idn,
	String det_ope_fecha_inicio_pago,
	String det_ope_cuotas,
	String det_ope_dia_vencimiento,
	String i,
	String j) {
	     
	         ArrayList<obj_tres_campos> lista = new ArrayList<obj_tres_campos>();
	        Connection c=null;
	         try {
	            String sql;
	            c = conexion_odbc.Connexion_datos();
	            sql = "insert into detalle_operaciones (deu_idn, det_ope_valor, tip_mov_idn, tip_ope_idn, det_ope_fecha_inicio_pago, det_ope_cuotas, det_ope_dia_vencimiento, det_ope_fecha_ingreso) values ('"+deu_idn.trim()+"', '"+det_ope_valor.trim()+"','"+tip_mov_idn.trim()+"','"+tip_ope_idn.trim()+"','"+det_ope_fecha_inicio_pago.trim()+"','"+det_ope_cuotas.trim()+"','"+det_ope_dia_vencimiento.trim()+"', getdate()) ";
	            
	            sql = sql + "SELECT SCOPE_IDENTITY() as det_ope_idn";
	            CallableStatement ps = c.prepareCall(sql);
	            ResultSet rs = ps.executeQuery();
	                        
	            while (rs.next())
	            {

	                lista.add(new obj_tres_campos(rs.getString("det_ope_idn"), i, j));
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
	public static ArrayList<obj_tres_campos> ingreso_deuda_pagador
	(String det_insc_idn,
	String med_cob_idn,
	String med_fin_idn,
	String ele_con_pag_idn,
	String deu_periodo,
	String i,
	String j) {
	     
	         ArrayList<obj_tres_campos> lista = new ArrayList<obj_tres_campos>();
	        Connection c=null;
	         try {
	            String sql;
	            c = conexion_odbc.Connexion_datos();
	            sql = "insert into deudas (det_insc_idn, med_cob_idn, med_fin_idn, ele_con_pag_idn, deu_periodo, deu_fecha_ingreso, deu_activa) values ('"+det_insc_idn.trim()+"', '"+med_cob_idn.trim()+"','"+med_fin_idn.trim()+"','"+ele_con_pag_idn.trim()+"','"+deu_periodo.trim()+"', getdate(), 1) ";
	            
	            sql = sql + "SELECT SCOPE_IDENTITY() as deu_idn";
	            CallableStatement ps = c.prepareCall(sql);
	            ResultSet rs = ps.executeQuery();
	                        
	            while (rs.next())
	            {

	                lista.add(new obj_tres_campos(rs.getString("deu_idn"), i, j));
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
	public static ArrayList<obj_tres_campos> ingreso_detalle_alumno
	(String insc_idn,
	String ent_reg_idn,
	String pro_mal_idn,
	String det_insc_fecha_inscripcion,
	String func_mod_fun_idn,
	String det_insc_fecha_inicio_clases,
	String i,
	String j) {
	     
	         ArrayList<obj_tres_campos> lista = new ArrayList<obj_tres_campos>();
	        Connection c=null;
	         try {
	            String sql;
	            c = conexion_odbc.Connexion_datos();
	            sql = "insert into detalle_inscripcion (insc_idn, ent_reg_idn, pro_mal_idn, det_insc_fecha_inscripcion, func_mod_fun_idn,det_insc_fecha_inicio_clases ) values ('"+insc_idn.trim()+"', '"+ent_reg_idn.trim()+"','"+pro_mal_idn.trim()+"','"+det_insc_fecha_inscripcion.trim()+"','"+func_mod_fun_idn.trim()+"','"+det_insc_fecha_inicio_clases.trim()+"' ) ";
	            
	            sql = sql + "SELECT SCOPE_IDENTITY() as det_insc_idn";
	            CallableStatement ps = c.prepareCall(sql);
	            ResultSet rs = ps.executeQuery();
	                        
	            while (rs.next())
	            {

	                lista.add(new obj_tres_campos(rs.getString("det_insc_idn"), i, j));
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
	public static ArrayList<obj_dos_campos> ingreso_parametro_jornada
	(String det_insc_idn,
	String val_par_idn) {
	     
	         ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
	        Connection c=null;
	         try {
	            String sql;
	            c = conexion_odbc.Connexion_datos();
	            sql = "insert into parametros_detalle_inscripcion (val_par_idn, det_insc_idn) values ("+val_par_idn.trim()+", "+det_insc_idn.trim()+" ) ";
	            
	            sql = sql + "SELECT SCOPE_IDENTITY() as par_det_insc_idn";
	            CallableStatement ps = c.prepareCall(sql);
	            ResultSet rs = ps.executeQuery();
	                        
	            while (rs.next())
	            {

	                lista.add(new obj_dos_campos(rs.getString("par_det_insc_idn"),det_insc_idn));
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
	public static ArrayList<obj_tres_campos> ingreso_detalle_pagador
	(String insc_idn,
	String ent_reg_idn,
	String pro_mal_idn,
	String det_insc_fecha_inscripcion,
	String func_mod_fun_idn,
	String i,
	String j) {
	     
	         ArrayList<obj_tres_campos> lista = new ArrayList<obj_tres_campos>();
	        Connection c=null;
	         try {
	            String sql;
	            c = conexion_odbc.Connexion_datos();
	            sql = "insert into detalle_inscripcion (insc_idn, ent_reg_idn, pro_mal_idn, det_insc_fecha_inscripcion, func_mod_fun_idn) values ('"+insc_idn.trim()+"', '"+ent_reg_idn.trim()+"','"+pro_mal_idn.trim()+"','"+det_insc_fecha_inscripcion.trim()+"','"+func_mod_fun_idn.trim()+"' ) ";
	            
	            sql = sql + "SELECT SCOPE_IDENTITY() as det_insc_idn";
	            CallableStatement ps = c.prepareCall(sql);
	            ResultSet rs = ps.executeQuery();
	                        
	            while (rs.next())
	            {

	                lista.add(new obj_tres_campos(rs.getString("det_insc_idn"), i, j));
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
	public static ArrayList<obj_un_campo> ingreso_inscripcion(String tipo_inscripcion) {
	     
	         ArrayList<obj_un_campo> lista = new ArrayList<obj_un_campo>();
	        Connection c=null;
	         try {
	            String sql;
	            c = conexion_odbc.Connexion_datos();
	            sql = "insert into inscripcion(insc_fecha_ingreso,tip_insc_idn) values (getdate(), "+tipo_inscripcion.trim()+" ) ";
	            
	            sql = sql + "SELECT SCOPE_IDENTITY() as insc_idn";
	            CallableStatement ps = c.prepareCall(sql);
	            ResultSet rs = ps.executeQuery();
	                        
	            while (rs.next())
	            {

	                lista.add(new obj_un_campo(rs.getString("insc_idn")));
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
	public static ArrayList<obj_cuatro_campos> muestra_carreras(String mod_cam_idn, String pro_idn) {
		ArrayList<obj_cuatro_campos> lista = new ArrayList<obj_cuatro_campos>();
		Connection c=null;
		try {
			String sql;
			c = conexion_odbc.Connexion_datos();
			
			sql = "select distinct a.car_idn, a.car_nombre, cast(g.pro_mal_val_arancel as varchar(12)) as pro_mal_val_arancel, cast(g.pro_mal_val_matricula as varchar(12)) as pro_mal_val_matricula ";
			sql = sql + "from ";
			sql = sql + "carreras a, ";
			sql = sql + "malla_curricular b, ";
			sql = sql + "peririocidad c, ";
			sql = sql + "tipo_producto d, ";
			sql = sql + "malla_campus e, ";
			sql = sql + "malla_modalidad f, ";
			sql = sql + "promociones_dela_malla g, ";
			sql = sql + "promocion h ";
			sql = sql + "where ";
			sql = sql + "	a.car_idn = b.car_idn ";
			sql = sql + "and b.per_idn = c.per_idn ";
			sql = sql + "and b.tip_prod_idn = d.tip_prod_idn ";
			sql = sql + "and b.mal_idn = e.mal_idn ";
			sql = sql + "and e.mal_cam_idn = f.mal_cam_idn ";
			sql = sql + "and f.mal_mod_idn = g.mal_mod_idn ";
			sql = sql + "and g.pro_idn = h.pro_idn ";
			sql = sql + "and h.pro_activa = 1 ";
			sql = sql + "and h.mod_cam_idn = '"+mod_cam_idn.trim()+"' ";
			sql = sql + "and h.pro_idn = '"+pro_idn.trim()+"' "; 
			sql = sql + "order by a.car_nombre "; 
			
			
			CallableStatement ps = c.prepareCall(sql);
			ResultSet rs = ps.executeQuery();

			lista.add(new obj_cuatro_campos("0", "-- Seleccione Carrera --","0","0")); 

			while (rs.next()){

				lista.add(new obj_cuatro_campos(rs.getString("car_idn"),
						rs.getString("car_nombre"),
						rs.getString("pro_mal_val_arancel"),
						rs.getString("pro_mal_val_matricula")));
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
	public static ArrayList<obj_dos_campos> muestra_tipo_carrera(String mod_cam_idn) {
		ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
		Connection c=null;
		try {
			String sql;
			c = conexion_odbc.Connexion_datos();
			
			sql = "select distinct d.tip_prod_idn, d.tip_prod_nombre ";
			sql = sql + "from ";
			sql = sql + "carreras a, ";
			sql = sql + "malla_curricular b, ";
			sql = sql + "peririocidad c, ";
			sql = sql + "tipo_producto d, ";
			sql = sql + "malla_campus e, ";
			sql = sql + "malla_modalidad f, ";
			sql = sql + "promociones_dela_malla g, ";
			sql = sql + "promocion h ";
			sql = sql + "where ";
			sql = sql + "	a.car_idn = b.car_idn ";
			sql = sql + "and b.per_idn = c.per_idn ";
			sql = sql + "and b.tip_prod_idn = d.tip_prod_idn ";
			sql = sql + "and b.mal_idn = e.mal_idn ";
			sql = sql + "and e.mal_cam_idn = f.mal_cam_idn ";
			sql = sql + "and f.mal_mod_idn = g.mal_mod_idn ";
			sql = sql + "and g.pro_idn = h.pro_idn ";
			sql = sql + "and h.pro_activa = 1 ";
			sql = sql + "and h.mod_cam_idn = '"+mod_cam_idn.trim()+"' "; 
			sql = sql + "order by d.tip_prod_nombre "; 
			
			
			CallableStatement ps = c.prepareCall(sql);
			ResultSet rs = ps.executeQuery();

			lista.add(new obj_dos_campos("0", "-- Todos --")); 

			while (rs.next()){

				lista.add(new obj_dos_campos(rs.getString("tip_prod_idn"),
						rs.getString("tip_prod_nombre")));
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
	public static ArrayList<obj_dos_campos> muestra_carreras_tipo(String mod_cam_idn, String tipo_carrera) {
		ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
		Connection c=null;
		try {
			String sql;
			c = conexion_odbc.Connexion_datos();
			
			sql = "select distinct a.car_idn, a.car_nombre ";
			sql = sql + "from ";
			sql = sql + "carreras a, ";
			sql = sql + "malla_curricular b, ";
			sql = sql + "peririocidad c, ";
			sql = sql + "tipo_producto d, ";
			sql = sql + "malla_campus e, ";
			sql = sql + "malla_modalidad f, ";
			sql = sql + "promociones_dela_malla g, ";
			sql = sql + "promocion h ";
			sql = sql + "where ";
			sql = sql + "	a.car_idn = b.car_idn ";
			sql = sql + "and b.per_idn = c.per_idn ";
			sql = sql + "and b.tip_prod_idn = d.tip_prod_idn ";
			sql = sql + "and b.mal_idn = e.mal_idn ";
			sql = sql + "and e.mal_cam_idn = f.mal_cam_idn ";
			sql = sql + "and f.mal_mod_idn = g.mal_mod_idn ";
			sql = sql + "and g.pro_idn = h.pro_idn ";
			sql = sql + "and h.pro_activa = 1 ";
			sql = sql + "and h.mod_cam_idn = '"+mod_cam_idn.trim()+"' ";
			sql = sql + "and d.tip_prod_idn = '"+tipo_carrera.trim()+"' ";
			sql = sql + "order by a.car_nombre "; 
			
			
			CallableStatement ps = c.prepareCall(sql);
			ResultSet rs = ps.executeQuery();

			lista.add(new obj_dos_campos("0", "-- Seleccione Carrera --")); 

			while (rs.next()){

				lista.add(new obj_dos_campos(rs.getString("car_idn"),
						rs.getString("car_nombre")));
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
	public static ArrayList<obj_dos_campos> muestra_promociones_tipo(String mod_cam_idn, String tipo_carrera) {
		ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
		Connection c=null;
		try {
			String sql;
			c = conexion_odbc.Connexion_datos();
			
			sql = "select distinct h.pro_idn, h.pro_nombre ";
			sql = sql + "from ";
			sql = sql + "carreras a, ";
			sql = sql + "malla_curricular b, ";
			sql = sql + "peririocidad c, ";
			sql = sql + "tipo_producto d, ";
			sql = sql + "malla_campus e, ";
			sql = sql + "malla_modalidad f, ";
			sql = sql + "promociones_dela_malla g, ";
			sql = sql + "promocion h ";
			sql = sql + "where ";
			sql = sql + "	a.car_idn = b.car_idn ";
			sql = sql + "and b.per_idn = c.per_idn ";
			sql = sql + "and b.tip_prod_idn = d.tip_prod_idn ";
			sql = sql + "and b.mal_idn = e.mal_idn ";
			sql = sql + "and e.mal_cam_idn = f.mal_cam_idn ";
			sql = sql + "and f.mal_mod_idn = g.mal_mod_idn ";
			sql = sql + "and g.pro_idn = h.pro_idn ";
			sql = sql + "and h.pro_activa = 1 ";
			sql = sql + "and h.mod_cam_idn = '"+mod_cam_idn.trim()+"' ";
			sql = sql + "and d.tip_prod_idn = '"+tipo_carrera.trim()+"' ";
			sql = sql + "order by h.pro_nombre "; 
			
			
			CallableStatement ps = c.prepareCall(sql);
			ResultSet rs = ps.executeQuery();

			lista.add(new obj_dos_campos("0", "-- Seleccione Promoción --")); 

			while (rs.next()){

				lista.add(new obj_dos_campos(rs.getString("pro_idn"),
						rs.getString("pro_nombre")));
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
	public static ArrayList<obj_ocho_campos> muestra_mallas(String mod_cam_idn,String car_idn, String pro_idn) {
		ArrayList<obj_ocho_campos> lista = new ArrayList<obj_ocho_campos>();
		Connection c=null;
		try {
			String sql;
			c = conexion_odbc.Connexion_datos();
			
			sql = "select distinct b.mal_idn, b.mal_nombre, d.tip_prod_nombre, c.per_nombre, f.mal_mod_idn, d.tip_prod_idn, i.eje_adm_idn, i.eje_adm_nombre ";
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
			sql = sql + "and b.tip_prod_idn = d.tip_prod_idn ";
			sql = sql + "and b.mal_idn = e.mal_idn ";
			sql = sql + "and i.eje_adm_idn = g.eje_adm_idn ";
			sql = sql + "and e.mal_cam_idn = f.mal_cam_idn ";
			sql = sql + "and f.mal_mod_idn = g.mal_mod_idn ";
			sql = sql + "and g.pro_idn = h.pro_idn ";
			sql = sql + "and h.pro_activa = 1 ";
			sql = sql + "and h.mod_cam_idn = '"+mod_cam_idn.trim()+"' ";
			sql = sql + "and a.car_idn = '"+car_idn.trim()+"' ";
			sql = sql + "and h.pro_idn = '"+pro_idn.trim()+"' ";
			sql = sql + "order by b.mal_nombre, d.tip_prod_nombre, c.per_nombre ";
			
			
			CallableStatement ps = c.prepareCall(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()){

				lista.add(new obj_ocho_campos(rs.getString("mal_idn"),
												rs.getString("mal_nombre"),
												rs.getString("tip_prod_nombre"),
												rs.getString("per_nombre"),
												rs.getString("mal_mod_idn"),
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
	public static ArrayList<obj_dos_campos> muestra_reportes(String mod_cam_idn,String tip_prod_idn, String eje_adm_idn) {
		ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
		Connection c=null;
		try {
			String sql;
			c = conexion_odbc.Connexion_datos();
			
			sql = "select distinct b.rep_nombre, b.rep_archivo ";
			sql = sql + "from ";
			sql = sql + "reportes_campus_modalidad a, reportes b ";
			sql = sql + "where a.rep_idn = b.rep_idn ";
			sql = sql + "and a.mod_cam_idn = '"+mod_cam_idn.trim()+"' ";
			sql = sql + "and a.tip_prod_idn = '"+tip_prod_idn.trim()+"' ";
			sql = sql + "and a.eje_adm_idn = '"+eje_adm_idn.trim()+"' ";
			sql = sql + "order by b.rep_nombre, b.rep_archivo ";
			
			
			CallableStatement ps = c.prepareCall(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()){

				lista.add(new obj_dos_campos(rs.getString("rep_archivo"),
												rs.getString("rep_nombre")));
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
	public static ArrayList<obj_dos_campos> muestra_promociones(String mod_cam_idn) {
		ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
		Connection c=null;
		try {
			String sql;
			c = conexion_odbc.Connexion_datos();
			
			sql = "select distinct h.pro_idn, h.pro_nombre ";
			sql = sql + "from ";
			sql = sql + "carreras a, ";
			sql = sql + "malla_curricular b, ";
			sql = sql + "peririocidad c, ";
			sql = sql + "tipo_producto d, ";
			sql = sql + "malla_campus e, ";
			sql = sql + "malla_modalidad f, ";
			sql = sql + "promociones_dela_malla g, ";
			sql = sql + "promocion h ";
			sql = sql + "where ";		
			sql = sql + "	a.car_idn = b.car_idn ";
			sql = sql + "and b.per_idn = c.per_idn ";
			sql = sql + "and b.tip_prod_idn = d.tip_prod_idn ";
			sql = sql + "and b.mal_idn = e.mal_idn ";
			sql = sql + "and e.mal_cam_idn = f.mal_cam_idn ";
			sql = sql + "and f.mal_mod_idn = g.mal_mod_idn ";
			sql = sql + "and g.pro_idn = h.pro_idn ";
			sql = sql + "and h.pro_activa = 1 ";
			sql = sql + "and h.mod_cam_idn = '"+mod_cam_idn.trim()+"' "; 
			sql = sql + "order by h.pro_nombre "; 
			
			
			CallableStatement ps = c.prepareCall(sql);
			ResultSet rs = ps.executeQuery();

			lista.add(new obj_dos_campos("0", "-- Seleccione Promoción --")); 

			while (rs.next()){

				lista.add(new obj_dos_campos(rs.getString("pro_idn"),
											rs.getString("pro_nombre")));
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
	public static ArrayList<obj_un_campo> muestra_promocion_malla(String mod_cam_idn, String car_idn, String mal_mod_idn, String pro_idn) {
		ArrayList<obj_un_campo> lista = new ArrayList<obj_un_campo>();
		Connection c=null;
		try {
			String sql;
			c = conexion_odbc.Connexion_datos();
			
			sql = "select distinct g.pro_mal_idn ";
			sql = sql + "from ";
			sql = sql + "carreras a, ";
			sql = sql + "malla_curricular b, ";
			sql = sql + "peririocidad c, ";
			sql = sql + "tipo_producto d, ";
			sql = sql + "malla_campus e, ";
			sql = sql + "malla_modalidad f, ";
			sql = sql + "promociones_dela_malla g, ";
			sql = sql + "promocion h ";
			sql = sql + "where ";		
			sql = sql + "	a.car_idn = b.car_idn ";
			sql = sql + "and b.per_idn = c.per_idn ";
			sql = sql + "and b.tip_prod_idn = d.tip_prod_idn ";
			sql = sql + "and b.mal_idn = e.mal_idn ";
			sql = sql + "and e.mal_cam_idn = f.mal_cam_idn ";
			sql = sql + "and f.mal_mod_idn = g.mal_mod_idn ";
			sql = sql + "and g.pro_idn = h.pro_idn ";
			sql = sql + "and h.pro_activa = 1 ";
			sql = sql + "and h.mod_cam_idn = '"+mod_cam_idn.trim()+"' "; 
			sql = sql + "and a.car_idn = '"+car_idn.trim()+"' ";
			sql = sql + "and f.mal_mod_idn = '"+mal_mod_idn.trim()+"' ";
			sql = sql + "and h.pro_idn = '"+pro_idn.trim()+"' ";
			sql = sql + "order by g.pro_mal_idn "; 
			
			
			CallableStatement ps = c.prepareCall(sql);
			ResultSet rs = ps.executeQuery();

			
			while (rs.next()){

				lista.add(new obj_un_campo(rs.getString("pro_mal_idn")));
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
	public static ArrayList<obj_nueve_campos> busca_promocion_malla(String mod_cam_idn, String pro_mal_idn) {
		ArrayList<obj_nueve_campos> lista = new ArrayList<obj_nueve_campos>();
		Connection c=null;
		try {
			String sql;
			c = conexion_odbc.Connexion_datos();
			
			sql = "select distinct a.car_idn, a.car_nombre, b.mal_idn, b.mal_nombre, c.per_nombre,d.tip_prod_nombre,f.mal_mod_idn, h.pro_idn, h.pro_nombre  ";
			sql = sql + "from ";
			sql = sql + "carreras a, ";
			sql = sql + "malla_curricular b, ";
			sql = sql + "peririocidad c, ";
			sql = sql + "tipo_producto d, ";
			sql = sql + "malla_campus e, ";
			sql = sql + "malla_modalidad f, ";
			sql = sql + "promociones_dela_malla g, ";
			sql = sql + "promocion h ";
			sql = sql + "where ";		
			sql = sql + "	a.car_idn = b.car_idn ";
			sql = sql + "and b.per_idn = c.per_idn ";
			sql = sql + "and b.tip_prod_idn = d.tip_prod_idn ";
			sql = sql + "and b.mal_idn = e.mal_idn ";
			sql = sql + "and e.mal_cam_idn = f.mal_cam_idn ";
			sql = sql + "and f.mal_mod_idn = g.mal_mod_idn ";
			sql = sql + "and g.pro_idn = h.pro_idn ";
			sql = sql + "and h.pro_activa = 1 ";
			sql = sql + "and h.mod_cam_idn = '"+mod_cam_idn.trim()+"' "; 
			sql = sql + "and g.pro_mal_idn = '"+pro_mal_idn.trim()+"' "; 
			sql = sql + "order by a.car_idn "; 
			
			
			CallableStatement ps = c.prepareCall(sql);
			ResultSet rs = ps.executeQuery();

			
			while (rs.next()){

				lista.add(new obj_nueve_campos(	rs.getString("car_idn"),
												rs.getString("car_nombre"),
												rs.getString("mal_idn"),
												rs.getString("mal_nombre"),
												rs.getString("per_nombre"),
												rs.getString("tip_prod_nombre"),
												rs.getString("mal_mod_idn"),
												rs.getString("pro_idn"),
												rs.getString("pro_nombre")));
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
	public static ArrayList<obj_dos_campos> muestra_financiamiento() {
		ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
		Connection c=null;
		try {
			String sql;
			c = conexion_odbc.Connexion_datos();
			sql = "select * from medio_de_financiamiento" ;
			CallableStatement ps = c.prepareCall(sql);
			ResultSet rs = ps.executeQuery();

			lista.add(new obj_dos_campos("0", "-- Seleccione --")); 

			while (rs.next()){

				lista.add(new obj_dos_campos(rs.getString("med_fin_idn"),
						rs.getString("med_fin_nombre")));
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
	public static ArrayList<obj_dos_campos> muestra_tipo_admision() {
		ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
		Connection c=null;
		try {
			String sql;
			c = conexion_odbc.Connexion_datos();
			sql = "select * from tipo_admision" ;
			CallableStatement ps = c.prepareCall(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()){

				lista.add(new obj_dos_campos(rs.getString("tip_adm_idn"),
						rs.getString("tip_adm_nombre")));
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
	public static ArrayList<obj_dos_campos> muestra_jornada() {
		ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
		Connection c=null;
		try {
			String sql;
			c = conexion_odbc.Connexion_datos();
			sql = "select * from valores_parametros where par_idn = 100" ;
			CallableStatement ps = c.prepareCall(sql);
			ResultSet rs = ps.executeQuery();
			lista.add(new obj_dos_campos("0", "-- Seleccione --"));
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
	public static ArrayList<obj_dos_campos> muestra_tipo_educacional() {
		ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
		Connection c=null;
		try {
			String sql;
			c = conexion_odbc.Connexion_datos();
			sql = "select * from tipo_antecedente_educacional" ;
			CallableStatement ps = c.prepareCall(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()){

				lista.add(new obj_dos_campos(rs.getString("tip_ant_edu_idn"),
						rs.getString("tip_ant_edu_nombre")));
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
	public static ArrayList<obj_dos_campos> muestra_medio_cobro() {
		ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
		Connection c=null;
		try {
			String sql;
			c = conexion_odbc.Connexion_datos();
			sql = "select * from medio_de_cobro" ;
			CallableStatement ps = c.prepareCall(sql);
			ResultSet rs = ps.executeQuery();

			lista.add(new obj_dos_campos("0", "-- Seleccione --")); 

			while (rs.next()){

				lista.add(new obj_dos_campos(rs.getString("med_cob_idn"),
						rs.getString("med_cob_nombre")));
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
	public static ArrayList<obj_dos_campos> muestra_estado_renuncia() {
		ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
		Connection c=null;
		try {
			String sql;
			c = conexion_odbc.Connexion_datos();
			sql = "select * from estado_renuncia" ;
			CallableStatement ps = c.prepareCall(sql);
			ResultSet rs = ps.executeQuery();

			lista.add(new obj_dos_campos("0", "-- Seleccione --")); 

			while (rs.next()){

				lista.add(new obj_dos_campos(rs.getString("est_ren_idn"),
						rs.getString("est_ren_nombre")));
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
	public static ArrayList<obj_dos_campos> muestra_promocion_comercial() {
		ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
		Connection c=null;
		try {
			String sql;
			c = conexion_odbc.Connexion_datos();
			sql = "select * from promociones_comerciales" ;
			CallableStatement ps = c.prepareCall(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()){

				lista.add(new obj_dos_campos(rs.getString("pro_com_idn"),
						rs.getString("pro_com_nombre")));
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
	public static ArrayList<obj_tres_campos> muestra_direcciones(String ent_reg_idn) {
		ArrayList<obj_tres_campos> lista = new ArrayList<obj_tres_campos>();
		Connection c=null;
		try {
			String sql;
			c = conexion_odbc.Connexion_datos();
			sql = "select a.ent_reg_dir_idn, b.env_doc_nombre + ' - ' + d.dir_direccion + ' ' + d.dir_numero + ' ' + e.seg_div_pol_nombre as env_doc_nombre, a.ent_reg_env_defecto " ;
			sql = sql + "from entidades_registros_envios a, envio_documentacion b, entidades_registros_direcciones c, direcciones d, segunda_division_politica e " ;
			sql = sql + "where a.ent_reg_dir_idn = c.ent_reg_dir_idn and c.dir_idn = d.dir_idn and c.dir_activa = 1 and d.seg_div_pol_idn = e.seg_div_pol_idn and a.ent_reg_env_activo = 1 and a.env_doc_idn = b.env_doc_idn and a.ent_reg_idn = "+ ent_reg_idn.trim() + " " ;
			sql = sql + "order by b.env_doc_nombre ASC" ;

			CallableStatement ps = c.prepareCall(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()){

				lista.add(new obj_tres_campos(rs.getString("ent_reg_dir_idn"),
						rs.getString("env_doc_nombre"),
						rs.getString("ent_reg_env_defecto")));
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
	public static ArrayList<obj_cinco_campos> muestra_requisitos_asignados(String ent_reg_idn) {
		ArrayList<obj_cinco_campos> lista = new ArrayList<obj_cinco_campos>();
		Connection c=null;
		try {
			String sql;
			c = conexion_odbc.Connexion_datos();
			sql = "select b.ent_req_idn, c.req_ing_nombre, b.ent_req_cantidad, e.pri_idn, e.pri_nombre " ;
			sql = sql + "from entidades_registros a, entidades_requisitos b, requisito_ingreso c, prioridad_requisitos_entidad d, prioridad e " ;
			sql = sql + "where a.ent_reg_idn = b.ent_reg_idn and b.req_ing_idn = c.req_ing_idn and d.pri_idn = e.pri_idn and d.ent_req_idn = b.ent_req_idn and a.ent_reg_idn = "+ ent_reg_idn.trim() + " " ;
			sql = sql + "and ((b.ent_req_duracion = 0 and b.ent_req_ultima_recepcion is null  ) or (b.ent_req_duracion <> 0 and b.ent_req_ultima_recepcion is null) or ( b.ent_req_duracion <> 0 and b.ent_req_ultima_recepcion is not null and DATEADD(month, b.ent_req_duracion, b.ent_req_ultima_recepcion) < getdate())  ) " ;
			sql = sql + "order by b.ent_req_idn asc" ;

			CallableStatement ps = c.prepareCall(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()){

				lista.add(new obj_cinco_campos(  rs.getString("ent_req_idn"),
						rs.getString("req_ing_nombre"),
						rs.getString("ent_req_cantidad"),
						rs.getString("pri_idn"),
						rs.getString("pri_nombre")));
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
	public static ArrayList<obj_cinco_campos> muestra_requisitos_renovar(String ent_reg_idn) {
		ArrayList<obj_cinco_campos> lista = new ArrayList<obj_cinco_campos>();
		Connection c=null;
		try {
			String sql;
			c = conexion_odbc.Connexion_datos();
			sql = "select c.req_ing_nombre, b.ent_req_cantidad, b.ent_req_ultima_recepcion, e.pri_idn, e.pri_nombre " ;
			sql = sql + "from entidades_registros a, entidades_requisitos b, requisito_ingreso c, prioridad_requisitos_entidad d, prioridad e " ;
			sql = sql + "where a.ent_reg_idn = b.ent_reg_idn and b.req_ing_idn = c.req_ing_idn and d.pri_idn = e.pri_idn and d.ent_req_idn = b.ent_req_idn and a.ent_reg_idn = "+ ent_reg_idn.trim() + " " ;
			sql = sql + "and ((b.ent_req_duracion = 0 and b.ent_req_ultima_recepcion is not null) or (b.ent_req_duracion <> 0 and b.ent_req_ultima_recepcion is not null and DATEADD(month, b.ent_req_duracion, b.ent_req_ultima_recepcion) >= getdate()))   " ;
			sql = sql + "order by b.ent_req_idn asc" ;

			CallableStatement ps = c.prepareCall(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()){

				lista.add(new obj_cinco_campos(  rs.getString("req_ing_nombre"),
						rs.getString("ent_req_cantidad"),
						rs.getString("ent_req_ultima_recepcion"),
						rs.getString("pri_idn"),
						rs.getString("pri_nombre")));
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
	public static ArrayList<obj_tres_campos> validar_requisito(String ent_req_idn) {
		ArrayList<obj_tres_campos> lista = new ArrayList<obj_tres_campos>();
		Connection c=null;
		try {
			String sql;
			c = conexion_odbc.Connexion_datos();
			sql = "update entidades_requisitos set ent_req_ultima_recepcion = getdate() where ent_req_idn = '"+ent_req_idn.trim()+"' " ;
			
			CallableStatement ps = c.prepareCall(sql);
			ResultSet rs = ps.executeQuery();
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
	public static ArrayList<obj_cinco_campos> muestra_requisitos(String car_idn) {
		ArrayList<obj_cinco_campos> lista = new ArrayList<obj_cinco_campos>();
		Connection c=null;
		try {
			String sql;
			c = conexion_odbc.Connexion_datos();
			sql = "select c.req_ing_idn, c.req_ing_nombre, b.req_ing_carr_cant, e.pri_idn, e.pri_nombre " ;
			sql = sql + "from carreras a, req_ing_carrera_cursos b, requisito_ingreso c, prioridad_requisitos_carrera d, prioridad e " ;
			sql = sql + "where a.car_idn = b.car_idn and e.pri_idn = d.pri_idn and d.reg_ing_car_idn = b.reg_ing_car_idn and b.reg_ing_idn = c.req_ing_idn and a.car_idn = "+ car_idn.trim() + " " ;
			sql = sql + "order by c.req_ing_idn asc" ;

			CallableStatement ps = c.prepareCall(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()){

				lista.add(new obj_cinco_campos(  rs.getString("req_ing_idn"),
						rs.getString("req_ing_nombre"),
						rs.getString("req_ing_carr_cant"),
						rs.getString("pri_idn"),
						rs.getString("pri_nombre")));
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
	public static ArrayList<obj_un_campo_string> muestra_arancel(String pro_mal_idn, String eje_idn) {
		ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
		Connection c=null;
		try {
			String sql;
			c = conexion_odbc.Connexion_datos();
			sql = "select a.pro_mal_eje_con_pag_arancel " ;
			sql = sql + "from promo_malla_ejecucion_concep_pagos_arancel a, promociones_dela_malla_ejecucion b, elementos_concepto_pagos c, elementos_pagos e " ;
			sql = sql + "where b.eje_idn = '"+ eje_idn.trim() + "' and b.pro_mal_idn = '"+ pro_mal_idn.trim() + "' and b.pro_eje_idn = a.pro_eje_idn and a.ele_con_pag_idn = c.ele_con_pag_idn and c.ele_pag_idn = e.ele_pag_idn and e.ele_pag_idn = '100'" ;

			CallableStatement ps = c.prepareCall(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()){

				lista.add(new obj_un_campo_string(  rs.getString("pro_mal_eje_con_pag_arancel")));
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
	public static ArrayList<obj_tres_campos> muestra_aranceles_malla(String pro_mal_idn) {
		ArrayList<obj_tres_campos> lista = new ArrayList<obj_tres_campos>();
		Connection c=null;
		try {
			String sql;
			c = conexion_odbc.Connexion_datos();
			sql = "select c.eje_idn, c.eje_nombre, b.pro_mal_eje_con_pag_arancel " ;
			sql = sql + "from promociones_dela_malla_ejecucion a, promo_malla_ejecucion_concep_pagos_arancel b, ejecucion c " ;
			sql = sql + "where a.pro_eje_idn = b.pro_eje_idn and a.eje_idn = c.eje_idn and b.ele_con_pag_idn = 100 and year(c.eje_fecha_inicio) >= (year(getdate()) - 1 ) and a.pro_mal_idn = '"+pro_mal_idn.trim()+"' " ;
			sql = sql + "order by c.eje_idn desc" ;
			
			CallableStatement ps = c.prepareCall(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()){

				lista.add(new obj_tres_campos(  rs.getString("eje_idn"),
												rs.getString("eje_nombre"),
												rs.getString("pro_mal_eje_con_pag_arancel")));
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
	public static ArrayList<obj_dos_campos> busca_materiales(String mat_apoyo_nombre) {
		ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
		Connection c=null;
		try {
			String sql;
			c = conexion_odbc.Connexion_datos();
			sql = "select rep_med_idn, rep_med_nombre " ;
			sql = sql + "from repositorio_medios " ;
			sql = sql + "where Lower(rep_med_nombre) like '"+ mat_apoyo_nombre.toLowerCase().trim() + "%' " ;
			sql = sql + "order by rep_med_idn asc" ;

			CallableStatement ps = c.prepareCall(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()){

				lista.add(new obj_dos_campos(  rs.getString("rep_med_idn"),
						rs.getString("rep_med_nombre")));
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
	public static ArrayList<obj_dos_campos> muestra_material_apoyo(String pro_mal_idn) {
		ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
		Connection c=null;
		try {
			String sql;
			c = conexion_odbc.Connexion_datos();
			sql = "select distinct d.rep_med_idn, d.rep_med_nombre " ;
			sql = sql + "from promociones_dela_malla a, productos_dela_malla b, medios_cursos c, repositorio_medios d " ;
			sql = sql + "where a.mal_mod_idn = b.mal_mod_idn and b.pro_cam_idn = c.pro_cam_idn and c.rep_med_idn = d.rep_med_idn and a.pro_mal_idn = "+ pro_mal_idn.trim() + " " ;
			sql = sql + "order by d.rep_med_idn ASC" ;

			CallableStatement ps = c.prepareCall(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()){

				lista.add(new obj_dos_campos(  rs.getString("rep_med_idn"),
						rs.getString("rep_med_nombre")));
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
	public static ArrayList<obj_once_campos> muestra_malla(String pro_mal_idn) {
		ArrayList<obj_once_campos> lista = new ArrayList<obj_once_campos>();
		Connection c=null;
		try {
			String sql;
			c = conexion_odbc.Connexion_datos();
			sql = "select a.car_nombre,f.pro_nombre, day(e.pro_mal_fec_ini) as dia_ini, month(e.pro_mal_fec_ini) as mes_ini, year(e.pro_mal_fec_ini) as ano_ini , day(e.pro_mal_fec_fin) as dia_fin, month(e.pro_mal_fec_fin) as mes_fin, year(e.pro_mal_fec_fin) as ano_fin, g.eje_idn, g.eje_nombre, a.car_idn ";
			sql = sql + "from carreras a, malla_curricular b, malla_campus c, malla_modalidad d, promociones_dela_malla e, promocion f, ejecucion g " ;
			sql = sql + "where e.pro_mal_activa = 1 and f.pro_idn = g.eje_idn and f.pro_nombre = g.eje_nombre and e.pro_idn = f.pro_idn and a.car_idn = b.car_idn and b.mal_idn = c.mal_idn and c.mal_cam_idn = d.mal_cam_idn and d.mal_mod_idn = e.mal_mod_idn and e.pro_mal_idn = "+ pro_mal_idn.trim() + " " ;

			CallableStatement ps = c.prepareCall(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()){

				lista.add(new obj_once_campos(rs.getString("car_nombre"),
						rs.getString("pro_nombre"),
						rs.getString("dia_ini"),
						rs.getString("mes_ini"),
						rs.getString("ano_ini"),
						rs.getString("dia_fin"),
						rs.getString("mes_fin"),
						rs.getString("ano_fin"),
						rs.getString("eje_idn"),
						rs.getString("eje_nombre"),
						rs.getString("car_idn")));
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
	public static ArrayList<obj_tres_campos> muestra_direcciones2(String ent_reg_idn) {
		ArrayList<obj_tres_campos> lista = new ArrayList<obj_tres_campos>();
		Connection c=null;
		try {
			String sql;
			c = conexion_odbc.Connexion_datos();
			sql = "select a.ent_reg_dir_idn, b.env_doc_nombre + ' - ' + d.dir_direccion + ' ' + d.dir_numero + ' ' + e.seg_div_pol_nombre as env_doc_nombre, a.ent_reg_env_defecto " ;
			sql = sql + "from entidades_registros_envios a, envio_documentacion b, entidades_registros_direcciones c, direcciones d, segunda_division_politica e " ;
			sql = sql + "where a.ent_reg_dir_idn = c.ent_reg_dir_idn and c.dir_idn = d.dir_idn and c.dir_activa = 1 and d.seg_div_pol_idn = e.seg_div_pol_idn and a.ent_reg_env_activo = 1 and a.env_doc_idn = b.env_doc_idn and a.ent_reg_idn = "+ ent_reg_idn.trim() + " " ;
			sql = sql + "order by b.env_doc_nombre ASC" ;

			CallableStatement ps = c.prepareCall(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()){

				lista.add(new obj_tres_campos(rs.getString("ent_reg_dir_idn"),
						rs.getString("env_doc_nombre"),
						rs.getString("ent_reg_env_defecto")));
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
	public static ArrayList<obj_cuatro_campos> busca_entidades(String parametro, int tipo_busqueda) {
		ArrayList<obj_cuatro_campos> lista = new ArrayList<obj_cuatro_campos>();
		Connection c=null;
		try {
			String sql;
			c = conexion_odbc.Connexion_datos();
			sql = "select b.ent_reg_idn, a.ent_codigo_pais, case when a.ent_ap_paterno is null then a.ent_nombre else a.ent_nombre + ' ' + a.ent_ap_paterno + ' ' +a.ent_ap_materno end as ent_nombre, c.tip_ent_nombre " ;
			sql = sql + "from entidades a, entidades_registros b, tipo_entidades c ";

			if (tipo_busqueda == 0){
				sql = sql + "where a.ent_activa = 1 and b.ent_reg_activa = 1 and a.ent_idn = b.ent_idn and b.tip_ent_idn = c.tip_ent_idn and a.ent_codigo_pais like '"+parametro.trim()+"%' order by a.ent_codigo_pais ASC";
			}
			if (tipo_busqueda == 1){
				sql = sql + "where a.ent_activa = 1 and b.ent_reg_activa = 1 and a.ent_idn = b.ent_idn and b.tip_ent_idn = c.tip_ent_idn and a.ent_nombre like '"+parametro.trim()+"%' order by a.ent_nombre ASC";
			}
			if (tipo_busqueda == 2){
				sql = sql + "where a.ent_activa = 1 and b.ent_reg_activa = 1 and a.ent_idn = b.ent_idn and b.tip_ent_idn = c.tip_ent_idn and a.ent_ap_paterno like '"+parametro.trim()+"%' order by a.ent_ap_paterno ASC";
			}
			CallableStatement ps = c.prepareCall(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()){

				lista.add(new obj_cuatro_campos(rs.getString("ent_reg_idn"),
						rs.getString("ent_codigo_pais"),
						rs.getString("ent_nombre"),
						rs.getString("tip_ent_nombre")));
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
	/** Creates a new instance of frm_registro_admision_ingreso_inscripcion */
	public frm_registro_admision_ingreso_inscripcion() {
	}

}
