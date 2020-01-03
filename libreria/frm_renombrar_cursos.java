/*
 * frm_adm_chat_ingreso.java
 *
 * Created on 12 de Febrero de 2007, 10:59 AM
 */

package libreria;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author  marcelo
 */
public class frm_renombrar_cursos {
  
    //*/*********************************************************************************************************************
 
     public static ArrayList<obj_seis_campos> busca_cursos_por_codigo(String codigo) {
      ArrayList<obj_seis_campos> lista = new ArrayList<obj_seis_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_busca_cursos_por_codigo(?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,codigo.trim());
                      
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
      
            lista.add(new obj_seis_campos (rs.getString("cur_idn"), 
                                             rs.getString("cur_nombre"), 
                                             rs.getString("cur_fecha_ingreso"), 
                                             rs.getString("cur_abreviacion_interna"),
                                             rs.getString("cur_abreviacion_sence"),
                                             rs.getString("cur_descripcion")));
           
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
   
    
    
    
    ///***************************************************************************************************     
 
    
    
     public static ArrayList<obj_un_campo> cursos_modifica_datos(String cur_idn
                                                    , String cur_nombre 
                                                    , String cur_fecha_ingreso
                                                    , String cur_abreviacion_interna
                                                    , String cur_abreviacion_sence
                                                    , String cur_descripcion)
   {
    ArrayList<obj_un_campo> lista = new ArrayList<obj_un_campo>();
        Connection c=null;
         int salida = 1;
        try {
  
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_cursos_modifica_datos (?,?,?,?,?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,cur_idn.trim());
            ps.setString(2,cur_nombre.trim());
            ps.setString(3,cur_fecha_ingreso.trim());
            ps.setString(4,cur_abreviacion_interna.trim());
            ps.setString(5,cur_abreviacion_sence.trim());
            ps.setString(6,cur_descripcion.trim());
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
   
    
    
    //***********************************************************************************************************      

         
   
        //-------------------------------------------------------------------------------------------
       
                  public frm_renombrar_cursos() {
    }
    
}
