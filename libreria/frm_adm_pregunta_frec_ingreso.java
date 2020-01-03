/*
 * frm_adm_foro_ingreso.java
 *
 * Created on 26 de diciembre de 2005, 02:30 PM
 */

package libreria;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author  luis
 */
public class frm_adm_pregunta_frec_ingreso {
 ////***************************************************************************************************
   ////***************************************************************************************************
    
    
    ////***************************************************************************************************
    
    
    
     public static ArrayList<obj_dos_campos> pregunta_muestra_tipo_producto(String valor) {
      ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_pregunta_muestra_tipo_producto (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,valor.trim());
                      
            ResultSet rs = ps.executeQuery();
            lista.add(new obj_dos_campos ("0", "-- Seleccione --"));  
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos (rs.getString("tip_prod_idn"), 
                                                rs.getString("tip_prod_nombre")));
           
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
 
 
  public static ArrayList<obj_dos_campos> pregunta_muestra_tema(String valor) {
      ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_pregunta_muestra_tema (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,valor.trim());
                      
            ResultSet rs = ps.executeQuery();
            
            lista.add(new obj_dos_campos ("0", "-- Seleccione --"));            
            
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos (rs.getString("tem_idn"), 
                                                rs.getString("tem_nombre")));
           
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

     
    
   
       public static ArrayList<obj_un_campo_string> pregunta_ingresa(String preg_frec_pregunta ) {
    ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
        Connection c=null;
         String msg ;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_pregunta_frec_ingresa (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, preg_frec_pregunta.trim());
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
   
    

    
////***************************************************************************************************
    
    
    
     public static ArrayList<obj_dos_campos> pregunta_frec_muestra_todas(String valor_pregunta) {
      ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_pregunta_frec_muestra (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,valor_pregunta.trim());         
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos (rs.getString("preg_frec_idn"), 
                                          rs.getString("preg_frec_pregunta")));
           
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
 
     ////***************************************************************************************************
    
    
    
     public static ArrayList<obj_dos_campos> respuestas_preg_frec_muestra_todas(String valor_respuesta) {
      ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_respuestas_preg_frec_muestra (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,valor_respuesta.trim());         
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
                  
            lista.add(new obj_dos_campos (rs.getString("res_preg_frec_idn"), 
                                          rs.getString("res_preg_frec_respuesta")));
           
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
 
     
     
   
      public static ArrayList<obj_un_campo> pregunta_modifica(String preg_frec_idn, String preg_frec_pregunta)
   {
    ArrayList<obj_un_campo> lista = new ArrayList<obj_un_campo>();
        Connection c=null;
         int salida = 1;
        try {
  
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_pregunta_frec_modifica (?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,preg_frec_idn.trim());
            ps.setString(2,preg_frec_pregunta.trim());
           
           
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
  
////***************************************************************************************************      
   
      
     public static ArrayList<obj_un_campo> pregunta_borra(int preg_frec_idn) {
    ArrayList<obj_un_campo> lista = new ArrayList<obj_un_campo>();
    Connection c=null;
    int salida = 1;
    try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_pregunta_frec_borra (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setInt(1,preg_frec_idn);
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
     
  ////***************************************************************************************************
    
    
    
     public static ArrayList<obj_dos_campos> muestra_idn_tema(String alu_idn) {
      ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_pregunta_frec_muestra_idn_tema (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,alu_idn.trim());         
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos (rs.getString("mod_idn"), 
                                          rs.getString("mod_nombre")));
           
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
 
     
     
     
     
    /*  
////***************************************************************************************************      
      
     public static ArrayList foro_existe(int for_tem_idn) {
        ArrayList lista = new ArrayList();
        Connection c=null;
         int salida;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_foro_existe (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setInt(1, for_tem_idn);
            
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
   */
       
    /** Creates a new instance of frm_adm_foro_ingreso */
     public frm_adm_pregunta_frec_ingreso() {
    }
    
}
