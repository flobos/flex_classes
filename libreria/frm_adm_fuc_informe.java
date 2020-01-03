/*
 * frm_adm_fuc_informe.java
 *
 * Created on 21 de diciembre de 2005, 10:07 AM
 */

package libreria;
import java.util.ArrayList;
import java.io.Serializable;
import java.sql.*;
/**
 *
 * @author  Esteban
 */
public class frm_adm_fuc_informe {
/**************************************************************************/         
/////   frm_adm_fuc_informe.mxml      by Arcturus              
/********************************************************************************/        
       public static ArrayList<obj_dos_campos> campus_muestra() {
    
        ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;

        try {
         
            c = conexion_odbc.Connexion_datos();
            
            CallableStatement cs;
            cs = c.prepareCall("flex_muestra_campus");
            //cs.setString(1, "a string");
            ResultSet rs = cs.executeQuery();
            //lista.add(0,"SELECCIONE");
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos(rs.getString("data"),rs.getString("label")));
            
            
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
       
/**************************************************************************/         
/////   frm_adm_fuc_informe.mxml      by Arcturus              
/********************************************************************************/       

       public static ArrayList<obj_dos_campos> modalidad_muestra() {
    
        ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;

        try {
         
            c = conexion_odbc.Connexion_datos();
            
            CallableStatement cs;
            cs = c.prepareCall("flex_muestra_modalidad");
            //cs.setString(1, "a string");
            ResultSet rs = cs.executeQuery();
            //lista.add(0,"SELECCIONE");
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos(rs.getString("data"),rs.getString("label")));
            
            
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

/**************************************************************************/         
/////   frm_adm_fuc_informe.mxml      by Arcturus              
/********************************************************************************/
       
       public static ArrayList<obj_dos_campos> sede_muestra() {
    
        ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;

        try {
         
            c = conexion_odbc.Connexion_datos();
            
            CallableStatement cs;
            cs = c.prepareCall("flex_muestra_sede");
            //cs.setString(1, "a string");
            ResultSet rs = cs.executeQuery();
             //lista.add(0,"SELECCIONE");
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos(rs.getString("data"),rs.getString("label")));
            
            
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

 /**************************************************************************/        
/////   frm_adm_fuc_informe.mxml      by Arcturus              
/********************************************************************************/
       
       public static ArrayList<obj_dos_campos> funcion_muestra() {
    
        ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;

        try {
         
            c = conexion_odbc.Connexion_datos();
            
            CallableStatement cs;
            cs = c.prepareCall("flex_muestra_funcion");
            //cs.setString(1, "a string");
            ResultSet rs = cs.executeQuery();
            //lista.add(0,"SELECCIONE");
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos(rs.getString("data"),rs.getString("label")));
            
            
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

/**************************************************************************/      
/////   frm_adm_fuc_informe.mxml      by Arcturus            
/********************************************************************************/    
       

       public static ArrayList<obj_dos_campos> muestra_estados_motivos() {
    
        ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_muestra_estado_motivos";
            cs = c.prepareCall(sql);
           // cs.setString(1, "633174");
            ResultSet rs = cs.executeQuery();
              //lista.add(0,"SELECCIONE");
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos(rs.getString("data"),
                                  rs.getString("label")));
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
/**************************************************************************/      
/////   frm_adm_fuc_informe.mxml      by Arcturus       
/********************************************************************************/    
       
       public static ArrayList<obj_diez_campos> muestra_informe_consulta(String campus, String modalidad, String sede, String funcion, String plazo, String fechadesde, String fechahasta) {
    
        ArrayList<obj_diez_campos> lista = new ArrayList<obj_diez_campos>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_muestra_listado_consultas '" + campus.trim() + "' , '" + modalidad.trim() + "' , '" + sede.trim() + "' , '" + funcion.trim() + "' , '" + plazo.trim() + "' , '" + fechadesde.trim() + "' , '" + fechahasta.trim() + "'";
            cs = c.prepareCall(sql);
           // cs.setString(1, "633174");
            ResultSet rs = cs.executeQuery();
            
            while (rs.next()){
            
      
            lista.add(new obj_diez_campos(rs.getString("rut"),
                                  rs.getString("funcionario"),
                                  rs.getString("sede"),
                                  rs.getString("resueltos"),
                                  rs.getString("pendientes"),
                                  rs.getString("derivados"),
                                  rs.getString("sinresolver"),
                                  rs.getString("rederivados"),
                                  rs.getString("nocorresponde"), 
                                  rs.getString("enproceso")));
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
    /** Creates a new instance of frm_adm_fuc_informe */
    public frm_adm_fuc_informe() {
    }
 //***********************************************************************************************************
 // frm_adm_fuc_informe_consultas.mxml --by.SyOuS
 //***********************************************************************************************************      
      public static ArrayList<Serializable> ro_carga_motivos_fuc_por_funcionario(String fun_rut, String estado_fuc, String mod_idn, String cam_idn) {
    
        ArrayList<Serializable> lista = new ArrayList<Serializable>();
        Connection c=null;
        
        int salida = 1;
        
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_adm_fuc_info_carga_motivos_por_func '" + fun_rut + "', '" + estado_fuc + "', '" + mod_idn + "', '" + cam_idn + "'";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
        
            while (rs.next()){

            lista.add(new obj_ocho_campos(rs.getString("mot_fuc_idn")
                                        , rs.getString("nombre")
                                        , rs.getString("mod_nombre")
                                        , rs.getString("cam_nombre")
                                        , rs.getString("mot_con_nombre")
                                        , rs.getString("est_mot_fuc_nombre")
                                        , rs.getString("mot_fuc_fecha_cam_est")
                                        , rs.getString("fuc_web_idn")));
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
            lista.add(new obj_dos_campos("n", "n"));
        }
        
        return lista;
    }     
       
      

 //***********************************************************************************************************
 // frm_adm_fuc_informe_consultas.mxml --by.SyOuS
 //***********************************************************************************************************      
      public static ArrayList<obj_tres_campos> ro_carga_detalle_motivo_fuc(String mot_fuc_idn) {
    
        ArrayList<obj_tres_campos> lista = new ArrayList<obj_tres_campos>();
        Connection c=null;
        
        int salida = 1;
        
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_adm_fuc_info_carga_detalle_motivo_fuc '" + mot_fuc_idn + "'";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
        
            while (rs.next()){

            lista.add(new obj_tres_campos(rs.getString("campo_uno")
                                        , rs.getString("campo_dos")
                                        , rs.getString("campo_tres")));
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
            lista.add(new obj_tres_campos("n", "n", "n"));
        }
        
        return lista;
    }    
}
