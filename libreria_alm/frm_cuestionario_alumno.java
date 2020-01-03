/*
 * frm_encuesta_alumno.java
 *
 * Created on 13 de diciembre de 2005, 17:11
 */

package libreria_alm;
/**
 *
 * @author  Administrador
 */

import java.util.ArrayList;
import java.sql.*;


public class frm_cuestionario_alumno {
    
    
       public static ArrayList<obj_dos_campos> cuestionario_inserta_respuesta(String enc_pre_idn,String mat_idn,String enc_pre_mat_respuesta) {
    ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
        String msg;
        msg = "OK";
        int salida = 1;
       
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_respuestas_cuestionario (?,?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,enc_pre_idn);
            ps.setString(2,mat_idn);
            ps.setString(3,enc_pre_mat_respuesta.trim());
            ps.execute();
             
        } catch (Exception e) {
            e.printStackTrace();
           
            msg = e.getMessage();
            salida = 0;
            
        } finally {
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        if (salida == 1){
        lista.add(new obj_dos_campos("1", msg));
        }else{
        lista.add(new obj_dos_campos("0", msg));
        
        }
        
         return lista;
   }
       
///////////////////////////////////////////////////////////
 /*  public static ArrayList cuestionario_existe_respuesta(String enc_pre_idn, String mat_idn) {
        ArrayList lista = new ArrayList();
        Connection c=null;
         int salida;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_cuestionario_existe_respuesta (?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, enc_pre_idn);
            ps.setString(2, mat_idn);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
        //lista.add(new obj_dos_campos(rs.getString("data"),
          //                        rs.getString("label")));
            //lista.add(new obj_dos_campos(rs.getString("campo_uno")));
           
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
   }*/
   //////////////////////
   
   
   
    public static ArrayList<obj_un_campo_string> cuestionario_existe_respuesta(String enc_pre_idn, String mat_idn) {
    ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
        Connection c=null;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_cuestionario_existe_respuesta (?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,enc_pre_idn);
            ps.setString(2,mat_idn.trim());
            ResultSet rs = ps.executeQuery();
            
            while (rs.next())
            {
                lista.add(new obj_un_campo_string(rs.getString("enc_idn")));
            }
        } catch (Exception e) {
            e.printStackTrace();
           
            e.getMessage();
            
        } finally {
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
      
        
         return lista;
   } 
   
   
   
   
   
   
   
   
   //////////////////////
}    
    
    
    
    
    
    