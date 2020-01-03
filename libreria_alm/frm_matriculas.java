/*
 * frm_matriculas.java
 *
 * Created on 16 de enero de 2006, 10:40 AM
 */

package libreria_alm;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author  Esteban
 */
public class frm_matriculas {
//***********************************************************************************************************    
public static ArrayList<obj_diez_campos> muestra_matriculas_por_idn(String alu_idn) {
    
        ArrayList<obj_diez_campos> lista = new ArrayList<obj_diez_campos>();
        Connection c=null;

        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            CallableStatement cs;
            sql = "flex_matricula_promo_malla_muestra '" + alu_idn + "'" ;
            cs = c.prepareCall(sql);
           // cs.setString(1, "633174");
            ResultSet rs = cs.executeQuery();
            
            while (rs.next())
            {
            
                  lista.add(new obj_diez_campos(rs.getString("cod_alum"),
                                     rs.getString("producto"),
                                     rs.getString("nombre_malla"),
                                     rs.getString("codigo_carrera"),
                                     rs.getString("matricula"),
                                     rs.getString("tipo_producto"),  
                                     rs.getString("promo_malla"),
                                     rs.getString("mal_idn"),
                                     rs.getString("inst_edu_rut"),
                                     rs.getString("inst_edu_nombre")
                                     ));
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
public static ArrayList<obj_cuatro_campos> muestra_encuestas_pendientes_por_idn(String alu_idn) {
    
    ArrayList<obj_cuatro_campos> lista = new ArrayList<obj_cuatro_campos>();
    Connection c=null;
 
    try {
        String sql;
        c = conexion_odbc.Connexion_datos();
        CallableStatement cs;
        sql = "select a.enc_eje_mat_idn, d.enc_nombre, b.enc_ver_idn, a.mat_idn from encuestas_ejecucion_matriculas a, encuestas_ejecucion b, encuestas_versiones c, encuestas d " ;
        sql = sql + "where b.enc_eje_fecha_inicio < getdate() and (b.enc_eje_fecha_termino is null or b.enc_eje_fecha_termino > getdate()) and a.enc_eje_idn = b.enc_eje_idn and a.enc_eje_mat_contestada = 0 and b.enc_ver_idn = c.enc_ver_idn and c.enc_idn = d.enc_idn and ";
        sql = sql + "a.mat_idn in (select distinct mat_idn from matriculas where alu_idn = '"+alu_idn.trim()+"') and b.eje_idn not in (select eje_idn from ejecucion where eje_activa = 0) ";
        cs = c.prepareCall(sql);
       // cs.setString(1, "633174");
        ResultSet rs = cs.executeQuery();
        
        while (rs.next())
        {
        
              lista.add(new obj_cuatro_campos(rs.getString("enc_eje_mat_idn"),
                                 rs.getString("enc_nombre"),
                                 rs.getString("enc_ver_idn"),
                                 rs.getString("mat_idn")
                                 ));
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
    /** Creates a new instance of frm_matriculas */
    public frm_matriculas() {
    }
    
}
