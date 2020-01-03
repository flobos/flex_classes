package libreria;
import java.net.*;
import flex.messaging.*;
import java.util.*;
import java.sql.*;
import java.lang.Object;

import java.security.spec.AlgorithmParameterSpec; 
import java.security.spec.KeySpec; 

import javax.crypto.Cipher; 
import javax.crypto.SecretKey; 
import javax.crypto.SecretKeyFactory; 
import javax.crypto.spec.PBEKeySpec; 
import javax.crypto.spec.PBEParameterSpec; 

import sun.misc.BASE64Encoder; 

public class Cifrador { 

private static byte[]	SALT_BYTES	 = { (byte) 0xA9, (byte) 0x9B, (byte) 0xC8, (byte) 0x32, (byte) 0x56, (byte) 0x35, (byte) 0xE3, (byte) 0x03 }; 

private static int	 ITERATION_COUNT	= 19; 


//***************************************************************************************

public static ArrayList encriptar(String passPhrase, String str) { 
 
    ArrayList lista = new ArrayList();
    Cipher ecipher = null; 
    Cipher dcipher = null; 
    
try { 
    // Crear la key 
    KeySpec keySpec = new PBEKeySpec(passPhrase.toCharArray(), SALT_BYTES, ITERATION_COUNT); 
    SecretKey key = SecretKeyFactory.getInstance("PBEWithMD5AndDES").generateSecret(keySpec); 
    ecipher = Cipher.getInstance(key.getAlgorithm()); 
    dcipher = Cipher.getInstance(key.getAlgorithm()); 

    // Preparar los parametros para los ciphers 
    AlgorithmParameterSpec paramSpec = new PBEParameterSpec(SALT_BYTES, ITERATION_COUNT); 

    // Crear los ciphers 
    ecipher.init(Cipher.ENCRYPT_MODE, key, paramSpec); 
    dcipher.init(Cipher.DECRYPT_MODE, key, paramSpec); 

    // Encodear la cadena a bytes usando utf-8 
    byte[] utf8 = str.getBytes("UTF8"); 

    // Encriptar 
    byte[] enc = ecipher.doFinal(utf8); 

    // Encodear bytes a base64 para obtener cadena 
    //lista.add(new obj_un_campo(func_mod_fun_idn));
    
    lista.add(new obj_un_campo(new BASE64Encoder().encode(enc))); 
    return lista;
    } catch (Exception e) { 
    return null; 
    } 
} 


//************************************************************************************************************


public static String desencriptar(String passPhrase, String str) { 
Cipher ecipher = null; 
Cipher dcipher = null; 

try { 
// Crear la key 
KeySpec keySpec = new PBEKeySpec(passPhrase.toCharArray(), SALT_BYTES, ITERATION_COUNT); 
SecretKey key = SecretKeyFactory.getInstance("PBEWithMD5AndDES").generateSecret(keySpec); 
ecipher = Cipher.getInstance(key.getAlgorithm()); 
dcipher = Cipher.getInstance(key.getAlgorithm()); 

// Preparar los parametros para los ciphers 
AlgorithmParameterSpec paramSpec = new PBEParameterSpec(SALT_BYTES, ITERATION_COUNT); 

// Crear los ciphers 
ecipher.init(Cipher.ENCRYPT_MODE, key, paramSpec); 
dcipher.init(Cipher.DECRYPT_MODE, key, paramSpec); 

// Decodear base64 y obtener bytes 
byte[] dec = new sun.misc.BASE64Decoder().decodeBuffer(str); 

// Desencriptar 
byte[] utf8 = dcipher.doFinal(dec); 

// Decodear usando utf-8 
return new String(utf8, "UTF8"); 

} catch (Exception e) { 
return null; 
} 
} 

public static void main(String args[]) { 
//String enc = Cifrador.encriptar("Iplacex-Belzart/Encript", "13.715.383-1"); 
//String des = Cifrador.desencriptar("Iplacex-Belzart/Encript", "Z4Zt49my7UADV4+dsCP4Og=="); 

//System.out.println(enc); 
//System.out.println(des); 
} 

}