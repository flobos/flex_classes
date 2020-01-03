/*
 * frm_biblioteca_material_recepcion.java
 *
 * Created on 1 de julio de 2008, 11:31
 */

package libreria;
import java.util.ArrayList;
import java.sql.*;


/**
 *
 * @author  Administrador
 */
public class frm_biblioteca_material_recepcion {
    
    
     public static ArrayList<obj_tres_campos> buscar_material_en_sede (String rut) {
         ArrayList<obj_tres_campos> lista = new ArrayList<obj_tres_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call bfx_material_recepcion_muestra_coleccion (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, rut.trim());
           
            ResultSet rs = ps.executeQuery();
                        
            while (rs.next()){
            
      
            lista.add(new obj_tres_campos(rs.getString("mat_col_codigo_externo"),
                                         rs.getString("coleccion"),
                                         rs.getString("est_ubi_nombre")));
           
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
     
     
     public static ArrayList<obj_dos_campos> verifica_colecion_en_sede (String rut, int codigo_coleccion) {
         ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call bfx_material_recepcion_verifica_coleccion_sedes (?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, rut.trim());
            ps.setInt(2,codigo_coleccion );
           
            ResultSet rs = ps.executeQuery();
                        
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos(rs.getString("mat_col_idn"),
                                         "hola"));
           
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
     
    public static ArrayList<obj_dos_campos> actualiza_ubicacion_sede(int codigo_coleccion){
    ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
        String msg;
        msg = "Comando completado exitosamente";
        int salida = 1;
       
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
           
             sql = "{call bfx_material_recepcion_actualiza_ubicacion (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
           
            ps.setInt(1,codigo_coleccion);
           
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
   
   
    
    
    
    public frm_biblioteca_material_recepcion() {
    }
    
}
