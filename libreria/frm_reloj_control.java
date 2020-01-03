/*
 * frm_reloj_control.java
 *
 * Created on 20 de julio de 2009, 12:25
 */

package libreria;
import java.util.ArrayList;
import java.sql.*;
/*
 * @author  Fernando
 */


public class frm_reloj_control {
    
    public static ArrayList<obj_dos_campos> recupera_fecha_servidor() {
        ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
        obj_dos_campos hora = null;
        String horafinal;
        
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call  frm_reloj_control_recupera_fecha_servidor ()}" ;
            CallableStatement ps = c.prepareCall(sql);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next())
            {
               lista.add(new obj_dos_campos (rs.getString("ddmmyyyyformato"),
                                             rs.getString("hhmmssformato")));        
            }
            
  
            hora=(obj_dos_campos)lista.get(0);
            horafinal = hora.getlabel();
            
            Runtime.getRuntime().exec ("cmd /c TIME "+horafinal); 

            
            
            

            
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
         
         
         
    
    
    public static ArrayList<obj_un_campo> recupera_tipo_ultimo_marcaje(String rut) {
      ArrayList<obj_un_campo> lista = new ArrayList<obj_un_campo>();
        Connection c=null;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call  frm_reloj_control_recupera_tipo_ultimo_marcaje (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,rut.trim());
                                
            ResultSet rs = ps.executeQuery();
        
            while (rs.next()){
            lista.add(new obj_un_campo (rs.getString("tipo_marcaje")));
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
    
    
    
    
    
    
    
    
    
     public static ArrayList<obj_cuatro_campos> obtiene_funcionario(String rut) {
      ArrayList<obj_cuatro_campos> lista = new ArrayList<obj_cuatro_campos>();
        Connection c=null;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call  frm_reloj_control_muestra_funcionario (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,rut.trim());
                                
            ResultSet rs = ps.executeQuery();
            
                  
            while (rs.next()){
            
      
            lista.add(new obj_cuatro_campos (rs.getString("fun_rut"), 
                                          rs.getString("nombre"),
                                          rs.getString("hhmmssformato"),
                                          rs.getString("fechahora")));
           
            }
            
            //inserta_marcaje(rs.getString("fun_rut"));
            
            
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
    
       
    
 //**********************************************************************
 // @author  LBaeza
 //**************************************************************************  
 public static ArrayList<obj_dos_campos> inserta_marcaje(String fun_rut, String hor_fun_tipo_marcaje) {
    ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
        String msg;
        msg = "OK";
        int salida = 1;
        
        
       
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_reloj_control_inserta_marcaje (?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,fun_rut.trim()); 
            ps.setString(2,hor_fun_tipo_marcaje.trim());
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
 //****************************************************************************
    
    
    public frm_reloj_control() {
        }
    
}
