/*
 * frm_conferencias_gestion_conferencias
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
public class frm_conferencias_gestion_conferencias_tutor {

	
	//******************************************************************************************************************************************************    
	public static ArrayList<obj_siete_campos> muestra_conferencias(String func_mod_fun_idn) {
		ArrayList<obj_siete_campos> lista = new ArrayList<obj_siete_campos>();
		Connection c=null;
		try {
			String sql;
			c = conexion_odbc.Connexion_datos();

		//	sql = "select distinct ";
			sql = "select ";
			sql = sql + "a.conf_idn,  ";
			sql = sql + "a.conf_nombre,  ";
			sql = sql + "d.est_conf_nombre,  ";
			sql = sql + "d.est_conf_idn,  ";
			sql = sql + "c.tip_conf_nombre,  ";
			sql = sql + "a.conf_max_capacidad,  ";
			sql = sql + "a.conf_fecha_inicio,  ";
			sql = sql + "a.conf_duracion  ";

			sql = sql + "from conferencia a,  ";
			sql = sql + "tipo_conferencia c,  ";
			sql = sql + "estado_conferencia d,  ";
			sql = sql + "conferencias_funcionarios j ";
			
			sql = sql + "where a.tip_conf_idn = c.tip_conf_idn and  ";
			sql = sql + "a.est_conf_idn = d.est_conf_idn and  ";
			sql = sql + "j.conf_idn = a.conf_idn and ";
			sql = sql + "NOT(Day(a.conf_fecha_inicio) = Day(getdate()) and  ";
			sql = sql + "Month(a.conf_fecha_inicio) = Month(getdate()) and  ";
			sql = sql + "Year(a.conf_fecha_inicio) = Year(getdate())) and  ";
			sql = sql + "a.conf_fecha_inicio >= getdate() and  ";
			sql = sql + "a.est_conf_idn = '1' and  ";
			sql = sql + "j.func_mod_fun_idn = '"+func_mod_fun_idn.trim()+"' ";
			
			sql = sql + "order by d.est_conf_idn, a.conf_fecha_inicio asc";
			
			CallableStatement ps = c.prepareCall(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()){

				lista.add(new obj_siete_campos(rs.getString("conf_idn"),
												rs.getString("conf_nombre"),
												rs.getString("est_conf_nombre"),
												rs.getString("tip_conf_nombre"),
												rs.getString("conf_max_capacidad"),
												rs.getString("conf_fecha_inicio"),
												rs.getString("conf_duracion")));
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
	public static ArrayList<obj_siete_campos> muestra_conferencias_total(String func_mod_fun_idn) {
		ArrayList<obj_siete_campos> lista = new ArrayList<obj_siete_campos>();
		Connection c=null;
		try {
			String sql;
			c = conexion_odbc.Connexion_datos();

			//	sql = "select distinct ";
			sql = "select ";
			sql = sql + "a.conf_idn,  ";
			sql = sql + "a.conf_nombre,  ";
			sql = sql + "d.est_conf_nombre,  ";
			sql = sql + "d.est_conf_idn,  ";
			sql = sql + "c.tip_conf_nombre,  ";
			sql = sql + "a.conf_max_capacidad,  ";
			sql = sql + "a.conf_fecha_inicio,  ";
			sql = sql + "a.conf_duracion  ";

			sql = sql + "from conferencia a,  ";
			sql = sql + "tipo_conferencia c,  ";
			sql = sql + "estado_conferencia d,  ";
			sql = sql + "conferencias_funcionarios j ";
			
			sql = sql + "where a.tip_conf_idn = c.tip_conf_idn and  ";
			sql = sql + "a.est_conf_idn = d.est_conf_idn and  ";
			sql = sql + "j.conf_idn = a.conf_idn and ";
			sql = sql + "j.func_mod_fun_idn = '"+func_mod_fun_idn.trim()+"' ";
			
			sql = sql + "order by d.est_conf_idn, a.conf_fecha_inicio asc";
			
			CallableStatement ps = c.prepareCall(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()){

				lista.add(new obj_siete_campos(rs.getString("conf_idn"),
												rs.getString("conf_nombre"),
												rs.getString("est_conf_nombre"),
												rs.getString("tip_conf_nombre"),
												rs.getString("conf_max_capacidad"),
												rs.getString("conf_fecha_inicio"),
												rs.getString("conf_duracion")));
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
	public static ArrayList<obj_doce_campos> muestra_conferencias_dia(String func_mod_fun_idn) {
		ArrayList<obj_doce_campos> lista = new ArrayList<obj_doce_campos>();
		Connection c=null;
		try {
			String sql;
			c = conexion_odbc.Connexion_datos();

			//	sql = "select distinct ";
			sql = "select ";
			sql = sql + "a.conf_idn,  ";
			sql = sql + "a.conf_nombre,  ";
			sql = sql + "o.cur_nombre,  ";
			sql = sql + "d.est_conf_idn,  ";
			sql = sql + "c.tip_conf_nombre,  ";
			sql = sql + "a.conf_max_capacidad,  ";
			sql = sql + "a.conf_fecha_inicio,  ";
			sql = sql + "CASE WHEN datepart(hour, dateadd(mi, -20 ,a.conf_fecha_inicio)) >9 THEN cast(datepart(hour, dateadd(mi, -20 ,a.conf_fecha_inicio)) as varchar(2)) ELSE '0' + cast(datepart(hour, dateadd(mi, -20 ,a.conf_fecha_inicio)) as varchar(1)) END + ':' + CASE WHEN datepart(minute, dateadd(mi, -20 ,a.conf_fecha_inicio))> 9 THEN cast(datepart(minute, dateadd(mi, -20 ,a.conf_fecha_inicio)) as varchar(2)) ELSE '0' + cast(datepart(minute, dateadd(mi, -20 ,a.conf_fecha_inicio)) as varchar(1)) END as hora_inicio,  ";
			sql = sql + "hor_inicio = CASE WHEN datepart(hour, dateadd(mi, -20 ,a.conf_fecha_inicio)) >9 THEN cast(datepart(hour, dateadd(mi, -20 ,a.conf_fecha_inicio)) as varchar(2)) ELSE '0' + cast(datepart(hour, dateadd(mi, -20 ,a.conf_fecha_inicio)) as varchar(1)) END,  ";
			sql = sql + "min_inicio = CASE WHEN datepart(minute, dateadd(mi, -20 ,a.conf_fecha_inicio))> 9 THEN cast(datepart(minute, dateadd(mi, -20 ,a.conf_fecha_inicio)) as varchar(2)) ELSE '0' + cast(datepart(minute, dateadd(mi, -20 ,a.conf_fecha_inicio)) as varchar(1)) END,  ";
			sql = sql + "CASE WHEN datepart(hour, dateadd(mi, a.conf_duracion ,a.conf_fecha_inicio)) >9 THEN cast(datepart(hour, dateadd(mi, a.conf_duracion ,a.conf_fecha_inicio)) as varchar(2)) ELSE '0' + cast(datepart(hour, dateadd(mi, a.conf_duracion ,a.conf_fecha_inicio)) as varchar(1)) END + ':' + CASE WHEN datepart(minute, dateadd(mi, a.conf_duracion ,a.conf_fecha_inicio)) >9 THEN cast(datepart(minute, dateadd(mi, a.conf_duracion ,a.conf_fecha_inicio)) as varchar(2)) ELSE '0' + cast(datepart(minute, dateadd(mi, a.conf_duracion ,a.conf_fecha_inicio)) as varchar(1)) END as max_inicio,  ";
			sql = sql + "max_hor_inicio = CASE WHEN datepart(hour, dateadd(mi, a.conf_duracion ,a.conf_fecha_inicio)) >9 THEN cast(datepart(hour, dateadd(mi, a.conf_duracion ,a.conf_fecha_inicio)) as varchar(2)) ELSE '0' + cast(datepart(hour, dateadd(mi, a.conf_duracion ,a.conf_fecha_inicio)) as varchar(1)) END, ";
			sql = sql + "max_min_inicio = CASE WHEN datepart(minute, dateadd(mi, a.conf_duracion ,a.conf_fecha_inicio)) >9 THEN cast(datepart(minute, dateadd(mi, a.conf_duracion ,a.conf_fecha_inicio)) as varchar(2)) ELSE '0' + cast(datepart(minute, dateadd(mi, a.conf_duracion ,a.conf_fecha_inicio)) as varchar(1)) END, ";
			sql = sql + "a.conf_duracion  ";

			sql = sql + "from conferencia a,  ";
			sql = sql + "tipo_conferencia c,  ";
			sql = sql + "estado_conferencia d,  ";
			sql = sql + "conferencias_funcionarios j, ";
			sql = sql + "conferencias_ejecuciones_academicas k, ";
			sql = sql + "ejecucion_academica l, ";
			sql = sql + "ejecucion_producto m, ";
			sql = sql + "producto_campus n, ";
			sql = sql + "producto_modalidad o, ";
			sql = sql + "cursos p ";
			
			
			
			
			
			sql = sql + " where a.tip_conf_idn = c.tip_conf_idn and  ";
			
			sql = sql + "a.conf_idn = k.conf_idn and  ";
			sql = sql + "k.eje_aca_idn = l.eje_aca_idn and";
			sql = sql + "l.eje_pro_idn = m.eje_pro_idn and  ";
			sql = sql + "m.pro_cam_idn = n.pro_cam_idn and  ";
			sql = sql + "n.pro_mod_idn = o.pro_mod_idn and  ";
			sql = sql + "o.cur_idn = p.cur_idn and";
			
			
			sql = sql + "a.est_conf_idn = d.est_conf_idn and  ";
			sql = sql + "j.conf_idn = a.conf_idn and ";
			sql = sql + "(Day(a.conf_fecha_inicio) = Day(getdate()) and  ";
			sql = sql + "Month(a.conf_fecha_inicio) = Month(getdate()) and  ";
			sql = sql + "Year(a.conf_fecha_inicio) = Year(getdate())) and  ";
			sql = sql + "getdate() < dateadd(mi,a.conf_duracion, a.conf_fecha_inicio) and  ";
			sql = sql + "a.est_conf_idn = '1' and  ";
			sql = sql + "j.func_mod_fun_idn = '"+func_mod_fun_idn.trim()+"' ";
			
			sql = sql + "order by d.est_conf_idn, a.conf_fecha_inicio asc";
			
			CallableStatement ps = c.prepareCall(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()){

				lista.add(new obj_doce_campos(rs.getString("conf_idn"),
												rs.getString("conf_nombre"),
												rs.getString("est_conf_nombre"),
												rs.getString("tip_conf_nombre"),
												rs.getString("conf_max_capacidad"),
												rs.getString("hora_inicio"),
												rs.getString("hor_inicio"),
												rs.getString("min_inicio"),
												rs.getString("max_inicio"),
												rs.getString("max_hor_inicio"),
												rs.getString("max_min_inicio"),
												rs.getString("conf_duracion")));
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
	public static ArrayList<obj_dos_campos> obtener_hora_servidor() {
		ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
		Connection c=null;
		try {
			String sql;
			c = conexion_odbc.Connexion_datos();

			sql = "select cast(datepart(hour, getdate()) as varchar(2)) as hor_actual,  ";
			sql = sql + "cast(datepart(minute, getdate()) as varchar(2)) as min_actual  ";

			CallableStatement ps = c.prepareCall(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()){

				lista.add(new obj_dos_campos(rs.getString("hor_actual"),
												rs.getString("min_actual")));
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
	public static ArrayList<obj_un_campo_string> buscar_modalidad_campus(String func_mod_fun_idn) {
		ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
		Connection c=null;
		try {
			String sql;
			c = conexion_odbc.Connexion_datos();
			sql = "select b.mod_cam_idn " ;
			sql = sql + "from funcion_modalidad_del_funcionario a, funcion_modalidad b ";
			sql = sql + "where a.func_mod_idn = b.func_mod_idn and a.func_mod_fun_idn = '"+func_mod_fun_idn.trim()+"'";
			
			CallableStatement ps = c.prepareCall(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()){

				lista.add(new obj_un_campo_string(rs.getString("mod_cam_idn")));
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
	public static ArrayList<obj_dos_campos> obtiene_usuario(String func_mod_fun_idn) {
		ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
		Connection c=null;
		try {
			String sql;
			c = conexion_odbc.Connexion_datos();
			sql = "select b.fun_nombre + ' ' + b.fun_ap_paterno as fun_nombre, d.func_nombre " ;
			sql = sql + "from funcion_modalidad_del_funcionario a, funcionarios b, funcion_modalidad c, funcion d ";
			sql = sql + "where a.fun_rut = b.fun_rut and a.func_mod_idn = c.func_mod_idn and c.func_idn = d.func_idn and a.func_mod_fun_idn = '"+func_mod_fun_idn.trim()+"'";
			
			CallableStatement ps = c.prepareCall(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()){

				lista.add(new obj_dos_campos(rs.getString("fun_nombre"),
											rs.getString("func_nombre")));
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
	public static ArrayList<obj_un_campo_string> iniciar_conferencia(String conf_idn) {
		ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
		Connection c=null;
		try {
			String sql;
			c = conexion_odbc.Connexion_datos();
			sql = "update conferencia " ;
			sql = sql + "set est_conf_idn = '2' ";
			sql = sql + "where conf_idn = '"+conf_idn.trim()+"'";
			
			CallableStatement ps = c.prepareCall(sql);
			ps.executeQuery();

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
	public static ArrayList<obj_un_campo_string> finalizar_conferencia(String conf_idn) {
		ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
		Connection c=null;
		try {
			String sql;
			c = conexion_odbc.Connexion_datos();
			sql = "update conferencia " ;
			sql = sql + "set est_conf_idn = '3' ";
			sql = sql + "where conf_idn = '"+conf_idn.trim()+"'";
			
			CallableStatement ps = c.prepareCall(sql);
			ps.executeQuery();

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
	public frm_conferencias_gestion_conferencias_tutor() {
	}

}
