/*
 * frm_adm_sube_pruebas_tutor.java
 *
 * Created on 5 de enero de 2006, 03:22 PM
 */

package libreria;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author  Esteban
 */
public class frm_adm_sube_pruebas_tutor {
   public static ArrayList<obj_siete_campos> prueba_sube_tutor_muestra_pruebas(String ejecucion_aca) {
      ArrayList<obj_siete_campos> lista = new ArrayList<obj_siete_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_prueba_sube_tutor_muesta_pruebas (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,ejecucion_aca.trim());
                      
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
      
            lista.add(new obj_siete_campos (rs.getString("eva_eje_idn"), 
                                             rs.getString("tip_pru_nombre"), 
                                             rs.getString("eva_eje_ponderacion"), 
                                             rs.getString("eva_eje_fecha"),
                                             rs.getString("eva_eje_archivo_web"), 
                                             rs.getString("eva_eje_fecha_subida_archivo"), 
                                             ""));
           
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
    














public static ArrayList<obj_dos_campos> prueba_sube_tutor_actualiza_archivo(String eva_eje_idn , String Archivo,String puntaje_total, String porcentaje_aprob) {
    ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
        String msg;
        msg = "OK";
        int salida = 1;
       
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_prueba_sube_tutor_actualiza_archivo (?,?,?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,eva_eje_idn .trim());
            ps.setString(2,Archivo.trim()); 
            ps.setString(3,puntaje_total.trim());
            ps.setString(4,porcentaje_aprob.trim());
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
//////////////////////////////////////////////

//////////////////////////////////////////////
       public static ArrayList<obj_un_campo_string> comprueba_fecha_subida_prueba(String eva_eje_idn) {
      ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_comprueba_fecha_subida_prueba_tutor (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,eva_eje_idn.trim());
                      
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
      
           lista.add(new obj_un_campo_string(rs.getString("campo_uno")));
           
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
//////////////////////////////////////////////


/*public static ArrayList ro_guarda_preguntas_pruebas_tutor(String pregunta
                                                         , String puntaje
                                                         , String codigo
                                                         , String ruta
                                                         , String aprobacion)
     {
        
        ArrayList lista = new ArrayList();
        int salida = 1;
         String msg;
        Connection c=null;
        String sql;
      
        try 
        {
            c = conexion_odbc.Connexion_datos();
                      
           sql = "flex_inserta_preguntas_pruebas_tutor '" + pregunta + "', '" + puntaje + "',  '" + codigo + "', '" + ruta + "', '" + aprobacion + "'";
                    
           CallableStatement ps = c.prepareCall(sql);
                       
           ps.execute();
        } 
        
         catch (Exception e) 
            {
                e.printStackTrace();
                salida = 0;
                msg = e.getMessage();
                lista.add(new obj_dos_campos("0",msg));
                
            }
         finally
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
        
        if (salida == 1){
            lista.add(new obj_dos_campos("1","Ok"));
        }
         return lista;
    }*/
////////////////////////////////////////////////
       public void ro_guarda_preguntas_pruebas_tutor(ArrayList<?> correccion ) 
     {
        int salida = 1;
         Connection c=null;
        String sql;
      
        try {   
            
               int size = correccion.size();
                obj_tres_campos registro = null;
                
                int i;
                for (i=0; i<size; i++) 
                {
                    
                    registro = (obj_tres_campos) correccion.get(i);
                        c = conexion_odbc.Connexion_datos();
                        sql = "{call flex_inserta_preguntas_pruebas_tutor (?,?,?)}" ;
                        CallableStatement ps = c.prepareCall(sql);
                        ps.setString(1,registro.getcampo_uno());
                        ps.setString(2,registro.getcampo_dos());
                        ps.setString(3,registro.getcampo_tres());
                       // ps.setString(4,registro.getcampo_cuatro());
                       // ps.setString(5,registro.getcampo_cinco());
                        ps.execute();
                }
           } 
         catch (Exception e) 
            {
                e.printStackTrace();
                salida = 0;
                e.getMessage();
             
                
            }
         finally
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
        
        if (salida == 1){
            
        }
         
    }     
       
       
       
/////////////////////////////////////////////////


    
    /** Creates a new instance of frm_adm_sube_pruebas_tutor */
    public frm_adm_sube_pruebas_tutor() {
    }
    
}
