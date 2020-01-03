/*
 * frm_mensajeria_alumno.java
 *
 * Created on 29 de noviembre de 2005, 10:16
 */

package libreria_alm;


import java.util.ArrayList;
import java.sql.*;


/**
 *
 * @author  lobo
 */
public class frm_mensajeria_alumno {
    

    
    
    
    
       /* public static ArrayList muestra_mensaje_alumno(String toma_curso , int leido) {
      ArrayList lista = new ArrayList();
        Connection c=null;
         int salida;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_tutor_mensaje_muestra_mesaje_alumno (?, ?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,toma_curso.trim());
            ps.setInt(2,leido);
                      
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
      
            lista.add(new obj_siete_campos (rs.getString("men_tom_cur_idn"), 
                                            rs.getString("men_eje_alu_idn"), 
                                             rs.getString("men_eje_alu_titulo"), 
                                             rs.getString("men_eje_alu_glosa"), 
                                             rs.getString("men_eje_alu_fecha_ingreso"),
                                             rs.getString("men_eje_alu_imagen"),
                                             rs.getString("leido")));
           
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
    
    
///////**************************************************************************    
    
     public static ArrayList<obj_ocho_campos> muestra_mensaje_alumno(String mat_idn, String leido) {
      ArrayList<obj_ocho_campos> lista = new ArrayList<obj_ocho_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_tutor_mensaje_muestra_mesaje_alumno (?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,mat_idn.trim());
            ps.setString(2,leido.trim());
                      
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
           
      
            lista.add(new obj_ocho_campos (rs.getString("men_tom_cur_idn"), 
                                             rs.getString("men_eje_alu_idn"), 
                                             rs.getString("men_eje_alu_titulo"), 
                                             rs.getString("men_eje_alu_glosa"), 
                                             rs.getString("men_eje_alu_fecha_ingreso"),
                                             rs.getString("men_eje_alu_imagen"),
                                             rs.getString("cur_nombre"),
                                             rs.getString("tc_idn")));//,
                                            // rs.getString("leido")));
           
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
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /////************************************************************************
          public static ArrayList<obj_un_campo> mensaje_actualiza_fecha_leido(String tc_idn)
   {
    ArrayList<obj_un_campo> lista = new ArrayList<obj_un_campo>();
        Connection c=null;
         int salida = 1;
        try {
  
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_tutor_mensaje_actualiza_fecha_leido (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
             ps.setString(1, tc_idn.trim());
           
          
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
          
/////////*********************************************************************
    public static ArrayList<obj_seis_campos> tutor_mensaje_muestra_leidos(String toma_curso , int leido) {
      ArrayList<obj_seis_campos> lista = new ArrayList<obj_seis_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_tutor_mensaje_muestra_mesaje_alumno (?, ?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,toma_curso.trim());
            ps.setInt(2,leido);
                      
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
      
            lista.add(new obj_seis_campos (rs.getString("men_tom_cur_idn"), 
                                            rs.getString("men_eje_alu_idn"), 
                                             rs.getString("men_eje_alu_titulo"), 
                                             rs.getString("men_eje_alu_glosa"), 
                                             rs.getString("men_eje_alu_fecha_ingreso"),
                                             rs.getString("men_eje_alu_imagen")));//,
                                           //  rs.getString("leido")));
           
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
        
        
        
        
/////////*********************************************************************    
    
    
    /** Creates a new instance of frm_mensajeria_alumno */
    public frm_mensajeria_alumno() {
    }
    
}
