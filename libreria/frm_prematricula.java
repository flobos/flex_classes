/*
 * frm_adm_chat_ingreso.java
 *
 * Created on 26 de diciembre de 2005, 03:16 PM
 */

package libreria;
import java.util.ArrayList;
import java.io.Serializable;
import java.sql.*;
/**
 *
 * @author  marcelo
 */
public class frm_prematricula {
  //*/*********************************************************************************************************************
    
    
    
      public static ArrayList<obj_dos_campos> muestra_comunas() {
      ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_prematricula_muestra_comunas ()}" ;
            CallableStatement ps = c.prepareCall(sql);
         
                      
            ResultSet rs = ps.executeQuery();
            
             
              lista.add(new obj_dos_campos("0"," - Seleccione - "));
                 
            
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos (rs.getString("seg_div_pol_idn"), 
                                         rs.getString("seg_div_pol_nombre")));
           
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
      
      
       public static ArrayList<Serializable> comprueba_promocion_de_la_malla(String pro_mal_idn
                                                                    , String func_mod_fun_idn
                                                                    
                                                                  
                                                                    ) {
    ArrayList<Serializable> lista = new ArrayList<Serializable>();
        Connection c=null;
         String msg ;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_prematricula_comprueba_promocion_de_la_malla (?,?)}";
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, pro_mal_idn.trim());
            ps.setString(2, func_mod_fun_idn.trim());
            
            ResultSet rs = ps.executeQuery();
        
            while (rs.next()){
            
      
            lista.add(new obj_cinco_campos (rs.getString("pro_mal_idn"), 
                                                rs.getString("mal_mod_idn"), 
                                                rs.getString("mal_nombre"), 
                                                rs.getString("cam_nombre"),
                                                rs.getString("pro_nombre")));
           
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            lista.remove(0);
            msg = e.getMessage();
            lista.add(new obj_un_campo_string(msg));
            
        } finally {
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
                
         return lista;
   }
         
    //-----------------------------------------------------------------------------------------------
        public static ArrayList<obj_un_campo_string> graba_prematricula( String alu_idn
                                                   , String pro_mal_idn
                                                   , String func_mod_fun_idn
                                                   , String env_idn
                                                                    
                                                                    ) {
    ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
        Connection c=null;
         String msg ;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_prematricula_ingresa_prematricula_alumno (?,?,?,?)}";
            CallableStatement ps = c.prepareCall(sql);
           
            ps.setString(1, alu_idn.trim());
            ps.setString(2, pro_mal_idn.trim());   
            ps.setString(3, func_mod_fun_idn.trim());
            ps.setString(4, env_idn.trim());    
           
            
            
            ResultSet rs = ps.executeQuery();
        
            while (rs.next()){
            
      
            lista.add(new obj_un_campo_string(rs.getString("identidad")));
           
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            lista.remove(0);
            msg = e.getMessage();
            lista.add(new obj_un_campo_string(msg));
            
        } finally {
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
                
         return lista;
   }
       
        //-----------------------------------------------------------------------------------------------
        
        
         public static ArrayList<obj_diez_campos> busca_rut_alumno(String alu_rut) {
    
        ArrayList<obj_diez_campos> lista = new ArrayList<obj_diez_campos>();
        Connection c=null;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_adm_prematricula_busca_alumno '" + alu_rut + "'";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
        
            while (rs.next()){
                       
            lista.add(new obj_diez_campos (rs.getString("alu_idn"), 
                                                rs.getString("alu_nombre"), 
                                                rs.getString("alu_ap_paterno"), 
                                                rs.getString("alu_ap_materno"),
                                                rs.getString("seg_div_pol_idn"),
                                                rs.getString("seg_div_pol_nombre"),
                                                rs.getString("alu_fono"), 
                                                rs.getString("alu_email"),
                                                rs.getString("alu_direccion"), 
                                                rs.getString("alu_dir_num")));
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
        //-----------------------------------------------------------------------------------------------
        public static ArrayList<obj_un_campo_string> graba_alumno(String alu_rut
                                                   , String alu_idn
                                                   , String alu_nombre
                                                   , String alu_ap_paterno
                                                   , String alu_ap_materno
                                                   , String seg_div_pol_idn
                                                   , String alu_fono
                                                   , String alu_email
                                                   , String alu_direccion
                                                   , String alu_dir_num
                                                   
                                                                    
                                                                    ) {
    ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
        Connection c=null;
         String msg ;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_prematricula_ingresa_alumno (?,?,?,?,?,?,?,?,?,?)}";
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, alu_rut.trim());
            ps.setString(2, alu_idn.trim());
            ps.setString(3, alu_nombre.trim());
            ps.setString(4, alu_ap_paterno.trim());
            ps.setString(5, alu_ap_materno.trim());
            ps.setString(6, seg_div_pol_idn.trim());
            
             ps.setString(7, alu_fono.trim());
            ps.setString(8, alu_email.trim());
            ps.setString(9, alu_direccion.trim());
            ps.setString(10, alu_dir_num.trim());
          

           
            
            
            ResultSet rs = ps.executeQuery();
        
            while (rs.next()){
            
      
            lista.add(new obj_un_campo_string(rs.getString("identidad")));
           
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            lista.remove(0);
            msg = e.getMessage();
            lista.add(new obj_un_campo_string(msg));
            
        } finally {
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
                
         return lista;
   }
       
        //-----------------------------------------------------------------------------------------------
      
      
      
      public static ArrayList<obj_tres_campos> busca_matriculas_por_rut(String alu_rut) {
    
        ArrayList<obj_tres_campos> lista = new ArrayList<obj_tres_campos>();
        Connection c=null;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_adm_prematricula_busca_matricula_por_rut '" + alu_rut + "'";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            
            //lista.add(new obj_combo_tres_campos("0","0"," - Seleccione - "));     
            
            while (rs.next()){
            
      
      
            lista.add(new obj_tres_campos( rs.getString("mat_idn"), 
                                            rs.getString("car_nombre")
                                            , rs.getString("tip_mat_nombre")));
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
      
    //-----------------------------------------------------------------------------------------------
           //*/*********************************************************************************************************************
    
    
      
      public static ArrayList<Serializable> muestra_promociones(String func_mod_fun_idn) {
    
        ArrayList<Serializable> lista = new ArrayList<Serializable>();
        Connection c=null;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_adm_prematricula_muestra_promociones '" + func_mod_fun_idn + "'";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            
           lista.add(new obj_dos_campos("0"," - Seleccione - "));     
            
            while (rs.next()){
            
      
      
            lista.add(new obj_combo_dos_campos( rs.getString("pro_idn") 
                                           
                                            , rs.getString("pro_nombre")));
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
       ///***************************************************************************************************  
      
      
       public static ArrayList<Serializable> busca_mallas(String func_mod_fun_idn
                                                                    , String pro_idn
                                                                    
                                                                  
                                                                    ) {
    ArrayList<Serializable> lista = new ArrayList<Serializable>();
        Connection c=null;
         String msg ;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_prematricula_busca_mallas (?,?)}";
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, func_mod_fun_idn.trim());
            ps.setString(2, pro_idn.trim());
            
            ResultSet rs = ps.executeQuery();
            lista.add(new obj_dos_campos("0"," - Seleccione - "));   
            while (rs.next()){
            
      
            lista.add(new obj_combo_dos_campos (rs.getString("pro_mal_idn"), 
                                                rs.getString("mal_nombre")));
           
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            lista.remove(0);
            msg = e.getMessage();
            lista.add(new obj_un_campo_string(msg));
            
        } finally {
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
                
         return lista;
   }
         
    //-----------------------------------------------------------------------------------------------
 //***********************************************************************************************************      
   
        public static ArrayList<Serializable> muestra_envios(String pro_idn) {
    
        ArrayList<Serializable> lista = new ArrayList<Serializable>();
        Connection c=null;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_adm_prematricula_muestra_envios '" + pro_idn + "'";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            
           lista.add(new obj_dos_campos("0"," - Seleccione - "));     
            
            while (rs.next()){
            
      
      
            lista.add(new obj_combo_dos_campos( rs.getString("env_idn") 
                                           
                                            , rs.getString("env_numero")));
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
    
          
          
        //-------------------------------------------------------------------------------------------
        /** Creates a new instance of frm_adm_chat_ingreso */
            public frm_prematricula() {
    }
    
}
