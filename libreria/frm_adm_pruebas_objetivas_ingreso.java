/*
 * frm_adm_pruebas_objetivas_ingreso.java
 *
 * Created on 22 de diciembre de 2005, 03:20 PM
 */

package libreria;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author  Esteban
 */
public class frm_adm_pruebas_objetivas_ingreso {

// ******************************************************************** 
// ////  Writed by LoBo !! 
// frm_pruebas_objetivas_asigna_ejecucion_pruebas.mxml  
// frm_pruebas_objetivas_ingreso                          
// ********************************************************************     

  public static ArrayList<obj_un_campo> pruebas_objetivas_productos_inserta(int pru_obj_idn,String producto , String nombre, int cantidad) {
    ArrayList<obj_un_campo> lista = new ArrayList<obj_un_campo>();
        Connection c=null;
         int salida = 1;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_producto_campus_inserta (?,?,?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setInt(1,pru_obj_idn);
            ps.setString(2,producto.trim());
            ps.setString(3,nombre.trim());
            ps.setInt(4, cantidad);
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
        lista.add(new obj_un_campo(1));
        }else{
        lista.add(new obj_un_campo(0));
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
//  Writed by LoBo !!
//  frm_pruebas_objetivas_ingreso.mxml  ///
// ********************************************************************

  public static ArrayList<obj_un_campo> pruebas_objetivas_actualiza(int idn , String nombre, int cantidad) {
    ArrayList<obj_un_campo> lista = new ArrayList<obj_un_campo>();
        Connection c=null;
         int salida = 1;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_pruebas_obj_actualiza (?,?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setInt(1,idn);
            ps.setString(2,nombre.trim());
            ps.setInt(3, cantidad);
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
        lista.add(new obj_un_campo(1));
        }else{
        lista.add(new obj_un_campo(0));
        }
        
         return lista;
   }
  // ********************************************************************
//  Writed by LoBo !!
//  frm_pruebas_objetivas_ingreso.mxml  ///
// ********************************************************************
  
 public static ArrayList<obj_un_campo> pruebas_objetivas_borra(int idn) {
    ArrayList<obj_un_campo> lista = new ArrayList<obj_un_campo>();
    Connection c=null;
    int salida = 1;
    try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_pruebas_obj_borra (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setInt(1,idn);
            ps.execute();
           
        } catch (Exception e) {
            e.printStackTrace();
            salida = 0;
            e.getMessage();
        } finally {
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (salida == 1){
        lista.add(new obj_un_campo(1));
        }else{
        lista.add(new obj_un_campo(0));
        }
        
         return lista;
   }  
//***********************************************************************************************************
// frm_ayuda_web_ingreso.mxml RGN
//        frm_menu_principal.mxml
//        frm_menu_sistema.mxml        
//        frm_pruebas_objetivas_ingreso         
//***********************************************************************************************************  
        
    public static ArrayList<obj_un_campo_string> genera_correlativos(String corre)
  {
      
              ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
        Connection c=null;

        try {
         
            c = conexion_odbc.Connexion_datos();
            Statement s = c.createStatement();
            ResultSet rs =  s.executeQuery("flex_genera_correlativos '" + corre + "'");
            while (rs.next()){
                    lista.add(new obj_un_campo_string(rs.getString("salida")));
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
// ********************************************************************
//  Writed by LoBo !!
//  frm_pruebas_objetivas_producto_muestra.mxml  ///
// ********************************************************************   
 
public static ArrayList<obj_dos_campos> producto_campus_muestra(String modalidad_campus, String cadena) {
    ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_producto_campus_muestra (?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, modalidad_campus.trim());
            ps.setString(2, cadena.trim());
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
      
             lista.add(new obj_dos_campos(rs.getString("pro_cam_idn"),
                                  rs.getString("cur_nombre")));
           
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
    /** Creates a new instance of frm_adm_pruebas_objetivas_ingreso */
    public frm_adm_pruebas_objetivas_ingreso() {
    }
    
}
