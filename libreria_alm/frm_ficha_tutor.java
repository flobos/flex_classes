/*
 * frm_ficha_tutor.java
 *
 * Created on 27 de junio de 2006, 18:14
 */

package libreria_alm;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author  Administrador
 */
public class frm_ficha_tutor {
     //***********************************************************************************************************
 // frm_ficha_tutor.mxml --by.SyOuS
 //***********************************************************************************************************      
      public static ArrayList<obj_un_campo_string> ro_carga_nombre_tutor(String eje_aca) {
    
        ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
        Connection c=null;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_nombre_tutor '" + eje_aca + "'";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
        
            while (rs.next()){
            
      
      
            lista.add(new obj_un_campo_string(rs.getString("fun_nombre")));
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
 // frm_ficha_tutor.mxml --by.SyOuS
 //***********************************************************************************************************      
      public static ArrayList<obj_seis_campos> ro_carga_datos_tutor(String fun_rut) {
    
        ArrayList<obj_seis_campos> lista = new ArrayList<obj_seis_campos>();
        Connection c=null;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_datos_tutor '" + fun_rut + "'";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
        
            while (rs.next()){
            
      
      
            lista.add(new obj_seis_campos(rs.getString("fun_nombre")
                                       , rs.getString("fun_gra_descripcion")
                                       , rs.getString("ins_sup_nombre")
                                       , rs.getString("tip_gra_idn")                                       
                                       , rs.getString("tip_gra_nombre")
                                       , rs.getString("fun_horario_atencion")));
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
      
    /** Creates a new instance of frm_ficha_tutor */
    public frm_ficha_tutor() {
    }
    
}
