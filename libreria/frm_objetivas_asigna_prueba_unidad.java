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
public class frm_objetivas_asigna_prueba_unidad {
    
//***********************************************************************************************************    
    private static byte[]	SALT_BYTES	 = { (byte) 0xA9, (byte) 0x9B, (byte) 0xC8, (byte) 0x32, (byte) 0x56, (byte) 0x35, (byte) 0xE3, (byte) 0x03 }; 

    private static int	 ITERATION_COUNT	= 19; 
//***********************************************************************************************************
    /** Creates a new instance of frm_objetivas_asigna_prueba_unidad */
    public frm_objetivas_asigna_prueba_unidad() {
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
    public static ArrayList<obj_cuatro_campos> muestra_ramos_ejecucion(String eje_idn, String tip_pru_idn, String pro_eva_idn) {
      ArrayList<obj_cuatro_campos> lista = new ArrayList<obj_cuatro_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_objetivas_asigna_prueba_unidad_muestra_ramos_ejecucion (?,?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, eje_idn.trim());
            ps.setString(2, tip_pru_idn.trim());
            ps.setString(3, pro_eva_idn.trim());
                      
            ResultSet rs = ps.executeQuery();

            while (rs.next())
            {
      
                lista.add(new obj_cuatro_campos (rs.getString("eva_eje_idn"), 
                                                  rs.getString("cur_nombre"), 
                                                  rs.getString("tip_jor_nombre"), 
                                             rs.getString("sec_nombre")));
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
    public static ArrayList<obj_diez_campos> muestra_ramos_ejecucion_con_prueba(String eje_idn, String tip_pru_idn, String pro_eva_idn) {
      ArrayList<obj_diez_campos> lista = new ArrayList<obj_diez_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_objetivas_asigna_prueba_unidad_muestra_ramos_ejecucion_con_prueba (?,?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, eje_idn.trim());
            ps.setString(2, tip_pru_idn.trim());
            ps.setString(3, pro_eva_idn.trim());
                      
            ResultSet rs = ps.executeQuery();

            while (rs.next())
            {
      
                lista.add(new obj_diez_campos (rs.getString("eva_eje_idn"), 
                                                rs.getString("cur_nombre"), 
                                                rs.getString("tip_jor_nombre"), 
                                                rs.getString("sec_nombre"), 
                                                rs.getString("tip_pru_nombre"), 
                                                rs.getString("uni_nombre"), 
                                                rs.getString("cla_nombre"),
                                                rs.getString("tip_preg_tipo"), 
                                                rs.getString("eva_eje_tip_pru_cantidad"), 
                                                rs.getString("eva_eje_tip_pru_puntaje")));
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
    public static ArrayList<obj_tres_campos> muestra_tipo_prueba(String eje_idn) {
      ArrayList<obj_tres_campos> lista = new ArrayList<obj_tres_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_objetivas_asigna_prueba_unidad_muestra_tipo_prueba (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, eje_idn.trim());
                      
            ResultSet rs = ps.executeQuery();

            lista.add(new obj_tres_campos("0"," - Seleccione - ","0"));

            while (rs.next())
            {
      
                lista.add(new obj_tres_campos (rs.getString("tip_pru_idn"), 
                							 rs.getString("tip_pru_nombre"),
                                             rs.getString("pro_eva_idn")));
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
     public static ArrayList<?> guarda_prueba_unidad (ArrayList<?> arreglo_coleccion, String puntaje, String porcentaje, String tiempo) {
         ArrayList<?> lista = new ArrayList<Object>();
        Connection c=null;
         try {
            
            
            if (arreglo_coleccion.size() > 0)
            {
                int i_asignados;
                int size_asignados = arreglo_coleccion.size();
                                
                obj_seis_campos reg_asignados = null;
                String sql;
                
                for (i_asignados=0; i_asignados<size_asignados; i_asignados++) 
                {               
                    reg_asignados = (obj_seis_campos)arreglo_coleccion.get(i_asignados);
                    
                    c = conexion_odbc.Connexion_datos();
                    
                    sql = "{call frm_objetivas_asigna_prueba_unidad_guarda_prueba_unidad (?,?,?,?,?,?,?,?,?)}" ;
                    CallableStatement ps1 = c.prepareCall(sql);
                    ps1.setString(1, reg_asignados.getcampo_uno().trim());  
                    ps1.setString(2, reg_asignados.getcampo_dos().trim());  
                    ps1.setString(3, reg_asignados.getcampo_tres().trim());  
                    ps1.setString(4, reg_asignados.getcampo_cuatro().trim());  
                    ps1.setString(5, reg_asignados.getcampo_cinco().trim());  
                    ps1.setString(6, puntaje.trim());
                    ps1.setString(7, porcentaje.trim());
                    ps1.setString(8, reg_asignados.getcampo_seis().trim());
                    ps1.setString(9, tiempo.trim());
                    ps1.execute();          
                }   
                
                //sql = "{call frm_objetivas_asigna_prueba_unidad_guarda_puntaje_y_porcentaje (?,?,?)}" ;
                //CallableStatement ps2 = c.prepareCall(sql);
                //ps2.setString(1, eva_eje_idn.trim());  
                //ps2.setString(2, puntaje.trim());  
                //ps2.setString(3, porcentaje.trim());
                //ps2.execute(); 

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
   public static ArrayList<?> elimina_ramos_ok (ArrayList<?> arreglo_coleccion) {
    
        ArrayList<?> lista = new ArrayList<Object>();
        Connection c=null;
        try {
            
            
            if (arreglo_coleccion.size() > 0)
            {
                int i_asignados;
                int size_asignados = arreglo_coleccion.size();
                                
                obj_un_campo_string reg_asignados = null;
                String sql;
                
                for (i_asignados=0; i_asignados<size_asignados; i_asignados++) 
                {               
                    reg_asignados = (obj_un_campo_string)arreglo_coleccion.get(i_asignados);
                    
                    c = conexion_odbc.Connexion_datos();
                    
                    sql = "{call frm_objetivas_asigna_prueba_unidad_elimina_ramos_ejecucion_con_prueba (?)}" ;
                    CallableStatement ps1 = c.prepareCall(sql);
                    ps1.setString(1, reg_asignados.getcampo_uno().trim());  
                    
                    ps1.execute();          
                }   
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
