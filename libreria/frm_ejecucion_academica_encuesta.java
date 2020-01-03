/*
 * frm_adm_chat_ingreso.java
 *
 * Created on 08 de Enero de 2007
 */

package libreria;
import java.util.ArrayList;
import java.io.Serializable;
import java.sql.*;
/**
 *
 * @author  marcelo
 */
public class frm_ejecucion_academica_encuesta {
 ///*******************************************************************************************************************
     //***********************************************************************************************************         
  
  public static ArrayList<obj_dos_campos> ejecucion_academica_encuesta_muestra_ejecuciones() {
      ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
        
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            
            sql = "{call flex_ejecucion_academica_encuesta_muestra_ejecuciones ()}" ;
            CallableStatement ps = c.prepareCall(sql);
           
                                
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
    
    
    
 //********************************************************************************************************
  
  
  
  
  
   public static ArrayList<Serializable> ejecucion_academica_encuesta_muestra_encuestas() {
      ArrayList<Serializable> lista = new ArrayList<Serializable>();
        Connection c=null;
        
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            
            sql = "{call flex_ejecucion_academica_encuesta_muestra_encuestas ()}" ;
            CallableStatement ps = c.prepareCall(sql);
           
                                
            ResultSet rs = ps.executeQuery();
            
             lista.add(new obj_dos_campos("0"," - Seleccione - "));   
            
            while (rs.next()){
            
      
            lista.add(new obj_combo_tres_campos (rs.getString("enc_idn"), 
                                                 rs.getString("enc_fecha_ingreso"),
                                                 rs.getString("enc_nombre")));
           
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
  //---------------------------------------------------------------------------------------

//--------------------------------------------------------------------------------------
 /////***************************************************************************
    
      public static ArrayList<obj_cuatro_campos> ejecucion_academica_encuesta_muestra_ejecuciones_academicas(String enc_idn, String eje_idn) {
      ArrayList<obj_cuatro_campos> lista = new ArrayList<obj_cuatro_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_ejecucion_academica_encuesta_muestra_ejecuciones_academicas (?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,enc_idn.trim());
             ps.setString(2,eje_idn.trim());          
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
             
      
             lista.add(new obj_cuatro_campos (rs.getString("eje_aca_idn"), 
                                                 rs.getString("cur_nombre"),
                                                  rs.getString("sec_nombre"),
                                                 rs.getString("tip_jor_nombre")));
           
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

       ////***************************************************************************************************      
  ////////////////////////////////////////////////
       public void ejecucion_academica_encuesta_graba(ArrayList<?> arreglo_seleccionadas ) 
     {
        int salida = 1;
         Connection c=null;
        String sql;
      
        try {   
            
               int size = arreglo_seleccionadas.size();
                obj_dos_campos registro = null;
                
                int i;
                for (i=0; i<size; i++) 
                {
                    
                    registro = (obj_dos_campos) arreglo_seleccionadas.get(i);
                        c = conexion_odbc.Connexion_datos();
                        sql = "{call flex_ejecucion_academica_encuesta_graba (?,?)}" ;
                        CallableStatement ps = c.prepareCall(sql);
                        ps.setString(1,registro.getdata());
                        ps.setString(2,registro.getlabel());
                        
                       // ps.setString(4,registro.getcampo_cuatro());
                       // ps.setString(5,registro.getcampo_cinco());
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
       
       
       
/////////////////////////////////////////////////
 ////////////////////////////////////////////////
  /*    public void ejecucion_academica_encuesta_busca(ArrayList arreglo_seleccionadas ) 
     {
        int salida = 1;
         String msg;
        Connection c=null;
        String sql;
      
        try {   
            
               int size = arreglo_seleccionadas.size();
                obj_dos_campos registro = null;
                
                int i;
                for (i=0; i<size; i++) 
                {
                    
                    registro = (obj_dos_campos) arreglo_seleccionadas.get(i);
                        c = conexion_odbc.Connexion_datos();
                        sql = "{call flex_ejecucion_academica_encuesta_busca (?,?)}" ;
                        CallableStatement ps = c.prepareCall(sql);
                        ps.setString(1,registro.getdata());
                        ps.setString(2,registro.getlabel());
                        
                       // ps.setString(4,registro.getcampo_cuatro());
                       // ps.setString(5,registro.getcampo_cinco());
                        ps.execute();
                }
           } 
         catch (Exception e) 
            {
                e.printStackTrace();
                salida = 0;
                msg = e.getMessage();
             
                
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
       
       
    */   
/////////////////////////////////////////////////
       
        public static ArrayList<obj_cinco_campos> ejecucion_academica_encuesta_llena_grilla(String enc_idn, String eje_idn) {
      ArrayList<obj_cinco_campos> lista = new ArrayList<obj_cinco_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_ejecucion_academica_encuesta_llena_grilla (?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,enc_idn.trim());
            ps.setString(2,eje_idn.trim());
             
             
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
      
            lista.add(new obj_cinco_campos (rs.getString("eje_aca_enc_idn"),
                                            rs.getString("eje_aca_idn"),
                                             rs.getString("cur_nombre"),
                                             rs.getString("sec_nombre"),
                                             rs.getString("tip_jor_nombre")));
           
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
    
    
////***************************************************************************************************     

      public static ArrayList<obj_un_campo_string> ejecucion_academica_encuesta_borra(String eje_aca_enc_idn ) {
    ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
        Connection c=null;
         String msg ;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_ejecucion_academica_encuesta_borra (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, eje_aca_enc_idn.trim());
           
            
           
            
            
            ResultSet rs = ps.executeQuery();
        
            while (rs.next()){
            
      
            lista.add(new obj_un_campo_string(rs.getString("identidad")));
           
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            lista.remove(0);
            msg = e.getMessage();
            lista.add(new obj_un_campo_string(msg));
            
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
 
     public frm_ejecucion_academica_encuesta() {
    }
    
}
