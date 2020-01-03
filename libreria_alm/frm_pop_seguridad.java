/*
 * frm_pop_seguridad.java
 *
 * Created on 16 de enero de 2006, 10:25 AM
 */

package libreria_alm;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author  Esteban
 */
public class frm_pop_seguridad {
//***********************************************************************************************************    
public static ArrayList<obj_dos_campos> muestra_paises() {
    
        ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;

        try {
         
            c = conexion_odbc.Connexion_datos();
            Statement s = c.createStatement();
            ResultSet rs =  s.executeQuery("SELECT pais_idn as data, pais_nombre as label FROM pais order by pais_idn");
           
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos(rs.getString("data")
                                        ,rs.getString("label")));
            
            
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
    public static ArrayList<obj_dos_campos> devuelve_datos_seguridad_nacional(String alu_rut, String alu_clave) {
    
        ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;

        try {
         
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_seguridad_valida_alumno_nacional (?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,alu_rut.trim());
            ps.setString(2,alu_clave);
            ResultSet rs = ps.executeQuery();         
           
            while (rs.next())
            {
                lista.add(new obj_dos_campos(rs.getString("alu_idn"),rs.getString("nombre")));
            }
        } 
            catch (Exception e) {
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
    public static ArrayList<obj_dos_campos>  devuelve_datos_alumnos_internacional (String alu_ident, String alu_clave)
    {
        ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
        
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_seguridad_valida_alumno_internacional (?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,alu_ident.trim());
            ps.setString(2,alu_clave);
            ResultSet rs = ps.executeQuery();                  
            
        while (rs.next())
            {
                lista.add(new obj_dos_campos(rs.getString("alu_idn"),rs.getString("nombre")));
            }
        } 
            catch (Exception e) {
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
    /** Creates a new instance of frm_pop_seguridad */
    public frm_pop_seguridad() {
    }
    
}
