/*
 * frm_pretoma_alumno.java
 *
 * Created on 11 de enero de 2007, 14:25
 */

package libreria_alm;

import java.util.ArrayList;
import java.io.Serializable;
import java.sql.*;


/**
 *
 * @author  Administrador
 */
public class frm_pretoma_alumno {
    

        public static ArrayList<Serializable> pretoma_muestra(String matricula, String ejecucion) {
            ArrayList<Serializable> lista = new ArrayList<Serializable>();
            Connection c=null;
            String msg ;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_pretoma_muestra_cursos_a_confirmar (?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, matricula.trim());
            ps.setString(2, ejecucion.trim());
           
            ResultSet rs = ps.executeQuery();
        
            while (rs.next()){
            
      
            lista.add(new obj_cinco_campos(rs.getString("pre_prod_mal_idn"),
                                           rs.getString("cur_nombre"),
                                           rs.getString("est_pre_tom_nombre"),
                                           rs.getString("pre_prod_sit_idn"),
                                           rs.getString("pre_prod_sit_nombre")));       
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
    
        
        
        
           public static ArrayList<Serializable> pretoma_valida_pretoma_abierta(String matricula) {
            ArrayList<Serializable> lista = new ArrayList<Serializable>();
            Connection c=null;
            String msg ;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_pretoma_valida_pretoma_abierta (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, matricula.trim());
                       
            ResultSet rs = ps.executeQuery();
        
            while (rs.next()){
            
      
            lista.add(new obj_cinco_campos(rs.getString("pre_tom_idn"),
                                           rs.getString("pre_tom_fecha"),
                                           rs.getString("eje_idn"),
                                           rs.getString("eje_nombre"),
                                           rs.getString("pre_est_nombre")));       
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
           
           
      public static ArrayList<?> cambia_estados_en_pretoma(int codigo_pretoma, ArrayList<?> pretomas_aceptadas ) {
    
        ArrayList<?> lista = new ArrayList<Object>();
        Connection c=null;
        try {
            
   
           
             String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_pretoma_update_pretoma (?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setInt(1,codigo_pretoma);
            ps.setInt(2,102); // Por defecto envia 102 que es "Validada por alumno"
            
             ps.execute();
            
             String sql1;
              int size = pretomas_aceptadas.size();
              obj_dos_campos registro = null;
                
            int j;
            for (j=0; j<size; j++) 
               {
                    
                       registro = (obj_dos_campos) pretomas_aceptadas.get(j);
                        sql1 = "{call flex_pretoma_update_pretoma_productos (?,?)}" ;
                        CallableStatement ps1 = c.prepareCall(sql1);
                        ps1.setInt(1, Integer.parseInt(registro.getdata()));
                        ps1.setInt(2, 103);// Por defecto envia 103 que es "Confimado para pretomar por alumno"
                       
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
    
    
    
    public frm_pretoma_alumno() {
    }
    





}
