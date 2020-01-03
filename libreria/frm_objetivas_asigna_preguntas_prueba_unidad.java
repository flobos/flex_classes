/*
 * frm_objetivas_asigna_prueba_unidad.java
 *
 * Created on 27 de abril de 2009, 09:12 AM
 */

package libreria;
import java.util.ArrayList;
import java.sql.*;


import java.lang.Object;

import java.security.spec.AlgorithmParameterSpec; 
import java.security.spec.KeySpec; 

import javax.crypto.Cipher; 
import javax.crypto.SecretKey; 
import javax.crypto.SecretKeyFactory; 
import javax.crypto.spec.PBEKeySpec; 
import javax.crypto.spec.PBEParameterSpec;
/**
 *
 * @author  JOliveros
 */
public class frm_objetivas_asigna_preguntas_prueba_unidad {
    
//***********************************************************************************************************    
    private static byte[]	SALT_BYTES	 = { (byte) 0xA9, (byte) 0x9B, (byte) 0xC8, (byte) 0x32, (byte) 0x56, (byte) 0x35, (byte) 0xE3, (byte) 0x03 }; 

    private static int	 ITERATION_COUNT	= 19; 
//***********************************************************************************************************
    /** Creates a new instance of frm_objetivas_asigna_prueba_unidad */
    public frm_objetivas_asigna_preguntas_prueba_unidad() {
    }
    
//******************************************************************************************************************************************************    
    public static ArrayList<obj_dos_campos> muestra_ejecuciones(String func_mod_fun_idn) {
      ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_objetivas_asigna_prueba_unidad_muestra_ejecuciones (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, func_mod_fun_idn.trim());
                      
            ResultSet rs = ps.executeQuery();

            lista.add(new obj_dos_campos("0"," - Seleccione - "));

            while (rs.next())
            {
      
                lista.add(new obj_dos_campos (rs.getString("eje_idn"), 
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

//******************************************************************************************************************************************************       
    public static ArrayList<obj_combo_tres_campos> muestra_ramos_ejecucion(String eje_idn) {
      ArrayList<obj_combo_tres_campos> lista = new ArrayList<obj_combo_tres_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_objetivas_asigna_preguntas_prueba_unidad_muestra_ramos_ejecucion (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, eje_idn.trim());
                      
            ResultSet rs = ps.executeQuery();
            lista.add(new obj_combo_tres_campos("0","0"," - Seleccione - "));
            while (rs.next())
            {
      
                lista.add(new obj_combo_tres_campos (rs.getString("eje_aca_idn"), 
                                                     rs.getString("pro_cam_idn"),
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
    public static ArrayList<obj_combo_tres_campos> muestra_tipo_prueba(String eje_aca_idn) {
      ArrayList<obj_combo_tres_campos> lista = new ArrayList<obj_combo_tres_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_objetivas_asigna_preguntas_prueba_unidad_muestra_pruebas (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, eje_aca_idn.trim());
                      
            ResultSet rs = ps.executeQuery();

            lista.add(new obj_combo_tres_campos("0","0"," - Seleccione - "));

            while (rs.next())
            {
      
                lista.add(new obj_combo_tres_campos (rs.getString("tip_pru_idn"),
                                              rs.getString("eva_eje_idn"),   
                                              rs.getString("tip_pru_nombre")));
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
public static ArrayList<obj_cinco_campos> muestra_detalle_prueba(String eva_eje_idn) {
      ArrayList<obj_cinco_campos> lista = new ArrayList<obj_cinco_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_objetivas_asigna_preguntas_prueba_unidad_popup_detalle (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, eva_eje_idn.trim());
                      
            ResultSet rs = ps.executeQuery();

            while (rs.next())
            {
      
                lista.add(new obj_cinco_campos (rs.getString("uni_nombre"),
                                                rs.getString("tip_preg_tipo"),   
                                                rs.getString("eva_eje_tip_pru_cantidad"),
                                                rs.getString("eva_eje_tip_pru_puntaje"),
                                                rs.getString("cla_nombre")
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

//******************************************************************************************************************************************************  
public static ArrayList<obj_seis_campos> muestra_detalle_prueba_cantidades(String eva_eje_idn) {
      ArrayList<obj_seis_campos> lista = new ArrayList<obj_seis_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_objetivas_asigna_preguntas_prueba_unidad_detalle_cantidades (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, eva_eje_idn.trim());
                      
            ResultSet rs = ps.executeQuery();

            while (rs.next())
            {
      
                lista.add(new obj_seis_campos (rs.getString("cant_obj"),
                                                 rs.getString("punt_obj"),   
                                                 rs.getString("cant_des"),
                                                 rs.getString("punt_des"), 
                                                 rs.getString("puntaje"), 
                                                 rs.getString("exigencia")));
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
     public static ArrayList<obj_dos_campos> muestra_tipo_pregunta () {
         ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_objetivas_ingreso_preguntas_muestra_tip_pregunta ()}" ;
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
     public static ArrayList<obj_nueve_campos> muestra_preguntas (String pro_cam_idn, String eva_eje_idn, String tip_preg_idn, String func_mod_fun_idn) {
         ArrayList<obj_nueve_campos> lista = new ArrayList<obj_nueve_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_objetivas_asigna_preguntas_prueba_unidad_muestra_preguntas (?,?,?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, pro_cam_idn.trim());
            ps.setString(2, eva_eje_idn.trim());
            ps.setString(3, tip_preg_idn.trim());
            ps.setString(4, func_mod_fun_idn.trim());
            ResultSet rs = ps.executeQuery();
            
             while (rs.next()){
            
                lista.add(new obj_nueve_campos( rs.getString("preg_idn"), 
                                                rs.getString("preg_pregunta"),  
                                                rs.getString("preg_pauta"), 
                                                rs.getString("tip_preg_idn"), 
                                                rs.getString("tip_preg_tipo"), 
                                                rs.getString("uni_idn"),
                                                rs.getString("uni_nombre"),
                                                rs.getString("cla_nombre"),
                                                rs.getString("cla_idn")
                                                ));
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
     public static ArrayList<obj_cuatro_campos> muestra_preguntas_asignadas (String eva_eje_idn, String tip_preg_idn) {
         ArrayList<obj_cuatro_campos> lista = new ArrayList<obj_cuatro_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_objetivas_asigna_preguntas_prueba_unidad_muestra_preguntas_asignadas (?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, eva_eje_idn.trim());
            ps.setString(2, tip_preg_idn.trim());
            ResultSet rs = ps.executeQuery();
            
             while (rs.next()){
            
                lista.add(new obj_cuatro_campos( rs.getString("preg_idn"), 
                                                rs.getString("eje_aca_preg_pregunta"),  
                                                rs.getString("uni_nombre"), 
                                                rs.getString("cla_nombre")
                                                ));
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
     public static ArrayList<?> asigna_preguntas (ArrayList<?> arreglo_coleccion) {
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
                    
                    sql = "{call frm_objetivas_asigna_preguntas_prueba_unidad_asigna_pregunta (?,?,?,?)}" ;
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
     public static ArrayList<obj_un_campo> desasigna_preguntas (String eje_aca_idn, String uni_nombre, String cla_nombre, String preg_idn) {
        ArrayList<obj_un_campo> lista = new ArrayList<obj_un_campo>();
        Connection c=null;
         try {
                String sql;
                
                c = conexion_odbc.Connexion_datos();
                  
                sql = "{call frm_objetivas_asigna_preguntas_prueba_unidad_desasigna_pregunta (?,?,?,?)}" ;
                CallableStatement ps1 = c.prepareCall(sql);
                ps1.setString(1, eje_aca_idn.trim());  
                ps1.setString(2, uni_nombre.trim());  
                ps1.setString(3, cla_nombre.trim());  
                ps1.setString(4, preg_idn.trim());
                ResultSet rs = ps1.executeQuery();  
                
                while (rs.next()){
                    lista.add(new obj_un_campo( rs.getString("eje_aca_uni_idn")));
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

    public static ArrayList<obj_un_campo_string> desencriptar_func_mod_fun_idn(String frase, String func_mod_fun_idn) {
        ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
        Cipher ecipher = null; 
        Cipher dcipher = null;
        try {
            
            KeySpec keySpec = new PBEKeySpec(frase.toCharArray(), SALT_BYTES, ITERATION_COUNT); 
            SecretKey key = SecretKeyFactory.getInstance("PBEWithMD5AndDES").generateSecret(keySpec); 
            ecipher = Cipher.getInstance(key.getAlgorithm()); 
            dcipher = Cipher.getInstance(key.getAlgorithm()); 

            // Preparar los parametros para los ciphers 
            AlgorithmParameterSpec paramSpec = new PBEParameterSpec(SALT_BYTES, ITERATION_COUNT); 

            // Crear los ciphers 
            ecipher.init(Cipher.ENCRYPT_MODE, key, paramSpec); 
            dcipher.init(Cipher.DECRYPT_MODE, key, paramSpec); 

            // Decodear base64 y obtener bytes 
            byte[] dec = new sun.misc.BASE64Decoder().decodeBuffer(func_mod_fun_idn); 

            // Desencriptar 
            byte[] utf8 = dcipher.doFinal(dec); 

            // Decodear usando utf-8 
            lista.add(new obj_un_campo_string(new String(utf8, "UTF8"))); 
            
            
        } catch (Exception e) {
            e.printStackTrace();
        } 
         return lista;
   }
//******************************************************************************************************************************************************          
    
    
}
