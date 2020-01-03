/*
 * frm_adm_fuc_detalle_motivo.java
 *
 * Created on 20 de diciembre de 2005, 04:12 PM
 */

package libreria;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author  Esteban
 */
public class frm_adm_fuc_detalle_motivo {
 //***********************************************************************************************************
 // frm_adm_fuc_funcionario.mxml --by.SyOuS
 //***********************************************************************************************************      
      public static ArrayList<?> ro_fuc_inserta_derivacion_fuc_tutor(String fuc_web_idn
                                                                , String est_mot_fuc_idn
                                                                , String mot_fuc_idn
                                                                , String tc_idn
                                                                , String mod_cam_mot_idn
                                                                , String mod_cam_cri_idn) {
    
        ArrayList<?> lista = new ArrayList<Object>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_adm_fuc_funcionario_inserta_fuc_derivado_tutor '" + fuc_web_idn + "', '" + est_mot_fuc_idn +"', '" + mot_fuc_idn + "', '" + tc_idn +"', '" + mod_cam_mot_idn + "','" + mod_cam_cri_idn + "'" ;
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
 // frm_adm_fuc_tutor.mxml --by.RGN --Cloned.by.SyOuS
 //***********************************************************************************************************          
     public static ArrayList<obj_dos_campos> ro_fuc_muestra_toma_cursos(String mat_idn) {
    
        ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
        
        int salida = 1;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_fuc_muestra_toma_cursos '" + mat_idn + "'";
            cs = c.prepareCall(sql);
           // cs.setString(1, "633174");
            ResultSet rs = cs.executeQuery();
            
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
        
        if (salida == 0)
        {
            lista.add(new obj_dos_campos("n", "n"));
        }
        
        return lista;
    }
//***********************************************************************************************************      
 //***********************************************************************************************************
 // frm_adm_fuc_detalle_motivo.mxml --by.SyOuS
 //***********************************************************************************************************      
      public static ArrayList<obj_un_campo_string> ro_fuc_rederiva_fuc(String campo_uno, String campo_dos, String campo_tres, String campo_cuatro) {
    
        ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_adm_fuc_funcionario_rederiva_fuc '" + campo_uno + "','"+ campo_dos +"','" + campo_tres + "','" + campo_cuatro + "'";
            cs = c.prepareCall(sql);
            cs.executeQuery();
            
            lista.add(new obj_un_campo_string("0"));

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
 // frm_adm_fuc_funcionario.mxml --by.SyOuS
 //***********************************************************************************************************      
      public static ArrayList<obj_un_campo_string> ro_carga_fuc_nombre_malla(String mot_fuc_idn) {
    
        ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_adm_fuc_funcionario_carga_nombre_curso '" + mot_fuc_idn +"'" ;
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            
            while (rs.next()){
            
      
            lista.add(new obj_un_campo_string(rs.getString("cur_nombre")));
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
 // frm_adm_fuc_detalle_motivo.mxml --by.SyOuS
 //***********************************************************************************************************      
      public static ArrayList<obj_un_campo_string> ro_fuc_verifica_func_deriva(String fun_rut, String motivo_fuc) {
    
        ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
        Connection c=null;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_adm_fuc_funcionario_verifica_func_deriva '" + fun_rut  + "', '" + motivo_fuc + "'" ;
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
        
            while (rs.next()){
            
      
            lista.add(new obj_un_campo_string(rs.getString("func_mod_fun_idn")));
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
 // frm_adm_fuc_detalle_motivo.mxml --by.SyOuS
 //***********************************************************************************************************      
      public static ArrayList<obj_tres_campos> ro_fuc_carga_resolucion_fuc(String motivo_fuc) {
    
        ArrayList<obj_tres_campos> lista = new ArrayList<obj_tres_campos>();
        Connection c=null;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_adm_fuc_funcionario_carga_resolucion_fuc '" + motivo_fuc  + "'" ;
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
        
            while (rs.next()){
            
      
            lista.add(new obj_tres_campos(rs.getString("fuc_web_idn"),
                                                    rs.getString("mot_fuc_fecha_cam_est"),
                                                    rs.getString("mot_fuc_resolucion")));
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
 // frm_adm_fuc_detalle_motivo.mxml --by.SyOuS
 //***********************************************************************************************************      
      public static ArrayList<?> ro_fuc_inserta_resolucion_fuc(String motivo_fuc, String resolucion, String est_fuc, String cau_mot_fuc_idn) {
    
        ArrayList<?> lista = new ArrayList<Object>();
        Connection c=null;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_adm_fuc_funcionario_resuelve_fuc '" + motivo_fuc  + "', '" + resolucion + "', '" + est_fuc + "', '" + cau_mot_fuc_idn + "'";
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
 // frm_adm_fuc_detalle_motivo.mxml --by.SyOuS
 //***********************************************************************************************************      
      public static ArrayList<?> ro_fuc_inserta_derivacion_fuc(String fuc_web, String motivo_criterio, String funcion_modalidad, String estado_motivo, String mot_fuc_idn) {
    
        ArrayList<?> lista = new ArrayList<Object>();
        Connection c=null;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_adm_fuc_funcionario_inserta_fuc_derivado '" + fuc_web  + "', '" + motivo_criterio + "', '" + funcion_modalidad + "', '" + estado_motivo + "', '" + mot_fuc_idn + "'" ;
            cs = c.prepareCall(sql);
            cs.executeQuery();
        
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            
           // lista.add(new obj_ro_fuc_inserta_derivacion_fuc(exito));
            
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
 // frm_adm_fuc_detalle_motivo.mxml --by.SyOuS
 //***********************************************************************************************************      
      public static ArrayList<obj_tres_campos> ro_fuc_verifica_func(String matricula, String criterio, String motivo) {
    
        ArrayList<obj_tres_campos> lista = new ArrayList<obj_tres_campos>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_adm_fuc_funcionario_verifica_func_derivacion '" + matricula  + "', '" + criterio + "', '" + motivo + "'" ;
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            
            while (rs.next()){
            
      
            lista.add(new obj_tres_campos(rs.getString("func_mod_fun_idn"),
                                                    rs.getString("seg_div_pol_idn"),
                                                    rs.getString("mot_cri_mod_can_idn")));
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
 // frm_adm_fuc_detalle_motivo.mxml --by.SyOuS
 //***********************************************************************************************************      
      public static ArrayList<obj_combo_tres_campos> ro_carga_criterios_fuc(String rut_funcionario, String mat_idn) {
    
        ArrayList<obj_combo_tres_campos> lista = new ArrayList<obj_combo_tres_campos>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_adm_fuc_funcionario_carga_criterios_fuc '" + rut_funcionario  + "', '" + mat_idn + "'" ;
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            
            lista.add(new obj_combo_tres_campos("0", "0"," - Seleccione - "));
            
            while (rs.next()){
            
            lista.add(new obj_combo_tres_campos(rs.getString("data"),
                                                    rs.getString("data2"),
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
 //***********************************************************************************************************      
     
 //***********************************************************************************************************
 // frm_adm_fuc_detalle_motivo.mxml --by.SyOuS
 //***********************************************************************************************************      
      public static ArrayList<obj_dos_campos> ro_carga_motivos_fuc(String rut_funcionario, String mod_campus_cri) {
    
        ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_adm_fuc_funcionario_carga_motivos_fuc '" + rut_funcionario  + "', '" + mod_campus_cri + "'" ;
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            
            lista.add(new obj_dos_campos("0"," - Seleccione - "));
            
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
 //***********************************************************************************************************      
    
//***********************************************************************************************************
// frm_adm_fuc_detalle_motivo.mxml --by.SyOuS
//***********************************************************************************************************   
      public static ArrayList<obj_dos_campos> ro_carga_fuc(String fuc_web) {
     
        ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;

        try {
         
            c = conexion_odbc.Connexion_datos();
            Statement s = c.createStatement();
            ResultSet rs =  s.executeQuery("select cast(fuc_web_fecha_ing as varchar(10)) as fuc_web_fecha_ing, fuc_web_consulta from fuc_web where fuc_web_idn = '" + fuc_web + "'");
           
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos(rs.getString("fuc_web_fecha_ing")
                                         , rs.getString("fuc_web_consulta")));
            
            
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
 // frm_adm_fuc_detalle_motivo.mxml --by.SyOuS
 //***********************************************************************************************************      
      public static ArrayList<obj_seis_campos> ro_fuc_carga_criterios_del_fuc(String fuc_web) {
    
        ArrayList<obj_seis_campos> lista = new ArrayList<obj_seis_campos>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_adm_fuc_funcionario_carga_criterios_del_fuc '" + fuc_web + "'";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            
            while (rs.next()){
         
            lista.add(new obj_seis_campos(rs.getString("mot_fuc_idn"),
                                          rs.getString("cri_con_nombre"),
                                          rs.getString("mot_con_nombre"),
                                          rs.getString("est_mot_fuc_nombre"),
                                          rs.getString("nombre"),
                                          rs.getString("cri_con_idn")));
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
 // frm_adm_fuc_detalle_motivo.mxml --by.SyOuS
 //***********************************************************************************************************      
      public static ArrayList<obj_dos_campos> ro_fuc_carga_datos_alumno(String matricula) {
    
        ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_adm_fuc_funcionario_carga_datos_alumno '" + matricula + "'";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            
            while (rs.next()){
         
            lista.add(new obj_dos_campos(rs.getString("nombre"),
                                         rs.getString("mal_nombre")));
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
 // frm_adm_fuc_detalle_motivo.mxml --by.SyOuS
 //***********************************************************************************************************      
      public static ArrayList<obj_un_campo_string> ro_fuc_verifica_derivacion_seg_opc(String mod_cam_mot_idn, String mod_cam_cri_idn, String mot_fuc_idn) {
    
        ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_adm_fuc_funcionario_verifica_derivacion_segunda_opcion '" + mod_cam_mot_idn + "', '" + mod_cam_cri_idn + "', '" + mot_fuc_idn + "'";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            
            while (rs.next()){
         
            lista.add(new obj_un_campo_string(rs.getString("mot_cri_mod_cam_idn")));
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
 // frm_adm_fuc_detalle_motivo.mxml --by.SyOuS
 //***********************************************************************************************************      
      public static ArrayList<obj_tres_campos> ro_fuc_busca_derivacion_seg_opc(String matricula, String mot_cri_mod_cam_idn) {
    
        ArrayList<obj_tres_campos> lista = new ArrayList<obj_tres_campos>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_adm_fuc_funcionario_busca_segunda_opcion '" + matricula + "', '" + mot_cri_mod_cam_idn + "'";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            
            while (rs.next()){
         
            lista.add(new obj_tres_campos(rs.getString("func_mod_fun_idn")
                                        , rs.getString("seg_div_pol_idn")
                                        , rs.getString("mot_cri_mod_can_idn")));
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
 // frm_adm_fuc_detalle_motivo.mxml --by.SyOuS
 //***********************************************************************************************************      
      public static ArrayList<obj_dos_campos> ro_fuc_carga_causas_motivos() {
    
        ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "select * from causa_motivo_fuc";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            
            lista.add(new obj_dos_campos("", "-- Seleccione --"));
            
            while (rs.next()){
         
            lista.add(new obj_dos_campos(rs.getString("cau_mot_fuc_idn")
                                        , rs.getString("cau_mot_fuc_nombre")));
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
    /** Creates a new instance of frm_adm_fuc_detalle_motivo */
    public frm_adm_fuc_detalle_motivo() {
    }
    
}
