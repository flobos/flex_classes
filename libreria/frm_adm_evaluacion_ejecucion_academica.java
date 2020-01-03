/*
 * frm_adm_evaluacion_academica.java
 *
 * Created on 14 de junio de 2007, 19:58
 */

package libreria;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author  Administrador
 */
public class frm_adm_evaluacion_ejecucion_academica {
    
    /** Creates a new instance of frm_adm_evaluacion_academica */
    public frm_adm_evaluacion_ejecucion_academica() {
    }
    
    
     //------------------------------------------------------------------------------------------------
    
     public static ArrayList<obj_dos_campos> llena_combo_ejecucion(String func_mod_fun_idn) {
      ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_adm_evaluacion_ejecucion_academica_combo_ejecucion (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
         
                       
            ps.setString(1,func_mod_fun_idn.trim());
            ps.execute();
            
            
            
                      
            ResultSet rs = ps.executeQuery();
            
             
              lista.add(new obj_dos_campos("0"," - Seleccione - "));
                 
            
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos (rs.getString("eje_idn"), 
                                         rs.getString("eje_nombre")));
           
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
     
//-------------------------------------------------------------------------------------------------
    
   
  public static ArrayList<obj_cinco_campos> llena_grilla_ejecuccion_academica(String eje_idn,String func_mod_fun_idn) {
      ArrayList<obj_cinco_campos> lista = new ArrayList<obj_cinco_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_adm_evaluacion_ejecucion_academica_llena_grilla_ejecucion_academica(?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
             
            ps.setString(1,eje_idn.trim());
              ps.setString(2,func_mod_fun_idn.trim());
            ps.execute();
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                  
            lista.add(new obj_cinco_campos (rs.getString("eje_aca_idn"), 
                                          rs.getString("cur_nombre"),
                                          rs.getString("tip_prod_nombre"),
                                              rs.getString("sec_nombre"),
                                                  rs.getString("tip_jor_nombre")
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
  //-------------------------------------------------------------------------------------------------
    
   
  public static ArrayList<obj_ocho_campos> llena_grilla_evaluaciones_ingresadas(String eje_aca_idn) {
      ArrayList<obj_ocho_campos> lista = new ArrayList<obj_ocho_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_adm_evaluacion_ejecucion_academica_llena_grilla_evaluaciones_ingresadas(?)}" ;
            CallableStatement ps = c.prepareCall(sql);
             
            ps.setString(1,eje_aca_idn.trim());
            ps.execute();
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                  
            lista.add(new obj_ocho_campos (rs.getString("eva_eje_idn"), 
                                          rs.getString("tip_pru_nombre"),
                                          rs.getString("eva_eje_ponderacion"),
                                              rs.getString("eva_eje_fecha"),
                                                   rs.getString("eva_eje_disponible"),
                                                    rs.getString("fun_rut"),
                                                    rs.getString("sit_eva_nombre"),
                                                     rs.getString("procedimiento")
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

  //------------------------------------------------------------------------------------------------
    
     public static ArrayList<obj_dos_campos> llena_combo_tipo_prueba() {
      ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_adm_evaluacion_ejecucion_academica_combo_tipo_prueba ()}" ;
            CallableStatement ps = c.prepareCall(sql);
         
                      
            ResultSet rs = ps.executeQuery();
            
             
              lista.add(new obj_dos_campos("0"," - Seleccione - "));
                 
            
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos (rs.getString("tip_pru_idn"), 
                                         rs.getString("tip_pru_nombre")));
           
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
//******************************************************************************
  public static ArrayList<obj_dos_campos> busca_revisor_popup(String busqueda,String func_idn,String func_mod_fun_idn) {
      ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_popup_busca_datos_revisor(?,?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
             
            ps.setString(1,busqueda.trim());
            ps.setString(2,func_idn.trim());
            ps.setString(3,func_mod_fun_idn.trim());
            ps.execute();
            
            ResultSet rs = ps.executeQuery();
            
              while (rs.next()){
                  
            lista.add(new obj_dos_campos (rs.getString("fun_rut"),
                                                rs.getString("datos")
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
  //------------------------------------------------------------------------------------------------
    
     public static ArrayList<obj_dos_campos> llena_combo_situacion() {
      ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_adm_evaluacion_ejecucion_academica_combo_situacion ()}" ;
            CallableStatement ps = c.prepareCall(sql);
         
                      
            ResultSet rs = ps.executeQuery();
            
             
              lista.add(new obj_dos_campos("0"," - Seleccione - "));
                 
            
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos (rs.getString("sit_eva_idn"), 
                                         rs.getString("sit_eva_nombre")));
           
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
//-------------------------------------------------------------------------
     //******************************************************************************
  public static ArrayList<obj_un_campo_string> busca_ejecucion_academica(ArrayList<?> arreglo_ejec) {
      ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
        Connection c=null;
         try {
            
            String sql;
                      
            int size = arreglo_ejec.size();   
             
                
                obj_un_campo_string registro_eje = null;
                
                 int x;    
              
    
             for (x=0; x<size; x++) 
                {
                    
                     registro_eje = (obj_un_campo_string) arreglo_ejec.get(x);
      
                              c = conexion_odbc.Connexion_datos();
            
                  sql = "{call frm_adm_evalucion_eje_aca_busca_ejecucion_academica_vacia (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,registro_eje.getcampo_uno());
            ps.execute();
            
             

                         ResultSet rs = ps.executeQuery();

                          while (rs.next()){

                        lista.add(new obj_un_campo_string (rs.getString("eje_aca_idn")
                                                          
                                                                      ));


                        }
 
     
             
             }
  
        }
        
  catch (Exception e) {
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

//******************************************************************************
  public static ArrayList<obj_un_campo_string> inserta_evaluacion(ArrayList<?> arreglo_ejecucion, String modalidad, ArrayList<?> arreglo_final) {
    
        ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
    
        Connection c=null;
        try {
            
            
       //     c = conexion_odbc.Connexion_datos();
       //     if (arreglo_ejecucion.size() > 0 && arreglo_final.size() > 0)
        //    {   
                int x;    
                int j;
                int size2 = arreglo_ejecucion.size();   
                int size = arreglo_final.size();
                
                obj_siete_campos registro = null;
                obj_un_campo_string registro_eje = null;
                String sql;
                
                x=0;
                for (x=0; x<size2; x++) 
                {
                    
                     registro_eje = (obj_un_campo_string) arreglo_ejecucion.get(x);
                                j=0;
                                for (j=0; j<size; j++) 
                                   {

                                            registro = (obj_siete_campos) arreglo_final.get(j);
                                            c = conexion_odbc.Connexion_datos();
                                            sql = "{call frm_evaluacion_ejecucion_aca_inserta_datos  (?,?,?,?,?,?,?,?,?)}" ;
                                            CallableStatement ps1 = c.prepareCall(sql);
                                           
                                            ps1.setString(1,registro_eje.getcampo_uno());
                                            ps1.setString(2,registro.getcampo_uno());
                                            ps1.setString(3,registro.getcampo_dos());
                                            ps1.setString(4,registro.getcampo_tres());
                                            ps1.setString(5, modalidad.trim());
                                            ps1.setString(6,registro.getcampo_cuatro());
                                            ps1.setString(7,registro.getcampo_cinco());
                                            ps1.setString(8,registro.getcampo_seis());
                                            ps1.setString(9,registro.getcampo_siete());
                                            ps1.execute();
                        
                        
                                }
                                           
                       }
            
                        
      //      }           
                        /*String sql;
              int size = arreglo_final.size();
              obj_siete_campos registro = null;
                
            int j;
            for (j=0; j<size; j++) 
               {
                    
                       registro = (obj_siete_campos) arreglo_final.get(j);
                        c = conexion_odbc.Connexion_datos();
                        sql = "{call frm_evaluacion_ejecucion_aca_inserta_datos  (?,?,?,?,?,?,?,?,?)}" ;
                        CallableStatement ps1 = c.prepareCall(sql);
                        ps1.setString(1, eje_aca_idn.trim());
                        ps1.setString(2,registro.getcampo_uno());
                        ps1.setString(3,registro.getcampo_dos());
                        ps1.setString(4,registro.getcampo_tres());
                         ps1.setString(5,registro.getcampo_cuatro());
                          ps1.setString(6, modalidad.trim());
                         ps1.setString(7,registro.getcampo_cinco());
                          ps1.setString(8,registro.getcampo_seis());
                          ps1.setString(9,registro.getcampo_siete());
                        ps1.execute();*/
              
      
                         
           } catch (Exception e) {
            e.printStackTrace();
            lista.add(new obj_un_campo_string("ERROR"));
           
        } finally {
                     
             lista.add(new obj_un_campo_string("OK"));           
            try {
                    c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            
            
            }
        }
        return lista;
    }    
    
//------------------------------------------------------------------------------------------------
    
     public static ArrayList<obj_dos_campos> llena_combo_funcion_pop_up() {
      ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_pop_up_eva_eje_academica_combo_funcion ()}" ;
            CallableStatement ps = c.prepareCall(sql);
         
                      
            ResultSet rs = ps.executeQuery();
            
             
              lista.add(new obj_dos_campos("0"," - Seleccione - "));
                 
            
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos (rs.getString("func_idn"), 
                                         rs.getString("func_nombre")));
           
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
  //------------------------------------------------------------------------------------------------
    
     public static ArrayList<obj_dos_campos> llena_combo_tipo_prueba_para_modificar() {
      ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_adm_evaluacion_ejecucion_academica_llena_combo_tipo_prueba_para_modificar ()}" ;
            CallableStatement ps = c.prepareCall(sql);
         
                      
            ResultSet rs = ps.executeQuery();
            
             
              lista.add(new obj_dos_campos("0"," - Seleccione - "));
                 
            
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos (rs.getString("tip_pru_idn"), 
                                         rs.getString("tip_pru_nombre")));
           
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
  
//------------------------------------------------------------------------------------------------
    
     public static ArrayList<obj_dos_campos> llena_combo_procedimiento() {
      ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_adm_evaluciones_ejecucion_academica_llena_combo_tipo_proceso()}" ;
            CallableStatement ps = c.prepareCall(sql);
         
                      
            ResultSet rs = ps.executeQuery();
            
             
              lista.add(new obj_dos_campos("0"," - Seleccione - "));
                 
            
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos (rs.getString("pro_eva_idn"), 
                                         rs.getString("datos")));
           
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
 //******************************************************************************
  public static ArrayList<obj_un_campo_string> modificar_fechas_evaluaciones(ArrayList<?> arreglo_ejecucion, String tip_pru_nombre, String eva_eje_disponible,String eva_eje_fecha) {
    
        ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
    
        Connection c=null;
        try {
            
          
           String sql;
            
                int size2 = arreglo_ejecucion.size();   
                                            
                obj_un_campo_string registro_eje = null;
                
                 int x;    
               
    
             for (x=0; x<size2; x++) 
                {
                    
                     registro_eje = (obj_un_campo_string) arreglo_ejecucion.get(x);
                     
                                                                         
                                            c = conexion_odbc.Connexion_datos();
                                            sql = "{call frm_adm_evaluciones_ejecucion_academica_modifica_fechas_por_ejecucion_academica  (?,?,?,?)}" ;
                                            CallableStatement ps1 = c.prepareCall(sql);
                                           
                                            ps1.setString(1,registro_eje.getcampo_uno());
                                            ps1.setString(2,tip_pru_nombre.trim());
                                            ps1.setString(3,eva_eje_disponible.trim());
                                             ps1.setString(4,eva_eje_fecha.trim());
                                             
                                            ps1.execute();
                        
                        
                                      
                       }
            
                        
           } catch (Exception e) {
            e.printStackTrace();
            lista.add(new obj_un_campo_string("ERROR"));
           
        } finally {
                     
             lista.add(new obj_un_campo_string("OK"));           
            try {
                    c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            
            
            }
        }
        return lista;
    }     
 //******************************************************************************
  public static ArrayList<obj_un_campo_string> genera_notas_ejecucion_academica(ArrayList<?> arreglo_ejecucion) {
    
        ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
    
        Connection c=null;
        try {
            
          
           String sql;
            
                int size2 = arreglo_ejecucion.size();   
                                            
                obj_un_campo_string registro_eje = null;
                
                 int x;    
               
    
             for (x=0; x<size2; x++) 
                {
                    
                     registro_eje = (obj_un_campo_string) arreglo_ejecucion.get(x);
                     
                                                                         
                                            c = conexion_odbc.Connexion_datos();
                                            sql = "{call frm_adm_evaluciones_ejecucion_academica_genera_notas_ejecucion_academica  (?)}" ;
                                            CallableStatement ps1 = c.prepareCall(sql);
                                           
                                            ps1.setString(1,registro_eje.getcampo_uno());
                                                                                        
                                            ps1.execute();
                        
                        
                                      
                       }
            
                        
           } catch (Exception e) {
            e.printStackTrace();
            lista.add(new obj_un_campo_string("ERROR"));
           
        } finally {
                     
             lista.add(new obj_un_campo_string("OK"));           
            try {
                    c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            
            
            }
        }
        return lista;
    }   
  
 //**************************************************************** 
    
}
