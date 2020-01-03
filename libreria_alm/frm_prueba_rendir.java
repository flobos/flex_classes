/*
 * frm_grupos_new.java
 *
 * Created on 26 de enero de 2006, 10:36
 */

package libreria_alm;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author  lobo
 */
public class frm_prueba_rendir {
    
    /** Creates a new instance of frm_grupos_new */
    public frm_prueba_rendir() {
    }
    
      public static ArrayList<obj_un_campo_string> ro_obtiene_correlativo_trabajos() {
    
        ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
        Connection c=null;
      
        
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_envio_prueba_genera_correlativo";
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
      
       public static ArrayList<obj_dos_campos> ro_carga_tipo_evaluacion(String matricula, String eje_aca) {
    
        ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_llena_combo_tipo_prueba '" + matricula + "', '" + eje_aca + "'";
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
       
       
       
      public static ArrayList<obj_dos_campos> ro_comprueba_unico_participante(String mat_idn, String tip_pru, String eje_aca) {
    
        ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
        
        try {
                       
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_envio_prueba_unico_participante (?,?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,mat_idn.trim());
            ps.setString(2,tip_pru.trim());
            ps.setString(3,eje_aca.trim());
                      
                      
            ResultSet rs = ps.executeQuery();
        
            while (rs.next()){

            lista.add(new obj_dos_campos(rs.getString("nombre_completo")
                                        , rs.getString("matricula")));
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

       public static ArrayList<obj_dos_campos> ro_consulta_busca_alumno(String alu_rut, String tip_pru, String eje_aca) {
    
        ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
        
        try {
          
            
            
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_envio_prueba_alumno_trabajo (?,?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,alu_rut.trim());
            ps.setString(2,tip_pru.trim());
            ps.setString(3,eje_aca.trim());
                      
            ResultSet rs = ps.executeQuery();
        
            while (rs.next()){

            lista.add(new obj_dos_campos(rs.getString("nombre_completo")
                                        , rs.getString("matricula")));
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

         
    public static ArrayList<?> ro_genera_grupos_trabajo_web(String eje_aca_idn,String tip_pru_idn,String gru_eva_web_integrantes, String corre_idn,String tipo_envio, String glosa, String carpeta ) {
    
        ArrayList<?> lista = new ArrayList<Object>();
        Connection c=null;
        try {
            
   
           
             String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_envio_prueba_inserta_trabajo (?,?,?,?,?,?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,eje_aca_idn.trim());
            ps.setString(2,tip_pru_idn.trim());
            ps.setString(3,gru_eva_web_integrantes.trim());
            ps.setString(4,corre_idn.trim());
            ps.setString(5,tipo_envio.trim());
            ps.setString(6,glosa.trim());
            ps.setString(7,carpeta.trim());
             ps.execute();
            
            
            
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
     
    
    public static ArrayList<?> ro_actualiza_nota(String matricula, String responsable, String eje_aca, String tip_pru_idn, String trabajo ) 
     {
        ArrayList<?> lista = new ArrayList<Object>();
        Connection c=null;
         try {
             c = conexion_odbc.Connexion_datos();
                String sql;
                    sql = "{call flex_envio_prueba_actualiza_nota (?,?,?,?,?)}" ;
                    CallableStatement ps1 = c.prepareCall(sql);
                    ps1.setString(1,matricula.trim());
                    ps1.setString(2,trabajo.trim());
                    ps1.setString(3,responsable.trim());
                    ps1.setString(4,eje_aca.trim());
                    ps1.setString(5,tip_pru_idn.trim());
                    ps1.execute();
                    
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
    
     public static ArrayList<?> ro_genera_detalle_grupos_trabajo_web(String matricula, String responsable, String trabajo ) 
     {
        ArrayList<?> lista = new ArrayList<Object>();
        Connection c1=null;
         try {
             c1 = conexion_odbc.Connexion_datos();
                String sql1; 
                    sql1 = "{call flex_envio_prueba_inserta_detalle_trabajo (?,?,?)}" ;
                    CallableStatement ps1 = c1.prepareCall(sql1);
                    ps1.setString(1,matricula.trim());
                    ps1.setString(2,trabajo.trim());
                    ps1.setString(3,responsable.trim());
                    ps1.execute();
                    
        
        } catch (Exception e) {
            e.printStackTrace();
           
        } finally {
            try {
                    c1.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return lista;
    }  
    
    
    
    
            
    
    
          
           
     public static ArrayList<obj_cinco_campos> muestra_informacion_de_toma_curso(String toma) {
    ArrayList<obj_cinco_campos> lista = new ArrayList<obj_cinco_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_pruebas_envia_muestra_matricula_ejecucion_Aca (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, toma.trim());
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
      
            lista.add(new obj_cinco_campos(rs.getString("nombre"), 
                                          rs.getString("mat_idn"),
                                          rs.getString("eje_aca_idn"), 
                                          rs.getString("mal_nombre"),
                                          rs.getString("cur_nombre")));
           
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



           
}
