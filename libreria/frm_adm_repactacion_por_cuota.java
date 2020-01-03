/*
 * frm_adm_repactacion_por_cuota.java
 *
 * Created on 25 de junio de 2007, 03:55 PM
 */

package libreria;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author  Esteban 
 */
public class frm_adm_repactacion_por_cuota {

//***********************************************************************************************************                 
        
public static ArrayList<obj_tres_campos> carga_matriculas_alumnos(String alu_rut) {
    ArrayList<obj_tres_campos> lista = new ArrayList<obj_tres_campos>();
        Connection c=null;
         
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_repactacion_por_cuota_carga_matriculas (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, alu_rut.trim());
            ResultSet rs = ps.executeQuery();
            
            while (rs.next())
            {
                lista.add(new obj_tres_campos(rs.getString("mat_idn")
                                            ,rs.getString("mal_nombre")
                                                , rs.getString("alu_nombre")));
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
        
public static ArrayList<obj_cuatro_campos> verifica_repactacion(String mat_idn) {
    ArrayList<obj_cuatro_campos> lista = new ArrayList<obj_cuatro_campos>();
        Connection c=null;
         
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_repactacion_por_cuota_verifica_repactacion (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, mat_idn.trim());
            ResultSet rs = ps.executeQuery();
            
            while (rs.next())
            {
                lista.add(new obj_cuatro_campos(rs.getString("pag_idn")
                                                , rs.getString("pag_val_cuota")
                                                , rs.getString("pag_fecha_venc")
                                                , rs.getString("pag_num_cuota")));
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
        
public static ArrayList<obj_un_campo_string> inserta_repactacion(String mat_idn, int monto_cancela, String fecha_pago, String pag_idn) {
    ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
        Connection c=null;
         
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_repactacion_por_cuota_inserta_repactacion (?,?,?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, mat_idn.trim());
            ps.setInt(2, monto_cancela);
            ps.setString(3, fecha_pago.trim());            
            ps.setString(4, pag_idn.trim());            
            ResultSet rs = ps.executeQuery();
            
            
            while (rs.next())
            {
                lista.add(new obj_un_campo_string(rs.getString("salida")));
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

    /** Creates a new instance of frm_adm_repactacion_por_cuota */
    public frm_adm_repactacion_por_cuota() {
    }
    
}
