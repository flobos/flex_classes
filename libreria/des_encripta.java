/*
 * des_encripta.java
 *
 * Created on 30 de marzo de 2009, 10:49 AM
 */
package libreria;
import java.util.*;
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
public class des_encripta {
    
    
//***********************************************************************************************************    
    private static byte[]	SALT_BYTES	 = { (byte) 0xA9, (byte) 0x9B, (byte) 0xC8, (byte) 0x32, (byte) 0x56, (byte) 0x35, (byte) 0xE3, (byte) 0x03 }; 

    private static int	 ITERATION_COUNT	= 19; 
//***********************************************************************************************************
    
//***********************************************************************************************************  
    
    public static ArrayList<obj_un_campo_string> desencriptar_rut(String frase, String rut) {
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
            byte[] dec = new sun.misc.BASE64Decoder().decodeBuffer(rut); 

            // Desencriptar 
            byte[] utf8 = dcipher.doFinal(dec); 

            // Decodear usando utf-8 
            lista.add(new obj_un_campo_string(new String(utf8, "UTF8"))); 
            
            
        } catch (Exception e) {
            e.printStackTrace();
        } 
         return lista;
   }
//***********************************************************************************************************  
   
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
//***********************************************************************************************************      
   
    public static ArrayList<obj_un_campo_string> desencriptar_mod_idn(String frase, String mod_idn) {
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
            byte[] dec = new sun.misc.BASE64Decoder().decodeBuffer(mod_idn); 

            // Desencriptar 
            byte[] utf8 = dcipher.doFinal(dec); 

            // Decodear usando utf-8 
            lista.add(new obj_un_campo_string(new String(utf8, "UTF8"))); 
            
            
        } catch (Exception e) {
            e.printStackTrace();
        } 
         return lista;
   }
//***********************************************************************************************************      
    
    /** Creates a new instance of des_encripta */
    public des_encripta() {
    }
    
}
