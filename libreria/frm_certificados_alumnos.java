package libreria;

import iplacex.conexion_odbc;
import iplacex.obj_cinco_campos;
import iplacex.obj_combo_dos_campos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class frm_certificados_alumnos {
	
	//******************************************************************************************************************************************************    
    public static ArrayList<obj_cuatro_campos> busca_matriculas_por_rut (String alu_rut) {
        ArrayList<obj_cuatro_campos> lista = new ArrayList<obj_cuatro_campos>();
       Connection c=null;
        try {
           String sql;
           c = conexion_odbc.Connexion_datos();
           sql = "select a.alu_rut, b.mat_idn, g.car_nombre, alu_nombre + ' ' + alu_ap_paterno + ' ' + alu_ap_materno as nombre  " ;
           sql = sql + "from alumnos a, matriculas b, promociones_dela_malla c, malla_modalidad d, malla_campus e, malla_curricular f, carreras g ";
           sql = sql + "where a.alu_idn = b.alu_idn "; 
           sql = sql + "and b.pro_mal_idn = c.pro_mal_idn ";
           sql = sql + "and c.mal_mod_idn = d.mal_mod_idn ";
           sql = sql + "and d.mal_cam_idn = e.mal_cam_idn ";
           sql = sql + "and e.mal_idn = f.mal_idn ";
           sql = sql + "and f.car_idn = g.car_idn ";
           sql = sql + "and a.alu_rut = '"+alu_rut.trim()+"'";
           CallableStatement ps = c.prepareCall(sql);
           ResultSet rs = ps.executeQuery();
           
                      
            while (rs.next()){
           
               lista.add(new obj_cuatro_campos (rs.getString("alu_rut"),
            		   						rs.getString("mat_idn"),
            		   						rs.getString("car_nombre"),
                                            rs.getString("nombre")));
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
    public static ArrayList<obj_cuatro_campos> busca_matriculas_por_matriculas (String mat_idn) {
        ArrayList<obj_cuatro_campos> lista = new ArrayList<obj_cuatro_campos>();
       Connection c=null;
        try {
           String sql;
           c = conexion_odbc.Connexion_datos();
           sql = "select a.alu_rut, b.mat_idn, g.car_nombre, alu_nombre + ' ' + alu_ap_paterno + ' ' + alu_ap_materno as nombre  " ;
           sql = sql + "from alumnos a, matriculas b, promociones_dela_malla c, malla_modalidad d, malla_campus e, malla_curricular f, carreras g ";
           sql = sql + "where a.alu_idn = b.alu_idn "; 
           sql = sql + "and b.pro_mal_idn = c.pro_mal_idn ";
           sql = sql + "and c.mal_mod_idn = d.mal_mod_idn ";
           sql = sql + "and d.mal_cam_idn = e.mal_cam_idn ";
           sql = sql + "and e.mal_idn = f.mal_idn ";
           sql = sql + "and f.car_idn = g.car_idn ";
           sql = sql + "and b.mat_idn = '"+mat_idn.trim()+"'";
           CallableStatement ps = c.prepareCall(sql);
           ResultSet rs = ps.executeQuery();
           
                      
            while (rs.next()){
           
               lista.add(new obj_cuatro_campos(rs.getString("alu_rut"),
            		   						rs.getString("mat_idn"),
            		   						rs.getString("car_nombre"),
                                            rs.getString("nombre")));
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
    
    public static ArrayList<obj_dos_campos> rellena_combo (String func_mod_fun_idn) {
        ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
       Connection c=null;
        try {
           String sql;
           c = conexion_odbc.Connexion_datos();
           sql = "select distinct e.rep_nombre, e.rep_archivo " ;
           sql = sql + "from   funcion_modalidad_del_funcionario a, funcion_modalidad b, modalidad_del_campus c, reportes_campus_modalidad d, reportes e ";
           sql = sql + "where  a.func_mod_fun_idn = '"+func_mod_fun_idn.trim()+"' and "; 
           sql = sql + "a.func_mod_idn = b.func_mod_idn and ";
           sql = sql + "b.mod_cam_idn = c.mod_cam_idn and ";
           sql = sql + "c.mod_cam_idn = d.mod_cam_idn and ";
           sql = sql + "d.rep_idn = e.rep_idn and ";
	   sql = sql + "d.rep_idn > 5 ";
           CallableStatement ps = c.prepareCall(sql);
           ResultSet rs = ps.executeQuery();
           
           lista.add(new obj_dos_campos("0", " - Seleccione - "));
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
   
  //*************************************************************************************************************************************** aqui    
  
	public frm_certificados_alumnos()
	{
		
	}
}
