/** frm_adm_muestra_alumnos_morosos.java 
 * Created on august 2010
 */
package libreria;
import java.util.ArrayList;
import java.sql.*;
 


/** @author LBaeza */
public class frm_adm_muestra_alumnos_morosos {
    
//******************************************************************************************************************************************************    
     public static ArrayList<obj_tres_campos> buscar_por_rut (String fun_rut) {
         ArrayList<obj_tres_campos> lista = new ArrayList<obj_tres_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_adm_muestra_alumnos_morosos(?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, fun_rut.trim());
            ResultSet rs = ps.executeQuery();
            
             while (rs.next()){
            
                lista.add(new obj_tres_campos(rs.getString("rut"),
                                              rs.getString("nombre"),
                                              rs.getString("cuotas_morosas")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally 
          {
            try 
            {
                c.close();
            } 
            catch (SQLException e) 
            {
                e.printStackTrace();
            }
          }
         return lista;
   }       
     
//******************************************************************************************************************************************************        
     public frm_adm_muestra_alumnos_morosos() {
    }
    
}
