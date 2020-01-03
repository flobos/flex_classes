/*
 * frm_adm_foro_ingreso.java
 *
 * Created on 26 de diciembre de 2005, 02:30 PM
 */

package libreria;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author  luis
 */
public class frm_adm_resp_pregunta_frec_ingreso {
 ////***************************************************************************************************
 ////***************************************************************************************************
 ////***************************************************************************************************
 
  
   
       public static ArrayList<obj_un_campo_string> respuesta_ingresa(String res_preg_frec_respuesta ) {
    ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
        Connection c=null;
         String msg ;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_respuesta_pregunta_frec_ingresa (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, res_preg_frec_respuesta.trim());
            ResultSet rs = ps.executeQuery();
        
            while (rs.next()){
            lista.add(new obj_un_campo_string(rs.getString("identidad")));
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
   
    

    
////***************************************************************************************************
   
      public static ArrayList<obj_un_campo> respuesta_modifica(String res_preg_frec_idn, String res_preg_frec_respuesta)
   {
    ArrayList<obj_un_campo> lista = new ArrayList<obj_un_campo>();
        Connection c=null;
         int salida = 1;
        try {
  
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_respuesta_pregunta_frec_modifica (?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,res_preg_frec_idn.trim());
            ps.setString(2,res_preg_frec_respuesta.trim());
           
           
            ps.execute();
                       
        } catch (Exception e) {
            e.printStackTrace();
            salida = 0;
            
        } finally {
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        if (salida == 1){
        lista.add(new obj_un_campo(1));
        }else{
        lista.add(new obj_un_campo(0));
        }
        
         return lista;
   }
  
////***************************************************************************************************      
 
      
     public static ArrayList<obj_un_campo> respuesta_borra(int res_preg_frec_idn) {
    ArrayList<obj_un_campo> lista = new ArrayList<obj_un_campo>();
    Connection c=null;
    int salida = 1;
    try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_respuesta_pregunta_frec_borra (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setInt(1,res_preg_frec_idn);
            ps.execute();
           
        } catch (Exception e) {
            e.printStackTrace();
            salida = 0;
            e.getMessage();
        } finally {
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (salida == 1){
        lista.add(new obj_un_campo(1));
        }else{
        lista.add(new obj_un_campo(0));
        }
        
         return lista;
   } 
 
     
     
      /** Creates a new instance of frm_adm_foro_ingreso */
     public frm_adm_resp_pregunta_frec_ingreso() {
    }
    
}
