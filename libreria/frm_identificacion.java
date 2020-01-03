/*
 * frm_identificacion.java
 *
 * Created on 20 de julio de 2006, 11:44 AM
 */

package libreria;
import java.util.ArrayList;
import java.sql.*;
//import flex.messaging.*;
/**
 *
 * @author  Esteban 
 */
public class frm_identificacion {
    //***********************************************************************************************************
    
    public static ArrayList<obj_un_campo> verifica_nombre_usuario(String est_reg_usuario) 
    {
        ArrayList<obj_un_campo> lista = new ArrayList<obj_un_campo>();
        Connection c=null;
        try 
        {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call bfx_adm_identificacion_verifica_nombre_usuario (?)}";
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, est_reg_usuario.trim());
            ResultSet rs = ps.executeQuery();
                                             
            while (rs.next())
            {
                lista.add(new obj_un_campo(rs.getString("ent_reg_idn")));
            }
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        } 
        finally 
        {
            try 
            {
                c.close();
            } 
            catch (SQLException e) 
            {
                e.printStackTrace();
            }
        }
        
        return lista;
    }
    //***********************************************************************************************************
    public static ArrayList<obj_dos_campos> verifica_usuario(String est_reg_usuario, String est_reg_clave) 
    {
        ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
        try 
        {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_autentifica_usuario (?,?)}";
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, est_reg_usuario.trim());
            ps.setString(2, est_reg_clave.trim());
            ResultSet rs = ps.executeQuery();
                                             
            while (rs.next())
            {
                lista.add(new obj_dos_campos(rs.getString("fun_rut")
                                            , rs.getString("fun_nombre")));
            }
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        } 
        finally 
        {
            try 
            {
                c.close();
            } 
            catch (SQLException e) 
            {
                e.printStackTrace();
            }
        }
        
        return lista;
    }    

//***********************************************************************************************************          
    public static ArrayList<obj_cinco_campos> autentifica_funcionario(String usuario, String password) {
    
        ArrayList<obj_cinco_campos> lista = new ArrayList<obj_cinco_campos>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_adm_autentifica_usuario '" + usuario + "' , '" + password + "'";
            cs = c.prepareCall(sql);
           // cs.setString(1, "633174");
            ResultSet rs = cs.executeQuery();
            
            while (rs.next()){
            
      
            lista.add(new obj_cinco_campos(rs.getString("fun_rut"),
                                  rs.getString("fun_ap_paterno"),
                                  rs.getString("fun_ap_materno"),
                                  rs.getString("fun_nombre"),
                                  rs.getString("sed_nombre")));
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
    
//***********************************************************************************************************        
    /** Creates a new instance of frm_identificacion */
    public frm_identificacion() 
    {
    }        
}

