/*
 * frm_biblioteca_material_asigna_sedes.java
 *
 * Created on 23 de junio de 2008, 11:36
 */

package libreria;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author  Administrador
 */
public class frm_biblioteca_material_asigna_sedes {
    
    
     public static ArrayList<obj_dos_campos> muestra_sedes() {
         ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call bfx_material_envio_sedes_muestra_sedes}" ;
            CallableStatement ps = c.prepareCall(sql);
                      
            ResultSet rs = ps.executeQuery();
            
            lista.add(new obj_dos_campos("1", "--Seleccione--"));
            
                        
            while (rs.next()){
            
            
                
            lista.add(new obj_dos_campos(rs.getString("sed_idn"),
                                         rs.getString("sed_nombre")));
           
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
     
      public static ArrayList<obj_cuatro_campos> buscar_coleccion (int codigo_coleccion ) {
         ArrayList<obj_cuatro_campos> lista = new ArrayList<obj_cuatro_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call bfx_material_envio_sedes_busca_coleccion (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setInt(1, codigo_coleccion);
           
            ResultSet rs = ps.executeQuery();
                       
            while (rs.next()){
              
            lista.add(new obj_cuatro_campos(rs.getString("mat_col_idn"),
                                         rs.getString("mat_tit_titulo"),
                                         rs.getString("tip_mat_bib_nombre"),
                                         rs.getString("mat_col_codigo_externo")));
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
      
      
     public static ArrayList<obj_dos_campos> actualiza_sede_coleccion(String codigo_sede , ArrayList<?> arreglo_coleccion  ) {
      ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
      
        Connection c=null;
        String salida = "0";
        String msg = "Comando completado exitosamente";
        
        try {
            
            if (arreglo_coleccion.size() > 0)
            {
                String sql_asignados;
                int i_asignados;
                int size_asignados = arreglo_coleccion.size();
                                
                obj_tres_campos reg_asignados = null;
                
                for (i_asignados=0; i_asignados<size_asignados; i_asignados++) 
                {               
                    reg_asignados = (obj_tres_campos)arreglo_coleccion.get(i_asignados);
                    c = conexion_odbc.Connexion_datos();
                    
                    sql_asignados = "{call bfx_material_envio_sedes_actualiza_sede_coleccion (?,?)}" ;
                    CallableStatement ps1 = c.prepareCall(sql_asignados);
                    ps1.setInt(1, Integer.parseInt(reg_asignados.getcampo_uno()));  
                    ps1.setString(2, codigo_sede.trim());  
                    ps1.execute();          
                }   
            }    
            
        } catch (Exception e) {
            e.printStackTrace();
            msg = e.getMessage();
            salida = "1";
        } finally {
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            
            lista.add(new obj_dos_campos(salida, msg));
        }
         return lista;
   } 
      
   
      public static ArrayList<obj_cuatro_campos> buscar_coleccion_sede (String codigo_sede ) {
         ArrayList<obj_cuatro_campos> lista = new ArrayList<obj_cuatro_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call bfx_material_envio_sedes_muestra_coleccion_sedes (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, codigo_sede);
           
            ResultSet rs = ps.executeQuery();
                       
            while (rs.next()){
              
            lista.add(new obj_cuatro_campos(rs.getString("mat_col_idn"),
                                         rs.getString("coleccion"),
                                         rs.getString("mat_col_codigo_externo"),
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
     
     
   
    
    
    /** Creates a new instance of frm_biblioteca_material_asigna_sedes */
    public frm_biblioteca_material_asigna_sedes() {
    }
    
}
