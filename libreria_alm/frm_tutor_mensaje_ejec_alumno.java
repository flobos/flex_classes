/*
 * frm_tutor_mensaje_ejec_alumno.java
 *
 * Created on 23 de noviembre de 2005, 9:03
 */

package libreria_alm;

/**
 *
 * @author  Administrador
 */
import java.util.ArrayList;
import java.sql.*;



public class frm_tutor_mensaje_ejec_alumno {
    
    
   ///**********************Tutor_mensajes_por_ejecución_académica**********************************************/////
    
     public static ArrayList<obj_seis_campos> tutor_mensaje_muestra(String ejecucion_aca) {
      ArrayList<obj_seis_campos> lista = new ArrayList<obj_seis_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_tutor_mensaje_muestra (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,ejecucion_aca.trim());
                      
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
      
            lista.add(new obj_seis_campos (rs.getString("men_eje_alu_idn"), 
                                             rs.getString("men_eje_alu_titulo"), 
                                             rs.getString("men_eje_alu_glosa"), 
                                             rs.getString("men_eje_alu_fecha_ingreso"),
                                             rs.getString("men_eje_alu_activa"),
                                             rs.getString("men_eje_alu_bloqueado")));
           
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
     
     
     
    
     
    
     public static ArrayList<obj_un_campo_string> tutor_mensaje_ingresa(String ejecucion_aca, String modo , String titulo, String glosa, String activo, String fecha, String imagen) {
    ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
        Connection c=null;
         String msg ;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_tutor_mensaje_ingresa (?,?,?,?,?,?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, ejecucion_aca.trim());
            ps.setString(2, modo.trim());
            ps.setString(3, titulo.trim());
            ps.setString(4, glosa.trim());
            ps.setString(5, activo);
            ps.setString(6, fecha.trim());
            ps.setString(7, imagen.trim());
           
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
    
    public static ArrayList<obj_un_campo> tutor_mensaje_borra(int men_eje_alu_idn) {
    ArrayList<obj_un_campo> lista = new ArrayList<obj_un_campo>();
    Connection c=null;
    int salida = 1;
    try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_tutor_mensaje_borra (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setInt(1,men_eje_alu_idn);
            ps.execute();
           
        } catch (Exception e) {
            e.printStackTrace();
            salida = 0;
            e.getMessage();
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
        }
        
         return lista;
   }  
    public static ArrayList<obj_un_campo_string> tutor_mensaje_existe(int chat_idn) {
        ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_tutor_mensaje_existe (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setInt(1, chat_idn);
            
            ResultSet rs = ps.executeQuery();
            
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
    
 
  // ********************************************************************
    
     public static ArrayList<obj_un_campo> tutor_mensaje_modifica(String ejecucion_aca, String modo , String titulo, String glosa, String activo, String fecha)
   {
    ArrayList<obj_un_campo> lista = new ArrayList<obj_un_campo>();
        Connection c=null;
         int salida = 1;
        try {
  
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_tutor_mensaje_modifica (?,?,?,?,?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
             ps.setString(1, ejecucion_aca.trim());
            ps.setString(2, modo.trim());
            ps.setString(3, titulo.trim());
            ps.setString(4, glosa.trim());
            ps.setString(5, activo);
            ps.setString(6, fecha.trim());
            ps.execute();
                       
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
        
        if (salida == 1){
        lista.add(new obj_un_campo(1));
        }else{
        lista.add(new obj_un_campo(0));
        }
        
         return lista;
   }
    
     public static ArrayList<obj_tres_campos> tutor_mensaje_muestra_alumnos(String idn) {
        ArrayList<obj_tres_campos> lista = new ArrayList<obj_tres_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_tutor_mensaje_muestra_alumnos (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, idn);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
      
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
    
     
      public static ArrayList<obj_tres_campos> tutor_mensaje_muestra_alumnos_a_seleccionar(String idn) {
        ArrayList<obj_tres_campos> lista = new ArrayList<obj_tres_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_tutor_mensaje_muestra_alumnos_a_seleccionar (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, idn);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
      
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
    
     
     ///////////////******************
     
    
      
        public static ArrayList<obj_un_campo_string> tutor_mensaje_envia_alumnos_seleccionados(String men_eje_alu_idn, String tc_idn) {
    ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
        Connection c=null;
         String msg ;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_tutor_mensaje_envia_alumnos_seleccionados (?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, men_eje_alu_idn.trim());
            ps.setString(2, tc_idn.trim());

           
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
     
           
      
      
      //**
      
    
        
        
        
        
    /////////////////*****************
         
         
          public static ArrayList<obj_dos_campos> tutor_mensaje_envia_alumnos_seleccionados2(int mensaje,ArrayList<?> arreglo) 
     {
        
        ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        int salida = 1;
         String msg;
        Connection c=null;
        String sql;
      
        try {

                int size= arreglo.size();
                int i;
                for (i=0; i<size; i++) 
                {
                        c = conexion_odbc.Connexion_datos();
                        sql = "{call flex_adm_tutor_mensaje_envia_alumnos_seleccionados2 (?,?)}" ;
                        CallableStatement ps = c.prepareCall(sql);
                        ps.setInt(1,mensaje);
                        ps.setString(2,arreglo.get(i).toString().trim());
                        ps.execute();
                }
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
        
        
          
  //////////////////////******************
      public static ArrayList<obj_un_campo_string> tutor_mensaje_envia_masivo_alumnos(String ejecucion_aca, String modo , String titulo, String glosa, String activo, String fecha, String imagen) {
    ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
        Connection c=null;
         String msg ;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_tutor_mensaje_envia_masivo_alumnos (?,?,?,?,?,?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, ejecucion_aca.trim());
            ps.setString(2, modo.trim());
            ps.setString(3, titulo.trim());
            ps.setString(4, glosa.trim());
            ps.setString(5, activo);
            ps.setString(6, fecha.trim());
            ps.setString(7, imagen.trim());
           
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
          
          
          
          
          
          
          
          
          
 ///////////////////////////***************         
     
  
    
    /** Creates a new instance of frm_tutor_mensaje_ejec_alumno */
    public frm_tutor_mensaje_ejec_alumno() {
    }
    
}
