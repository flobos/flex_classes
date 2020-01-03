/*
 * EchoService.java
 *
 * Created on 7 de noviembre de 2006, 03:36 PM
 */

package libreria;
import flex.messaging.*;
import java.util.*;
/**
 *
 * @author  Esteban 
 */
public class EchoService {
//***********************************************************************************************************      
    @SuppressWarnings("finally")
	public static ArrayList<obj_un_campo> sub_entidad_identificacion(String sub_ent_idn, String ent_reg_nombre) {
        ArrayList<obj_un_campo> lista = new ArrayList<obj_un_campo>();
        String flag = "0";
        
        try
        {
            FlexSession session = FlexContext.getFlexSession();
            
            //FlexContext.getFlexSession().setAttribute("sub_entidad_idn", sub_ent_idn);
            //FlexContext.getFlexSession().setAttribute("entidad_registro_nombre", ent_reg_nombre);
            
            session.setAttribute("sub_entidad_idn", sub_ent_idn);
            session.setAttribute("entidad_registro_nombre", ent_reg_nombre);
        }
        
        catch (Exception e) 
        {
            e.printStackTrace();
            flag = "1";
        }        
        finally
        {
            
                  
            lista.add(new obj_un_campo(flag));
            return lista;
        }

    }
//***********************************************************************************************************    
    @SuppressWarnings("finally")
	public static ArrayList<obj_un_campo> sub_entidad_funcion_modalidad(String sub_fun_mod_idn) {
        ArrayList<obj_un_campo> lista = new ArrayList<obj_un_campo>();
        String flag = "0";
        
        try
        {
            FlexSession session = FlexContext.getFlexSession();
            
            session.setAttribute("sub_funcion_modalidad", sub_fun_mod_idn);
        }
        
        catch (Exception e) 
        {
            e.printStackTrace();
            flag = "1";
        }        
        finally
        {
            
                  
            lista.add(new obj_un_campo(flag));
            return lista;
        }

    }
//***********************************************************************************************************    
    @SuppressWarnings("finally")
	public static ArrayList<obj_un_campo> ejecucion_academica(String eje_aca_idn) {
        ArrayList<obj_un_campo> lista = new ArrayList<obj_un_campo>();
        String flag = "0";
        
        try
        {
            FlexSession session = FlexContext.getFlexSession();
            
            session.setAttribute("ejecucion_academica", eje_aca_idn);
        }
        
        catch (Exception e) 
        {
            e.printStackTrace();
            flag = "1";
        }        
        finally
        {
            
                  
            lista.add(new obj_un_campo(flag));
            return lista;
        }

    }     
    
//***********************************************************************************************************
//***********************************************************************************************************    
// Retorna Valores
//***********************************************************************************************************
        @SuppressWarnings("finally")
		public static ArrayList<obj_dos_campos> return_sub_entidad_identificacion() 
        {
            ArrayList<obj_dos_campos> lista = new ArrayList<obj_dos_campos>();
            
            try 
            {
                FlexSession session = FlexContext.getFlexSession();
                String sub_ent_idn = ((String) session.getAttribute("sub_entidad_idn"));
                String ent_reg_nombre = ((String) session.getAttribute("entidad_registro_nombre"));
                lista.add(new obj_dos_campos(sub_ent_idn, ent_reg_nombre));
            }
            catch (Exception e) 
            {
                e.printStackTrace();
            }
            finally
            {
                return lista;
            }            
        }
//***********************************************************************************************************
        @SuppressWarnings("finally")
		public static ArrayList<obj_un_campo> return_sub_entidad_funcion_modalidad() 
        {
            ArrayList<obj_un_campo> lista = new ArrayList<obj_un_campo>();
            
            try 
            {
                FlexSession session = FlexContext.getFlexSession();
                String sub_fun_mod_idn = ((String) session.getAttribute("sub_funcion_modalidad"));
                lista.add(new obj_un_campo(sub_fun_mod_idn));
            }
            catch (Exception e) 
            {
                e.printStackTrace();
            }
            finally
            {
                return lista;
            }            
        }
//***********************************************************************************************************
        @SuppressWarnings("finally")
		public static ArrayList<obj_un_campo> return_ejecucion_academica() 
        {
            ArrayList<obj_un_campo> lista = new ArrayList<obj_un_campo>();
            
            try 
            {
                FlexSession session = FlexContext.getFlexSession();
                String eje_aca_idn = ((String) session.getAttribute("ejecucion_academica"));
                lista.add(new obj_un_campo(eje_aca_idn));
            }
            catch (Exception e) 
            {
                e.printStackTrace();
            }
            finally
            {
                return lista;
            }            
        }
//*********************************************************************************************************** 
    @SuppressWarnings("finally")
	public static ArrayList<obj_un_campo> funcion_modalidad(String func_mod_fun_idn, String mod_idn) {
        ArrayList<obj_un_campo> lista = new ArrayList<obj_un_campo>();
        String flag = "0";
        
        try
        {
            FlexSession session = FlexContext.getFlexSession();
            
            //FlexContext.getFlexSession().setAttribute("sub_entidad_idn", sub_ent_idn);
            //FlexContext.getFlexSession().setAttribute("entidad_registro_nombre", ent_reg_nombre);
            
            session.setAttribute("func_mod_fun_idn", func_mod_fun_idn);
            session.setAttribute("mod_idn", mod_idn);
        }
        
        catch (Exception e) 
        {
            e.printStackTrace();
            flag = "1";
        }        
        finally
        {
            
                  
            lista.add(new obj_un_campo(flag));
            return lista;
        }

    }
//***********************************************************************************************************
        @SuppressWarnings("finally")
		public static ArrayList<obj_un_campo> return_funcion_modalidad() 
        {
            ArrayList<obj_un_campo> lista = new ArrayList<obj_un_campo>();
            
            try 
            {
                FlexSession session = FlexContext.getFlexSession();
                String func_mod_fun_idn = ((String) session.getAttribute("func_mod_fun_idn"));
                lista.add(new obj_un_campo(func_mod_fun_idn));
            }
            catch (Exception e) 
            {
                e.printStackTrace();
            }
            finally
            {
                return lista;
            }            
        }
//***********************************************************************************************************
        @SuppressWarnings("finally")
		public static ArrayList<obj_un_campo> return_modalidad() 
        {
            ArrayList<obj_un_campo> lista = new ArrayList<obj_un_campo>();
            
            try 
            {
                FlexSession session = FlexContext.getFlexSession();
                String mod_idn = ((String) session.getAttribute("mod_idn"));
                lista.add(new obj_un_campo(mod_idn));
            }
            catch (Exception e) 
            {
                e.printStackTrace();
            }
            finally
            {
                return lista;
            }            
        }
//***********************************************************************************************************         
    public EchoService() {
    }    
}
