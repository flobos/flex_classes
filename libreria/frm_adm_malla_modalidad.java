/*
 * frm_adm_ejecucion_producto.java
 *
 * Created on 18 de julio de 2007, 04:15 PM
 */

package libreria;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author  Esteban 
 */
public class frm_adm_malla_modalidad {
    
//***********************************************************************************************************                 
   
public static ArrayList<obj_dos_campos> carga_campus(int func_mod_fun_idn) {
    ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_campus_funcionario_busca (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setInt(1, func_mod_fun_idn);
            ResultSet rs = ps.executeQuery();
            
            lista.add(new obj_dos_campos("0","-- Seleccione --"));
            
            while (rs.next())
            {
                lista.add(new obj_dos_campos(rs.getString("cam_idn")
                                             , rs.getString("cam_nombre")));
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
//***********************************************************************************************************                 
   
public static ArrayList<obj_dos_campos> carga_modalidad(int func_mod_fun_idn) {
    ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_modalidad_funcionario_busca (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setInt(1, func_mod_fun_idn);
            ResultSet rs = ps.executeQuery();
            
            lista.add(new obj_dos_campos("0","-- Seleccione --"));
            
            while (rs.next())
            {
                lista.add(new obj_dos_campos(rs.getString("mod_idn")
                                             , rs.getString("mod_nombre")));
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
//***********************************************************************************************************                 
   
public static ArrayList<obj_cuatro_campos> carga_malla_campus(String cam_idn, String mod_idn) {
    ArrayList<obj_cuatro_campos> lista = new ArrayList<obj_cuatro_campos>();
        Connection c=null;
         
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_malla_modalidad_carga_mallas_campus (?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, cam_idn.trim());
            ps.setString(2, mod_idn.trim());
            ResultSet rs = ps.executeQuery();
            
           
            while (rs.next())
            {
                lista.add(new obj_cuatro_campos(rs.getString("mal_cam_idn")
                                                , rs.getString("tip_prod_nombre")
                                                , rs.getString("malla_nombre")
                                                , rs.getString("mal_idn")));
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

//***********************************************************************************************************                 
   
public static ArrayList<obj_cuatro_campos> carga_malla_modalidad(String cam_idn, String mod_idn) {
    ArrayList<obj_cuatro_campos> lista = new ArrayList<obj_cuatro_campos>();
        Connection c=null;
         
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_malla_modalidad_carga_mallas_modalidad (?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, cam_idn.trim());
            ps.setString(2, mod_idn.trim());
            ResultSet rs = ps.executeQuery();
            
           
            while (rs.next())
            {
                lista.add(new obj_cuatro_campos(rs.getString("mal_cam_idn")
                                                , rs.getString("tip_prod_nombre")
                                                , rs.getString("malla_nombre")
                                                , rs.getString("mal_idn")));
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
//***********************************************************************************************************                 
       
         @SuppressWarnings("null")
		public static ArrayList<obj_un_campo_string> inserta_malla_modalidad(ArrayList<?> arreglo_final) {
    
        ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
        Connection c=null;
        try {

             String sql1;
              int size = arreglo_final.size();
              obj_tres_campos registro = null;
                
            int j;
            for (j=0; j<size; j++) 
               {
                    
                       registro = (obj_tres_campos) arreglo_final.get(j);
                        sql1 = "{call flex_adm_malla_modalidad_inserta_malla_modalidad  (?,?)}" ;
                        CallableStatement ps1 = c.prepareCall(sql1);
                        ps1.setString(1, registro.getcampo_uno());
                        ps1.setString(2, registro.getcampo_dos());
                        ps1.execute();
               }
           
           } catch (Exception e) {
            e.printStackTrace();
            lista.add(new obj_un_campo_string("ERROR20"));
           
        } finally {
                     
            lista.add(new obj_un_campo_string("OK"));           
            try {
                    c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            
            
            }
        }
        return lista;
    }  
         
         //***********************************************************************************************************                 
       
         @SuppressWarnings("null")
		public static ArrayList<obj_un_campo_string> elimina_malla_modalidad(ArrayList<?> arreglo_final) {
    
        ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
        Connection c=null;
        try {

             String sql1;
              int size = arreglo_final.size();
              obj_tres_campos registro = null;
                
            int j;
            for (j=0; j<size; j++) 
               {
                    
                       registro = (obj_tres_campos) arreglo_final.get(j);
                        sql1 = "{call flex_adm_malla_modalidad_elimina_malla_modalidad  (?,?)}" ;
                        CallableStatement ps1 = c.prepareCall(sql1);
                        ps1.setString(1, registro.getcampo_uno());
                        ps1.setString(2, registro.getcampo_dos());
                        ps1.execute();
               }
           
           } catch (Exception e) {
            e.printStackTrace();
            lista.add(new obj_un_campo_string("ERROR"));
           
        } finally {
                     
            lista.add(new obj_un_campo_string("OK"));           
            try {
                    c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            
            
            }
        }
        return lista;
    }  


    /** Creates a new instance of frm_adm_ejecucion_producto */
    public frm_adm_malla_modalidad() {
    }
    
}
