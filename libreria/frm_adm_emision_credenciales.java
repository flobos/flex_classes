/*
 * frm_adm_emision_credenciales.java
 *
 * Created on 8 de junio de 2007, 10:41 AM
 */

package libreria;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author  Esteban 
 */
public class frm_adm_emision_credenciales {
    //***********************************************************************************************************                 
        
public static ArrayList<obj_dos_campos> carga_instituciones() {
    ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_emision_credenciales_carga_instituciones}" ;
            CallableStatement ps = c.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            
            lista.add(new obj_dos_campos("0","-- Seleccione --"));
            
            while (rs.next())
            {
                lista.add(new obj_dos_campos(rs.getString("inst_edu_rut")
                                                , rs.getString("inst_edu_nombre")));
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
        
public static ArrayList<obj_dos_campos> carga_campus(String inst_edu_rut) {
    ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_emision_credenciales_carga_campus (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,inst_edu_rut.trim());
            ResultSet rs = ps.executeQuery();
            
            lista.add(new obj_dos_campos("0","-- Seleccione --"));
            
            while (rs.next())
            {
                lista.add(new obj_dos_campos(rs.getString("cam_inst_edu_idn")
                                                , rs.getString("cam_nombre")));
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
        
public static ArrayList<obj_dos_campos> carga_modalidad(String cam_inst_edu_idn) {
    ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_emision_credenciales_carga_modalidad (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,cam_inst_edu_idn.trim());
            ResultSet rs = ps.executeQuery();
            
            lista.add(new obj_dos_campos("0","-- Seleccione --"));
            
            while (rs.next())
            {
                lista.add(new obj_dos_campos(rs.getString("mod_cam_idn")
                                                , rs.getString("mod_nombre")));
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
        
public static ArrayList<obj_dos_campos> carga_promociones(int mod_cam_idn) {
    ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_emision_credenciales_carga_promociones (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setInt(1, mod_cam_idn);
            ResultSet rs = ps.executeQuery();
            
            lista.add(new obj_dos_campos("0","-- Seleccione --"));
            
            while (rs.next())
            {
                lista.add(new obj_dos_campos(rs.getString("pro_idn")
                                             , rs.getString("pro_nombre")));
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
        
public static ArrayList<obj_cuatro_campos> carga_alumnos_sin_emision(String pro_idn) {
    ArrayList<obj_cuatro_campos> lista = new ArrayList<obj_cuatro_campos>();
        Connection c=null;
         
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_emision_credenciales_carga_alumnos_sin_emision (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,pro_idn.trim());
            ResultSet rs = ps.executeQuery();
            
            while (rs.next())
            {
                lista.add(new obj_cuatro_campos(rs.getString("alu_rut")
                                            , rs.getString("mat_idn")
                                            , rs.getString("alu_nombre")
                                            , rs.getString("alu_foto")));
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
    
    /** Creates a new instance of frm_adm_emision_credenciales */
    public frm_adm_emision_credenciales() {
    }
    
}
