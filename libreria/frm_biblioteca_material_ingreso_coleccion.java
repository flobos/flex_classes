/*
 * frm_biblioteca_material_ingreso_coleccion.java
 *
 * Created on 18 de junio de 2008, 16:06
 */

package libreria;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author  Administrador
 */
public class frm_biblioteca_material_ingreso_coleccion {
    
     public static ArrayList<obj_tres_campos> buscar_material_por_titulo (String criterio, String rut_funcionario) {
         ArrayList<obj_tres_campos> lista = new ArrayList<obj_tres_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call bfx_material_coleccion_buscar_x_titulo (?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, criterio.trim());
            ps.setString(2, rut_funcionario.trim());
           
            ResultSet rs = ps.executeQuery();
                        
            while (rs.next()){
            
      
            lista.add(new obj_tres_campos(rs.getString("mat_bib_idn"),
                                         rs.getString("mat_tit_titulo"),
                                         rs.getString("tip_mat_bib_nombre")));
           
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
     
     public static ArrayList<obj_dos_campos> muestra_tipo_coleccion () {
         ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call bfx_material_coleccion_muestra_tipo_coleccion}" ;
            CallableStatement ps = c.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
                        
             while (rs.next()){
            
      
            lista.add(new obj_dos_campos(rs.getString("tip_col_idn"),
                                         rs.getString("tip_col_nombre")));
           
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
     
     public static ArrayList<obj_dos_campos> inserta_coleccion(int codigo_material_biblioteca,int funcion_funcionario , ArrayList<?> arreglo_coleccion  ) {
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
                    
                    sql_asignados = "{call bfx_material_coleccion_inserta_coleccion (?,?,?,?,?)}" ;
                    CallableStatement ps1 = c.prepareCall(sql_asignados);
                    ps1.setInt(1, codigo_material_biblioteca);  
                    ps1.setInt(2, Integer.parseInt(reg_asignados.getcampo_uno()));  
                    ps1.setInt(3, funcion_funcionario);  
                    ps1.setInt(4, Integer.parseInt(reg_asignados.getcampo_dos()));  
                    ps1.setString(5, reg_asignados.getcampo_tres().trim());  
                    
                    
                    
                    //ps1.setString(2, reg_asignados.getcampo_uno().toString().trim());          
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
     
       
     
     public static ArrayList<obj_cuatro_campos> muestra_coleccion_sede  (int codigo_material , String rut_funcionario) {
         ArrayList<obj_cuatro_campos> lista = new ArrayList<obj_cuatro_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call bfx_material_coleccion_muestra_coleccion_sede (?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setInt(1, codigo_material);
            ps.setString(2, rut_funcionario.trim());
            ResultSet rs = ps.executeQuery();
                       
            
            while (rs.next()){
            
      
            lista.add(new obj_cuatro_campos(rs.getString("mat_col_idn"),
                                         rs.getString("tip_col_idn"),
                                         rs.getString("tip_col_nombre"),
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

   
    
    
    
    public frm_biblioteca_material_ingreso_coleccion() {
    }
    
}
