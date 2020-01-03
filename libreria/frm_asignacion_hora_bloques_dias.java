/*
 * frm_adm_chat_ingreso.java
 *
 * Created on 08 de Enero de 2007
 */

package libreria;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author  marcelo
 */
public class frm_asignacion_hora_bloques_dias {
 ///*******************************************************************************************************************
    public static ArrayList<obj_un_campo_string> carga_modalidad_campus_funcionaro(int func_mod_fun ) {
      ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
        Connection c=null;
        
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            
            sql = "{call flex_asignacion_hora_bloques_dias_modalidad_campus_funcionaro (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setInt(1, func_mod_fun);                                           
            ResultSet rs = ps.executeQuery();
            
           //  lista.add(new obj_dos_campos("0"," - Seleccione - "));   
            
            while (rs.next()){
            
      
           lista.add(new obj_un_campo_string(rs.getString("mod_cam_idn")));
                                           
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
    
    //*/*********************************************************************************************************************
    
  public static ArrayList<obj_tres_campos> muestra_horas() {
      ArrayList<obj_tres_campos> lista = new ArrayList<obj_tres_campos>();
        Connection c=null;
        
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            
            sql = "{call flex_asignacion_hora_bloques_dias_muestra_horas ()}" ;
            CallableStatement ps = c.prepareCall(sql);
                                                       
            ResultSet rs = ps.executeQuery();
            
           //  lista.add(new obj_dos_campos("0"," - Seleccione - "));   
            
            while (rs.next()){
            
      
            lista.add(new obj_tres_campos (rs.getString("hor_idn"), 
                                            rs.getString("hor_desde"), 
                                             rs.getString("hor_hasta")));
           
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
    
    //*/*********************************************************************************************************************
     
     public static ArrayList<obj_dos_campos> muestra_bloques() {
      ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
        
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            
            sql = "{call flex_asignacion_hora_bloques_dias_muestra_bloques ()}" ;
            CallableStatement ps = c.prepareCall(sql);
                                                       
            ResultSet rs = ps.executeQuery();
            
             lista.add(new obj_dos_campos("0"," - Seleccione - "));   
            
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos (rs.getString("bloq_idn"), 
                                            rs.getString("bloq_numero")));
           
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
     //----------------------------------------------------------------------------------------------------------------------
      public static ArrayList<obj_dos_campos> muestra_dias() {
      ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
        
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            
            sql = "{call flex_asignacion_hora_bloques_dias_muestra_dias ()}" ;
            CallableStatement ps = c.prepareCall(sql);
                                                       
            ResultSet rs = ps.executeQuery();
            
             lista.add(new obj_dos_campos("0"," - Seleccione - "));   
            
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos (rs.getString("dia_idn"), 
                                           rs.getString("dia_nombre")));
           
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
         //*/*********************************************************************************************************************
 
  public static ArrayList<obj_dos_campos> muestra_jornada() {
      ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
        
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            
            sql = "{call flex_asignacion_hora_bloques_dias_muestra_jornadas ()}" ;
            CallableStatement ps = c.prepareCall(sql);
                                                       
            ResultSet rs = ps.executeQuery();
            
             lista.add(new obj_dos_campos("0"," - Seleccione - "));   
            
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos (rs.getString("tip_jor_idn"), 
                                            rs.getString("tip_jor_nombre")));
           
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
     //----------------------------------------------------------------------------------------------------------------------
 

 public static ArrayList<?> asigna_horas_bloque_dia(   ArrayList<?> arreglo_seleccionados ,String bloq_idn,String dia_idn, String jornada_idn, int mod_cam_idn) {
    
        ArrayList<?> lista = new ArrayList<Object>();
        Connection c=null;
        try {
            c = conexion_odbc.Connexion_datos();
             String sql1;
              int size = arreglo_seleccionados.size();
              obj_un_campo_string registro = null;
                
            int j;
            for (j=0; j<size; j++) 
               {
                    
                        registro = (obj_un_campo_string) arreglo_seleccionados.get(j);
                        sql1 = "{call flex_asignacion_hora_bloques_dias_asigna (?,?,?,?,?)}" ;
                        CallableStatement ps1 = c.prepareCall(sql1);
                         ps1.setString(1,registro.getcampo_uno());
                         ps1.setString(2,bloq_idn.trim());
                         ps1.setString(3,dia_idn.trim());
                         ps1.setString(4,jornada_idn.trim());
                         ps1.setInt(5,mod_cam_idn);
                         ps1.execute();
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
     
 //-------------------------------------------------------------------------------------------------------------
 
       public static ArrayList<obj_seis_campos> llena_grilla() {
      ArrayList<obj_seis_campos> lista = new ArrayList<obj_seis_campos>();
        Connection c=null;
        
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            
            sql = "{call flex_asignacion_hora_bloques_dias_llena_grilla ()}" ;
            CallableStatement ps = c.prepareCall(sql);
                                                       
            ResultSet rs = ps.executeQuery();
            
             //lista.add(new obj_dos_campos("0"," - Seleccione - "));   
            
            while (rs.next()){
            
      
            lista.add(new obj_seis_campos (rs.getString("hor_blo_idn"), 
                                            rs.getString("hor_desde"),
                                            rs.getString("hor_hasta"),
                                            rs.getString("bloq_numero"), 
                                            rs.getString("dia_nombre"), 
                                            rs.getString("tip_jor_nombre")));
           
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
         //*/*********************************************************************************************************************
 
 
 
   //-------------------------------------------------------------------------------------------------------------
 
       public static ArrayList<obj_cinco_campos> llena_grilla2(int mod_cam_idn, int tip_jor_idn) {
      ArrayList<obj_cinco_campos> lista = new ArrayList<obj_cinco_campos>();
        Connection c=null;
        
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            
            sql = "{call flex_asignacion_hora_bloques_dias_llena_grilla (?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setInt(1, mod_cam_idn);    
            ps.setInt(2, tip_jor_idn);  
            ResultSet rs = ps.executeQuery();
          
            while (rs.next()){
            
      
            lista.add(new obj_cinco_campos (rs.getString("hor_blo_idn"), 
                                            rs.getString("hor_desde"),
                                            rs.getString("hor_hasta"),
                                            rs.getString("bloq_numero"), 
                                            rs.getString("dia_nombre"))); 

           
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
         //*/*********************************************************************************************************************
       
       public static ArrayList<obj_un_campo> elimina_horas_bloque_dia(int hor_blo_idn) {
    ArrayList<obj_un_campo> lista = new ArrayList<obj_un_campo>();
    Connection c=null;
    int salida = 1;
    try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_asignacion_hora_bloques_dias_elimina (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setInt(1,hor_blo_idn);
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
 
      //------------------------------------------------------------------------------------------------------
          public frm_asignacion_hora_bloques_dias() {
    }
    
}
