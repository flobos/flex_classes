/*
 * frm_adm_main.java
 *
 * Created on 19 de diciembre de 2005, 10:36 AM
 */

package libreria;

import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author  Esteban
 */
public class frm_adm_main {
    
//***********************************************************************************************************                 
public static ArrayList<obj_cinco_campos> funcionario_muestra_menu(String rut) {
    ArrayList<obj_cinco_campos> lista = new ArrayList<obj_cinco_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_menu_usuario_main (?)} " ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, rut.trim());
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
      
             lista.add(new obj_cinco_campos(rs.getString("men_idn"),
                                            rs.getString("men_nombre"),
                                            rs.getString("men_pri_idn"),
                                            rs.getString("men_pri_nombre"),
                                            rs.getString("men_pan_sistema")));
           
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
     public static ArrayList<obj_un_campo_string> registro_acceso_menu_inserta(String menu, String rut) {
    ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
        Connection c=null;
         int salida = 1;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_registro_acceso_sistema_inserta (?,?)} " ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, menu.trim());
            ps.setString(2, rut.trim());
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
        lista.add(new obj_un_campo_string("1"));
        }else{
        lista.add(new obj_un_campo_string("0"));
        }
        
         return lista;
   }
//***********************************************************************************************************          
     
    /** Creates a new instance of frm_adm_main */
    public frm_adm_main() {
    }
    
}
