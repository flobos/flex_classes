/*
 * frm_adm_chat_ingreso.java
 *
 * Created on 08 de Enero de 2007
 */

package libreria;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author  marcelo
 */
public class frm_resumen_ajecuciones_academicas {
 ///*******************************************************************************************************************
     //***********************************************************************************************************         
  
  
    
    
   
  public static ArrayList<obj_dos_campos> resumen_ejecuciones_academicas_muestra_ejecuciones_academicas(int funcion_modalidad) {
      ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
        
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            
            sql = "{call flex_resumen_ejecuciones_academicas_muestra_ejecuciones_academicas (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setInt(1,funcion_modalidad);
            
                                
            ResultSet rs = ps.executeQuery();
            
             lista.add(new obj_dos_campos("0"," - Seleccione - "));   
            
            while (rs.next()){
            
      
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
    
    
  
////***************************************************************************************************     
 
     
 //*/*********************************************************************************************************************
 
      public frm_resumen_ajecuciones_academicas() {
    }
    
}
