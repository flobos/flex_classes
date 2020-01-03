package libreria;
import java.util.ArrayList;
import java.sql.*;

public class frm_registro_admision_pagos {
	
	//******************************************************************************************************************************************************    
	public static ArrayList<obj_ocho_campos> busca_deudas(String ent_codigo_pais) {
		ArrayList<obj_ocho_campos> lista = new ArrayList<obj_ocho_campos>();
		Connection c=null;
		try {
			String sql;
			c = conexion_odbc.Connexion_datos();
			
			sql = "{call frm_registro_admision_deudas_muestra_deuda_rut (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, ent_codigo_pais.trim());
            
            ResultSet rs = ps.executeQuery();
            
                        
             while (rs.next()){
            
                lista.add(new obj_ocho_campos(rs.getString("deu_idn"),
                                             rs.getString("car_nombre"),
                                             rs.getString("ent_nombre"),
                                             rs.getString("deu_periodo"),
                                             rs.getString("det_insc_fecha_inscripcion"),
                                             rs.getString("ent_codigo_pais"),
                                             rs.getString("rut_alumno"),
                                             rs.getString("pro_mal_idn")));
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
	public static ArrayList<obj_cinco_campos> busca_deudas_por_alumno(String ent_codigo_pais) {
		ArrayList<obj_cinco_campos> lista = new ArrayList<obj_cinco_campos>();
		Connection c=null;
		try {
			String sql;
			c = conexion_odbc.Connexion_datos();
			
			sql = "{call frm_registro_admision_deudas_muestra_deuda_rut_alumno (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, ent_codigo_pais.trim());
            
            ResultSet rs = ps.executeQuery();
            
                        
             while (rs.next()){
            
                lista.add(new obj_cinco_campos(rs.getString("deu_idn"),
                                             rs.getString("car_nombre"),
                                             rs.getString("ent_nombre"),
                                             rs.getString("deu_periodo"),
                                             rs.getString("det_insc_fecha_inscripcion")));
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
	  public static ArrayList<obj_un_campo> agrega_detalle_orden_pago(String ord_pag_idn, ArrayList<?> medios, String doc_ele_idn ) {
	        
	        ArrayList<obj_un_campo> lista = new ArrayList<obj_un_campo>();
	        Connection c=null;
	        try {
	             String sql;
	             String ent_idn = "";
	             int size = medios.size();
	         libreria.obj_once_campos registro = null;
	                
	            int j;
	            for (j=0; j<size; j++) 
	               {
	                       c = conexion_odbc.Connexion_datos();
	                       registro = (libreria.obj_once_campos)medios.get(j);
	                       System.out.print("as\n");
	                       
	                       if (registro.getcampo_cuatro() != "")
	                       {
	                    	   sql = "if exists (select * from entidades where ent_codigo_pais = '"+registro.getcampo_siete()+"') ";
	                    	   sql = sql + "select ent_idn from entidades where ent_codigo_pais = '"+registro.getcampo_siete()+"' ";
	                    	   sql = sql + "else begin ";
	                    	   sql = sql + "insert into entidades (ent_codigo_pais, ent_ap_paterno, ent_ap_materno, ent_nombre, ent_fecha_ingreso, ent_usuario, ent_password, ent_activa) ";
	                    	   sql = sql + "values ('"+registro.getcampo_siete()+"','"+registro.getcampo_nueve()+"','"+registro.getcampo_diez()+"','"+registro.getcampo_ocho()+"',getdate(),'','',1) ";
	                    	   sql = sql + "SELECT SCOPE_IDENTITY() as ent_idn end ";
	                    	   CallableStatement ps = c.prepareCall(sql);
	                           ResultSet rs = ps.executeQuery();
	                           
	                    	   while (rs.next())
	                           {
			                       ent_idn = rs.getString("ent_idn");
	                           }
	                    	   
	                    	   sql = "insert into detalle_orden_pago(ord_pag_idn,det_ord_pag_valor,med_pag_idn,doc_ele_idn, ban_idn, det_ord_pag_plazo,det_ord_pag_serie,ent_idn ) values ("+ord_pag_idn.trim()+","+registro.getcampo_uno().trim()+", "+registro.getcampo_dos().trim()+","+doc_ele_idn.trim()+",'"+registro.getcampo_cuatro()+"',"+registro.getcampo_cinco()+",'"+registro.getcampo_seis()+"',"+ent_idn.trim()+") ";
	                    	   sql = sql + "SELECT SCOPE_IDENTITY() as det_ord_pag_idn ";
	                    	   CallableStatement ps1 = c.prepareCall(sql);
		                       ResultSet rs1 = ps1.executeQuery();
		                       
		                       
		                       while (rs1.next())
	                           {
		                    	   lista.add(new obj_un_campo(rs1.getString("det_ord_pag_idn")));
	                           }
	                    	   
	                       }
	                       else
	                       {
	                    	   sql = "insert into detalle_orden_pago(ord_pag_idn,det_ord_pag_valor,med_pag_idn,doc_ele_idn ) values ("+ord_pag_idn.trim()+","+registro.getcampo_uno().trim()+", "+registro.getcampo_dos().trim()+","+doc_ele_idn.trim()+") ";
	                    	   sql = sql + "SELECT SCOPE_IDENTITY() as det_ord_pag_idn ";
	                    	   CallableStatement ps1 = c.prepareCall(sql);
		                       ResultSet rs1 = ps1.executeQuery();
		                       
		                       
		                       while (rs1.next())
	                           {
		                    	   lista.add(new obj_un_campo(rs1.getString("det_ord_pag_idn")));
	                           }
	                       }
	                       
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
	  public static ArrayList<obj_un_campo> generar_cargos(ArrayList<?> cargos, String deu_idn ) {
	        
	        ArrayList<obj_un_campo> lista = new ArrayList<obj_un_campo>();
	        Connection c=null;
	        try {
	             String sql;
	             int size = cargos.size();
	         libreria.obj_dos_campos registro = null;
	                
	            int j;
	            for (j=0; j<size; j++) 
	               {
	                       c = conexion_odbc.Connexion_datos();
	                       registro = (libreria.obj_dos_campos)cargos.get(j);
	                       
	                       sql = "insert into detalle_operaciones (deu_idn, det_ope_valor, tip_mov_idn, tip_ope_idn, det_ope_fecha_inicio_pago, det_ope_cuotas, det_ope_dia_vencimiento, det_ope_fecha_ingreso) values (" + deu_idn.trim()+", "+registro.getlabel()+",1,"+registro.getdata()+",getdate(),0,0,getdate()) ";
	                       
	                       sql = sql + "SELECT SCOPE_IDENTITY() as det_ope_idn";
	                       
	                       CallableStatement ps = c.prepareCall(sql);
	                       ResultSet rs = ps.executeQuery();
	                                   
	                       while (rs.next())
	                       {

	                           lista.add(new obj_un_campo(rs.getString("det_ope_idn")));
	                       }
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
	  public static ArrayList<obj_dos_campos> valida_boleta(String boleta ,String rut) {
	         ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
	        Connection c=null;
	         try {
	            String sql;
	            c = conexion_odbc.Connexion_datos();
	            sql = "{call flex_adm_pagos_sedes_valida_existe_boleta (?,?)}" ;
	            CallableStatement ps = c.prepareCall(sql);
	            ps.setString(1, boleta.trim());
	            ps.setString(2, rut.trim());
	            
	            ResultSet rs = ps.executeQuery();
	            
	            while (rs.next()){
	            
	      
	            lista.add(new obj_dos_campos(rs.getString("valida"),
	                                         "validacion"));
	           
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
	  public static ArrayList<obj_dos_campos> valida_boleta_automatica(String rut) {
	         ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
	        Connection c=null;
	         try {
	            String sql;
	            c = conexion_odbc.Connexion_datos();
	            sql = "{call flex_adm_pagos_sedes_valida_existe_boleta_automatica (?)}" ;
	            CallableStatement ps = c.prepareCall(sql);
	            ps.setString(1, rut.trim());
	            
	            ResultSet rs = ps.executeQuery();
	            
	            while (rs.next()){
	            
	      
	            lista.add(new obj_dos_campos(rs.getString("valida"),
	                                         "validacion"));
	           
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
 
	 public static ArrayList<obj_un_campo> agrega_detalle_operacion
     (String deu_idn, 
     String det_ope_valor
     ) {
         ArrayList<obj_un_campo> lista = new ArrayList<obj_un_campo>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "insert into detalle_operaciones (deu_idn, det_ope_valor, tip_mov_idn, tip_ope_idn, det_ope_fecha_inicio_pago, det_ope_cuotas, det_ope_dia_vencimiento, det_ope_fecha_ingreso) values (" + deu_idn.trim()+", "+det_ope_valor.trim()+",0,4,getdate(),0,0,getdate()) ";
            
            sql = sql + "SELECT SCOPE_IDENTITY() as det_ope_idn";
            
            CallableStatement ps = c.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
                        
            while (rs.next())
            {

                lista.add(new obj_un_campo(rs.getString("det_ope_idn")));
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
	 
	 public static ArrayList<obj_un_campo> agrega_detalle_operacion_cargos
     (String deu_idn, 
     String det_ope_valor,
     String tip_mov_idn
     ) {
         ArrayList<obj_un_campo> lista = new ArrayList<obj_un_campo>();
        Connection c=null;
         try {
            String sql;
            
            
            c = conexion_odbc.Connexion_datos();
            sql = "insert into detalle_operaciones (deu_idn, det_ope_valor, tip_mov_idn, tip_ope_idn, det_ope_fecha_inicio_pago, det_ope_cuotas, det_ope_dia_vencimiento, det_ope_fecha_ingreso) values (" + deu_idn.trim()+", "+det_ope_valor.trim()+",0,"+tip_mov_idn.trim()+",getdate(),0,0,getdate()) ";
            
            sql = sql + "SELECT SCOPE_IDENTITY() as det_ope_idn";
            
            CallableStatement ps = c.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
                        
            while (rs.next())
            {

                lista.add(new obj_un_campo(rs.getString("det_ope_idn")));
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
	 
	 public static ArrayList<obj_dos_campos> orden_pago_muestra_banco() {
         ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_pagos_sedes_recauda_muestra_banco}" ;
            CallableStatement ps = c.prepareCall(sql);
           
            ResultSet rs = ps.executeQuery();
            
            lista.add(new obj_dos_campos("0", "--Seleccione--"));
            
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos(rs.getString("ban_idn"),
                                         rs.getString("ban_nombre")));
           
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
	 
	 public static ArrayList<obj_dos_campos> agrega_boleta_electronica
     (String doc_ele_valor, String doc_ele_numero
     ) {
         ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "insert into documento_electronico (doc_ele_fecha_emision, doc_ele_valor, tip_doc_ele_idn, tip_ind_serv_idn,doc_ele_numero ) values (getdate(), "+doc_ele_valor.trim()+",'39','3',"+doc_ele_numero.trim()+" ) ";
            
            sql = sql + "SELECT SCOPE_IDENTITY() as doc_ele_idn";
            
            CallableStatement ps = c.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
                        
            while (rs.next())
            {

                lista.add(new obj_dos_campos(rs.getString("doc_ele_idn"),doc_ele_numero));
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
	 
	 public static ArrayList<obj_un_campo> muestra_boleta_sede
     (String fun_rut
     ) {
         ArrayList<obj_un_campo> lista = new ArrayList<obj_un_campo>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            
            sql = "{call frm_registro_admision_pagos_muestra_boleta_sede (?)}" ;
            
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, fun_rut.trim());
                       
            ResultSet rs = ps.executeQuery();
        
            while (rs.next()){
            
      
            	lista.add(new obj_un_campo(rs.getString("num_boleta")));       
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
	 
	 public static ArrayList<obj_dos_campos> agrega_boleta_electronica_automatica
     (String doc_ele_valor, String fun_rut
     ) {
         ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            String num_boleta = "";
            c = conexion_odbc.Connexion_datos();
            
            sql = "{call frm_registro_admision_pagos_obtiene_boleta_sede (?)}" ;
            
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, fun_rut.trim());
                       
            ResultSet rs = ps.executeQuery();
        
            while (rs.next()){
            
      
            	num_boleta = rs.getString("num_boleta");       
            }
            
            
            
            sql = "insert into documento_electronico (doc_ele_fecha_emision, doc_ele_valor, tip_doc_ele_idn, tip_ind_serv_idn,doc_ele_numero ) values (getdate(), "+doc_ele_valor.trim()+",'39','3',"+num_boleta.trim()+" ) ";
            
            sql = sql + "SELECT SCOPE_IDENTITY() as doc_ele_idn";
            
            CallableStatement ps1 = c.prepareCall(sql);
            ResultSet rs1 = ps1.executeQuery();
                        
            while (rs1.next())
            {

                lista.add(new obj_dos_campos(rs1.getString("doc_ele_idn"), num_boleta));
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
	 
	 public static ArrayList<obj_dos_campos> agrega_orden_pago
     (String det_ope_idn, String func_mod_fun_idn, String det_ope_idn_cargos
     ) {
         ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            String ord_pag_idn = "";
            c = conexion_odbc.Connexion_datos();
            sql = "insert into orden_de_pago (func_mod_fun_idn, ord_pag_fecha_ingreso) values ("+func_mod_fun_idn.toString()+",getdate()) ";
            
            sql = sql + "SELECT SCOPE_IDENTITY() as ord_pag_idn ";
            
            CallableStatement ps = c.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
                        
            while (rs.next())
            {
                ord_pag_idn = rs.getString("ord_pag_idn");
            }
            
            sql = "insert into operaciones_orden_pago (det_ope_idn, ord_pag_idn) values ("+det_ope_idn.trim()+", "+ord_pag_idn.trim()+") ";
            sql = sql + "SELECT SCOPE_IDENTITY() as ope_ord_pag_idn ";
            
            CallableStatement ps1 = c.prepareCall(sql);
            ResultSet rs1 = ps1.executeQuery();
            while (rs1.next())
            {
            	lista.add(new obj_dos_campos(ord_pag_idn, rs1.getString("ope_ord_pag_idn")));
            }
            
            if (!det_ope_idn_cargos.equals(""))
            {
                sql = "insert into operaciones_orden_pago (det_ope_idn, ord_pag_idn) values ("+det_ope_idn_cargos.trim()+", "+ord_pag_idn.trim()+") ";
                sql = sql + "SELECT SCOPE_IDENTITY() as ope_ord_pag_idn ";
                
                CallableStatement ps2 = c.prepareCall(sql);
                ResultSet rs2 = ps2.executeQuery();
                while (rs2.next())
                {
                	lista.add(new obj_dos_campos(ord_pag_idn, rs2.getString("ope_ord_pag_idn")));
                }
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

	 public static ArrayList<obj_un_campo> agrega_glosa_detalle_operacion
     (String det_ope_idn, 
     String des_det_ope_glosa,
     String des_det_ope_valor
     ) {
         ArrayList<obj_un_campo> lista = new ArrayList<obj_un_campo>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "insert into desglose_detalle_operacion (det_ope_idn, des_det_ope_glosa, des_det_ope_valor) values ("+det_ope_idn.trim()+", '"+des_det_ope_glosa.trim()+"',"+des_det_ope_valor.trim()+") ";
            
            sql = sql + "SELECT SCOPE_IDENTITY() as des_det_ope_idn";
            
            CallableStatement ps = c.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
                        
            while (rs.next())
            {

                lista.add(new obj_un_campo(rs.getString("des_det_ope_idn")));
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
	public static ArrayList<obj_seis_campos> busca_operaciones(String deu_idn) {
		ArrayList<obj_seis_campos> lista = new ArrayList<obj_seis_campos>();
		Connection c=null;
		try {
			String sql;
			c = conexion_odbc.Connexion_datos();
			
			sql = "{call frm_registro_admision_deudas_muestra_operaciones_deuda (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, deu_idn.trim());
            
            ResultSet rs = ps.executeQuery();
                        
             while (rs.next()){
            
                lista.add(new obj_seis_campos(rs.getString("det_ope_idn"),
                                             rs.getString("det_ope_fecha_ingreso"),
                                             rs.getString("tip_ope_nombre"),
                                             rs.getString("cobro"),
                                             rs.getString("abono"),
                                             rs.getString("tip_ope_idn")));
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
	public static ArrayList<obj_tres_campos> busca_totales(String deu_idn) {
		ArrayList<obj_tres_campos> lista = new ArrayList<obj_tres_campos>();
		Connection c=null;
		try {
			String sql;
			c = conexion_odbc.Connexion_datos();
			
			sql = "{call frm_registro_admision_deudas_muestra_totales_deuda (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, deu_idn.trim());
            
            ResultSet rs = ps.executeQuery();
                        
             while (rs.next()){
            
                lista.add(new obj_tres_campos(rs.getString("cobros"),
                                             rs.getString("abonos"),
                                             rs.getString("deuda_restante")));
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
	public static ArrayList<obj_dos_campos> muestra_glosa(String det_ope_idn) {
		ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
		Connection c=null;
		try {
			String sql;
			c = conexion_odbc.Connexion_datos();
			
			sql = "select distinct des_det_ope_idn,des_det_ope_glosa, des_det_ope_valor from desglose_detalle_operacion where det_ope_idn = '"+det_ope_idn.trim()+"'  order by des_det_ope_idn asc";
			
			
			
			CallableStatement ps = c.prepareCall(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()){

				lista.add(new obj_dos_campos(rs.getString("des_det_ope_glosa"),
						rs.getString("des_det_ope_valor")));
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
	public static ArrayList<obj_dos_campos> borrar_datos(String det_ope_idn, String det_ope_idn_cargos, String det_ope_idn_cargo) {
		ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
		Connection c=null;
		try {
			String sql;
			c = conexion_odbc.Connexion_datos();
			
			sql = "delete desglose_detalle_operacion where det_ope_idn = "+det_ope_idn.trim()+" ";
			sql = sql + "delete detalle_operaciones where det_ope_idn = "+det_ope_idn.trim()+" ";
			
			if (!det_ope_idn_cargos.equals(""))
			{
				sql = sql + "delete desglose_detalle_operacion where det_ope_idn = "+det_ope_idn_cargos.trim()+" ";
				sql = sql + "delete detalle_operaciones where det_ope_idn = "+det_ope_idn_cargos.trim()+" ";
				sql = sql + "delete desglose_detalle_operacion where det_ope_idn = "+det_ope_idn_cargo.trim()+" ";
				sql = sql + "delete detalle_operaciones where det_ope_idn = "+det_ope_idn_cargo.trim()+" ";
			}
			
			
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
	public static ArrayList<obj_dos_campos> muestra_medios(String det_ope_idn) {
		ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
		Connection c=null;
		try {
			String sql;
			c = conexion_odbc.Connexion_datos();
			
			sql = "select  a.det_ord_pag_valor, d.med_pag_nombre ";
			sql = sql + "from detalle_orden_pago a, operaciones_orden_pago c, medio_de_pago d "; 
			sql = sql + "where a.med_pag_idn = d.med_pag_idn and  a.ord_pag_idn = c.ord_pag_idn and c.det_ope_idn = "+det_ope_idn.trim()+" ";
			sql = sql + "order by a.det_ord_pag_idn asc ";
			
			
			CallableStatement ps = c.prepareCall(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()){

				lista.add(new obj_dos_campos(rs.getString("det_ord_pag_valor"),
						rs.getString("med_pag_nombre")));
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
	public static ArrayList<obj_dos_campos> busca_deuda_mes(String deu_idn) {
		ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
		Connection c=null;
		try {
			String sql;
			c = conexion_odbc.Connexion_datos();
			
			sql = "{call frm_registro_admision_deudas_muestra_deuda_mes (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, deu_idn.trim());
            
            ResultSet rs = ps.executeQuery();
                        
             while (rs.next()){
            
                lista.add(new obj_dos_campos(rs.getString("deuda_al_dia"),rs.getString("cuotas")));
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
	public static ArrayList<obj_dos_campos> busca_medio_pago() {
		ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
		Connection c=null;
		try {
			String sql;
			c = conexion_odbc.Connexion_datos();
			sql = "select * from medio_de_pago" ;
			CallableStatement ps = c.prepareCall(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()){

				lista.add(new obj_dos_campos(rs.getString("med_pag_idn"),
						rs.getString("med_pag_nombre")));
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
	public static ArrayList<obj_dos_campos> busca_concepto_pago() {
		ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
		Connection c=null;
		try {
			String sql;
			c = conexion_odbc.Connexion_datos();
			sql = "select * from tipo_operacion where tip_ope_idn not in (0,4) " ;
			CallableStatement ps = c.prepareCall(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()){

				lista.add(new obj_dos_campos(rs.getString("tip_ope_idn"),
						rs.getString("tip_ope_nombre")));
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
	public static ArrayList<obj_tres_campos> ingreso_detalle_operaciones
	(String deu_idn,
	String det_ope_valor,
	String tip_mov_idn,
	String tip_ope_idn,
	String det_ope_glosa
	) {
	     
	         ArrayList<obj_tres_campos> lista = new ArrayList<obj_tres_campos>();
	        Connection c=null;
	         try {
	            String sql;
	            c = conexion_odbc.Connexion_datos();
	            sql = "insert into detalle_operaciones (deu_idn, det_ope_valor, tip_mov_idn, tip_ope_idn, det_ope_fecha_inicio_pago, det_ope_cuotas, det_ope_dia_vencimiento, det_ope_fecha_ingreso, det_ope_glosa) values ('"+deu_idn.trim()+"', '"+det_ope_valor.trim()+"','"+tip_mov_idn.trim()+"','"+tip_ope_idn.trim()+"',getdate(),0,getdate(), getdate(),'"+det_ope_glosa.trim()+"' ) ";
	            
	            sql = sql + "SELECT SCOPE_IDENTITY() as det_ope_idn";
	            CallableStatement ps = c.prepareCall(sql);
	            ResultSet rs = ps.executeQuery();
	                        
	            while (rs.next())
	            {

	                lista.add(new obj_tres_campos(rs.getString("det_ope_idn"), "", ""));
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
	
	
	
	
	
	
	
	public frm_registro_admision_pagos() {
	}
}
