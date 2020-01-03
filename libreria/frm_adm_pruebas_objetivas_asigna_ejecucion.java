/*
 * frm_adm_pruebas_objetivas_asigna_ejecucion.java
 *
 * Created on 26 de diciembre de 2005, 04:01 PM
 */

package libreria;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author  Esteban
 */
public class frm_adm_pruebas_objetivas_asigna_ejecucion {
  //******************************************************************** 
  ////////  Writed by LoBo !! frm_pruebas_objetivas_asigna_ejecucion
  //********************************************************************     

 public static ArrayList<obj_dos_campos> muestra_ejecuciones_activas() {
    
        ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
           sql = "flex_adm_ejecucion_activas_muestra";
            cs = c.prepareCall(sql);
           // cs.setString(1, "633174");
            ResultSet rs = cs.executeQuery();
            
        lista.add(new obj_dos_campos("0","-Seleccione-"));
            
            
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos(rs.getString("eje_idn"),
                                         rs.getString("eje_nombre")));
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
  ////////  Writed by LoBo !! frm_pruebas_objetivas_asigna_ejecucion
  //********************************************************************   
   
 public static ArrayList<obj_ocho_campos> pruebas_objetivas_muestra_evaluaciones_ejecucion(String codigo) {
    ArrayList<obj_ocho_campos> lista = new ArrayList<obj_ocho_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_pruebas_ejecucion_muestra_evaluaciones (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, codigo.trim());
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
      
            lista.add(new obj_ocho_campos(rs.getString("eje_aca_idn"), 
                                          rs.getString("pro_cam_idn"),
                                          rs.getString("cur_nombre"), 
                                          rs.getString("tip_prod_nombre"),
                                          rs.getString("eva_eje_idn"),
                                          rs.getString("fecha"),
                                          rs.getString("fecha_disponible"),
                                          rs.getString("tip_pru_nombre")));
           
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
  ////////  Writed by LoBo !! frm_pruebas_objetivas_asigna_ejecucion
  //********************************************************************   
 
   public static ArrayList<obj_tres_campos> pruebas_objetivas_ejecucion_valida(int codigo) {
    ArrayList<obj_tres_campos> lista = new ArrayList<obj_tres_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_pruebas_obj_valida_prueba_ok (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setInt(1, codigo);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
      
            lista.add(new obj_tres_campos(rs.getString("valida"), 
                                          rs.getString("errores"),
                                          rs.getString("descripcion")));
           
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
  ////////  Writed by LoBo !! frm_pruebas_objetivas_asigna_ejecucion
  //********************************************************************   
   
public static ArrayList<obj_un_campo_string> pruebas_objetivas_ejecucion_inserta(int prueba, int evaluacion , int cantidad, int porcentaje , int tiempo) {
    ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
    Connection c=null;
    int salida = 1;
    String msg;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_pruebas_obj_ejecucion_inserta (?,?,?,?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setInt(1,prueba);
            ps.setInt(2,evaluacion);
            ps.setInt(3,cantidad);
            ps.setInt(4,porcentaje);
            ps.setInt(5,tiempo);
            
            ps.execute();
            
           
        } catch (Exception e) {
            e.printStackTrace();
            salida = 0;
            msg = e.getMessage();
            lista.add(new obj_un_campo_string(msg));
        } finally {
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
                   
            }
        }
        
        if (salida == 1){
        lista.add(new obj_un_campo_string("1"));
        }
    
        return lista;
   }
// ******************************************************************** 
// ////  Writed by LoBo !! frm_pruebas_objetivas_asigna_ejecucion  ///
// ********************************************************************   
   
   public static ArrayList<obj_un_campo_string> pruebas_objetivas_ejecucion_inserta_preguntas(int evaluacion) {
    ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
    Connection c=null;
    int salida = 1;
    String msg;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_pruebas_obj_genera_para_ejecucion (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setInt(1,evaluacion);
            
            ps.execute();
            
           
        } catch (Exception e) {
            e.printStackTrace();
            salida = 0;
            msg = e.getMessage();
            lista.add(new obj_un_campo_string(msg));
        } finally {
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
                   
            }
        }
        
        if (salida == 1){
        lista.add(new obj_un_campo_string("1"));
        }
    
        return lista;
   }
 // ******************************************************************** 
// Writed by LoBo !!
// frm_pruebas_objetivas_asigna_ejecucion_pruebas.mxml  ///
// frm_pruebas_objetivas_ingreso   
// ********************************************************************      
   
    public static ArrayList<obj_cuatro_campos> pruebas_objetivas_muestra(String producto) {
    ArrayList<obj_cuatro_campos> lista = new ArrayList<obj_cuatro_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_producto_campus_muestra_pruebas (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, producto.trim());
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
      
            lista.add(new obj_cuatro_campos(rs.getString("idn"),
                                            rs.getString("pru_obj_nombre"), 
                                            rs.getString("cantidad"),
                                            rs.getString("fecha")));
           
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
     
// ******************************************************************** 
// ////  Writed by LoBo !! frm_pruebas_objetivas_asigna_ejecucion_pruebas.mxml  ///
// ********************************************************************          
    
public static ArrayList<obj_cinco_campos> pruebas_objetivas_ejecucion_muestra_asignadas(String evaluacion) {
    ArrayList<obj_cinco_campos> lista = new ArrayList<obj_cinco_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_pruebas_ejecucion_muestra_pruebas_asignadas (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, evaluacion.trim());
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
            lista.add(new obj_cinco_campos (rs.getString("idn"),
                                            rs.getString("cantidad"),
                                            rs.getString("porcentaje"),
                                            rs.getString("tiempo"),
                                            rs.getString("fecha")));
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
    /** Creates a new instance of frm_adm_pruebas_objetivas_asigna_ejecucion */
    public frm_adm_pruebas_objetivas_asigna_ejecucion() {
    }
    
}
