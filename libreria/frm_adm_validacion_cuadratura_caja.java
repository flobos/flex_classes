/*
 * frm_adm_validacion_cuadratura_caja.java
 *
 * Created on 17 de octubre de 2007, 9:42
 */

package libreria;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author  Administrador
 */
public class frm_adm_validacion_cuadratura_caja {
    
    /** Creates a new instance of frm_adm_validacion_cuadratura_caja */
    public frm_adm_validacion_cuadratura_caja() {
    }
    

 public static ArrayList<obj_un_campo_string> valida_cuadratura_caja (int envio_caja) {
        ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_valida_cuadratura_caja_valida (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setInt(1, envio_caja);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
      
            lista.add(new obj_un_campo_string(rs.getString("si_no")));
           
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

