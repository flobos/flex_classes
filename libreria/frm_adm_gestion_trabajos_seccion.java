/*
 * frm_adm_gestion_trabajos_seccion.java
 *
 * Created on 30 de agosto de 2007, 16:44
 */

package libreria;


import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author  Administrador
 */
public class frm_adm_gestion_trabajos_seccion {
       
    public frm_adm_gestion_trabajos_seccion() {
    }
    
    public static ArrayList<obj_dos_campos> muestra_ejecuciones(int funcion_modalidad) {
    ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_gestion_trabajo_seccion_muestra_ejecuciones (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setInt(1, funcion_modalidad);
            ResultSet rs = ps.executeQuery();
            
            lista.add(new obj_dos_campos("0","-- Seleccione --"));
            
            while (rs.next())
            {
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
    
    
    public static ArrayList<obj_dos_campos> muestra_tipo_producto(String ejecucion) {
    ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_gestion_trabajo_seccion_muestra_tipo_producto (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, ejecucion.trim());
            ResultSet rs = ps.executeQuery();
            
            lista.add(new obj_dos_campos("0","-- Seleccione --"));
            
            while (rs.next())
            {
                lista.add(new obj_dos_campos(rs.getString("tip_prod_idn")
                                             , rs.getString("tip_prod_nombre")));
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
    
    
    public static ArrayList<obj_dos_campos> muestra_jornada(String ejecucion, String tipo_producto) {
    ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_gestion_trabajo_seccion_muestra_jornada (?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, ejecucion.trim());
            ps.setString(2, tipo_producto.trim());
            ResultSet rs = ps.executeQuery();
            
            lista.add(new obj_dos_campos("0","-- Seleccione --"));
            
            while (rs.next())
            {
                lista.add(new obj_dos_campos(rs.getString("tip_jor_idn")
                                             , rs.getString("tip_jor_nombre")));
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
    
    
      public static ArrayList<obj_dos_campos> muestra_secciones(String ejecucion, String tipo_producto, int jornada) {
    ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_gestion_trabajo_seccion_muestra_secciones (?,?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, ejecucion.trim());
            ps.setString(2, tipo_producto.trim());
            ps.setInt(3, jornada);
            ResultSet rs = ps.executeQuery();
            
            lista.add(new obj_dos_campos("0","-- Seleccione --"));
            
            while (rs.next())
            {
                lista.add(new obj_dos_campos(rs.getString("eje_aca_idn")
                                             , rs.getString("seccion")));
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
      
      
    public static ArrayList<obj_dos_campos> muestra_evaluaciones(String ejecucion_academica) {
    ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_gestion_trabajo_seccion_muestra_evaluaciones (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, ejecucion_academica.trim());
            ResultSet rs = ps.executeQuery();
            
            lista.add(new obj_dos_campos("0","-- Seleccione --"));
            
            while (rs.next())
            {
                lista.add(new obj_dos_campos(rs.getString("eva_eje_idn")
                                             , rs.getString("tip_pru_nombre")));
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
    
      public static ArrayList<obj_nueve_campos> muestra_evaluaciones_alumnos(String evaluacion_ejecucion) {
    ArrayList<obj_nueve_campos> lista = new ArrayList<obj_nueve_campos>();
        Connection c=null;
         
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_gestion_trabajo_seccion_muestra_evaluaciones_alumnos (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, evaluacion_ejecucion.trim());
            ResultSet rs = ps.executeQuery();
            
            while (rs.next())
            {
                lista.add(new obj_nueve_campos(rs.getString("not_idn")
                                             , rs.getString("mat_idn"),
                                             rs.getString("alu_rut"),
                                             rs.getString("nombre"),
                                             rs.getString("mal_nombre"),
                                             rs.getString("not_nota"),
                                             rs.getString("trab_idn"),
                                             rs.getString("est_pru_idn"),
                                             rs.getString("est_pru_nombre")));
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
    
    
//******************Generar trabajos *****************************************************************************************           
//------------------------------------------------------------------
    
         //******************************************************************************
 public static ArrayList<?> genera_trabajos( ArrayList<?> arreglo_seleccionados, String codigo_lote_trabajo ) {
    
        ArrayList<?> lista = new ArrayList<Object>();
        Connection c=null;
        try {
            c = conexion_odbc.Connexion_datos();
             String sql1;
              int size = arreglo_seleccionados.size();
              obj_dos_campos registro = null;
                
            int j;
            for (j=0; j<size; j++) 
               {
                    
                        registro = (obj_dos_campos) arreglo_seleccionados.get(j);
                        sql1 = "{call flex_adm_gestion_trabajo_seccion_genera_trabajos (?,?,?)}" ;
                        CallableStatement ps1 = c.prepareCall(sql1);
                        ps1.setString(1,registro.getdata());
                        ps1.setString(2,registro.getlabel());
                       ps1.setString(3,codigo_lote_trabajo.trim());
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
     
 //-------------------------------------------------------------------------------------------------------------
 
 
 public static ArrayList<?> elimina_trabajos( ArrayList<?> arreglo_seleccionados_eliminar ) {
    
        ArrayList<?> lista = new ArrayList<Object>();
        Connection c=null;
        try {
            c = conexion_odbc.Connexion_datos();
             String sql1;
              int size = arreglo_seleccionados_eliminar.size();
              obj_dos_campos registro2 = null;
                
            int j;
            for (j=0; j<size; j++) 
               {
                    
                        registro2 = (obj_dos_campos) arreglo_seleccionados_eliminar.get(j);
                        sql1 = "{call flex_adm_gestion_trabajo_seccion_elimina_trabajos (?,?)}" ;
                        CallableStatement ps1 = c.prepareCall(sql1);
                        ps1.setString(1,registro2.getdata());
                        ps1.setString(2,registro2.getlabel());
                       
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
 
 
        
//---------------------------------- comprueba si existe participantes para crear lote de trabajo ---------------------------------------------------------------------------  
 
  
    
      //*********************************************************************************************************** 
 /*  public static ArrayList busca_participantes(int mensaje,ArrayList arregloo) 
     {
        
        ArrayList lista = new ArrayList();
        int salida = 1;
         String msg;
        Connection c=null;
        String sql;
      
        try {

                int size= arregloo.size();
                int i;
                for (i=0; i<size; i++) 
                {
                        c = conexion_odbc.Connexion_datos();
                        sql = "{call flex_adm_gestion_trabajo_seccion_busca_participantes (?)}" ;
                        CallableStatement ps = c.prepareCall(sql);
                        //ps.setInt(1,mensaje);
                        ps.setString(1,arregloo.get(i).toString().trim());
                        ps.execute();
                }
           } 
         catch (Exception e) 
            {
                e.printStackTrace();
                salida = 0;
                msg = e.getMessage();
                lista.add(new obj_un_campo_string(msg));
                
            }
         finally
            {
                try 
                    {
                        c.close();
                    }
                catch (SQLException e) 
                    {
                        e.printStackTrace();
                    }
            }
        
        if (salida == 1){
            lista.add(new obj_un_campo_string("Ok"));
        }
         return lista;
    }   
//*********************************************************************************************************** 
       
       
   */    
       
       
//******************************************************************************
  
    //******************************************************************************
  public static ArrayList<obj_un_campo_string> busca_participantes(ArrayList<?> arreglo_p) {
      ArrayList<obj_un_campo_string> lista_p = new ArrayList<obj_un_campo_string>();
        Connection c=null;
         try {
            
            String sql;
                      
            int size = arreglo_p.size();   
             
                
                obj_un_campo_string registro_reg = null;
                
                 int x;    
              
    
             for (x=0; x<size; x++) 
                {
                    
                     registro_reg = (obj_un_campo_string) arreglo_p.get(x);
      
                              c = conexion_odbc.Connexion_datos();
            
                  sql = "{call flex_adm_gestion_trabajo_seccion_busca_participantes (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
             
           ps.setString(1,registro_reg.getcampo_uno());
            ps.execute();
            
             

                         ResultSet rs = ps.executeQuery();

                          while (rs.next()){

                        lista_p.add(new obj_un_campo_string (rs.getString("not_idn")
                                                          
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
         return lista_p;
   }


//******************************************************************************
  
   //--------------------------crea lote de trabajo----------------------------------------------------------------------
    
     public static ArrayList<obj_un_campo_string> crea_lote_trabajo( ) {//(String fun_rut ) {
      ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_gestion_trabajo_seccion_crea_lote ()}" ;
            CallableStatement ps = c.prepareCall(sql);
          //   ps.setString(1, fun_rut.trim());
                      
            ResultSet rs = ps.executeQuery();
               
            
            while (rs.next()){
            
      
            lista.add(new obj_un_campo_string (rs.getString("lot_trab_idn")));
           
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
     
      public static ArrayList<obj_un_campo_string> busca_lote_trabajo(ArrayList<?> arreglo_not_idn) {
      ArrayList<obj_un_campo_string> lista_p = new ArrayList<obj_un_campo_string>();
        Connection c=null;
         try {
            
            String sql;
                      
            int size = arreglo_not_idn.size();   
             
                
                obj_un_campo_string registro_not = null;
                
                 int x;    
              
    
             for (x=0; x<size; x++) 
                {
                    
                     registro_not = (obj_un_campo_string) arreglo_not_idn.get(x);
      
                              c = conexion_odbc.Connexion_datos();
            
                  sql = "{call flex_adm_gestion_trabajo_seccion_busca_lote_trabajo (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
             
           ps.setString(1,registro_not.getcampo_uno());
            ps.execute();
            
             

                         ResultSet rs = ps.executeQuery();

                          while (rs.next()){

                        lista_p.add(new obj_un_campo_string (rs.getString("lot_trab_idn")
                                                          
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
         return lista_p;
   }


//******************************************************************************
     
     
     
     
        public static ArrayList<obj_nueve_campos> muestra_evaluaciones_alumnos_en_evaluacion(String evaluacion_ejecucion) {
    ArrayList<obj_nueve_campos> lista = new ArrayList<obj_nueve_campos>();
        Connection c=null;
         
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_gestion_trabajo_seccion_muestra_evaluaciones_alumnos_en_evaluacion (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, evaluacion_ejecucion.trim());
            ResultSet rs = ps.executeQuery();
            
            while (rs.next())
            {
                lista.add(new obj_nueve_campos(rs.getString("not_idn")
                                             , rs.getString("mat_idn"),
                                             rs.getString("alu_rut"),
                                             rs.getString("nombre"),
                                             rs.getString("mal_nombre"),
                                             rs.getString("not_nota"),
                                             rs.getString("trab_idn"),
                                             rs.getString("est_pru_idn"),
                                             rs.getString("est_pru_nombre")));
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
      
       //------------------------------------------------------------------------------------------------------------------------
//
//      public static ArrayList ingresa_nota(String not_idn, String not_nota) {
//            ArrayList lista = new ArrayList();
//            Connection c=null;
//
//            try {
//                String sql;
//                c = conexion_odbc.Connexion_datos();
//                sql = "{call flex_adm_gestion_trabajo_seccion_ingresa_nota (?,?)}" ;
//                CallableStatement ps = c.prepareCall(sql);
//                ps.setString(1, not_idn.trim());
//                ps.setString(2, not_nota.trim());
//                    ps.execute();
//                //ResultSet rs = ps.executeQuery();
//
//                // lista.add(new obj_dos_campos("0"," - Seleccione - "));   
//               // while (rs.next())
//                //{
//
//                //}
//            } catch (Exception e) {
//                e.printStackTrace();
//            } finally {
//                try {
//                    c.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//             return lista;
//        }
  //---------------------------------------------------------------------------------------------------------------------------
   //******************************************************************************
 public static ArrayList<?> ingresa_nota( ArrayList<?> arreglo_seleccionados, String not_nota ) {
    
        ArrayList<?> lista = new ArrayList<Object>();
        Connection c=null;
        try {
            c = conexion_odbc.Connexion_datos();
             String sql1;
              int size = arreglo_seleccionados.size();
              obj_un_campo_string registro = null;
                
            int j;
            for (j=0; j<size; j++) 
               {
                    
                        registro = (obj_un_campo_string) arreglo_seleccionados.get(j);
                        sql1 = "{call flex_adm_gestion_trabajo_seccion_ingresa_nota (?,?)}" ;
                        CallableStatement ps1 = c.prepareCall(sql1);
                        ps1.setString(1,registro.getcampo_uno());
                       
                       ps1.setString(2,not_nota.trim());
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
     
 //-------------------------------------------------------------------------------------------------------------
  public static ArrayList<obj_dos_campos> muestra_secciones_con_clases(int funcion_modalidad) {
    ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_gestion_trabajo_seccion_muestra_secciones_con_clases_profesor (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setInt(1, funcion_modalidad);
          //  ps.setString(2, fecha_clase.trim());
            ResultSet rs = ps.executeQuery();
            
            lista.add(new obj_dos_campos("0","-- Seleccione --"));
            
            while (rs.next())
            {
                lista.add(new obj_dos_campos(rs.getString("eje_aca_idn")
                                             , rs.getString("seccion")));
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
   //----------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------
 
 
 
}
