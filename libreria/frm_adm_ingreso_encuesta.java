/*
 * frm_adm_ingreso_encuesta.java
 *
 * Created on 3 de abril de 2007, 15:04
 */

package libreria;

import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author  Administrador
 */
public class frm_adm_ingreso_encuesta {
    
    /** Creates a new instance of frm_adm_ingreso_encuesta */
    public frm_adm_ingreso_encuesta() {
    }
    
   public static ArrayList<obj_un_campo_int> encuesta_inserta(String nombre)
   {
    ArrayList<obj_un_campo_int> lista = new ArrayList<obj_un_campo_int>();
        Connection c=null;
         int salida = 1;
        try {
  
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_encuesta_inserta (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
             ps.setString(1, nombre.trim());
           
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
        lista.add(new obj_un_campo_int(1));
        }else{
        lista.add(new obj_un_campo_int(0));
        }
        
         return lista;
   }
   
   public static ArrayList<obj_tres_campos> encuesta_muestra() {
      ArrayList<obj_tres_campos> lista = new ArrayList<obj_tres_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_encuesta_muestra}" ;
            CallableStatement ps = c.prepareCall(sql);
                                 
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
      
            lista.add(new obj_tres_campos (rs.getString("enc_idn"), 
                                             rs.getString("enc_nombre"), 
                                             rs.getString("enc_fecha_ingreso")));
           
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
   
   
   
    public static ArrayList<obj_un_campo_int> encuesta_elimina(int codigo)
   {
    ArrayList<obj_un_campo_int> lista = new ArrayList<obj_un_campo_int>();
        Connection c=null;
         int salida = 1;
        try {
  
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_encuesta_elimina (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
             ps.setInt(1, codigo);
           
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
        lista.add(new obj_un_campo_int(1));
        }else{
        lista.add(new obj_un_campo_int(0));
        }
        
         return lista;
   }
    
    
    
     public static ArrayList<obj_dos_campos> encuesta_muestra_tipo_pregunta() {
      ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_encuesta_muestra_tipo_pregunta}" ;
            CallableStatement ps = c.prepareCall(sql);
                                 
            ResultSet rs = ps.executeQuery();
            
              
            lista.add(new obj_dos_campos("0", "--Seleccione--"));
            
            
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos (rs.getString("tip_pre_idn"), 
                                             rs.getString("tip_pre_nombre")));
           
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
     
     
     public static ArrayList<obj_un_campo_int> encuesta_inserta_pregunta(int codigo, String pregunta, int tipo_pregunta )
   {
    ArrayList<obj_un_campo_int> lista = new ArrayList<obj_un_campo_int>();
        Connection c=null;
         int salida = 1;
        try {
  
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_encuesta_inserta_pregunta (?,?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
             ps.setInt(1, codigo);
             ps.setString(2, pregunta.trim());
             ps.setInt(3, tipo_pregunta);
           
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
        lista.add(new obj_un_campo_int(1));
        }else{
        lista.add(new obj_un_campo_int(0));
        }
        
         return lista;
   }
     
     
     
     public static ArrayList<obj_tres_campos> encuesta_muestra_preguntas(int codigo) {
      ArrayList<obj_tres_campos> lista = new ArrayList<obj_tres_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_encuesta_muestra_pregunta (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setInt(1, codigo);
                                 
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
      
            lista.add(new obj_tres_campos (rs.getString("enc_pre_idn"), 
                                             rs.getString("enc_pre_pregunta"), 
                                             rs.getString("tip_pre_nombre")));
           
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
     
     
   public static ArrayList<obj_un_campo_int> encuesta_elimina_pregunta(int codigo)
   {
    ArrayList<obj_un_campo_int> lista = new ArrayList<obj_un_campo_int>();
        Connection c=null;
         int salida = 1;
        try {
  
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_encuesta_elimina_pregunta (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
             ps.setInt(1, codigo);
           
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
        lista.add(new obj_un_campo_int(1));
        }else{
        lista.add(new obj_un_campo_int(0));
        }
        
         return lista;
   }
   
   
    
    
    
    
}
