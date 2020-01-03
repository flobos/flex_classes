/*
 * frm_adm_tutor_revisa_pruebas.java
 *
 * Created on 5 de enero de 2006, 02:53 PM
 */

package libreria;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author  Esteban
 */
public class frm_adm_tutor_revisa_pruebas {
    
     public static ArrayList<obj_dos_campos> muestra_porcentaje_y_puntaje(String ejecucion_aca, String tipo_prueba) {
      ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_pruebas_revisa_obtiene_puntaje_y_porcentaje (?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,ejecucion_aca.trim());
            ps.setString(2,tipo_prueba.trim());
                      
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos (rs.getString("puntaje"), 
                                             rs.getString("porcentaje")));
           
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
    
    
    
 public void inserta_correcion_de_prueba(String trab_idn, ArrayList<?> correccion ) 
     {
    //      ArrayList correccion = new ArrayList();
        
      
         //= new ArrayList();
        int salida = 1;
         Connection c=null;
        String sql;
      
        try {   
            
            
       //    prueba.add(new obj_cuatro_campos("23","23","23","23"));
          
               int size = correccion.size();
                obj_cuatro_campos registro = null;
                
                int i;
                for (i=0; i<size; i++) 
                {
                    
                    registro = (obj_cuatro_campos) correccion.get(i);
                        c = conexion_odbc.Connexion_datos();
                        sql = "{call flex_pruebas_inserta_correccion (?,?,?,?,?)}" ;
                        CallableStatement ps = c.prepareCall(sql);
                        ps.setString(1,trab_idn);
                        ps.setString(2,registro.getcampo_uno());
                        ps.setString(3,registro.getcampo_dos());
                        ps.setString(4,registro.getcampo_tres());
                        ps.setString(5,registro.getcampo_cuatro());
                        ps.execute();
                }
           } 
         catch (Exception e) 
            {
                e.printStackTrace();
                salida = 0;
                e.getMessage();
             
                
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
            
        }
         
    }     
    
    
    
    
    
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
      
            public static ArrayList<obj_ocho_campos> ro_carga_pruebas_tutor(String tip_pru_idn, String eje_aca) {
    
        ArrayList<obj_ocho_campos> lista = new ArrayList<obj_ocho_campos>();
        Connection c=null;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_baja_pruebas_tutor '" + tip_pru_idn.trim() + "','" + eje_aca.trim() + "'";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
           // lista.add(new obj_dos_campos("0","Seleccione"));
            while (rs.next()){
            
      
            lista.add(new obj_ocho_campos(rs.getString("campo_uno")
                                        , rs.getString("campo_dos")
                                        , rs.getString("campo_tres")
                                        , rs.getString("campo_cuatro")
                                        , rs.getString("campo_cinco")
                                        , rs.getString("campo_seis")
                                        , rs.getString("campo_siete")
                                        , rs.getString("campo_ocho")));
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
      /*  public static ArrayList ro_guarda_nota(String trabajo, String nota, String observacion) {
    
        ArrayList lista = new ArrayList();
        Connection c=null;
         int salida = 1;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_tutor_coloca_nota_pruebas_web '"+ trabajo + "','"+ nota + "','"+ observacion + "' ";
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
        }       */


        public static ArrayList<obj_un_campo_string> ro_guarda_nota(String trabajo, String nota, String observacion) {
    
        ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
        Connection c=null;
         int salida = 1;
        try {
            
              String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_tutor_coloca_nota_pruebas_web (?,?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, trabajo.trim());
            ps.setString(2, nota.trim());
            ps.setString(3, observacion.trim());
            ResultSet rs = ps.executeQuery();   
                   
            
            
            
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


  public static ArrayList<obj_tres_campos> ro_obtiene_preguntas_pruebas(String not_idn) {
    
        ArrayList<obj_tres_campos> lista = new ArrayList<obj_tres_campos>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_selecciona_preguntas_a_evaluar_tutor '" + not_idn + "'";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            
            while (rs.next()){
         
            lista.add(new obj_tres_campos(rs.getString("campo_uno")
                                        , rs.getString("campo_dos")
                                        , rs.getString("campo_tres")));
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
  
    public static ArrayList<obj_cinco_campos> ro_obtiene_preguntas_pruebas_ya_evaluadas(String trab_idn) {
    
        ArrayList<obj_cinco_campos> lista = new ArrayList<obj_cinco_campos>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_selecciona_prueba_evaluada_tutor '" + trab_idn + "'";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            
            while (rs.next()){
         
            lista.add(new obj_cinco_campos(rs.getString("campo_uno")
                                        , rs.getString("campo_dos")
                                        , rs.getString("campo_tres")
                                        , rs.getString("campo_cuatro")
                                        , rs.getString("campo_cinco")));
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
    
 
//////////////////////////////////////////////////   
  
         public static ArrayList<obj_dos_campos> ro_ingresa_nota(String nota
                                               , String trabajo)
                                                            
     {
        
        ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        int salida = 1;
         String msg;
        Connection c=null;
        String sql;
      
        try {
                c = conexion_odbc.Connexion_datos();
                sql = "flex_inserta_nota_correccion '"+ nota + "','"+ trabajo + "' ";
                        CallableStatement ps = c.prepareCall(sql);
                       
                        ps.execute();
           } 
         catch (Exception e) 
            {
                e.printStackTrace();
                salida = 0;
                msg = e.getMessage();
                lista.add(new obj_dos_campos("0",msg));
                
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
            lista.add(new obj_dos_campos("1","Ok"));
        }
         return lista;
    }
  //////////////////////////////////////////////////////////////////////////
       public static ArrayList<obj_dos_campos> ro_llena_grilla_participantes(String trab_idn) {
    
        ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_envio_prueba_muestra_parti_trabajo '"+ trab_idn + "'";
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
        return lista;
       } 
       
   //////////////////////////////////////////////////    
  public static ArrayList<obj_tres_campos> ro_llena_grilla_participantes_update_nota(String trab_idn) {
    
        ArrayList<obj_tres_campos> lista = new ArrayList<obj_tres_campos>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_envio_prueba_muestra_parti_trabajo_update_nota '"+ trab_idn + "'";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            
            while (rs.next()){
         
            lista.add(new obj_tres_campos(rs.getString("campo_uno")
                                        , rs.getString("campo_dos")
                                        , rs.getString("campo_tres")));
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
  
//////////////////////////////////////////////////
   public static ArrayList<obj_un_campo_string> genera_lotes_trabajo_web(String trabajo) {
    
        ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
        Connection c=null;
         int salida = 1;
        try {
            
              String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call genera_lote_trabajos_web (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, trabajo.trim());
            ResultSet rs = ps.executeQuery();   
                   
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
//////////////////////////////////////////////////
 /*  public static ArrayList actualiza_lotes_trabajo_web(String lote_trabajo_web) {
    
        ArrayList lista = new ArrayList();
        Connection c=null;
         int salida = 1;
        try {
            
              String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call actualiza_lote_trabajos_web (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, lote_trabajo_web.trim());
            ResultSet rs = ps.executeQuery();   
                   
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
  //------------------------------------------------------*/
   
  //////////////////////////////////////////////////////////////////////////

     public static ArrayList<?> elimina_correccion_prueba(String valor) {
      ArrayList<?> lista = new ArrayList<Object>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_borra_correccion_modfica_nota_inserta_nota_historial (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,valor.trim());
                      
            ResultSet rs = ps.executeQuery();
            
           
            
            while (rs.next()){
            
      
          // lista.add(new obj_un_campo (rs.getString("trab_idn"); 
                                            
           
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
   
   
   
//////////////////////////////////////////////////
    /** Creates a new instance of frm_adm_tutor_revisa_pruebas */
    public frm_adm_tutor_revisa_pruebas() {
    }
    
}







