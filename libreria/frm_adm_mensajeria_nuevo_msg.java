/*
 * frm_adm_mensajeria_nuevo_msg.java
 *
 * Created on 19 de diciembre de 2005, 02:21 PM
 */

package libreria;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author  Esteban
 */
public class frm_adm_mensajeria_nuevo_msg {
//*********************************************************************************************************** 
  public static ArrayList<obj_dos_campos> mensajeria_muestra_funcionarios() {
      ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_mesajeria_muestra_funcionarios}" ;
            CallableStatement ps = c.prepareCall(sql);
                      
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos (rs.getString("rut"), 
                                          rs.getString("nombre")));
           
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
//*********************************************************************************************************** 
   public static ArrayList<obj_dos_campos> mesajeria_inserta_mesaje(String rut, String asunto, String cuerpo, int respuesta) {
    ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
           String msg;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_mesajeria_inserta (?,?,?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
               ps.setString(1,rut.trim());
            ps.setString(2,asunto.trim());
            ps.setString(3,cuerpo.trim());
            ps.setInt(4,respuesta);
            ResultSet rs = ps.executeQuery();
        
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos("1", rs.getString("identidad")));
           
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
//*********************************************************************************************************** 
   public static ArrayList<obj_dos_campos> mensajeria_inserta_destinatarios(int mensaje,ArrayList<?> arreglo) 
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
                        sql = "{call flex_adm_mesajeria_inserta_destinatarios (?,?)}" ;
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
//*********************************************************************************************************** 
    
    /** Creates a new instance of frm_adm_mensajeria_nuevo_msg */
    public frm_adm_mensajeria_nuevo_msg() {
    }
    
}
