/*
 * frm_adm_envio_pruebas_funcionario.java
 *
 * Created on 5 de enero de 2006, 03:12 PM
 */

package libreria;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author  Esteban
 */
public class frm_adm_envio_pruebas_funcionario {
       //////////////////////////////////////////////////////////////////////////////////
      

 //***********************************************************************************************************    
 //***********************************************************************************************************
 // grupos_new.mxml --by.SyOuS (frm by DJPhanter)
 //***********************************************************************************************************      
//***********************************************************************************************************      
  
  public static ArrayList<obj_tres_campos> muestra_matriculas_por_rut(String alu_rut) {
    
        ArrayList<obj_tres_campos> lista = new ArrayList<obj_tres_campos>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_matricula_promo_malla_muestra_x_rut '" + alu_rut + "'" ;
            cs = c.prepareCall(sql);
           // cs.setString(1, "633174");
            ResultSet rs = cs.executeQuery();
            
            while (rs.next())
            {
            
                  lista.add(new obj_tres_campos(rs.getString("campo_uno"),
                                     rs.getString("campo_dos"),
                                     rs.getString("campo_tres")
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
  //*****************************************************************************************
//ingreso pruebas funcionarios
      
        public static ArrayList<obj_dos_campos> muestra_toma_cursos_matricula (String mat_idn) {
    
        ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_adm_pruebas_tutor_toma_curso_por_matricula '" + mat_idn + "'";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            lista.add(new obj_dos_campos("0"," - Seleccione - "));
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
   public static void ro_inserta_func_mod(String func_mod, String trab_idn) {
        new ArrayList<Object>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_inserta_func_mod_subida_prueba_funcionario '"+ func_mod + "','"+ trab_idn + "'";
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
         
        }           
     public static ArrayList<obj_dos_campos> ro_llena_grilla_comprobante(String trab_idn) {
    
        ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;

        try {
            
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_envio_prueba_muestra_parti_trabajo (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,trab_idn.trim());
                    
            ResultSet rs = ps.executeQuery();
        
            
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

 
    ////////////////////////////////////////////////////////////////////
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
            sql = "flex_llena_combo_tipo_prueba_envio_funcionario '" + matricula + "', '" + eje_aca + "'";
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
            sql = "{call  flex_envio_prueba_alumno_trabajo (?,?,?)}" ;
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

         
         public static ArrayList<?> ro_genera_grupos_trabajo_web(String eje_aca_idn,String tip_pru_idn,String gru_eva_web_integrantes, String corre_idn,String tipo_envio, String glosa, String carpeta, ArrayList<?> matriculas ) {
    
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
            
             String sql1;
              int size = matriculas.size();
              obj_tres_campos registro = null;
                
            int j;
            for (j=0; j<size; j++) 
               {
                    
                       registro = (obj_tres_campos) matriculas.get(j);
                        sql1 = "{call flex_envio_prueba_inserta_detalle (?,?,?,?,?)}" ;
                        CallableStatement ps1 = c.prepareCall(sql1);
                        ps1.setString(1,registro.getcampo_uno());
                        ps1.setString(2,corre_idn.trim());
                        ps1.setString(3,registro.getcampo_dos());
                        ps1.setString(4,eje_aca_idn.trim());
                        ps1.setString(5,tip_pru_idn.trim());
                        ps1.execute();
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
    /** Creates a new instance of frm_adm_envio_pruebas_funcionario */
    public frm_adm_envio_pruebas_funcionario() {
    }
    
}
