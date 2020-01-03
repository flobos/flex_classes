/*
 * frm_adm_asistencia_ingreso_clase.java
 *
 * Created on 24 de marzo de 2008, 15:53
 */

package libreria;
import java.util.ArrayList;
import java.io.Serializable;
import java.sql.*;

/**
 *
 * @author  Administrador
 */
public class frm_adm_asistencia_ingreso_clase {
    
    /** Creates a new instance of frm_adm_asistencia_ingreso_clase */
    public frm_adm_asistencia_ingreso_clase() {
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
     
     
     
       public static ArrayList<obj_dos_campos> muestra_secciones(String ejecucion, String tipo_producto ) {
        ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_clase_asistencia_muestra_secciones (?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, ejecucion.trim());
            ps.setString(2, tipo_producto.trim());
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
       
       
     public static ArrayList<obj_dos_campos> muestra_hora_pedagogica() {
        ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_clase_asistencia_muestra_hora_pedagogica ()}" ;
            CallableStatement ps = c.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            
            lista.add(new obj_dos_campos("0","-- Seleccione --"));
            
            while (rs.next())
            {
                lista.add(new obj_dos_campos(rs.getString("tip_hor_idn")
                                             , rs.getString("tip_hor_nombre")));
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
     
    //------------------------------------------------------------------------------------------------------------------------------- 
     public static ArrayList<Serializable> inserta_clase(String eje_academica, int func_funcionario, int hora_pedagogica, String fecha_clase) {
    ArrayList<Serializable> lista = new ArrayList<Serializable>();
    
        Connection c=null;
           String msg;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_clase_asistencia_inserta_clase (?,?,?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,eje_academica.trim());
            ps.setInt(2,func_funcionario);
            ps.setInt(3,hora_pedagogica);
            ps.setString(4,fecha_clase);
            ResultSet rs = ps.executeQuery();
        
            while (rs.next()){
            
             
           // lista.add(new obj_dos_campos("1", "OK"));
           lista.add(new obj_un_campo_string(rs.getString("identidad")));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
             msg = e.getMessage();
            lista.remove(0);
            lista.add(new obj_dos_campos("0",msg));
                                 
        } finally {
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        
         return lista;
         
   }  
     
   //------------------------------------------------------------------------------------  
     
     public static ArrayList<obj_cuatro_campos> muestra_clases(String eje_academica) {
        ArrayList<obj_cuatro_campos> lista = new ArrayList<obj_cuatro_campos>();
        Connection c=null;
         
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_clase_asistencia_muestra_clases (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,eje_academica.trim());
            ResultSet rs = ps.executeQuery();
            
            while (rs.next())
            {
                lista.add(new obj_cuatro_campos(rs.getString("cla_idn")
                                             , rs.getString("cla_fecha_clase")
                                             , rs.getString("cla_fecha_ingreso")
                                             , rs.getString("tip_hor_nombre")));
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
      
     
     //------------------------------------------------------------------------------------------------------------------------
    /*
    public static ArrayList elimina_clases(String cla_idn) {
    ArrayList lista = new ArrayList();
    
    Connection c=null;
    int salida = 1;
    String msg;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_clase_asistencia_elimina_clases (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,cla_idn);
            ps.execute();
             ResultSet rs = ps.executeQuery();
            
            while (rs.next())
            {
                lista.add(new obj_un_campo_string(rs.getString("salida_2")));
                                                
            }           
             } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }*/
       /* } catch (Exception e) {
            e.printStackTrace();
            salida = 0;
            msg = e.getMessage();
        } finally {
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (salida == 1){
        lista.add(new obj_un_campo(1));
        }else{
        lista.add(new obj_un_campo(0));
        }*/
        /*
         return lista;
   }  
    */
     //-------------------------------------------------------------------------
     
public static ArrayList<obj_un_campo_string> elimina_clases(String cla_idn) {
    ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
        Connection c=null;
         
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_clase_asistencia_elimina_clases (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
           ps.setString(1,cla_idn);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next())
            {
                lista.add(new obj_un_campo_string(rs.getString("salida")));
                                                
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
     
     //--------------------------------------------------------------------------
    //----------------------------------------------------------------------------------------------------------------------
      public static ArrayList<obj_dos_campos> muestra_dias() {
      ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
        
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            
            sql = "{call flex_asignacion_hora_bloques_dias_muestra_dias ()}" ;
            CallableStatement ps = c.prepareCall(sql);
                                                       
            ResultSet rs = ps.executeQuery();
            
             lista.add(new obj_dos_campos("0"," - Seleccione - "));   
            
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos (rs.getString("dia_idn"), 
                                           rs.getString("dia_nombre")));
           
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
         //*/*********************************************************************************************************************
      
 
      
      
      //---------------------------------------------------------------------------------------------------------------------------
 
  //****************************************************************************************
   public static ArrayList<obj_seis_campos> muestra_bloques_segun_dia( String dia_idn) {
        ArrayList<obj_seis_campos> lista = new ArrayList<obj_seis_campos>();
        Connection c=null;
         
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_clase_asistencia_muestra_bloques_segun_dia (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,dia_idn.trim());
            ResultSet rs = ps.executeQuery();
            
            while (rs.next())
            {
                lista.add(new obj_seis_campos(rs.getString("hor_blo_idn")
                                             , rs.getString("hor_idn")
                                             , rs.getString("bloq_idn")
                                             , rs.getString("bloq_numero")
                                             , rs.getString("hor_desde")
                                             , rs.getString("hor_hasta")));
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
  ///---------------------------------------------------------------------------------------------------------------------------
  
  
  
      //******************************************************************************
 
//******************************************************************************
           //********************************************************************
  //******************************************************************************
/*  public static ArrayList inserta_clase_bloque(String eje_idn, ArrayList pro_mal_idn) {
      ArrayList lista_p = new ArrayList();
        Connection c=null;
         int salida;
        try {
            
            String sql;
                      
            int size = pro_mal_idn.size();   
             
                
                obj_un_campo_string registro = null;
                
                 int x;    
              
    
             for (x=0; x<size; x++) 
                {
                    
                     registro = (obj_un_campo_string) pro_mal_idn.get(x);
      
                              c = conexion_odbc.Connexion_datos();
            
                  sql = "{call flex_adm_clase_asistencia_inserta_clase_bloque  (?,?)}"  ;
            CallableStatement ps = c.prepareCall(sql);
            
             ps.setString(1,eje_idn.trim());
             ps.setString(2,registro.getcampo_uno().toString());
            
             
             ps.execute();
            
            
        
             

                         ResultSet rs = ps.executeQuery();

                          while (rs.next()){

                        lista_p.add(new obj_un_campo_string (rs.getString("salida")
                                                          
                                                                      ));


                        }
 
     
             
             }
  
        }
        
  catch (Exception e) {
            e.printStackTrace();
        } finally {
            lista_p.add(new obj_un_campo_string("OK"));   
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
         return lista_p;
   }

*/
//******************************************************************************
          public static ArrayList<?> inserta_clase_bloque(  String cla_idn,  ArrayList<?> arreglo_seleccionados) {
    
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
                        sql1 = "{call flex_adm_clase_asistencia_inserta_clase_bloque (?,?)}" ;
                        CallableStatement ps1 = c.prepareCall(sql1);
                         ps1.setString(1,cla_idn.trim());
                         ps1.setString(2,registro.getcampo_uno());
                         ps1.execute();
                         
                         ///
                    /*      ResultSet rs = ps1.executeQuery();

                          while (rs.next()){

                        lista.add(new obj_un_campo_string (rs.getString("salida")
                                                          
                                                                      ));


                        }
                    */
                         ///
                         
                         
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
 
   
   
   
   //-------------------------------------------------------------------------
     
public static ArrayList<obj_un_campo_string> inserta_alumnos_segun_clase(String cla_idn) {
    ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
        Connection c=null;
         
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_clase_asistencia_inserta_alumnos_segun_clase (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
           ps.setString(1,cla_idn);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next())
            {
                lista.add(new obj_un_campo_string(rs.getString("salida")));
                                                
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
     
     //--------------------------------------------------------------------------








 //------------------------------------------------------------------------------------  
     
     public static ArrayList<Serializable> busca_funcionario_por_rut(String fun_rut) {
        ArrayList<Serializable> lista = new ArrayList<Serializable>();
        Connection c=null;
         
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_clase_asistencia_busca_funcionario (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,fun_rut.trim());
            ResultSet rs = ps.executeQuery();
            
             lista.add(new obj_dos_campos("0"," - Seleccione - "));   
            while (rs.next())
            {
                lista.add(new obj_combo_tres_campos(rs.getString("func_mod_fun_idn")
                                             , rs.getString("nombre_completo")
                                             , rs.getString("funcion_modalidad")));
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
      
     
     //------------------------------------------------------------------------------------------------------------------------

     
      
     public static ArrayList<Serializable> muestra_funcion_modalidad(String func_mod_fun_idn) {
        ArrayList<Serializable> lista = new ArrayList<Serializable>();
        Connection c=null;
         
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_clase_asistencia_muestra_funcion_modalidad (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,func_mod_fun_idn.trim());
            ResultSet rs = ps.executeQuery();
            
             lista.add(new obj_dos_campos("0"," - Seleccione - "));   
            while (rs.next())
            {
                lista.add(new obj_combo_tres_campos(rs.getString("func_mod_fun_idn")
                                             , rs.getString("nombre_completo")
                                             , rs.getString("funcion_modalidad")));
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
     
     
     
     
     
  //******************************************************************** 
//******************************************************************************
         
  
  
 ///---------------------------------------------------------------------------------------------------------------------------
    
}
