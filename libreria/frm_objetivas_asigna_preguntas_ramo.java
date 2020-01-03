/*
 * frm_biblioteca_material_recepcion.java
 *
 * Created on 14 de abril de 2009
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
 * @author Joliveros
 */
public class frm_objetivas_asigna_preguntas_ramo {
    
//***********************************************************************************************************    
    private static byte[]	SALT_BYTES	 = { (byte) 0xA9, (byte) 0x9B, (byte) 0xC8, (byte) 0x32, (byte) 0x56, (byte) 0x35, (byte) 0xE3, (byte) 0x03 }; 

    private static int	 ITERATION_COUNT	= 19; 
//***********************************************************************************************************
//******************************************************************************************************************************************************    
     
     public static ArrayList<obj_dos_campos> muestra_unidades () {
         ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_objetivas_asigna_preguntas_ramo_muestra_unidades}" ;
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
     
     public static ArrayList<obj_dos_campos> muestra_clases () {
         ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_objetivas_asigna_preguntas_ramo_muestra_clases}" ;
            CallableStatement ps = c.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
                        
            lista.add(new obj_dos_campos("0", "-- Seleccione --")); 
            while (rs.next()){
            
             
                lista.add(new obj_dos_campos(rs.getString("cla_idn"),
                                             rs.getString("cla_nombre")));
           
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
            sql = "{call frm_objetivas_asigna_preguntas_ramo_muestra_ramos (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, func_mod_fun_idn.trim());
            ResultSet rs = ps.executeQuery();
                        
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
     public static ArrayList<obj_seis_campos> busca_pregunta (String tipo_busqueda, String criterio, String tip_preg_idn, String func_mod_fun_idn) {
         ArrayList<obj_seis_campos> lista = new ArrayList<obj_seis_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_objetivas_asigna_preguntas_ramo_busca_preguntas (?,?,?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, tipo_busqueda.trim());
            ps.setString(2, criterio.trim());
            ps.setString(3, tip_preg_idn.trim());
            ps.setString(4, func_mod_fun_idn.trim());
            

            ResultSet rs = ps.executeQuery();
                        
            while (rs.next())
            {
                lista.add(new obj_seis_campos(rs.getString("preg_idn"),
                                                rs.getString("preg_pregunta"),
                                                rs.getString("tip_preg_idn"),
                                                rs.getString("tip_preg_tipo"),
                                                rs.getString("preg_pauta"),
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
    public static ArrayList<obj_cinco_campos> preguntas_x_tipo (String tip_preg_idn) {
        ArrayList<obj_cinco_campos> lista = new ArrayList<obj_cinco_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_objetivas_asigna_preguntas_ramo_muestra_preguntas_x_tipo (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, tip_preg_idn.trim());

            ResultSet rs = ps.executeQuery();
                        
             while (rs.next())
            {
                lista.add(new obj_cinco_campos(rs.getString("preg_idn"),
                                                rs.getString("preg_pregunta"),
                                                rs.getString("tip_preg_idn"),
                                                rs.getString("tip_preg_tipo"),
                                                rs.getString("preg_pauta")));
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
    public frm_objetivas_asigna_preguntas_ramo() {
    }
    
}
