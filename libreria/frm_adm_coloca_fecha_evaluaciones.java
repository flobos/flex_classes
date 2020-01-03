/*
 * frm_adm_coloca_fecha_evaluaciones.java
 *
 * Created on 10 de octubre de 2006, 04:18 PM
 */

package libreria;
import java.util.ArrayList;
import java.sql.*; 

/**
 *
 * @author  jose
 */
public class frm_adm_coloca_fecha_evaluaciones {
   
     public static ArrayList<obj_dos_campos> carga_ejecucion() {
    
        ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_carga_ejecucion_informe_trabajos ";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            lista.add(new obj_dos_campos("0","Seleccione"));
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos(rs.getString("data")
                                       , rs.getString("label")));
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
//********************************************************************************
     
       public static ArrayList<obj_dos_campos> carga_ejecuciones_academicas(String eje_idn) {
    
        ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_muestra_eje_aca_segun_ejec '" + eje_idn + "'";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            lista.add(new obj_dos_campos("0","Seleccione"));
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos(rs.getString("data")
                                       , rs.getString("label")));
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
    
    //******************************************************************************************************
     public static ArrayList<obj_cuatro_campos> obtiene_evaluaciones (String eje_idn, String eje_aca_idn) {
    
        ArrayList<obj_cuatro_campos> lista = new ArrayList<obj_cuatro_campos>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_muestra_evaluaciones_ejecucion_academica '" + eje_idn + "','" + eje_aca_idn + "'";
            cs = c.prepareCall(sql);
            ResultSet rs = cs.executeQuery();
            
            while (rs.next()){
         
            lista.add(new obj_cuatro_campos(rs.getString("campo_uno")
                                        , rs.getString("campo_dos")
                                        , rs.getString("campo_tres")
                                        , rs.getString("campo_cuatro")));
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
     //*********************************************************************
     
  /*   public static ArrayList inserta_fechas_evaluaciones(ArrayList correccion_fechas) {
    ArrayList lista = new ArrayList();
        Connection c=null;
         
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "select * from biblioteca_virtual_base order by bib_vir_bas_nombre" ;
            CallableStatement ps = c.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            
            lista.add(new obj_dos_campos("", "-- Seleccione --"));
            
            while (rs.next()){
            
      
             lista.add(new obj_dos_campos(rs.getString("bib_vir_bas_idn"),
                                            rs.getString("bib_vir_bas_nombre")));
           
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
   }*/
   
   //**********************************************************************************
 public static ArrayList<?> inserta_fechas_evaluaciones(ArrayList<?> correccion_fechas) {
        Connection c=null;
        
        ArrayList<?> lista = new ArrayList<Object>();
        try 
        {   
            c = conexion_odbc.Connexion_datos();
            if (correccion_fechas.size() > 0)
            { 
                int i;
                int size = correccion_fechas.size();
                obj_tres_campos registro = null;
                
                String sql;
                i=0;
                for (i=0; i<size; i++) 
               {
                 
                        registro = (obj_tres_campos)correccion_fechas.get(i);
                         c = conexion_odbc.Connexion_datos();
                         sql = "{call flex_inserta_fechasmax_trabajo_nota (?,?,?)}" ;
                         CallableStatement ps = c.prepareCall(sql);
                         ps.setString(1,registro.getcampo_uno());
                         ps.setString(2,registro.getcampo_dos());
                         ps.setString(3,registro.getcampo_tres());
                         ps.execute();
                }
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
 
    
    
    
    /** Creates a new instance of frm_adm_coloca_fecha_evaluaciones */
    public frm_adm_coloca_fecha_evaluaciones() {
    }
    
}
