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
public class frm_conferencias_gestion_conferencias {

	
	//******************************************************************************************************************************************************    
	public static ArrayList<obj_dos_campos> muestra_ejecuciones() {
		ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
		Connection c=null;
		try {
			String sql;
			c = conexion_odbc.Connexion_datos();
			sql = "select * from ejecucion where eje_activa=1" ;
			CallableStatement ps = c.prepareCall(sql);
			ResultSet rs = ps.executeQuery();

			lista.add(new obj_dos_campos("0", "-- Seleccione --")); 

			while (rs.next()){

				lista.add(new obj_dos_campos(rs.getString("eje_idn"),
						rs.getString("eje_nombre")));
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
	public static ArrayList<obj_cuatro_campos> muestra_cursos(String eje_idn) {
		ArrayList<obj_cuatro_campos> lista = new ArrayList<obj_cuatro_campos>();
		Connection c=null;
		try {
			String sql;
			c = conexion_odbc.Connexion_datos();
			sql = "select a.eje_aca_idn, g.cur_nombre,  h.tip_jor_nombre, d.sec_nombre " ;
			sql = sql + "from ejecucion_academica a,	ejecucion_producto b, seccion d, producto_campus e, producto_modalidad f, cursos g, tipo_jornada h ";
			sql = sql + "where a.eje_pro_idn = b.eje_pro_idn and a.sec_idn = d.sec_idn and b.pro_cam_idn = e.pro_cam_idn and e.pro_mod_idn = f.pro_mod_idn and f.cur_idn = g.cur_idn and a.tip_jor_idn = h.tip_jor_idn and b.eje_idn = '"+eje_idn.trim()+"' ";
			sql = sql + "order by g.cur_nombre,d.sec_nombre, h.tip_jor_nombre  asc ";
			CallableStatement ps = c.prepareCall(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()){

				lista.add(new obj_cuatro_campos(rs.getString("eje_aca_idn"),
												rs.getString("cur_nombre"),
												rs.getString("tip_jor_nombre"),
												rs.getString("sec_nombre")));
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
	public static ArrayList<obj_cuatro_campos> busca_funcionarios(String fun_rut, String mod_cam_idn) {
		ArrayList<obj_cuatro_campos> lista = new ArrayList<obj_cuatro_campos>();
		Connection c=null;
		try {
			String sql;
			c = conexion_odbc.Connexion_datos();
			sql = "select b.func_mod_fun_idn, a.fun_rut, a.fun_nombre +' '+a.fun_ap_paterno+' '+a.fun_ap_materno as fun_nombre, d.func_nombre " ;
			sql = sql + "from funcionarios a, funcion_modalidad_del_funcionario b, funcion_modalidad c, funcion d, tipo_funcion e ";
			sql = sql + "where a.fun_rut = b.fun_rut and b.func_mod_idn = c.func_mod_idn and c.func_idn = d.func_idn and d.tip_fun_idn = e.tip_fun_idn and e.tip_fun_idn = '101' and c.mod_cam_idn = '"+mod_cam_idn.trim()+"' and a.fun_rut = '"+ fun_rut.trim()+"' ";
			sql = sql + "order by fun_nombre, d.func_nombre  ";
			CallableStatement ps = c.prepareCall(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()){

				lista.add(new obj_cuatro_campos(rs.getString("func_mod_fun_idn"),
												rs.getString("fun_rut"),
												rs.getString("fun_nombre"),
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
	public static ArrayList<obj_ocho_campos> muestra_conferencias(String eje_aca_idn) {
		ArrayList<obj_ocho_campos> lista = new ArrayList<obj_ocho_campos>();
		Connection c=null;
		try {
			String sql;
			c = conexion_odbc.Connexion_datos();
			sql = "select a.conf_idn, a.conf_nombre, d.est_conf_nombre, c.tip_conf_nombre, a.conf_max_capacidad, a.conf_fecha_creacion, a.conf_fecha_inicio, a.conf_duracion " ;
			sql = sql + "from conferencia a, conferencias_ejecuciones_academicas b, tipo_conferencia c, estado_conferencia d ";
			sql = sql + "where a.conf_idn = b.conf_idn and a.tip_conf_idn = c.tip_conf_idn and a.est_conf_idn = d.est_conf_idn and b.eje_aca_idn = '"+eje_aca_idn.trim()+"' ";
			sql = sql + "order by a.conf_fecha_inicio  ";
			CallableStatement ps = c.prepareCall(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()){

				lista.add(new obj_ocho_campos(rs.getString("conf_idn"),
												rs.getString("conf_nombre"),
												rs.getString("est_conf_nombre"),
												rs.getString("tip_conf_nombre"),
												rs.getString("conf_max_capacidad"),
												rs.getString("conf_fecha_creacion"),
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
	public static ArrayList<obj_un_campo_string> elimina_conferencia_eje_aca(String conf_idn,String eje_aca_idn) {
		ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
		Connection c=null;
		try {
			String sql;
			c = conexion_odbc.Connexion_datos();
			sql = "delete conferencias_ejecuciones_academicas where eje_aca_idn = '"+eje_aca_idn.trim()+"' and conf_idn = '"+conf_idn.trim()+"' ";

			CallableStatement ps = c.prepareCall(sql);
			ps.execute();

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
	public static ArrayList<obj_un_campo_string> elimina_conferencia(String conf_idn) {
		ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
		Connection c=null;
		try {
			String sql;
			c = conexion_odbc.Connexion_datos();
			sql = "delete conferencias_ejecuciones_academicas where conf_idn = '"+conf_idn.trim()+"' " ;
			sql = sql + "delete conferencias_funcionarios where conf_idn = '"+conf_idn.trim()+"' " ;
			sql = sql + "delete conferencia where conf_idn = '"+conf_idn.trim()+"' " ;
			
			CallableStatement ps = c.prepareCall(sql);
			ps.execute();

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
	public frm_conferencias_gestion_conferencias() {
	}

}
