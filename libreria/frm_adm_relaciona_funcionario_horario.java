/*
 * frm_adm_relaciona_funcionario_horario.java
 *
 * Created on octubre de 2010, 15:11
 */

/**
 *
 * @author  LBaeza
 */
package libreria;
import java.util.ArrayList;
import java.sql.*;

public class frm_adm_relaciona_funcionario_horario {
    
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
    
   //******************************************************************************************************************************************************    
     public static ArrayList<obj_ocho_campos> recupera_jornadas () {
         ArrayList<obj_ocho_campos> lista = new ArrayList<obj_ocho_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
	    sql = "{call frm_adm_recupera_jornadas_trabajo()}";
            CallableStatement ps = c.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            
             while (rs.next()){
            
                lista.add(new obj_ocho_campos(rs.getString("idnjornada"),
                                              rs.getString("tipojornadaidn"),
                                              rs.getString("desc_tipo_jornada"),
                                              rs.getString("tipomarcajeidn"),
                                              rs.getString("desc_tipo_marcaje"),
                                              rs.getString("hora"),
                                              rs.getString("tipo"),
                                              rs.getString("desc_gral_jornada")                                              
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
       public static ArrayList<obj_un_campo> recupera_jornadas_rut (String fun_rut) {
         ArrayList<obj_un_campo> lista = new ArrayList<obj_un_campo>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
	    sql = "{call frm_adm_recupera_jornadas_trabajo_rut(?)}";
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, fun_rut.trim());
            ResultSet rs = ps.executeQuery();
            
             while (rs.next()){
            
                lista.add(new obj_un_campo(rs.getString("jornada")                                            
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
     
    public static ArrayList<obj_un_campo_string> inserta_horario(String fun_rut, String jornada) {
    ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
    Connection c=null;
    int salida = 1;
    String msg;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_adm_inserta_jornadas_trabajo_rut (?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,fun_rut);
            ps.setString(2,jornada);

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
     
    
   public static ArrayList<obj_un_campo_string> elimina_horario_anterior(String fun_rut) {
    ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
    Connection c=null;
    int salida = 1;
    String msg;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_adm_elimina_jornadas_trabajo_rut (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,fun_rut);
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
       
       
    
    public frm_adm_relaciona_funcionario_horario() {
    }
    
}
