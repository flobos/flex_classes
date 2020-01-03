
package libreria;
import java.util.ArrayList;
import java.sql.*;


public class frm_informes_matriculas {
	public frm_informes_matriculas() {
    }
	
	
	public static ArrayList<obj_dos_campos> busca_periodos() {
		ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
		Connection c=null;
		try {
			String sql;
			c = conexion_odbc.Connexion_datos();
			sql = "select distinct eje_ano from proceso_reporte_matriculas order by eje_ano desc " ;
			CallableStatement ps = c.prepareCall(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()){

				lista.add(new obj_dos_campos(rs.getString("eje_ano"),
						rs.getString("eje_ano")));
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
	
	public static ArrayList<obj_tres_campos> busca_informes() {
		ArrayList<obj_tres_campos> lista = new ArrayList<obj_tres_campos>();
		Connection c=null;
		try {
			String sql;
			c = conexion_odbc.Connexion_datos();
			sql = "select distinct a.rep_archivo, a.rep_nombre, b.tip_rep_nombre from reportes a, tipo_reportes b where a.rep_visible = 1 and a.tip_rep_idn = b.tip_rep_idn order by b.tip_rep_nombre asc " ;
			CallableStatement ps = c.prepareCall(sql);
			ResultSet rs = ps.executeQuery();
				
			while (rs.next()){

				lista.add(new obj_tres_campos(rs.getString("rep_archivo"),
						rs.getString("rep_nombre"),
						rs.getString("tip_rep_nombre")));
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
