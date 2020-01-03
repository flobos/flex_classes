/*
 * frm_adm_ejecucion_producto.java
 *
 * Created on 26 de julio de 2007, 05:42 PM
 */

package libreria;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author  Esteban 
 */
public class frm_adm_ejecucion_producto {

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
public static ArrayList<obj_dos_campos> carga_ejecucion() {
    ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_ejecuciones_activas}" ;
            CallableStatement ps = c.prepareCall(sql);

            ResultSet rs = ps.executeQuery();
            
            lista.add(new obj_dos_campos("0","-- Seleccione --"));
            
            while (rs.next())
            {
                lista.add(new obj_dos_campos(rs.getString("eje_idn")
                                             , rs.getString("eje_nombre")));
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
   
public static ArrayList<obj_cuatro_campos> carga_producto_campus(String cam_idn, String mod_idn) {
    ArrayList<obj_cuatro_campos> lista = new ArrayList<obj_cuatro_campos>();
        Connection c=null;
         
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_ejecucion_producto_productos_campus (?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, mod_idn.trim());
            ps.setString(2, cam_idn.trim());
            ResultSet rs = ps.executeQuery();
            
           
            while (rs.next())
            {
                lista.add(new obj_cuatro_campos(rs.getString("pro_mod_idn")
                                                , rs.getString("pro_cam_idn")
                                                , rs.getString("cur_idn")
                                                , rs.getString("cur_nombre")));
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
   
public static ArrayList<obj_cinco_campos> carga_ejecucion_producto(String cam_idn, String mod_idn, String eje_idn) {
    ArrayList<obj_cinco_campos> lista = new ArrayList<obj_cinco_campos>();
        Connection c=null;
         
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_ejecucion_producto_ejecuciones_producto (?,?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, eje_idn.trim());
            ps.setString(2, mod_idn.trim());
            ps.setString(3, cam_idn.trim());
            ResultSet rs = ps.executeQuery();
            
           
            while (rs.next())
            {
                lista.add(new obj_cinco_campos(rs.getString("eje_pro_idn")
                                                , rs.getString("cur_nombre")
                                                , rs.getString("cam_nombre")
                                                , rs.getString("mod_nombre")
                                                , rs.getString("tip_prod_nombre")));
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
       
         public static ArrayList<obj_un_campo_string> elimina_ejecucion_producto(ArrayList<?> arreglo_final) {
    
        ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
        Connection c=null;
        try {

             String sql1;
              int size = arreglo_final.size();
              obj_un_campo_string registro = null;
                
            int j;
            for (j=0; j<size; j++) 
               {
                    
                       registro = (obj_un_campo_string) arreglo_final.get(j);
                        c = conexion_odbc.Connexion_datos();
                        sql1 = "{call flex_adm_ejecucion_producto_elimina_ejecucion_producto (?)}" ;
                        CallableStatement ps1 = c.prepareCall(sql1);
                        ps1.setString(1, registro.getcampo_uno());
                        ResultSet rs = ps1.executeQuery();
                        
                        while (rs.next())
                        {
                            lista.add(new obj_un_campo_string(rs.getString("salida")));
                        }   
               }

           } catch (Exception e) {
            e.printStackTrace();
            lista.clear();
            lista.add(new obj_un_campo_string("ERROR"));
           
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
    
    /** Creates a new instance of frm_adm_ejecucion_producto */
    public frm_adm_ejecucion_producto() {
    }
    
}
