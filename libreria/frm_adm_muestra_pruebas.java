/*
 * frm_adm_chat_ingreso.java
 *
 * Created on 26 de diciembre de 2005, 03:16 PM
 */

package libreria;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author  marcelo
 */
public class frm_adm_muestra_pruebas {
  //*/*********************************************************************************************************************
 ///***************************************************************************************************     
 //***********************************************************************************************************      
      public static ArrayList<obj_siete_campos> adm_muestra_pruebas(String fun_rut) {
    
        ArrayList<obj_siete_campos> lista = new ArrayList<obj_siete_campos>();
        Connection c=null;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_adm_muestra_pruebas '" + fun_rut + "'";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
        
            while (rs.next()){
            
           
             lista.add(new obj_siete_campos (rs.getString("eva_eje_idn"), 
                                                rs.getString("Ramo"),
                                                rs.getString("sec_nombre"),
                                                rs.getString("tip_pru_nombre"),
                                                 rs.getString("tip_jor_nombre"),
                                                 rs.getString("Fecha_evaluacion"),
                                                rs.getString("eva_eje_disponible")));
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
//***********************************************************************************************************      
     
         
         
   
        //-------------------------------------------------------------------------------------------
        /** Creates a new instance of frm_adm_chat_ingreso */
                  public frm_adm_muestra_pruebas() {
    }
    
}
