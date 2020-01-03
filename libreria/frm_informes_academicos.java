
package libreria;
import java.util.ArrayList;
import java.sql.*;


public class frm_informes_academicos {
	public frm_informes_academicos() {
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
	
	public static ArrayList<obj_dos_campos> muestra_ejecuciones(String mod_cam_idn) {
		ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
		Connection c=null;
		try {
			String sql;
			c = conexion_odbc.Connexion_datos();
			sql = "select * from ejecucion where mod_cam_idn = '"+mod_cam_idn.trim()+"' order by a.eje_idn desc" ;
			CallableStatement ps = c.prepareCall(sql);
			ResultSet rs = ps.executeQuery();

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
	
	
	
	public static ArrayList<obj_dos_campos> muestra_tipo_prueba() {
		ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
		Connection c=null;
		try {
			String sql;
			c = conexion_odbc.Connexion_datos();
			sql = "select * from tipo_prueba" ;
			CallableStatement ps = c.prepareCall(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()){

				lista.add(new obj_dos_campos(rs.getString("tip_pru_idn"),
						rs.getString("tip_pru_nombre")));
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

	public static ArrayList<obj_un_campo_string> comprueba_matricula(String mat_idn, String func_mod_fun_idn, String usuario_iplacex) {
		ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
		Connection c=null;
		try {
			String sql;
			c = conexion_odbc.Connexion_datos();
			sql = "exec frm_informe_estado_cuenta_comprueba_matricula '"+mat_idn.trim()+"', '"+func_mod_fun_idn.trim()+"','"+usuario_iplacex.trim()+"' " ;
			CallableStatement ps = c.prepareCall(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()){

				lista.add(new obj_un_campo_string(rs.getString("mat_idn")));
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
	
}
