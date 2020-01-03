/*
 * frm_biblioteca_material_bibiloteca.java
 *
 * Created on 5 de junio de 2008, 17:51
 */

package libreria;
import java.util.ArrayList;
import java.sql.*;



import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author  villanueva
 */
public class frm_biblioteca_material_bibiloteca {
  
    
    public frm_biblioteca_material_bibiloteca() {
    }
    
//**********************************************************
    public static ArrayList<obj_combo_dos_campos> llena_combo_tipo_material() {
      ArrayList<obj_combo_dos_campos> lista = new ArrayList<obj_combo_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_biblioteca_material_bibiloteca_llena_combo_tipo_material}" ;
            CallableStatement ps = c.prepareCall(sql);
                                  
            ResultSet rs = ps.executeQuery();
             lista.add(new obj_combo_dos_campos ("0", "-- Seleccione --"));
            while (rs.next()){
                  
            lista.add(new obj_combo_dos_campos (rs.getString("tip_mat_bib_idn"), 
                                                rs.getString("tip_mat_bib_nombre")));
           
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
    //**********************************************************
    public static ArrayList<obj_combo_dos_campos> llena_combo_tipo_autor() {
      ArrayList<obj_combo_dos_campos> lista = new ArrayList<obj_combo_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_biblioteca_material_bibiloteca_llena_combo_tipo_autor}" ;
            CallableStatement ps = c.prepareCall(sql);
                                  
            ResultSet rs = ps.executeQuery();
             lista.add(new obj_combo_dos_campos ("0", "-- Seleccione --"));
            while (rs.next()){
                  
            lista.add(new obj_combo_dos_campos (rs.getString("tip_aut_idn"), 
                                                rs.getString("tip_aut_nombre")));
           
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
//**********************************************************************
 //**************************************************************************
    
    
   
 public static ArrayList<obj_dos_campos> guarda_datos_material(String func_mod_fun_idn,String mat_tit_idn,String mat_bib_edicion,String tip_mat_bib_idn) {
    ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
        String msg;
        msg = "OK";
        int salida = 1;
       
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_biblioteca_material_bibiloteca_guarda_datos_material (?,?,?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,func_mod_fun_idn .trim());
            ps.setString(2,mat_tit_idn.trim()); 
            ps.setString(3,mat_bib_edicion.trim());
            ps.setString(4,tip_mat_bib_idn.trim());
            ps.execute();
            
        } catch (Exception e) {
            e.printStackTrace();
           
            msg = e.getMessage();
            salida = 0;
            
        } finally {
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        if (salida == 1){
        lista.add(new obj_dos_campos("1", msg));
        }else{
        lista.add(new obj_dos_campos("0", msg));
        }
        
         return lista;
   } 
 //****************************************************************************
 
 public static ArrayList<obj_dos_campos> llena_repeter_etiquetas() {
      ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_biblioteca_material_bibiloteca_llena_repeter_etiquetas()}" ;
            CallableStatement ps = c.prepareCall(sql);
                             
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
                  
            lista.add(new obj_dos_campos (rs.getString("eti_idn"), 
                                                rs.getString("eti_nombre")
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
  //***************************************************************************
 //***************************************************************************
 //***************************************************************************
 //***************************************************************************
 //***************************************************************************
 //***************************************************************************
 //***************************************************************************
 //***************************************************************************
 //***************************************************************************
 
 
   public static ArrayList<obj_un_campo_string> guarda_material_biblioteca( String funcionario
                                                       , String codigo_titulo
                                                       , String edicion_titulo
                                                       , String dewey
                                                       ,String cutter
                                                       ,String anio
                                                       ,String volumen
                                                       ,String editorial
                                                       ,String descripcion
                                                       ,String tipo_standar
                                                       ,String tipo_material_titulo
                                                       ,String resumen
                                                       ,String codigo_tipo_estandar
                                                       ,ArrayList<?> arreglo_etiquetas
                                                       , ArrayList<?> arreglo_autores
                                                       ,ArrayList<?> arreglo_contenido
                                                       ,int copias) {
    ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
        Connection c=null;
        try {
        
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_biblioteca_material_bibiloteca_guarda_datos_material (?,?,?,?,?,?,?,?,?,?,?,?,?)}";
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, funcionario.trim());
            ps.setString(2, codigo_titulo.trim());
            ps.setString(3, edicion_titulo.trim());
            ps.setString(4, tipo_material_titulo.trim());
            ps.setString(5, anio.trim());
            ps.setString(6, resumen.trim());
            
            ps.setString(7, descripcion.trim());
            ps.setString(8, tipo_standar.trim());
            ps.setString(9, dewey.trim());
            ps.setString(10, cutter.trim());
            ps.setString(11, volumen.trim());
            ps.setString(12, editorial.trim());
            
             ps.setString(13, codigo_tipo_estandar.trim());      
            ResultSet rs = ps.executeQuery(); 

  
            while (rs.next())
            {
            	  lista.add(new obj_un_campo_string(rs.getString("salida")));
            }

           

            
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
//***************************************************************************
  //***************************************************************************
  //***************************************************************************
  //***************************************************************************
   
      public static ArrayList<?> guarda_etiquetas_material(  String eje_idn,  ArrayList<?> arreglo_etiquetas) {
    
        ArrayList<?> lista = new ArrayList<Object>();
        Connection c=null;
        try {
            c = conexion_odbc.Connexion_datos();
             String sql1;
              int size = arreglo_etiquetas.size();
              obj_un_campo_string registro = null;
                
            int j;
            for (j=0; j<size; j++) 
               {
                    
                        registro = (obj_un_campo_string) arreglo_etiquetas.get(j);
                        sql1 = "{call frm_biblioteca_material_bibiloteca_guarda_etiquetas_material (?,?)}" ;
                        CallableStatement ps1 = c.prepareCall(sql1);
                         ps1.setString(1,eje_idn.trim());
                         ps1.setString(2,registro.getcampo_uno());
                         
                         ps1.execute();
                         
                                             
                         
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
     
   //--------------------------------------------------------------------------
      
      
 //-------------------------------------------------------------------------------------------------------------
 
    ///////////////////////////////////////////////////////////////////////////////        
       public static ArrayList<?> guarda_autores_material(  String material_insertado,  ArrayList<?> arreglo_autores) {
    
        ArrayList<?> lista = new ArrayList<Object>();
        Connection c=null;
        try {
              String sql1;
              int size = arreglo_autores.size();
              obj_dos_campos registro = null;
              
            int j;
            for (j=0; j<size; j++) 
               {
                    
                       registro = (obj_dos_campos) arreglo_autores.get(j);
                       
                       c = conexion_odbc.Connexion_datos();
                       sql1 = "{call frm_biblioteca_material_bibiloteca_guarda_autores_material (?,?,?)}" ;
                        CallableStatement ps1 = c.prepareCall(sql1);
                         
                        ps1.setString(1, registro.getlabel() );
                        ps1.setString(2, registro.getdata() );
                        ps1.setString(3, material_insertado);
                                           
                        ps1.execute();
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
    
    
    
   //-------------------------------------------------------------------------
       ////////
        //***************************************************************************
   
      public static ArrayList<?> guarda_material_contenido(  String material_insertado,  ArrayList<?> arreglo_contenidos) {
    
        ArrayList<?> lista = new ArrayList<Object>();
        Connection c=null;
        try {
            c = conexion_odbc.Connexion_datos();
             String sql1;
              int size = arreglo_contenidos.size();
              obj_un_campo_string registro = null;
                
            int j;
            for (j=0; j<size; j++) 
               {
                    
                        registro = (obj_un_campo_string) arreglo_contenidos.get(j);
                        sql1 = "{call frm_biblioteca_material_bibiloteca_guarda_material_contenido (?,?)}" ;
                        CallableStatement ps1 = c.prepareCall(sql1);
                         ps1.setString(1,material_insertado.trim());
                         ps1.setString(2,registro.getcampo_uno());
                         
                         ps1.execute();
                         
                                             
                         
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
     
   //--------------------------------------------------------------------------
      public static ArrayList<obj_dos_campos> guarda_material_coleccion(int copias
                                                        ,String material_insertado
                                                        ,String funcionario) {
    ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
        String msg;
        msg = "OK";
        int salida = 1;
       
        try {
             String sql2;
                          
            int p;
            for (p=0;  p < copias; p++) 
               {
                    
                   
                       
                       c = conexion_odbc.Connexion_datos();
                       sql2 = "{call frm_biblioteca_material_bibiloteca_guarda_material_coleccion (?,?)}" ;
                        CallableStatement ps2 = c.prepareCall(sql2);
                         
                        ps2.setString(1, material_insertado);
                        ps2.setString(2, funcionario);
                       
                                           
                        ps2.execute();
               }
            
            
            
        } catch (Exception e) {
            e.printStackTrace();
           
            msg = e.getMessage();
            salida = 0;
            
        } finally {
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        if (salida == 1){
        lista.add(new obj_dos_campos("1", msg));
        }else{
        lista.add(new obj_dos_campos("0", msg));
        }
        
         return lista;
   } 
 
      ////////////////////////////////////////////////*/*/*/*/*/*/*/*/*/*/*-*-*/*/
       
       ///////
            
            
            
              
              
              
            ////  
              
                ///////////  
    
    
    
    
  //***************************************************************************
  //***************************************************************************
  //***************************************************************************
 //**************************************************************************
 public static ArrayList<obj_dos_campos> agrega_etiqueta(String eti_nombre) {
    ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
        String msg;
        msg = "OK";
        int salida = 1;
       
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_biblioteca_material_bibiloteca_agrega_etiqueta (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,eti_nombre .trim());
           
            ps.execute();
            
        } catch (Exception e) {
            e.printStackTrace();
           
            msg = e.getMessage();
            salida = 0;
            
        } finally {
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        if (salida == 1){
        lista.add(new obj_dos_campos("1", msg));
        }else{
        lista.add(new obj_dos_campos("0", msg));
        }
        
         return lista;
   } 


 //*********************************************************************
 


	public static String  llena_combo_fecha() {

	  
	   
	   Calendar calendario = new GregorianCalendar(); 
	   
	   String annio;
	   
	 
	   annio = Integer.toString(calendario.get(Calendar.YEAR));
	   
	 
		
		 return annio;
	}
//**********************************************************
    public static ArrayList<obj_combo_dos_campos> llena_combo_contenido() {
      ArrayList<obj_combo_dos_campos> lista = new ArrayList<obj_combo_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_biblioteca_material_bibiloteca_llena_combo_contenido}" ;
            CallableStatement ps = c.prepareCall(sql);
                                  
            ResultSet rs = ps.executeQuery();
             lista.add(new obj_combo_dos_campos ("0", "-- Seleccione --"));
            while (rs.next()){
                  
            lista.add(new obj_combo_dos_campos (rs.getString("tip_con_idn"), 
                                                rs.getString("tip_con_nombre")));
           
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
//**********************************************************
    public static ArrayList<obj_combo_dos_campos> llena_combo_tipo_estandar() {
      ArrayList<obj_combo_dos_campos> lista = new ArrayList<obj_combo_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_biblioteca_material_bibiloteca_llena_combo_tipo_estandar}" ;
            CallableStatement ps = c.prepareCall(sql);
                                  
            ResultSet rs = ps.executeQuery();
             lista.add(new obj_combo_dos_campos ("0", "-- Seleccione --"));
            while (rs.next()){
                  
            lista.add(new obj_combo_dos_campos (rs.getString("mat_tip_estandar_idn"), 
                                                rs.getString("mat_tipo_estandar_nombre")));
           
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
    
//******---------------**************--------------------***************----------------*************--------**********
//******---------------**************--------------------***************----------------*************--------**********    
      public static ArrayList<obj_dos_campos> buscar_material_por_titulo (String criterio) {
         ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_biblioteca_material_bibiloteca_buscar_x_titulo (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, criterio.trim());
           
           
            ResultSet rs = ps.executeQuery();
                        
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos(rs.getString("mat_tit_idn"),
                                         rs.getString("mat_tit_titulo")));
           
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

 //-----------------------------------------------------------------------------------
      
 
  public static ArrayList<obj_dos_campos> buscar_material_por_editorial (String criterio) {
         ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_biblioteca_material_bibiloteca_buscar_x_editorial (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, criterio.trim());
           
           
            ResultSet rs = ps.executeQuery();
                        
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos(rs.getString("edi_idn"),
                                         rs.getString("edi_nombre")));//,
                                         //rs.getString("tip_mat_bib_nombre")));
           
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

 //-----------------------------------------------------------------------------------
  
    public static ArrayList<obj_dos_campos> buscar_material_por_autor (String criterio) {
         ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_biblioteca_material_bibiloteca_buscar_x_autor (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, criterio.trim());
           
           
            ResultSet rs = ps.executeQuery();
                        
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos(rs.getString("aut_idn"),
                                         rs.getString("aut_nombre")));//,
                                         //rs.getString("tip_mat_bib_nombre")));
           
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

  
  
  
//********************************************************************************* 
    //-----------------------------------------------------------------------------------
      
 
 //-----------------------------------------------------------------------------------
  
    public static ArrayList<obj_dos_campos> buscar_etiqueta (String criterio) {
         ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_biblioteca_material_bibiloteca_buscar_x_etiqueta (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, criterio.trim());
           
           
            ResultSet rs = ps.executeQuery();
                        
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos(rs.getString("eti_idn"),
                                         rs.getString("eti_nombre")));//,
                                         //rs.getString("tip_mat_bib_nombre")));
           
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

  
  /*
   public static ArrayList guarda_material_biblioteca(String funcionario, String codigo_titulo, String edicion_titulo, String dewey,String cutter,String anio,String volumen,String editorial,String descripcion,String tipo_standar,String tipo_material_titulo,String resumen,String codigo_tipo_estandar,ArrayList arreglo_etiquetas, ArrayList arreglo_autores,ArrayList arreglo_contenido,int copias) {
       
       
        ArrayList lista = new ArrayList();
            Connection c=null;
            
            String material_insertado, codigo_material;
             obj_un_campo registro_material_insertado = null;
             
            int salida = 1;
            String msg ;
         try {
    0        String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_biblioteca_material_bibiloteca_guarda_datos_material (?,?,?,?,?,?,?,?,?,?,?,?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, funcionario.trim());
            ps.setString(2, codigo_titulo.trim());
            ps.setString(3, edicion_titulo.trim());
            ps.setString(4, tipo_material_titulo.trim());
            ps.setString(5, anio.trim());
            ps.setString(6, resumen.trim());
            
            ps.setString(7, descripcion.trim());
            ps.setString(8, tipo_standar.trim());
            ps.setString(9, dewey.trim());
            ps.setString(10, cutter.trim());
            ps.setString(11, volumen.trim());
            ps.setString(12, editorial.trim());
            
             ps.setString(13, codigo_tipo_estandar.trim());
            
                       
            ResultSet rs = ps.executeQuery();
        
            while (rs.next()){
            
      
            lista.add(new obj_un_campo(rs.getString("codigo_material")));       
            }
            
                  
              registro_material_insertado = (obj_un_campo) lista.get(0);
            
            material_insertado = registro_material_insertado.getcampo_uno();
          
            
          //////////
            
            String sql0;
            int size0 = arreglo_etiquetas.size();
            obj_un_campo registro0 = null;
              
            int x;
            for (x=0; x<size0; x++) 
               {
      1            
                       registro0 = (obj_un_campo) arreglo_etiquetas.get(x);
                        sql0 = "{call frm_biblioteca_material_bibiloteca_guarda_etiquetas_material (?,?)}" ;
                        CallableStatement ps0 = c.prepareCall(sql0);
                       
                        ps0.setString(1, material_insertado );
                         ps0.setString(2,registro0.getcampo_uno() );
                       
                        ps0.execute();
               }
            
            
          ///////////  
            
      2      
              String sql1;
              int size = arreglo_autores.size();
              obj_tres_campos registro = null;
              
            int j;
            for (j=0; j<size; j++) 
               {
                    
                       registro = (obj_tres_campos) arreglo_autores.get(j);
                       
                       c = conexion_odbc.Connexion_datos();
                       sql1 = "{call frm_biblioteca_material_bibiloteca_guarda_autores_material (?,?,?)}" ;
                        CallableStatement ps1 = c.prepareCall(sql1);
                         
                        ps1.setString(1, registro.getcampo_dos().toString().trim() );
                        ps1.setString(2, registro.getcampo_uno().toString().trim() );
                        ps1.setString(3, material_insertado);
                                           
                        ps1.execute();
               }
            
            
            ////////
            
                String sql00;
            int size00 = arreglo_contenido.size();
            obj_un_campo registro00 = null;
              
            int a;
            for (a=0; a<size00; a++) 
               {
                    
                       registro00 = (obj_un_campo) arreglo_contenido.get(a);
                        sql00 = "{call frm_biblioteca_material_bibiloteca_guarda_material_contenido (?,?)}" ;
                        CallableStatement ps00 = c.prepareCall(sql00);
                       
                        ps00.setString(1, material_insertado );
                         ps00.setString(2,registro00.getcampo_uno() );
                       
                        ps00.execute();
               }
            
            
                ///////////  
            
            
              String sql2;
             
             
              
            int p;
            for (p=0; p<copias; p++) 
               {
                    
                   
                       
                       c = conexion_odbc.Connexion_datos();
                       sql2 = "{call frm_biblioteca_material_bibiloteca_guarda_material_coleccion (?,?)}" ;
                        CallableStatement ps2 = c.prepareCall(sql2);
                         
                        ps2.setString(1, material_insertado);
                        ps2.setString(2, funcionario);
                       
                                           
                        ps2.execute();
               }
            
            
            
              
              
              
            ////  
            
        } catch (Exception e) {
            e.printStackTrace();
            lista.remove(0);
            msg = e.getMessage();
            
            
        } finally {
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
                
         return lista;
    
          
          
   }  
  
  
  
  
  */
//*********************************************************************************   
    
    //******---------------**************--------------------***************----------------*************--------**********    
      public static ArrayList<obj_dieciseis_campos> buscar_x_codigo_titulo (String mat_tit_idn) {
         ArrayList<obj_dieciseis_campos> lista = new ArrayList<obj_dieciseis_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_biblioteca_material_bibiloteca_buscar_x_codigo_titulo (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, mat_tit_idn.trim());
           
           
            ResultSet rs = ps.executeQuery();
                        
            while (rs.next()){
            
      
            lista.add(new obj_dieciseis_campos(rs.getString("mat_bib_idn"),
                                         rs.getString("mat_bib_fecha_ingreso"),
                                         rs.getString("edi_idn"),
                                         rs.getString("edi_nombre"),
                                         rs.getString("mat_bib_edicion"),
                                         rs.getString("tip_mat_bib_idn"),
                                         rs.getString("tip_mat_bib_nombre"),
                                         rs.getString("mat_bib_indice"),
                                         rs.getString("mat_descripcion"),
                                         rs.getString("mat_codigo_estandar"),
                                         rs.getString("mat_tip_estandar_idn"),
                                         rs.getString("mat_tipo_estandar_nombre"),
                                         rs.getString("mat_bib_dewey"),
                                         rs.getString("mat_bib_cutter"),
                                         rs.getString("mat_bib_anio"),
                                         rs.getString("mat_bib_volumen")));
           
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

 //-----------------------------------------------------------------------------------
      
    //******---------------**************--------------------***************----------------*************--------**********    
      public static ArrayList<obj_dos_campos> buscar_x_fecha (String fecha) {
         ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_biblioteca_material_bibiloteca_buscar_x_fecha_ingreso (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, fecha.trim());
           
           
            ResultSet rs = ps.executeQuery();
                        
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos(rs.getString("mat_tit_idn"),
                                         rs.getString("mat_tit_titulo")));
           
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

 //-----------------------------------------------------------------------------------
      
      public static ArrayList<obj_un_campo_string> muestra_cantidad_de_copias (String mat_bib_idn) {
         ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_biblioteca_material_bibiloteca_muestra_cantidad_de_copias (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, mat_bib_idn.trim());
           
           
            ResultSet rs = ps.executeQuery();
                        
            while (rs.next()){
            
      
            lista.add(new obj_un_campo_string(rs.getString("copias")));
           
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
//---------------------------------------------------------------------------------------------
      
     public static ArrayList<obj_dos_campos> muestra_arreglo_contenido (String mat_bib_idn) {
         ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_biblioteca_material_bibiloteca_muestra_arreglo_contenido (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, mat_bib_idn.trim());
           
           
            ResultSet rs = ps.executeQuery();
                        
            while (rs.next()){
            
            lista.add(new obj_dos_campos(rs.getString("tip_con_idn"),
                                         rs.getString("tip_con_nombre")));//,
          
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
    //
     
     
     //---------------------------------------------------------------------------------------------
      
     public static ArrayList<obj_dos_campos> muestra_arreglo_etiquetas (String mat_bib_idn) {
         ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_biblioteca_material_bibiloteca_muestra_arreglo_etiquetas (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, mat_bib_idn.trim());
           
           
            ResultSet rs = ps.executeQuery();
                        
            while (rs.next()){
            
            lista.add(new obj_dos_campos(rs.getString("eti_idn"),
                                         rs.getString("eti_nombre")));//,
          
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
     //--------------------------------------------------------------------------------------------------
     
     
     //---------------------------------------------------------------------------------------------
      
     public static ArrayList<obj_cuatro_campos> muestra_arreglo_autores (String mat_bib_idn) {
         ArrayList<obj_cuatro_campos> lista = new ArrayList<obj_cuatro_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_biblioteca_material_bibiloteca_muestra_arreglo_autores (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, mat_bib_idn.trim());
           
           
            ResultSet rs = ps.executeQuery();
                        
            while (rs.next()){
            
            lista.add(new obj_cuatro_campos(rs.getString("aut_idn"),
                                        rs.getString("aut_nombre"), 
                                        rs.getString("tip_aut_nombre"), 
                                        rs.getString("tip_aut_idn")));
            //,
          
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
     //--------------------------------------------------------------------------------------------------
    
     
     
     
      public static ArrayList<obj_un_campo_string> bibiloteca_elimina (String mat_bib_idn) {
         ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_biblioteca_material_bibiloteca_elimina (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, mat_bib_idn.trim());
           
           
            ResultSet rs = ps.executeQuery();
                        
            while (rs.next()){
            
            lista.add(new obj_un_campo_string(rs.getString("salida")));
            //,
          
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
     //----------------------------M O D I F I C A----------------------------------------------------------------------
     //***************************************************************************
   
     public static ArrayList<obj_un_campo_string> modifica_material_biblioteca( String mat_bib_idn 
                                                       , String funcionario
                                                       , String codigo_titulo
                                                       , String edicion_titulo
                                                       , String dewey
                                                       ,String cutter
                                                       ,String anio
                                                       ,String volumen
                                                       ,String editorial
                                                       ,String descripcion
                                                       ,String tipo_standar
                                                       ,String tipo_material_titulo
                                                       ,String resumen
                                                       ,String codigo_tipo_estandar
                                                       ) {
    ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
        Connection c=null;
        try {
        
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_biblioteca_material_bibiloteca_modifica_datos_material (?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, mat_bib_idn.trim());
            ps.setString(2, funcionario.trim());
            ps.setString(3, codigo_titulo.trim());
            ps.setString(4, edicion_titulo.trim());
            ps.setString(5, tipo_material_titulo.trim());
            ps.setString(6, anio.trim());
            ps.setString(7, resumen.trim());
            
            ps.setString(8, descripcion.trim());
            ps.setString(9, tipo_standar.trim());
            ps.setString(10, dewey.trim());
            ps.setString(11, cutter.trim());
            ps.setString(12, volumen.trim());
            ps.setString(13, editorial.trim());
            
             ps.setString(14, codigo_tipo_estandar.trim());      
            ResultSet rs = ps.executeQuery(); 

  
            while (rs.next())
            {
            	  lista.add(new obj_un_campo_string(rs.getString("salida")));
            }

           

            
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
//***************************************************************************
 //-----------------------------------------------------------------------------------
      
      public static ArrayList<obj_un_campo_string> guardar_nuevo_titulo (String criterio) {
         ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_biblioteca_material_bibiloteca_agrega_titulo (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, criterio.trim());
           
           
            ResultSet rs = ps.executeQuery();
                        
            while (rs.next()){
            
      
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
//---------------------------------------------------------------------------------------------
    
     //-----------------------------------------------------------------------------------
      
      public static ArrayList<obj_un_campo_string> guardar_nueva_editorial (String criterio) {
         ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_biblioteca_material_bibiloteca_guarda_editorial (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, criterio.trim());
           
           
            ResultSet rs = ps.executeQuery();
                        
            while (rs.next()){
            
      
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
//---------------------------------------------------------------------------------------------
      
         //-----------------------------------------------------------------------------------
      
      public static ArrayList<obj_un_campo_string> guardar_nuevo_autor (String criterio) {
         ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_biblioteca_material_bibiloteca_guardar_nuevo_autor (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, criterio.trim());
           
           
            ResultSet rs = ps.executeQuery();
                        
            while (rs.next()){
            
      
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
//---------------------------------------------------------------------------------------------
        //-----------------------------------------------------------------------------------
      
      public static ArrayList<obj_un_campo_string> guardar_nueva_etiqueta (String criterio) {
         ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_biblioteca_material_bibiloteca_guardar_nueva_etiqueta (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, criterio.trim());
           
           
            ResultSet rs = ps.executeQuery();
                        
            while (rs.next()){
            
      
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
//---------------------------------------------------------------------------------------------
      
     
     //--------------------------------------------------------------------------------------------------
    //
}
