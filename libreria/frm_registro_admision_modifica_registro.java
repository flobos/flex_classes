/*
 * frm_registro_admision_modifica_registro.java
 *
 * Created on 26 de agosto de 2010, 03:08 PM
 */

package libreria;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author  Cristian
 */
public class frm_registro_admision_modifica_registro {
    
    public static ArrayList<?> modifica_entidad_persona 
     (String ent_idn,
     String cod_pais, 
     String ap_paterno, 
     String ap_materno, 
     String nombre,
     String usuario, 
     String password, 
     String fecha_nac, 
     String nacionalidad, 
     String sexo, 
     String estado_civil,
     String estado_foto) {
         ArrayList<?> lista = new ArrayList<Object>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "SET DATEFORMAT dmy ";
            sql = sql + "update entidades set ent_codigo_pais = '"+cod_pais.trim()+"',ent_ap_paterno = '"+ap_paterno.trim()+"',ent_ap_materno = '"+ap_materno.trim()+"',ent_nombre = '"+nombre.trim()+"',ent_usuario = '"+usuario.trim()+"',ent_password = '"+password.trim()+"',ent_fecha_nacimiento= '"+fecha_nac.trim()+"',ent_nacionalidad =  '"+nacionalidad.trim()+"',ent_sexo = '"+sexo.trim()+"',ent_est_civil_idn ='"+estado_civil.trim()+"',ent_foto ="+estado_foto.trim()+" ";
            sql = sql + "where ent_idn = '"+ent_idn.trim()+"'";
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
    
  //******************************************************************************************************************************************************    
	public static ArrayList<obj_ocho_campos> busca_requisitos(String ent_reg_idn) {
		ArrayList<obj_ocho_campos> lista = new ArrayList<obj_ocho_campos>();
		Connection c=null;
		try {
			String sql;
			c = conexion_odbc.Connexion_datos();
			sql = "select b.ent_req_idn, c.req_ing_idn, c.req_ing_nombre, b.ent_req_fecha_inicio,  b.ent_req_duracion, b.ent_req_cantidad, e.pri_idn, e.pri_nombre   " ;
			sql = sql + "from entidades_registros a, entidades_requisitos b, requisito_ingreso c, prioridad_requisitos_entidad d, prioridad e " ;
			sql = sql + "where a.ent_reg_idn = b.ent_reg_idn and b.req_ing_idn = c.req_ing_idn and d.pri_idn = e.pri_idn and d.ent_req_idn = b.ent_req_idn and a.ent_reg_idn = "+ ent_reg_idn.trim() + " " ;
			sql = sql + "order by b.ent_req_idn asc" ;

			CallableStatement ps = c.prepareCall(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()){

				lista.add(new obj_ocho_campos(  rs.getString("ent_req_idn"),
						rs.getString("req_ing_idn"),
						rs.getString("req_ing_nombre"),
						rs.getString("ent_req_fecha_inicio"),
						rs.getString("ent_req_duracion"),
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
    public static ArrayList<obj_un_campo> quitar_educacional 
    (String ant_edu_idn 
    ) {
        ArrayList<obj_un_campo> lista = new ArrayList<obj_un_campo>();
       Connection c=null;
        try {
           String sql;
           c = conexion_odbc.Connexion_datos();
           sql = "delete entidades_antecedentes_educacionales where ant_edu_idn = '"+ant_edu_idn.trim()+"' ";
           sql = sql + "delete antecedentes_educacionales where ant_edu_idn = '"+ant_edu_idn.trim()+"' ";
           
           CallableStatement ps = c.prepareCall(sql);
           ResultSet rs = ps.executeQuery();
                       
           while (rs.next())
           {

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
    public static ArrayList<obj_un_campo> quitar_laboral 
    (String ant_lab_idn 
    ) {
        ArrayList<obj_un_campo> lista = new ArrayList<obj_un_campo>();
       Connection c=null;
        try {
           String sql;
           c = conexion_odbc.Connexion_datos();
           sql = "delete entidades_antecedentes_laborales where ant_lab_idn = '"+ant_lab_idn.trim()+"' ";
           sql = sql + "delete antecedentes_laborales where ant_lab_idn = '"+ant_lab_idn.trim()+"' ";
           
           CallableStatement ps = c.prepareCall(sql);
           ResultSet rs = ps.executeQuery();
                       
           while (rs.next())
           {

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
           sql = "insert into antecedentes_laborales(ant_lab_nombre,ant_lab_institucion,ant_lab_fecha_inicio,ant_lab_fecha_fin,ant_lab_descripcion) values ('"+ant_lab_nombre.trim()+"', '"+ant_lab_institucion.trim()+"','"+ant_lab_fecha_inicio.trim()+"','"+ant_lab_fecha_fin.trim()+"','"+ant_lab_descripcion.trim()+"') ";
           
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
	public static ArrayList<obj_ocho_campos> busca_educacionales(String ent_idn) {
		ArrayList<obj_ocho_campos> lista = new ArrayList<obj_ocho_campos>();
		Connection c=null;
		try {
			String sql;
			c = conexion_odbc.Connexion_datos();
			sql = "select a.ent_ant_edu_idn, b.ant_edu_idn, b.ant_edu_nombre, b.ant_edu_institucion,  c.tip_ant_edu_idn, c.tip_ant_edu_nombre, b.ant_edu_fecha_ingreso, b.ant_edu_fecha_egreso " ;
			sql = sql + "from entidades_antecedentes_educacionales a, antecedentes_educacionales b, tipo_antecedente_educacional c " ;
			sql = sql + "where a.ant_edu_idn = b.ant_edu_idn and b.tip_ant_edu_idn = c.tip_ant_edu_idn and a.ent_idn = "+ ent_idn.trim() + " " ;
			sql = sql + "order by a.ent_ant_edu_idn asc" ;

			CallableStatement ps = c.prepareCall(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()){

				lista.add(new obj_ocho_campos(
						rs.getString("ant_edu_nombre"),
						rs.getString("ant_edu_institucion"),
						rs.getString("tip_ant_edu_idn"),
						rs.getString("tip_ant_edu_nombre"),
						rs.getString("ant_edu_fecha_ingreso"),
						rs.getString("ant_edu_fecha_egreso"),
						rs.getString("ent_ant_edu_idn"),
						rs.getString("ant_edu_idn")));
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
	public static ArrayList<obj_siete_campos> busca_laborales(String ent_idn) {
		ArrayList<obj_siete_campos> lista = new ArrayList<obj_siete_campos>();
		Connection c=null;
		try {
			String sql;
			c = conexion_odbc.Connexion_datos();
			sql = "select a.ent_ant_lab_idn, b.ant_lab_idn, b.ant_lab_nombre, b.ant_lab_institucion, b.ant_lab_fecha_inicio, b.ant_lab_fecha_fin, b.ant_lab_descripcion " ;
			sql = sql + "from entidades_antecedentes_laborales a, antecedentes_laborales b " ;
			sql = sql + "where a.ant_lab_idn = b.ant_lab_idn and a.ent_idn = "+ ent_idn.trim() + " " ;
			sql = sql + "order by a.ent_ant_lab_idn asc" ;

			CallableStatement ps = c.prepareCall(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()){

				lista.add(new obj_siete_campos(
						rs.getString("ent_ant_lab_idn"),
						rs.getString("ant_lab_idn"),
						rs.getString("ant_lab_nombre"),
						rs.getString("ant_lab_institucion"),
						rs.getString("ant_lab_fecha_inicio"),
						rs.getString("ant_lab_fecha_fin"),
						rs.getString("ant_lab_descripcion")));
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
     public static ArrayList<?> modifica_entidad_empresa 
     (String ent_idn,
     String cod_pais, 
     String nombre,
     String usuario, 
     String password,
     String estado_foto) {
         ArrayList<?> lista = new ArrayList<Object>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "SET DATEFORMAT dmy ";
            sql = sql + "update entidades set ent_codigo_pais = '"+cod_pais.trim()+"',ent_nombre = '"+nombre.trim()+"',ent_usuario = '"+usuario.trim()+"',ent_password = '"+password.trim()+"',ent_foto = "+estado_foto.trim()+" ";
            sql = sql + "where ent_idn = '"+ent_idn.trim()+"'";
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
    
  
     
    //******************************************************************************************************************************************************    
     public static ArrayList<obj_cinco_campos> busca_entidades (String ent_cod_pais) {
         ArrayList<obj_cinco_campos> lista = new ArrayList<obj_cinco_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
             sql = "select a.ent_idn,a.ent_codigo_pais,CASE b.tip_ent_idn WHEN 1 THEN cast (a.ent_nombre + ' ' + a.ent_ap_paterno + ' ' + a.ent_ap_materno as VARCHAR(400)) 	ELSE a.ent_nombre END as ent_nombre, b.ent_reg_idn, c.tip_ent_nombre ";
            sql = sql + "from entidades a, entidades_registros b, tipo_entidades c ";
            sql = sql + "where a.ent_idn = b.ent_idn and	b.tip_ent_idn = c.tip_ent_idn and a.ent_activa = 1 and	b.ent_reg_activa = 1 and a.ent_codigo_pais ='"+ent_cod_pais.trim()+"'";

            CallableStatement ps = c.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
                lista.add(new obj_cinco_campos(rs.getString("ent_idn"),
                                             rs.getString("ent_nombre"),
                                             rs.getString("ent_reg_idn"),
                                             rs.getString("tip_ent_nombre"),
                                             rs.getString("ent_codigo_pais")));
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
     public static ArrayList<obj_cinco_campos> busca_entidades_nombre (String ent_param, String tipo_busqueda) {
         ArrayList<obj_cinco_campos> lista = new ArrayList<obj_cinco_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "";
            System.out.println("\n\n\n"+ tipo_busqueda.trim()+ "\n\n\n");
            if (tipo_busqueda.trim().equals("0"))
            {
            	sql = "select a.ent_idn,a.ent_codigo_pais,CASE b.tip_ent_idn WHEN 1 THEN cast (a.ent_nombre + ' ' + a.ent_ap_paterno + ' ' + a.ent_ap_materno as VARCHAR(400)) 	ELSE a.ent_nombre END as ent_nombre, b.ent_reg_idn, c.tip_ent_nombre ";
            	sql = sql + "from entidades a, entidades_registros b, tipo_entidades c ";
            	sql = sql + "where a.ent_idn = b.ent_idn and	b.tip_ent_idn = c.tip_ent_idn and a.ent_activa = 1 and	b.ent_reg_activa = 1 and lower(a.ent_nombre) like '%"+ent_param.toLowerCase().trim()+"%'";

            }
            else
            {
            	sql = "select a.ent_idn,a.ent_codigo_pais,CASE b.tip_ent_idn WHEN 1 THEN cast (a.ent_nombre + ' ' + a.ent_ap_paterno + ' ' + a.ent_ap_materno as VARCHAR(400)) 	ELSE a.ent_nombre END as ent_nombre, b.ent_reg_idn, c.tip_ent_nombre ";
                sql = sql + "from entidades a, entidades_registros b, tipo_entidades c ";
                sql = sql + "where a.ent_idn = b.ent_idn and	b.tip_ent_idn = c.tip_ent_idn and a.ent_activa = 1 and	b.ent_reg_activa = 1 and lower(a.ent_ap_paterno) like '%"+ent_param.toLowerCase().trim()+"%'";

            }
           
            CallableStatement ps = c.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
                lista.add(new obj_cinco_campos(rs.getString("ent_idn"),
                                             rs.getString("ent_nombre"),
                                             rs.getString("ent_reg_idn"),
                                             rs.getString("tip_ent_nombre"),
                                             rs.getString("ent_codigo_pais")));
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
     public static ArrayList<obj_cinco_campos> busca_entidad (String ent_cod_pais, String ent_reg_idn) {
         ArrayList<obj_cinco_campos> lista = new ArrayList<obj_cinco_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
             sql = "select a.ent_idn,a.ent_foto,CASE b.tip_ent_idn WHEN 1 THEN cast (a.ent_nombre + ' ' + a.ent_ap_paterno + ' ' + a.ent_ap_materno as VARCHAR(400)) 	ELSE a.ent_nombre END as ent_nombre, b.ent_reg_idn, c.tip_ent_nombre ";
            sql = sql + "from entidades a, entidades_registros b, tipo_entidades c ";
            sql = sql + "where a.ent_idn = b.ent_idn and	b.tip_ent_idn = c.tip_ent_idn and a.ent_activa = 1 and	b.ent_reg_activa = 1 and a.ent_codigo_pais ='"+ent_cod_pais.trim()+"' and b.ent_reg_idn = '"+ent_reg_idn.trim()+"' ";

            CallableStatement ps = c.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
                lista.add(new obj_cinco_campos(rs.getString("ent_idn"),
                                             rs.getString("ent_nombre"),
                                             rs.getString("ent_reg_idn"),
                                             rs.getString("tip_ent_nombre"),
                                             rs.getString("ent_foto")));
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
     public static ArrayList<obj_cinco_campos> busca_fonos (String ent_idn) {
         ArrayList<obj_cinco_campos> lista = new ArrayList<obj_cinco_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
             sql = "select c.fon_idn, c.fon_area, c.fon_numero, d.tip_fon_nombre, CASE b.ent_fon_activo WHEN 1 THEN 'Activo' ELSE 'Inactivo' END as ent_fon_activo ";
            sql = sql + "from entidades a, entidades_fonos b, fonos c, tipo_fonos d ";
            sql = sql + "where a.ent_idn = b.ent_idn and b.fon_idn = c.fon_idn and c.tip_fon_idn = d.tip_fon_idn and a.ent_idn ='"+ent_idn.trim()+"'";

            CallableStatement ps = c.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
                lista.add(new obj_cinco_campos(rs.getString("fon_idn"),
                                             rs.getString("fon_area"),
                                             rs.getString("fon_numero"),
                                             rs.getString("tip_fon_nombre"),
                                             rs.getString("ent_fon_activo")));
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
     public static ArrayList<?> elimina_telefono (String fon_idn) {
         ArrayList<?> lista = new ArrayList<Object>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "update  entidades_fonos set ent_fon_activo = 0, ent_fon_fecha_desactiva = getdate() where fon_idn ='"+fon_idn.trim()+"' ";
            
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
     public static ArrayList<?> elimina_direccion (String ent_reg_idn,String dir_idn) {
         ArrayList<?> lista = new ArrayList<Object>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
             sql = "declare @ent_reg_dir_idn as numeric(18) ";
            sql = sql + "select @ent_reg_dir_idn = ent_reg_dir_idn from entidades_registros_direcciones where ent_reg_idn = '"+ent_reg_idn.trim()+"' and dir_idn = '"+dir_idn.trim()+"' ";
            sql = sql + "update entidades_registros_envios set ent_reg_env_activo = 0 where ent_reg_dir_idn = @ent_reg_dir_idn ";
            sql = sql + "update entidades_registros_direcciones set dir_activa = 0, ent_reg_dir_fecha_desactiva = getdate() where ent_reg_dir_idn = @ent_reg_dir_idn ";

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
     public static ArrayList<?> activa_direccion (String ent_reg_idn,String dir_idn) {
         ArrayList<?> lista = new ArrayList<Object>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
             sql = "declare @ent_reg_dir_idn as numeric(18) ";
            sql = sql + "select @ent_reg_dir_idn = ent_reg_dir_idn from entidades_registros_direcciones where ent_reg_idn = '"+ent_reg_idn.trim()+"' and dir_idn = '"+dir_idn.trim()+"' ";
            sql = sql + "update entidades_registros_envios set ent_reg_env_activo = 1 where ent_reg_dir_idn = @ent_reg_dir_idn ";
            sql = sql + "update entidades_registros_direcciones set dir_activa = 1 where ent_reg_dir_idn = @ent_reg_dir_idn ";

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
     public static ArrayList<?> establece_direccion_default (String dir_idn,String ent_reg_idn) {
         ArrayList<?> lista = new ArrayList<Object>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
             sql = "declare @ent_reg_dir_idn as numeric(18) "; 
            sql = sql + "select @ent_reg_dir_idn = ent_reg_dir_idn from entidades_registros_direcciones where ent_reg_idn = '"+ent_reg_idn.trim()+"' and dir_idn = '"+dir_idn.trim()+"' ";
            sql = sql + "update entidades_registros_envios set ent_reg_env_defecto = 0 where ent_reg_idn = '"+ent_reg_idn.trim()+"' ";
            sql = sql + "update entidades_registros_envios set ent_reg_env_defecto = 1 where ent_reg_dir_idn = @ent_reg_dir_idn and ent_reg_env_activo = 1";

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
     public static ArrayList<?> elimina_electronico (String ele_idn) {
         ArrayList<?> lista = new ArrayList<Object>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "update  entidades_antecedentes_electronicos set ant_ele_activo = 0, ent_ant_ele_fecha_desactiva = getdate() where ant_ele_idn ='"+ele_idn.trim()+"' ";
            
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
     public static ArrayList<obj_cuatro_campos> busca_electronicos (String ent_idn) {
         ArrayList<obj_cuatro_campos> lista = new ArrayList<obj_cuatro_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
             sql = "select c.ant_ele_idn, c.ant_ele_nombre, d.tip_ant_ele_nombre, CASE b.ant_ele_activo WHEN 1 THEN 'Activo' ELSE 'Inactivo' END as ant_ele_activo ";
            sql = sql + "from entidades a, entidades_antecedentes_electronicos b, antecedentes_electronicos c, tipo_antecedentes_electronicos d ";
            sql = sql + "where a.ent_idn = b.ent_idn and b.ant_ele_idn = c.ant_ele_idn and c.tip_ant_ele_idn = d.tip_ant_ele_idn and a.ent_idn ='"+ent_idn.trim()+"'";

            CallableStatement ps = c.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
                lista.add(new obj_cuatro_campos(rs.getString("ant_ele_idn"),
                                             rs.getString("ant_ele_nombre"),
                                             rs.getString("tip_ant_ele_nombre"),
                                             rs.getString("ant_ele_activo")));
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
     public static ArrayList<obj_diez_campos> busca_datos_personales (String ent_reg_idn) {
         ArrayList<obj_diez_campos> lista = new ArrayList<obj_diez_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "select a.ent_nombre, a.ent_ap_paterno, a.ent_ap_materno, a.ent_codigo_pais, a.ent_usuario, a.ent_password, cast(cast(day(a.ent_fecha_nacimiento) as varchar(2)) +'-'+ cast(month(a.ent_fecha_nacimiento) as varchar(2))+'-'+ cast(year(a.ent_fecha_nacimiento)as varchar(4)) as varchar(10))as ent_fecha_nacimiento , a.ent_nacionalidad, a.ent_sexo, a.ent_est_civil_idn ";
            sql = sql + "from entidades a, entidades_registros b ";
            sql = sql + "where a.ent_idn = b.ent_idn and b.ent_reg_idn = '"+ent_reg_idn.trim()+"'";

            CallableStatement ps = c.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
                lista.add(new obj_diez_campos(rs.getString("ent_nombre"),
                                             rs.getString("ent_ap_paterno"),
                                             rs.getString("ent_ap_materno"),
                                             rs.getString("ent_codigo_pais"),
                                             rs.getString("ent_usuario"),
                                             rs.getString("ent_password"),
                                             rs.getString("ent_fecha_nacimiento"),
                                             rs.getString("ent_nacionalidad"),
                                             rs.getString("ent_sexo"),
                                             rs.getString("ent_est_civil_idn")));
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
     public static ArrayList<obj_un_campo> quitar_requisito 
     (String ent_req_idn 
     ) {
         ArrayList<obj_un_campo> lista = new ArrayList<obj_un_campo>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "delete entidades_requisitos where ent_req_idn = '"+ent_req_idn.trim()+"' ";
            
            CallableStatement ps = c.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
                        
            while (rs.next())
            {

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
     public static ArrayList<?> agrega_direccion(String ent_reg_idn,String dir_idn, String env_doc_idn,  String env_por_defecto) {
         ArrayList<?> lista = new ArrayList<Object>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            
            sql = "declare @ent_reg_dir_idn as varchar(18) ";
            sql = sql + "insert into entidades_registros_direcciones(ent_reg_idn,dir_idn,dir_activa,ent_reg_dir_fecha_ingreso) values ('"+ent_reg_idn.trim()+"', '"+dir_idn.trim()+"','1', getdate()) ";
            sql = sql + "select @ent_reg_dir_idn=SCOPE_IDENTITY() ";
            sql = sql + "insert into entidades_registros_envios(ent_reg_idn,ent_reg_dir_idn,env_doc_idn,ent_reg_env_activo,ent_reg_env_defecto) values ('"+ent_reg_idn.trim()+"', @ent_reg_dir_idn, '"+env_doc_idn.trim()+"','1','"+env_por_defecto.trim()+"') ";
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
     
     
     //******************************************************************************************************************************************************    
     public static ArrayList<obj_quince_campos> busca_direcciones (String ent_reg_idn) {
         ArrayList<obj_quince_campos> lista = new ArrayList<obj_quince_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "select a.dir_idn, a.dir_direccion, CASE c.dir_activa WHEN 1 THEN 'Activa' ELSE 'Inactiva' END as dir_activa, a.dir_numero, a.dir_depto, a.dir_referencia, b.seg_div_pol_idn, b.seg_div_pol_nombre, e.div_pol_nombre, f.pais_nombre, a.dir_cod_zip, g.env_doc_idn, d.env_doc_nombre, CASE g.ent_reg_env_defecto WHEN 1 THEN 'SI' ELSE 'NO' END as env_defecto, c.ent_reg_dir_idn ";
            sql = sql + "from direcciones a, segunda_division_politica b, entidades_registros_direcciones c, envio_documentacion d, division_politica e, pais f, entidades_registros_envios g ";
            sql = sql + "where a.seg_div_pol_idn = b.seg_div_pol_idn and b.div_pol_idn = e.div_pol_idn and e.pais_idn = f.pais_idn and a.dir_idn = c.dir_idn and c.ent_reg_dir_idn = g.ent_reg_dir_idn and g.env_doc_idn = d.env_doc_idn and c.ent_reg_idn = '"+ent_reg_idn.trim()+"' ";
            sql = sql + "order by c.dir_activa asc, g.ent_reg_env_defecto desc ";
            CallableStatement ps = c.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
                lista.add(new obj_quince_campos(rs.getString("dir_idn"),
                                             rs.getString("dir_direccion"),
                                             rs.getString("dir_numero"),
                                             rs.getString("dir_depto"),
                                             rs.getString("seg_div_pol_idn"),
                                             rs.getString("seg_div_pol_nombre"),
                                             rs.getString("div_pol_nombre"),
                                             rs.getString("pais_nombre"),
                                             rs.getString("env_doc_idn"),
                                             rs.getString("env_doc_nombre"),
                                             rs.getString("env_defecto"),
                                             rs.getString("dir_cod_zip"),
                                             rs.getString("ent_reg_dir_idn"),
                                             rs.getString("dir_referencia"),
                                             rs.getString("dir_activa")
                                             ));
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
     
     
    /** Creates a new instance of frm_registro_admision_modifica_registro */
    public frm_registro_admision_modifica_registro() {
    }
    
}
