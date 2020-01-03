/*
 * frm_adm_asocia_matriculas_matricula_isntitucion.java
 *
 * Created on 27 de septiembre de 2007, 10:36 AM
 */

package libreria;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author  Esteban 
 */
public class frm_adm_asocia_matriculas_matricula_isntitucion {
    
//***********************************************************************************************************                 
public static ArrayList<obj_dos_campos> carga_matricula_de_matricula_isnt(String mat_ins_idn) {
    ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_asocia_matriculas_carga_matricula_de_matricula_inst (?)}" ;//
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, mat_ins_idn.trim());
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
      
             lista.add(new obj_dos_campos(rs.getString("mat_ins_idn")
                                                , rs.getString("mat_idn")));
           
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
public static ArrayList<obj_un_campo_string> inserta_matricula_de_matricula_isnt(String mat_ins_idn, String mat_idn) {
    ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
        Connection c=null;
         
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_asocia_matriculas_inserta_matricula_de_matricula_isnt (?,?)}" ;//
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, mat_ins_idn.trim());
            ps.setString(2, mat_idn.trim());
            ResultSet rs = ps.executeQuery();
            
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
public static ArrayList<obj_un_campo_string> elimina_matricula_de_matricula_isnt(String mat_ins_idn, String mat_idn) {
    ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
        Connection c=null;
         
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_asocia_matriculas_elimina_matricula_de_matricula_inst (?,?)}" ;//
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, mat_ins_idn.trim());
            ps.setString(2, mat_idn.trim());
            ResultSet rs = ps.executeQuery();
            
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

    
    /** Creates a new instance of frm_adm_asocia_matriculas_matricula_isntitucion */
    public frm_adm_asocia_matriculas_matricula_isntitucion() {
    }
    
}
