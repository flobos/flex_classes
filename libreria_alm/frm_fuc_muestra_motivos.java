/*
 * frm_fuc_muestra_motivos.java
 *
 * Created on 17 de enero de 2006, 03:09 PM
 */

package libreria_alm;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author  Esteban
 */
public class frm_fuc_muestra_motivos {
    public static ArrayList<obj_seis_campos> muestra_motivos_fuc(String numero_fuc) {
    
        ArrayList<obj_seis_campos> lista = new ArrayList<obj_seis_campos>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
             sql = "flex_fuc_muestra_motivos_fuc '" + numero_fuc + "'" ;
            cs = c.prepareCall(sql);
           // cs.setString(1, "633174");
            ResultSet rs = cs.executeQuery();
            
            while (rs.next()){
            
      
            lista.add(new obj_seis_campos(rs.getString("idn"),
                                          rs.getString("motivo"),
                                          rs.getString("estado"),
                                          rs.getString("fechaestado"),
                                          rs.getString("vista"), 
                                          rs.getString("fechavista")));
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
    public static void cambia_vista_motivo(String numero_motivo ) {
    
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "flex_fuc_cambia_vista_motivo '" + numero_motivo + "'" ;
            PreparedStatement ps = c.prepareStatement(sql);
            ps.execute();
           } 
        catch (Exception e) 
        {
            e.printStackTrace();
        } 
        finally
        {
            try {
                c.close();
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
    }  
//***********************************************************************************************************  
    public static ArrayList<obj_cuatro_campos> muestra_resolucion_motivo(String numero_motivo) {
    
        ArrayList<obj_cuatro_campos> lista = new ArrayList<obj_cuatro_campos>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
             sql = "flex_fuc_muestra_resolucion_motivo '" + numero_motivo + "'" ;
            cs = c.prepareCall(sql);
           // cs.setString(1, "633174");
            ResultSet rs = cs.executeQuery();
            
            while (rs.next()){
            
      
            lista.add(new obj_cuatro_campos(rs.getString("resolucion"),
                                          rs.getString("fecha"),
                                          rs.getString("motivo"),
                                          rs.getString("consulta")));
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
    /** Creates a new instance of frm_fuc_muestra_motivos */
    public frm_fuc_muestra_motivos() {
    }
    
}
