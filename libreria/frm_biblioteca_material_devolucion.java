/*
 * frm_biblioteca_material_devolucion.java
 *
 * Created on 1 de julio de 2008, 16:39
 */

package libreria;
    import java.util.ArrayList;
import java.sql.*;


/**
 *
 * @author  Administrador
 */
public class frm_biblioteca_material_devolucion {
    
  public static ArrayList<obj_dos_campos> verifica_coleccion_prestado (String rut, int codigo_coleccion) {
         ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call bfx_material_devolucion_verifica (?,?)}" ;
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

  
   public static ArrayList<obj_seis_campos> actualiza_movimiento(int codigo_coleccion) {
         ArrayList<obj_seis_campos> lista = new ArrayList<obj_seis_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call bfx_material_devolucion_coleccion (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setInt(1,codigo_coleccion );
            
           
            ResultSet rs = ps.executeQuery();
                        
            while (rs.next()){
            
      
            lista.add(new obj_seis_campos(rs.getString("mat_mov_idn"),
                                            rs.getString("nombre"),
                                            rs.getString("mat_mov_fecha_devuelto"),
                                            rs.getString("est_mov_nombre"),
                                            rs.getString("mat_mov_fecha_ingreso"),
                                            rs.getString("mat_col_dias_prestamo")));
           
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

    
    
    public frm_biblioteca_material_devolucion() {
    }
    
}
