/*
 * frm_adm_semanas_ejecucion.java
 *
 * Created on 28 de abril de 2008, 03:16 PM
 */

package libreria;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author  Mauricio
 */
public class frm_adm_semanas_ejecucion {
    
    /** Creates a new instance of frm_adm_semanas_ejecucion */
    public frm_adm_semanas_ejecucion() {
    }
    
         public static ArrayList<obj_dos_campos> carga_ejecucion() {
    
        ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_carga_ejecucion_informe_trabajos ";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            lista.add(new obj_dos_campos("0","Seleccione"));
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos(rs.getString("data")
                                       , rs.getString("label")));
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
//********************************************************************************
     
          public static ArrayList<obj_dos_campos> carga_ejecucion_fun_mod(int funcion_modalidad) {
    
        ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_frm_adm_semanas_carga_ejecucion '" + funcion_modalidad + "'";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            lista.add(new obj_dos_campos("0","Seleccione"));
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos(rs.getString("eje_idn")
                                       , rs.getString("eje_nombre")));
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
//********************************************************************************
         
      public static ArrayList<obj_cinco_campos> comprueba_semanas_ejecucion(String eje_idn) {
    
        ArrayList<obj_cinco_campos> lista = new ArrayList<obj_cinco_campos>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_frm_adm_semanas_ejecucion_comprueba '" + eje_idn + "'";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            while (rs.next()){
            
            lista.add(new obj_cinco_campos(rs.getString("sem_eje_idn")
                                                   ,rs.getString("eje_nombre")  
                                                   ,rs.getString("sem_eje_numero_semana")
                                                   ,rs.getString("sem_eje_fecha_inicio")
                                                   ,rs.getString("sem_eje_fecha_termino")));
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
         
         public static ArrayList<obj_cinco_campos> guarda_semanas_ejecucion(String eje_idn, String fecha_inicio, String fecha_termino) {
    
        ArrayList<obj_cinco_campos> lista = new ArrayList<obj_cinco_campos>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_frm_adm_semanas_ejecucion_semanas'" + eje_idn + "', '" + fecha_inicio + "','" + fecha_termino + "'" ;
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            while (rs.next()){
            
            lista.add(new obj_cinco_campos(rs.getString("sem_eje_idn")
                                                   ,rs.getString("eje_nombre")  
                                                   ,rs.getString("sem_eje_numero_semana")
                                                   ,rs.getString("sem_eje_fecha_inicio")
                                                   ,rs.getString("sem_eje_fecha_termino")));
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
}
