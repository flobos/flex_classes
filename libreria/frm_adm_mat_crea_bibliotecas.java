/*
 * frm_adm_mat_crea_bibliotecas.java
 *
 * Created on 1 de febrero de 2006, 02:49 PM
 */

package libreria;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author  Esteban
 */
public class frm_adm_mat_crea_bibliotecas {
//***********************************************************************************************************                 
public static ArrayList<obj_tres_campos> carga_bibliotecas_virtuales() {
    ArrayList<obj_tres_campos> lista = new ArrayList<obj_tres_campos>();
        Connection c=null;
         
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "select * from biblioteca_virtual order by bib_vir_nombre" ;
            CallableStatement ps = c.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
      
             lista.add(new obj_tres_campos(rs.getString("bib_vir_idn"),
                                            rs.getString("bib_vir_nombre"),
                                            rs.getString("bib_vir_fecha_ingreso")));
           
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
public static ArrayList<obj_un_campo_string> inserta_biblioteca_virtual(String bib_vir_nombre) {
    ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
        Connection c=null;
         
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_biblioteca_virtual_inserta (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, bib_vir_nombre.trim());
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
      
             lista.add(new obj_un_campo_string(rs.getString("campo_uno")));
           
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
public static ArrayList<?> elimina_biblioteca_virtual(String bib_vir_idn) {
    ArrayList<?> lista = new ArrayList<Object>();
        Connection c=null;
         
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_biblioteca_virtual_elimina (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, bib_vir_idn.trim());
            ps.executeQuery();
            

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

    /** Creates a new instance of frm_adm_mat_crea_bibliotecas */
    public frm_adm_mat_crea_bibliotecas() {
    }
    
}
