/*
 * frm_adm_mensajeria.java
 *
 * Created on 19 de diciembre de 2005, 11:30 AM
 */

package libreria;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author  Esteban
 */
public class frm_adm_mensajeria {
    
//***********************************************************************************************************
public static ArrayList<obj_cuatro_campos> mensajeria_muestra_mensajes_enviados(String rut) {
      ArrayList<obj_cuatro_campos> lista = new ArrayList<obj_cuatro_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_mesajeria_muestra_mensajes_enviados (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,rut.trim());
                      
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
      
            lista.add(new obj_cuatro_campos (rs.getString("mens_idn"), 
                                             rs.getString("mens_asunto"), 
                                             rs.getString("mens_fecha"), 
                                             rs.getString("respuesta")));
           
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
   public static ArrayList<obj_ocho_campos> mensajeria_muestra_mensajes_recibidos(String rut) {
      ArrayList<obj_ocho_campos> lista = new ArrayList<obj_ocho_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_mesajeria_muestra_mensajes_recibidos (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,rut.trim());
                      
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
      
            lista.add(new obj_ocho_campos (rs.getString("mens_idn"), 
                                             rs.getString("mens_asunto"), 
                                             rs.getString("mens_fecha"), 
                                             rs.getString("nombre"), 
                                             rs.getString("mens_cuerpo"),
                                             rs.getString("respuesta"), 
                                             rs.getString("leido"),
                                             rs.getString("mens_des_idn")));
           
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
    public static ArrayList<obj_un_campo_string> mensajeria_cuenta_nuevos(String rut) {
      ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_mesajeria_cuenta_mensajes_nuevos (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,rut.trim());
                      
            ResultSet rs = ps.executeQuery();
                      
         
        while (rs.next()){
       
                lista.add(new obj_un_campo_string (rs.getString("contador")));
           
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
    /** Creates a new instance of frm_adm_mensajeria */
    public frm_adm_mensajeria() {
    }
    
}
