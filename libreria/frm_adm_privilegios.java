/*
 * frm_adm_privilegios.java
 *
 * Created on 20 de diciembre de 2005, 11:13 AM
 */

package libreria;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author  Esteban
 */
public class frm_adm_privilegios {
 //***********************************************************************************************************
 // frm_privilegios_popup_funcionarios  RGN
 //      
 //***********************************************************************************************************           
     
public static ArrayList<obj_dos_campos> muestra_fucionario_privilegios(String cadena) {
    
        ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
             sql = "flex_adm_funcionario_privilegios_busca '" + cadena + "'" ;
            cs = c.prepareCall(sql);
           // cs.setString(1, "633174");
            ResultSet rs = cs.executeQuery();
            while (rs.next())
            {
                 lista.add(new obj_dos_campos( rs.getString("fun_rut")
                                                                , rs.getString("nombre")));
                 
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
    
 //******************************************************************** 
  ////////  Writed by RGN !! frm_privilegios
  //********************************************************************
  
  public static ArrayList<obj_cuatro_campos> busca_privilegios_no_asignados_a_funcionario(String fun_rut) {
    
        ArrayList<obj_cuatro_campos> lista = new ArrayList<obj_cuatro_campos>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
           sql = "flex_busca_privilegios_no_asignados_a_funcionario '" + fun_rut + "'";
            cs = c.prepareCall(sql);
           // cs.setString(1, "633174");
            ResultSet rs = cs.executeQuery();
            
            while (rs.next()){
            
      
            lista.add(new obj_cuatro_campos(rs.getString("data")
                                                , rs.getString("label1")
                                                , rs.getString("label2")
                                                , rs.getString("label3")));
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
  //******************************************************************** 
  ////////  Writed by RGN !! frm_privilegios
  //********************************************************************
  

  
    public static ArrayList<obj_cuatro_campos> busca_privilegios_asignados_a_funcionario(String fun_rut) {
    
        ArrayList<obj_cuatro_campos> lista = new ArrayList<obj_cuatro_campos>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
           sql = "flex_busca_privilegios_asignados_a_funcionario '" + fun_rut + "'";
            cs = c.prepareCall(sql);
           // cs.setString(1, "633174");
            ResultSet rs = cs.executeQuery();
            
            while (rs.next()){
            
      
            lista.add(new obj_cuatro_campos(rs.getString("data")
                                            , rs.getString("label1")
                                            , rs.getString("label2")
                                            , rs.getString("label3")));
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
 //******************************************************************** 
  ////////  Writed by RGN !! frm_privilegios
  //********************************************************************
  
   
     public static ArrayList<obj_un_campo>  envia_privilegios_para_agregar(ArrayList<?> arreglo, String fun_rut) 
     {
        
        ArrayList<obj_un_campo> lista = new ArrayList<obj_un_campo>();
        int salida = 1;
        Connection c=null;
        String sql;
      
        try {

                int size= arreglo.size();
                int i;
                for (i=0; i<size; i++) 
                {
                        c = conexion_odbc.Connexion_datos();
                        sql = "{call flex_privilegios_agrega (?,?)}" ;
                        CallableStatement ps = c.prepareCall(sql);
                        ps.setString(1,arreglo.get(i).toString().trim());
                        ps.setString(2,fun_rut);
                        ps.execute();
                }
           } 
         catch (Exception e) 
            {
                e.printStackTrace();
                salida = 0;
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
        
        if (salida == 1)
            {
            lista.add(new obj_un_campo(1));
            }
        else
            {
                lista.add(new obj_un_campo(0));
            }
        
         return lista;
    }
  
  //******************************************************************** 
  ////////  Writed by RGN !! frm_privilegios
  //********************************************************************
     
     
     public static void  envia_privilegios_para_borrar(ArrayList<?> arreglo, String fun_rut) {
        Connection c=null;
        String sql;
        try {
            int size= arreglo.size();
            int i;
            for (i=0; i<size; i++) 
            {
                    c = conexion_odbc.Connexion_datos();
                    sql = "{call flex_privilegios_borra (?,?)}" ;
                    CallableStatement ps = c.prepareCall(sql);
                    ps.setString(1,arreglo.get(i).toString().trim());
                    ps.setString(2,fun_rut);
                    ps.execute();
                    c.close();
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
    }     
    //********************************************************************  
     
     
    /** Creates a new instance of frm_adm_privilegios */
    public frm_adm_privilegios() {
    }
    
}
