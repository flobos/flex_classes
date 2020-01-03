/*
 * frm_notas.java
 *
 * Created on 16 de enero de 2006, 05:48 PM
 */

package libreria_alm;
import java.util.ArrayList;
import java.io.Serializable;
import java.sql.*;
/**
 *
 * @author  Esteban
 */
public class frm_notas {

	public static ArrayList<obj_tres_campos> procesos_muestra_web(String tcur_idn)
    {

    ArrayList<obj_tres_campos> lista = new ArrayList<obj_tres_campos>();
    Connection c=null;

    try {
        String sql;
        c = conexion_odbc.Connexion_datos();
        CallableStatement cs;
        sql = "flex_proceso_muestra_web '" + tcur_idn + "'";
        cs = c.prepareCall(sql);
       // cs.setString(1, "633174");
        ResultSet rs = cs.executeQuery();
        
        while (rs.next())
        { 
             lista.add(new obj_tres_campos(rs.getString("pro_eva_idn")
                                 ,rs.getString("tip_pro_eva_nombre")                 
                                 ,rs.getString("promedio")
                                 ));
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
	
public static ArrayList<obj_once_campos> notas_muestra_web(String tcur_idn, String pro_eva_idn)
        {
    
        ArrayList<obj_once_campos> lista = new ArrayList<obj_once_campos>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_notas_muestra_web_proceso '" + tcur_idn + "','" + pro_eva_idn + "'";
            cs = c.prepareCall(sql);
           // cs.setString(1, "633174");
            ResultSet rs = cs.executeQuery();
            
            while (rs.next())
            {
                 lista.add(new obj_once_campos(rs.getString("tipo")
                                     ,rs.getString("nota")                 
                                     ,rs.getString("estado")
                                     ,rs.getString("fecha_nota")
                                     ,rs.getString("fecha_toma_prueba")
                                     ,rs.getString("promedio")
                                     ,rs.getString("idn")
                                     ,rs.getString("trabajo")
                                     ,rs.getString("mod_ren_pru_idn")
                                     ,rs.getString("est_pru_idn")
                                     ,rs.getString("tip_pro_eva_nombre")
                                     ));
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
    /////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
  public static ArrayList<obj_cuatro_campos> ro_obtiene_correccion_pruebas(String trab_idn) {
    
        ArrayList<obj_cuatro_campos> lista = new ArrayList<obj_cuatro_campos>();
        Connection c=null;

        try {    
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_alumno_detalle_nota_correccion '" + trab_idn + "'";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            
            while (rs.next()){
         
            lista.add(new obj_cuatro_campos(rs.getString("campo_uno")
                                        , rs.getString("campo_dos")
                                        , rs.getString("campo_tres")
                                        , rs.getString("campo_cuatro")));
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
  
  
     public static ArrayList<Serializable> muestra_preguntas_objetivas(String trab_idn) {
            ArrayList<Serializable> lista = new ArrayList<Serializable>();
            Connection c=null;
            String msg ;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_notas_muestra_preguntas_objetivas (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, trab_idn.trim());
            
                    
            ResultSet rs = ps.executeQuery();
            
                
            while (rs.next()){
            
            lista.add(new obj_dos_campos(rs.getString("eje_aca_preg_idn"),
                                          rs.getString("eje_aca_preg_pregunta")));
                                            
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            lista.remove(0);
            msg = e.getMessage();
            lista.add(new obj_un_campo_string(msg));
            
        } finally {
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
                
         return lista;
  }

     public static ArrayList<Serializable> muestra_preguntas_respuestas(String pregunta) {
            ArrayList<Serializable> lista = new ArrayList<Serializable>();
            Connection c=null;
            String msg ;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_notas_muestra_respuestas_objetivas (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, pregunta.trim());
            
                    
            ResultSet rs = ps.executeQuery();
            
                
            while (rs.next()){
            
            lista.add(new obj_cuatro_campos(rs.getString("eje_aca_res_idn"),
                                          rs.getString("eje_aca_res_respuesta"),
                                          rs.getString("correcta"),
                                          rs.getString("eje_aca_preg_idn")));
                                            
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            lista.remove(0);
            msg = e.getMessage();
            lista.add(new obj_un_campo_string(msg));
            
        } finally {
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
                
         return lista;
  }
     

///////////////////////////////////////////////////////////////////////////
    /** Creates a new instance of frm_notas */
    public frm_notas() {
    }
    
}


