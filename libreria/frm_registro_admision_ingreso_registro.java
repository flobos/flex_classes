/*
 * frm_registro_admision_ingreso_registro.java
 *
 * Created on 19 de agosto de 2010, 03:17 PM
 */

package libreria;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author  Cristian
 */
public class frm_registro_admision_ingreso_registro {
    
    //******************************************************************************************************************************************************    
     public static ArrayList<obj_dos_campos> muestra_tipo_entidad () {
         ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "select * from tipo_entidades" ;
            CallableStatement ps = c.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            
            
             while (rs.next()){
            
                lista.add(new obj_dos_campos(rs.getString("tip_ent_idn"),
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
 	public static ArrayList<obj_dos_campos> muestra_comunas() {
 		ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
 		Connection c=null;
 		try {
 			String sql;
 			c = conexion_odbc.Connexion_datos();
 			sql = "select * from segunda_division_politica where len(seg_div_pol_cod_area) > 2 " ;
 			CallableStatement ps = c.prepareCall(sql);
 			ResultSet rs = ps.executeQuery();
 			
 			lista.add(new obj_dos_campos("Tel. Móvil", "(09)")); 
 			
 			while (rs.next()){

 				lista.add(new obj_dos_campos(	rs.getString("seg_div_pol_nombre"),
 												rs.getString("seg_div_pol_cod_area")));
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
 	public static ArrayList<obj_dos_campos> muestra_requisitos() {
 		ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
 		Connection c=null;
 		try {
 			String sql;
 			c = conexion_odbc.Connexion_datos();
 			sql = "select req_ing_idn , req_ing_nombre  " ;
 			sql = sql + "from requisito_ingreso " ;
 			sql = sql + "order by req_ing_idn asc" ;

 			CallableStatement ps = c.prepareCall(sql);
 			ResultSet rs = ps.executeQuery();
 			while (rs.next()){

 				lista.add(new obj_dos_campos(  rs.getString("req_ing_idn"),
 						rs.getString("req_ing_nombre")));
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
     public static ArrayList<obj_dos_campos> muestra_pais () {
         ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "select * from pais";
            CallableStatement ps = c.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            
            
             while (rs.next()){
            
                lista.add(new obj_dos_campos(rs.getString("pais_idn"),
                                             rs.getString("pais_nombre")));
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
     public static ArrayList<obj_dos_campos> muestra_nacionalidad () {
         ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "select * from pais" ;
            CallableStatement ps = c.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            
            lista.add(new obj_dos_campos("0", "-- Seleccione --")); 
            
             while (rs.next()){
            
                lista.add(new obj_dos_campos(rs.getString("pais_idn"),
                                             rs.getString("pais_nombre")));
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
     public static ArrayList<obj_dos_campos> muestra_tipo_telefono() {
         ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "select * from tipo_fonos" ;
            CallableStatement ps = c.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            
            lista.add(new obj_dos_campos("0", "-- Seleccione --")); 
            
             while (rs.next()){
            
                lista.add(new obj_dos_campos(rs.getString("tip_fon_idn"),
                                             rs.getString("tip_fon_nombre")));
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
     public static ArrayList<obj_dos_campos> muestra_tipo_contacto() {
         ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "select * from tipo_antecedentes_electronicos" ;
            CallableStatement ps = c.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            
            lista.add(new obj_dos_campos("0", "-- Seleccione --")); 
            
             while (rs.next()){
            
                lista.add(new obj_dos_campos(rs.getString("tip_ant_ele_idn"),
                                             rs.getString("tip_ant_ele_nombre")));
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
     public static ArrayList<obj_dos_campos> muestra_estado_civil () {
         ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "select * from estado_civil" ;
            CallableStatement ps = c.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            
            lista.add(new obj_dos_campos("0", "-- Seleccione --")); 
            
             while (rs.next()){
            
                lista.add(new obj_dos_campos(rs.getString("est_civil_idn"),
                                             rs.getString("est_civil_nombre")));
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
     public static ArrayList<obj_dos_campos> muestra_tipo_direccion () {
         ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "select * from envio_documentacion" ;
            CallableStatement ps = c.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            
            lista.add(new obj_dos_campos("0", "-- Seleccione --")); 
            
             while (rs.next()){
            
                lista.add(new obj_dos_campos(rs.getString("env_doc_idn"),
                                             rs.getString("env_doc_nombre")));
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
     public static ArrayList<obj_dos_campos> muestra_comuna (String div_pol_idn) {
         ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "select a.seg_div_pol_idn, a.seg_div_pol_nombre ";
            sql = sql + "from segunda_division_politica a, division_politica b ";
            sql = sql + "where a.div_pol_idn = b.div_pol_idn and b.div_pol_idn = '"+div_pol_idn.trim()+"' order by a.seg_div_pol_nombre asc";

            CallableStatement ps = c.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
                lista.add(new obj_dos_campos(rs.getString("seg_div_pol_idn"),
                                             rs.getString("seg_div_pol_nombre")));
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
     public static ArrayList<obj_tres_campos> muestra_regiones (String pais_idn) {
         ArrayList<obj_tres_campos> lista = new ArrayList<obj_tres_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "select distinct b.div_pol_idn, b.div_pol_nombre, d.tip_div_politica_nombre ";
            sql = sql + "from segunda_division_politica a, division_politica b, pais c, tipo_division_politica d ";
            sql = sql + "where a.tip_div_politica_idn = d.tip_div_politica_idn  and a.div_pol_idn = b.div_pol_idn and b.pais_idn = c.pais_idn and b.pais_idn = '"+pais_idn.trim()+"' order by b.div_pol_idn, b.div_pol_nombre, d.tip_div_politica_nombre asc";

            CallableStatement ps = c.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            
            lista.add(new obj_tres_campos("-- Seleccione --", "-- Seleccione --", "-- Seleccione --"));
            
            
            while (rs.next()){
            
                lista.add(new obj_tres_campos(rs.getString("div_pol_idn"),
                                             rs.getString("div_pol_nombre"),
                                             rs.getString("tip_div_politica_nombre")));
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
     public static ArrayList<obj_once_campos> muestra_direcciones (String ent_cod_pais) {
         ArrayList<obj_once_campos> lista = new ArrayList<obj_once_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
             sql = "select a.dir_idn, a.dir_direccion, 	a.dir_numero, 	a.dir_depto, a.dir_referencia, a.dir_cod_zip, b.seg_div_pol_idn,b.seg_div_pol_nombre, c.div_pol_nombre, d.pais_nombre,e.ent_codigo_pais ";
            sql = sql + "from direcciones a, segunda_division_politica b, division_politica c, pais d, entidades e,entidades_registros f,entidades_registros_direcciones g ";
            sql = sql + "where a.seg_div_pol_idn = b. seg_div_pol_idn and b.div_pol_idn = c.div_pol_idn and c.pais_idn = d.pais_idn and e.ent_activa = 1 and e.ent_idn = f.ent_idn and f.ent_reg_idn = g.ent_reg_idn and g.dir_idn = a.dir_idn and e.ent_codigo_pais like '"+ent_cod_pais.trim()+"%'";

            CallableStatement ps = c.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
                lista.add(new obj_once_campos(rs.getString("dir_idn"),
                                             rs.getString("dir_direccion"),
                                             rs.getString("dir_numero"),
                                             rs.getString("dir_depto"),
                                             rs.getString("dir_cod_zip"),
                                             rs.getString("seg_div_pol_idn"),
                                             rs.getString("seg_div_pol_nombre"),
                                             rs.getString("div_pol_nombre"),
                                             rs.getString("pais_nombre"),
                                             rs.getString("ent_codigo_pais"), 
                                             rs.getString("dir_referencia")));
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
     public static ArrayList<obj_once_campos> muestra_direcciones_nombre (String nombre) {
         ArrayList<obj_once_campos> lista = new ArrayList<obj_once_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
             sql = "select a.dir_idn, a.dir_direccion, 	a.dir_numero, 	a.dir_depto, a.dir_referencia, a.dir_cod_zip, b.seg_div_pol_idn,b.seg_div_pol_nombre, c.div_pol_nombre, d.pais_nombre,e.ent_codigo_pais ";
            sql = sql + "from direcciones a, segunda_division_politica b, division_politica c, pais d, entidades e,entidades_registros f,entidades_registros_direcciones g ";
            sql = sql + "where a.seg_div_pol_idn = b. seg_div_pol_idn and b.div_pol_idn = c.div_pol_idn and c.pais_idn = d.pais_idn and e.ent_activa = 1 and e.ent_idn = f.ent_idn and f.ent_reg_idn = g.ent_reg_idn and g.dir_idn = a.dir_idn and e.ent_nombre like '"+nombre.trim()+"%'";

            CallableStatement ps = c.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
                lista.add(new obj_once_campos(rs.getString("dir_idn"),
                                             rs.getString("dir_direccion"),
                                             rs.getString("dir_numero"),
                                             rs.getString("dir_depto"),
                                             rs.getString("dir_cod_zip"),
                                             rs.getString("seg_div_pol_idn"),
                                             rs.getString("seg_div_pol_nombre"),
                                             rs.getString("div_pol_nombre"),
                                             rs.getString("pais_nombre"),
                                             rs.getString("ent_codigo_pais"), 
                                             rs.getString("dir_referencia")));
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
     public static ArrayList<obj_once_campos> muestra_direcciones_apellidos (String apellidos) {
         ArrayList<obj_once_campos> lista = new ArrayList<obj_once_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
             sql = "select a.dir_idn, a.dir_direccion, 	a.dir_numero, 	a.dir_depto, a.dir_referencia, a.dir_cod_zip, b.seg_div_pol_idn,b.seg_div_pol_nombre, c.div_pol_nombre, d.pais_nombre,e.ent_codigo_pais ";
            sql = sql + "from direcciones a, segunda_division_politica b, division_politica c, pais d, entidades e,entidades_registros f,entidades_registros_direcciones g ";
            sql = sql + "where a.seg_div_pol_idn = b. seg_div_pol_idn and b.div_pol_idn = c.div_pol_idn and c.pais_idn = d.pais_idn and e.ent_activa = 1 and e.ent_idn = f.ent_idn and f.ent_reg_idn = g.ent_reg_idn and g.dir_idn = a.dir_idn and e.ent_ap_paterno + ' ' +e.ent_ap_materno like '"+apellidos.trim()+"%'";

            CallableStatement ps = c.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
                lista.add(new obj_once_campos(rs.getString("dir_idn"),
                                             rs.getString("dir_direccion"),
                                             rs.getString("dir_numero"),
                                             rs.getString("dir_depto"),
                                             rs.getString("dir_cod_zip"),
                                             rs.getString("seg_div_pol_idn"),
                                             rs.getString("seg_div_pol_nombre"),
                                             rs.getString("div_pol_nombre"),
                                             rs.getString("pais_nombre"),
                                             rs.getString("ent_codigo_pais"), 
                                             rs.getString("dir_referencia")));
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
     public static ArrayList<obj_un_campo> agrega_direccion 
     (String calle, 
     String numero, 
     String depto,
     String referencia,
     String zipcode, 
     String id_comuna) {
         ArrayList<obj_un_campo> lista = new ArrayList<obj_un_campo>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "insert into direcciones(dir_direccion,dir_numero,dir_depto,dir_referencia,seg_div_pol_idn,dir_cod_zip) values ('"+calle.trim()+"', '"+numero.trim()+"','"+depto.trim()+"','"+referencia.trim()+"','"+id_comuna.trim()+"','"+zipcode.trim()+"') ";
            
            sql = sql + "SELECT SCOPE_IDENTITY() as dir_idn";
            CallableStatement ps = c.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
                        
            while (rs.next())
            {

                lista.add(new obj_un_campo(rs.getString("dir_idn")));
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
     public static ArrayList<obj_un_campo> agrega_educacional 
     (String ant_edu_nombre, 
     String ant_edu_institucion, 
     String ant_edu_fecha_ingreso,
     String ant_edu_fecha_egreso,
     String tip_ant_edu_idn,
     String ent_idn) {
         ArrayList<obj_un_campo> lista = new ArrayList<obj_un_campo>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "insert into antecedentes_educacionales(ant_edu_nombre,ant_edu_institucion,ant_edu_fecha_ingreso,ant_edu_fecha_egreso,tip_ant_edu_idn) values ('"+ant_edu_nombre.trim()+"', '"+ant_edu_institucion.trim()+"','"+ant_edu_fecha_ingreso.trim()+"','"+ant_edu_fecha_egreso.trim()+"','"+tip_ant_edu_idn.trim()+"') ";
            
            sql = sql + "insert into entidades_antecedentes_educacionales(ant_edu_idn, ent_idn, ent_ant_edu_fecha_ingreso) values (SCOPE_IDENTITY(),'"+ent_idn.trim()+"', getdate()) ";
            
            sql = sql + "SELECT SCOPE_IDENTITY() as ent_ant_edu_idn";
            CallableStatement ps = c.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
                        
            while (rs.next())
            {

                lista.add(new obj_un_campo(rs.getString("ent_ant_edu_idn")));
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
     public static ArrayList<obj_un_campo> agrega_laboral 
     (String ant_lab_nombre, 
     String ant_lab_institucion, 
     String ant_lab_fecha_inicio,
     String ant_lab_fecha_fin,
     String ant_lab_descripcion,
     String ent_idn) {
         ArrayList<obj_un_campo> lista = new ArrayList<obj_un_campo>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "insert into antecedentes_laborales(ant_lab_nombre,ant_lab_institucion,ant_lab_fecha_inicio,ant_lab_fecha_fin,ant_lab_descripcion, ant_lab_activo) values ('"+ant_lab_nombre.trim()+"', '"+ant_lab_institucion.trim()+"','"+ant_lab_fecha_inicio.trim()+"','"+ant_lab_fecha_fin.trim()+"','"+ant_lab_descripcion.trim()+"',1) ";
            
            sql = sql + "insert into entidades_antecedentes_laborales(ant_lab_idn, ent_idn, ent_ant_lab_fecha_ingreso) values (SCOPE_IDENTITY(),'"+ent_idn.trim()+"', getdate()) ";
            
            sql = sql + "SELECT SCOPE_IDENTITY() as ent_ant_lab_idn";
            CallableStatement ps = c.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
                        
            while (rs.next())
            {

                lista.add(new obj_un_campo(rs.getString("ent_ant_lab_idn")));
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
     public static ArrayList<obj_un_campo> agrega_requisito 
     (String ent_reg_idn, 
     String req_ing_idn, 
     String ent_req_duracion,
     String ent_req_cantidad,
     String pri_idn) {
         ArrayList<obj_un_campo> lista = new ArrayList<obj_un_campo>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "insert into entidades_requisitos(ent_reg_idn,req_ing_idn,ent_req_fecha_inicio,ent_req_cantidad,ent_req_duracion) values ('"+ent_reg_idn.trim()+"', '"+req_ing_idn.trim()+"',getdate(),'"+ent_req_cantidad.trim()+"','"+ent_req_duracion.trim()+"') ";
            
            sql = sql + "insert into prioridad_requisitos_entidad values (SCOPE_IDENTITY(), '"+pri_idn.trim()+"') ";
            
            sql = sql + "SELECT SCOPE_IDENTITY() as ent_req_idn";
            CallableStatement ps = c.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
                        
            while (rs.next())
            {

                lista.add(new obj_un_campo(rs.getString("ent_req_idn")));
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
 	public static ArrayList<obj_dos_campos> muestra_prioridad() {
 		ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
 		Connection c=null;
 		try {
 			String sql;
 			c = conexion_odbc.Connexion_datos();
 			sql = "select * from prioridad " ;
 			CallableStatement ps = c.prepareCall(sql);
 			ResultSet rs = ps.executeQuery();

 			while (rs.next()){

 				lista.add(new obj_dos_campos(rs.getString("pri_idn"),
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
     public static ArrayList<obj_un_campo> agrega_fono(String ent_idn, String fon_idn) {
         ArrayList<obj_un_campo> lista = new ArrayList<obj_un_campo>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "insert into entidades_fonos(ent_idn,fon_idn,ent_fon_activo,ent_fon_fecha_ingreso) values ('"+ent_idn.trim()+"', '"+fon_idn.trim()+"','1', getdate()) ";
            sql = sql + "SELECT SCOPE_IDENTITY() as ent_fon_idn";
            CallableStatement ps = c.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
                        
            while (rs.next())
            {

                lista.add(new obj_un_campo(rs.getString("ent_fon_idn")));
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
     public static ArrayList<obj_un_campo> agrega_electronico(String ant_ele_idn, String ent_idn) {
         ArrayList<obj_un_campo> lista = new ArrayList<obj_un_campo>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "insert into entidades_antecedentes_electronicos(ant_ele_idn,ent_idn,ant_ele_activo,ent_ant_ele_fecha_ingreso) values ('"+ant_ele_idn.trim()+"', '"+ent_idn.trim()+"','1',getdate()) ";
            sql = sql + "SELECT SCOPE_IDENTITY() as ent_ant_ele_idn";
            CallableStatement ps = c.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
                        
            while (rs.next())
            {

                lista.add(new obj_un_campo(rs.getString("ent_ant_ele_idn")));
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
     public static ArrayList<obj_un_campo> agrega_entidad_registro(String ent_idn, String tip_ent_idn) {
         ArrayList<obj_un_campo> lista = new ArrayList<obj_un_campo>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "insert into entidades_registros(ent_idn,tip_ent_idn,ent_reg_activa) values ('"+ent_idn.trim()+"', '"+tip_ent_idn.trim()+"','1') ";
            sql = sql + "SELECT SCOPE_IDENTITY() as ent_reg_idn";
            CallableStatement ps = c.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
                        
            while (rs.next())
            {

                lista.add(new obj_un_campo(rs.getString("ent_reg_idn")));
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
     public static ArrayList<obj_un_campo> agrega_entidad_registro_envio(String ent_reg_idn, String ent_reg_dir_idn, String env_doc_idn,  String env_por_defecto) {
         ArrayList<obj_un_campo> lista = new ArrayList<obj_un_campo>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "insert into entidades_registros_envios(ent_reg_idn,ent_reg_dir_idn,env_doc_idn,ent_reg_env_activo,ent_reg_env_defecto) values ('"+ent_reg_idn.trim()+"', '"+ent_reg_dir_idn.trim()+"', '"+env_doc_idn.trim()+"','1','"+env_por_defecto.trim()+"') ";
            sql = sql + "SELECT SCOPE_IDENTITY() as ent_reg_env_idn";
            CallableStatement ps = c.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
                        
            while (rs.next())
            {

                lista.add(new obj_un_campo(rs.getString("ent_reg_env_idn")));
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
     public static ArrayList<obj_tres_campos> agrega_registro_direccion(String ent_reg_idn, String dir_idn, String env_doc_idn, String env_por_defecto) {
         ArrayList<obj_tres_campos> lista = new ArrayList<obj_tres_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "insert into entidades_registros_direcciones(ent_reg_idn,dir_idn,dir_activa,ent_reg_dir_fecha_ingreso) values ('"+ent_reg_idn.trim()+"', '"+dir_idn.trim()+"','1',getdate()) ";
            sql = sql + "SELECT SCOPE_IDENTITY() as ent_reg_dir_idn";
            CallableStatement ps = c.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
                        
            while (rs.next())
            {

                lista.add(new obj_tres_campos(rs.getString("ent_reg_dir_idn"), env_doc_idn, env_por_defecto));
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
     public static ArrayList<obj_un_campo> agrega_entidad_persona 
     (String cod_pais, 
     String ap_paterno, 
     String ap_materno, 
     String nombre,
     String fecha_ingreso, 
     String usuario, 
     String password, 
     String fecha_nac, 
     String nacionalidad, 
     String sexo, 
     String estado_civil,
     String estado_foto) {
         ArrayList<obj_un_campo> lista = new ArrayList<obj_un_campo>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "SET DATEFORMAT dmy ";
            sql = sql + "insert into entidades(ent_codigo_pais,ent_ap_paterno,ent_ap_materno,ent_nombre,ent_fecha_ingreso,ent_usuario,ent_password,ent_fecha_nacimiento,ent_nacionalidad,ent_sexo,ent_est_civil_idn,ent_activa,ent_foto) values ('"+cod_pais.trim()+"', '"+ap_paterno.trim()+"','"+ap_materno.trim()+"','"+nombre.trim()+"','"+fecha_ingreso.trim()+"','"+usuario.trim()+"','"+password.trim()+"','"+fecha_nac.trim()+"','"+nacionalidad.trim()+"','"+sexo.trim()+"','"+estado_civil.trim()+"',1, "+estado_foto.trim()+") ";
            sql = sql + "SELECT SCOPE_IDENTITY() as ent_idn";
            CallableStatement ps = c.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
                        
            while (rs.next())
            {

                lista.add(new obj_un_campo(rs.getString("ent_idn")));
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
     public static ArrayList<obj_un_campo> agrega_entidad_empresa 
     (String cod_pais, 
     String nombre,
     String fecha_ingreso, 
     String usuario, 
     String password,
     String nacionalidad,
     String estado_foto) {
         ArrayList<obj_un_campo> lista = new ArrayList<obj_un_campo>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "SET DATEFORMAT dmy ";
            sql = sql + "insert into entidades(ent_codigo_pais,ent_ap_paterno,ent_ap_materno,ent_nombre,ent_fecha_ingreso,ent_usuario,ent_password,ent_fecha_nacimiento,ent_nacionalidad,ent_sexo,ent_est_civil_idn,ent_activa, ent_foto) values ('"+cod_pais.trim()+"', null,null,'"+nombre.trim()+"','"+fecha_ingreso.trim()+"','"+usuario.trim()+"','"+password.trim()+"',null,'"+nacionalidad.trim()+"',null,null,1, "+estado_foto.trim()+") ";
            sql = sql + "SELECT SCOPE_IDENTITY() as ent_idn";
            CallableStatement ps = c.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
                        
            while (rs.next())
            {

                lista.add(new obj_un_campo(rs.getString("ent_idn")));
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
     public static ArrayList<obj_un_campo> agrega_telefono (String cod_area, String numero, String tipo_fono) {
         ArrayList<obj_un_campo> lista = new ArrayList<obj_un_campo>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "insert into fonos(fon_area,fon_numero,tip_fon_idn) values ('"+cod_area.trim()+"', '"+numero.trim()+"','"+tipo_fono.trim()+"') ";
            sql = sql + "SELECT SCOPE_IDENTITY() as fon_idn";
            CallableStatement ps = c.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
                        
            while (rs.next())
            {

                lista.add(new obj_un_campo(rs.getString("fon_idn")));
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
     public static ArrayList<obj_un_campo> agrega_contacto (String detalle, String tipo_contacto) {
         ArrayList<obj_un_campo> lista = new ArrayList<obj_un_campo>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "insert into antecedentes_electronicos(ant_ele_nombre,tip_ant_ele_idn) values ('"+detalle.trim()+"', '"+tipo_contacto.trim()+"') ";
            sql = sql + "SELECT SCOPE_IDENTITY() as ant_ele_idn";
            CallableStatement ps = c.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
                        
            while (rs.next())
            {

                lista.add(new obj_un_campo(rs.getString("ant_ele_idn")));
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
     public static ArrayList<?> elimina_datos (String ent_idn) {
         ArrayList<?> lista = new ArrayList<Object>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "delete entidades_registros_envios where ent_reg_idn in (select ent_reg_idn from entidades_registros where ent_idn = '"+ent_idn.trim()+"') ";
            sql = sql + "delete entidades_requisitos where ent_reg_idn in (select ent_reg_idn from entidades_registros where ent_idn = '"+ent_idn.trim()+"') ";
            sql = sql + "delete entidades_registros_direcciones where ent_reg_idn in (select ent_reg_idn from entidades_registros where ent_idn = '"+ent_idn.trim()+"') ";
            sql = sql + "delete entidades_registros where ent_idn = '"+ent_idn.trim()+"'" ;
            sql = sql + "delete entidades_fonos where ent_idn = '"+ent_idn.trim()+"'" ;
            sql = sql + "delete entidades_antecedentes_electronicos where ent_idn = '"+ent_idn.trim()+"'" ;
            sql = sql + "delete entidades where ent_idn = '"+ent_idn.trim()+"'" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.executeQuery();
           
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
     
     
    /** Creates a new instance of frm_registro_admision_ingreso_registro */
    public frm_registro_admision_ingreso_registro() {
    }
    
}
