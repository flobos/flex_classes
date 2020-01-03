/*
 * frm_encuesta_contesta.java
 *
 * Created on 4 de abril de 2007, 15:54
 */

package libreria_alm;
import java.util.ArrayList;
import java.io.Serializable;
import java.sql.*;




/**
 *
 * @author  Administrador
 */
public class frm_encuesta_contesta {
    
       public static ArrayList<obj_dos_campos> encuesta_muestra_alumno(String ejecucion_academica) {
      ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_encuesta_muestra_alumno (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
             ps.setString(1, ejecucion_academica.trim());                     
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos (rs.getString("enc_idn"), 
                                             rs.getString("enc_nombre")));
           
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
       
       
       
      public static ArrayList<obj_tres_campos> encuesta_muestra_preguntas_tipo_nota(int codigo_encuestas) {
      ArrayList<obj_tres_campos> lista = new ArrayList<obj_tres_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_encuesta_muestra_preguntas_alumno_tipo_nota (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
             ps.setInt(1, codigo_encuestas);                     
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
      
            lista.add(new obj_tres_campos (rs.getString("enc_pre_idn"), 
                                             rs.getString("enc_pre_pregunta"),
                                             rs.getString("tip_pre_nombre")));
           
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
      
      
      public static ArrayList<obj_tres_campos> encuesta_muestra_preguntas_tipo_desarrollo(int codigo_encuestas) {
      ArrayList<obj_tres_campos> lista = new ArrayList<obj_tres_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_encuesta_muestra_preguntas_alumno_tipo_desarrollo (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
             ps.setInt(1, codigo_encuestas);                     
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
      
            lista.add(new obj_tres_campos (rs.getString("enc_pre_idn"), 
                                             rs.getString("enc_pre_pregunta"),
                                             rs.getString("tip_pre_nombre")));
           
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
      
      
      
     public static ArrayList<Serializable> encuesta_inserta_encuesta_pregunta_alumno(String toma_cursos , int codigo_encuesta, ArrayList<?> preguntas) {
            ArrayList<Serializable> lista = new ArrayList<Serializable>();
            Connection c=null;
            int identidad;
             obj_un_campo registro_identidad = null;
            String msg ;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_encuesta_inserta_encuesta_alumno (?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, toma_cursos.trim());
            ps.setInt(2, codigo_encuesta);
                       
            ResultSet rs = ps.executeQuery();
        
            while (rs.next()){
            
      
            lista.add(new obj_un_campo(rs.getInt("identidad")));       
            }
            
                  
              registro_identidad = (obj_un_campo) lista.get(0);
            
            identidad = registro_identidad.getvalor();
            
            
            
              String sql1;
              int size = preguntas.size();
              obj_dos_campos registro = null;
              
            int j;
            for (j=0; j<size; j++) 
               {
                    
                       registro = (obj_dos_campos) preguntas.get(j);
                        sql1 = "{call flex_adm_encuesta_inserta_pregunta_alumno (?,?,?)}" ;
                        CallableStatement ps1 = c.prepareCall(sql1);
                        ps1.setInt(1,identidad );
                        ps1.setInt(2, Integer.parseInt(registro.getdata()));
                        ps1.setString(3, registro.getlabel());
                       
                        ps1.execute();
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
      
     
   
    
    
    
    public frm_encuesta_contesta() {
    }
    
}
