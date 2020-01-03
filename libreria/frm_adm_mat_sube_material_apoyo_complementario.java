/*
 * frm_adm_mat_sube_material_apoyo_complementario.java
 *
 * Created on 2 de febrero de 2006, 03:09 PM
 */

package libreria;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author  Esteban
 */
public class frm_adm_mat_sube_material_apoyo_complementario {
    //***********************************************************************************************************                 
public static ArrayList<obj_dos_campos> carga_bibliotecas_virtuales(String eje_aca) {
    ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "select b.* from bibliotecas_ejecucion_academica a, biblioteca_virtual b where a.eje_aca_idn = " + eje_aca + " and b.bib_vir_idn = a.bib_vir_idn order by bib_vir_nombre" ;
            CallableStatement ps = c.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            
            lista.add(new obj_dos_campos("","-- Seleccione --"));
            while (rs.next()){
            
      
             lista.add(new obj_dos_campos(rs.getString("bib_vir_idn"),
                                            rs.getString("bib_vir_nombre")));
           
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
   public static ArrayList<obj_seis_campos> carga_materiales_biblioteca_virtual(String biblioteca) {
    
        ArrayList<obj_seis_campos> lista = new ArrayList<obj_seis_campos>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_tutor_subida_materiales_carga_materiales_biblioteca '" + biblioteca + "'" ;//
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            
            while (rs.next()){
            
      
            lista.add(new obj_seis_campos(rs.getString("mat_apoyo_idn"),
                                                 rs.getString("mat_apoyo_nombre"),
                                                 rs.getString("tipo_material_nombre"),
                                                 rs.getString("tipo_contenido"),
                                                 rs.getString("mat_apoyo_ruta"),
                                                 rs.getString("con_vir_base")));
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
    
       public static void inserta_material_apoyo(String nombre_archivo
                                                    , String mat_apoyo_nombre
                                                    , String mat_apoyo_idn)
                                                    
       {
     
        Connection c=null;

        try {
                String sql;
                c = conexion_odbc.Connexion_datos();
                  
                sql = "{call flex_tutor_sube_materiales_inserta_material (?,?,?)}";//
                PreparedStatement ps = c.prepareStatement(sql);
                ps.setString(1,nombre_archivo.trim());
                ps.setString(2,mat_apoyo_nombre.trim());
                ps.setString(3,mat_apoyo_idn.trim());
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
    /** Creates a new instance of frm_adm_mat_sube_material_apoyo */
    public frm_adm_mat_sube_material_apoyo_complementario() {
    }
    
}
