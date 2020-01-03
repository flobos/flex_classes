/*
 * frm_adm_tutor_info.java
 *
 * Created on 19 de diciembre de 2005, 03:03 PM
 */

package libreria;
import java.util.ArrayList;
import java.io.Serializable;
import java.sql.*;

/**
 *
 * @author  Esteban
 */
public class frm_adm_tutor_info {
//***********************************************************************************************************
      public static ArrayList<obj_cuatro_campos> muestra_fucionario(String cadena) {
    
        ArrayList<obj_cuatro_campos> lista = new ArrayList<obj_cuatro_campos>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
             sql = "flex_adm_funcionario_busca '" + cadena + "'" ;
            cs = c.prepareCall(sql);
           // cs.setString(1, "633174");
            ResultSet rs = cs.executeQuery();
            
            while (rs.next()){
            
      
            lista.add(new obj_cuatro_campos(rs.getString("fun_rut"),
                                            rs.getString("fun_ap_paterno"),
                                            rs.getString("fun_ap_materno"),
                                            rs.getString("fun_nombre")));
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
 // frm_adm_tutor_info.mxml --by.SyOuS
 //***********************************************************************************************************   
   public static ArrayList<Serializable> muestra_tipo_grado() {
    
        ArrayList<Serializable> lista = new ArrayList<Serializable>();
        Connection c=null;

        try {
         
            c = conexion_odbc.Connexion_datos();
            Statement s = c.createStatement();
            ResultSet rs =  s.executeQuery("SELECT tip_gra_idn , tip_gra_nombre FROM tipo_grado ORDER BY  tip_gra_nombre ");
            lista.add(0, "-- Seleccione --");
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos(rs.getString("tip_gra_idn")
                                        ,rs.getString("tip_gra_nombre")));
            
            
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
 // frm_adm_tutor_info.mxml --by.SyOuS
 //***********************************************************************************************************              
   public static ArrayList<Serializable> muestra_institucion_superior() {
    
        ArrayList<Serializable> lista = new ArrayList<Serializable>();
        Connection c=null;

        try {
         
            c = conexion_odbc.Connexion_datos();
            Statement s = c.createStatement();
            ResultSet rs =  s.executeQuery("SELECT ins_sup_idn, ins_sup_nombre, ins_sup_tipo FROM instituciones_superiores ORDER BY ins_sup_nombre");
            lista.add(0," -- Seleccione --");
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos(rs.getString("ins_sup_idn")
                                       , rs.getString("ins_sup_nombre")));
            
            
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
 // frm_adm_tutor_info.mxml --by.SyOuS
 //***********************************************************************************************************   
   
   
    public static ArrayList<obj_cuatro_campos> muestra_funcionario_grado(String rut) {
    
        ArrayList<obj_cuatro_campos> lista = new ArrayList<obj_cuatro_campos>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
             sql = "flex_adm_funcionario_grado_muestra '" + rut + "'" ;
            cs = c.prepareCall(sql);
           // cs.setString(1, "633174");
            ResultSet rs = cs.executeQuery();
            
            while (rs.next()){
            
      
            lista.add(new obj_cuatro_campos(rs.getString("fun_gra_idn"),
                                            rs.getString("tip_gra_nombre"),
                                            rs.getString("fun_gra_descripcion"),
                                            rs.getString("ins_sup_nombre")));
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
 // frm_adm_tutor_info.mxml --by.SyOuS
 //***********************************************************************************************************   
    
   public static void inserta_funcionarios_grados(String rut, int tipo , String descri , int insti) {
    
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "Insert Into funcionario_grado (fun_rut, tip_gra_idn, fun_gra_descripcion, ins_sup_idn, fun_gra_fecha_ingreso) Values (? ,?, rtrim(ltrim(?)) , ?, getdate() )" ;
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1,rut.trim());
            ps.setInt(2,tipo);
            ps.setString(3,descri.trim());
            ps.setInt(4,insti);
            ps.execute();
            //('10000','102',1005)
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
   }

//***********************************************************************************************************
// frm_adm_tutor_info.mxml --by.SyOuS
//***********************************************************************************************************         
     public static void borra_funcionarios_grados(int codigo) {
    
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "Delete funcionario_grado Where fun_gra_idn = ?" ;
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1,codigo);
            ps.execute();
            //('10000','102',1005)
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
   }
     
//***********************************************************************************************************
// frm_adm_tutor_info.mxml --by.SyOuS
//***********************************************************************************************************   
    
    public static void actualiza_horario_funcionario(String rut, String cadena) {
    
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "Update funcionarios set fun_horario_atencion = rtrim(ltrim(?)) Where fun_rut = ltrim(rtrim(?))" ;
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1,cadena.trim());
            ps.setString(2,rut.trim());
            ps.execute();
            //('10000','102',1005)
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
   }
//***********************************************************************************************************
// frm_adm_tutor_info_asigna_eje_aca.mxml --by.RGN 
//***********************************************************************************************************     
  
  
    public static ArrayList<obj_un_campo_string> adm_info_tutor_muestra_horario(String rut) {
    
        ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
             sql = "flex_adm_info_tutor_muestra_horario '" + rut + "'" ;
            cs = c.prepareCall(sql);
           // cs.setString(1, "633174");
            ResultSet rs = cs.executeQuery();
            
            while (rs.next()){
            
      
            lista.add(new obj_un_campo_string(rs.getString("fun_horario_atencion")));
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
  
    /** Creates a new instance of frm_adm_tutor_info */
    public frm_adm_tutor_info() {
    }
    
}
