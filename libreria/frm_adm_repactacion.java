/*
 * frm_adm_repactacion.java
 *
 * Created on 4 de junio de 2007, 10:11 AM
 */

package libreria;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author  Esteban 
 */
public class frm_adm_repactacion {

    //***********************************************************************************************************                 
        
public static ArrayList<obj_tres_campos> carga_matriculas_alumnos(String alu_rut) {
    ArrayList<obj_tres_campos> lista = new ArrayList<obj_tres_campos>();
        Connection c=null;
         
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_repactacion_por_cuota_carga_matriculas (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, alu_rut.trim());
            ResultSet rs = ps.executeQuery();
            
            while (rs.next())
            {
                lista.add(new obj_tres_campos(rs.getString("mat_idn")
                                            ,rs.getString("mal_nombre")
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
        
public static ArrayList<obj_seis_campos> carga_pagos_atrasados_alumno(String mat_idn) {
    ArrayList<obj_seis_campos> lista = new ArrayList<obj_seis_campos>();
        Connection c=null;
         
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_repactacion_carga_pagos_atrasados_alumno (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, mat_idn.trim());
            ResultSet rs = ps.executeQuery();
            
            while (rs.next())
            {
                lista.add(new obj_seis_campos(rs.getString("pag_idn")
                                                , rs.getString("pag_num_cuota")
                                                , rs.getString("pag_fecha_venc")
                                                , rs.getString("pag_val_cuota")
                                                , rs.getString("deuda_total")
                                                , rs.getString("deuda_pendiente")));
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
        
public static ArrayList<obj_un_campo_string> verifica_posibilidad_repactacion(String mat_idn) {
    ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
        Connection c=null;
         
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_repactacion_verifica_posibilidad_repactacion (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, mat_idn.trim());
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
       
         public static ArrayList<obj_un_campo_string> inserta_repactacion(String mat_idn, String func_mod_fun, ArrayList<?> arreglo_final) {
    
        ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
        Connection c=null;
        try {
        
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_repactacion_elimina_pagos (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,mat_idn.trim());

            ps.execute();
            String sql1;
                
            
            int size = arreglo_final.size();
            obj_cuatro_campos registro = null;             
            
            int j;
         
            for (j=0; j<size; j++) 
               {
                    
                       registro = (obj_cuatro_campos) arreglo_final.get(j);
                        sql1 = "{call flex_adm_repactacion_inserta_repactacion  (?,?,?,?,?)}" ;
                        CallableStatement ps1 = c.prepareCall(sql1);
                        ps1.setString(1, mat_idn.trim());
                        ps1.setString(2,registro.getcampo_uno());
                        ps1.setString(3,registro.getcampo_dos());
                        ps1.setString(4,registro.getcampo_tres());
                        ps1.setString(5,registro.getcampo_cuatro());
                        ps1.execute();
               }
            
                      
            String sql2;
            sql2 = "{call flex_adm_repactacion_inserta_historial (?,?)}" ;
            CallableStatement ps2 = c.prepareCall(sql2);
            ps2.setString(1,mat_idn.trim());
            ps2.setString(2,func_mod_fun.trim());
            ps2.execute();
           
           
           } catch (Exception e) {
            e.printStackTrace();
            lista.add(new obj_un_campo_string("ERROR"));
           
        } finally {
                     
             lista.add(new obj_un_campo_string("OK"));           
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
        
public static ArrayList<obj_cuatro_campos> simula_calcula_cuotas(String alu_rut, int monto_cancela, int cant_cuotas, int n_meses) {
    ArrayList<obj_cuatro_campos> lista = new ArrayList<obj_cuatro_campos>();
        Connection c=null;
         
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_repactacion_simulacion_calcula_cuotas (?,?,?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, alu_rut.trim());
            ps.setInt(2, monto_cancela);
            ps.setInt(3, cant_cuotas);            
            ps.setInt(4, n_meses);  
            ResultSet rs = ps.executeQuery();
            
            
            while (rs.next())
            {
                lista.add(new obj_cuatro_campos(rs.getString("n_cuota")
                                             ,rs.getString("valor_cuota")   
                                             ,rs.getString("fecha_pago")
                                             ,rs.getString("fecha_ultima_cuota")));
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
//***********************************************************************************************************                 
public static ArrayList<obj_un_campo_string> genera_lotes(String lot_monto, String mat_idn, String func_mod_fun_idn) {
    ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
        Connection c=null;
         
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_repactacion_genera_lote (?,?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, lot_monto.trim());
            ps.setString(2, mat_idn.trim());
            ps.setString(3, func_mod_fun_idn.trim());            
            ResultSet rs = ps.executeQuery();
            
            
            while (rs.next())
            {
                lista.add(new obj_un_campo_string(rs.getString("lote")));
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
//***********************************************************************************************************                 
       
     public static ArrayList<obj_un_campo_string> inserta_repactacion_lotes(String mat_idn, String func_mod_fun, ArrayList<?> arreglo_final) {

    ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
    Connection c=null;
    try {

        String sql;
        c = conexion_odbc.Connexion_datos();
        sql = "{call flex_adm_repactacion_elimina_pagos (?)}" ;
        CallableStatement ps = c.prepareCall(sql);
        ps.setString(1,mat_idn.trim());

        ps.execute();
        String sql1;


        int size = arreglo_final.size();
        obj_cinco_campos registro = null;             

        int j;

        for (j=0; j<size; j++) 
           {

                   registro = (obj_cinco_campos) arreglo_final.get(j);
                    sql1 = "{call flex_adm_repactacion_inserta_repactacion_lotes  (?,?,?,?,?,?)}" ;
                    CallableStatement ps1 = c.prepareCall(sql1);
                    ps1.setString(1, mat_idn.trim());
                    ps1.setString(2,registro.getcampo_uno());
                    ps1.setString(3,registro.getcampo_dos());
                    ps1.setString(4,registro.getcampo_tres());
                    ps1.setString(5,registro.getcampo_cuatro());
                    ps1.setString(6,registro.getcampo_cinco());
                    ps1.execute();
           }


        String sql2;
        sql2 = "{call flex_adm_repactacion_inserta_historial (?,?)}" ;
        CallableStatement ps2 = c.prepareCall(sql2);
        ps2.setString(1,mat_idn.trim());
        ps2.setString(2,func_mod_fun.trim());
        ps2.execute();


       } catch (Exception e) {
        e.printStackTrace();
        lista.add(new obj_un_campo_string("ERROR"));

    } finally {

         lista.add(new obj_un_campo_string("OK"));           
        try {
                c.close();
        } catch (SQLException e) {
            e.printStackTrace();


        }
    }
    return lista;
}  
//***********************************************************************************************************                 
    /** Creates a new instance of frm_adm_repactacion */
    public frm_adm_repactacion() {
    }
    
}
