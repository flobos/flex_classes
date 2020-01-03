/*
 * frm_adm_activacion_funcionarios.java
 *
 * Created on 16 de septiembre de 2010, 15:11
 */

/**
 *
 * @author  LBaeza
 */
package libreria;
import java.util.ArrayList;
import java.sql.*;

public class frm_adm_activacion_funcionarios {
    
    //******************************************************************************************************************************************************    
     public static ArrayList<obj_tres_campos> buscar_por_rut (String fun_rut) {
         ArrayList<obj_tres_campos> lista = new ArrayList<obj_tres_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
			sql = "{call frm_adm_activacion_funcionarios_trae_datos(?)}";
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, fun_rut.trim());
            ResultSet rs = ps.executeQuery();
            
             while (rs.next()){
            
                lista.add(new obj_tres_campos(rs.getString("rut"),
                                              rs.getString("nombre"),
                                              rs.getString("descripcion")));
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
   public static ArrayList<obj_combo_dos_campos> llena_combo_estado_funcionario()
   {
	   ArrayList<obj_combo_dos_campos> lista = new ArrayList<obj_combo_dos_campos>();
	   Connection c = null;
	   try
	   {
		   String sql;
		   c = conexion_odbc.Connexion_datos();
		   sql = "{call frm_adm_activacion_funcionarios_llena_combo_estado_funcionario}";
		   CallableStatement ps = c.prepareCall(sql);

		   ResultSet rs = ps.executeQuery();
		   lista.add(new obj_combo_dos_campos("0", "-- Seleccione --"));
		   while (rs.next())
		   {

			   lista.add(new obj_combo_dos_campos(rs.getString("fun_estado_idn"),
		  	   rs.getString("fun_estado_descripcion")));

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
   
   
   
   
   
   public static ArrayList<obj_un_campo_string> modificar_estado(String fun_rut, String estado) {
    ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
    Connection c=null;
    int salida = 1;
    String msg;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_adm_activacion_funcionarios_modifica_estado_funcionario (?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,fun_rut);
            ps.setString(2,estado);

            ps.execute();
            
           
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
   
   
   
   
   
   
    /** Creates a new instance of frm_adm_activacion_funcionarios */
    public frm_adm_activacion_funcionarios() {
    }
    
}
