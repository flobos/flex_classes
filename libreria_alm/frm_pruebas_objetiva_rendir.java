/*
 * frm_pruebas_objetiva_rendir.java
 *
 * Created on 3 de mayo de 2010, 12:31
 */

package libreria_alm;
import java.util.ArrayList;
import java.io.Serializable;
import java.sql.*;

/**
 *
 * @author  lobo
 */
public class frm_pruebas_objetiva_rendir {
    
   
    public static ArrayList<Serializable> muestra_preguntas(String tc_idn, String tipo_prueba, String pro_eva_idn ) {
            ArrayList<Serializable> lista = new ArrayList<Serializable>();
            Connection c=null;
            String msg ;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_pruebas_objetiva_rendir_muestra_preguntas_evaluacion (?,?, ?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, tc_idn.trim());
            ps.setString(2, tipo_prueba.trim());
            ps.setString(3, pro_eva_idn.trim());
                    
            ResultSet rs = ps.executeQuery();
            
                
            while (rs.next()){
            
            lista.add(new obj_cuatro_campos(rs.getString("eje_aca_preg_idn"),
                                         rs.getString("eje_aca_preg_pregunta"),
                                         rs.getString("eje_aca_preg_arch_imagen"),
                                         rs.getString("preg_idn")));       
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            lista.remove(0);
            msg = e.getMessage();
            lista.add(new obj_un_campo_string(msg));
            
        } finally {
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
                
         return lista;
  }
    
    
  
    public static ArrayList<Serializable> muestra_respuestas(int codigo_pregunta ) {
            ArrayList<Serializable> lista = new ArrayList<Serializable>();
            Connection c=null;
            String msg ;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_pruebas_objetiva_rendir_muestra_respuestas (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setInt(1,codigo_pregunta);
            
                    
            ResultSet rs = ps.executeQuery();
            
                
            
            while (rs.next()){
            
            lista.add(new obj_tres_campos_combo(rs.getString("eje_aca_preg_res_idn"),
                                          rs.getString("eje_aca_res_respuesta"),
                                          rs.getString("eje_aca_preg_idn")));       
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            lista.remove(0);
            msg = e.getMessage();
            lista.add(new obj_un_campo_string(msg));
            
        } finally {
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
                
         return lista;
  }
    
    
     public static ArrayList<obj_un_campo_string> genera_trabajo(String tc_idn, String tipo_prueba, String pro_eva_idn ) {
            ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
            Connection c=null;
            try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_pruebas_objetiva_rendir_inserta_trabajo_evaluaciones (?,?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
             ps.setString(1, tc_idn.trim());
            ps.setString(2, tipo_prueba.trim());
            ps.setString(3, pro_eva_idn.trim());
            
            ResultSet rs = ps.executeQuery(); 
            
            while (rs.next()){
            
            lista.add(new obj_un_campo_string(rs.getString("trab_idn")));       
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
     
       public static ArrayList<?> genera_respuestas_alumnos(String trabajo, ArrayList<?> pretomas_aceptadas ) {
    
        ArrayList<?> lista = new ArrayList<Object>();
        Connection c=null;
        try {
             String sql;
             int size = pretomas_aceptadas.size();
         String registro = null;
                
            int j;
            for (j=0; j<size; j++) 
               {
                       c = conexion_odbc.Connexion_datos();
                       registro = (String)pretomas_aceptadas.get(j);
                       sql = "{call frm_pruebas_objetiva_rendir_inserta_respuestas (?,?)}";
                       CallableStatement ps1 = c.prepareCall(sql);
                       ps1.setString(1,trabajo.trim());
                       ps1.setString(2,registro.trim());
                       
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
       
       
    
     public static ArrayList<Serializable> calcula_nota(String trab_idn ) {
            ArrayList<Serializable> lista = new ArrayList<Serializable>();
            Connection c=null;
            String msg ;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_pruebas_objetiva_rendir_calcula_nota (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, trab_idn.trim());
            
                    
            ResultSet rs = ps.executeQuery();
            
                
            while (rs.next()){
            
            lista.add(new obj_dos_campos(rs.getString("not_nota"),
                                         rs.getString("trab_idn")));       
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            lista.remove(0);
            msg = e.getMessage();
            lista.add(new obj_un_campo_string(msg));
            
        } finally {
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
                
         return lista;
  }
   
    
     public static ArrayList<Serializable> muestra_info_trabajo(String trab_idn ) {
            ArrayList<Serializable> lista = new ArrayList<Serializable>();
            Connection c=null;
            String msg ;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_pruebas_objetiva_rendir_muestra_info_trabajo (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, trab_idn.trim());
            
                    
            ResultSet rs = ps.executeQuery();
            
                
            while (rs.next()){
            
            lista.add(new obj_cuatro_campos(rs.getString("nombre"),
                                            rs.getString("cur_nombre"),
                                            rs.getString("trab_idn"),
                                            rs.getString("tip_pru_nombre")));       
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            lista.remove(0);
            msg = e.getMessage();
            lista.add(new obj_un_campo_string(msg));
            
        } finally {
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
                
         return lista;
  }
     
     
   public static ArrayList<Serializable> muestra_respuestas_trabajo(String trab_idn ) {
            ArrayList<Serializable> lista = new ArrayList<Serializable>();
            Connection c=null;
            String msg ;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_pruebas_objetiva_rendir_muestra_respuestas_trabajo (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, trab_idn.trim());
            
                    
            ResultSet rs = ps.executeQuery();
            
                
            while (rs.next()){
            
            lista.add(new obj_tres_campos(rs.getString("eje_aca_preg_idn"),
                                          rs.getString("eje_aca_res_idn"),
                                          rs.getString("correcta")));       
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            lista.remove(0);
            msg = e.getMessage();
            lista.add(new obj_un_campo_string(msg));
            
        } finally {
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
                
         return lista;
  }
       
   
   public static ArrayList<obj_tres_campos> ingresa_inicio_rendicion(String tc_idn, String tipo_prueba, Integer tiempo_prueba ) {
       ArrayList<obj_tres_campos> lista = new ArrayList<obj_tres_campos>();
       Connection c=null;
       try {
       String sql;
       c = conexion_odbc.Connexion_datos();
       sql = "{call frm_pruebas_objetiva_rendir_inicio_rendicion (?,?,?)}" ;
       CallableStatement ps = c.prepareCall(sql);
        ps.setString(1, tc_idn.trim());
       ps.setString(2, tipo_prueba.trim());
       ps.setInt(3, tiempo_prueba);
       
                  
       ResultSet rs = ps.executeQuery();
       
       
       while (rs.next()){
       
       lista.add(new obj_tres_campos(rs.getString("fecha_inicio_rendicion"),
    		   						rs.getString("fecha_fin_rendicion"),
    		   						rs.getString("segundos_restantes")));       
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
    
    public frm_pruebas_objetiva_rendir() {
    }
    
}
