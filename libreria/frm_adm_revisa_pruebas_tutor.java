/*
 * frm_adm_revisa_pruebas_tutor.java
 *
 * Created on 27 de diciembre de 2005, 09:18 AM
 */

package libreria;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author  Esteban
 */
public class frm_adm_revisa_pruebas_tutor {
/////////////////////////////////////////////////////////////////////////////////////////   
      public static ArrayList<obj_dos_campos> ro_carga_tipo_evaluacion_ptutor(String eje_aca) {
    
        ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_llena_combo_tipo_prueba_ptutor '" + eje_aca + "'";
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
        
/////////////////////////////////////////////////////////////////////////////////////////
      
/////////////////////////////////////////////////////////////////////////////////////////
      
            public static ArrayList<obj_siete_campos> ro_carga_pruebas_tutor(String tip_pru_idn, String eje_aca) {
    
        ArrayList<obj_siete_campos> lista = new ArrayList<obj_siete_campos>();
        Connection c=null;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_baja_pruebas_tutor '" + tip_pru_idn + "','" + eje_aca + "'";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
           // lista.add(new obj_dos_campos("0","Seleccione"));
            while (rs.next()){
            
      
            lista.add(new obj_siete_campos(rs.getString("campo_uno")
                                        , rs.getString("campo_dos")
                                        , rs.getString("campo_tres")
                                        , rs.getString("campo_cuatro")
                                        , rs.getString("campo_cinco")
                                        , rs.getString("campo_seis")
                                        , rs.getString("campo_siete")));
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
/////////////////////////////////////////////////////////////////////////////////////////


/////////////////////////////////////////////////////////////////////////////////////////
     public static ArrayList<obj_diez_campos> ro_carga_detalle_pruebas_tutor(String mat_idn, String tip_pru_idn, String eje_aca) {
    
        ArrayList<obj_diez_campos> lista = new ArrayList<obj_diez_campos>();
        Connection c=null;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_pruebas_tutor_detalle_nota_alumno '" + mat_idn + "','" + tip_pru_idn + "','" + eje_aca + "'";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
           // lista.add(new obj_dos_campos("0","Seleccione"));
            while (rs.next()){
            
      
            lista.add(new obj_diez_campos(rs.getString("campo_uno")
                                        , rs.getString("campo_dos")
                                        , rs.getString("campo_tres")
                                        , rs.getString("campo_cuatro")
                                        , rs.getString("campo_cinco")
                                        , rs.getString("campo_seis")
                                        , rs.getString("campo_siete")
                                        , rs.getString("campo_ocho")
                                        , rs.getString("campo_nueve")
                                        , rs.getString("campo_diez")));
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
/////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////
           public static ArrayList<obj_un_campo_string> ro_verifica_fecha_nota_maxima_ingreso(String fecha_maxima,String not_idn) {
    
        ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_comprueba_fecha_maxima_ingreso_nota_tutor '" + fecha_maxima + "','" + not_idn + "' ";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            
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
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        public static ArrayList<obj_un_campo_string> ro_guarda_nota(String trabajo, String nota) {
    
        ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
        Connection c=null;
         int salida = 1;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_tutor_coloca_nota_pruebas_web '"+ trabajo + "','"+ nota + "'";
            cs = c.prepareCall(sql);
           // cs.setString(1, "633174");
            ResultSet rs = cs.executeQuery();
            
            while (rs.next()){

            lista.add(new obj_un_campo_string(rs.getString("campo_uno")));

            }
            
        } catch (Exception e) {
            e.printStackTrace();
            salida = 0;
        } finally {
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
         
        if (salida == 0)
        {
        lista.add(new obj_un_campo_string("n"));
        }
        
        return lista;
        }           
    /** Creates a new instance of frm_adm_revisa_pruebas_tutor */
    public frm_adm_revisa_pruebas_tutor() {
    }
    
}
