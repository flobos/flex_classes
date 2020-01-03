/*
 * frm_tutor_subida_prueba.java
 *
 * Created on 22 de diciembre de 2005, 09:47 AM
 */

package libreria;
import java.util.ArrayList;
import java.io.Serializable;
import java.sql.*;
/**
 *
 * @author  Esteban
 */
public class frm_tutor_subida_prueba {
//***********************************************************************************************************   
// frm_tutor_subida_prueba.mxml --by.SyOuS
//***********************************************************************************************************
public static ArrayList<obj_tres_campos> ro_carga_eje_aca_subida_pruebas(String eje_aca) {
    
   
        ArrayList<obj_tres_campos> lista = new ArrayList<obj_tres_campos>();
        Connection c=null;
        try {
                c = conexion_odbc.Connexion_datos();
                Statement s = c.createStatement();
                ResultSet rs =  s.executeQuery("flex_tutor_subida_prueba_carga_ejecuciones_academicas '" + eje_aca + "'");
                while (rs.next()){
            
                    lista.add(new obj_tres_campos(
                                                        rs.getString("tip_pru_nombre"),
                                                        rs.getString("tip_pru_idn"),
                                                        rs.getString("eva_eje_archivo_web")));
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
// frm_tutor_subida_prueba.mxml -- RGN
//***********************************************************************************************************

public static ArrayList<Serializable> carga_semestre() {
  
             
            ArrayList<Serializable> lista = new ArrayList<Serializable>();
        Connection c=null;
        try {
                c = conexion_odbc.Connexion_datos();
                Statement s = c.createStatement();
                ResultSet rs =  s.executeQuery("flex_carga_semestres");
                lista.add(0,"-- Seleccione --");
                while (rs.next()){
                lista.add(new obj_dos_campos(rs.getString("data"),rs.getString("label")));
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
// frm_tutor_subida_prueba.mxml -- RGN
//***********************************************************************************************************

 public static void elimina_evaluacion_archivo(String eva_eje_archivo_web ,String eje_aca_idn , String tip_pru_idn) {
       Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "flex_tutor_subida_prueba_actualiza_evaluacion_academica";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1,eva_eje_archivo_web);
            ps.setString(2,eje_aca_idn);
            ps.setString(3,tip_pru_idn);
            ps.execute();
            //('10000','102',1005)
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
   }    

//***********************************************************************************************************   
// frm_tutor_subida_prueba.mxml -- by.SyOuS
//***********************************************************************************************************
 
  public static ArrayList<Serializable> carga_malla(String eje_aca, String tip_prod_idn) {
    
        
        ArrayList<Serializable> lista = new ArrayList<Serializable>();
        Connection c=null;
        try {
                c = conexion_odbc.Connexion_datos();
                Statement s = c.createStatement();
                ResultSet rs =  s.executeQuery("flex_adm_subida_pruebas_carga_mallas '" + eje_aca + "', '" + tip_prod_idn + "'");
                lista.add(0,"-- Seleccione --");
                while (rs.next()){
                lista.add(new obj_dos_campos(rs.getString("data"),rs.getString("label")));
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
// frm_tutor_asigna_biblio_academica.mxml --by.SyOuS
// RGN 
// frm_tutor_subida_prueba
//***********************************************************************************************************  
 
 public static ArrayList<obj_dos_campos> carga_tipo_producto() {
        ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
        try {
                c = conexion_odbc.Connexion_datos();
                Statement s = c.createStatement();
                ResultSet rs =  s.executeQuery("select tip_prod_idn as data, tip_prod_nombre as label from tipo_producto order by tip_prod_nombre desc");
                lista.add(new obj_dos_campos("0","-- Seleccione --"));
                while (rs.next()){
                lista.add(new obj_dos_campos(rs.getString("data"),rs.getString("label")));
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
 // frm_adm_tutor_info_asigna_eje_aca.mxml --by.SyOuS
//***********************************************************************************************************           
   public static ArrayList<obj_seis_campos> muestra_ejecuciones_academicas_asignadas(String fun_mod_func) {
    
        ArrayList<obj_seis_campos> lista = new ArrayList<obj_seis_campos>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_adm_eje_aca_muestra_ejecuciones_academicas_asignadas '" + fun_mod_func + "'";
            cs = c.prepareCall(sql);
           // cs.setString(1, "633174");
            ResultSet rs = cs.executeQuery();
            
            while (rs.next()){
            
      
            lista.add(new obj_seis_campos(rs.getString("eje_aca_idn"),
                                  rs.getString("cur_nombre"),
                                  rs.getString("sec_nombre"),
                                  rs.getString("tip_prod_nombre"),
                                  rs.getString("cam_nombre"),
                                  rs.getString("eje_nombre")));
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
   
    /** Creates a new instance of frm_tutor_subida_prueba */
    public frm_tutor_subida_prueba() {
    }
    
}
