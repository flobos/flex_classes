package libreria;

import iplacex.conexion_odbc;
//import iplacex.obj_cinco_campos;
//import iplacex.obj_combo_dos_campos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class frm_matricula_adicional {
    public static ArrayList<obj_doce_campos> busca_matriculas_por_rut (String alu_rut) {
        ArrayList<obj_doce_campos> lista = new ArrayList<obj_doce_campos>();
       Connection c=null;
        try {
           String sql;
           c = conexion_odbc.Connexion_datos();
           sql =       "SELECT Matriculas.mat_idn, alumnos.alu_rut, alumnos.alu_nombre + ' ' + alumnos.alu_ap_paterno + ' ' + " ;
           sql = sql + "alumnos.alu_ap_materno AS nombre_alumno, ";
           sql = sql + "antecedentes_contratos.tip_sex_idn, REPLACE(CONVERT(CHAR(10), antecedentes_contratos.alu_fech_nacimiento, 103), '/', '-') as alu_fech_nacimiento, "; 
           sql = sql + "antecedentes_contratos.est_sup_pais_idn, contratos.con_nombre, ";
           sql = sql + "antecedentes_contratos.num_cel_apoderado, antecedentes_contratos.alu_pasaporte, antecedentes_contratos.tipo_res_idn, malla_curricular.mal_nombre, alumnos.alu_nacional "; 
           sql = sql + "FROM Promociones_dela_Malla INNER JOIN ";
           sql = sql + "Matriculas INNER JOIN "; 
           sql = sql + "alumnos ON Matriculas.alu_idn = alumnos.alu_idn ON Promociones_dela_Malla.pro_mal_idn = Matriculas.pro_mal_idn INNER JOIN ";
           sql = sql + "malla_modalidad ON Promociones_dela_Malla.mal_mod_idn = malla_modalidad.mal_mod_idn INNER JOIN ";
           sql = sql + "malla_campus ON malla_modalidad.mal_cam_idn = malla_campus.mal_cam_idn INNER JOIN "; 
           sql = sql + "malla_curricular ON malla_campus.mal_idn = malla_curricular.mal_idn LEFT OUTER JOIN ";
           sql = sql + "antecedentes_contratos INNER JOIN "; 
           sql = sql + "contratos ON antecedentes_contratos.con_idn = contratos.con_idn ON Matriculas.mat_idn = antecedentes_contratos.mat_idn ";
           sql = sql + "WHERE alumnos.alu_rut = '"+alu_rut.trim()+"'";
           CallableStatement ps = c.prepareCall(sql);
           ResultSet rs = ps.executeQuery();
            while (rs.next()){
                lista.add(new obj_doce_campos(rs.getString("mat_idn"),
   						rs.getString("alu_rut"),
   						rs.getString("nombre_alumno"),
   						rs.getString("tip_sex_idn"),
   						rs.getString("alu_fech_nacimiento"),
   						rs.getString("est_sup_pais_idn"),
   						rs.getString("con_nombre"),
   						rs.getString("num_cel_apoderado"),
                        rs.getString("alu_pasaporte"),
                		rs.getString("tipo_res_idn"),
                        rs.getString("mal_nombre"),
                        rs.getString("alu_nacional")));}} 
        catch (Exception e) {
           e.printStackTrace();} 
        finally {
           try {
               c.close(); } 
           catch (SQLException e) {
               e.printStackTrace(); }}
        return lista;}  

    public static ArrayList<obj_doce_campos> busca_matriculas_por_matriculas (String mat_idn) {
        ArrayList<obj_doce_campos> lista = new ArrayList<obj_doce_campos>();
       Connection c=null;
        try {
           String sql;
           c = conexion_odbc.Connexion_datos();
   /*      sql =       "SELECT Matriculas.mat_idn, alumnos.alu_rut, alumnos.alu_nombre + ' ' + " ;
           sql = sql + "alumnos.alu_ap_paterno + ' ' + alumnos.alu_ap_materno AS nombre_alumno, antecedentes_contratos.tip_sex_idn, ";
           sql = sql + "REPLACE(CONVERT(CHAR(10), antecedentes_contratos.alu_fech_nacimiento, 103), '/', '-')  as alu_fech_nacimiento, antecedentes_contratos.est_sup_pais_idn, "; 
           sql = sql + "contratos.con_nombre, antecedentes_contratos.num_cel_apoderado, antecedentes_contratos.alu_pasaporte, antecedentes_contratos.tipo_res_idn, alumnos.alu_nacional  ";
           sql = sql + "FROM antecedentes_contratos INNER JOIN "; 
           sql = sql + "contratos ON antecedentes_contratos.con_idn = contratos.con_idn RIGHT OUTER JOIN ";
           sql = sql + "Matriculas INNER JOIN "; 
           sql = sql + "alumnos ON Matriculas.alu_idn = alumnos.alu_idn ON antecedentes_contratos.mat_idn = Matriculas.mat_idn ";
           sql = sql + "WHERE (Matriculas.mat_idn = '"+mat_idn.trim()+"')";
           CallableStatement ps = c.prepareCall(sql);
           ResultSet rs = ps.executeQuery();
            while (rs.next()){
               lista.add(new obj_once_campos(rs.getString("mat_idn"),
            		   						rs.getString("alu_rut"),
            		   						rs.getString("nombre_alumno"),
            		   						rs.getString("tip_sex_idn"),
            		   						rs.getString("alu_fech_nacimiento"),
            		   						rs.getString("est_sup_pais_idn"),
            		   						rs.getString("con_nombre"),
                                            rs.getString("num_cel_apoderado"),
                                    		rs.getString("alu_pasaporte"),
                                            rs.getString("tipo_res_idn"),
                                            rs.getString("alu_nacional")));}}
                                            */
           sql =  "SELECT Matriculas.mat_idn, alumnos.alu_rut, alumnos.alu_nombre + ' ' + alumnos.alu_ap_paterno + ' ' + ";
           sql = sql + "alumnos.alu_ap_materno AS nombre_alumno, " ;
           sql = sql + "antecedentes_contratos.tip_sex_idn, REPLACE(CONVERT(CHAR(10), antecedentes_contratos.alu_fech_nacimiento, 103), '/', '-') as alu_fech_nacimiento, ";  
           sql = sql + "antecedentes_contratos.est_sup_pais_idn, contratos.con_nombre,  ";
           sql = sql + "antecedentes_contratos.num_cel_apoderado, antecedentes_contratos.alu_pasaporte, antecedentes_contratos.tipo_res_idn,  alumnos.alu_nacional  ,carreras.car_nombre ";
           sql = sql + "FROM Promociones_dela_Malla INNER JOIN " ;
           sql = sql + "Matriculas INNER JOIN   ";
           sql = sql + "alumnos ON Matriculas.alu_idn = alumnos.alu_idn ON Promociones_dela_Malla.pro_mal_idn = Matriculas.pro_mal_idn INNER JOIN "; 
           sql = sql + "malla_modalidad ON Promociones_dela_Malla.mal_mod_idn = malla_modalidad.mal_mod_idn INNER JOIN " ;
           sql = sql + "malla_campus ON malla_modalidad.mal_cam_idn = malla_campus.mal_cam_idn INNER JOIN "  ;
           sql = sql + "malla_curricular ON malla_campus.mal_idn = malla_curricular.mal_idn INNER JOIN   ";
           sql = sql + "carreras ON malla_curricular.car_idn = carreras.car_idn LEFT OUTER JOIN  ";
           sql = sql + "antecedentes_contratos INNER JOIN   ";
           sql = sql + "contratos ON antecedentes_contratos.con_idn = contratos.con_idn ON Matriculas.mat_idn = antecedentes_contratos.mat_idn "; 
           sql = sql + "WHERE (Matriculas.mat_idn = '"+mat_idn.trim()+"')";
           CallableStatement ps = c.prepareCall(sql);
           ResultSet rs = ps.executeQuery();
            while (rs.next()){
               lista.add(new obj_doce_campos(rs.getString("mat_idn"),
            		   						rs.getString("alu_rut"),
            		   						rs.getString("nombre_alumno"),
            		   						rs.getString("tip_sex_idn"),
            		   						rs.getString("alu_fech_nacimiento"),
            		   						rs.getString("est_sup_pais_idn"),
            		   						rs.getString("con_nombre"),
                                            rs.getString("num_cel_apoderado"),
                                    		rs.getString("alu_pasaporte"),
                                            rs.getString("tipo_res_idn"),
                                            rs.getString("alu_nacional"),
                                            rs.getString("car_nombre")));}}                                
        catch (Exception e) {
           e.printStackTrace();}
        finally {
           try {
               c.close();} 
           catch (SQLException e) {
               e.printStackTrace(); }}
        return lista;}  
    
    
    public static ArrayList<obj_dos_campos> rellena_combo_pais (String func_mod_fun_idn) {
        ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
       Connection c=null;
        try {
           String sql;
           c = conexion_odbc.Connexion_datos();
           sql = "SELECT pais_idn, pais_nombre FROM Pais" ;
           CallableStatement ps = c.prepareCall(sql);
           ResultSet rs = ps.executeQuery();
           lista.add(new obj_dos_campos("0", " - Seleccione - "));
            while (rs.next()){
               lista.add(new obj_dos_campos(rs.getString("pais_idn"),
            		   						rs.getString("pais_nombre")));}} 
        catch (Exception e) {
           e.printStackTrace();} 
        finally {
           try {
               c.close();} 
           catch (SQLException e){
               e.printStackTrace();}}
        return lista;}  

    public static ArrayList<obj_dos_campos> rellena_combo_sexo (String func_mod_fun_idn) {
        ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
       Connection c=null;
        try {
           String sql;
           c = conexion_odbc.Connexion_datos();
           sql = "SELECT tip_sex_idn, tip_sex_detalle FROM tipo_sexo" ;
           CallableStatement ps = c.prepareCall(sql);
           ResultSet rs = ps.executeQuery();
           lista.add(new obj_dos_campos("0", " - Seleccione - "));
            while (rs.next()){
               lista.add(new obj_dos_campos(rs.getString("tip_sex_idn"),
            		   						rs.getString("tip_sex_detalle")));}} 
        catch (Exception e) {
        	
           e.printStackTrace();} 
        finally {
           try {
               c.close();} 
           catch (SQLException e){
               e.printStackTrace();}}
        return lista;}  
    
    public static ArrayList<obj_dos_campos> rellena_combo_residencia (String func_mod_fun_idn) {
        ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
       Connection c=null;
        try {
           String sql;
           c = conexion_odbc.Connexion_datos();
           sql = "SELECT tip_res_idn, tip_res_tipo FROM tipo_residencia" ;
           CallableStatement ps = c.prepareCall(sql);
           ResultSet rs = ps.executeQuery();
           lista.add(new obj_dos_campos("0", " - Seleccione - "));
            while (rs.next()){
               lista.add(new obj_dos_campos(rs.getString("tip_res_idn"),
            		   						rs.getString("tip_res_tipo")));}} 
        catch (Exception e) {
        	
           e.printStackTrace();} 
        finally {
           try {
               c.close();} 
           catch (SQLException e){
               e.printStackTrace();}}
        return lista;} 
    
     //******************************************************************************************************************************************************        
    public static ArrayList<obj_un_campo> guarda_datos (String txt_matric, String txt_fecha_nacimiento, String txt_num_contrato, String txt_celular_aval, String cmb_sexo, String cmb_pais_estudios, String residencia, String pasaporte) {
       ArrayList<obj_un_campo> lista = new ArrayList<obj_un_campo>();
       Connection c=null;
        try {
               String sql;
               c = conexion_odbc.Connexion_datos();
               sql = "{call frm_matricula_adicional_grava_datos (?,?,?,?,?,?,?,?)}" ;
               CallableStatement ps1 = c.prepareCall(sql);
               ps1.setString(1, txt_matric.trim());  
               ps1.setString(2, txt_num_contrato.trim());  
               ps1.setString(3, cmb_sexo.trim());  
               ps1.setString(4, txt_fecha_nacimiento.trim());
               ps1.setString(5, cmb_pais_estudios.trim());  
               ps1.setString(6, txt_celular_aval.trim());
               ps1.setString(7, residencia.trim());  
               ps1.setString(8, pasaporte.trim());
               ResultSet rs = ps1.executeQuery();  
               while (rs.next()){
                   lista.add(new obj_un_campo( rs.getString("resp")));}} 
        catch (Exception e) {
           e.printStackTrace();} 
        finally {
           try {
               c.close();} 
           catch (SQLException e) {
               e.printStackTrace();}}
        return lista;}  
    
	public frm_matricula_adicional(){}
	
}
