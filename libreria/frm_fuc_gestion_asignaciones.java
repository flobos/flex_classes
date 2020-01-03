package libreria;

import java.util.ArrayList;
import java.sql.*;

public class frm_fuc_gestion_asignaciones {
	
	public static ArrayList<obj_seis_campos> buscar_matriculas
    (String func_mod_fun_idn,
    String eje_idn,
    String eje_aca_idn, 
    String pro_idn, 
    String car_idn, 
    String mal_idn,
    String toma_curso
    ) {
        ArrayList<obj_seis_campos> lista = new ArrayList<obj_seis_campos>();
       Connection c=null;
        try {
           String sql;
           c = conexion_odbc.Connexion_datos();
        
           sql = "select distinct a.mat_idn, s.car_nombre, l.pro_nombre, p.mal_nombre, cast(count(e.eje_nombre) as varchar(2)) + ' ejecuciones asociadas' as eje_nombre ";
           sql = sql + "from ";
           sql = sql + "matriculas a, ";
           sql = sql + "toma_cursos b, ";
           sql = sql + "ejecucion_academica c, ";
           sql = sql + "ejecucion_producto d, ";
           sql = sql + "ejecucion e, ";
           sql = sql + "producto_campus f, ";
           sql = sql + "producto_modalidad g, ";
           sql = sql + "cursos h, ";
           sql = sql + "promociones_dela_malla i, ";
           sql = sql + "seccion j, ";
           sql = sql + "tipo_jornada k, ";
           sql = sql + "promocion l, ";
           sql = sql + "malla_modalidad m, ";
           sql = sql + "modalidad n, ";
           sql = sql + "malla_campus o, ";
           sql = sql + "malla_curricular p, ";
           sql = sql + "peririocidad q, ";
           sql = sql + "tipo_producto r, ";
           sql = sql + "carreras s, ";
           sql = sql + "alumnos t ";
           sql = sql + "where  ";
           sql = sql + "a.mat_idn = b.mat_idn ";
           sql = sql + "and c.sec_idn = j.sec_idn ";
           sql = sql + "and c.tip_jor_idn = k.tip_jor_idn ";
           sql = sql + "and	b.eje_aca_idn = c.eje_aca_idn ";
           sql = sql + "and c.eje_pro_idn = d.eje_pro_idn ";
           sql = sql + "and	d.eje_idn = e.eje_idn ";
           sql = sql + "and d.pro_cam_idn = f.pro_cam_idn ";
           sql = sql + "and f.pro_mod_idn = g.pro_mod_idn ";
           sql = sql + "and g.cur_idn = h.cur_idn ";
           sql = sql + "and a.pro_mal_idn = i.pro_mal_idn ";
           sql = sql + "and i.pro_idn = l.pro_idn ";
           sql = sql + "and m.mal_mod_idn = i.mal_mod_idn ";
           sql = sql + "and m.mod_idn = n.mod_idn ";
           sql = sql + "and m.mod_idn = g.mod_idn ";
           sql = sql + "and o.mal_cam_idn = m.mal_cam_idn ";
           sql = sql + "and p.mal_idn = o.mal_idn ";
           sql = sql + "and p.per_idn = q.per_idn ";
           sql = sql + "and r.tip_prod_idn = p.tip_prod_idn ";
           sql = sql + "and p.car_idn = s.car_idn ";
           sql = sql + "and t.alu_idn = a.alu_idn ";
           sql = sql + "and a.mat_idn not in ";
           sql = sql + "(select distinct mat_idn from motivos_matriculas_funcionarios) ";
           sql = sql + "and l.mod_cam_idn in ";
           sql = sql + "(select a.mod_cam_idn from funcion_modalidad a, funcion_modalidad_del_funcionario b where a.func_mod_idn = b.func_mod_idn and b.func_mod_fun_idn = '"+func_mod_fun_idn.trim()+"') ";


           if (toma_curso.equals("1"))
           {
        	   sql = sql + "and b.sit_tom_idn = '100' ";
           }
           if (toma_curso.equals("2"))
           {
        	   sql = sql + "and b.sit_tom_idn = '101' ";
           }
           if (!eje_idn.equals(""))
           {
        	   sql = sql + "and e.eje_activa = 1 ";
        	   sql = sql + "and e.eje_idn = '"+eje_idn.trim()+"' ";
           }
           if (!eje_aca_idn.equals(""))
           {
        	   sql = sql + "and e.eje_activa = 1 ";
        	   sql = sql + "and c.eje_aca_idn = '"+eje_aca_idn.trim()+"' ";
           }
           if (!pro_idn.equals(""))
           {
        	   sql = sql + "and l.pro_idn = '"+pro_idn.trim()+"' ";
           }
           if (!car_idn.equals(""))
           {
        	   sql = sql + "and s.car_idn = '"+car_idn.trim()+"' ";
           }
           if (!mal_idn.equals(""))
           {
        	   sql = sql + "and p.mal_idn = '"+mal_idn.trim()+"' ";
           }
           
           sql = sql + "group by a.mat_idn, s.car_nombre, l.pro_nombre, p.mal_nombre ";
 
           CallableStatement ps = c.prepareCall(sql);
           ResultSet rs = ps.executeQuery();
           
           while (rs.next()){
           
               lista.add(new obj_seis_campos(rs.getString("mat_idn"),
            		   								rs.getString("car_nombre"),
            		   								rs.getString("pro_nombre"),
            		   								rs.getString("mal_nombre"),
            		   								rs.getString("eje_nombre"),
            		   								null));
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
	
	public static ArrayList<obj_seis_campos> buscar_matriculas_asignadas 
    (String func_mod_fun_idn,
    String eje_idn,
    String eje_aca_idn, 
    String pro_idn, 
    String car_idn, 
    String mal_idn,
    String toma_curso
    ) {
        ArrayList<obj_seis_campos> lista = new ArrayList<obj_seis_campos>();
       Connection c=null;
        try {
           String sql;
           c = conexion_odbc.Connexion_datos();
        
           sql = "select distinct a.mat_idn, s.car_nombre, l.pro_nombre, p.mal_nombre, cast(count(e.eje_nombre) as varchar(2)) + ' ejecuciones asociadas' as eje_nombre ";
           sql = sql + "from ";
           sql = sql + "matriculas a, ";
           sql = sql + "toma_cursos b, ";
           sql = sql + "ejecucion_academica c, ";
           sql = sql + "ejecucion_producto d, ";
           sql = sql + "ejecucion e, ";
           sql = sql + "producto_campus f, ";
           sql = sql + "producto_modalidad g, ";
           sql = sql + "cursos h, ";
           sql = sql + "promociones_dela_malla i, ";
           sql = sql + "seccion j, ";
           sql = sql + "tipo_jornada k, ";
           sql = sql + "promocion l, ";
           sql = sql + "malla_modalidad m, ";
           sql = sql + "modalidad n, ";
           sql = sql + "malla_campus o, ";
           sql = sql + "malla_curricular p, ";
           sql = sql + "peririocidad q, ";
           sql = sql + "tipo_producto r, ";
           sql = sql + "carreras s, ";
           sql = sql + "alumnos t ";
           sql = sql + "where  ";
           sql = sql + "a.mat_idn = b.mat_idn ";
           sql = sql + "and c.sec_idn = j.sec_idn ";
           sql = sql + "and c.tip_jor_idn = k.tip_jor_idn ";
           sql = sql + "and	b.eje_aca_idn = c.eje_aca_idn ";
           sql = sql + "and c.eje_pro_idn = d.eje_pro_idn ";
           sql = sql + "and	d.eje_idn = e.eje_idn ";
           sql = sql + "and d.pro_cam_idn = f.pro_cam_idn ";
           sql = sql + "and f.pro_mod_idn = g.pro_mod_idn ";
           sql = sql + "and g.cur_idn = h.cur_idn ";
           sql = sql + "and a.pro_mal_idn = i.pro_mal_idn ";
           sql = sql + "and i.pro_idn = l.pro_idn ";
           sql = sql + "and m.mal_mod_idn = i.mal_mod_idn ";
           sql = sql + "and m.mod_idn = n.mod_idn ";
           sql = sql + "and m.mod_idn = g.mod_idn ";
           sql = sql + "and o.mal_cam_idn = m.mal_cam_idn ";
           sql = sql + "and p.mal_idn = o.mal_idn ";
           sql = sql + "and p.per_idn = q.per_idn ";
           sql = sql + "and r.tip_prod_idn = p.tip_prod_idn ";
           sql = sql + "and p.car_idn = s.car_idn ";
           sql = sql + "and t.alu_idn = a.alu_idn ";
           sql = sql + "and a.mat_idn in ";
           sql = sql + "(select distinct mat_idn from motivos_matriculas_funcionarios) ";
           sql = sql + "and l.mod_cam_idn in ";
           sql = sql + "(select a.mod_cam_idn from funcion_modalidad a, funcion_modalidad_del_funcionario b where a.func_mod_idn = b.func_mod_idn and b.func_mod_fun_idn = '"+func_mod_fun_idn.trim()+"') ";

           
           if (!eje_idn.equals(""))
           {
        	   sql = sql + "and e.eje_activa = 1 ";
        	   sql = sql + "and e.eje_idn = '"+eje_idn.trim()+"' ";
           }
           if (!eje_aca_idn.equals(""))
           {
        	   sql = sql + "and e.eje_activa = 1 ";
        	   sql = sql + "and c.eje_aca_idn = '"+eje_aca_idn.trim()+"' ";
           }
           if (!pro_idn.equals(""))
           {
        	   sql = sql + "and l.pro_idn = '"+pro_idn.trim()+"' ";
           }
           if (!car_idn.equals(""))
           {
        	   sql = sql + "and s.car_idn = '"+car_idn.trim()+"' ";
           }
           if (!mal_idn.equals(""))
           {
        	   sql = sql + "and p.mal_idn = '"+mal_idn.trim()+"' ";
           }
           
           sql = sql + "group by a.mat_idn, s.car_nombre, l.pro_nombre, p.mal_nombre ";
 
           CallableStatement ps = c.prepareCall(sql);
           ResultSet rs = ps.executeQuery();
           
           while (rs.next()){
           
               lista.add(new obj_seis_campos(rs.getString("mat_idn"),
            		   								rs.getString("car_nombre"),
            		   								rs.getString("pro_nombre"),
            		   								rs.getString("mal_nombre"),
            		   								rs.getString("eje_nombre"),
            		   								null));
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
	
	
	public static ArrayList<obj_cinco_campos> buscar_motivos_matriculas 
    (String func_mod_fun_idn, String mat_idn) {
        ArrayList<obj_cinco_campos> lista = new ArrayList<obj_cinco_campos>();
       Connection c=null;
        try {
           String sql;
           c = conexion_odbc.Connexion_datos();
           
      
           sql = "select * from  ";
           sql = sql + "(select  ";
           sql = sql + "e.mot_cri_mod_cam_idn, "; 
           sql = sql + "b.mot_con_nombre, "; 
           sql = sql + "a.cri_con_nombre ";
           sql = sql + "from "; 
           sql = sql + "criterios_consulta a, "; 
           sql = sql + "motivos_consulta b, "; 
           sql = sql + "motivos_criterios_modalidad_campus e, ";
           sql = sql + "modalidad_campus_del_criterio f, ";
           sql = sql + "modalidad_campus_del_motivo g ";
           sql = sql + "where ";
           sql = sql + "a.cri_con_idn = f.cri_con_idn  ";
           sql = sql + "and f.mod_cam_cri_idn = e.mod_cam_cri_idn  ";
           sql = sql + "and f.mod_cam_idn = g.mod_cam_idn  ";
           sql = sql + "and b.mot_con_idn = g.mot_con_idn  ";
           sql = sql + "and g.mod_cam_mot_idn = e.mod_cam_mot_idn  ";
           sql = sql + "and g.mod_cam_idn =  ";
           sql = sql + "(select a.mod_cam_idn from modalidad_del_campus a, funcion_modalidad_del_funcionario b, funcion_modalidad c  ";
           sql = sql + "where a.mod_cam_idn = c.mod_cam_idn  ";
           sql = sql + "and b.func_mod_idn = c.func_mod_idn ";
           sql = sql + "and b.func_mod_fun_idn = '"+func_mod_fun_idn.trim()+"')) motivos_asignables ";

           sql = sql + "LEFT OUTER JOIN ";

           sql = sql + "(select b.func_mod_fun_idn , d.fun_nombre + ' ' + d.fun_ap_paterno + ' ' + d.fun_ap_materno as funcionario, c.mot_cri_mod_cam_idn ";
           sql = sql + "from ";
           sql = sql + "matriculas a, ";
           sql = sql + "funcion_modalidad_del_funcionario b, ";
           sql = sql + "motivos_matriculas_funcionarios c, ";
           sql = sql + "funcionarios d ";
           sql = sql + "where ";
           sql = sql + "a.mat_idn = c.mat_idn and ";
           sql = sql + "a.mat_idn = '"+mat_idn.trim()+"' and ";
           sql = sql + "b.func_mod_fun_idn = c.func_mod_fun_idn and ";
           sql = sql + "b.fun_rut = d.fun_rut) motivos_asignados ";
           sql = sql + "ON motivos_asignables.mot_cri_mod_cam_idn = motivos_asignados.mot_cri_mod_cam_idn ";
           sql = sql + "order by motivos_asignables.cri_con_nombre, motivos_asignables.mot_con_nombre asc ";


           
           
           CallableStatement ps = c.prepareCall(sql);
           ResultSet rs = ps.executeQuery();
           
           while (rs.next()){
           
        	   
               lista.add(new obj_cinco_campos(rs.getString("mot_cri_mod_cam_idn"),
            		   						rs.getString("mot_con_nombre"),
            		   						rs.getString("cri_con_nombre"),
            		   						rs.getString("func_mod_fun_idn"),
            		   						rs.getString("funcionario")));
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
	
		public static void insertar_asignacion(String func_mod_fun_idn, String mat_idn, String mot_cri_mod_cam_idn)  {
		
		Connection c = null;
		PreparedStatement ps = null;
		try {
			c = conexion_odbc.Connexion_datos();
			String sql;
			
			sql = "IF EXISTS(SELECT * FROM motivos_matriculas_funcionarios WHERE mat_idn = '"+mat_idn.trim()+"' AND mot_cri_mod_cam_idn ='"+mot_cri_mod_cam_idn.trim()+"') ";
			sql = sql + "BEGIN UPDATE motivos_matriculas_funcionarios set func_mod_fun_idn = '"+func_mod_fun_idn.trim()+"' WHERE mat_idn = '"+mat_idn.trim()+"' AND mot_cri_mod_cam_idn ='"+mot_cri_mod_cam_idn.trim()+"' END ";
			sql = sql + "ELSE BEGIN INSERT INTO motivos_matriculas_funcionarios (func_mod_fun_idn, mat_idn, mot_cri_mod_cam_idn) VALUES ('"+func_mod_fun_idn.trim()+"', '"+mat_idn.trim()+"', '"+mot_cri_mod_cam_idn.trim()+"') END ";			
			
			ps = c.prepareStatement(sql);
			ps.execute();
			// HSQLDB Syntax to get the identity (company_id) of inserted row
			//ResultSet rs = s.executeQuery("CALL IDENTITY()");
			// MySQL Syntax to get the identity (product_id) of inserted row
			// Update the id in the returned object. This is important as this value must get returned to the client.
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
	}
	
		public static ArrayList<obj_un_campo> eliminar_asignacion(String mat_idn)  {
			 ArrayList<obj_un_campo> lista = new ArrayList<obj_un_campo>();
			Connection c = null;
			try {
				c = conexion_odbc.Connexion_datos();
				String sql;
				
				sql = "DELETE motivos_matriculas_funcionarios WHERE mat_idn = '"+mat_idn.trim()+"' ";
				sql = sql + "select mat_idn from motivos_matriculas_funcionarios WHERE mat_idn = '"+mat_idn.trim()+"' ";
				
				CallableStatement ps = c.prepareCall(sql);
		        ResultSet rs = ps.executeQuery();
				
		        while (rs.next()){
		            
		        	   
		               lista.add(new obj_un_campo(rs.getString("mat_idn")));
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
	
	public static ArrayList<obj_cinco_campos> buscar_motivos 
    (String func_mod_fun_idn) {
        ArrayList<obj_cinco_campos> lista = new ArrayList<obj_cinco_campos>();
       Connection c=null;
        try {
           String sql;
           c = conexion_odbc.Connexion_datos();
           
      
           sql = "select  ";
           sql = sql + "e.mot_cri_mod_cam_idn, "; 
           sql = sql + "b.mot_con_nombre, "; 
           sql = sql + "a.cri_con_nombre, ";
           sql = sql + "null as func_mod_fun_idn, ";
           sql = sql + "null as funcionario ";
           sql = sql + "from "; 
           sql = sql + "criterios_consulta a, "; 
           sql = sql + "motivos_consulta b, "; 
           sql = sql + "motivos_criterios_modalidad_campus e, ";
           sql = sql + "modalidad_campus_del_criterio f, ";
           sql = sql + "modalidad_campus_del_motivo g ";
           sql = sql + "where ";
           sql = sql + "a.cri_con_idn = f.cri_con_idn  ";
           sql = sql + "and f.mod_cam_cri_idn = e.mod_cam_cri_idn  ";
           sql = sql + "and f.mod_cam_idn = g.mod_cam_idn  ";
           sql = sql + "and b.mot_con_idn = g.mot_con_idn  ";
           sql = sql + "and g.mod_cam_mot_idn = e.mod_cam_mot_idn  ";
           sql = sql + "and g.mod_cam_idn =  ";
           sql = sql + "(select a.mod_cam_idn from modalidad_del_campus a, funcion_modalidad_del_funcionario b, funcion_modalidad c  ";
           sql = sql + "where a.mod_cam_idn = c.mod_cam_idn  ";
           sql = sql + "and b.func_mod_idn = c.func_mod_idn ";
           sql = sql + "and b.func_mod_fun_idn = '"+func_mod_fun_idn.trim()+"') ";

           sql = sql + "order by a.cri_con_nombre, b.mot_con_nombre asc ";


           
           
           CallableStatement ps = c.prepareCall(sql);
           ResultSet rs = ps.executeQuery();
           
           while (rs.next()){
           
        	   
               lista.add(new obj_cinco_campos(rs.getString("mot_cri_mod_cam_idn"),
            		   						rs.getString("mot_con_nombre"),
            		   						rs.getString("cri_con_nombre"),
            		   						rs.getString("func_mod_fun_idn"),
            		   						rs.getString("funcionario")));
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
	public static ArrayList<obj_dos_campos> buscar_ejecuciones_academicas 
    (String func_mod_fun_idn) {
        ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
       Connection c=null;
        try {
           String sql;
           c = conexion_odbc.Connexion_datos();
           
           sql = "select distinct q.eje_aca_idn, y.cur_nombre + ' - ' + t.sec_nombre +' - ' + u.tip_jor_nombre + ' ['+q.eje_aca_idn+']' as cur_nombre "; 
           sql = sql + "from "; 
           sql = sql + "carreras a, ";  
           sql = sql + "malla_curricular g, "; 
           sql = sql + "peririocidad h, "; 
           sql = sql + "tipo_producto i, "; 
           sql = sql + "malla_campus j, "; 
           sql = sql + "malla_modalidad k,  ";
           sql = sql + "modalidad l, "; 
           sql = sql + "promociones_dela_malla m, "; 
           sql = sql + "promocion n, "; 
           sql = sql + "matriculas o, "; 
           sql = sql + "toma_cursos p, "; 
           sql = sql + "ejecucion_academica q, "; 
           sql = sql + "ejecucion_producto r, "; 
           sql = sql + "ejecucion s,  ";
           sql = sql + "seccion t, "; 
           sql = sql + "tipo_jornada u, "; 
           sql = sql + "producto_campus v,  ";
           sql = sql + "producto_modalidad x, "; 
           sql = sql + "cursos y,  ";
           sql = sql + "alumnos z  ";
           sql = sql + "where ";  
           sql = sql + "o.alu_idn = z.alu_idn ";  
           sql = sql + "and a.car_idn = g.car_idn  ";
           sql = sql + "and g.per_idn = h.per_idn "; 
           sql = sql + "and g.tip_prod_idn = i.tip_prod_idn "; 
           sql = sql + "and g.mal_idn = j.mal_idn "; 
           sql = sql + "and j.mal_cam_idn = k.mal_cam_idn "; 
           sql = sql + "and k.mod_idn = l.mod_idn "; 
           sql = sql + "and k.mal_mod_idn = m.mal_mod_idn "; 
           sql = sql + "and m.pro_idn = n.pro_idn "; 
           sql = sql + "and m.pro_mal_idn = o.pro_mal_idn "; 
           sql = sql + "and o.mat_idn = p.mat_idn "; 
           sql = sql + "and p.eje_aca_idn = q.eje_aca_idn "; 
           sql = sql + "and q.eje_pro_idn = r.eje_pro_idn "; 
           sql = sql + "and r.eje_idn = s.eje_idn "; 
           sql = sql + "and q.sec_idn = t.sec_idn "; 
           sql = sql + "and q.tip_jor_idn = u.tip_jor_idn "; 
           sql = sql + "and s.eje_activa = 1 "; 
           sql = sql + "and s.mod_cam_idn = n.mod_cam_idn "; 
           sql = sql + "and r.pro_cam_idn = v.pro_cam_idn "; 
           sql = sql + "and v.pro_mod_idn = x.pro_mod_idn "; 
           sql = sql + "and x.cur_idn = y.cur_idn "; 
           sql = sql + "and n.mod_cam_idn in ";
           sql = sql + "(select a.mod_cam_idn from funcion_modalidad a, funcion_modalidad_del_funcionario b where a.func_mod_idn = b.func_mod_idn and b.func_mod_fun_idn = '"+func_mod_fun_idn.trim()+"') ";

           
           CallableStatement ps = c.prepareCall(sql);
           ResultSet rs = ps.executeQuery();
           lista.add(new obj_dos_campos("0"," - Todas - "));
           
           while (rs.next()){
           
        	   
               lista.add(new obj_dos_campos(rs.getString("eje_aca_idn"),
            		   						rs.getString("cur_nombre")));
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
	
	
	public static ArrayList<obj_dos_campos> buscar_ejecuciones 
    (String func_mod_fun_idn) {
        ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
       Connection c=null;
        try {
           String sql;
           c = conexion_odbc.Connexion_datos();
           
           sql = "select distinct s.eje_idn, s.eje_nombre "; 
           sql = sql + "from "; 
           sql = sql + "carreras a, ";  
           sql = sql + "malla_curricular g, "; 
           sql = sql + "peririocidad h, "; 
           sql = sql + "tipo_producto i, "; 
           sql = sql + "malla_campus j, "; 
           sql = sql + "malla_modalidad k,  ";
           sql = sql + "modalidad l, "; 
           sql = sql + "promociones_dela_malla m, "; 
           sql = sql + "promocion n, "; 
           sql = sql + "matriculas o, "; 
           sql = sql + "toma_cursos p, "; 
           sql = sql + "ejecucion_academica q, "; 
           sql = sql + "ejecucion_producto r, "; 
           sql = sql + "ejecucion s,  ";
           sql = sql + "seccion t, "; 
           sql = sql + "tipo_jornada u, "; 
           sql = sql + "producto_campus v,  ";
           sql = sql + "producto_modalidad x, "; 
           sql = sql + "cursos y,  ";
           sql = sql + "alumnos z  ";
           sql = sql + "where ";  
           sql = sql + "o.alu_idn = z.alu_idn ";  
           sql = sql + "and a.car_idn = g.car_idn  ";
           sql = sql + "and g.per_idn = h.per_idn "; 
           sql = sql + "and g.tip_prod_idn = i.tip_prod_idn "; 
           sql = sql + "and g.mal_idn = j.mal_idn "; 
           sql = sql + "and j.mal_cam_idn = k.mal_cam_idn "; 
           sql = sql + "and k.mod_idn = l.mod_idn "; 
           sql = sql + "and k.mal_mod_idn = m.mal_mod_idn "; 
           sql = sql + "and m.pro_idn = n.pro_idn "; 
           sql = sql + "and m.pro_mal_idn = o.pro_mal_idn "; 
           sql = sql + "and o.mat_idn = p.mat_idn "; 
           sql = sql + "and p.eje_aca_idn = q.eje_aca_idn "; 
           sql = sql + "and q.eje_pro_idn = r.eje_pro_idn "; 
           sql = sql + "and r.eje_idn = s.eje_idn "; 
           sql = sql + "and q.sec_idn = t.sec_idn "; 
           sql = sql + "and q.tip_jor_idn = u.tip_jor_idn "; 
           sql = sql + "and s.eje_activa = 1 "; 
           sql = sql + "and s.mod_cam_idn = n.mod_cam_idn "; 
           sql = sql + "and r.pro_cam_idn = v.pro_cam_idn "; 
           sql = sql + "and v.pro_mod_idn = x.pro_mod_idn "; 
           sql = sql + "and x.cur_idn = y.cur_idn "; 
           sql = sql + "and n.mod_cam_idn in ";
           sql = sql + "(select a.mod_cam_idn from funcion_modalidad a, funcion_modalidad_del_funcionario b where a.func_mod_idn = b.func_mod_idn and b.func_mod_fun_idn = '"+func_mod_fun_idn.trim()+"') ";

           sql = sql + "order by s.eje_nombre asc ";
           
           CallableStatement ps = c.prepareCall(sql);
           ResultSet rs = ps.executeQuery();
           lista.add(new obj_dos_campos("0"," - Todas - "));
           
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
	public static ArrayList<obj_dos_campos> buscar_promociones 
    (String func_mod_fun_idn) {
        ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
       Connection c=null;
        try {
           String sql;
           c = conexion_odbc.Connexion_datos();
       
           sql = "select distinct n.pro_idn, n.pro_nombre "; 
           sql = sql + "from "; 
           sql = sql + "carreras a, ";  
           sql = sql + "malla_curricular g, "; 
           sql = sql + "peririocidad h, "; 
           sql = sql + "tipo_producto i, "; 
           sql = sql + "malla_campus j, "; 
           sql = sql + "malla_modalidad k,  ";
           sql = sql + "modalidad l, "; 
           sql = sql + "promociones_dela_malla m, "; 
           sql = sql + "promocion n, "; 
           sql = sql + "matriculas o, "; 
           sql = sql + "toma_cursos p, "; 
           sql = sql + "ejecucion_academica q, "; 
           sql = sql + "ejecucion_producto r, "; 
           sql = sql + "ejecucion s,  ";
           sql = sql + "seccion t, "; 
           sql = sql + "tipo_jornada u, "; 
           sql = sql + "producto_campus v,  ";
           sql = sql + "producto_modalidad x, "; 
           sql = sql + "cursos y,  ";
           sql = sql + "alumnos z  ";
           sql = sql + "where ";  
           sql = sql + "o.alu_idn = z.alu_idn ";  
           sql = sql + "and a.car_idn = g.car_idn  ";
           sql = sql + "and g.per_idn = h.per_idn "; 
           sql = sql + "and g.tip_prod_idn = i.tip_prod_idn "; 
           sql = sql + "and g.mal_idn = j.mal_idn "; 
           sql = sql + "and j.mal_cam_idn = k.mal_cam_idn "; 
           sql = sql + "and k.mod_idn = l.mod_idn "; 
           sql = sql + "and k.mal_mod_idn = m.mal_mod_idn "; 
           sql = sql + "and m.pro_idn = n.pro_idn "; 
           sql = sql + "and m.pro_mal_idn = o.pro_mal_idn "; 
           sql = sql + "and o.mat_idn = p.mat_idn "; 
           sql = sql + "and p.eje_aca_idn = q.eje_aca_idn "; 
           sql = sql + "and q.eje_pro_idn = r.eje_pro_idn "; 
           sql = sql + "and r.eje_idn = s.eje_idn "; 
           sql = sql + "and q.sec_idn = t.sec_idn "; 
           sql = sql + "and q.tip_jor_idn = u.tip_jor_idn "; 
           sql = sql + "and s.eje_activa = 1 "; 
           sql = sql + "and s.mod_cam_idn = n.mod_cam_idn "; 
           sql = sql + "and r.pro_cam_idn = v.pro_cam_idn "; 
           sql = sql + "and v.pro_mod_idn = x.pro_mod_idn "; 
           sql = sql + "and x.cur_idn = y.cur_idn "; 
           sql = sql + "and n.mod_cam_idn in ";
           sql = sql + "(select a.mod_cam_idn from funcion_modalidad a, funcion_modalidad_del_funcionario b where a.func_mod_idn = b.func_mod_idn and b.func_mod_fun_idn = '"+func_mod_fun_idn.trim()+"') ";

           sql = sql + "order by n.pro_nombre asc ";

           
           CallableStatement ps = c.prepareCall(sql);
           ResultSet rs = ps.executeQuery();
           lista.add(new obj_dos_campos("0"," - Todas - "));
           
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
	
	public static ArrayList<obj_dos_campos> buscar_mallas 
    (String func_mod_fun_idn) {
        ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
       Connection c=null;
        try {
           String sql;
           c = conexion_odbc.Connexion_datos();
           
           sql = "select distinct g.mal_idn, g.mal_nombre + ' v.'+ cast(g.mal_version as varchar(1)) + ' - ' + i.tip_prod_nombre + ' - ' + h.per_nombre as mal_nombre "; 
           sql = sql + "from "; 
           sql = sql + "carreras a, ";  
           sql = sql + "malla_curricular g, "; 
           sql = sql + "peririocidad h, "; 
           sql = sql + "tipo_producto i, "; 
           sql = sql + "malla_campus j, "; 
           sql = sql + "malla_modalidad k,  ";
           sql = sql + "modalidad l, "; 
           sql = sql + "promociones_dela_malla m, "; 
           sql = sql + "promocion n, "; 
           sql = sql + "matriculas o, "; 
           sql = sql + "toma_cursos p, "; 
           sql = sql + "ejecucion_academica q, "; 
           sql = sql + "ejecucion_producto r, "; 
           sql = sql + "ejecucion s,  ";
           sql = sql + "seccion t, "; 
           sql = sql + "tipo_jornada u, "; 
           sql = sql + "producto_campus v,  ";
           sql = sql + "producto_modalidad x, "; 
           sql = sql + "cursos y,  ";
           sql = sql + "alumnos z  ";
           sql = sql + "where ";  
           sql = sql + "o.alu_idn = z.alu_idn ";  
           sql = sql + "and a.car_idn = g.car_idn  ";
           sql = sql + "and g.per_idn = h.per_idn "; 
           sql = sql + "and g.tip_prod_idn = i.tip_prod_idn "; 
           sql = sql + "and g.mal_idn = j.mal_idn "; 
           sql = sql + "and j.mal_cam_idn = k.mal_cam_idn "; 
           sql = sql + "and k.mod_idn = l.mod_idn "; 
           sql = sql + "and k.mal_mod_idn = m.mal_mod_idn "; 
           sql = sql + "and m.pro_idn = n.pro_idn "; 
           sql = sql + "and m.pro_mal_idn = o.pro_mal_idn "; 
           sql = sql + "and o.mat_idn = p.mat_idn "; 
           sql = sql + "and p.eje_aca_idn = q.eje_aca_idn "; 
           sql = sql + "and q.eje_pro_idn = r.eje_pro_idn "; 
           sql = sql + "and r.eje_idn = s.eje_idn "; 
           sql = sql + "and q.sec_idn = t.sec_idn "; 
           sql = sql + "and q.tip_jor_idn = u.tip_jor_idn "; 
           sql = sql + "and s.eje_activa = 1 "; 
           sql = sql + "and s.mod_cam_idn = n.mod_cam_idn "; 
           sql = sql + "and r.pro_cam_idn = v.pro_cam_idn "; 
           sql = sql + "and v.pro_mod_idn = x.pro_mod_idn "; 
           sql = sql + "and x.cur_idn = y.cur_idn "; 
           sql = sql + "and n.mod_cam_idn in ";
           sql = sql + "(select a.mod_cam_idn from funcion_modalidad a, funcion_modalidad_del_funcionario b where a.func_mod_idn = b.func_mod_idn and b.func_mod_fun_idn = '"+func_mod_fun_idn.trim()+"') ";

           
           
           sql = sql + "order by g.mal_nombre asc ";

           
           CallableStatement ps = c.prepareCall(sql);
           ResultSet rs = ps.executeQuery();
           lista.add(new obj_dos_campos("0"," - Todas - "));
           
           while (rs.next()){
           
        	   
               lista.add(new obj_dos_campos(rs.getString("mal_idn"),
            		   						rs.getString("mal_nombre")));
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
	
	
	public static ArrayList<obj_dos_campos> buscar_carreras 
    (String func_mod_fun_idn) {
        ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
       Connection c=null;
        try {
           String sql;
           c = conexion_odbc.Connexion_datos();
           
           sql = "select distinct a.car_idn, a.car_nombre ";
           sql = sql + "from "; 
           sql = sql + "carreras a, ";  
           sql = sql + "malla_curricular g, "; 
           sql = sql + "peririocidad h, "; 
           sql = sql + "tipo_producto i, "; 
           sql = sql + "malla_campus j, "; 
           sql = sql + "malla_modalidad k,  ";
           sql = sql + "modalidad l, "; 
           sql = sql + "promociones_dela_malla m, "; 
           sql = sql + "promocion n, "; 
           sql = sql + "matriculas o, "; 
           sql = sql + "toma_cursos p, "; 
           sql = sql + "ejecucion_academica q, "; 
           sql = sql + "ejecucion_producto r, "; 
           sql = sql + "ejecucion s,  ";
           sql = sql + "seccion t, "; 
           sql = sql + "tipo_jornada u, "; 
           sql = sql + "producto_campus v,  ";
           sql = sql + "producto_modalidad x, "; 
           sql = sql + "cursos y,  ";
           sql = sql + "alumnos z  ";
           sql = sql + "where ";  
           sql = sql + "o.alu_idn = z.alu_idn ";  
           sql = sql + "and a.car_idn = g.car_idn  ";
           sql = sql + "and g.per_idn = h.per_idn "; 
           sql = sql + "and g.tip_prod_idn = i.tip_prod_idn "; 
           sql = sql + "and g.mal_idn = j.mal_idn "; 
           sql = sql + "and j.mal_cam_idn = k.mal_cam_idn "; 
           sql = sql + "and k.mod_idn = l.mod_idn "; 
           sql = sql + "and k.mal_mod_idn = m.mal_mod_idn "; 
           sql = sql + "and m.pro_idn = n.pro_idn "; 
           sql = sql + "and m.pro_mal_idn = o.pro_mal_idn "; 
           sql = sql + "and o.mat_idn = p.mat_idn "; 
           sql = sql + "and p.eje_aca_idn = q.eje_aca_idn "; 
           sql = sql + "and q.eje_pro_idn = r.eje_pro_idn "; 
           sql = sql + "and r.eje_idn = s.eje_idn "; 
           sql = sql + "and q.sec_idn = t.sec_idn "; 
           sql = sql + "and q.tip_jor_idn = u.tip_jor_idn "; 
           sql = sql + "and s.eje_activa = 1 "; 
           sql = sql + "and s.mod_cam_idn = n.mod_cam_idn "; 
           sql = sql + "and r.pro_cam_idn = v.pro_cam_idn "; 
           sql = sql + "and v.pro_mod_idn = x.pro_mod_idn "; 
           sql = sql + "and x.cur_idn = y.cur_idn "; 
           sql = sql + "and n.mod_cam_idn in ";
           sql = sql + "(select a.mod_cam_idn from funcion_modalidad a, funcion_modalidad_del_funcionario b where a.func_mod_idn = b.func_mod_idn and b.func_mod_fun_idn = '"+func_mod_fun_idn.trim()+"') ";

           sql = sql + "order by a.car_nombre asc ";
           
           
           CallableStatement ps = c.prepareCall(sql);
           ResultSet rs = ps.executeQuery();
           lista.add(new obj_dos_campos("0"," - Todas - "));
           
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
	
	public static ArrayList<obj_dos_campos> buscar_funciones 
    () {
        ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
       Connection c=null;
        try {
           String sql;
           c = conexion_odbc.Connexion_datos();
           
           sql = "select * from funcion ";
           CallableStatement ps = c.prepareCall(sql);
           ResultSet rs = ps.executeQuery();
           lista.add(new obj_dos_campos("0"," - Todas - "));
           
           while (rs.next()){
           
        	   
               lista.add(new obj_dos_campos(rs.getString("func_idn"),
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
	
	public frm_fuc_gestion_asignaciones() {
    }
	
}
