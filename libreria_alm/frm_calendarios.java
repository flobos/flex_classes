/*
 * frm_calendarios.java
 *
 * Created on 17 de enero de 2006, 11:25 AM
 */

package libreria_alm;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author  Esteban
 */
public class frm_calendarios {
 //***********************************************************************************************************
 // frm_calendarios.mxml --by.SyOuS
 //***********************************************************************************************************      
      public static ArrayList<obj_cuatro_campos> ro_carga_fechas_bibliotecas_academicas(String eje_aca_idn) {
    
        ArrayList<obj_cuatro_campos> lista = new ArrayList<obj_cuatro_campos>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_calendarios_carga_bibliotecas_academicas '" + eje_aca_idn + "'";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            
            while (rs.next()){
            
      
            lista.add(new obj_cuatro_campos(rs.getString("bib_vir_idn")
                                        , rs.getString("bib_eje_aca_titulo")
                                        , rs.getString("bib_eje_aca_fecha_subida")
                                        , rs.getString("bib_eje_aca_fecha_bajada")));
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
 // frm_calendarios.mxml --by.SyOuS
 //***********************************************************************************************************      
      public static ArrayList<obj_cinco_campos> ro_carga_fechas_notas_toma(String mat_idn, String eje_aca_idn) {
    
        ArrayList<obj_cinco_campos> lista = new ArrayList<obj_cinco_campos>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_calendarios_carga_fechas_notas '" + mat_idn +"', '" + eje_aca_idn + "'";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            
            while (rs.next()){
            
      
            lista.add(new obj_cinco_campos(rs.getString("tip_pru_nombre")
                                        , rs.getString("fecha_disponibilidad_prueba")
                                        , rs.getString("fecha_toma_prue")
                                        , rs.getString("not_fecha_exte")
                                        , rs.getString("tip_pro_eva_nombre")));
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
 // frm_calendarios.mxml --by.SyOuS
 //***********************************************************************************************************      
      public static ArrayList<obj_dos_campos> ro_carga_eje_aca_por_toma(String mat_idn) {
    
        ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_calendarios_carga_eje_aca_por_toma '" + mat_idn +"'" ;
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            
            lista.add(new obj_dos_campos("0"," - Seleccione - "));
            
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos(rs.getString("eje_aca_idn")
                                        , rs.getString("cur_nombre")));
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
 // frm_calendarios.mxml --by.lmaf
 //***********************************************************************************************************      
    
 //***********************************************************************************************************     
 
   //***********************************************************************************************************     
  
    public static ArrayList<obj_tres_campos> ro_carga_fechas_foro_sincronico(String mat_idn, String eje_aca_idn) {
    
        ArrayList<obj_tres_campos> lista = new ArrayList<obj_tres_campos>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_calendarios_carga_foros_sincronicos '" + mat_idn +"', '" + eje_aca_idn + "'";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            
            while (rs.next()){
            
      
            lista.add(new obj_tres_campos(rs.getString("chat_tema")
                                        , rs.getString("chat_fecha_subida")
                                        , rs.getString("chat_fecha_bajada")));
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
    ///**********************************************************************    
         
       public static ArrayList<obj_tres_campos> ro_carga_fechas_foro_Asincronico(String mat_idn, String eje_aca_idn) {
    
        ArrayList<obj_tres_campos> lista = new ArrayList<obj_tres_campos>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_calendarios_carga_foros_Asincronicos '" + mat_idn +"', '" + eje_aca_idn + "'";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            
            while (rs.next()){
            
      
            lista.add(new obj_tres_campos(rs.getString("for_tem_titulo")
                                        , rs.getString("for_tem_fecha_subida")
                                        , rs.getString("for_tem_fecha_bajada")));
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
      
  ///**********************************************************************    
      
      
      
      /** Creates a new instance of frm_calendarios */
    public frm_calendarios() {
    }
    
}
