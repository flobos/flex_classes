/*
 * frm_adm_mat_crea_material_base.java
 *
 * Created on 1 de febrero de 2006, 04:44 PM
 */

package libreria;
import java.util.ArrayList;
import java.io.Serializable;
import java.sql.*;
/**
 *
 * @author  Esteban
 */
public class frm_adm_mat_crea_material_base {
//***********************************************************************************************************                 
public static ArrayList<obj_dos_campos> carga_bibliotecas_virtuales() {
    ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "select * from biblioteca_virtual_base order by bib_vir_bas_nombre" ;
            CallableStatement ps = c.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            
            lista.add(new obj_dos_campos("", "-- Seleccione --"));
            
            while (rs.next()){
            
      
             lista.add(new obj_dos_campos(rs.getString("bib_vir_bas_idn"),
                                            rs.getString("bib_vir_bas_nombre")));
           
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
// frm_tutor_crear_materiales_apoyo.mxml --by.SyOuS
//***********************************************************************************************************   
   public static ArrayList<obj_cinco_campos> carga_materiales_biblioteca_virtual(String biblioteca) {
    
        ArrayList<obj_cinco_campos> lista = new ArrayList<obj_cinco_campos>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_tutor_subida_materiales_carga_materiales_biblioteca_base '" + biblioteca + "'" ;//
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            
            while (rs.next()){
            
      
            lista.add(new obj_cinco_campos(rs.getString("mat_apoyo_idn"),
                                                 rs.getString("mat_apoyo_nombre"),
                                                 rs.getString("tipo_material_nombre"),
                                                 rs.getString("tipo_contenido"),
                                                 rs.getString("mat_apoyo_ruta")));
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
// frm_tutor_crear_materiales_apoyo.mxml --by.SyOuS
//***********************************************************************************************************   
    
       public static void inserta_material_apoyo_base(String bib_vir_bas_idn
                                                    , String tip_mat_apo_idn
                                                    , String cantidad
                                                    , String tip_mat_apo_nombre) 
       {
     
        Connection c=null;

        try {
                String sql;
                c = conexion_odbc.Connexion_datos();
                  
                sql = "{call flex_tutor_crea_materiales_apoyo_inserta_materiales_base (?,?,?,?)}";//
                PreparedStatement ps = c.prepareStatement(sql);
                ps.setString(1,bib_vir_bas_idn.trim());
                ps.setString(2,tip_mat_apo_idn.trim());
                ps.setString(3,cantidad.trim());
                ps.setString(4,tip_mat_apo_nombre.trim());
                ps.execute();
           }
        
                catch (Exception e) 
           {
                e.printStackTrace();
            } 
        finally {
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
    }   
//***********************************************************************************************************
// frm_tutor_crear_materiales_apoyo.mxml --by.SyOuS
//***********************************************************************************************************   
          
    public static ArrayList<Serializable> carga_tipo_material_de_apoyo() {
    
        ArrayList<Serializable> lista = new ArrayList<Serializable>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
           sql = "flex_busca_tipo_material_de_apoyo";//
            cs = c.prepareCall(sql);
           // cs.setString(1, "633174");
            lista.add(0,"-- Seleccione --");
            ResultSet rs = cs.executeQuery();
            
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos(rs.getString("data"),
                                         rs.getString("label")));
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
    
       public static void eliminar_material_apoyo_base(String mat_apoyo_idn) 
       {
     
        Connection c=null;

        try {
                String sql;
                c = conexion_odbc.Connexion_datos();
                  
                sql = "{call flex_tutor_crea_materiales_apoyo_elimina_material_base (?)}";//
                PreparedStatement ps = c.prepareStatement(sql);
                ps.setString(1,mat_apoyo_idn.trim());
                ps.execute();
           }
        
                catch (Exception e) 
           {
                e.printStackTrace();
            } 
        finally {
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
    }   
    /** Creates a new instance of frm_adm_mat_crea_material_base */
    public frm_adm_mat_crea_material_base() {
    }
}
