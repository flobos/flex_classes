/*
 * frm_adm_menu_principal.java
 *
 * Created on 21 de diciembre de 2005, 04:10 PM
 */

package libreria;
import java.util.ArrayList;
import java.io.Serializable;
import java.sql.*;
/**
 *
 * @author  Esteban
 */
public class frm_adm_menu_principal {
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
//   MENU PRINCIPAL --- MENU DE SISTEMA --- PRIVILEGIOS   (RGN) !!!
// ******************************************************************** 
//  Writed by RGN !! frm_menu_principal.mxml
// ********************************************************************
      
  public static ArrayList<Serializable> menu_principal_muestra()
 {
             ArrayList<Serializable> lista = new ArrayList<Serializable>();
        Connection c=null;

        try {
         
            c = conexion_odbc.Connexion_datos();
            Statement s = c.createStatement();
            ResultSet rs =  s.executeQuery("SELECT men_pri_idn as data , men_pri_nombre as label from menu_principal where tip_men_pri_idn = 11");
           lista.add(0,"SELECCIONO");
            while (rs.next()){
            
                
                lista.add(new obj_dos_campos(rs.getString("data"),rs.getString("label")));
            
            
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
  ////////  Writed by RGN !! frm_menu_principal.mxml
  //********************************************************************

      
   public static ArrayList<obj_un_campo> inserta_menu_principal(String men_pri_idn, String men_pri_nombre)
   {
    ArrayList<obj_un_campo> lista = new ArrayList<obj_un_campo>();
        Connection c=null;
         int salida = 1;
        try {
  
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_agrega_menu_principal (?,?)} " ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,men_pri_idn.trim());
            ps.setString(2,men_pri_nombre.trim());
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

  //******************************************************************** 
  ////////  Writed by RGN !! frm_menu_principal.mxml
  //********************************************************************

   
    public static ArrayList<obj_un_campo> modifica_menu_principal(String men_pri_idn, String men_pri_nombre)
   {
    ArrayList<obj_un_campo> lista = new ArrayList<obj_un_campo>();
        Connection c=null;
         int salida = 1;
        try {
  
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_modifica_menu_principal (?,?)} " ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,men_pri_idn.trim());
            ps.setString(2,men_pri_nombre.trim());
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
  
    
//******************************************************************** 
////////  Writed by RGN !!  frm_menu_principal.mxml
//********************************************************************

    
   public static ArrayList<obj_un_campo> elimina_menu_principal(String men_pri_idn)
   {
    ArrayList<obj_un_campo> lista = new ArrayList<obj_un_campo>();
        Connection c=null;
         int salida = 1;
        try {
  
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_elimina_menu_principal (?)} " ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,men_pri_idn.trim());
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
    /** Creates a new instance of frm_adm_menu_principal */
    public frm_adm_menu_principal() {
    }
    
}
