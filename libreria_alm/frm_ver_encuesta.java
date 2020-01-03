
package libreria_alm;
import java.util.ArrayList;

import java.sql.*;

import libreria.conexion_odbc;
import libreria.obj_tres_campos;



public class frm_ver_encuesta {
	
	//******************************************************************************************************************************************************    
    public static ArrayList<obj_tres_campos> cargar_categorias (String enc_ver_idn) {
        ArrayList<obj_tres_campos> lista = new ArrayList<obj_tres_campos>();
       Connection c=null;
        try {
           String sql;
           c = conexion_odbc.Connexion_datos();
           sql = "select distinct c.enc_nombre, a.enc_cat_idn, b.enc_ver_encabezado ";
           sql = sql + "from encuestas_preguntas_respuestas a, encuestas_versiones b, encuestas c ";
           sql = sql + "where a.enc_ver_idn = b.enc_ver_idn and b.enc_idn = c.enc_idn and a.enc_ver_idn = "+enc_ver_idn+"  ";
           sql = sql + "order by a.enc_cat_idn asc ";
           CallableStatement ps = c.prepareCall(sql);
           ResultSet rs = ps.executeQuery();
           
           
            while (rs.next()){
           
               lista.add(new obj_tres_campos(rs.getString("enc_nombre"),
            		   						rs.getString("enc_cat_idn"),
            		   						rs.getString("enc_ver_encabezado")));
           }
       } catch (Exception e) {
           e.printStackTrace();
       } finally 
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
        return lista;
  }  
  //******************************************************************************************************************************************************    
    public static ArrayList<obj_tres_campos> cargar_preguntas (String enc_cat_idn,String enc_ver_idn) {
        ArrayList<obj_tres_campos> lista = new ArrayList<obj_tres_campos>();
       Connection c=null;
        try {
           String sql;
           c = conexion_odbc.Connexion_datos();
           sql = "select distinct b.enc_cat_contenido, a.enc_pre_idn, count(c.enc_res_idn) as num_respuestas ";
           sql = sql + "from encuestas_preguntas_respuestas a, encuestas_categorias b, encuestas_respuestas c ";
           sql = sql + "where a.enc_cat_idn = b.enc_cat_idn and a.enc_res_idn = c.enc_res_idn and a.enc_ver_idn = "+enc_ver_idn+" and a.enc_cat_idn = "+enc_cat_idn+"  ";
           sql = sql + "group by b.enc_cat_contenido, a.enc_pre_idn ";
           CallableStatement ps = c.prepareCall(sql);
           ResultSet rs = ps.executeQuery();
           
           
            while (rs.next()){
           
               lista.add(new obj_tres_campos(rs.getString("enc_cat_contenido"),
            		   						rs.getString("enc_pre_idn"),
            		   						rs.getString("num_respuestas")));
           }
       } catch (Exception e) {
           e.printStackTrace();
       } finally 
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
        return lista;
  }  
	//******************************************************************************************************************************************************    
    public static ArrayList<obj_un_campo_string> cargar_pregunta (String enc_pre_idn) {
        ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
       Connection c=null;
        try {
           String sql;
           c = conexion_odbc.Connexion_datos();
           sql = "select enc_pre_contenido from encuestas_preguntas where enc_pre_idn = "+enc_pre_idn.trim() +" " ;
           CallableStatement ps = c.prepareCall(sql);
           ResultSet rs = ps.executeQuery();
           
           
            while (rs.next()){
           
               lista.add(new obj_un_campo_string(rs.getString("enc_pre_contenido")));
           }
       } catch (Exception e) {
           e.printStackTrace();
       } finally 
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
        return lista;
  } 
  //******************************************************************************************************************************************************
  public static ArrayList<?> guarda_respuestas_old(String mat_idn, ArrayList<?> respuestas, String enc_eje_mat_idn ) {
        
        ArrayList<?> lista = new ArrayList<Object>();
        Connection c=null;
        try {
             String sql;
             int size = respuestas.size();
         String registro = null;
                
            int j;
            for (j=0; j<size; j++) 
               {
                       c = conexion_odbc.Connexion_datos();
                       registro = (String)respuestas.get(j);
                       
                       sql = "insert into encuestas_respuestas_matriculas(enc_pre_res_idn,mat_idn,enc_res_mat_fecha) values ("+registro.trim()+", '"+mat_idn.trim()+"', getdate()) ";
                       CallableStatement ps = c.prepareCall(sql);
                       ps.execute();
               }
            
            sql = "update encuestas_ejecucion_matriculas set enc_eje_mat_contestada = 1 where enc_eje_mat_idn = "+enc_eje_mat_idn.trim()+" ";
            CallableStatement ps1 = c.prepareCall(sql);
            ps1.execute();        
           
            
            
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
//******************************************************************************************************************************************************
  public static ArrayList<?> guarda_respuestas(String mat_idn, ArrayList<?> respuestas, String enc_eje_mat_idn ) {
        
        ArrayList<?> lista = new ArrayList<Object>();
        Connection c=null;
        try {
             String sql;
             int size = respuestas.size();
         libreria.obj_dos_campos registro = null;
                
            int j;
            for (j=0; j<size; j++) 
               {
                       c = conexion_odbc.Connexion_datos();
                       registro = (libreria.obj_dos_campos)respuestas.get(j);
                       System.out.print("as\n");
                       sql = "insert into encuestas_respuestas_matriculas(enc_pre_res_idn,mat_idn,enc_res_mat_fecha,enc_res_mat_res_desarrollo ) values ("+registro.getdata().trim()+", '"+mat_idn.trim()+"', getdate(),'"+registro.getlabel().trim()+"') ";
                       CallableStatement ps = c.prepareCall(sql);
                       ps.execute();
               }
            
            sql = "update encuestas_ejecucion_matriculas set enc_eje_mat_contestada = 1 where enc_eje_mat_idn = "+enc_eje_mat_idn.trim()+" ";
            CallableStatement ps1 = c.prepareCall(sql);
            ps1.execute();        
           
            
            
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
  //******************************************************************************************************************************************************    
    public static ArrayList<obj_cinco_campos> busca_respuestas (String enc_pre_idn, String enc_ver_idn, String enc_cat_idn) {
        ArrayList<obj_cinco_campos> lista = new ArrayList<obj_cinco_campos>();
       Connection c=null;
        try {
           String sql;
           c = conexion_odbc.Connexion_datos();
           sql = "select a.enc_pre_res_idn, b.enc_res_idn, b.enc_res_contenido, b.enc_res_valor ";
           sql = sql + "from encuestas_preguntas_respuestas a, encuestas_respuestas b ";
           sql = sql + "where a.enc_res_idn = b.enc_res_idn and a.enc_pre_idn = "+enc_pre_idn.trim()+" and a.enc_ver_idn = "+enc_ver_idn+" and a.enc_cat_idn = "+enc_cat_idn+"  ";
           sql = sql + "order by b.enc_res_valor " ;
           CallableStatement ps = c.prepareCall(sql);
           ResultSet rs = ps.executeQuery();
           
           
            while (rs.next()){
           
               lista.add(new obj_cinco_campos(rs.getString("enc_pre_res_idn"),
            		   							rs.getString("enc_res_idn"),
            		   							rs.getString("enc_res_contenido"),
            		   							rs.getString("enc_res_valor"),
            		   							enc_pre_idn));
           }
       } catch (Exception e) {
           e.printStackTrace();
       } finally 
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
        return lista;
  }  
/** Creates a new instance of frm_ver_encuesta */
public frm_ver_encuesta() {
}

}