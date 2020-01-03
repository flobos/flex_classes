/*
 * frm_adm_tutor_asigna_biblio_academica.java
 *
 * Created on 1 de febrero de 2006, 10:03 AM
 */

package libreria;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author  Esteban
 */
public class frm_adm_tutor_asigna_biblio_academica {
    
//***********************************************************************************************************   
// frm_tutor_asigna_biblio_academica.mxml --by.SyOuS
//***********************************************************************************************************      
 public static ArrayList<obj_un_campo_string> inserta_biblio_academica(String ejecucion, String biblio_virtual, String nombre_unidad, String fecha_ini, String fecha_fin) {
    
        ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_tutor_biblioteca_acedemica_inserta_biblio_aca '" + ejecucion + "','" + biblio_virtual + "','" + nombre_unidad + "','" + fecha_ini + "','" + fecha_fin + "'";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            
            while (rs.next())
            {
            
      
            lista.add(new obj_un_campo_string(rs.getString("identidad")));
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
//***********************************************************************************************************      
 public static ArrayList<obj_dos_campos> academica(String ejecucion, String tipo_producto) {
    
        ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_tutor_biblioteca_academica_carga_eje_aca '" + ejecucion + "','" + tipo_producto + "'";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            
            while (rs.next())
            {
            
      
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
// frm_tutor_asigna_biblio_academica.mxml --by.SyOuS
//***********************************************************************************************************      
 public static ArrayList<obj_dos_campos> ejecucion() {
    
        ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "select eje_idn, eje_nombre from ejecucion order by eje_nombre" ;
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            
            while (rs.next())
            {
            
      
            lista.add(new obj_dos_campos(rs.getString("eje_idn"),
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

 
//***********************************************************************************************************   
// frm_tutor_asigna_biblio_academica.mxml --by.SyOuS
//***********************************************************************************************************      
 public static ArrayList<obj_dos_campos> virtuales() {
    
        ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "select * from biblioteca_virtual order by bib_vir_nombre" ;
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            
            while (rs.next())
            {
            
      
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
// frm_tutor_asigna_biblio_academica.mxml --by.SyOuS
//***********************************************************************************************************      
 public static ArrayList<obj_dos_campos> tipo_producto() {
    
        ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "select tip_prod_idn, tip_prod_nombre from tipo_producto order by tip_prod_nombre desc" ;
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            
            lista.add(new obj_dos_campos("0", "-- Seleccione --")); 
            while (rs.next())
            {
            
      
            lista.add(new obj_dos_campos(rs.getString("tip_prod_idn"),
                                         rs.getString("tip_prod_nombre")));
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
//***********************************************************************************************************      
 public static ArrayList<obj_siete_campos> ro_bibliotecas(String eje_aca_idn) {
    
        ArrayList<obj_siete_campos> lista = new ArrayList<obj_siete_campos>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_tutor_biblioteca_academica_carga_bibliotecas '" + eje_aca_idn  + "'" ;
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            
            while (rs.next())
            {
            
      
            lista.add(new obj_siete_campos(rs.getString("eje_aca_idn"),
                                                rs.getString("bib_vir_idn"),
                                                rs.getString("bib_vir_nombre"),
                                                rs.getString("bib_eje_aca_titulo"),
                                                rs.getString("bib_eje_aca_activa"),
                                                rs.getString("bib_eje_aca_fecha_subida"),
                                                rs.getString("bib_eje_aca_fecha_bajada")
                                                
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

 
//***********************************************************************************************************   
 
 ///***********************************************************************************************************
 // frm_tutor_biblio_acedmica.mxml --by.SyOuS
 //***********************************************************************************************************      
      public static ArrayList<?> ro_biblio_academica_elimina_enlace(String eje_aca_idn, String bib_vir_idn)
      
      
      {
    
        ArrayList<?> lista = new ArrayList<Object>();
        Connection c=null;
        
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "delete bibliotecas_ejecucion_academica where eje_aca_idn = '" + eje_aca_idn  + "' and bib_vir_idn = '" + bib_vir_idn + "'" ;
            cs = c.prepareCall(sql);
            cs.executeQuery();
        
        

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
    /** Creates a new instance of frm_adm_tutor_asigna_biblio_academica */
    public frm_adm_tutor_asigna_biblio_academica() {
    }
    
}
