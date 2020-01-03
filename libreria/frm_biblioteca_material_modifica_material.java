/*
 * frm_biblioteca_material_modifica_material.java
 *
 * Created on 23 de junio de 2008, 17:02
 */

package libreria;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author  villanueva
 */
public class frm_biblioteca_material_modifica_material {
    
    /** Creates a new instance of frm_biblioteca_material_modifica_material */
    public frm_biblioteca_material_modifica_material() {
    }
//**************************************    
     public static ArrayList<obj_cinco_campos> busca_titulo(String mat_tit_titulo) {
      ArrayList<obj_cinco_campos> lista = new ArrayList<obj_cinco_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_biblioteca_material_modifica_material_busca_titulo(?)}" ;
            CallableStatement ps = c.prepareCall(sql);
             
            ps.setString(1,mat_tit_titulo.trim());
                                  
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
                  
            lista.add(new obj_cinco_campos (rs.getString("mat_bib_idn"), 
                                                rs.getString("mat_tit_titulo"),
                                                 rs.getString("mat_bib_edicion"), 
                                                  rs.getString("mat_bib_anio"),
                                                   rs.getString("mat_bib_indice")
                                            
                                               ));
                                                      
           
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
 
//**************************************    
     public static ArrayList<obj_cinco_campos> busca_codigo(String mat_bib_idn) {
      ArrayList<obj_cinco_campos> lista = new ArrayList<obj_cinco_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_biblioteca_material_modifica_material_busca_codigo(?)}" ;
            CallableStatement ps = c.prepareCall(sql);
             
            ps.setString(1,mat_bib_idn.trim());
                                  
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
                  
            lista.add(new obj_cinco_campos (rs.getString("mat_bib_idn"), 
                                                rs.getString("mat_tit_titulo"),
                                                 rs.getString("mat_bib_edicion"), 
                                                  rs.getString("mat_bib_anio"),
                                                   rs.getString("mat_bib_indice")
                                            
                                               ));
                                                      
           
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
     
    //**************************************    
     public static ArrayList<obj_cuatro_campos> llena_grilla_autores(String mat_bib_idn) {
      ArrayList<obj_cuatro_campos> lista = new ArrayList<obj_cuatro_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_biblioteca_material_modifica_material_llena_grilla_autores(?)}" ;
            CallableStatement ps = c.prepareCall(sql);
             
            ps.setString(1,mat_bib_idn.trim());
                                  
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
                  
            lista.add(new obj_cuatro_campos (rs.getString("mat_aut_idn"), 
                                                rs.getString("aut_nombres"),
                                                 rs.getString("aut_apellidos"), 
                                                  rs.getString("tip_aut_nombre")                                           
                                                   ));
                                                      
           
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
    
    
//************************************
     
     
     
     
    
}
