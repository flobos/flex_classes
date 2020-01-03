/*
 * frm_entidades.java
 *
 * Created on 4 de noviembre de 2009, 09:14 AM
 */

package libreria;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author  Jose
 */
public class frm_entidades {
    
    /** Creates a new instance of frm_entidades */
    public frm_entidades() {
    }
//***********************************************************************************************************      
    
    public static ArrayList<obj_combo_dos_campos> muestra_pais() {
      ArrayList<obj_combo_dos_campos> lista = new ArrayList<obj_combo_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call  carreras_fx_frm_entidades_muestra_pais}" ;
            CallableStatement ps = c.prepareCall(sql);
                                          
            ResultSet rs = ps.executeQuery();
            
          lista.add(new obj_combo_dos_campos ("0", "-- Seleccione --"));
          
            while (rs.next()){
            
      
            lista.add(new obj_combo_dos_campos (rs.getString("pais_idn"), 
                                                rs.getString("pais_nombre")));
           
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
    
    public static ArrayList<obj_combo_dos_campos> muestra_entidad() {
      ArrayList<obj_combo_dos_campos> lista = new ArrayList<obj_combo_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call  carreras_fx_frm_entidades_muestra_entidades}" ;
            CallableStatement ps = c.prepareCall(sql);
                                          
            ResultSet rs = ps.executeQuery();
            
          //lista.add(new obj_combo_dos_campos ("0", "-- Seleccione --"));
          
            while (rs.next()){
            
      
            lista.add(new obj_combo_dos_campos (rs.getString("tip_ent_idn"), 
                                                rs.getString("tip_ent_nombre")));
           
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
    public static ArrayList<obj_combo_dos_campos> muestra_region(String pais_idn) {
      ArrayList<obj_combo_dos_campos> lista = new ArrayList<obj_combo_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call  carreras_fx_frm_entidades_muestra_region(?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,pais_idn.trim());                               
            ResultSet rs = ps.executeQuery();
            
          lista.add(new obj_combo_dos_campos ("0", "-- Seleccione --"));
          
            while (rs.next()){
            
      
            lista.add(new obj_combo_dos_campos (rs.getString("div_pol_idn"), 
                                                rs.getString("div_pol_nombre")));
           
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
    public static ArrayList<obj_combo_dos_campos> muestra_tipo_fono() {
      ArrayList<obj_combo_dos_campos> lista = new ArrayList<obj_combo_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call  carreras_fx_frm_entidades_muestra_tipo_fono}" ;
            CallableStatement ps = c.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            
          lista.add(new obj_combo_dos_campos ("0", "-- Seleccione --"));
          
            while (rs.next()){
            
      
            lista.add(new obj_combo_dos_campos (rs.getString("tip_ent_fon_idn"), 
                                                rs.getString("tip_ent_fon_nombre")));
           
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
    public static ArrayList<obj_combo_dos_campos> muestra_comuna(String pais_idn) {
      ArrayList<obj_combo_dos_campos> lista = new ArrayList<obj_combo_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call  carreras_fx_frm_entidades_muestra_comunas(?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,pais_idn.trim());                               
            ResultSet rs = ps.executeQuery();
            
          lista.add(new obj_combo_dos_campos ("0", ""));
          
            while (rs.next()){
            
      
            lista.add(new obj_combo_dos_campos (rs.getString("seg_div_pol_idn"), 
                                                rs.getString("seg_div_pol_nombre")));
           
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
    public static ArrayList<obj_combo_dos_campos> muestra_tipo_direcciones() {
      ArrayList<obj_combo_dos_campos> lista = new ArrayList<obj_combo_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call  carreras_fx_frm_entidades_muestra_tipo_direcciones}" ;
            CallableStatement ps = c.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            
          lista.add(new obj_combo_dos_campos ("0", "-- Seleccione --"));
          
            while (rs.next())
            {
                lista.add(new obj_combo_dos_campos (rs.getString("tip_dir_idn"), 
                                                    rs.getString("tip_dir_nombre")));
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
//***********************************************************************************************************      
    public static ArrayList<obj_combo_dos_campos> muestra_direcciones(String seg_div_pol_idn, String cadena) {
      ArrayList<obj_combo_dos_campos> lista = new ArrayList<obj_combo_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call  carreras_fx_frm_entidades_muestra_direcciones(?, ?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,seg_div_pol_idn.trim());                               
            ps.setString(2,cadena.trim());                               
            ResultSet rs = ps.executeQuery();
            
            lista.add(new obj_combo_dos_campos ("0", cadena));
            while (rs.next())
            {
                lista.add(new obj_combo_dos_campos (rs.getString("dir_idn"), 
                                                    rs.getString("dir_cal_nombre")));
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
//***********************************************************************************************************      
    public static ArrayList<obj_ocho_campos> busca_entidad(String ent_rut) {
      ArrayList<obj_ocho_campos> lista = new ArrayList<obj_ocho_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call  carreras_fx_frm_entidades_busca_entidad(?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,ent_rut.trim());                               
            ResultSet rs = ps.executeQuery();
            
            while (rs.next())
            {
                lista.add(new obj_ocho_campos (rs.getString("ent_idn"), 
                                               rs.getString("ent_ap_paterno"),
                                               rs.getString("ent_ap_materno"),
                                               rs.getString("ent_nombres"),
                                               rs.getString("ent_fecha_ingreso"),
                                               rs.getString("ent_email"),
                                               rs.getString("tip_ent_idn"),
                                               rs.getString("pais_idn")));
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
//***********************************************************************************************************      
    public static ArrayList<?> guarda_entidad(String ent_rut, String ent_ap_paterno, String ent_ap_materno, String ent_nombres, String ent_fecha_ingreso, String ent_email, ArrayList<?> arreglo_entidad, ArrayList<?> arreglo_dir, ArrayList<?> arreglo_fono) {
      ArrayList<?> lista = new ArrayList<Object>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call  carreras_fx_frm_entidades_guarda_entidad(?,?,?,?,?,?)}";
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,ent_rut.trim());
            ps.setString(2,ent_ap_paterno.trim());                               
            ps.setString(3,ent_ap_materno.trim());                               
            ps.setString(4,ent_nombres.trim());                               
            ps.setString(5,ent_fecha_ingreso.trim());                               
            ps.setString(6,ent_email.trim());                               
            ResultSet rs = ps.executeQuery();
            
            
            int i_asignados;
            int size_dir = arreglo_dir.size();
            int size_num = arreglo_fono.size();
            int size_ent = arreglo_entidad.size();
            obj_ocho_campos reg_asignados = null;
            obj_seis_campos reg_asignados_fono = null;
            obj_tres_campos reg_asignados_entidad = null;
            String ent_idn;
            

            
            while (rs.next())
            {
                ent_idn = rs.getString("ent_idn");
                
                
                for (i_asignados=0; i_asignados<size_ent; i_asignados++) 
                {               
                    reg_asignados_entidad = (obj_tres_campos)arreglo_entidad.get(i_asignados);

                        c = conexion_odbc.Connexion_datos();

                        sql = "{call carreras_fx_frm_entidades_guarda_entidad_tipo_entidad (?,?,?)}" ;
                        CallableStatement ps1 = c.prepareCall(sql);
                        ps1.setString(1, ent_idn.trim());  
                        ps1.setString(2, reg_asignados_entidad.getcampo_uno().trim());  
                        ps1.setString(3, reg_asignados_entidad.getcampo_tres().trim());  

                        ps1.execute();          
                    
                }   
                
                
                
                for (i_asignados=0; i_asignados<size_dir; i_asignados++) 
                {               
                    reg_asignados = (obj_ocho_campos) arreglo_dir.get(i_asignados);
                    
                    c = conexion_odbc.Connexion_datos();
                    
                    sql = "{call carreras_fx_frm_entidades_guarda_entidad_direccion (?,?,?,?,?,?)}" ;
                    CallableStatement ps1 = c.prepareCall(sql);
                    ps1.setString(1, ent_idn.trim());  
                    ps1.setString(2, reg_asignados.getcampo_cuatro().trim());  
                    ps1.setString(3, reg_asignados.getcampo_seis().trim());  
                    ps1.setString(4, reg_asignados.getcampo_dos().trim());  
                    ps1.setString(5, reg_asignados.getcampo_siete().trim());  
                    ps1.setString(6, reg_asignados.getcampo_cinco().trim());  

                    ps1.execute();          
                }   
                
                for (i_asignados=0; i_asignados<size_num; i_asignados++) 
                {               
                    reg_asignados_fono = (obj_seis_campos)arreglo_fono.get(i_asignados);
                    
                    c = conexion_odbc.Connexion_datos();
                    
                    sql = "{call carreras_fx_frm_entidades_guarda_entidad_fono (?,?,?,?,?)}" ;
                    CallableStatement ps1 = c.prepareCall(sql);
                    ps1.setString(1, ent_idn.trim());  
                    ps1.setString(2, reg_asignados_fono.getcampo_tres().trim());  
                    ps1.setString(3, reg_asignados_fono.getcampo_cuatro().trim());  
                    ps1.setString(4, reg_asignados_fono.getcampo_dos().trim());  
                    ps1.setString(5, reg_asignados_fono.getcampo_seis().trim());  

                    ps1.execute();          
                }   
                
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
//***********************************************************************************************************      
    public static ArrayList<obj_combo_dos_campos> muestra_all_comunas() {
      ArrayList<obj_combo_dos_campos> lista = new ArrayList<obj_combo_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call  carreras_fx_frm_entidades_muestra_all_comunas}" ;
            CallableStatement ps = c.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            
            lista.add(new obj_combo_dos_campos ("0", ""));
            while (rs.next())
            {
                lista.add(new obj_combo_dos_campos (rs.getString("seg_div_pol_idn"), 
                                                    rs.getString("seg_div_pol_nombre")));
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
//*********************************************************************************************************** 
    
}
