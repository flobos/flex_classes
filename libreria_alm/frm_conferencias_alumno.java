package libreria_alm;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import libreria.conexion_odbc;
import libreria.obj_doce_campos;
import libreria.obj_ocho_campos;
import libreria.obj_siete_campos;


/**
 *
 * @author  cmedina
 */
public class frm_conferencias_alumno {
	public frm_conferencias_alumno() {
	}

	public List getConferencias() throws DAOException {

		List list = new ArrayList();
		Connection c = null;
		String sql;
		try {  
			c = ConnectionHelper.getConnection();
			Statement s = c.createStatement();
			
			sql = "select ";
			sql = sql + "a.conf_idn,  ";
			sql = sql + "a.conf_nombre,  ";
			sql = sql + "d.est_conf_nombre,  ";
			sql = sql + "d.est_conf_idn,  ";
			sql = sql + "c.tip_conf_nombre,  ";
			sql = sql + "a.conf_max_capacidad,  ";
			sql = sql + "a.conf_fecha_inicio,  ";
			sql = sql + "CASE WHEN datepart(hour, dateadd(mi, 0 ,a.conf_fecha_inicio)) >9 THEN cast(datepart(hour, dateadd(mi, 0 ,a.conf_fecha_inicio)) as varchar(2)) ELSE '0' + cast(datepart(hour, dateadd(mi, 0 ,a.conf_fecha_inicio)) as varchar(1)) END + ':' + CASE WHEN datepart(minute, dateadd(mi, 0 ,a.conf_fecha_inicio))> 9 THEN cast(datepart(minute, dateadd(mi, 0 ,a.conf_fecha_inicio)) as varchar(2)) ELSE '0' + cast(datepart(minute, dateadd(mi, 0 ,a.conf_fecha_inicio)) as varchar(1)) END as hora_inicio,  ";
			sql = sql + "hor_inicio = CASE WHEN datepart(hour, dateadd(mi, -20 ,a.conf_fecha_inicio)) >9 THEN cast(datepart(hour, dateadd(mi, -20 ,a.conf_fecha_inicio)) as varchar(2)) ELSE '0' + cast(datepart(hour, dateadd(mi, -20 ,a.conf_fecha_inicio)) as varchar(1)) END,  ";
			sql = sql + "min_inicio = CASE WHEN datepart(minute, dateadd(mi, -20 ,a.conf_fecha_inicio))> 9 THEN cast(datepart(minute, dateadd(mi, -20 ,a.conf_fecha_inicio)) as varchar(2)) ELSE '0' + cast(datepart(minute, dateadd(mi, -20 ,a.conf_fecha_inicio)) as varchar(1)) END,  ";
			sql = sql + "CASE WHEN datepart(hour, dateadd(mi, a.conf_duracion ,a.conf_fecha_inicio)) >9 THEN cast(datepart(hour, dateadd(mi, a.conf_duracion ,a.conf_fecha_inicio)) as varchar(2)) ELSE '0' + cast(datepart(hour, dateadd(mi, a.conf_duracion ,a.conf_fecha_inicio)) as varchar(1)) END + ':' + CASE WHEN datepart(minute, dateadd(mi, a.conf_duracion ,a.conf_fecha_inicio)) >9 THEN cast(datepart(minute, dateadd(mi, a.conf_duracion ,a.conf_fecha_inicio)) as varchar(2)) ELSE '0' + cast(datepart(minute, dateadd(mi, a.conf_duracion ,a.conf_fecha_inicio)) as varchar(1)) END as max_inicio,  ";
			sql = sql + "max_hor_inicio = CASE WHEN datepart(hour, dateadd(mi, a.conf_duracion ,a.conf_fecha_inicio)) >9 THEN cast(datepart(hour, dateadd(mi, a.conf_duracion ,a.conf_fecha_inicio)) as varchar(2)) ELSE '0' + cast(datepart(hour, dateadd(mi, a.conf_duracion ,a.conf_fecha_inicio)) as varchar(1)) END, ";
			sql = sql + "max_min_inicio = CASE WHEN datepart(minute, dateadd(mi, a.conf_duracion ,a.conf_fecha_inicio)) >9 THEN cast(datepart(minute, dateadd(mi, a.conf_duracion ,a.conf_fecha_inicio)) as varchar(2)) ELSE '0' + cast(datepart(minute, dateadd(mi, a.conf_duracion ,a.conf_fecha_inicio)) as varchar(1)) END, ";
			sql = sql + "a.conf_duracion,  ";
			sql = sql + "d.est_conf_nombre  ";
			
			sql = sql + "from conferencia a, ";
			sql = sql + "tipo_conferencia c, ";
			sql = sql + "estado_conferencia d,";
			sql = sql + "toma_cursos e ";
						
			sql = sql + "where a.tip_conf_idn = c.tip_conf_idn and ";  
			sql = sql + "a.est_conf_idn = d.est_conf_idn ";  
			
			sql = sql + "order by d.est_conf_idn, a.conf_fecha_inicio asc";
			
//			sql = "SELECT * FROM conferencia ORDER BY conf_idn";
			ResultSet rs = s.executeQuery(sql);
			while (rs.next()) {
				list.add(new libreria_alm.obj_trece_campos(rs.getString("conf_idn"),
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
						rs.getString("est_conf_idn"),
						rs.getString("est_conf_nombre")));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		} finally {
			ConnectionHelper.close(c);
		}
		return list;

	}
	
	public List getConferenciasTC(String tc_idn) throws DAOException {

		List list = new ArrayList();
		Connection c = null;
		String sql;
		try {  
			c = ConnectionHelper.getConnection();
			Statement s = c.createStatement();
			
			sql = "select ";
			sql = sql + "a.conf_idn,  ";
			sql = sql + "a.conf_nombre,  ";
			sql = sql + "p.cur_nombre,  ";
			sql = sql + "d.est_conf_idn,  ";
			sql = sql + "c.tip_conf_nombre,  ";
			sql = sql + "a.conf_max_capacidad,  ";
			sql = sql + "a.conf_fecha_inicio,  ";
			sql = sql + "CASE WHEN datepart(hour, dateadd(mi, 0 ,a.conf_fecha_inicio)) >9 THEN cast(datepart(hour, dateadd(mi, 0 ,a.conf_fecha_inicio)) as varchar(2)) ELSE '0' + cast(datepart(hour, dateadd(mi, 0 ,a.conf_fecha_inicio)) as varchar(1)) END + ':' + CASE WHEN datepart(minute, dateadd(mi, 0 ,a.conf_fecha_inicio))> 9 THEN cast(datepart(minute, dateadd(mi, 0 ,a.conf_fecha_inicio)) as varchar(2)) ELSE '0' + cast(datepart(minute, dateadd(mi, 0 ,a.conf_fecha_inicio)) as varchar(1)) END as hora_inicio,  ";
			sql = sql + "hor_inicio = CASE WHEN datepart(hour, dateadd(mi, -20 ,a.conf_fecha_inicio)) >9 THEN cast(datepart(hour, dateadd(mi, -20 ,a.conf_fecha_inicio)) as varchar(2)) ELSE '0' + cast(datepart(hour, dateadd(mi, -20 ,a.conf_fecha_inicio)) as varchar(1)) END,  ";
			sql = sql + "min_inicio = CASE WHEN datepart(minute, dateadd(mi, -20 ,a.conf_fecha_inicio))> 9 THEN cast(datepart(minute, dateadd(mi, -20 ,a.conf_fecha_inicio)) as varchar(2)) ELSE '0' + cast(datepart(minute, dateadd(mi, -20 ,a.conf_fecha_inicio)) as varchar(1)) END,  ";
			sql = sql + "CASE WHEN datepart(hour, dateadd(mi, a.conf_duracion ,a.conf_fecha_inicio)) >9 THEN cast(datepart(hour, dateadd(mi, a.conf_duracion ,a.conf_fecha_inicio)) as varchar(2)) ELSE '0' + cast(datepart(hour, dateadd(mi, a.conf_duracion ,a.conf_fecha_inicio)) as varchar(1)) END + ':' + CASE WHEN datepart(minute, dateadd(mi, a.conf_duracion ,a.conf_fecha_inicio)) >9 THEN cast(datepart(minute, dateadd(mi, a.conf_duracion ,a.conf_fecha_inicio)) as varchar(2)) ELSE '0' + cast(datepart(minute, dateadd(mi, a.conf_duracion ,a.conf_fecha_inicio)) as varchar(1)) END as max_inicio,  ";
			sql = sql + "max_hor_inicio = CASE WHEN datepart(hour, dateadd(mi, a.conf_duracion ,a.conf_fecha_inicio)) >9 THEN cast(datepart(hour, dateadd(mi, a.conf_duracion ,a.conf_fecha_inicio)) as varchar(2)) ELSE '0' + cast(datepart(hour, dateadd(mi, a.conf_duracion ,a.conf_fecha_inicio)) as varchar(1)) END, ";
			sql = sql + "max_min_inicio = CASE WHEN datepart(minute, dateadd(mi, a.conf_duracion ,a.conf_fecha_inicio)) >9 THEN cast(datepart(minute, dateadd(mi, a.conf_duracion ,a.conf_fecha_inicio)) as varchar(2)) ELSE '0' + cast(datepart(minute, dateadd(mi, a.conf_duracion ,a.conf_fecha_inicio)) as varchar(1)) END, ";
			sql = sql + "a.conf_duracion,  ";
			sql = sql + "d.est_conf_nombre  ";
			
			sql = sql + "from conferencia a, ";
			sql = sql + "conferencias_ejecuciones_academicas b,";
			sql = sql + "tipo_conferencia c, ";
			sql = sql + "estado_conferencia d,";
			sql = sql + "toma_cursos e, ";
			
			
			sql = sql + "ejecucion_academica l, ";
			sql = sql + "ejecucion_producto m, ";
			sql = sql + "producto_campus n, ";
			sql = sql + "producto_modalidad o, ";
			sql = sql + "cursos p ";
						
			sql = sql + "where a.tip_conf_idn = c.tip_conf_idn and ";  
			sql = sql + "a.est_conf_idn = d.est_conf_idn and ";  
			sql = sql + "b.conf_idn = a.conf_idn and "; 
			sql = sql + "b.eje_aca_idn = e.eje_aca_idn and ";
			
			sql = sql + "b.eje_aca_idn = l.eje_aca_idn and ";
			sql = sql + "l.eje_pro_idn = m.eje_pro_idn and  ";
			sql = sql + "m.pro_cam_idn = n.pro_cam_idn and  ";
			sql = sql + "n.pro_mod_idn = o.pro_mod_idn and  ";
			sql = sql + "o.cur_idn = p.cur_idn and ";
			
			sql = sql + "a.est_conf_idn = '2' and  ";
			sql = sql + "e.tc_idn = '"+tc_idn.trim()+"' ";
			System.out.println("\n\n"+tc_idn.trim()+"\n\n");
			
			sql = sql + "order by d.est_conf_idn, a.conf_fecha_inicio asc";
			
//			sql = "SELECT * FROM conferencia ORDER BY conf_idn";
			ResultSet rs = s.executeQuery(sql);
			while (rs.next()) {
				list.add(new libreria_alm.obj_trece_campos(rs.getString("conf_idn"),
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
						rs.getString("est_conf_idn"),
						rs.getString("tip_conf_nombre")));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		} finally {
			ConnectionHelper.close(c);
		}
		return list;

	}
	
	public List getConferenciasPARAM(String tipo, String param) throws DAOException {
		
		System.out.println("\n\n"+tipo.trim()+"\n\n");
		List list = new ArrayList();
		Connection c = null;
		String sql="";
		try {  
			c = ConnectionHelper.getConnection();
			Statement s = c.createStatement();
			if (tipo.trim().equals("by_tc_dia"))
			{
				sql = "select ";
				sql = sql + "a.conf_idn,  ";
				sql = sql + "a.conf_nombre,  ";
				sql = sql + "p.cur_nombre + '-'+ q.sec_nombre as cur_nombre,  ";
				sql = sql + "d.est_conf_idn,  ";
				sql = sql + "c.tip_conf_nombre,  ";
				sql = sql + "a.conf_max_capacidad,  ";
				sql = sql + "a.conf_fecha_inicio,  ";
				sql = sql + "CASE WHEN datepart(hour, dateadd(mi, 0 ,a.conf_fecha_inicio)) >9 THEN cast(datepart(hour, dateadd(mi, 0 ,a.conf_fecha_inicio)) as varchar(2)) ELSE '0' + cast(datepart(hour, dateadd(mi, 0 ,a.conf_fecha_inicio)) as varchar(1)) END + ':' + CASE WHEN datepart(minute, dateadd(mi, 0 ,a.conf_fecha_inicio))> 9 THEN cast(datepart(minute, dateadd(mi, 0 ,a.conf_fecha_inicio)) as varchar(2)) ELSE '0' + cast(datepart(minute, dateadd(mi, 0 ,a.conf_fecha_inicio)) as varchar(1)) END as hora_inicio,  ";
				sql = sql + "hor_inicio = CASE WHEN datepart(hour, dateadd(mi, -20 ,a.conf_fecha_inicio)) >9 THEN cast(datepart(hour, dateadd(mi, -20 ,a.conf_fecha_inicio)) as varchar(2)) ELSE '0' + cast(datepart(hour, dateadd(mi, -20 ,a.conf_fecha_inicio)) as varchar(1)) END,  ";
				sql = sql + "min_inicio = CASE WHEN datepart(minute, dateadd(mi, -20 ,a.conf_fecha_inicio))> 9 THEN cast(datepart(minute, dateadd(mi, -20 ,a.conf_fecha_inicio)) as varchar(2)) ELSE '0' + cast(datepart(minute, dateadd(mi, -20 ,a.conf_fecha_inicio)) as varchar(1)) END,  ";
				sql = sql + "CASE WHEN datepart(hour, dateadd(mi, a.conf_duracion ,a.conf_fecha_inicio)) >9 THEN cast(datepart(hour, dateadd(mi, a.conf_duracion ,a.conf_fecha_inicio)) as varchar(2)) ELSE '0' + cast(datepart(hour, dateadd(mi, a.conf_duracion ,a.conf_fecha_inicio)) as varchar(1)) END + ':' + CASE WHEN datepart(minute, dateadd(mi, a.conf_duracion ,a.conf_fecha_inicio)) >9 THEN cast(datepart(minute, dateadd(mi, a.conf_duracion ,a.conf_fecha_inicio)) as varchar(2)) ELSE '0' + cast(datepart(minute, dateadd(mi, a.conf_duracion ,a.conf_fecha_inicio)) as varchar(1)) END as max_inicio,  ";
				sql = sql + "max_hor_inicio = CASE WHEN datepart(hour, dateadd(mi, a.conf_duracion ,a.conf_fecha_inicio)) >9 THEN cast(datepart(hour, dateadd(mi, a.conf_duracion ,a.conf_fecha_inicio)) as varchar(2)) ELSE '0' + cast(datepart(hour, dateadd(mi, a.conf_duracion ,a.conf_fecha_inicio)) as varchar(1)) END, ";
				sql = sql + "max_min_inicio = CASE WHEN datepart(minute, dateadd(mi, a.conf_duracion ,a.conf_fecha_inicio)) >9 THEN cast(datepart(minute, dateadd(mi, a.conf_duracion ,a.conf_fecha_inicio)) as varchar(2)) ELSE '0' + cast(datepart(minute, dateadd(mi, a.conf_duracion ,a.conf_fecha_inicio)) as varchar(1)) END, ";
				sql = sql + "a.conf_duracion,  ";
				sql = sql + "d.est_conf_nombre  ";
				
				sql = sql + "from conferencia a, ";
				sql = sql + "conferencias_ejecuciones_academicas b,";
				sql = sql + "tipo_conferencia c, ";
				sql = sql + "estado_conferencia d,";
				sql = sql + "toma_cursos e, ";
				sql = sql + "ejecucion_academica l, ";
				sql = sql + "ejecucion_producto m, ";
				sql = sql + "producto_campus n, ";
				sql = sql + "producto_modalidad o, ";
				sql = sql + "cursos p, ";
				sql = sql + "seccion q ";
							
				sql = sql + "where a.tip_conf_idn = c.tip_conf_idn and ";  
				
				sql = sql + "a.conf_idn = b.conf_idn and  ";
				sql = sql + "b.eje_aca_idn = l.eje_aca_idn and ";
				sql = sql + "l.eje_pro_idn = m.eje_pro_idn and  ";
				sql = sql + "m.pro_cam_idn = n.pro_cam_idn and  ";
				sql = sql + "n.pro_mod_idn = o.pro_mod_idn and  ";
				sql = sql + "o.cur_idn = p.cur_idn and ";
				sql = sql + "l.sec_idn = q.sec_idn and ";
				
				
				sql = sql + "a.est_conf_idn = d.est_conf_idn and ";  
				sql = sql + "b.conf_idn = a.conf_idn and "; 
				sql = sql + "b.eje_aca_idn = e.eje_aca_idn and ";
				sql = sql + "a.est_conf_idn = '2' and  ";
				sql = sql + "e.tc_idn = '"+param.trim()+"' ";
			}
			
			if (tipo.trim().equals("by_tc_nd"))
			{
				sql = "select ";
				sql = sql + "a.conf_idn,  ";
				sql = sql + "a.conf_nombre,  ";
				sql = sql + "p.cur_nombre + '-'+ q.sec_nombre as cur_nombre,  ";
				sql = sql + "d.est_conf_idn,  ";
				sql = sql + "c.tip_conf_nombre,  ";
				sql = sql + "a.conf_max_capacidad,  ";
				sql = sql + "a.conf_fecha_inicio,  ";
				sql = sql + "a.conf_fecha_inicio as hora_inicio,  ";
				sql = sql + "hor_inicio = CASE WHEN datepart(hour, dateadd(mi, -20 ,a.conf_fecha_inicio)) >9 THEN cast(datepart(hour, dateadd(mi, -20 ,a.conf_fecha_inicio)) as varchar(2)) ELSE '0' + cast(datepart(hour, dateadd(mi, -20 ,a.conf_fecha_inicio)) as varchar(1)) END,  ";
				sql = sql + "min_inicio = CASE WHEN datepart(minute, dateadd(mi, -20 ,a.conf_fecha_inicio))> 9 THEN cast(datepart(minute, dateadd(mi, -20 ,a.conf_fecha_inicio)) as varchar(2)) ELSE '0' + cast(datepart(minute, dateadd(mi, -20 ,a.conf_fecha_inicio)) as varchar(1)) END,  ";
				sql = sql + "CASE WHEN datepart(hour, dateadd(mi, a.conf_duracion ,a.conf_fecha_inicio)) >9 THEN cast(datepart(hour, dateadd(mi, a.conf_duracion ,a.conf_fecha_inicio)) as varchar(2)) ELSE '0' + cast(datepart(hour, dateadd(mi, a.conf_duracion ,a.conf_fecha_inicio)) as varchar(1)) END + ':' + CASE WHEN datepart(minute, dateadd(mi, a.conf_duracion ,a.conf_fecha_inicio)) >9 THEN cast(datepart(minute, dateadd(mi, a.conf_duracion ,a.conf_fecha_inicio)) as varchar(2)) ELSE '0' + cast(datepart(minute, dateadd(mi, a.conf_duracion ,a.conf_fecha_inicio)) as varchar(1)) END as max_inicio,  ";
				sql = sql + "max_hor_inicio = CASE WHEN datepart(hour, dateadd(mi, a.conf_duracion ,a.conf_fecha_inicio)) >9 THEN cast(datepart(hour, dateadd(mi, a.conf_duracion ,a.conf_fecha_inicio)) as varchar(2)) ELSE '0' + cast(datepart(hour, dateadd(mi, a.conf_duracion ,a.conf_fecha_inicio)) as varchar(1)) END, ";
				sql = sql + "max_min_inicio = CASE WHEN datepart(minute, dateadd(mi, a.conf_duracion ,a.conf_fecha_inicio)) >9 THEN cast(datepart(minute, dateadd(mi, a.conf_duracion ,a.conf_fecha_inicio)) as varchar(2)) ELSE '0' + cast(datepart(minute, dateadd(mi, a.conf_duracion ,a.conf_fecha_inicio)) as varchar(1)) END, ";
				sql = sql + "a.conf_duracion,  ";
				sql = sql + "d.est_conf_nombre  ";
				
				sql = sql + "from conferencia a, ";
				sql = sql + "conferencias_ejecuciones_academicas b,";
				sql = sql + "tipo_conferencia c, ";
				sql = sql + "estado_conferencia d,";
				sql = sql + "toma_cursos e, ";
				sql = sql + "ejecucion_academica l, ";
				sql = sql + "ejecucion_producto m, ";
				sql = sql + "producto_campus n, ";
				sql = sql + "producto_modalidad o, ";
				sql = sql + "cursos p, ";
				sql = sql + "seccion q ";
							
				sql = sql + "where a.tip_conf_idn = c.tip_conf_idn and ";  
				
				sql = sql + "a.conf_idn = b.conf_idn and  ";
				sql = sql + "b.eje_aca_idn = l.eje_aca_idn and ";
				sql = sql + "l.eje_pro_idn = m.eje_pro_idn and  ";
				sql = sql + "m.pro_cam_idn = n.pro_cam_idn and  ";
				sql = sql + "n.pro_mod_idn = o.pro_mod_idn and  ";
				sql = sql + "o.cur_idn = p.cur_idn and ";
				sql = sql + "l.sec_idn = q.sec_idn and ";
				
				
				
				sql = sql + "a.est_conf_idn = d.est_conf_idn and ";  
				sql = sql + "b.conf_idn = a.conf_idn and "; 
				sql = sql + "b.eje_aca_idn = e.eje_aca_idn and ";
				sql = sql + "a.est_conf_idn <> '2' and  ";
				sql = sql + "a.est_conf_idn <> '3' and  ";
				sql = sql + "e.tc_idn = '"+param.trim()+"' ";
			}
			if (tipo.trim().equals("by_tc_dif"))
			{
				sql = "select ";
				sql = sql + "a.conf_idn,  ";
				sql = sql + "a.conf_nombre,  ";
				sql = sql + "p.cur_nombre + '-'+ q.sec_nombre as cur_nombre,  ";
				sql = sql + "d.est_conf_idn,  ";
				sql = sql + "c.tip_conf_nombre,  ";
				sql = sql + "a.conf_max_capacidad,  ";
				sql = sql + "a.conf_fecha_inicio,  ";
				sql = sql + "a.conf_fecha_inicio as hora_inicio,  ";
				sql = sql + "hor_inicio = CASE WHEN datepart(hour, dateadd(mi, -20 ,a.conf_fecha_inicio)) >9 THEN cast(datepart(hour, dateadd(mi, -20 ,a.conf_fecha_inicio)) as varchar(2)) ELSE '0' + cast(datepart(hour, dateadd(mi, -20 ,a.conf_fecha_inicio)) as varchar(1)) END,  ";
				sql = sql + "min_inicio = CASE WHEN datepart(minute, dateadd(mi, -20 ,a.conf_fecha_inicio))> 9 THEN cast(datepart(minute, dateadd(mi, -20 ,a.conf_fecha_inicio)) as varchar(2)) ELSE '0' + cast(datepart(minute, dateadd(mi, -20 ,a.conf_fecha_inicio)) as varchar(1)) END,  ";
				sql = sql + "CASE WHEN datepart(hour, dateadd(mi, a.conf_duracion ,a.conf_fecha_inicio)) >9 THEN cast(datepart(hour, dateadd(mi, a.conf_duracion ,a.conf_fecha_inicio)) as varchar(2)) ELSE '0' + cast(datepart(hour, dateadd(mi, a.conf_duracion ,a.conf_fecha_inicio)) as varchar(1)) END + ':' + CASE WHEN datepart(minute, dateadd(mi, a.conf_duracion ,a.conf_fecha_inicio)) >9 THEN cast(datepart(minute, dateadd(mi, a.conf_duracion ,a.conf_fecha_inicio)) as varchar(2)) ELSE '0' + cast(datepart(minute, dateadd(mi, a.conf_duracion ,a.conf_fecha_inicio)) as varchar(1)) END as max_inicio,  ";
				sql = sql + "max_hor_inicio = CASE WHEN datepart(hour, dateadd(mi, a.conf_duracion ,a.conf_fecha_inicio)) >9 THEN cast(datepart(hour, dateadd(mi, a.conf_duracion ,a.conf_fecha_inicio)) as varchar(2)) ELSE '0' + cast(datepart(hour, dateadd(mi, a.conf_duracion ,a.conf_fecha_inicio)) as varchar(1)) END, ";
				sql = sql + "max_min_inicio = CASE WHEN datepart(minute, dateadd(mi, a.conf_duracion ,a.conf_fecha_inicio)) >9 THEN cast(datepart(minute, dateadd(mi, a.conf_duracion ,a.conf_fecha_inicio)) as varchar(2)) ELSE '0' + cast(datepart(minute, dateadd(mi, a.conf_duracion ,a.conf_fecha_inicio)) as varchar(1)) END, ";
				sql = sql + "a.conf_duracion,  ";
				sql = sql + "d.est_conf_nombre  ";
				
				sql = sql + "from conferencia a, ";
				sql = sql + "conferencias_ejecuciones_academicas b,";
				sql = sql + "tipo_conferencia c, ";
				sql = sql + "estado_conferencia d,";
				sql = sql + "toma_cursos e, ";
				sql = sql + "ejecucion_academica l, ";
				sql = sql + "ejecucion_producto m, ";
				sql = sql + "producto_campus n, ";
				sql = sql + "producto_modalidad o, ";
				sql = sql + "cursos p, ";
				sql = sql + "seccion q ";
							
				sql = sql + "where a.tip_conf_idn = c.tip_conf_idn and "; 
				
				sql = sql + "a.conf_idn = b.conf_idn and  ";
				sql = sql + "b.eje_aca_idn = l.eje_aca_idn and ";
				sql = sql + "l.eje_pro_idn = m.eje_pro_idn and  ";
				sql = sql + "m.pro_cam_idn = n.pro_cam_idn and  ";
				sql = sql + "n.pro_mod_idn = o.pro_mod_idn and  ";
				sql = sql + "o.cur_idn = p.cur_idn and ";
				sql = sql + "l.sec_idn = q.sec_idn and ";
				
				
				
				sql = sql + "a.est_conf_idn = d.est_conf_idn and ";  
				sql = sql + "b.conf_idn = a.conf_idn and "; 
				sql = sql + "b.eje_aca_idn = e.eje_aca_idn and ";
				sql = sql + "a.est_conf_idn = '3' and  ";
				sql = sql + "e.tc_idn = '"+param.trim()+"' ";
			}
			
			if (tipo.trim().equals("by_func_dia"))
			{
				sql = "select ";
				sql = sql + "a.conf_idn,  ";
				sql = sql + "a.conf_nombre,  ";
				sql = sql + "p.cur_nombre + '-'+ q.sec_nombre as cur_nombre,  ";
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
				sql = sql + "a.conf_duracion,  ";
				sql = sql + "d.est_conf_nombre  ";

				sql = sql + "from conferencia a,  ";
				sql = sql + "tipo_conferencia c,  ";
				sql = sql + "estado_conferencia d,  ";
				sql = sql + "conferencias_funcionarios j, ";
				sql = sql + "conferencias_ejecuciones_academicas k, ";
				sql = sql + "ejecucion_academica l, ";
				sql = sql + "ejecucion_producto m, ";
				sql = sql + "producto_campus n, ";
				sql = sql + "producto_modalidad o, ";
				sql = sql + "cursos p, ";
				sql = sql + "seccion q ";
				
				
				
				
				sql = sql + " where a.tip_conf_idn = c.tip_conf_idn and  ";
				
				sql = sql + "a.conf_idn = k.conf_idn and  ";
				sql = sql + "k.eje_aca_idn = l.eje_aca_idn and ";
				sql = sql + "l.eje_pro_idn = m.eje_pro_idn and  ";
				sql = sql + "m.pro_cam_idn = n.pro_cam_idn and  ";
				sql = sql + "n.pro_mod_idn = o.pro_mod_idn and  ";
				sql = sql + "o.cur_idn = p.cur_idn and ";
				sql = sql + "l.sec_idn = q.sec_idn and ";
				
				sql = sql + "a.est_conf_idn = d.est_conf_idn and  ";
				sql = sql + "j.conf_idn = a.conf_idn and ";
				sql = sql + "(Day(a.conf_fecha_inicio) = Day(getdate()) and  ";
				sql = sql + "Month(a.conf_fecha_inicio) = Month(getdate()) and  ";
				sql = sql + "Year(a.conf_fecha_inicio) = Year(getdate())) and  ";
				sql = sql + "getdate() < dateadd(mi,a.conf_duracion, a.conf_fecha_inicio) and  ";
				sql = sql + "a.est_conf_idn = '1' and  ";
				sql = sql + "j.func_mod_fun_idn = '"+param.trim()+"' ";
				
				sql = sql + "order by d.est_conf_idn, a.conf_fecha_inicio asc";
			}
			
			if (tipo.trim().equals("by_func_activas"))
			{
				sql = "select ";
				sql = sql + "a.conf_idn,  ";
				sql = sql + "a.conf_nombre,  ";
				sql = sql + "p.cur_nombre + '-'+ q.sec_nombre as cur_nombre,  ";
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
				sql = sql + "a.conf_duracion,  ";
				sql = sql + "d.est_conf_nombre  ";

				sql = sql + "from conferencia a,  ";
				sql = sql + "tipo_conferencia c,  ";
				sql = sql + "estado_conferencia d,  ";
				sql = sql + "conferencias_funcionarios j, ";
				sql = sql + "conferencias_ejecuciones_academicas k, ";
				sql = sql + "ejecucion_academica l, ";
				sql = sql + "ejecucion_producto m, ";
				sql = sql + "producto_campus n, ";
				sql = sql + "producto_modalidad o, ";
				sql = sql + "cursos p, ";
				sql = sql + "seccion q ";
				
				sql = sql + " where a.tip_conf_idn = c.tip_conf_idn and  ";
				
				sql = sql + "a.conf_idn = k.conf_idn and  ";
				sql = sql + "k.eje_aca_idn = l.eje_aca_idn and ";
				sql = sql + "l.eje_pro_idn = m.eje_pro_idn and  ";
				sql = sql + "m.pro_cam_idn = n.pro_cam_idn and  ";
				sql = sql + "n.pro_mod_idn = o.pro_mod_idn and  ";
				sql = sql + "o.cur_idn = p.cur_idn and ";
				sql = sql + "l.sec_idn = q.sec_idn and ";
				
				sql = sql + "a.est_conf_idn = d.est_conf_idn and  ";
				sql = sql + "j.conf_idn = a.conf_idn and ";
				sql = sql + "a.est_conf_idn = '2' and  ";
				sql = sql + "j.func_mod_fun_idn = '"+param.trim()+"' ";
				
				sql = sql + "order by d.est_conf_idn, a.conf_fecha_inicio asc";
			}
			
			if (tipo.trim().equals("by_func_futuras"))
			{
				sql = "select ";
				sql = sql + "a.conf_idn,  ";
				sql = sql + "a.conf_nombre,  ";
				sql = sql + "p.cur_nombre + '-'+ q.sec_nombre as cur_nombre,  ";
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
				sql = sql + "a.conf_duracion,  ";
				sql = sql + "d.est_conf_nombre  ";

				sql = sql + "from conferencia a,  ";
				sql = sql + "tipo_conferencia c,  ";
				sql = sql + "estado_conferencia d,  ";
				sql = sql + "conferencias_funcionarios j, ";
				sql = sql + "conferencias_ejecuciones_academicas k, ";
				sql = sql + "ejecucion_academica l, ";
				sql = sql + "ejecucion_producto m, ";
				sql = sql + "producto_campus n, ";
				sql = sql + "producto_modalidad o, ";
				sql = sql + "cursos p, ";
				sql = sql + "seccion q ";
				
				sql = sql + " where a.tip_conf_idn = c.tip_conf_idn and  ";
				
				sql = sql + "a.conf_idn = k.conf_idn and  ";
				sql = sql + "k.eje_aca_idn = l.eje_aca_idn and ";
				sql = sql + "l.eje_pro_idn = m.eje_pro_idn and  ";
				sql = sql + "m.pro_cam_idn = n.pro_cam_idn and  ";
				sql = sql + "n.pro_mod_idn = o.pro_mod_idn and  ";
				sql = sql + "o.cur_idn = p.cur_idn and ";
				sql = sql + "l.sec_idn = q.sec_idn and ";
				
				
				sql = sql + "a.est_conf_idn = d.est_conf_idn and  ";
				sql = sql + "j.conf_idn = a.conf_idn and ";
				sql = sql + "NOT(Day(a.conf_fecha_inicio) = Day(getdate()) and  ";
				sql = sql + "Month(a.conf_fecha_inicio) = Month(getdate()) and  ";
				sql = sql + "Year(a.conf_fecha_inicio) = Year(getdate())) and  ";
				sql = sql + "a.conf_fecha_inicio >= getdate() and  ";
				sql = sql + "a.est_conf_idn = '1' and  ";
				sql = sql + "j.func_mod_fun_idn = '"+param.trim()+"' ";
				
				sql = sql + "order by d.est_conf_idn, a.conf_fecha_inicio asc";
			}
			
//			sql = "SELECT * FROM conferencia ORDER BY conf_idn";
			ResultSet rs = s.executeQuery(sql);
			while (rs.next()) {
				list.add(new libreria_alm.obj_trece_campos(
						rs.getString("conf_idn"),
						rs.getString("conf_nombre"),
						rs.getString("cur_nombre"),
						rs.getString("tip_conf_nombre"),
						rs.getString("conf_max_capacidad"),
						rs.getString("hora_inicio"),
						rs.getString("hor_inicio"),
						rs.getString("min_inicio"),
						rs.getString("max_inicio"),
						rs.getString("max_hor_inicio"),
						rs.getString("max_min_inicio"),
						rs.getString("est_conf_idn"),
						rs.getString("est_conf_nombre")));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		} finally {
			ConnectionHelper.close(c);
		}
		return list;

	}
	
	
	public libreria_alm.obj_trece_campos getConferencia(String conf_idn) throws DAOException {
		libreria_alm.obj_trece_campos conf = new libreria_alm.obj_trece_campos();
		Connection c = null;
		try {
			c = ConnectionHelper.getConnection();
			Statement s = c.createStatement();
			String sql;
			sql = "select ";
			sql = sql + "a.conf_idn,  ";
			sql = sql + "a.conf_nombre,  ";
			sql = sql + "d.est_conf_nombre,  ";
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
			sql = sql + "a.conf_duracion,  ";
			sql = sql + "d.est_conf_nombre  ";

			sql = sql + "from conferencia a,  ";
			sql = sql + "tipo_conferencia c,  ";
			sql = sql + "estado_conferencia d  ";
			
			sql = sql + " where a.tip_conf_idn = c.tip_conf_idn and  ";
			sql = sql + "a.est_conf_idn = d.est_conf_idn and  ";
			sql = sql + "a.conf_idn = '"+conf_idn.trim()+"' ";
			
			sql = sql + "order by d.est_conf_idn, a.conf_fecha_inicio asc";
			
			ResultSet rs = s.executeQuery(sql);
			if (rs.next()) {
				
				conf = new libreria_alm.obj_trece_campos();
				conf.setcampo_uno(rs.getString("conf_idn"));
				conf.setcampo_dos(rs.getString("conf_nombre"));
				conf.setcampo_tres(rs.getString("est_conf_nombre"));
				conf.setcampo_cuatro(rs.getString("tip_conf_nombre"));
				conf.setcampo_cinco(rs.getString("conf_max_capacidad"));
				conf.setcampo_seis(rs.getString("hora_inicio"));
				conf.setcampo_siete(rs.getString("hor_inicio"));
				conf.setcampo_ocho(rs.getString("min_inicio"));
				conf.setcampo_nueve(rs.getString("max_inicio"));
				conf.setcampo_diez(rs.getString("max_hor_inicio"));
				conf.setcampo_once(rs.getString("max_min_inicio"));
				conf.setcampo_doce(rs.getString("est_conf_idn"));
				conf.setcampo_trece(rs.getString("est_conf_nombre"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		} finally {
			ConnectionHelper.close(c);
		}
		return conf;
	}
	
	
	
public libreria_alm.obj_trece_campos create(libreria_alm.obj_trece_campos item) throws DAOException {
		
		Connection c = null;
		PreparedStatement ps = null;
		try {
			c = ConnectionHelper.getConnection();
			ps = c.prepareStatement("INSERT INTO conferencia (conf_nombre, tip_conf_idn, conf_max_capacidad, conf_fecha_creacion, conf_fecha_inicio,conf_duracion,est_conf_idn) VALUES (?, ?, ?, ?, ?, ?,?)");
			ps.setString(1, item.getcampo_dos());
			ps.setString(2, item.getcampo_tres());
			ps.setString(3, item.getcampo_cuatro());
			ps.setString(4, item.getcampo_cinco());
			ps.setString(5, item.getcampo_seis());
			ps.setString(6, item.getcampo_siete());
			ps.setString(7, item.getcampo_ocho());
			ps.executeUpdate();
			Statement s = c.createStatement();
			// HSQLDB Syntax to get the identity (company_id) of inserted row
			//ResultSet rs = s.executeQuery("CALL IDENTITY()");
			// MySQL Syntax to get the identity (product_id) of inserted row
			ResultSet rs = s.executeQuery("SELECT SCOPE_IDENTITY() as conf_idn");
			rs.next();
            // Update the id in the returned object. This is important as this value must get returned to the client.
			item.setcampo_uno(rs.getString(1));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException(e);
		} finally {
			ConnectionHelper.close(c);
		}
		return item;
	}

	
	public boolean update(libreria_alm.obj_trece_campos newVersion, libreria_alm.obj_trece_campos prevVersion, List changes) throws DAOException {
		System.out.println("\n\n update!!!  \n\n");
		Connection c = null;

		try {
			c = ConnectionHelper.getConnection();
			PreparedStatement ps = c.prepareStatement("UPDATE conferencia SET conf_nombre=?, conf_max_capacidad=?, est_conf_idn=?  WHERE conf_idn=?");
			ps.setString(1, newVersion.getcampo_dos());
			ps.setString(2, newVersion.getcampo_cinco());
			ps.setString(3, newVersion.getcampo_doce());
			ps.setString(4, newVersion.getcampo_uno());
			
			return (ps.executeUpdate() == 1);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException(e);
		} finally {
			ConnectionHelper.close(c);
		}

	}

	
	public boolean delete(libreria_alm.obj_ocho_campos conferencia) throws DAOException {
		
		Connection c = null;
		
		try {
			c = ConnectionHelper.getConnection();
			Statement stmt = c. createStatement();
			int count = stmt.executeUpdate("DELETE FROM conferencia WHERE conf_idn='"+conferencia.getcampo_uno()+"'");
			return (count == 1);
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException(e);
		} finally {
			ConnectionHelper.close(c);
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//******************************************************************************************************************************************************    
	public static ArrayList<obj_seis_campos> muestra_conferencias_dia(String tc_idn) {
		ArrayList<obj_seis_campos> lista = new ArrayList<obj_seis_campos>();
		Connection c=null;
		try {
			String sql;
			c = conexion_odbc.Connexion_datos();

			sql = "select ";
			sql = sql + "a.conf_idn,  ";
			sql = sql + "a.conf_nombre, ";
			sql = sql + "d.est_conf_nombre, ";  
			sql = sql + "d.est_conf_idn, ";  
			sql = sql + "c.tip_conf_nombre, ";
			sql = sql + "CASE WHEN datepart(hour, a.conf_fecha_inicio) >9 THEN cast(datepart(hour, a.conf_fecha_inicio) as varchar(2)) ELSE '0' + cast(datepart(hour, a.conf_fecha_inicio) as varchar(1)) END + ':' + CASE WHEN datepart(minute, a.conf_fecha_inicio)> 9 THEN cast(datepart(minute, a.conf_fecha_inicio) as varchar(2)) ELSE '0' + cast(datepart(minute, a.conf_fecha_inicio) as varchar(1)) END as hora_inicio,  ";
			sql = sql + "a.conf_duracion  ";
			
			sql = sql + "from conferencia a, ";
			sql = sql + "conferencias_ejecuciones_academicas b,";
			sql = sql + "tipo_conferencia c, ";
			sql = sql + "estado_conferencia d,";
			sql = sql + "toma_cursos e ";
						
			sql = sql + "where a.tip_conf_idn = c.tip_conf_idn and ";  
			sql = sql + "a.est_conf_idn = d.est_conf_idn and ";  
			sql = sql + "b.conf_idn = a.conf_idn and "; 
			sql = sql + "b.eje_aca_idn = e.eje_aca_idn and ";
			sql = sql + "a.est_conf_idn = '2' and  ";
			sql = sql + "e.tc_idn = '"+tc_idn.trim()+"' ";
			System.out.println("\n\n"+tc_idn.trim()+"\n\n");
			
			sql = sql + "order by d.est_conf_idn, a.conf_fecha_inicio asc";

			
			CallableStatement ps = c.prepareCall(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()){

				lista.add(new obj_seis_campos(rs.getString("conf_idn"),
												rs.getString("conf_nombre"),
												rs.getString("est_conf_nombre"),
												rs.getString("tip_conf_nombre"),
												rs.getString("hora_inicio"),
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
	
	
	public static ArrayList<obj_seis_campos> muestra_conferencias(String tc_idn) {
		ArrayList<obj_seis_campos> lista = new ArrayList<obj_seis_campos>();
		Connection c=null;
		try {
			String sql;
			c = conexion_odbc.Connexion_datos();

			sql = "select ";
			sql = sql + "a.conf_idn,  ";
			sql = sql + "a.conf_nombre, ";
			sql = sql + "d.est_conf_nombre, ";  
			sql = sql + "d.est_conf_idn, ";  
			sql = sql + "c.tip_conf_nombre, ";
			sql = sql + "a.conf_fecha_inicio,  ";
			sql = sql + "a.conf_duracion  ";
			
			sql = sql + "from conferencia a, ";
			sql = sql + "conferencias_ejecuciones_academicas b,";
			sql = sql + "tipo_conferencia c, ";
			sql = sql + "estado_conferencia d,";
			sql = sql + "toma_cursos e ";
						
			sql = sql + "where a.tip_conf_idn = c.tip_conf_idn and ";  
			sql = sql + "a.est_conf_idn = d.est_conf_idn and ";  
			sql = sql + "b.conf_idn = a.conf_idn and "; 
			sql = sql + "b.eje_aca_idn = e.eje_aca_idn and ";
			sql = sql + "a.est_conf_idn <> '2' and  ";
			sql = sql + "a.est_conf_idn <> '3' and  ";
			sql = sql + "e.tc_idn = '"+tc_idn.trim()+"' ";
			
			
			sql = sql + "order by d.est_conf_idn, a.conf_fecha_inicio asc";
			
			CallableStatement ps = c.prepareCall(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()){

				lista.add(new obj_seis_campos(rs.getString("conf_idn"),
												rs.getString("conf_nombre"),
												rs.getString("est_conf_nombre"),
												rs.getString("tip_conf_nombre"),
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
//******************************************************************************************************************************************************    
	
	
	public static ArrayList<obj_seis_campos> muestra_conferencias_fin(String tc_idn) {
		ArrayList<obj_seis_campos> lista = new ArrayList<obj_seis_campos>();
		Connection c=null;
		try {
			String sql;
			c = conexion_odbc.Connexion_datos();

			sql = "select ";
			sql = sql + "a.conf_idn,  ";
			sql = sql + "a.conf_nombre, ";
			sql = sql + "d.est_conf_nombre, ";  
			sql = sql + "d.est_conf_idn, ";  
			sql = sql + "c.tip_conf_nombre, ";
			sql = sql + "a.conf_fecha_inicio,  ";
			sql = sql + "a.conf_duracion  ";
			
			sql = sql + "from conferencia a, ";
			sql = sql + "conferencias_ejecuciones_academicas b,";
			sql = sql + "tipo_conferencia c, ";
			sql = sql + "estado_conferencia d,";
			sql = sql + "toma_cursos e ";
						
			sql = sql + "where a.tip_conf_idn = c.tip_conf_idn and ";  
			sql = sql + "a.est_conf_idn = d.est_conf_idn and ";  
			sql = sql + "b.conf_idn = a.conf_idn and "; 
			sql = sql + "b.eje_aca_idn = e.eje_aca_idn and ";
			sql = sql + "a.est_conf_idn = '3' and  ";
			sql = sql + "e.tc_idn = '"+tc_idn.trim()+"' ";
			
			
			sql = sql + "order by d.est_conf_idn, a.conf_fecha_inicio asc";
			
			CallableStatement ps = c.prepareCall(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()){

				lista.add(new obj_seis_campos(rs.getString("conf_idn"),
												rs.getString("conf_nombre"),
												rs.getString("est_conf_nombre"),
												rs.getString("tip_conf_nombre"),
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
	
	
	
}
