/*
 * frm_biblioteca_material_recepcion.java
 *
 * Created on 14 de abril de 2009
 */

package libreria;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author Joliveros
 */
public class frm_objetivas_ingreso_preguntas {
    
    
//******************************************************************************************************************************************************    
     public static ArrayList<obj_dos_campos> muestra_tipo_pregunta () {
         ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_objetivas_ingreso_preguntas_muestra_tip_pregunta()}" ;
            CallableStatement ps = c.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            
            lista.add(new obj_dos_campos("0", "-- Seleccione --")); 
            
             while (rs.next()){
            
                lista.add(new obj_dos_campos(rs.getString("tip_preg_idn"),
                                             rs.getString("tip_preg_tipo")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally 
          {
            try 
            {
                c.close();
            } 
            catch (SQLException e) 
            {
                e.printStackTrace();
            }
          }
         return lista;
   }  
//******************************************************************************************************************************************************    
     public static ArrayList<obj_dos_campos> muestra_clase () {
        ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_objetivas_ingreso_preguntas_muestra_clases ()}" ;
            CallableStatement ps = c.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            
            lista.add(new obj_dos_campos("0", "-- Seleccione --")); 
            
             while (rs.next()){
            
                lista.add(new obj_dos_campos(rs.getString("cla_idn"),
                                             rs.getString("cla_nombre")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally 
          {
            try 
            {
                c.close();
            } 
            catch (SQLException e) 
            {
                e.printStackTrace();
            }
          }
         return lista;
   }       
//******************************************************************************************************************************************************    
     public static ArrayList<obj_tres_campos> muestra_preguntas_asignadas (String pro_cam_idn, String uni_idn, String func_mod_fun_idn) {
         ArrayList<obj_tres_campos> lista = new ArrayList<obj_tres_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_objetivas_ingreso_preguntas_muestra_asigandas (?,?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, pro_cam_idn.trim());
            ps.setString(2, uni_idn.trim());
            ps.setString(3, func_mod_fun_idn.trim());
            
            ResultSet rs = ps.executeQuery();
            
                        
             while (rs.next()){
            
                lista.add(new obj_tres_campos(rs.getString("preg_mod_cam_idn"),
                                             rs.getString("preg_pregunta"),
                                             rs.getString("tip_preg_tipo")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally 
          {
            try 
            {
                c.close();
            } 
            catch (SQLException e) 
            {
                e.printStackTrace();
            }
          }
         return lista;
   }  
     
//******************************************************************************************************************************************************        
     public static ArrayList<?> asigna_pregunta (ArrayList<?> arreglo_coleccion) {
        ArrayList<?> lista = new ArrayList<Object>();
        Connection c=null;
         try {
            
            
            c = conexion_odbc.Connexion_datos();
                
            if (arreglo_coleccion.size() > 0)
            {
                int i_asignados;
                int size_asignados = arreglo_coleccion.size();
                                
                obj_cuatro_campos reg_asignados = null;
                
                String sql;
                
                for (i_asignados=0; i_asignados<size_asignados; i_asignados++) 
                {               
                    reg_asignados = (obj_cuatro_campos)arreglo_coleccion.get(i_asignados);
                    
                    c = conexion_odbc.Connexion_datos();
                    
                    sql = "{call frm_objetivas_asigna_preguntas_ramo_asigna (?,?,?,?)}" ;
                    CallableStatement ps1 = c.prepareCall(sql);
                    ps1.setString(1, reg_asignados.getcampo_uno().trim());  
                    ps1.setString(2, reg_asignados.getcampo_dos().trim());  
                    ps1.setString(3, reg_asignados.getcampo_tres().trim());  
                    ps1.setString(4, reg_asignados.getcampo_cuatro().trim());  
                   
                    ps1.execute();          
                }   
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
//******************************************************************************************************************************************************  
     public static ArrayList<obj_dos_campos> muestra_unidades () {
         ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_objetivas_ingreso_preguntas_muestra_unidades}" ;
            CallableStatement ps = c.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
                        
            lista.add(new obj_dos_campos("0", "-- Seleccione --")); 
            while (rs.next()){
            
             
                lista.add(new obj_dos_campos(rs.getString("uni_idn"),
                                             rs.getString("uni_nombre")));
           
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
//******************************************************************************************************************************************************  
     public static ArrayList<obj_dos_campos> muestra_ramos (String func_mod_fun_idn) {
         ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_objetivas_ingreso_preguntas_muestra_ramos (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, func_mod_fun_idn.trim());
            ResultSet rs = ps.executeQuery();
                        
            lista.add(new obj_dos_campos("0", "-- Seleccione --")); 
            while (rs.next()){
            
             
                lista.add(new obj_dos_campos(rs.getString("pro_cam_idn"),
                                             rs.getString("cur_nombre")));
           
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
//******************************************************************************************************************************************************  
     public static ArrayList<obj_dos_campos> agrega_pregunta (String tip_preg_idn, String preg_pregunta, String preg_pauta, String preg_arch_adjunto, String func_mod_fun_idn, String url_imagen) {
         ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_objetivas_ingreso_preguntas_agrega_preguntas (?,?,?,?,?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, tip_preg_idn.trim());
            ps.setString(2, preg_pregunta.trim());
            ps.setString(3, preg_pauta.trim());
            ps.setString(4, preg_arch_adjunto.trim());
            ps.setString(5, func_mod_fun_idn.trim());
            ps.setString(6, url_imagen.trim());
            ResultSet rs = ps.executeQuery();
                        
            while (rs.next())
            {

                lista.add(new obj_dos_campos(rs.getString("preg_idn"), 
                                             rs.getString("preg_mod_cam_idn")));
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
//******************************************************************************************************************************************************  
     public static ArrayList<?> modifica_pregunta (String preg_idn, String tip_preg_idn, String preg_pregunta, String preg_pauta, String preg_arch_adjunto, String mod_ejecuciones, String imagen_adjunta) {
         ArrayList<?> lista = new ArrayList<Object>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_objetivas_ingreso_preguntas_modifica_preguntas (?,?,?,?,?,?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, preg_idn.trim());
            ps.setString(2, tip_preg_idn.trim());
            ps.setString(3, preg_pregunta.trim());
            ps.setString(4, preg_pauta.trim());
            ps.setString(5, preg_arch_adjunto.trim());
            ps.setString(6, mod_ejecuciones.trim());
            ps.setString(7, imagen_adjunta.trim());
            ps.executeQuery();
                        
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
//******************************************************************************************************************************************************  
     //String preg_idn, String res_idn, String res_respuesta, String res_correcta, String res_arch_adjunto
     public static ArrayList<?> agrega_respuesta (ArrayList<?> arreglo_coleccion) {
         ArrayList<?> lista = new ArrayList<Object>();
        Connection c=null;
         try {
            
            if (arreglo_coleccion.size() > 0)
            {
                int i_asignados;
                int size_asignados = arreglo_coleccion.size();
                                
                obj_cinco_campos reg_asignados = null;
                String sql;
                
                for (i_asignados=0; i_asignados<size_asignados; i_asignados++) 
                {               
                    reg_asignados = (obj_cinco_campos)arreglo_coleccion.get(i_asignados);
                    
                    c = conexion_odbc.Connexion_datos();
                    
                    sql = "{call frm_objetivas_ingreso_preguntas_agrega_respuestas (?,?,?,?,?)}" ;
                    CallableStatement ps1 = c.prepareCall(sql);
                    ps1.setString(1, reg_asignados.getcampo_uno().trim());  
                    ps1.setString(2, reg_asignados.getcampo_dos().trim());  
                    ps1.setString(3, reg_asignados.getcampo_tres().trim());  
                    ps1.setString(4, reg_asignados.getcampo_cuatro().trim());  
                    ps1.setString(5, reg_asignados.getcampo_cinco().trim());  
                    
                    ps1.execute();          
                }   
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
//******************************************************************************************************************************************************  
     public static ArrayList<?> modifica_respuesta(String res_idn, String preg_idn, String res_respuesta, String res_correcta, String res_arch_adjunto, String mod_ejecuciones) {
         ArrayList<?> lista = new ArrayList<Object>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_objetivas_ingreso_preguntas_modifica_respuestas (?,?,?,?,?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, res_idn.trim());
            ps.setString(2, preg_idn.trim());
            ps.setString(3, res_respuesta.trim());
            ps.setString(4, res_correcta.trim());
            ps.setString(5, res_arch_adjunto.trim());
            ps.setString(6, mod_ejecuciones.trim());

            ps.execute();            

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
//******************************************************************************************************************************************************  
     public static ArrayList<?> elimina_respuestas_pregunta(String preg_idn) {
         ArrayList<?> lista = new ArrayList<Object>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_objetivas_ingreso_preguntas_elimina_respuestas_pregunta (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            
            ps.setString(1, preg_idn.trim());
            
            ps.execute();            

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

//******************************************************************************************************************************************************  
     public static ArrayList<obj_siete_campos> busca_pregunta (String tipo_busqueda, String criterio, String tip_preg_idn, String func_mod_fun_idn) {
         ArrayList<obj_siete_campos> lista = new ArrayList<obj_siete_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_objetivas_ingreso_preguntas_busca_pregunta (?,?,?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, tipo_busqueda.trim());
            ps.setString(2, criterio.trim());
            ps.setString(3, tip_preg_idn.trim());
            ps.setString(4, func_mod_fun_idn.trim());
            

            ResultSet rs = ps.executeQuery();
                        
            while (rs.next())
            {
                lista.add(new obj_siete_campos(rs.getString("preg_idn"),
                                              rs.getString("preg_pregunta"),
                                              rs.getString("tip_preg_idn"),
                                              rs.getString("tip_preg_tipo"),
                                              rs.getString("preg_pauta"),
                                              rs.getString("preg_mod_cam_idn"),
                                              rs.getString("preg_arch_imagen")));
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


//******************************************************************************************************************************************************    
    public static ArrayList<obj_tres_campos> busca_respuesta (String preg_idn) {
         ArrayList<obj_tres_campos> lista = new ArrayList<obj_tres_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_objetivas_ingreso_preguntas_busca_respuesta (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, preg_idn.trim());
            
            

            ResultSet rs = ps.executeQuery();
                        
            while (rs.next())
            {
                lista.add(new obj_tres_campos(rs.getString("res_idn"),
                                                rs.getString("res_respuesta"),
                                                rs.getString("res_correcta")));
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
//******************************************************************************************************************************************************    
    public static ArrayList<?> elimina_pregunta (String preg_idn) {
         ArrayList<?> lista = new ArrayList<Object>();
        Connection c=null;
         try 
        {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_objetivas_ingreso_preguntas_elimina_pregunta (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, preg_idn.trim());
            ps.executeQuery();

        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        } 
        finally 
        {
            try 
            {
                c.close();
            } 
            catch (SQLException e) 
            {
                e.printStackTrace();
            }
        }
         return lista;
   }


//******************************************************************************************************************************************************        
    public frm_objetivas_ingreso_preguntas() {
    }
    
}
