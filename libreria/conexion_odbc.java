
package libreria;

 
import java.sql.Connection;
import java.sql.DriverManager;
import javax.sql.DataSource;    
import org.apache.commons.dbcp.BasicDataSource;


@SuppressWarnings("unused")
public class conexion_odbc {

	public conexion_odbc() {
	}


	public static Connection Connexion_datos() throws java.sql.SQLException {
		
		BasicDataSource Ds_pool_coneccion = new BasicDataSource();
		Ds_pool_coneccion.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Ds_pool_coneccion.setUsername("");
		Ds_pool_coneccion.setPassword("");
		Ds_pool_coneccion.setUrl("jdbc:sqlserver://192.168.1.4:1433;DatabaseName=datos_belzart;");
		DataSource Fuente_datos = Ds_pool_coneccion;
		
		return Fuente_datos.getConnection();
			

	}
}
