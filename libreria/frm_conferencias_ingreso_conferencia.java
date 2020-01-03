/*
 * frm_conferencias_ingreso_conferencia.java
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
public class frm_conferencias_ingreso_conferencia {

	//******************************************************************************************************************************************************    
	public static ArrayList<obj_dos_campos> muestra_tipo_conferencia() {
		ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
		Connection c=null;
		try {
			String sql;
			c = conexion_odbc.Connexion_datos();
			sql = "select * from tipo_conferencia" ;
			CallableStatement ps = c.prepareCall(sql);
			ResultSet rs = ps.executeQuery();

			lista.add(new obj_dos_campos("0", "-- Seleccione --")); 

			while (rs.next()){

				lista.add(new obj_dos_campos(rs.getString("tip_conf_idn"),
						rs.getString("tip_conf_nombre")));
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
	public static ArrayList<obj_dos_campos> muestra_tipo_jornada() {
		ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
		Connection c=null;
		try {
			String sql;
			c = conexion_odbc.Connexion_datos();
			sql = "select * from tipo_jornada" ;
			CallableStatement ps = c.prepareCall(sql);
			ResultSet rs = ps.executeQuery();

			lista.add(new obj_dos_campos("0", "-- Seleccione --")); 

			while (rs.next()){

				lista.add(new obj_dos_campos(rs.getString("tip_jor_idn"),
						rs.getString("tip_jor_nombre")));
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
	public static ArrayList<obj_dos_campos> muestra_ejecuciones_tutor(String funcionario) {
		ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
		Connection c=null;
		try {
			String sql;
			c = conexion_odbc.Connexion_datos();
			sql = "select * from ejecucion where eje_idn in (";
			sql = sql + "select eje_idn from ejecucion_producto where eje_pro_idn in (";
			sql = sql + "select eje_pro_idn from ejecucion_academica where func_mod_fun_idn = '"+funcionario.trim()+"'))" ;
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
	public static ArrayList<obj_cuatro_campos> busca_ejecuciones_academicas(String eje_idn) {
		ArrayList<obj_cuatro_campos> lista = new ArrayList<obj_cuatro_campos>();
		Connection c=null;
		try {
			String sql;
			c = conexion_odbc.Connexion_datos();
			sql = "select a.eje_aca_idn, g.cur_nombre, h.tip_jor_nombre, d.sec_nombre " ;
			sql = sql + "from ejecucion_academica a,	ejecucion_producto b, seccion d, producto_campus e, producto_modalidad f, cursos g, tipo_jornada h ";
			sql = sql + "where a.eje_pro_idn = b.eje_pro_idn and a.sec_idn = d.sec_idn and b.pro_cam_idn = e.pro_cam_idn and e.pro_mod_idn = f.pro_mod_idn and f.cur_idn = g.cur_idn and a.tip_jor_idn = h.tip_jor_idn and b.eje_idn = '"+eje_idn.trim()+"' ";
			sql = sql + "order by g.cur_nombre, d.sec_nombre, h.tip_jor_nombre ";
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
	public static ArrayList<obj_cuatro_campos> busca_ejecuciones_academicas_tutor(String eje_idn, String funcionario) {
		ArrayList<obj_cuatro_campos> lista = new ArrayList<obj_cuatro_campos>();
		Connection c=null;
		try {
			String sql;
			c = conexion_odbc.Connexion_datos();
			sql = "select a.eje_aca_idn, g.cur_nombre, h.tip_jor_nombre, d.sec_nombre " ;
			sql = sql + "from ejecucion_academica a,	ejecucion_producto b, seccion d, producto_campus e, producto_modalidad f, cursos g, tipo_jornada h ";
			sql = sql + "where a.eje_pro_idn = b.eje_pro_idn and a.sec_idn = d.sec_idn and b.pro_cam_idn = e.pro_cam_idn and e.pro_mod_idn = f.pro_mod_idn and f.cur_idn = g.cur_idn and a.tip_jor_idn = h.tip_jor_idn and a.func_mod_fun_idn = '"+funcionario.trim()+"' and b.eje_idn = '"+eje_idn.trim()+"' ";
			sql = sql + "order by g.cur_nombre, d.sec_nombre, h.tip_jor_nombre ";
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
			sql = sql + "where a.fun_rut = b.fun_rut and b.func_mod_idn = c.func_mod_idn and c.func_idn = d.func_idn and d.tip_fun_idn = e.tip_fun_idn and c.mod_cam_idn = '"+mod_cam_idn.trim()+"' and a.fun_rut = '"+ fun_rut.trim()+"' ";
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
	public static ArrayList<obj_cuatro_campos> busca_funcionarios_funcion(String fun_rut, String mod_cam_idn, String func_idn) {
		ArrayList<obj_cuatro_campos> lista = new ArrayList<obj_cuatro_campos>();
		Connection c=null;
		try {
			String sql;
			c = conexion_odbc.Connexion_datos();
			sql = "select b.func_mod_fun_idn, a.fun_rut, a.fun_nombre +' '+a.fun_ap_paterno+' '+a.fun_ap_materno as fun_nombre, d.func_nombre " ;
			sql = sql + "from funcionarios a, funcion_modalidad_del_funcionario b, funcion_modalidad c, funcion d, tipo_funcion e ";
			sql = sql + "where a.fun_rut = b.fun_rut and b.func_mod_idn = c.func_mod_idn and c.func_idn = '"+func_idn.trim()+"' and c.func_idn = d.func_idn and d.tip_fun_idn = e.tip_fun_idn and c.mod_cam_idn = '"+mod_cam_idn.trim()+"' and a.fun_rut = '"+ fun_rut.trim()+"' ";
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
	public static ArrayList<obj_cuatro_campos> busca_funcionarios_por_apellido(String fun_ap_paterno, String mod_cam_idn) {
		ArrayList<obj_cuatro_campos> lista = new ArrayList<obj_cuatro_campos>();
		Connection c=null;
		try {
			String sql;
			c = conexion_odbc.Connexion_datos();
			sql = "select b.func_mod_fun_idn, a.fun_rut, a.fun_nombre +' '+a.fun_ap_paterno+' '+a.fun_ap_materno as fun_nombre, d.func_nombre " ;
			sql = sql + "from funcionarios a, funcion_modalidad_del_funcionario b, funcion_modalidad c, funcion d, tipo_funcion e ";
			sql = sql + "where a.fun_rut = b.fun_rut and b.func_mod_idn = c.func_mod_idn and c.func_idn = d.func_idn and d.tip_fun_idn = e.tip_fun_idn and c.mod_cam_idn = '"+mod_cam_idn.trim()+"' and lower(a.fun_ap_paterno) like '"+ fun_ap_paterno.toLowerCase().trim()+"%' ";
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
	public static ArrayList<obj_cuatro_campos> busca_funcionarios_por_apellido_funcion(String fun_ap_paterno, String mod_cam_idn, String func_idn) {
		ArrayList<obj_cuatro_campos> lista = new ArrayList<obj_cuatro_campos>();
		Connection c=null;
		try {
			String sql;
			c = conexion_odbc.Connexion_datos();
			sql = "select b.func_mod_fun_idn, a.fun_rut, a.fun_nombre +' '+a.fun_ap_paterno+' '+a.fun_ap_materno as fun_nombre, d.func_nombre " ;
			sql = sql + "from funcionarios a, funcion_modalidad_del_funcionario b, funcion_modalidad c, funcion d, tipo_funcion e ";
			sql = sql + "where a.fun_rut = b.fun_rut and b.func_mod_idn = c.func_mod_idn and c.func_idn = '"+func_idn.trim()+"' and c.func_idn = d.func_idn and d.tip_fun_idn = e.tip_fun_idn and c.mod_cam_idn = '"+mod_cam_idn.trim()+"' and lower(a.fun_ap_paterno) like '"+ fun_ap_paterno.toLowerCase().trim()+"%' ";
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
    public static ArrayList<obj_un_campo> agrega_conferencia 
    (String nombre, 
    String tipo, 
    String integrantes, 
    String fecha_inicio,
    String duracion) {
        ArrayList<obj_un_campo> lista = new ArrayList<obj_un_campo>();
       Connection c=null;
        try {
           String sql;
           c = conexion_odbc.Connexion_datos();
           sql = "insert into conferencia values ('"+nombre.trim()+"', '"+tipo.trim()+"','"+integrantes.trim()+"',getdate(),'"+fecha_inicio.trim()+"',"+duracion.trim()+",'1') ";
           sql = sql + "SELECT SCOPE_IDENTITY() as conf_idn";
           CallableStatement ps = c.prepareCall(sql);
           ResultSet rs = ps.executeQuery();
                       
           while (rs.next())
           {

               lista.add(new obj_un_campo(rs.getString("conf_idn")));
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
    public static ArrayList<?> guarda_conferencia_ejecuciones (ArrayList<?> arreglo_ejecuciones, String conf_idn) {
        ArrayList<?> lista = new ArrayList<Object>();
       Connection c=null;
        try {
           
           
           if (arreglo_ejecuciones.size() > 0)
           {
               int i_asignados;
               int size_asignados = arreglo_ejecuciones.size();
                               
               obj_cuatro_campos reg_asignados = null;
               String sql;
               
               for (i_asignados=0; i_asignados<size_asignados; i_asignados++) 
               {               
                   reg_asignados = (obj_cuatro_campos)arreglo_ejecuciones.get(i_asignados);
                   
                   c = conexion_odbc.Connexion_datos();
                   
                   sql = "insert into conferencias_ejecuciones_academicas values(?,?)" ;
                   CallableStatement ps1 = c.prepareCall(sql);
                   ps1.setString(1, reg_asignados.getcampo_uno().trim());  
                   ps1.setString(2, conf_idn.trim());  
                   ps1.execute();          
               }   
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
    public static ArrayList<?> guarda_conferencia_funcionarios (String fun_codigo, String conf_idn) {
        ArrayList<?> lista = new ArrayList<Object>();
       Connection c=null;
        try {
               String sql;
               c = conexion_odbc.Connexion_datos();
                   
                   sql = "insert into conferencias_funcionarios values(?,?)" ;
                   CallableStatement ps1 = c.prepareCall(sql);
                   ps1.setString(1, fun_codigo.trim());  
                   ps1.setString(2, conf_idn.trim());  
                   ps1.execute();          
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
	public frm_conferencias_ingreso_conferencia() {
	}

}
