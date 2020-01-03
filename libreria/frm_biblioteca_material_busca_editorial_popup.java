/*
 * frm_biblioteca_material_busca_editorial_popup.java
 *
 * Created on 27 de junio de 2008, 12:05
 */

package libreria;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author  villanueva
 */
public class frm_biblioteca_material_busca_editorial_popup {
    
    /** Creates a new instance of frm_biblioteca_material_busca_editorial_popup */
    public frm_biblioteca_material_busca_editorial_popup() {
    }
   //*****************************************************************************    

    public static ArrayList<obj_dos_campos> busca_editorial(String edi_nombre) {
      ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_biblioteca_material_busca_editorial_popup_busca_editorial(?)}" ;
            CallableStatement ps = c.prepareCall(sql);
             
            ps.setString(1,edi_nombre.trim());
                                  
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
                  
            lista.add(new obj_dos_campos (rs.getString("edi_idn"), 
                                                rs.getString("edi_nombre")
                                            
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
    
    
//******************************************************************************
      public static ArrayList<obj_dos_campos> inserta_editorial(String edi_nombre) {
    ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
        String msg;
        msg = "Comando completado exitosamente";
        int salida = 1;
       
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
           
             sql = "{call frm_biblioteca_material_busca_editorial_popup_inserta_editorial (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
           
            ps.setString(1,edi_nombre.trim());
              
            
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
 
        
    
    
    
    
    
//******************************************************
}
