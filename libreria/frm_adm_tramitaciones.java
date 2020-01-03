/*
 * frm_adm_tramitaciones.java
 *
 * Created on 24 de noviembre de 2005, 09:41 AM
 */

package libreria;

/**
 *
 * @author  SyOuS [Esteban Ramírez]
 */
import java.util.ArrayList;
import java.sql.*;

public class frm_adm_tramitaciones {
    
    
 //***********************************************************************************************************
 // frm_adm_solicitudes.mxml --by.SyOuS
 //***********************************************************************************************************      
      public static ArrayList<obj_dos_campos> ro_solicitud_carga_documentos_a_tramitar_imcompleta(String tram_idn, String sol_idn) {
    
        ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_adm_solicitudes_carga_documentos_a_tramitar_incompleta '" + tram_idn +"', '" + sol_idn + "'";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            
            while (rs.next())
            {
                lista.add(new obj_dos_campos(rs.getString("doc_sol_sol_idn"),
                                             rs.getString("doc_sol_nombre")));
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
 // frm_adm_tramitaciones.mxml --by.SyOuS
 //***********************************************************************************************************      
      public static ArrayList<obj_cinco_campos> ro_tramitacion_carga_solicitudes(String mat_idn) {
    
        ArrayList<obj_cinco_campos> lista = new ArrayList<obj_cinco_campos>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_adm_tramitaciones_carga_solicitudes_sin_finalizar '" + mat_idn +"'";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            
            while (rs.next())
            {
                lista.add(new obj_cinco_campos(rs.getString("sol_idn"),
                                                rs.getString("tip_sol_nombre"),
                                                rs.getString("sol_fecha_ingreso"),
                                                rs.getString("est_sol_nombre"),
                                                rs.getString("est_sol_idn")));
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
 // frm_adm_solicitudes.mxml --by.SyOuS
 //***********************************************************************************************************      
      public static ArrayList<?> ro_solicitud_inserta_documentos_tramitacion(String tram_idn, String doc_sol_sol_idn, String est_tram_idn, String sol_idn) {
    
        ArrayList<?> lista = new ArrayList<Object>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_adm_solicitudes_inserta_documentos_tramitacion '" + tram_idn +"', '" + doc_sol_sol_idn + "','" + est_tram_idn + "', '" + sol_idn + "'";
            cs = c.prepareCall(sql);
            cs.executeQuery();
            

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
 // frm_adm_solicitudes.mxml --by.SyOuS
 //***********************************************************************************************************      
      public static ArrayList<obj_cuatro_campos> ro_solicitud_carga_documentos_a_solicitar(String mot_sol_idn) {
    
        ArrayList<obj_cuatro_campos> lista = new ArrayList<obj_cuatro_campos>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_adm_solicitudes_carga_documentos_a_solicitar '" + mot_sol_idn +"'";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            
            while (rs.next())
            {
                lista.add(new obj_cuatro_campos(rs.getString("doc_mot_sol_idn"),
                                                rs.getString("doc_mot_sol_obligatorio"),
                                                rs.getString("doc_sol_nombre"),
                                                rs.getString("obligatorio")));
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
 // frm_adm_solicitudes.mxml --by.SyOuS
 //***********************************************************************************************************      
      public static ArrayList<obj_cuatro_campos> ro_solicitud_carga_documentos_solicitados(String mot_sol_idn) {
    
        ArrayList<obj_cuatro_campos> lista = new ArrayList<obj_cuatro_campos>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_adm_solicitudes_carga_documentos_solicitados '" + mot_sol_idn + "'";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            
            while (rs.next())
            {
                lista.add(new obj_cuatro_campos(rs.getString("doc_mot_sol_idn"),
                                                rs.getString("doc_mot_sol_obligatorio"),
                                                rs.getString("doc_sol_nombre"),
                                                rs.getString("obligatorio")));
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
 // frm_adm_solicitudes.mxml --by.SyOuS
 //***********************************************************************************************************      
      public static ArrayList<obj_dos_campos> ro_solicitud_carga_documentos_a_tramitar(String sol_idn) {
    
        ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_adm_solicitudes_carga_documentos_a_tramitar '" + sol_idn +"'";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            
            while (rs.next())
            {
                lista.add(new obj_dos_campos(rs.getString("doc_sol_sol_idn"),
                                             rs.getString("doc_sol_nombre")));
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
 // frm_adm_solicitudes.mxml --by.SyOuS
 //***********************************************************************************************************      
      public static ArrayList<obj_dos_campos> ro_solicitud_carga_documentos_tramitados(String tram_idn, String est_tram_idn) {
    
        ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_adm_solicitudes_carga_documentos_tramitados '" + tram_idn +"', '" + est_tram_idn + "'";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            
            while (rs.next())
            {
                lista.add(new obj_dos_campos(rs.getString("doc_sol_sol_idn"),
                                             rs.getString("doc_sol_nombre")));
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
 // frm_adm_solicitudes.mxml --by.SyOuS
 //***********************************************************************************************************      
      public static ArrayList<obj_cuatro_campos> ro_solicitud_tramitaciones_solicitud(String sol_idn) {
    
        ArrayList<obj_cuatro_campos> lista = new ArrayList<obj_cuatro_campos>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_adm_solicitudes_carga_tramitaciones_solicitud '" + sol_idn +"'";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            while (rs.next()){
            
      
            lista.add(new obj_cuatro_campos(rs.getString("tram_idn"),
                                                        rs.getString("est_tram_idn"),
                                                        rs.getString("tram_fecha_ingreso"),
                                                        rs.getString("est_tram_nombre")));
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
 // frm_adm_solicitudes.mxml --by.SyOuS
 //***********************************************************************************************************      
      public static ArrayList<obj_un_campo_string> ro_solicitud_inserta_tramitacion(String func_mod_fun_idn
                                                            , String sol_idn
                                                            , String est_tram_idn) {
    
        ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_adm_solicitudes_inserta_tramitacion '" + func_mod_fun_idn +"', '" + sol_idn +"', '" + est_tram_idn + "'";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            while (rs.next())
            {
                lista.add(new obj_un_campo_string(rs.getString("corre_correlativo")));
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
 // frm_adm_solicitudes.mxml --by.SyOuS
 //***********************************************************************************************************      
 /*     public static ArrayList ro_solicitud_carga_doc_sol_a_tramitar(String sol_idn) {
    
        ArrayList lista = new ArrayList();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_adm_solicitudes_carga_documentos_tramitacion '" + sol_idn + "'";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            
            while (rs.next())
            {
                lista.add(new obj_cuatro_campos(rs.getString("doc_sol_sol_idn")
                                           , rs.getString("doc_sol_nombre")
                                           , rs.getString("doc_mot_sol_obligatorio")
                                           , rs.getString("obligatorio")));
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
    }*/
 //***********************************************************************************************************      
   
 //***********************************************************************************************************
 // frm_adm_solicitudes.mxml --by.SyOuS
 //***********************************************************************************************************      
      public static ArrayList<obj_tres_campos> ro_solicitud_verifica_solictud_tipo(String mat_idn, String tip_sol_idn) {
    
        ArrayList<obj_tres_campos> lista = new ArrayList<obj_tres_campos>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_adm_solicitudes_verifica_solicitud_tipo '" + mat_idn + "', '" + tip_sol_idn + "'";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            
            while (rs.next())
            {
                lista.add(new obj_tres_campos(rs.getString("sol_idn")
                                            , rs.getString("est_sol_idn")
                                            , rs.getString("est_sol_nombre")));
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
 // frm_adm_solicitudes.mxml --by.SyOuS
 //***********************************************************************************************************      
      public static ArrayList<?> ro_solicitud_inserta_documentos_solicitud(String sol_idn, String doc_mot_sol_idn) {
    
        ArrayList<?> lista = new ArrayList<Object>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_adm_solicitudes_inserta_documentos_solicitud '" + sol_idn + "', '" + doc_mot_sol_idn + "'";
            cs = c.prepareCall(sql);
            cs.executeQuery();
            
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
 // frm_adm_solicitudes.mxml --by.SyOuS
 //***********************************************************************************************************      
      public static ArrayList<obj_un_campo_string> ro_solicitud_inserta_solicitud(String func_mod_fun_idn
                                                            , String tip_sol_idn
                                                            , String est_sol_idn
                                                            , String mat_idn) {
    
        ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_adm_solicitudes_inserta_solicitud '" + func_mod_fun_idn +"', '" + tip_sol_idn +"', '" + est_sol_idn +"', '" + mat_idn +"'";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            while (rs.next())
            {
                lista.add(new obj_un_campo_string(rs.getString("corre_correlativo")));
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
 // frm_adm_solicitudes.mxml --by.SyOuS
 //***********************************************************************************************************      
      public static ArrayList<obj_dos_campos> ro_solicitud_carga_datos_alumno(String alu_idn) {
    
        ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_adm_solicitudes_carga_datos_alumno '" + alu_idn + "'";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            
            while (rs.next())
            {
                lista.add(new obj_dos_campos(rs.getString("alu_rut")
                                           , rs.getString("alu_nombre")));
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
 // frm_adm_solicitudes.mxml --by.SyOuS
 //***********************************************************************************************************      
      public static ArrayList<obj_cuatro_campos> ro_solicitud_carga_doc_sol_a_solicitar(String mot_sol_idn) {
    
        ArrayList<obj_cuatro_campos> lista = new ArrayList<obj_cuatro_campos>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_adm_solicitudes_carga_documentos_solicitud_a_solicitar '" + mot_sol_idn + "'";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            
            while (rs.next())
            {
                lista.add(new obj_cuatro_campos(rs.getString("doc_mot_sol_idn")
                                           , rs.getString("doc_sol_nombre")
                                           , rs.getString("doc_mot_sol_obligatorio")
                                           , rs.getString("obligatorio")));
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
 // frm_adm_solicitudes.mxml --by.SyOuS
 //***********************************************************************************************************      
      public static ArrayList<obj_dos_campos> ro_solicitud_carga_motivos_solicitud(String mat_idn, String tip_sol_idn) {
    
        ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_adm_solicitudes_carga_motivos_solicitud '" + mat_idn + "', '" + tip_sol_idn + "'";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            
            lista.add(new obj_dos_campos("0", " - Seleccione - "));
            
            while (rs.next())
            {
                lista.add(new obj_dos_campos(rs.getString("mot_sol_idn")
                                           , rs.getString("mot_sol_nombre")));
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
 // frm_adm_solicitudes.mxml --by.SyOuS
 //***********************************************************************************************************      
      public static ArrayList<obj_dos_campos> ro_solicitud_carga_tipo_solicitud(String mat_idn) {
    
        ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_adm_solicitudes_carga_tipo_solicitud '" + mat_idn + "'";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            
            lista.add(new obj_dos_campos("0", " - Seleccione - "));
            
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos(rs.getString("tip_sol_idn")
                                       , rs.getString("tip_sol_nombre")));
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
// F U N C I O N E S   F O R A N E A S 
//***********************************************************************************************************           
      
 //***********************************************************************************************************
 // frm_adm_tutor_visualiza_notas.mxml --by.SyOuS
 //***********************************************************************************************************      
      public static ArrayList<obj_dos_campos> ro_carga_alumnos_por_apellido(String alu_ap_paterno) {
    
        ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_adm_info_mat_busca_alumnos_por_apeliido '" + alu_ap_paterno + "'";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
        
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
 //***********************************************************************************************************  
      
 //***********************************************************************************************************
 // frm_adm_tutor_visualiza_notas.mxml --by.SyOuS
 //***********************************************************************************************************      
      public static ArrayList<obj_un_campo_string> ro_carga_alumnos_por_matricula(String matricula) {
    
        ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
        Connection c=null;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_adm_info_mat_busca_alumno_por_matricula '" + matricula + "'";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
        
            while (rs.next()){
            
      
      
            lista.add(new obj_un_campo_string(rs.getString("alu_rut")));
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
 // frm_adm_info_matriculas.mxml --by.SyOuS
 //***********************************************************************************************************      
      public static ArrayList<obj_tres_campos> ro_carga_matriculas_alumno_por_rut(String alu_rut) {
    
        ArrayList<obj_tres_campos> lista = new ArrayList<obj_tres_campos>();
        Connection c=null;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_adm_info_mat_matriculas_alumno '" + alu_rut + "'";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
        
            while (rs.next()){
            
      
      
            lista.add(new obj_tres_campos(rs.getString("mat_idn")
                                        , rs.getString("mal_nombre")
                                        , rs.getString("alu_idn")));
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
    public frm_adm_tramitaciones() {
    }
    
}
