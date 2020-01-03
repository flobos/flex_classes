/*
 * frm_fise_ingreso_datos.java
 * Created on 1 de diciembre de 2010, 9:13
 */

/**
 *
 * @author  LBaeza
 */
package libreria;
import java.util.ArrayList;
import java.sql.*;
public class frm_fise_ingreso_datos {
    
    /** Creates a new instance of frm_fise_ingreso_datos */
    public frm_fise_ingreso_datos() {
    }
  
    //******************************************************************************************************************************************************    
     public static ArrayList buscar_por_rut (String fun_rut) {
         ArrayList lista = new ArrayList();
        Connection c=null;
         int salida;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
			sql = "{call frm_fise_ingreso_datos_trae_datos(?)}";
                        
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, fun_rut.trim());
            ResultSet rs = ps.executeQuery();
            
             while (rs.next()){
            
                lista.add(new obj_dos_campos(rs.getString("rut"),
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
     public static ArrayList trae_datos_correlativo () {
         ArrayList lista = new ArrayList();
        Connection c=null;
         int salida;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
			sql = "{call frm_fise_ingreso_datos_trae_correlativo()}";
                        
            CallableStatement ps = c.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            
             while (rs.next()){
            
                lista.add(new obj_un_campo(rs.getString("salida")));
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
     public static ArrayList trae_datos_fise (String fun_rut) {
         ArrayList lista = new ArrayList();
        Connection c=null;
         int salida;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
			sql = "{call frm_fise_ingreso_datos_trae_datos_fise(?)}";
                        
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, fun_rut.trim());
            ResultSet rs = ps.executeQuery();
            
             while (rs.next()){
            
                lista.add(new obj_un_campo(rs.getString("tipo_familia")));
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
    
 //**********************************************************
   public static ArrayList llena_combo_becas()
   {
	   ArrayList lista = new ArrayList();
	   Connection c = null;
	   int salida;
	   try
	   {       String sql;
		   c = conexion_odbc.Connexion_datos();
		   sql = "{call frm_fise_ingreso_datos_llena_combo_becas}";
		   CallableStatement ps = c.prepareCall(sql);
		   ResultSet rs = ps.executeQuery();
		   lista.add(new obj_combo_dos_campos("0", "-- Seleccione --"));
		   while (rs.next())
		   {       lista.add(new obj_combo_dos_campos(rs.getString("idn"),
		  	   rs.getString("descripcion")));   }
	   }
	   catch (Exception e)
	   { e.printStackTrace();   }
	   finally
	   {  try
		   { c.close(); }
	      catch (SQLException e)
		   { e.printStackTrace(); }
	   }
	   return lista;
   }

   
 //**********************************************************
   public static ArrayList llena_combo_tipo_propiedad()
   {
	   ArrayList lista = new ArrayList();
	   Connection c = null;
	   int salida;
	   try
	   {       String sql;
		   c = conexion_odbc.Connexion_datos();
		   sql = "{call frm_fise_ingreso_datos_llena_combo_tipo_propiedad}";
		   CallableStatement ps = c.prepareCall(sql);

		   ResultSet rs = ps.executeQuery();
		   lista.add(new obj_combo_dos_campos("0", "-- Seleccione --"));
		   while (rs.next())
		   {       lista.add(new obj_combo_dos_campos(rs.getString("idn"),
		  	   rs.getString("descripcion")));   }
	   }
	   catch (Exception e)
	   { e.printStackTrace();   }
	   finally
	   {  try
		   { c.close(); }
	      catch (SQLException e)
		   { e.printStackTrace(); }
	   }
	   return lista;
   }
   
    //**********************************************************
   public static ArrayList llena_combo_tipo_construccion()
   {
       
       
	   ArrayList lista = new ArrayList();
	   Connection c = null;
	   int salida;
	   try
	   {       String sql;
		   c = conexion_odbc.Connexion_datos();
		   sql = "{call frm_fise_ingreso_datos_llena_combo_tipo_construccion}";
		   CallableStatement ps = c.prepareCall(sql);

		   ResultSet rs = ps.executeQuery();
		   lista.add(new obj_combo_dos_campos("0", "-- Seleccione --"));
		   while (rs.next())
		   {       lista.add(new obj_combo_dos_campos(rs.getString("idn"),
		  	   rs.getString("descripcion")));   }
	   }
	   catch (Exception e)
	   { e.printStackTrace();   }
	   finally
	   {  try
		   { c.close(); }
	      catch (SQLException e)
		   { e.printStackTrace(); }
	   }
	   return lista;
   }
   
      //**********************************************************
   public static ArrayList llena_combo_tenencia_propiedad()
   {
	   ArrayList lista = new ArrayList();
	   Connection c = null;
	   int salida;
	   try
	   {       String sql;
		   c = conexion_odbc.Connexion_datos();
		   sql = "{call frm_fise_ingreso_datos_llena_combo_tenencia_propiedad}";
		   CallableStatement ps = c.prepareCall(sql);

		   ResultSet rs = ps.executeQuery();
		   lista.add(new obj_combo_dos_campos("0", "-- Seleccione --"));
		   while (rs.next())
		   {       lista.add(new obj_combo_dos_campos(rs.getString("idn"),
		  	   rs.getString("descripcion")));   }
	   }
	   catch (Exception e)
	   { e.printStackTrace();   }
	   finally
	   {  try
		   { c.close(); }
	      catch (SQLException e)
		   { e.printStackTrace(); }
	   }
	   return lista;
   } 
   
         //**********************************************************
   public static ArrayList llena_combo_estado_conservacion()
   {
	   ArrayList lista = new ArrayList();
	   Connection c = null;
	   int salida;
	   try
	   {       String sql;
		   c = conexion_odbc.Connexion_datos();
		   sql = "{call frm_fise_ingreso_datos_llena_combo_estado_conservacion}";
		   CallableStatement ps = c.prepareCall(sql);

		   ResultSet rs = ps.executeQuery();
		   lista.add(new obj_combo_dos_campos("0", "-- Seleccione --"));
		   while (rs.next())
		   {       lista.add(new obj_combo_dos_campos(rs.getString("idn"),
		  	   rs.getString("descripcion")));   }
	   }
	   catch (Exception e)
	   { e.printStackTrace();   }
	   finally
	   {  try
		   { c.close(); }
	      catch (SQLException e)
		   { e.printStackTrace(); }
	   }
	   return lista;
   } 
   
     
  //**********************************************************
   public static ArrayList llena_combo_uso()
   {
	   ArrayList lista = new ArrayList();
	   Connection c = null;
	   int salida;
	   try
	   {       String sql;
		   c = conexion_odbc.Connexion_datos();
		   sql = "{call frm_fise_ingreso_datos_llena_combo_uso}";
		   CallableStatement ps = c.prepareCall(sql);

		   ResultSet rs = ps.executeQuery();
		   lista.add(new obj_combo_dos_campos("0", "-- Seleccione --"));
		   while (rs.next())
		   {       lista.add(new obj_combo_dos_campos(rs.getString("idn"),
		  	   rs.getString("descripcion")));   }
	   }
	   catch (Exception e)
	   { e.printStackTrace();   }
	   finally
	   {  try
		   { c.close(); }
	      catch (SQLException e)
		   { e.printStackTrace(); }
	   }
	   return lista;
   } 
   
  //**********************************************************
   public static ArrayList llena_combo_servicios_basicos()
   {
	   ArrayList lista = new ArrayList();
	   Connection c = null;
	   int salida;
	   try
	   {       String sql;
		   c = conexion_odbc.Connexion_datos();
		   sql = "{call frm_fise_ingreso_datos_llena_combo_servicios_basicos}";
		   CallableStatement ps = c.prepareCall(sql);

		   ResultSet rs = ps.executeQuery();
		   lista.add(new obj_combo_dos_campos("0", "-- Seleccione --"));
		   while (rs.next())
		   {       lista.add(new obj_combo_dos_campos(rs.getString("idn"),
		  	   rs.getString("descripcion")));   }
	   }
	   catch (Exception e)
	   { e.printStackTrace();   }
	   finally
	   {  try
		   { c.close(); }
	      catch (SQLException e)
		   { e.printStackTrace(); }
	   }
	   return lista;
   } 
   
   //**********************************************************
   public static ArrayList llena_combo_estado_civil()
   {
	   ArrayList lista = new ArrayList();
	   Connection c = null;
	   int salida;
	   try
	   {   String sql;
		   c = conexion_odbc.Connexion_datos();
		   sql = "{call frm_fise_ingreso_datos_llena_combo_estado_civil}";
		   CallableStatement ps = c.prepareCall(sql);

		   ResultSet rs = ps.executeQuery();
		   lista.add(new obj_combo_dos_campos("0", "-- Seleccione --"));
		   while (rs.next())
		   {       lista.add(new obj_combo_dos_campos(rs.getString("idn"),
		  	   rs.getString("descripcion")));   }
	   }
	   catch (Exception e)
	   { e.printStackTrace();   }
	   finally
	   {  try
		   { c.close(); }
	      catch (SQLException e)
		   { e.printStackTrace(); }
	   }
	   return lista;
   } 
   
   //**********************************************************
   public static ArrayList llena_combo_sexo()
   {
	   ArrayList lista = new ArrayList();
	   Connection c = null;
	   int salida;
	   try
	   {   String sql;
		   c = conexion_odbc.Connexion_datos();
		   sql = "{call frm_fise_ingreso_datos_llena_combo_sexo}";
		   CallableStatement ps = c.prepareCall(sql);

		   ResultSet rs = ps.executeQuery();
		   lista.add(new obj_combo_dos_campos("0", "-- Seleccione --"));
		   while (rs.next())
		   {       lista.add(new obj_combo_dos_campos(rs.getString("idn"),
		  	   rs.getString("descripcion")));   }
	   }
	   catch (Exception e)
	   { e.printStackTrace();   }
	   finally
	   {  try
		   { c.close(); }
	      catch (SQLException e)
		   { e.printStackTrace(); }
	   }
	   return lista;
   } 
   
   //**********************************************************
   public static ArrayList llena_combo_parentesco()
   {
	   ArrayList lista = new ArrayList();
	   Connection c = null;
	   int salida;
	   try
	   {   String sql;
		   c = conexion_odbc.Connexion_datos();
		   sql = "{call frm_fise_ingreso_datos_llena_combo_parentesco}";
		   CallableStatement ps = c.prepareCall(sql);

		   ResultSet rs = ps.executeQuery();
		   lista.add(new obj_combo_dos_campos("0", "-- Seleccione --"));
		   while (rs.next())
		   {       lista.add(new obj_combo_dos_campos(rs.getString("idn"),
		  	   rs.getString("descripcion")));   }
	   }
	   catch (Exception e)
	   { e.printStackTrace();   }
	   finally
	   {  try
		   { c.close(); }
	      catch (SQLException e)
		   { e.printStackTrace(); }
	   }
	   return lista;
   } 
   //**********************************************************
   public static ArrayList llena_combo_nivel_estudios()
   {
	   ArrayList lista = new ArrayList();
	   Connection c = null;
	   int salida;
	   try
	   {   String sql;
		   c = conexion_odbc.Connexion_datos();
		   sql = "{call frm_fise_ingreso_datos_llena_combo_nivel_estudios}";
		   CallableStatement ps = c.prepareCall(sql);

		   ResultSet rs = ps.executeQuery();
		   lista.add(new obj_combo_dos_campos("0", "-- Seleccione --"));
		   while (rs.next())
		   {       lista.add(new obj_combo_dos_campos(rs.getString("idn"),
		  	   rs.getString("descripcion")));   }
	   }
	   catch (Exception e)
	   { e.printStackTrace();   }
	   finally
	   {  try
		   { c.close(); }
	      catch (SQLException e)
		   { e.printStackTrace(); }
	   }
	   return lista;
   } 
   
   //**********************************************************
   public static ArrayList llena_combo_prevision_social()
   {
	   ArrayList lista = new ArrayList();
	   Connection c = null;
	   int salida;
	   try
	   {   String sql;
		   c = conexion_odbc.Connexion_datos();
		   sql = "{call frm_fise_ingreso_datos_llena_combo_prevision_social}";
		   CallableStatement ps = c.prepareCall(sql);

		   ResultSet rs = ps.executeQuery();
		   lista.add(new obj_combo_dos_campos("0", "-- Seleccione --"));
		   while (rs.next())
		   {       lista.add(new obj_combo_dos_campos(rs.getString("idn"),
		  	   rs.getString("descripcion")));   }
	   }
	   catch (Exception e)
	   { e.printStackTrace();   }
	   finally
	   {  try
		   { c.close(); }
	      catch (SQLException e)
		   { e.printStackTrace(); }
	   }
	   return lista;
   }
   //**********************************************************
   public static ArrayList llena_combo_prevision_salud()
   {
	   ArrayList lista = new ArrayList();
	   Connection c = null;
	   int salida;
	   try
	   {   String sql;
		   c = conexion_odbc.Connexion_datos();
		   sql = "{call frm_fise_ingreso_datos_llena_combo_prevision_salud}";
		   CallableStatement ps = c.prepareCall(sql);

		   ResultSet rs = ps.executeQuery();
		   lista.add(new obj_combo_dos_campos("0", "-- Seleccione --"));
		   while (rs.next())
		   {       lista.add(new obj_combo_dos_campos(rs.getString("idn"),
		  	   rs.getString("descripcion")));   }
	   }
	   catch (Exception e)
	   { e.printStackTrace();   }
	   finally
	   {  try
		   { c.close(); }
	      catch (SQLException e)
		   { e.printStackTrace(); }
	   }
	   return lista;
   } 
   
   //**********************************************************
   public static ArrayList llena_combo_actividad()
   {
	   ArrayList lista = new ArrayList();
	   Connection c = null;
	   int salida;
	   try
	   {   String sql;
		   c = conexion_odbc.Connexion_datos();
		   sql = "{call frm_fise_ingreso_datos_llena_combo_actividad}";
		   CallableStatement ps = c.prepareCall(sql);

		   ResultSet rs = ps.executeQuery();
		   lista.add(new obj_combo_dos_campos("0", "-- Seleccione --"));
		   while (rs.next())
		   {       lista.add(new obj_combo_dos_campos(rs.getString("idn"),
		  	   rs.getString("descripcion")));   }
	   }
	   catch (Exception e)
	   { e.printStackTrace();   }
	   finally
	   {  try
		   { c.close(); }
	      catch (SQLException e)
		   { e.printStackTrace(); }
	   }
	   return lista;
   } 
   
   //**********************************************************
   public static ArrayList llena_combo_enfermedad_grave()
   {
	   ArrayList lista = new ArrayList();
	   Connection c = null;
	   int salida;
	   try
	   {   String sql;
		   c = conexion_odbc.Connexion_datos();
		   sql = "{call frm_fise_ingreso_datos_llena_combo_enfermedad_grave}";
		   CallableStatement ps = c.prepareCall(sql);

		   ResultSet rs = ps.executeQuery();
		   lista.add(new obj_combo_dos_campos("0", "-- Seleccione --"));
		   while (rs.next())
		   {       lista.add(new obj_combo_dos_campos(rs.getString("idn"),
		  	   rs.getString("descripcion")));   }
	   }
	   catch (Exception e)
	   { e.printStackTrace();   }
	   finally
	   {  try
		   { c.close(); }
	      catch (SQLException e)
		   { e.printStackTrace(); }
	   }
	   return lista;
   } 
   //**********************************************************
   public static ArrayList llena_combo_tipo_familia()
   {
	   ArrayList lista = new ArrayList();
	   Connection c = null;
	   int salida;
	   try
	   {   String sql;
		   c = conexion_odbc.Connexion_datos();
		   sql = "{call frm_fise_ingreso_datos_llena_combo_tipo_familia}";
		   CallableStatement ps = c.prepareCall(sql);

		   ResultSet rs = ps.executeQuery();
		   lista.add(new obj_combo_dos_campos("0", "-- Seleccione --"));
		   while (rs.next())
		   {       lista.add(new obj_combo_dos_campos(rs.getString("idn"),
		  	   rs.getString("descripcion")));   }
	   }
	   catch (Exception e)
	   { e.printStackTrace();   }
	   finally
	   {  try
		   { c.close(); }
	      catch (SQLException e)
		   { e.printStackTrace(); }
	   }
	   return lista;
   } 
   
   //**********************************************************
   public static ArrayList llena_combo_jefe_hogar()
   {
	   ArrayList lista = new ArrayList();
	   Connection c = null;
	   int salida;
	   try
	   {   String sql;
		   c = conexion_odbc.Connexion_datos();
		   sql = "{call frm_fise_ingreso_datos_llena_combo_jefe_hogar}";
		   CallableStatement ps = c.prepareCall(sql);

		   ResultSet rs = ps.executeQuery();
		   lista.add(new obj_combo_dos_campos("0", "-- Seleccione --"));
		   while (rs.next())
		   {       lista.add(new obj_combo_dos_campos(rs.getString("idn"),
		  	   rs.getString("descripcion")));   }
	   }
	   catch (Exception e)
	   { e.printStackTrace();   }
	   finally
	   {  try
		   { c.close(); }
	      catch (SQLException e)
		   { e.printStackTrace(); }
	   }
	   return lista;
   } 
 //******************************************************************************************************************************************************  
     public static ArrayList guarda_datos_ingresos (ArrayList arreglo_ingresos,  String fise_correlativo) {
        ArrayList lista = new ArrayList();
        Connection c=null;
        int salida;
        try {
            
            
            if (arreglo_ingresos.size() > 0)
            {
                String sql_asignados;
                int i_asignados;
                int size_asignados = arreglo_ingresos.size();
                                
                obj_nueve_campos reg_asignados = null;
                String sql;
                
                for (i_asignados=0; i_asignados<size_asignados; i_asignados++) 
                {               
                    reg_asignados = (obj_nueve_campos)arreglo_ingresos.get(i_asignados);
                    
                    c = conexion_odbc.Connexion_datos();
                    
                    sql = "{call frm_fise_ingreso_datos_guarda_datos_ingresos (?,?,?,?,?,?,?,?,?,?)}" ;
                    CallableStatement ps1 = c.prepareCall(sql);
                    ps1.setString(1, reg_asignados.getcampo_uno().trim());  
                    ps1.setString(2, reg_asignados.getcampo_dos().trim());  
                    ps1.setString(3, reg_asignados.getcampo_tres().trim());  
                    ps1.setString(4, reg_asignados.getcampo_cuatro().trim());  
                    ps1.setString(5, reg_asignados.getcampo_cinco().trim());             
                    ps1.setString(6, reg_asignados.getcampo_seis().trim());
                    ps1.setString(7, reg_asignados.getcampo_siete().trim());
                    ps1.setString(8, reg_asignados.getcampo_ocho().trim());
                    ps1.setString(9, reg_asignados.getcampo_nueve().trim());
                    ps1.setString(10, fise_correlativo.trim());
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
     public static ArrayList guarda_datos_bienes (ArrayList arreglo_bienes, String rut,  String fise_correlativo) {
        ArrayList lista = new ArrayList();
        Connection c=null;
        int salida;
        try {
            
            
            if (arreglo_bienes.size() > 0)
            {
                String sql_asignados;
                int i_asignados;
                int size_asignados = arreglo_bienes.size();
                                
                obj_diez_campos reg_asignados = null;
                String sql;
                
                for (i_asignados=0; i_asignados<size_asignados; i_asignados++) 
                {               
                    reg_asignados = (obj_diez_campos)arreglo_bienes.get(i_asignados);
                    
                    c = conexion_odbc.Connexion_datos();
                    
                    sql = "{call frm_fise_ingreso_datos_guarda_datos_bienes (?,?,?,?,?,?,?,?,?,?,?,?)}" ;
                    CallableStatement ps1 = c.prepareCall(sql);
                    ps1.setString(1, reg_asignados.getcampo_uno().trim());  
                    ps1.setString(2, reg_asignados.getcampo_dos().trim());  
                    ps1.setString(3, reg_asignados.getcampo_tres().trim());  
                    ps1.setString(4, reg_asignados.getcampo_cuatro().trim());  
                    ps1.setString(5, reg_asignados.getcampo_cinco().trim());             
                    ps1.setString(6, reg_asignados.getcampo_seis().trim());
                    ps1.setString(7, reg_asignados.getcampo_siete().trim());
                    ps1.setString(8, reg_asignados.getcampo_ocho().trim());
                    ps1.setString(9, reg_asignados.getcampo_nueve().trim());
                    ps1.setString(10, reg_asignados.getcampo_diez().trim());
                    ps1.setString(11, rut.trim());
                    ps1.setString(12, fise_correlativo.trim());
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
   

   
   
     
     public static ArrayList guarda_datos_egresos (String fise_correlativo, String alimentacion, String vestuario, String estudios, String vivienda, String transporte, String medicamentos, String servicios_basicos) {
    	    ArrayList lista = new ArrayList();
    	    Connection c=null;
    	    int salida = 1;
    	    String msg;
    	        try {
    	            String sql;
    	            c = conexion_odbc.Connexion_datos();
    	            sql = "{call frm_fise_ingreso_datos_guarda_datos_egresos (?,?,?,?,?,?,?,?)}" ;
    	            CallableStatement ps1 = c.prepareCall(sql);
                    ps1.setString(1, fise_correlativo.trim());
                    ps1.setString(2, alimentacion.trim());
                    ps1.setString(3, vestuario.trim());
                    ps1.setString(4, estudios.trim());
                    ps1.setString(5, vivienda.trim());
                    ps1.setString(6, transporte.trim());
                    ps1.setString(7, medicamentos.trim());
                    ps1.setString(8, servicios_basicos.trim());

    	            ps1.execute();
    	            
    	           
    	        } catch (Exception e) {
    	            e.printStackTrace();
    	            salida = 0;
    	            msg = e.getMessage();
    	            lista.add(new obj_un_campo_string(msg));
    	        } finally {
    	            try {
    	                c.close();
    	            } catch (SQLException e) {
    	                e.printStackTrace();
    	                   
    	            }
    	        }
    	        
    	        if (salida == 1){
    	        lista.add(new obj_un_campo_string("1"));
    	        }
    	    
    	        return lista;
    	   }
     
     
     
     public static ArrayList guarda_datos_fise (String rut, String tipo_familia, String fise_correlativo) {
 	    ArrayList lista = new ArrayList();
 	    Connection c=null;
 	    int salida = 1;
 	    String msg;
 	        try {
 	            String sql;
 	            c = conexion_odbc.Connexion_datos();
 	            sql = "{call frm_fise_ingreso_datos_guarda_datos_fise (?,?,?)}" ;
 	            CallableStatement ps1 = c.prepareCall(sql);
                 ps1.setString(1, rut.trim());
                 ps1.setString(2, tipo_familia.trim());
                 ps1.setString(3, fise_correlativo.trim());

 	            ps1.execute();
 	            
 	           
 	        } catch (Exception e) {
 	            e.printStackTrace();
 	            salida = 0;
 	            msg = e.getMessage();
 	            lista.add(new obj_un_campo_string(msg));
 	        } finally {
 	            try {
 	                c.close();
 	            } catch (SQLException e) {
 	                e.printStackTrace();
 	                   
 	            }
 	        }
 	        
 	        if (salida == 1){
 	        lista.add(new obj_un_campo_string("1"));
 	        }
 	    
 	        return lista;
 	   }
     
     
     
     
     //******************************************************************************************************************************************************  
     public static ArrayList guarda_datos_grupo_familiar (ArrayList arreglo_familiar, String fise_correlativo) {
        ArrayList lista = new ArrayList();
        Connection c=null;
        int salida;
        try {
            
            
            if (arreglo_familiar.size() > 0)
            {
                String sql_asignados;
                int i_asignados;
                int size_asignados = arreglo_familiar.size();
                                
                obj_quince_campos reg_asignados = null;
                String sql;
                
                for (i_asignados=0; i_asignados<size_asignados; i_asignados++) 
                {               
                    reg_asignados = (obj_quince_campos)arreglo_familiar.get(i_asignados);
                    
                    c = conexion_odbc.Connexion_datos();
                    
                    sql = "{call frm_fise_ingreso_datos_guarda_datos_grupo_familiar (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}" ;
                    CallableStatement ps1 = c.prepareCall(sql);
                    ps1.setString(1, reg_asignados.getcampo_uno().trim());  
                    ps1.setString(2, reg_asignados.getcampo_dos().trim());  
                    ps1.setString(3, reg_asignados.getcampo_tres().trim());  
                    ps1.setString(4, reg_asignados.getcampo_cuatro().trim());  
                    ps1.setString(5, reg_asignados.getcampo_cinco().trim());             
                    ps1.setString(6, reg_asignados.getcampo_seis().trim());
                    ps1.setString(7, reg_asignados.getcampo_siete().trim());
                    ps1.setString(8, reg_asignados.getcampo_ocho().trim());
                    ps1.setString(9, reg_asignados.getcampo_nueve().trim());
                    ps1.setString(10, reg_asignados.getcampo_diez().trim());
                    ps1.setString(11, reg_asignados.getcampo_once().trim());
                    ps1.setString(12, reg_asignados.getcampo_doce().trim());
                    ps1.setString(13, reg_asignados.getcampo_trece().trim());
                    ps1.setString(14, reg_asignados.getcampo_catorce().trim());
                    ps1.setString(15, fise_correlativo.trim());
                    ps1.setString(16, reg_asignados.getcampo_quince().trim());
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
     public static ArrayList trae_datos_bienes (String rut) {
        ArrayList lista = new ArrayList();
        Connection c=null;
        int salida;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
	        sql = "{call frm_fise_ingreso_datos_trae_datos_bienes(?)}";
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, rut.trim());
            ResultSet rs = ps.executeQuery();
            
             while (rs.next()){
            
                lista.add(new obj_dieciseis_campos(rs.getString("descripcion_propiedad"),
                                              rs.getString("descripcion_tipo_construccion"),
                                              rs.getString("descripcion_tenencia"),
                                              rs.getString("descripcionec"),
                                              rs.getString("descripcionsb"),
                                              rs.getString("metros_construidos"),
                                              rs.getString("superficie_total"),
                                              rs.getString("descripcionu"),
                                              rs.getString("habitaciones"),
                                              rs.getString("avaluo_fiscal"),
                                              rs.getString("tipo_propiedad"),
                                              rs.getString("tipo_construccion"),
                                              rs.getString("tenencia_propiedad"),
                                              rs.getString("estado_de_conservacion"),
                                              rs.getString("estado_de_conservacion"),
                                              rs.getString("uso")
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
  
     
     //******************************************************************************************************************************************************    
     public static ArrayList trae_datos_familia (String rut) {
        ArrayList lista = new ArrayList();
        Connection c=null;
        int salida;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
	        sql = "{call frm_fise_ingreso_datos_trae_datos_familiares(?)}";
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, rut.trim()); 
            ResultSet rs = ps.executeQuery();
            
             while (rs.next()){
            
                lista.add(new obj_veintitres_campos(rs.getString("nombres"),
                                              rs.getString("apellido_paterno"),
                                              rs.getString("apellido_materno"),
                                              rs.getString("rut"),
                                              rs.getString("fecha_nacimiento"),
                                              rs.getString("est_civil_nombre"),
                                              rs.getString("id_estado_civil"),
                                              rs.getString("desc_sexo"),
                                              rs.getString("id_sexo"),
                                              rs.getString("desc_parentesco"),
                                              rs.getString("id_parentesco"),
                                              rs.getString("desc_nivel_estudios"),
                                              rs.getString("id_nivel_estudios"),
                                              rs.getString("desc_prevision_social"),
                                              rs.getString("id_prevision_social"),
                                              rs.getString("desc_prevision_salud"),
                                              rs.getString("id_prevision_salud"),
                                              rs.getString("desc_actividad"),
                                              rs.getString("id_actividad"),
                                              rs.getString("desc_enfermedad_grave"),
                                              rs.getString("id_enfermedad_grave"),
                                              rs.getString("desc_jefe_hogar"),
                                              rs.getString("id_jefe_hogar")
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
     
     //******************************************************************************************************************************************************    
     public static ArrayList trae_datos_ingresos (String rut) {
        ArrayList lista = new ArrayList();
        Connection c=null;
        int salida;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
	        sql = "{call frm_fise_ingreso_datos_trae_datos_ingresos(?)}";
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, rut.trim());
            ResultSet rs = ps.executeQuery();
            
             while (rs.next()){
                lista.add(new obj_nueve_campos(rs.getString("rut"),
                                              rs.getString("remuneracion_contrato"),
                                              rs.getString("honorario"),
                                              rs.getString("arriendo_bienes_muebles"),
                                              rs.getString("arriendo_bienes_inmuebles"),
                                              rs.getString("pension"),
                                              rs.getString("becas_otros_ingresos"),
                                              rs.getString("descripcion_beca"),
                                              rs.getString("tipo_beca")
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
     
     
     public static ArrayList trae_datos_egresos (String rut) 
     {
         ArrayList lista = new ArrayList();
         Connection c=null;
         int salida;
         try 
         {
             String sql;
             c = conexion_odbc.Connexion_datos();
             sql = "{call frm_fise_ingreso_datos_trae_datos_egresos (?)}";
             CallableStatement ps = c.prepareCall(sql);
             ps.setString(1, rut.trim());
             ResultSet rs = ps.executeQuery();
             
             while (rs.next())
             {
                 lista.add(new obj_siete_campos(rs.getString("alimentacion"),
                		                        rs.getString("vestuario"),
                		                        rs.getString("estudios"),
                		                        rs.getString("vivienda"),
                		                        rs.getString("transporte"),
                		                        rs.getString("medicamentos"),
                		                        rs.getString("servicios_basicos")
                                               )
                           );
             }
         } 
         catch (Exception e) 
         {
             e.printStackTrace();
         } 
         finally 
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
