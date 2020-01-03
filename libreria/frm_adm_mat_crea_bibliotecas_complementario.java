/*
 * frm_adm_mat_crea_bibliotecas_complementario.java
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
public class frm_adm_mat_crea_bibliotecas_complementario {
//***********************************************************************************************************                 
public static ArrayList<obj_dos_campos> carga_bibliotecas_virtuales_base() {
    ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "select * from biblioteca_virtual_base order by bib_vir_bas_nombre" ;
            CallableStatement ps = c.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            
            lista.add(new obj_dos_campos("", "-- Seleccione --"));
            
            while (rs.next()){
            
      
             lista.add(new obj_dos_campos(rs.getString("bib_vir_bas_idn"),
                                            rs.getString("bib_vir_bas_nombre")));
           
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
public static ArrayList<obj_cuatro_campos> carga_bibliotecas_virtuales(String eje_aca) {
    ArrayList<obj_cuatro_campos> lista = new ArrayList<obj_cuatro_campos>();
        Connection c=null;
         
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "select a.bib_vir_idn, a.bib_vir_nombre, a.bib_vir_fecha_ingreso, b.bib_vir_bas_nombre from biblioteca_virtual a, biblioteca_virtual_base b where b.bib_vir_bas_idn = a.bib_vir_bas_idn order by a.bib_vir_nombre" ;
            CallableStatement ps = c.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
      
             lista.add(new obj_cuatro_campos(rs.getString("bib_vir_idn"),
                                            rs.getString("bib_vir_nombre"),
                                            rs.getString("bib_vir_fecha_ingreso"),
                                            rs.getString("bib_vir_bas_nombre")));
           
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
public static ArrayList<obj_un_campo_string> inserta_biblioteca_virtual(String bib_vir_nombre, String bib_vir_bas_idn) {
    ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
        Connection c=null;
         
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_biblioteca_virtual_inserta (?,?)}" ;//
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, bib_vir_nombre.trim());
            ps.setString(2, bib_vir_bas_idn.trim());
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
            sql = "{call flex_biblioteca_virtual_elimina (?)}" ;//
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
    public frm_adm_mat_crea_bibliotecas_complementario() {
    }
    
}
