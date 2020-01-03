/*
 * frm_biblioteca_material_movimiento.java
 *
 * Created on 16 de junio de 2008, 10:16
 */

package libreria;
import java.util.ArrayList;
import java.sql.*;


/**
 *
 * @author  Administrador
 */
public class frm_biblioteca_material_movimiento {
    
    /** Creates a new instance of frm_biblioteca_material_movimiento */
    public frm_biblioteca_material_movimiento() {
    }
    
    
    
      public static ArrayList<obj_tres_campos> buscar_material_por_titulo (String criterio) {
         ArrayList<obj_tres_campos> lista = new ArrayList<obj_tres_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call bfx_material_biblioteca_buscar_x_titulo (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, criterio.trim());
           
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
 //********************************************************************
      public static ArrayList<obj_tres_campos> buscar_material_por_codigo (String criterio) {
         ArrayList<obj_tres_campos> lista = new ArrayList<obj_tres_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call bfx_material_biblioteca_buscar_x_codigo (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, criterio.trim());
           
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
//********************************************************************
      public static ArrayList<obj_tres_campos> buscar_material_por_autor (String criterio) {
         ArrayList<obj_tres_campos> lista = new ArrayList<obj_tres_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call bfx_material_biblioteca_buscar_x_autor (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, criterio.trim());
           
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
 //********************************************************************
      public static ArrayList<obj_tres_campos> buscar_material_por_etiqueta (String criterio) {
         ArrayList<obj_tres_campos> lista = new ArrayList<obj_tres_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call bfx_material_biblioteca_buscar_x_etiqueta (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, criterio.trim());
           
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
 //*********************************************************************  
      public static ArrayList<obj_dos_campos> buscar_material_etiquetas (int material) {
         ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call bfx_material_biblioteca_buscar_etiqueta (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setInt(1, material);
           
            ResultSet rs = ps.executeQuery();
                        
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos(rs.getString("mat_eti_idn"),
                                         rs.getString("eti_nombre")));
           
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
      
      
     public static ArrayList<obj_tres_campos> buscar_material_autor(int material) {
         ArrayList<obj_tres_campos> lista = new ArrayList<obj_tres_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call bfx_material_biblioteca_buscar_autor (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setInt(1, material);
           
            ResultSet rs = ps.executeQuery();
                        
            while (rs.next()){
            
      
            lista.add(new obj_tres_campos(rs.getString("mat_aut_idn"),
                                         rs.getString("nombre"),
                                         rs.getString("tip_aut_nombre")));
           
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
     
     
    public static ArrayList<obj_seis_campos> muestra_material_coleccion(int material) {
         ArrayList<obj_seis_campos> lista = new ArrayList<obj_seis_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call bfx_material_biblioteca_muestra_coleccion (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setInt(1, material);
           
            ResultSet rs = ps.executeQuery();
                        
            while (rs.next()){
            
      
            lista.add(new obj_seis_campos(rs.getString("mat_col_idn"),
                                         rs.getString("mat_col_dias_prestamo"),
                                         rs.getString("tip_est_mat_nombre"),
                                         rs.getString("tip_est_mat_idn"),
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
    
    
    
    public static ArrayList<obj_dos_campos> busca_alumno(String rut ) {
         ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call bfx_material_biblioteca_muestra_alumno (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, rut.trim());
           
            ResultSet rs = ps.executeQuery();
                        
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos(rs.getString("alu_idn"),
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
    
    
    
    public static ArrayList<obj_dos_campos> inserta_movimiento(int coleccion, int funcion , String alumno){
    ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
        String msg;
        msg = "Comando completado exitosamente";
        int salida = 1;
       
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
           
             sql = "{call bfx_material_biblioteca_inserta_movimiento (?,?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
           
            ps.setInt(1,coleccion);
            ps.setInt(2,funcion);
            ps.setString(3,alumno.trim());
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
    
    
    public static ArrayList<obj_seis_campos> muestra_movimiento_alumno(String codigo_alumno) {
         ArrayList<obj_seis_campos> lista = new ArrayList<obj_seis_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call bfx_material_biblioteca_muestra_movimiento_alumno (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, codigo_alumno.trim());
           
            ResultSet rs = ps.executeQuery();
                        
            while (rs.next()){
            
       
            lista.add(new obj_seis_campos(rs.getString("mat_col_idn"),
                                         rs.getString("titulo"),
                                         rs.getString("prestado"),
                                         rs.getString("devuelto"),
                                         rs.getString("est_mov_nombre"),
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



    
   
      
      
      
      
    
}
