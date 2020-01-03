package libreria;
import java.util.*;
import java.sql.*;
import java.io.Serializable;
import java.security.spec.AlgorithmParameterSpec; 
import java.security.spec.KeySpec; 
import javax.crypto.Cipher; 
import javax.crypto.SecretKey; 
import javax.crypto.SecretKeyFactory; 
import javax.crypto.spec.PBEKeySpec; 
import javax.crypto.spec.PBEParameterSpec; 

import libreria.conexion_odbc;

import sun.misc.BASE64Encoder; 



public class frm_main_frame {
//***********************************************************************************************************    
    private static byte[]	SALT_BYTES	 = { (byte) 0xA9, (byte) 0x9B, (byte) 0xC8, (byte) 0x32, (byte) 0x56, (byte) 0x35, (byte) 0xE3, (byte) 0x03 }; 

    private static int	 ITERATION_COUNT	= 19; 
//***********************************************************************************************************
    public static void registro_login (String fun_rut) {
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "insert into registro_login_funcionario values ('"+fun_rut.trim()+"', getdate())   " ;
            CallableStatement ps = c.prepareCall(sql);
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
       
   }  
    public static void registro_acceso_menu (String men_idn, String fun_rut) {
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "insert into registro_acceso_sistema values ('"+men_idn.trim()+"','"+ fun_rut.trim()+"', getdate())   " ;
            CallableStatement ps = c.prepareCall(sql);
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
       
   }     
    
    
    
    public static ArrayList<obj_combo_tres_campos> carga_institucion_mod_cam_entidad(int sub_ent_idn) {
      ArrayList<obj_combo_tres_campos> lista = new ArrayList<obj_combo_tres_campos>();
      
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call bfx_adm_main_frame_carga_institucion_mod_cam_sub_entidad (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setInt(1, sub_ent_idn);
            ResultSet rs = ps.executeQuery();

            lista.add(new obj_combo_tres_campos ("0","0","-- Seleccione --"));
            while (rs.next()){
            
      
            lista.add(new obj_combo_tres_campos (rs.getString("inst_edu_idn")
                                                , rs.getString("mod_cam_idn")
                                                , rs.getString("inst_mod_cam_nombre")));
           
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
    public static ArrayList<Serializable> carga_funcion_institucion_mod_cam_entidad(int inst_edu_idn, int sub_ent_idn, int mod_cam_idn) {
      ArrayList<Serializable> lista = new ArrayList<Serializable>();
      
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call bfx_adm_main_frame_carga_funcion_institucion_mod_cam_sub_entidad (?,?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setInt(1, inst_edu_idn);
            ps.setInt(2, sub_ent_idn);
            ps.setInt(3, mod_cam_idn);
            ResultSet rs = ps.executeQuery();
            
            lista.add(new obj_combo_dos_campos ("0","-- Seleccione --"));
            
            while (rs.next()){
            
      
            lista.add(new obj_combo_tres_campos (rs.getString("sub_fun_mod_idn")
                                                , rs.getString("tip_fun_idn")
                                                , rs.getString("sub_ent_funcion_nombre")));
           
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
    public static ArrayList<obj_combo_dos_campos> carga_ejecucion_academica_funcion_modalidad(int sub_fun_mod_idn) {
      ArrayList<obj_combo_dos_campos> lista = new ArrayList<obj_combo_dos_campos>();
      
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call bfx_adm_main_frame_carga_ejecucion_academica_funcion_modalidad (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setInt(1, sub_fun_mod_idn);
            ResultSet rs = ps.executeQuery();
            
            lista.add(new obj_combo_dos_campos ("0","-- Seleccione --"));
            
            while (rs.next()){
            
      
            lista.add(new obj_combo_dos_campos (rs.getString("eje_aca_idn")
                                                , rs.getString("cur_nombre_sec_jor")));
           
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
    public static ArrayList<obj_seis_campos> carga_menus_asignados(String rut) 
    {
        ArrayList<obj_seis_campos> lista = new ArrayList<obj_seis_campos>();
        Connection c=null;
        try 
        {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call bfx_adm_menu_usuario (?)} " ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, rut);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next())
            {
                lista.add(new obj_seis_campos(rs.getString("men_idn"),
                                            rs.getString("men_nombre"),
                                            rs.getString("men_pri_idn"),
                                            rs.getString("men_pri_nombre"),
                                            rs.getString("men_pan_sistema"),
                                            rs.getString("tip_men_pri_idn")));
            }
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
  //-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-
    
    public static ArrayList<obj_cinco_campos> funcionario_muestra_menu(String rut) {
    ArrayList<obj_cinco_campos> lista = new ArrayList<obj_cinco_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_menu_usuario_main (?)} " ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, rut.trim());
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
      
             lista.add(new obj_cinco_campos(rs.getString("men_idn"),
                                            rs.getString("men_nombre"),
                                            rs.getString("men_pri_idn"),
                                            rs.getString("men_pri_nombre"),
                                            rs.getString("men_pan_sistema")));
           
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
     public static ArrayList<obj_combo_tres_campos> muestra_funcion(String rut) {
      ArrayList<obj_combo_tres_campos> lista = new ArrayList<obj_combo_tres_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call  flex_adm_funcion_ejecucion_academica_muestra_funcion  (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,rut.trim());
                                
            ResultSet rs = ps.executeQuery();
            
          lista.add(new obj_combo_tres_campos ("0", "0", "-- Seleccione --"));
          
            while (rs.next()){
            
      
            lista.add(new obj_combo_tres_campos (rs.getString("func_idn"), 
                                                rs.getString("tip_fun_idn"),
                                                rs.getString("func_nombre")));
           
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
   
     public static ArrayList<Serializable> muestra_campus_modalidad(String rut, String funcion) {
      ArrayList<Serializable> lista = new ArrayList<Serializable>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_funcion_ejecucion_academica_muestra_funcion_modalidad_funcionario (?, ?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,rut.trim());
            ps.setString(2,funcion.trim());
                                
            ResultSet rs = ps.executeQuery();
            
            
               lista.add(new obj_dos_campos ("0", "--Seleccione--"));
            
            while (rs.next()){
            
      
            lista.add(new obj_combo_tres_campos (rs.getString("func_mod_fun_idn"), 
                                                rs.getString("mod_idn"), 
                                                rs.getString("nombre")));
           
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
  
  public static ArrayList<obj_tres_campos> muestra_ejecuciones_academicas(int funcion_modalidad) {
      ArrayList<obj_tres_campos> lista = new ArrayList<obj_tres_campos>();
        Connection c=null;
        
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_funcion_ejecucion_academica_muestra_ejecucion_academicas (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setInt(1,funcion_modalidad);
            
                                
            ResultSet rs = ps.executeQuery();
            
                                     
            while (rs.next()){
            
      
            lista.add(new obj_tres_campos (rs.getString("eje_aca_idn"), 
                                             rs.getString("cur_nombre"), 
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
    
    public static ArrayList<obj_un_campo> encripta_rut(String frase, String rut) {
        ArrayList<obj_un_campo> lista = new ArrayList<obj_un_campo>();
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

            // Encodear la cadena a bytes usando utf-8 
            byte[] utf8 = rut.getBytes("UTF8"); 

            // Encriptar 
            byte[] enc = ecipher.doFinal(utf8); 
            
            lista.add(new obj_un_campo(new BASE64Encoder().encode(enc))); 
            
            
        } catch (Exception e) {
            e.printStackTrace();
        } 
         return lista;
   }
//***********************************************************************************************************  
    
    
    
    
    
    
    
    
    
public static ArrayList<obj_un_campo> encripta(String frase, ArrayList<?> valores ) {

    ArrayList<obj_un_campo> lista = new ArrayList<obj_un_campo>();
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

            int size = valores.size();
            obj_un_campo registro = null;

            int j;
            for (j=0; j<size; j++) 
            {

                registro = (obj_un_campo) valores.get(j);

                // Encodear la cadena a bytes usando utf-8 
                byte[] utf8 = registro.getcampo_uno().getBytes("UTF8"); 

                // Encriptar 
                byte[] enc = ecipher.doFinal(utf8); 

                lista.add(new obj_un_campo(new BASE64Encoder().encode(enc))); 

            }

       } catch (Exception e) 
        {
            e.printStackTrace();
        } 
    return lista;
}  

//***********************************************************************************************************  
    
   public static ArrayList<obj_un_campo> encripta_func_mod_fun_idn(String frase, String func_mod_fun_idn) {
        ArrayList<obj_un_campo> lista = new ArrayList<obj_un_campo>();
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

            // Encodear la cadena a bytes usando utf-8 
            byte[] utf8 = func_mod_fun_idn.getBytes("UTF8"); 

            // Encriptar 
            byte[] enc = ecipher.doFinal(utf8); 
            
            lista.add(new obj_un_campo(new BASE64Encoder().encode(enc))); 
            
            
        } catch (Exception e) {
            e.printStackTrace();
        } 
         return lista;
   }
//*********************************************************************************************************** 
      public static ArrayList<obj_un_campo> encripta_mod_idn(String frase, String func_mod_fun_idn) {
        ArrayList<obj_un_campo> lista = new ArrayList<obj_un_campo>();
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

            // Encodear la cadena a bytes usando utf-8 
            byte[] utf8 = func_mod_fun_idn.getBytes("UTF8"); 

            // Encriptar 
            byte[] enc = ecipher.doFinal(utf8); 
            
            lista.add(new obj_un_campo(new BASE64Encoder().encode(enc))); 
            
            
        } catch (Exception e) {
            e.printStackTrace();
        } 
         return lista;
   }
//*********************************************************************************************************** 
    
    /** Creates a new instance of frm_main_frame */
    public frm_main_frame() {
    }
    
}
