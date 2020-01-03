/*
 * frm_foto_alumno_2.java
 *
 * Created on 25 de abril de 2007, 11:52
 */


package libreria;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author  marcelo
 */
public class frm_foto_alumno {
    
    
    
      //***********************************************************************************************************

      
 //***********************************************************************************************************

    //***********************************************************************************************************      
      public static ArrayList foto_alumno_busca_datos_alumno(String dato) {
    
        ArrayList lista = new ArrayList();
        Connection c=null;
        String exito;
        
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_foto_alumno_busca_datos_alumno '" + dato + "'";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
        
            while (rs.next()){
            
      
      
            lista.add(new obj_cinco_campos(rs.getString("alu_idn")
                                       , rs.getString("nombre")
                                       , rs.getString("mat_idn")
                                       , rs.getString("car_nombre")
                                       , rs.getString("alu_foto")));
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
 //************--------------------------------------------------------------------------
  


    
 
   ////////////////////////////////////////////////
    
       ////////////////////////////////////////////////
    
    
    public static ArrayList foto_alumno_actualiza_alu_foto(String alu_idn
    , String alu_foto)
   {
    ArrayList lista = new ArrayList();
        Connection c=null;
         int salida = 1;
         String msg;
         msg = "siiisubio";
        try {
  
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_foto_alumno_actualiza_alu_foto (?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, alu_idn.trim());
            ps.setString(2, alu_foto.trim());
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
        lista.add(new obj_dos_campos("1", msg));
        }else{
        lista.add(new obj_dos_campos("0", msg));
        
        }
        
         return lista;
   }
   
    
    
 
   ////////////////////////////////////////////////
   
    
    
    
     public static ArrayList foto_alumno_borra_alu_foto(String alu_idn)
   {
    ArrayList lista = new ArrayList();
        Connection c=null;
         int salida = 1;
         String msg;
         msg = "siiisubio";
        try {
  
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_foto_alumno_borra_alu_foto (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, alu_idn.trim());
            
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
        lista.add(new obj_dos_campos("1", msg));
        }else{
        lista.add(new obj_dos_campos("0", msg));
        
        }
        
         return lista;
   }
    
    //-----------------------------------------------------------
    
    //***********************************************************************************************************      
      public static ArrayList foto_alumno_busca_datos_alumno_por_matricula(String mat_idn) {
    
        ArrayList lista = new ArrayList();
        Connection c=null;
        String exito;
        
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_foto_alumno_busca_datos_alumno_por_matricula '" + mat_idn + "'";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
        
            while (rs.next()){
            
      
      
            lista.add(new obj_cinco_campos(rs.getString("alu_idn")
                                       , rs.getString("nombre")
                                       , rs.getString("mat_idn")
                                       , rs.getString("car_nombre")
                                       , rs.getString("alu_foto")));
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
 //************--------------------------------------------------------------------------
  
    
    
    
    
    
    /** Creates a new instance of frm_foto_alumno_2 */
    public frm_foto_alumno() {
    }
    
}
