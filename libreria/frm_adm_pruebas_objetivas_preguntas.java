/*
 * frm_adm_pruebas_objetivas_preguntas.java
 *
 * Created on 22 de diciembre de 2005, 03:27 PM
 */

package libreria;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author  Esteban
 */
public class frm_adm_pruebas_objetivas_preguntas {
  // ********************************************************************
//  Writed by LoBo !!
//  frm_pruebas_objetivas_preguntas.mxml  ///
// ******************************************************************** 
 
      public static ArrayList<obj_un_campo> pruebas_obj_preguntas_muestra(int prueba) {
    ArrayList<obj_un_campo> lista = new ArrayList<obj_un_campo>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_pruebas_obj_preguntas_ultimo_numero (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setInt(1, prueba);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
      
            lista.add(new obj_un_campo(rs.getInt("numero")));
           
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
//  frm_pruebas_objetivas_preguntas.mxml  ///
// ********************************************************************       
      
  public static ArrayList<obj_un_campo> pruebas_objetivas_preguntas_inserta(int pru_obj_pre_idn ,int codigo , int numero, String pregunta) {
    ArrayList<obj_un_campo> lista = new ArrayList<obj_un_campo>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_pruebas_obj_preguntas_inserta (?,?,?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            
            ps.setInt(1, pru_obj_pre_idn);
            ps.setInt(2, codigo);
            ps.setInt(3, numero);
            ps.setString(4, pregunta.trim());
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                   lista.add(new obj_un_campo(rs.getInt("identidad")));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            lista.remove(0);
            lista.add(new obj_un_campo(0));
            
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
//  frm_pruebas_objetivas_preguntas.mxml  ///
// ********************************************************************  
  
    public static ArrayList<obj_cuatro_campos> pruebas_preguntas_muestra(int codigo) {
    ArrayList<obj_cuatro_campos> lista = new ArrayList<obj_cuatro_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_pruebas_obj_preguntas_muestra (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setInt(1, codigo);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            lista.add(new obj_cuatro_campos(rs.getString("idn"),
                                            rs.getString("numero"), 
                                            rs.getString("pru_obj_pre_pregunta"),
                                            rs.getString("pru_obj_pre_ingreso")));
           
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
  public static ArrayList<obj_un_campo> pruebas_objetivas_preguntas_actualiza(int idn, String pregunta) {
    ArrayList<obj_un_campo> lista = new ArrayList<obj_un_campo>();
    Connection c=null;
    int salida = 1;
    try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_pruebas_obj_preguntas_actualiza (?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setInt(1,idn);
            ps.setString(2,pregunta.trim());
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
// ********************************************************************
//  Writed by LoBo !!
//  frm_pruebas_objetivas_preguntas.mxml  ///
// ********************************************************************   
    public static ArrayList<obj_un_campo> pruebas_objetivas_respuestas_inserta(int pru_obj_res_idn,int idn, String respuesta , boolean correcta) {
    ArrayList<obj_un_campo> lista = new ArrayList<obj_un_campo>();
    Connection c=null;
    int salida = 1;
    try {
                String sql;
                c = conexion_odbc.Connexion_datos();
                sql = "{call flex_adm_pruebas_obj_respuesta_inserta (?,?,?,?)}" ;
                CallableStatement ps = c.prepareCall(sql);
                ps.setInt(1,pru_obj_res_idn);
                ps.setInt(2,idn);
                ps.setString(3,respuesta.trim());
                ps.setBoolean(4,correcta);
                ps.execute();
           } 
        catch (Exception e) 
         {
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
   // ********************************************************************
//  Writed by LoBo !!
//  frm_pruebas_objetivas_preguntas.mxml  ///
// ********************************************************************    
   public static ArrayList<obj_tres_campos> pruebas_respuesta_muestra(int codigo) {
    ArrayList<obj_tres_campos> lista = new ArrayList<obj_tres_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_pruebas_obj_respuesta_muestra (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setInt(1, codigo);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
      
            lista.add(new obj_tres_campos(rs.getString("idn"),
                                          rs.getString("pru_obj_res_respuesta"), 
                                          rs.getString("correcta")));
           
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
//  frm_pruebas_objetivas_preguntas.mxml  ///
// ********************************************************************   
 public static ArrayList<obj_un_campo> pruebas_objetivas_respuestas_borra(int idn) 
 {
    ArrayList<obj_un_campo> lista = new ArrayList<obj_un_campo>();
    Connection c=null;
    int salida = 1;
    try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_pruebas_obj_respuesta_borra (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setInt(1,idn);
            ps.execute();
            
           
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
    /** Creates a new instance of frm_adm_pruebas_objetivas_preguntas */
    public frm_adm_pruebas_objetivas_preguntas() {
    }
    
}
