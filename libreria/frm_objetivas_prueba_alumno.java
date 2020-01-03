/*
 * frm_objetivas_prueba_alumno.java
 *
 * Created on 2 de julio de 2009, 04:16 PM
 */

package libreria;
import java.util.ArrayList;
import java.sql.*;

import java.lang.Object;
/**
 *
 * @author  JOliveros
 */
public class frm_objetivas_prueba_alumno 
{
    
    public static ArrayList<obj_siete_campos> crea_prueba_alumno(String trab_idn, String tc_idn, String tip_pru_idn)
    {
        ArrayList<obj_siete_campos> lista = new ArrayList<obj_siete_campos>();
        Connection c=null;
        try 
        {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_objetivas_prueba_alumno_genera_aleatoriedad (?,?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, trab_idn.trim());
            ps.setString(2, tc_idn.trim());
            ps.setString(3, tip_pru_idn.trim());
            ResultSet rs = ps.executeQuery();

            while (rs.next())
            {
                lista.add(new obj_siete_campos( rs.getString("preg_trab_idn"),
                                                rs.getString("eje_aca_preg_idn"),
                                                rs.getString("eje_aca_preg_pregunta"),
                                                rs.getString("eje_aca_preg_arch_adjunto"),
                                                rs.getString("eje_aca_res_idn"),
                                                rs.getString("eje_aca_res_respuesta"),
                                                rs.getString("eje_aca_res_arch_adjunto")));
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
//****************************************************************************************************************************************************************************
    public static ArrayList<obj_diez_campos> muestra_detalle_prueba_alumno(String trab_idn)
    {
        ArrayList<obj_diez_campos> lista = new ArrayList<obj_diez_campos>();
        Connection c=null;
        try 
        {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_objetivas_prueba_alumno_detalles_prueba (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, trab_idn.trim());
            
            ResultSet rs = ps.executeQuery();

            while (rs.next())
            {
                lista.add(new obj_diez_campos( rs.getString("cantidad"),
                                                rs.getString("tip_preg_idn"),
                                                rs.getString("tc_idn"),
                                                rs.getString("tip_pru_idn"),
                                                rs.getString("cur_nombre"),
                                                rs.getString("tip_pru_nombre"),
                                                rs.getString("eva_eje_tiempo"),
                                                rs.getString("eva_eje_disponible"),
                                                rs.getString("eva_eje_fecha_ter_ing_trab"),
                                                rs.getString("nombres")));
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
//****************************************************************************************************************************************************************************
    public static ArrayList<obj_nueve_campos> muestra_prueba_alumno(String trab_idn)
    {
        ArrayList<obj_nueve_campos> lista = new ArrayList<obj_nueve_campos>();
        Connection c=null;
        try 
        {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_objetivas_prueba_alumno_muestra_preguntas (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, trab_idn.trim());
            
            ResultSet rs = ps.executeQuery();

            while (rs.next())
            {
                lista.add(new obj_nueve_campos( rs.getString("preg_trab_idn"),
                                                rs.getString("eje_aca_preg_idn"),
                                                rs.getString("eje_aca_preg_pregunta"),
                                                rs.getString("eje_aca_preg_arch_adjunto"),
                                                rs.getString("eje_aca_res_idn"),
                                                rs.getString("eje_aca_res_respuesta"),
                                                rs.getString("eje_aca_res_arch_adjunto"),
                                                rs.getString("tip_preg_idn"),
                                                rs.getString("respuesta")));
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
//*************************************************************************************************************************************************************************
    public static ArrayList<?> guarda_respuesta_alumno(String preg_trab_idn, String eje_aca_res_idn, String preg_trab_texto_respuesta)
    {
        ArrayList<?> lista = new ArrayList<Object>();
        Connection c=null;
        try 
        {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_objetivas_prueba_alumno_guarda_respuesta (?,?,?)}";
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, preg_trab_idn.trim());
            ps.setString(2, eje_aca_res_idn.trim());
            ps.setString(3, preg_trab_texto_respuesta.trim());
            ps.execute();
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
//*************************************************************************************************************************************************************************

    /** Creates a new instance of frm_objetivas_prueba_alumno */
    public frm_objetivas_prueba_alumno() 
    {
    }
    
}
