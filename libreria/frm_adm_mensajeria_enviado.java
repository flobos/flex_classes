/*
 * frm_adm_mensajeria_enviado.java
 *
 * Created on 19 de diciembre de 2005, 02:17 PM
 */

package libreria;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author  Esteban
 */
public class frm_adm_mensajeria_enviado {
//***********************************************************************************************************    
   public static ArrayList<obj_cinco_campos> mensajeria_muestra_mensaje_enviado_detalle(int codigo) {
      ArrayList<obj_cinco_campos> lista = new ArrayList<obj_cinco_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_mesajeria_enviado_muestra (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setInt(1,codigo);
                      
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
      
            lista.add(new obj_cinco_campos (rs.getString("mens_asunto"), 
                                             rs.getString("mens_cuerpo"), 
                                             rs.getString("mens_fecha_leido"), 
                                             rs.getString("mens_respuesta"),
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
//***********************************************************************************************************   
     public static ArrayList<obj_dos_campos> mensajeria_muestra_respuesta_recibido_combo(int idn) {
      ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_mesajeria_muestra_mensajes_enviados_combo (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setInt(1,idn);
                      
            ResultSet rs = ps.executeQuery();
                      
         lista.add(new obj_dos_campos ("1","-- Seleccione --"));
        while (rs.next()){
       
                lista.add(new obj_dos_campos (rs.getString("mensaje"),rs.getString("nombre") + ". -Leido: "  + rs.getString("leido") + ". -Resp.: "  + rs.getString("respuesta") ));
           
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
     
    /** Creates a new instance of frm_adm_mensajeria_enviado */
    public frm_adm_mensajeria_enviado() {
    }
    
}
