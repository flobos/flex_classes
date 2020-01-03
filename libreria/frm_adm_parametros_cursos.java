/*
 * frm_adm_producto_campus_elemento.java
 *
 * Created on 24 de abril de 2008, 10:53
 */

package libreria;

import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author  Administrador
 */
public class frm_adm_parametros_cursos {
    
    /** Creates a new instance of frm_adm_producto_campus_elemento */
  
 //*********************************************************************
 

//*********************************************************************
  
 public static ArrayList<obj_dos_campos> llena_combo_malla_curricular(String  func_mod_fun_idn) {
      ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call frm_adm_producto_campus_elemento_llena_combo_malla_curricular (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
         
                       
            ps.setString(1, func_mod_fun_idn.trim());
            ps.execute();
            
            
            
                      
            ResultSet rs = ps.executeQuery();
            
             
              lista.add(new obj_dos_campos("0"," - Seleccione - "));
                 
            
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos (rs.getString("mal_mod_idn"), 
                                         rs.getString("mal_nombre")));
           
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
//*****************************************************************************
     public static ArrayList<obj_dos_campos> llena_grilla_cursos(String mal_mod_idn) {
         ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_parametros_cursos_llena_grilla_cursos (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, mal_mod_idn.trim());
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
      
             lista.add(new obj_dos_campos (rs.getString("pro_cam_idn"), 
                                         rs.getString("cur_nombre")));
           
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
//************************************************
     
          public static ArrayList<obj_dos_campos> llena_grilla_todos_los_cursos() {
         ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_parametros_cursos_llena_grilla_todos_los_cursos ()}" ;
            CallableStatement ps = c.prepareCall(sql);
                        
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
      
             lista.add(new obj_dos_campos (rs.getString("pro_cam_idn"), 
                                         rs.getString("cur_nombre")));
           
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
  
 public static ArrayList<obj_dos_campos> llena_combo_caracter() {
      ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_parametros_cursos_llena_combo_caracter ()}" ;
            CallableStatement ps = c.prepareCall(sql);
         
                       
          
            ps.execute();
            
            
            
                      
            ResultSet rs = ps.executeQuery();
            
             
              lista.add(new obj_dos_campos("0"," - Seleccione - "));
                 
            
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos (rs.getString("car_hor_idn"), 
                                         rs.getString("car_hor_nombre")));
           
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
//*****************************************************************************
     //*********************************************************************
  
 public static ArrayList<obj_dos_campos> llena_combo_nivel() {
      ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_parametros_cursos_llena_combo_nivel ()}" ;
            CallableStatement ps = c.prepareCall(sql);
         
                       
          
            ps.execute();
            
            
            
                      
            ResultSet rs = ps.executeQuery();
            
             
              lista.add(new obj_dos_campos("0"," - Seleccione - "));
                 
            
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos (rs.getString("niv_hor_idn"), 
                                         rs.getString("niv_hor_nombre")));
           
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
//*****************************************************************************
 //*****************************************************************************
     public static ArrayList<obj_seis_campos> llena_grilla_detalle_horas(String car_hor_idn,String niv_hor_idn) {
         ArrayList<obj_seis_campos> lista = new ArrayList<obj_seis_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_parametros_cursos_llena_grilla_detalle_horas (?,?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, car_hor_idn.trim());
             ps.setString(2, niv_hor_idn.trim());
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
      
             lista.add(new obj_seis_campos (rs.getString("tip_subtip_car_niv_hor_cantidad"), 
                                        rs.getString("car_hor_nombre"), 
                                        rs.getString("niv_hor_nombre"), 
                                        rs.getString("sub_tip_hor_nombre"), 
                                        rs.getString("tip_hor_nombre"),
                                         rs.getString("tip_subtip_car_niv_hor_idn")));
             
             
             
             
            
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
//************************************************
 
     //******************************************************************************
 /*public static ArrayList asigna_parametros_producto_campus(  String tip_subtip_car_niv_hor_idn,  ArrayList arreglo_seleccionados) {
    
        ArrayList lista = new ArrayList();
        Connection c=null;
        String exito;
        int salida = 1;
        
        try {
            c = conexion_odbc.Connexion_datos();
             String sql1;
              int size = arreglo_seleccionados.size();
              obj_un_campo_string registro = null;
                
            int j;
            for (j=0; j<size; j++) 
               {                    
                        registro = (obj_un_campo_string) arreglo_seleccionados.get(j);
                        sql1 = "{call flex_adm_parametros_cursos_asigna_parametros_producto_campus (?,?)}" ;
                        CallableStatement ps1 = c.prepareCall(sql1);
                         ps1.setString(1,tip_subtip_car_niv_hor_idn.trim());
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
     */
 //-------------------------------------------------------------------------------------------------------------
 
   //******************************************************************************
  public static ArrayList<obj_nueve_campos> verifica_existe_curso_parametro( ArrayList<?> arreglo_cursos) {
      ArrayList<obj_nueve_campos> lista_p = new ArrayList<obj_nueve_campos>();
        Connection c=null;
         try {
            
            String sql;
                      
            int size = arreglo_cursos.size();   
             
                
                obj_un_campo_string registro = null;
                
                 int x;    
              
    
             for (x=0; x<size; x++) 
                {
                    
                     registro = (obj_un_campo_string) arreglo_cursos.get(x);
      
                              c = conexion_odbc.Connexion_datos();
            
                  sql = "{call flex_adm_parametros_cursos_verifica_existe_curso_parametro  (?)}"  ;
            CallableStatement ps = c.prepareCall(sql);
            
             
             ps.setString(1,registro.getcampo_uno().toString());
            
             
             ps.execute();
            
            
           /*  
           ps.setString(1,registro_reg.getcampo_uno());
            ps.execute();
            */
             

                         ResultSet rs = ps.executeQuery();

                          while (rs.next()){

                                lista_p.add(new obj_nueve_campos (rs.getString("pro_cam_par_asig_hor_idn"), 
                                                        rs.getString("pro_cam_idn"),
                                                         rs.getString("tip_subtip_car_niv_hor_idn"),
                                                          rs.getString("tip_subtip_car_niv_hor_cantidad"),
                                                           rs.getString("car_hor_nombre"),
                                                            rs.getString("niv_hor_nombre"),
                                                             rs.getString("sub_tip_hor_nombre"),
                                                              rs.getString("tip_hor_nombre"),
                                                        rs.getString("tip_subtip_car_niv_hor_idn")));
                             // lista_p.add(new obj_un_campo_string (rs.getString("salida")
                                                          
                                                                      //));


                        }
 
     
             
             }
  
        }
        
  catch (Exception e) {
            e.printStackTrace();
        } finally {
           // lista_p.add(new obj_un_campo_string("OK"));   
            try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
         return lista_p;
   }
//-------------------------------------------------------------------
  
  //******************************************************************************
         
          public static ArrayList<?> asigna_parametros_producto_campus(ArrayList<?> arreglo_grilla, ArrayList<?> arreglo_seleccionados) {
    
        ArrayList<?> lista = new ArrayList<Object>();
    
        Connection c=null;
        try {
            
          
           String sql;
            
                int size2 = arreglo_grilla.size();   
                int size = arreglo_seleccionados.size();
                
                obj_un_campo_string registro = null;
                obj_un_campo_string registro_2 = null;
                
                 int x;    
                int j;
    
             for (x=0; x<size2; x++) 
                {
                    
                     registro = (obj_un_campo_string) arreglo_grilla.get(x);
                     
                                for (j=0; j<size; j++) 
                                   {

                                           registro_2 = (obj_un_campo_string) arreglo_seleccionados.get(j);
                                            c = conexion_odbc.Connexion_datos();
                                            sql = "{call flex_adm_parametros_cursos_asigna_parametros_producto_campus  (?,?)}" ;
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
    
  
  
  
//**************************************************  
          
          
//          //******************************************************************************
//         
//          public static ArrayList modifica_parametros_producto_campus( ArrayList arreglo_grilla, String pro_cam_idn) {
//    
//        ArrayList lista = new ArrayList();
//    
//        String exito;
//        int salida = 1;
//                    Connection c=null;
//        try {
//            
//          
//           String sql;
//            
//                int size2 = arreglo_grilla.size();   
//              //  int size = arreglo_seleccionados.size();
//                
//                obj_un_campo_string registro = null;
//                //obj_un_campo_string registro_2 = null;
//                
//                 int x;    
//                //int j;
//    
//             for (x=0; x<size2; x++) 
//                {
//                    
//                     registro = (obj_un_campo_string) arreglo_grilla.get(x);
//                     
//                               // for (j=0; j<size; j++) 
//                                 //  {
//
//                                         //  registro_2 = (obj_un_campo_string) arreglo_seleccionados.get(j);
//                                            c = conexion_odbc.Connexion_datos();
//                                            sql = "{call flex_adm_parametros_cursos_modifica_parametros_producto_campus  (?,?)}" ;
//                                            CallableStatement ps1 = c.prepareCall(sql);
//                                           
//                                            
//                                           
//                                            ps1.setString(1,registro.getcampo_uno());
//                                            ps1.setString(2, pro_cam_idn.trim());
//                                            ps1.execute();
//                        
//                        
//                                //}
//                                         
//                       }
//           
//                         
//           } catch (Exception e) {
//            e.printStackTrace();
//            //lista.add(new obj_un_campo_string("ERROR"));
//           
//        } finally {
//                     
//            
//      /*       if (salida == 1){
//        lista.add(new obj_un_campo_string("si"));
//        }else{
//        lista.add(new obj_un_campo_string("no"));
//        }*/
//                 
//            try {
//                
//               
//                    c.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            
//            
//            }
//        }
//           
//        
//        return lista;
//    }    
//    
//  
  //-------------------------------------------------------------------------
          
      public static ArrayList<?> elimina_antes_de_modificar(String pro_cam_idn) {
         ArrayList<?> lista = new ArrayList<Object>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_parametros_cursos_elimina_antes_de_modificar_parametros_producto_campus (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, pro_cam_idn.trim());
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
      
           //  lista.add(new obj_dos_campos (rs.getString("pro_cam_idn"), 
                                      //   rs.getString("cur_nombre")));
           
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
//************************************************       
        
 //-------------------------------------------------------------------------------------------------------------
 
  
          
           //******************************************************************************
 public static ArrayList<?> modifica_parametros_producto_campus( ArrayList<?> arreglo_seleccionados, String pro_cam_idn ) {
    
        ArrayList<?> lista = new ArrayList<Object>();
        Connection c=null;
        try {
            c = conexion_odbc.Connexion_datos();
             String sql1;
              int size = arreglo_seleccionados.size();
              obj_un_campo_string registro = null;
                
            int j;
            for (j=0; j<size; j++) 
               {
                    
                        registro = (obj_un_campo_string) arreglo_seleccionados.get(j);
                        sql1 = "{call flex_adm_parametros_cursos_modifica_parametros_producto_campus (?,?)}" ;
                        CallableStatement ps1 = c.prepareCall(sql1);
                        ps1.setString(1,registro.getcampo_uno());
                        ps1.setString(2,pro_cam_idn.trim());
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
     
 //-------------------------------------------------------------------------------------------------------------
 //-------------------------------------------------------------------------
          
      public static ArrayList<?> elimina_parametro(String pro_cam_idn) {
         ArrayList<?> lista = new ArrayList<Object>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_parametros_cursos_elimina_parametros_producto_campus (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, pro_cam_idn.trim());
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
      
           //  lista.add(new obj_dos_campos (rs.getString("pro_cam_idn"), 
                                      //   rs.getString("cur_nombre")));
           
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
//************************************************     
  //*********************************************************************
  
 public static ArrayList<obj_dos_campos> llena_combo_primera_letra() {
      ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_parametros_cursos_flex_adm_parametros_cursos_llena_combo_primera_letra ()}" ;
            CallableStatement ps = c.prepareCall(sql);
         
                       
          
            ps.execute();
            
            
            
                      
            ResultSet rs = ps.executeQuery();
            
             
              lista.add(new obj_dos_campos("0"," - Seleccione - "));
                 
            
            while (rs.next()){
            
      
            lista.add(new obj_dos_campos (rs.getString("D1"), 
                                         rs.getString("L1")));
           
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
//*****************************************************************************
  //*****************************************************************************
     public static ArrayList<obj_dos_campos> busca_cursos_por_primera_letra(String valor) {
         ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_parametros_cursos_busca_cursos_por_primera_letra (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, valor.trim());
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
      
             lista.add(new obj_dos_campos (rs.getString("pro_cam_idn"), 
                                         rs.getString("cur_nombre")));
           
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
//************************************************
  //-------------------------------------------------------------------------
          
      public static ArrayList<?> elimina_parametros_masivo(String pro_cam_idn) {
         ArrayList<?> lista = new ArrayList<Object>();
        Connection c=null;
         try {
            String sql;
            c = conexion_odbc.Connexion_datos();
            sql = "{call flex_adm_parametros_cursos_elimina_parametros_producto_campus (?)}" ;
            CallableStatement ps = c.prepareCall(sql);
            ps.setString(1, pro_cam_idn.trim());
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
            
      
           //  lista.add(new obj_dos_campos (rs.getString("pro_cam_idn"), 
                                      //   rs.getString("cur_nombre")));
           
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
//************************************************     
  
    
    //******************************************************************************
 public static ArrayList<?> elimina_parametros_masivo(   ArrayList<?> arreglo_seleccionados) {
    
        ArrayList<?> lista = new ArrayList<Object>();
        Connection c=null;
        try {
            c = conexion_odbc.Connexion_datos();
             String sql1;
              int size = arreglo_seleccionados.size();
              obj_un_campo_string registro = null;
                
            int j;
            for (j=0; j<size; j++) 
               {
                    
                        registro = (obj_un_campo_string) arreglo_seleccionados.get(j);
                        sql1 = "{call flex_adm_parametros_cursos_elimina_parametros_producto_campus_masivo (?)}" ;
                        CallableStatement ps1 = c.prepareCall(sql1);
                        
                         ps1.setString(1,registro.getcampo_uno());
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
     
 //-------------------------------------------------------------------------------------------------------------
 
    
    //******************************************************************************
 public static ArrayList<?> elimina_antes_de_modificar_masivo(   ArrayList<?> arreglo_seleccionados) {
    
        ArrayList<?> lista = new ArrayList<Object>();
        Connection c=null;
        try {
            c = conexion_odbc.Connexion_datos();
             String sql1;
              int size = arreglo_seleccionados.size();
              obj_un_campo_string registro = null;
                
            int j;
            for (j=0; j<size; j++) 
               {
                    
                        registro = (obj_un_campo_string) arreglo_seleccionados.get(j);
                        sql1 = "{call flex_adm_parametros_cursos_elimina_antes_de_modificar_masivo (?)}" ;
                        CallableStatement ps1 = c.prepareCall(sql1);
                        
                         ps1.setString(1,registro.getcampo_uno());
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
     
 //-------------------------------------------------------------------------------------------------------------
    //******************************************************************************
         
          public static ArrayList<?> RE_asigna_parametros_producto_campus(ArrayList<?> arreglo_grilla, ArrayList<?> arreglo_seleccionados) {
    
        ArrayList<?> lista = new ArrayList<Object>();
    
        Connection c=null;
        try {
            
          
           String sql;
            
                int size2 = arreglo_grilla.size();   
                int size = arreglo_seleccionados.size();
                
                obj_un_campo_string registro = null;
                obj_un_campo_string registro_2 = null;
                
                 int x;    
                int j;
    
             for (x=0; x<size2; x++) 
                {
                    
                     registro = (obj_un_campo_string) arreglo_grilla.get(x);
                     
                                for (j=0; j<size; j++) 
                                   {

                                           registro_2 = (obj_un_campo_string) arreglo_seleccionados.get(j);
                                            c = conexion_odbc.Connexion_datos();
                                            sql = "{call flex_adm_parametros_cursos_RE_asigna_parametros_producto_campus  (?,?)}" ;
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
    
  
  
  
//**************************************************  
//**************************************************   
      public frm_adm_parametros_cursos() {
    }


}
