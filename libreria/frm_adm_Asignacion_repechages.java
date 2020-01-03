/*
 * frm_adm_gestion_trabajos_seccion.java
 *
 * Created on 30 de agosto de 2007, 16:44
 */

package libreria;


import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author  Administrador
 */
public class frm_adm_Asignacion_repechages {
 //-------------------------------------------1------------------------------------------      
    public frm_adm_Asignacion_repechages() {
    }
    
    public static ArrayList<obj_dos_campos> muestra_ejecuciones(int funcion_modalidad) {
    ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_Asignacion_repechages_muestra_ejecuciones (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setInt(1, funcion_modalidad);
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
    
 //-----------------------------------------------2--------------------------------------   
    public static ArrayList<obj_dos_campos> muestra_tipo_producto(String ejecucion) {
    ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_Asignacion_repechages_muestra_tipo_producto (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, ejecucion.trim());
            ResultSet rs = ps.executeQuery();
            
            lista.add(new obj_dos_campos("0","-- Seleccione --"));
            
            while (rs.next())
            {
                lista.add(new obj_dos_campos(rs.getString("tip_prod_idn")
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
    
    //--------------------------------------------3-----------------------------------------
    public static ArrayList<obj_dos_campos> muestra_jornada(String ejecucion, String tipo_producto) {
    ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_Asignacion_repechages_muestra_jornada (?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, ejecucion.trim());
            ps.setString(2, tipo_producto.trim());
            ResultSet rs = ps.executeQuery();
            
            lista.add(new obj_dos_campos("0","-- Seleccione --"));
            
            while (rs.next())
            {
                lista.add(new obj_dos_campos(rs.getString("tip_jor_idn")
                                             , rs.getString("tip_jor_nombre")));
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
    
    //-------------------------------------------4------------------------------------------
      public static ArrayList<obj_dos_campos> muestra_secciones(String ejecucion, String tipo_producto, int jornada, String nota_inicial, String nota_final ) {
    ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
        
          try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_Asignacion_repechages_muestra_secciones (?,?,?,?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, ejecucion.trim());
            ps.setString(2, tipo_producto.trim());
            ps.setInt(3, jornada);
            ps.setString(4, nota_inicial.trim());
            ps.setString(5, nota_final.trim());
            ResultSet rs = ps.executeQuery();
            
            lista.add(new obj_dos_campos("0","-- Seleccione --"));
            
            while (rs.next())
            {
                lista.add(new obj_dos_campos(rs.getString("eje_aca_idn")
                                             , rs.getString("seccion")));
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
      
      //----------------------------------------5---------------------------------------------
  
    //***********************************************************************************************************                 
   
public static ArrayList<obj_cuatro_campos> muestra_evaluaciones(String ejecucion_academica,String nota_inicial,String nota_final) {
    ArrayList<obj_cuatro_campos> lista = new ArrayList<obj_cuatro_campos>();
        Connection c=null;
         
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_Asignacion_repechages_muestra_matriculas_promedios (?,?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, ejecucion_academica.trim());
            ps.setString(2, nota_inicial.trim());
            ps.setString(3, nota_final.trim());
            ResultSet rs = ps.executeQuery();
            
           
            while (rs.next())
            {
                lista.add(new obj_cuatro_campos(rs.getString("tc_idn")
                                                , rs.getString("Rut")
                                                , rs.getString("mat_idn")
                                                , rs.getString("tc_promedio")
                                               
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
       
    //-------------------------------------------6------------------------------------------
  /*    public static ArrayList muestra_evaluaciones_alumnos(String evaluacion_ejecucion) {
    ArrayList lista = new ArrayList();
        Connection c=null;
         
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_Asignacion_repechages_muestra_evaluaciones_alumnos (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, evaluacion_ejecucion.trim());
            ResultSet rs = ps.executeQuery();
            
            while (rs.next())
            {
                lista.add(new obj_nueve_campos(rs.getString("not_idn")
                                             , rs.getString("mat_idn"),
                                             rs.getString("alu_rut"),
                                             rs.getString("nombre"),
                                             rs.getString("mal_nombre"),
                                             rs.getString("not_nota"),
                                             rs.getString("trab_idn"),
                                             rs.getString("est_pru_idn"),
                                             rs.getString("est_pru_nombre")));
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
    */
    
         //******************************************************************************
//-------------------------------------------------------------------------
 
 
        //******************************************************************************
 public static ArrayList<?> Asigna_repechages(  String eje_aca_idn,  ArrayList<?> arreglo_seleccionados) {
    
        ArrayList<?> lista = new ArrayList<Object>();
        Connection c=null;
        try {
            c = conexion_odbc.Connexion_datos();
             String sql1;
              int size = arreglo_seleccionados.size();
              obj_un_campo_string registro = null;
                
            int j;
            for (j=0; j<size; j++) 
               {
                    
                        registro = (obj_un_campo_string) arreglo_seleccionados.get(j);
                        sql1 = "{call flex_adm_Asignacion_repechages_asigna_repechages (?,?)}" ;
                        CallableStatement ps1 = c.prepareCall(sql1);
                         ps1.setString(1,eje_aca_idn.trim());
                         ps1.setString(2,registro.getcampo_uno());
                         ps1.execute();
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
     
 //-------------------------------------------------------------------------------------------------------------
 
 //-------------------------------------------------------------------------------------------------------------
 
 
}
