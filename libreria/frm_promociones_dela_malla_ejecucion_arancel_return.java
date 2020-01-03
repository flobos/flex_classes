/*
 * frm_adm_chat_ingreso.java
 *
 * Created on 08 de Enero de 2007
 */

package libreria;
import java.util.ArrayList;
import java.io.Serializable;
import java.sql.*;
/**
 *
 * @author  marcelo
 */
public class frm_promociones_dela_malla_ejecucion_arancel_return {
 ///*******************************************************************************************************************
     
  public static ArrayList<obj_dos_campos> promociones_dela_malla_ejecucion_Arancel_muestra_ejecuciones_academicas(int funcion_modalidad) {
      ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
        
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            
            sql = "{call flex_promociones_dela_malla_ejecucion_Arancel_muestra_ejecuciones_academicas (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setInt(1,funcion_modalidad);
            
                                
            ResultSet rs = ps.executeQuery();
            
             lista.add(new obj_dos_campos("0"," - Seleccione - "));   
            
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos (rs.getString("eje_idn"), 
                                             rs.getString("eje_nombre")));
           
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
    
    //*/*********************************************************************************************************************
     public static ArrayList<obj_dos_campos> promociones_dela_malla_ejecucion_Arancel_muestra_ejecucion(String valor) {
      ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_promociones_dela_malla_ejecucion_arancel_muestra_ejecucion (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,valor.trim());
                      
            ResultSet rs = ps.executeQuery();
            
            lista.add(new obj_dos_campos("0"," - Seleccione - "));     
            
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos (rs.getString("eje_idn"), 
                                             rs.getString("eje_nombre")));
           
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
  
////***************************************************************************************************     
 //*/*********************************************************************************************************************
  /*   public static ArrayList promociones_dela_malla_ejecucion_Arancel_muestra_pro_mal_idn(String eje_idn) {
      ArrayList lista = new ArrayList();
        Connection c=null;
         int salida;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_promociones_dela_malla_ejecucion_arancel_muestra_pro_mal_idn (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,eje_idn.trim());
                      
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
            lista.add(new obj_dos_campos (rs.getString("pro_mal_idn"), 
                                             rs.getString("pro_mal_fec_ini")));
           
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
   **/
////***************************************************************************************************     
 
      public static ArrayList<obj_dos_campos> promociones_dela_malla_ejecucion_Arancel_muestra_promociones(String valor) {
      ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_promociones_dela_malla_ejecucion_arancel_muestra_promociones (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,valor.trim());
                      
            ResultSet rs = ps.executeQuery();
            lista.add(new obj_dos_campos("0"," - Seleccione - "));     
            while (rs.next()){
            lista.add(new obj_dos_campos (rs.getString("pro_idn"), 
                                             rs.getString("pro_nombre")));
           
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
 /////*****************************************************************************************
      
  public static ArrayList<obj_dos_campos> promociones_dela_malla_ejecucion_Arancel_muestra_promociones_dela_malla(int pro_idn, int func_mod_fun_idn) {
      ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
        
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            
            sql = "{call flex_promociones_dela_malla_ejecucion_Arancel_muestra_promociones_dela_malla (?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setInt(1,pro_idn);
            ps.setInt(2,func_mod_fun_idn); 
                                
            ResultSet rs = ps.executeQuery();
            
            // lista.add(new obj_dos_campos("0"," - Seleccione - "));   
            
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos (rs.getString("pro_mal_idn"), 
                                             rs.getString("Malla")));
           
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
    
 //*/*********************************************************************************************************************
  
/*
   public static ArrayList promociones_dela_malla_ejecucion_Arancel_inserta(String eje_idn, String pro_mal_idn , String pro_eje_ara_arancel) {
    ArrayList lista = new ArrayList();
        Connection c=null;
         int salida = 1;
      String msg ;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_promociones_dela_malla_ejecucion_Arancel_inserta (?,?,?)}";
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, eje_idn.trim());
            ps.setString(2, pro_mal_idn.trim());
            ps.setString(3, pro_eje_ara_arancel.trim());
           
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
            lista.add(new obj_un_campo_string(rs.getString("identidad")));
            }
        } catch (Exception e) {
            e.printStackTrace();
            lista.remove(0);
            msg = e.getMessage();
            lista.add(new obj_un_campo_string(msg));
            
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
  //---------------------------------------------------------------------------------------------------------------------
  /*
     public static ArrayList promociones_dela_malla_ejecucion_Arancel_inserta(String eje_idn,
                                                                                 ArrayList pro_mal_idn,
                                                                                String ele_con_pag_idn, 
                                                                                String pro_eje_ara_arancel
                                                                                ) {
                                                                                 
    ArrayList lista = new ArrayList();
        Connection c=null;
         int salida = 1;
      String msg ;
      
       String sql1;
              int size = pro_mal_idn.size();
              obj_tres_campos registro = null;
                
            int j;
            for (j=0; j<size; j++) 
            
              {
                    
                        registro = (obj_tres_campos) pro_mal_idn.get(j);
                        sql1 = "{call flex_promociones_dela_malla_ejecucion_Arancel_inserta (?,?,?,?)}" ;
                        CallableStatement ps1 = c.prepareCall(sql1);
                         ps1.setString(1,eje_idn.trim());
                        ps1.setString(2,registro.getcampo_uno().toString());
                       ps1.setString(3,ele_con_pag_idn.trim());
                       
                        ps1.setString(4,pro_eje_ara_arancel.trim());
                       
                        ps1.execute();
                        
                        //  lista.add(new obj_un_campo_string(rs.getString("identidad")));
               }
           
 //-------------------------------------------------------           
           
    */        //-------------------------------------------------
  
  
  //***********************************************************************************************************           
   /*      public static ArrayList promociones_dela_malla_ejecucion_Arancel_inserta_en_dos_tablas(String eje_idn,
                                                                                                  ArrayList pro_mal_idn,
                                                                                                  String ele_con_pag_idn, 
                                                                                                  String pro_mal_eje_con_pag_arancel,
                                                                                                  String func_mod_fun               ) {
    
        ArrayList lista = new ArrayList();
        Connection c=null;
        String exito;
        int salida;
        
        try {
             c = conexion_odbc.Connexion_datos();

             String sql1;
             int size = pro_mal_idn.size();
             obj_un_campo_string registro = null;
                
            int j;
            for (j=0; j<size; j++) 
               {
                    
                        registro = (obj_un_campo_string) pro_mal_idn.get(j);
                        sql1 = "{call flex_inserta_promociones_dela_malla_ejecucion_promo_malla_ejecucion_concep_pagos_arancel (?,?,?,?,?)}" ;
                        CallableStatement ps1 = c.prepareCall(sql1);
                        ps1.setString(1,eje_idn.trim());
                        ps1.setString(2,registro.getcampo_uno().toString());
                        ps1.setString(3,ele_con_pag_idn.trim());
                        ps1.setString(4,pro_mal_eje_con_pag_arancel.trim());
                         ps1.setString(5,func_mod_fun.trim());
                       ps1.execute();
                        
                    //   ResultSet rs = ps1.executeQuery();
                        
                    //  lista.add(new obj_un_campo_string(rs.getString("salida")));
               }
            
            
            
           } catch (Exception e) {
            e.printStackTrace();
     //      salida = "1";
           
        } finally {
                     
            
            try {
                    c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            
            }
             
            }
//       lista.add(new obj_un_campo(salida));
        
        {
        lista.add(new obj_un_campo(0));
        }
      
       return lista;
    }  
       
           
           

  */
  
  //*//------------------------------------------------------------------------------------------------------------------
   
    public static ArrayList<obj_diez_campos> promociones_dela_malla_ejecucion_Arancel_muestra(String valor) {
      ArrayList<obj_diez_campos> lista = new ArrayList<obj_diez_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_promociones_dela_malla_ejecucion_Arancel_muestra (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,valor.trim());
                      
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
      
            lista.add(new obj_diez_campos (rs.getString("pro_eje_idn"), 
                                             rs.getString("eje_idn"), 
                                             rs.getString("eje_nombre"), 
                                             rs.getString("pro_mal_idn"),
                                             rs.getString("mal_nombre"),
                                             rs.getString("pro_mal_eje_con_pag_arancel"),
                                             rs.getString("pro_mal_eje_con_pag_fecha_ingreso"),
                                             rs.getString("pro_mal_eje_con_pag_idn"),
                                             rs.getString("ele_pag_nombre"),
                                             rs.getString("con_pag_nombre")));
           
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
   
//------------------------------------------------------------------------------------------------------------------------
    
    public static ArrayList<obj_un_campo> promociones_dela_malla_ejecucion_Arancel_elimina(String pro_eje_idn, String pro_mal_eje_con_pag_idn) {
    ArrayList<obj_un_campo> lista = new ArrayList<obj_un_campo>();
    Connection c=null;
    int salida = 1;
    try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_promociones_dela_malla_ejecucion_Arancel_elimina (?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,pro_eje_idn);
             ps.setString(2,pro_mal_eje_con_pag_idn);
            ps.execute();
           
        } catch (Exception e) {
            e.printStackTrace();
            salida = 0;
            e.getMessage();
        } finally {
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (salida == 1){
        lista.add(new obj_un_campo(1));
        }else{
        lista.add(new obj_un_campo(0));
        }
        
         return lista;
   }  
   
  ////---------------------------------------------------------------------------------
    
    
    
    
    public static ArrayList<obj_un_campo> promociones_dela_malla_ejecucion_Arancel_modifica_arancel(String pro_eje_ara_idn, String pro_eje_ara_arancel )
   {
    ArrayList<obj_un_campo> lista = new ArrayList<obj_un_campo>();
        Connection c=null;
         int salida = 1;
        try {
  
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_promociones_dela_malla_ejecucion_Arancel_modifica_arancel (?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,pro_eje_ara_idn.trim());
            ps.setString(2,pro_eje_ara_arancel.trim());
          
            
            ps.execute();
                       
        } catch (Exception e) {
            e.printStackTrace();
            salida = 0;
            
        } finally {
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        if (salida == 1){
        lista.add(new obj_un_campo(1));
        }else{
        lista.add(new obj_un_campo(0));
        }
        
         return lista;
   }
   
   //---------------------------------------------------------------------------------
    
    
    
    
     public static ArrayList<obj_un_campo_string> promociones_dela_malla_ejecucion_Arancel_busca_existe(String eje_idn, String pro_mal_idn ) {
      ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_promociones_dela_malla_ejecucion_Arancel_busca_existe (?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,eje_idn.trim());
            ps.setString(2,pro_mal_idn.trim());          
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
      
            lista.add(new obj_un_campo_string (rs.getString("pro_eje_ara_idn")));
           
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
  //---------------------------------------------------------------------------------------------------------------------
     
     
     
      public static ArrayList<obj_dos_campos> muestra_elementos_conceptos_pago() {
      ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_promociones_dela_malla_ejecucion_arancel_muestra_elementos_conceptos_pago ()}" ;
            CallableStatement ps = c.prepareCall(sql);
         
                      
            ResultSet rs = ps.executeQuery();
            
             
              lista.add(new obj_dos_campos("0"," - Seleccione - "));
                 
            
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos (rs.getString("ele_con_pag_idn"), 
                                         rs.getString("elemento_concepto")));
           
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
     
      //*/*********************************************************************************************************************
   
  
////***************************************************************************************************      
        //***********************************************************************************************************         
  
  public static ArrayList<obj_dos_campos> promociones_dela_malla_ejecucion_Arancel_llena_repiter_ejecuciones_academicas(int funcion_modalidad) {
      ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
        
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            
            sql = "{call flex_promociones_dela_malla_ejecucion_Arancel_llena_repiter_ejecuciones_academicas (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setInt(1,funcion_modalidad);
            
                                
            ResultSet rs = ps.executeQuery();
            
            // lista.add(new obj_dos_campos("0"," - Seleccione - "));   
            
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos (rs.getString("eje_idn"), 
                                             rs.getString("eje_nombre")));
           
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
    //********************************************************************************************************************
  /*    public static ArrayList promociones_dela_malla_ejecucion_Arancel_inserta_en_tres_tablas(String eje_idn,
                                                                                                  ArrayList pro_mal_idn,
                                                                                                  String ele_con_pag_idn, 
                                                                                                  String pro_mal_eje_con_pag_arancel,
                                                                                                  String func_mod_fun,
                                                                                                  ArrayList arreglo_ejecucion) {
    
        ArrayList lista = new ArrayList();
        Connection c=null;
        String exito;
        String salida = "0";
        
        try {
             c = conexion_odbc.Connexion_datos();

             String sql1;
             int size = pro_mal_idn.size();
             obj_un_campo_string registro = null;
              int size2 = arreglo_ejecucion.size();
             obj_un_campo_string registro_eje = null;
                
            int j;
            int x;
            for (j=0; j<size; j++) 
               {
                    for (x=0; x<size; x++) 
               {
                    
                        registro = (obj_un_campo_string) pro_mal_idn.get(j);
                        registro_eje = (obj_un_campo_string) pro_mal_idn.get(x);
                        sql1 = "{call flex_inserta_promociones_dela_malla_ejecucion_promo_malla_ejecucion_concep_pagos_arancel_2 (?,?,?,?,?,?)}" ;
                        CallableStatement ps1 = c.prepareCall(sql1);
                        ps1.setString(1,eje_idn.trim());
                        ps1.setString(2,registro.getcampo_uno().toString());
                        ps1.setString(3,ele_con_pag_idn.trim());
                        ps1.setString(4,pro_mal_eje_con_pag_arancel.trim());
                         ps1.setString(5,func_mod_fun.trim());
                          ps1.setString(6,registro_eje.getcampo_uno().toString());
                        ps1.execute();
               }
                    }
            
           } catch (Exception e) {
            e.printStackTrace();
            salida = "1";
           
        } finally {
                     
            
            try {
                    c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            
            }
             
            }
     //  lista.add(new obj_un_campo(salida));
        
        {
        lista.add(new obj_un_campo(0));
        }
      
       return lista;
    }  
       
           
    */       
       
           
 ////********************************************************************************************************************   
         public static ArrayList<obj_un_campo_string> promociones_dela_malla_ejecucion_Arancel_inserta_en_tres_tablas(String eje_idn,
                                                                                                  ArrayList<?> pro_mal_idn,
                                                                                                  String ele_con_pag_idn, 
                                                                                                  String pro_mal_eje_con_pag_arancel,
                                                                                                  String func_mod_fun,
                                                                                                  ArrayList<?> arreglo_ejecucion) {
    
        ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
    
        Connection c=null;
        try {
            
          
           String sql;
            
                int size2 = pro_mal_idn.size();   
                int size = arreglo_ejecucion.size();
                
                obj_un_campo_string registro = null;
                obj_un_campo_string registro_1 = null;
                
                 int x;    
                int j;
    
             for (x=0; x<size2; x++) 
                {
                    
                     registro_1 = (obj_un_campo_string) pro_mal_idn.get(x);
                     
                                for (j=0; j<size; j++) 
                                   {
                                            try
                                            {
                                           registro = (obj_un_campo_string) arreglo_ejecucion.get(j);
                                            c = conexion_odbc.Connexion_datos();
                                            sql = "{call flex_inserta_promociones_dela_malla_ejecucion_promo_malla_ejecucion_concep_pagos_arancel_2  (?,?,?,?,?,?)}" ;
                                            CallableStatement ps1 = c.prepareCall(sql);
                                           
                                            ps1.setString(1,eje_idn.trim());
                                            ps1.setString(2,registro_1.getcampo_uno().toString());
                                            ps1.setString(3,ele_con_pag_idn.trim());
                                            ps1.setString(4,pro_mal_eje_con_pag_arancel.trim());
                                            ps1.setString(5,func_mod_fun.trim());
                                            ps1.setString(6,registro.getcampo_uno().toString());
                                            ps1.execute();
                                            }
                                            catch (Exception e) {
                                                  e.printStackTrace();
                                            }
                                            finally 
                                            {
                                            }
                                            
                        
                        
                                }
                                           
                       }
            
                                                                 
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
     
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////           

       //******************************************************************************
  public static ArrayList<obj_un_campo_string> promociones_dela_malla_ejecucion_Arancel_inserta_en_dos_tablas(String eje_idn,
                                                                                                  ArrayList<?> pro_mal_idn,
                                                                                                  String ele_con_pag_idn, 
                                                                                                  String pro_mal_eje_con_pag_arancel,
                                                                                                  String func_mod_fun) {
      ArrayList<obj_un_campo_string> lista_p = new ArrayList<obj_un_campo_string>();
        Connection c=null;
         try {
            
            String sql;
                      
            int size = pro_mal_idn.size();   
             
                
                obj_un_campo_string registro = null;
                
                 int x;    
              
    
             for (x=0; x<size; x++) 
                {
                    
                     registro = (obj_un_campo_string) pro_mal_idn.get(x);
      
                              c = conexion_odbc.Connexion_datos();
            
                  sql = "{call flex_inserta_promociones_dela_malla_ejecucion_promo_malla_ejecucion_concep_pagos_arancel  (?,?,?,?,?)}"  ;
            CallableStatement ps = c.prepareCall(sql);
            
             ps.setString(1,eje_idn.trim());
             ps.setString(2,registro.getcampo_uno().toString());
             ps.setString(3,ele_con_pag_idn.trim());
             ps.setString(4,pro_mal_eje_con_pag_arancel.trim());
             ps.setString(5,func_mod_fun.trim());
             
             ps.execute();
            
            
           /*  
           ps.setString(1,registro_reg.getcampo_uno());
            ps.execute();
            */
             

                         ResultSet rs = ps.executeQuery();

                          while (rs.next()){

                        lista_p.add(new obj_un_campo_string (rs.getString("salida")
                                                          
                                                                      ));


                        }
 
     
             
             }
  
        }
        
  catch (Exception e) {
            e.printStackTrace();
        } finally {
            lista_p.add(new obj_un_campo_string("OK"));   
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
         return lista_p;
   }


//******************************************************************************
         
          public static ArrayList<?> promociones_dela_malla_ejecucion_Arancel_inserta_promocion_ejecuciones(ArrayList<?> pro_mal_eje_con_pag_idn, ArrayList<?> arreglo_ejecuciones) {
    
        ArrayList<?> lista = new ArrayList<Object>();
    
        Connection c=null;
        try {
            
          
           String sql;
            
                int size2 = pro_mal_eje_con_pag_idn.size();   
                int size = arreglo_ejecuciones.size();
                
                obj_un_campo_string registro = null;
                obj_un_campo_string registro_2 = null;
                
                 int x;    
                int j;
    
             for (x=0; x<size2; x++) 
                {
                    
                     registro = (obj_un_campo_string) pro_mal_eje_con_pag_idn.get(x);
                     
                                for (j=0; j<size; j++) 
                                   {

                                           registro_2 = (obj_un_campo_string) arreglo_ejecuciones.get(j);
                                            c = conexion_odbc.Connexion_datos();
                                            sql = "{call flex_promociones_dela_malla_ejecucion_Arancel_inserta_promocion_ejecuciones  (?,?)}" ;
                                            CallableStatement ps1 = c.prepareCall(sql);
                                           
                                            ps1.setString(1,registro.getcampo_uno());
                                            ps1.setString(2,registro_2.getcampo_uno());
                                           
                                            ps1.execute();
                        
                        
                                }
                                         
                       }
           
                         
           } catch (Exception e) {
            e.printStackTrace();
            //lista.add(new obj_un_campo_string("ERROR"));
           
        } finally {
                     
            
      /*       if (salida == 1){
        lista.add(new obj_un_campo_string("si"));
        }else{
        lista.add(new obj_un_campo_string("no"));
        }*/
                 
            try {
                
               
                    c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            
            
            }
        }
           
        
        return lista;
    }    
    
          //--------------------------------------------------modificaciones 19_ 03 _ 2008----------------------------------------------------------------------
          
     
      public static ArrayList<obj_dos_campos> llena_combo_conceptos_pago() {
      ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_promociones_dela_malla_ejecucion_arancel_llena_combo_conceptos_pago ()}" ;
            CallableStatement ps = c.prepareCall(sql);
         
                      
            ResultSet rs = ps.executeQuery();
            
             
              lista.add(new obj_dos_campos("0"," - Seleccione - "));
                 
            
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos (rs.getString("con_pag_idn"), 
                                         rs.getString("con_pag_nombre")));
           
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
          
  //------------------------------------------------------------------------------------------------------------------------
      
      
      
      public static ArrayList<obj_dos_campos> llena_lista_elemento_pago_segun_concepto(String con_pag_idn) {
      ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_promociones_dela_malla_ejecucion_Arancel_llena_lista_elemento_pago_segun_concepto (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,con_pag_idn.trim());
                      
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos (rs.getString("ele_con_pag_idn"), 
                                             rs.getString("ele_pag_nombre")));
           
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
      //******************************************************************************
 /* public static ArrayList promociones_dela_malla_ejecucion_Arancel_inserta_en_dos_tablas_2(String eje_idn,
                                                                                                  ArrayList pro_mal_idn,
                                                                                                  ArrayList arreglo_elementos,
                                                                                                  //String ele_con_pag_idn, 
                                                                                                  //String pro_mal_eje_con_pag_arancel,
                                                                                                  String func_mod_fun) {
      ArrayList lista_p = new ArrayList();
        Connection c=null;
         int salida;
        try {
            
            String sql;
                      
            int size = pro_mal_idn.size();   
             int size2 = arreglo_elementos.size(); 
                
                obj_un_campo_string registro = null;
                obj_dos_campos registro_dos_campos = null;
                
                 int x;    
                 int y;  
    
             for (x=0; x<size; x++) 
                {
                    
                     registro = (obj_un_campo_string) pro_mal_idn.get(x);
                     
                     for (y=0; y<size2; y++) 
                        {
                      registro_dos_campos=(obj_dos_campos) arreglo_elementos.get(y);
                              c = conexion_odbc.Connexion_datos();
            
                  sql = "{call flex_inserta_promociones_dela_malla_ejecucion_promo_malla_ejecucion_concep_pagos_arancel_2  (?,?,?,?,?)}"  ;
            CallableStatement ps = c.prepareCall(sql);
            
             ps.setString(1,eje_idn.trim());
             ps.setString(2,registro.getcampo_uno().toString());
             ps.setString(3,registro_dos_campos.getdata().toString());
             ps.setString(4,registro_dos_campos.getlabel().toString());
            // ps.setString(3,ele_con_pag_idn.trim());
            // ps.setString(4,pro_mal_eje_con_pag_arancel.trim());
             ps.setString(5,func_mod_fun.trim());
             
             ps.execute();
            
            
         
             

                         ResultSet rs = ps.executeQuery();

                          while (rs.next()){

                        lista_p.add(new obj_un_campo_string (rs.getString("salida")
                                                          
                                                                      ));

                            }
                        }
 
     
             
             }
  
        }
        
  catch (Exception e) {
            e.printStackTrace();
        } finally {
            lista_p.add(new obj_un_campo_string("OK"));   
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
         return lista_p;
   }
*/
//******************************************************************************
      
           public static ArrayList<obj_un_campo_string> promociones_dela_malla_ejecucion_Arancel_inserta_en_dos_tablas_2(String eje_idn,
                                                                                                  ArrayList<?> pro_mal_idn,
                                                                                                  ArrayList<?> arreglo_elementos,
                                                                                                  //String ele_con_pag_idn, 
                                                                                                  //String pro_mal_eje_con_pag_arancel,
                                                                                                  String func_mod_fun) {
    
        ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
    
        Connection c=null;
        try {
            
          
           String sql;
            
                int size2 = pro_mal_idn.size();   
                int size = arreglo_elementos.size();
                
                obj_dos_campos registro = null;
                obj_un_campo_string registro_1 = null;
                
                 int x;    
                int j;
    
             for (x=0; x<size2; x++) 
                {
                    
                     registro_1 = (obj_un_campo_string) pro_mal_idn.get(x);
                     
                                for (j=0; j<size; j++) 
                                   {
                                            try
                                            {
                                           registro = (obj_dos_campos) arreglo_elementos.get(j);
                                            c = conexion_odbc.Connexion_datos();
                                            sql = "{call flex_inserta_promociones_dela_malla_ejecucion_promo_malla_ejecucion_concep_pagos_arancel_2  (?,?,?,?,?)}" ;
                                            CallableStatement ps1 = c.prepareCall(sql);
                                           
                                            
                                             ps1.setString(1,eje_idn.trim());
                                             ps1.setString(2,registro_1.getcampo_uno().toString());
                                             ps1.setString(3,registro.getdata().toString());
                                             ps1.setString(4,registro.getlabel().toString());
                                             ps1.setString(5,func_mod_fun.trim());
                                            
                                            
                                            
                                            ps1.execute();
                                            
                                            
                                              ResultSet rs = ps1.executeQuery();

                          while (rs.next()){

                        lista.add(new obj_un_campo_string (rs.getString("salida")
                                                          
                                                                      ));

                            }
                                            
                                            
                                            
                                                }
                                                catch (Exception e) {
                                                      e.printStackTrace();
                                                }
                                                finally 
                                                {
                                                }



                                    }

                           }


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
           
 //*//------------------------------------------------------------------------------------------------------------------
   
    public static ArrayList<obj_once_campos> promociones_dela_malla_ejecucion_Arancel_muestra_por_funcionario_y_ejecucion(String valor, String eje_idn) {
      ArrayList<obj_once_campos> lista = new ArrayList<obj_once_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_promociones_dela_malla_ejecucion_Arancel_muestra_por_funcionario_y_ejecucion (?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,valor.trim());
            ps.setString(2,eje_idn.trim());          
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
      
            lista.add(new obj_once_campos (rs.getString("pro_eje_idn"), 
                                             rs.getString("eje_idn"), 
                                             rs.getString("eje_nombre"), 
                                             rs.getString("pro_mal_idn"),
                                             rs.getString("mal_nombre"),
                                             rs.getString("pro_mal_eje_con_pag_arancel"),
                                             rs.getString("pro_mal_eje_con_pag_fecha_ingreso"),
                                             rs.getString("pro_mal_eje_con_pag_idn"),
                                             rs.getString("ele_pag_nombre"),
                                             rs.getString("con_pag_nombre"),
                                             rs.getString("pro_nombre")
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
   
//------------------------------------------------------------------------------------------------------------------------
    
         /*  
            public static ArrayList llena_lista_elemento_pago_segun_concepto_elemento_elegido(ArrayList ele_pag_idn) {
      ArrayList lista = new ArrayList();
        Connection c=null;
         int salida;
        try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_promociones_dela_malla_ejecucion_Arancel_llena_lista_elemento_pago_segun_concepto_elemento_elegido (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1,ele_pag_idn.trim());
                      
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos (rs.getString("ele_pag_idn"), 
                                             rs.getString("ele_pag_nombre")));
           
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
     */
            
       //******************************************************************************
  public static ArrayList<Serializable> llena_lista_elemento_pago_segun_concepto_elemento_elegido( ArrayList<?> ele_pag_idn) {
      ArrayList<Serializable> lista_p = new ArrayList<Serializable>();
        Connection c=null;
         try {
            
            String sql;
                      
            int size = ele_pag_idn.size();   
             
                
                obj_un_campo_string registro = null;
                
                 int x;    
              
    
             for (x=0; x<size; x++) 
                {
                    
                     registro = (obj_un_campo_string) ele_pag_idn.get(x);
      
                              c = conexion_odbc.Connexion_datos();
            
                  sql = "{call flex_promociones_dela_malla_ejecucion_Arancel_llena_lista_elemento_pago_segun_concepto_elemento_elegido  (?)}"  ;
            CallableStatement ps = c.prepareCall(sql);
            
             
             ps.setString(1,registro.getcampo_uno().toString());
            
             
             ps.execute();
            
            
           /*  
           ps.setString(1,registro_reg.getcampo_uno());
            ps.execute();
            */
             

                         ResultSet rs = ps.executeQuery();

                          while (rs.next()){

                                lista_p.add(new obj_dos_campos (rs.getString("ele_pag_idn"), 
                                                        rs.getString("ele_pag_nombre")));
                             // lista_p.add(new obj_un_campo_string (rs.getString("salida")
                                                          
                                                                      //));


                        }
 
     
             
             }
  
        }
        
  catch (Exception e) {
            e.printStackTrace();
        } finally {
            lista_p.add(new obj_un_campo_string("OK"));   
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
         return lista_p;
   }

//-*------------------------------------------------------------------------------------------------------------------------------
   ////////////////////////////////////////////////
    
/////////////////////////////////////////////////
            
            ////////////////////////////////////////////////
       public void elimina_en_masa(ArrayList<?> arreglo_seleccionadas ) 
     {
        int salida = 1;
         Connection c=null;
        String sql;
      
        try {   
            
               int size = arreglo_seleccionadas.size();
                obj_dos_campos registro = null;
                
                int i;
                for (i=0; i<size; i++) 
                {
                    
                    registro = (obj_dos_campos) arreglo_seleccionadas.get(i);
                        c = conexion_odbc.Connexion_datos();
                        sql = "{call flex_promociones_dela_malla_ejecucion_Arancel_elimina_en_masa (?,?)}" ;
                        CallableStatement ps = c.prepareCall(sql);
                        ps.setString(1,registro.getdata());
                        ps.setString(2,registro.getlabel());
                        
                       // ps.setString(4,registro.getcampo_cuatro());
                       // ps.setString(5,registro.getcampo_cinco());
                        ps.execute();
                }
           } 
         catch (Exception e) 
            {
                e.printStackTrace();
                salida = 0;
                e.getMessage();
             
                
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
        
        if (salida == 1){
            
        }
         
    }     
 ////////////-*------------------------------------------------------------------------------------------------------------------
       
       
       
       //*//------------------------------------------------------------------------------------------------------------------
   
//    public static ArrayList muestra_aranceles_segun_eje_origen_y_ele_concepto(String valor, String eje_idn) {
//      ArrayList lista = new ArrayList();
//        Connection c=null;
//         int salida;
//        try {
//            String sql;
//            c = conexion_odbc.Connexion_datos();
//            sql = "{call flex_promociones_dela_malla_ejecucion_Arancel_muestra_aranceles_segun_eje_origen_y_ele_concepto (?,?)}" ;
//            CallableStatement ps = c.prepareCall(sql);
//            ps.setString(1,valor.trim());
//            ps.setString(2,eje_idn.trim());          
//            ResultSet rs = ps.executeQuery();
//            
//            
//                        
//              lista.add(new obj_dos_campos("0"," - Seleccione - "));
//            
//            while (rs.next()){
//            
//      
//            lista.add(new obj_dos_campos (rs.getString("pro_mal_eje_con_pag_arancel"), 
//                                             rs.getString("pro_mal_eje_con_pag_arancel") 
//                                             
//                                             ));
//           
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                c.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//         return lista;
//   }
//   
//------------------------------------------------------------------------------------------------------------------------
       //******************************************************************************
         
          public static ArrayList<obj_dos_campos> muestra_aranceles_segun_eje_origen_y_ele_concepto(ArrayList<?> arreglo_elementos, String eje_idn) {
    
        ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
    
        Connection c=null;
        try {
            
          
           String sql;
            
                int size2 = arreglo_elementos.size();   
               
                
                obj_un_campo_string registro = null;
               
                
                 int x;    
                for (x=0; x<size2; x++) 
                {
                    
                     registro = (obj_un_campo_string) arreglo_elementos.get(x);
                                           
                                            c = conexion_odbc.Connexion_datos();
                                            sql = "{call flex_promociones_dela_malla_ejecucion_Arancel_muestra_aranceles_segun_eje_origen_y_ele_concepto  (?,?)}" ;
                                            CallableStatement ps1 = c.prepareCall(sql);
                                           
                                            ps1.setString(1,registro.getcampo_uno());
                                            ps1.setString(2,eje_idn.trim()); 
                                           
                                            //ps1.execute();
                         ResultSet rs = ps1.executeQuery();
            
            
                        
  //lista.add(new obj_dos_campos("0"," - Seleccione - "));
            
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos (rs.getString("pro_mal_eje_con_pag_arancel"), 
                                             rs.getString("pro_mal_eje_con_pag_arancel") 
                                             
                                             ));
           
            }
                        
                                    
                       }
           
                         
           } catch (Exception e) {
            e.printStackTrace();
            //lista.add(new obj_un_campo_string("ERROR"));
           
        } finally {
                     
            
      /*       if (salida == 1){
        lista.add(new obj_un_campo_string("si"));
        }else{
        lista.add(new obj_un_campo_string("no"));
        }*/
                 
            try {
                
               
                    c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            
            
            }
        }
           
        
        return lista;
    }    
    
       
       
       //*//------------------------------------------------------------------------------------------------------------------
   
//    public static ArrayList muestra_promociones_con_precio(String valor, String eje_idn, String Precio ) {
//      ArrayList lista = new ArrayList();
//        Connection c=null;
//         int salida;
//        try {
//            String sql;
//            c = conexion_odbc.Connexion_datos();
//            sql = "{call flex_promociones_dela_malla_ejecucion_Arancel_muestra_promociones_con_precio (?,?,?)}" ;
//            CallableStatement ps = c.prepareCall(sql);
//            ps.setString(1,valor.trim());
//            ps.setString(2,eje_idn.trim()); 
//             ps.setString(3,Precio.trim());
//            ResultSet rs = ps.executeQuery();
//            
//            
//                        
//            //  lista.add(new obj_dos_campos("0"," - Seleccione - "));
//            
//            while (rs.next()){
//            
//      
//            lista.add(new obj_tres_campos (rs.getString("pro_mal_idn"), 
//                                             rs.getString("detalle") ,
//                                            rs.getString("precio")
//                                             
//                                             ));
//           
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                c.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//         return lista;
//   }
//   
       //******************************************************************************
         
          public static ArrayList<obj_tres_campos> muestra_promociones_con_precio(ArrayList<?> arreglo_elementos, String eje_idn, String Precio) {
    
        ArrayList<obj_tres_campos> lista = new ArrayList<obj_tres_campos>();
    
        Connection c=null;
        try {
            
          
           String sql;
            
                int size2 = arreglo_elementos.size();   
               
                
                obj_un_campo_string registro = null;
               
                
                 int x;    
                for (x=0; x<size2; x++) 
                {
                    
                     registro = (obj_un_campo_string) arreglo_elementos.get(x);
                                           
                                            c = conexion_odbc.Connexion_datos();
                                            sql = "{call flex_promociones_dela_malla_ejecucion_Arancel_muestra_promociones_con_precio  (?,?,?)}" ;
                                            CallableStatement ps1 = c.prepareCall(sql);
                                           
                                            ps1.setString(1,registro.getcampo_uno());
                                            ps1.setString(2,eje_idn.trim()); 
                                             ps1.setString(3,Precio.trim()); 
                                           
                                            //ps1.execute();
                         ResultSet rs = ps1.executeQuery();
            
            
                        
              //lista.add(new obj_dos_campos("0"," - Seleccione - "));
            
            while (rs.next()){
            
      
           lista.add(new obj_tres_campos (rs.getString("pro_mal_idn"), 
                                             rs.getString("detalle") ,
                                            rs.getString("precio")
                                             
                                             ));
           
           
            }
                        
                                    
                       }
           
                         
           } catch (Exception e) {
            e.printStackTrace();
            //lista.add(new obj_un_campo_string("ERROR"));
           
        } finally {
                     
            
      /*       if (salida == 1){
        lista.add(new obj_un_campo_string("si"));
        }else{
        lista.add(new obj_un_campo_string("no"));
        }*/
                 
            try {
                
               
                    c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            
            
            }
        }
           
        
        return lista;
    }    
    
       
       
       //*//------------------------------------------------------------------------------------------------------------------
       ///*******************************************************************************************************************
     
  public static ArrayList<obj_dos_campos> promociones_dela_malla_ejecucion_Arancel_muestra_ejecuciones_academicas_destino(int funcion_modalidad, String eje_idn ) {
      ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
        
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            
            sql = "{call flex_promociones_dela_malla_ejecucion_Arancel_muestra_ejecuciones_academicas_destino (?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setInt(1,funcion_modalidad);
            ps.setString(2,eje_idn.trim());
            
                                
            ResultSet rs = ps.executeQuery();
            
             lista.add(new obj_dos_campos("0"," - Seleccione - "));   
            
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos (rs.getString("eje_idn"), 
                                             rs.getString("eje_nombre")));
           
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
    
    //*/*********************************************************************************************************************
  
  
 // 
  
  //
/////////////////////////////////////////////////
  
  //******************************************************************************
      
           public static ArrayList<obj_un_campo_string> promociones_dela_malla_ejecucion_Arancel_marca_deshabilita_ya_ingresados(String eje_idn,
                                                                                                  ArrayList<?> arreglo_ele_con_pag_idn,
                                                                                                  ArrayList<?> arreglo10000
                                                                                                  ) {
    
        ArrayList<obj_un_campo_string> lista = new ArrayList<obj_un_campo_string>();
    
        Connection c=null;
        try {
            
          
           String sql;
            
                int size2 = arreglo_ele_con_pag_idn.size();   
                int size = arreglo10000.size();
                
                obj_un_campo_string registro = null;
                obj_un_campo_string registro_1 = null;
                
                 int x;    
                int j;
    
             for (x=0; x<size2; x++) 
                {
                    
                     registro_1 = (obj_un_campo_string) arreglo_ele_con_pag_idn.get(x);
                     
                                for (j=0; j<size; j++) 
                                   {
                                            try
                                            {
                                           registro = (obj_un_campo_string) arreglo10000.get(j);
                                            c = conexion_odbc.Connexion_datos();
                                            sql = "{call flex_promociones_dela_malla_ejecucion_Arancel_marca_deshabilita_ya_ingresados  (?,?,?)}" ;
                                            CallableStatement ps1 = c.prepareCall(sql);
                                           
                                            
                                             ps1.setString(1,eje_idn.trim());
                                             ps1.setString(2,registro_1.getcampo_uno().toString());
                                             ps1.setString(3,registro.getcampo_uno().toString());
                                            
                                            
                                            
                                            
                                            
                                            ps1.execute();
                                            
                                            
                                              ResultSet rs = ps1.executeQuery();

                          while (rs.next()){

                        lista.add(new obj_un_campo_string (rs.getString("salida")
                                                          
                                                                      ));

                            }
                                            
                                            
                                            
                                                }
                                                catch (Exception e) {
                                                      e.printStackTrace();
                                                }
                                                finally 
                                                {
                                                }



                                    }

                           }


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
           
 //*//------------------------------------------------------------------------------------------------------------------
  
  
  
         //*/*********************************************************************************************************************
 
       public frm_promociones_dela_malla_ejecucion_arancel_return() {
    }
    
}
