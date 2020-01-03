/*
 * frm_adm_asistencia_registro.java
 *
 * Created on 25 de marzo de 2008, 11:05 AM
 */

package libreria;
import java.util.ArrayList;
import java.sql.*;


/**
 *
 * @author  Administrador
 */
public class frm_adm_asistencia_registro_por_profesor {
    
    /** Creates a new instance of frm_adm_asistencia_registro */
    public frm_adm_asistencia_registro_por_profesor() {
    }

public static ArrayList<obj_dos_campos> muestra_dias_clases_por_profesor(int cla_idn) {
    ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_clase_asistencia_muestra_dias_clases_profesor (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setInt(1, cla_idn);
            ResultSet rs = ps.executeQuery();
            
            lista.add(new obj_dos_campos("0","-- Seleccione --"));
            
            while (rs.next())
            {
                lista.add(new obj_dos_campos(rs.getString("cla_idn")
                                             , rs.getString("fecha")));
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
 
  //-----------------------------------------------------------------------------------
 public static ArrayList<obj_dos_campos> muestra_dias_clases(int funcion_modalidad) {
    ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_clase_asistencia_muestra_dias_clases (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setInt(1, funcion_modalidad);
            ResultSet rs = ps.executeQuery();
            
            lista.add(new obj_dos_campos("0","-- Seleccione --"));
            
            while (rs.next())
            {
                lista.add(new obj_dos_campos(rs.getString("cla_idn")
                                             , rs.getString("fecha")));
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
 
  //--------------------------------------------------------------------------------------------------------
 /*  public static ArrayList muestra_secciones_con_clases(int funcion_modalidad, String fecha_clase) {
    ArrayList lista = new ArrayList();
        Connection c=null;
         
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_clase_asistencia_muestra_secciones_con_clases (?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setInt(1, funcion_modalidad);
            ps.setString(2, fecha_clase.trim());
            ResultSet rs = ps.executeQuery();
            
            lista.add(new obj_dos_campos("0","-- Seleccione --"));
            
            while (rs.next())
            {
                lista.add(new obj_dos_campos(rs.getString("cla_idn")
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
    }*/
   //------------------------------------------------------------------------------------------------
    public static ArrayList<obj_dos_campos> muestra_secciones_con_clases(int funcion_modalidad) {
    ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_clase_asistencia_muestra_secciones_con_clases_profesor (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setInt(1, funcion_modalidad);
          //  ps.setString(2, fecha_clase.trim());
            ResultSet rs = ps.executeQuery();
            
            lista.add(new obj_dos_campos("0","-- Seleccione --"));
            
            while (rs.next())
            {
                lista.add(new obj_dos_campos(rs.getString("cla_idn")
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
   //----------------------------------------------------------------------------------------------
   
    public static ArrayList<obj_cinco_campos> muestra_alumnos_seccion(String clase) {
    ArrayList<obj_cinco_campos> lista = new ArrayList<obj_cinco_campos>();
        Connection c=null;
         
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_clase_asistencia_muestra_alumnos_seccion (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, clase);
            ResultSet rs = ps.executeQuery();
                  
            while (rs.next())
            {
                lista.add(new obj_cinco_campos(rs.getString("mat_idn"), 
                                                 rs.getString("alu_rut"),
                                                rs.getString("nombre"),
                                                rs.getString("mal_nombre"),
                                                rs.getString("alu_idn")));
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
    
 //******************************************************************************
    public static ArrayList<?> guarda_alumnos_con_asistencia(String cla_idn, ArrayList<?> arreglo_seleccionados) {
    
       ArrayList<?> lista = new ArrayList<Object>();
        Connection c=null;
        try {
            c = conexion_odbc.Connexion_datos();
             String sql1;
              int size = arreglo_seleccionados.size();
              obj_dos_campos registro = null;
                
            int j;
            for (j=0; j<size; j++) 
               {
                    
                        registro = (obj_dos_campos) arreglo_seleccionados.get(j);
                        sql1 = "{call frm_adm_asistencia_registro_ingresa_alumnos_con_asistencia (?,?,?)}" ;
                        CallableStatement ps1 = c.prepareCall(sql1);
                         ps1.setString(1,cla_idn.trim());
                         ps1.setString(2,registro.getdata());
                         ps1.setString(3,registro.getlabel());
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

//******************************************
      public static ArrayList<obj_un_campo_string> busca_asistencia(int clase) {
    ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
        Connection c=null;
         
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_adm_asistencia_registro_busca_asistencia(?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setInt(1, clase);
            ResultSet rs = ps.executeQuery();
                  
            while (rs.next())
            {
                lista.add(new obj_un_campo_string(rs.getString("alu_idn")));
                                              
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
    
    
    
//****************************************

}
