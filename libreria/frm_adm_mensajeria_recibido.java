/*
 * frm_adm_mensajeria_recibido.java
 *
 * Created on 19 de diciembre de 2005, 02:26 PM
 */

package libreria;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author  Esteban
 */
//***********************************************************************************************************
public class frm_adm_mensajeria_recibido {
  public static ArrayList<obj_un_campo> mensaje_actualiza_leidos(int mensaje) {
    ArrayList<obj_un_campo> lista = new ArrayList<obj_un_campo>();
    Connection c=null;
    int salida = 1;
    try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_mesajeria_actualiza_leido (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setInt(1,mensaje);
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
//***********************************************************************************************************  
  public static ArrayList<obj_un_campo> mensaje_actualiza_respuesta(int mensaje, String respuesta) {
    ArrayList<obj_un_campo> lista = new ArrayList<obj_un_campo>();
    Connection c=null;
    int salida = 1;
    try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_mesajeria_actualiza_respuesta (?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setInt(1,mensaje);
            ps.setString(2,respuesta);
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
  
//***********************************************************************************************************  
     public static ArrayList<obj_dos_campos> mensajeria_muestra_respuesta_recibido(int codigo) {
      ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_mesajeria_muestra_respuesta_recibido (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setInt(1,codigo);
                      
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos (rs.getString("mens_respuesta"), 
                                             rs.getString("mens_fecha_respuesta")));
           
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
//******************************************************************************
     
      public static ArrayList<obj_un_campo_string> llena_datos_adjuntos(String mens_idn) {
    ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
        Connection c=null;
         
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_adm_mensajeria_recibido_muestra_datos_adjuntos (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, mens_idn.trim());
            ResultSet rs = ps.executeQuery();
            
            while (rs.next())
            {
                lista.add(new obj_un_campo_string(rs.getString("dat_adj_nombre")));
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
    /** Creates a new instance of frm_adm_mensajeria_recibido */
    public frm_adm_mensajeria_recibido() {
    }
    
}
