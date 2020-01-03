/*
 * frm_adm_pago_elementos_conceptos.java
 *
 * Created on 28 de junio de 2007, 11:09 AM
 */

package libreria;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author  Esteban 
 */
public class frm_adm_pago_elementos_conceptos {
    
 //***********************************************************************************************************      
      public static ArrayList<obj_un_campo_string> carga_alumnos_por_matricula(String matricula) {
    
        ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
        Connection c=null;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_adm_info_mat_busca_alumno_por_matricula '" + matricula + "'";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
        
            while (rs.next()){
            
      
      
            lista.add(new obj_un_campo_string(rs.getString("alu_rut")));
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
      public static ArrayList<obj_cuatro_campos> carga_matriculas_alumno_por_rut(String alu_rut) {
    
        ArrayList<obj_cuatro_campos> lista = new ArrayList<obj_cuatro_campos>();
        Connection c=null;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_adm_pago_elementos_conceptos_carga_matriculas_alumno '" + alu_rut + "'";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
        
            while (rs.next()){
            
      
      
            lista.add(new obj_cuatro_campos(rs.getString("mat_idn")
                                        , rs.getString("mal_nombre")
                                        , rs.getString("alu_idn")
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
  //***********************************************************************************************************      
      public static ArrayList<obj_dos_campos> carga_datos_alumno(String alu_idn) {
    
        ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_adm_solicitudes_carga_datos_alumno '" + alu_idn + "'";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            
            while (rs.next())
            {
                lista.add(new obj_dos_campos(rs.getString("alu_rut")
                                           , rs.getString("alu_nombre")));
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
      public static ArrayList<obj_dos_campos> carga_ejecuciones(int func_mod_fun_idn) {
    
        ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_pago_elementos_conceptos_carga_ejecuciones (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setInt(1, func_mod_fun_idn);
            ResultSet rs = ps.executeQuery();
                      
            lista.add(new obj_dos_campos("0", "-- Seleccione --"));            
            
            while (rs.next())
            {
                lista.add(new obj_dos_campos(rs.getString("eje_idn")
                                           , rs.getString("eje_nombre")));
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
      public static ArrayList<obj_dos_campos> carga_ejecuciones_futuras(String mat_idn, String ele_con_pag_idn) {
    
        ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_pago_elementos_conceptos_carga_ejecuciones_futuras (?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, mat_idn.trim());
            ps.setString(2, ele_con_pag_idn.trim());
            ResultSet rs = ps.executeQuery();
                      
          
            while (rs.next())
            {
                lista.add(new obj_dos_campos(rs.getString("eje_idn")
                                           , rs.getString("eje_nombre")));
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
      public static ArrayList<obj_dos_campos> carga_conceptos() {
    
        ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_adm_pago_elementos_conceptos_carga_conceptos";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            
            lista.add(new obj_dos_campos("0", "-- Seleccione --"));          
            
            while (rs.next())
            {
                lista.add(new obj_dos_campos(rs.getString("con_pag_idn")
                                           , rs.getString("con_pag_nombre")));
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
      public static ArrayList<obj_dos_campos> carga_elementos(String con_pag_idn) {
    
        ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_adm_pago_elementos_conceptos_carga_elementos '" + con_pag_idn + "'";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            
            
            lista.add(new obj_dos_campos("0", "-- Seleccione --")); 
            
            while (rs.next())
            {
                lista.add(new obj_dos_campos(rs.getString("ele_con_pag_idn")
                                           , rs.getString("ele_pag_nombre")));
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
      
public static ArrayList<obj_dos_campos> carga_arancel(String mat_idn, String eje_idn, String ele_con_pag_idn) {
    ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_pago_elementos_conceptos_carga_arancel (?,?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, mat_idn.trim());
            ps.setString(2, eje_idn.trim());
            ps.setString(3, ele_con_pag_idn.trim());
            ResultSet rs = ps.executeQuery();
            
            while (rs.next())
            {
                lista.add(new obj_dos_campos(rs.getString("pro_mal_eje_con_pag_idn")
                                                , rs.getString("pro_mal_eje_con_pag_arancel")));
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
      public static ArrayList<obj_dos_campos> carga_medio_pago() {
    
        ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_adm_pago_elementos_conceptos_carga_medio_pago";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            
            
            lista.add(new obj_dos_campos("0", "-- Seleccione --")); 
            
            while (rs.next())
            {
                lista.add(new obj_dos_campos(rs.getString("med_pag_idn")
                                           , rs.getString("med_pag_nom")));
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
      public static ArrayList<obj_un_campo> verifica_elemento_ejecucion(String mat_idn, String eje_idn, String ele_con_pag_idn) {
    
        ArrayList<obj_un_campo> lista = new ArrayList<obj_un_campo>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_pago_elementos_conceptos_verifica_elemento_ejecucion (?,?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, mat_idn.trim());
            ps.setString(2, eje_idn.trim());
            ps.setString(3, ele_con_pag_idn.trim());
            ResultSet rs = ps.executeQuery();
            
            
 
            
            while (rs.next())
            {
                lista.add(new obj_un_campo(rs.getInt("ele_dat_pag_eje_idn")));
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
    public static ArrayList<obj_un_campo_string> inserta_datos_del_pago( String mat_idn
                                                    , String lbl_arancel
                                                    , String txt_descuento
                                                    , String cmb_medio_pago
                                                    , String cmb_elementos
                                                    , String cmb_ejecucion
                                                    , String df_fecha_pago
                                                    , String func_mod_fun
                                                    , int n_cuotas
                                                    , ArrayList<?> arreglo_ejecucion) {
         ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
        Connection c=null;
        String dat_pag_idn;
        
        dat_pag_idn = "";
        
        try {
        
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_pago_elementos_conceptos_inserta_datos_del_pago (?,?,?,?,?,?,?,?,?)}";
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, mat_idn.trim());
            ps.setString(2,lbl_arancel.trim());
            ps.setString(3,txt_descuento.trim());
            ps.setString(4,cmb_medio_pago.trim());
            ps.setString(5,cmb_elementos.trim());
            ps.setString(6,cmb_ejecucion.trim());
            ps.setString(7,df_fecha_pago.trim());
            ps.setString(8,func_mod_fun.trim());
            ps.setInt(9,n_cuotas);            
            ResultSet rs = ps.executeQuery(); 

  
            while (rs.next())
            {
            	dat_pag_idn = rs.getString("salida");
            }

            

            if(dat_pag_idn.length() < 12)
            {
                if(dat_pag_idn.length() < 10)
                {
                    String sql1;

                    int size = arreglo_ejecucion.size();
                    obj_un_campo_string registro = null;             

                    int j;

                    for(j=0;j<size;j++)
                    {
                        registro = (obj_un_campo_string) arreglo_ejecucion.get(j);

                        sql1 = "{call flex_adm_pago_elementos_conceptos_inserta_pago_ejecucion (?,?)}" ;
                        CallableStatement ps1 = c.prepareCall(sql1);
                        ps1.setString(1, dat_pag_idn.trim());
                        ps1.setString(2, registro.getcampo_uno());
                        ps1.execute();
                    }

                    dat_pag_idn = "OK";                    
                }

            }

            lista.add(new obj_un_campo_string(dat_pag_idn)); 


            
           } catch (Exception e) {
                lista.add(new obj_un_campo_string(e.getMessage())); 
        } finally {
                     
                       
            try {
                    c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            
            
            }
        }
        return lista;
    }  
     //------------------------------------------nuevo---------------------------------------
    
     public static ArrayList<obj_cuatro_campos> muestra_elemento_concepto_segun_matricula(String mat_idn) {
    
        ArrayList<obj_cuatro_campos> lista = new ArrayList<obj_cuatro_campos>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_adm_pago_elementos_conceptos_muestra_elemento_concepto_segun_matricula '" + mat_idn + "'";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            
            
            //lista.add(new obj_dos_campos("0", "-- Seleccione --")); 
            
            while (rs.next())
            {
                lista.add(new obj_cuatro_campos(rs.getString("dat_pag_idn")
                                            , rs.getString("ele_pag_nombre")
                                            , rs.getString("con_pag_nombre")
                                           , rs.getString("ele_con_pag_idn")));
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
    
  //---------------------------------------------------------------------------------
     /*
     
     public static ArrayList elimina_datos_del_pago_y_pago(String dat_pag_idn) {
    ArrayList lista = new ArrayList();
    ArrayList lista_p = new ArrayList();
    Connection c=null;
    int salida = 1;
    String msg;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_pago_elementos_conceptos_elimina_datos_del_pago_y_pago (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,dat_pag_idn);
            ps.execute();
            //------------------------------------------------
            
        
            //------------------------------------------------
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
        //  return lista_p;
   }  
      */
  //---------------------------------------------------------------------------------
   //***********************************************************************************************************      
      
public static ArrayList<obj_un_campo_string> elimina_datos_del_pago_y_pago(String dat_pag_idn, int ele_con_pag_idn) {
    ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
        Connection c=null;
         
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_pago_elementos_conceptos_elimina_datos_del_pago_y_pago (?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, dat_pag_idn.trim());
            ps.setInt(2, ele_con_pag_idn);
           
            ResultSet rs = ps.executeQuery();
            
            while (rs.next())
            {
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
      
  //***********************************************************************************************************     
     
    /** Creates a new instance of frm_adm_pago_elementos_conceptos */
    public frm_adm_pago_elementos_conceptos() {
    }
    
}
