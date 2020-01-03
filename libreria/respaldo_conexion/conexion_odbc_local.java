/*
 * conexion_odbc.java
 *
 * Created on 5 de mayo de 2005, 15:33
 */

package libreria.respaldo_conexion;

/**
 *
 * @author  Fernando Lobos
 */

import java.sql.Connection;
import java.sql.DriverManager;


public class conexion_odbc_local {
    
     static {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            
        }
    }
    
     public conexion_odbc_local() {
    }
    
      public static Connection Connexion_datos() throws java.sql.SQLException {
          
      
         
       return DriverManager.getConnection("jdbc:sqlserver://127.0.0.1;ProgramName=aulavirtualflex;DatabaseName=datos_belzart_local;User=sa;Password=2109");
    }
}
