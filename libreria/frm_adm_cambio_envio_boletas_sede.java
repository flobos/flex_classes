/*
 * frm_adm_envio_boletas_sede.java
 *
 * Created on 8 de abril de 2008, 10:56 AM
 */

package libreria;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author  Mauricio
 */
public class frm_adm_cambio_envio_boletas_sede {
    
    /** Creates a new instance of frm_adm_envio_boletas_sede */
    public frm_adm_cambio_envio_boletas_sede() {
    }
        public static ArrayList<obj_un_campo_string> verifica_funcionario_sede(String fun_rut) {
            ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
            Connection c=null;
            try {
                String sql;
                c = conexion_odbc.Connexion_datos();
                sql = "{call flex_adm_cambio_envio_boletas_verifica_sede_funcionario (?)}" ;
                CallableStatement ps = c.prepareCall(sql);
                ps.setString(1, fun_rut.trim());
                ResultSet rs = ps.executeQuery();
            
                while (rs.next())
                {
                    lista.add(new obj_un_campo_string(rs.getString("sed_idn")));
                                                
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
        
        public static ArrayList<obj_seis_campos> carga_grilla_envio_boletas(String sed_idn) {
            ArrayList<obj_seis_campos> lista = new ArrayList<obj_seis_campos>();
            Connection c=null;
            try {
                String sql;
                c = conexion_odbc.Connexion_datos();
                sql = "{call envios_boletas_sedes_muestra_envios (?)}" ;
                CallableStatement ps = c.prepareCall(sql);
                ps.setString(1, sed_idn.trim());
                ResultSet rs = ps.executeQuery();
            
                while (rs.next())
                {
                    lista.add(new obj_seis_campos(rs.getString("sed_nombre")
                                              , rs.getString("env_bol_sed_numero")
                                              , rs.getString("env_bol_sed_desde")
                                              , rs.getString("env_bol_sed_hasta")
                                              , rs.getString("env_bol_sed_contador")
                                              , rs.getString("env_bol_sed_fecha_ingreso")));
                                                     
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
        
        public static ArrayList<obj_un_campo_string> verifica_maximo_envio_boletas_sede(String sed_idn) {
            ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
            Connection c=null;
            try {
                String sql;
                c = conexion_odbc.Connexion_datos();
                sql = "{call flex_adm_maximo_envio_boletas_sede (?)}" ;
                CallableStatement ps = c.prepareCall(sql);
                ps.setString(1, sed_idn.trim());
                ResultSet rs = ps.executeQuery();
            
                while (rs.next())
                {
                    lista.add(new obj_un_campo_string(rs.getString("maximo")));
                                                
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
        
    public static ArrayList<obj_un_campo_string> cambio_contador_envio_boletas_sede(String sed_idn, int env_bol_sed_numero, int env_bol_sed_contador) {
    
        ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_adm_cambio_contador_envio_boletas_sede '" + sed_idn + "', '" + env_bol_sed_numero + "','" + env_bol_sed_contador + "'" ;
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            while (rs.next()){
            
      
      
            lista.add(new obj_un_campo_string(rs.getString("identidad")));
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
    
    public static ArrayList<obj_un_campo_string> comprueba_contador_envio_boletas_sede(String num_bol) {
            ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
            Connection c=null;
            try {
                String sql;
                c = conexion_odbc.Connexion_datos();
                sql = "{call flex_adm_comprueba_contador_envio_boletas_sede (?)}" ;
                CallableStatement ps = c.prepareCall(sql);
                ps.setString(1, num_bol.trim());
                ResultSet rs = ps.executeQuery();
            
                while (rs.next())
                {
                    lista.add(new obj_un_campo_string(rs.getString("num_bol")));
                                                
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
}
