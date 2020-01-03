package libreria_alm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectionHelper {

    private String url;
    private static String user;
    private static String password;
    private static ConnectionHelper instance;

    private ConnectionHelper() {
    	String driver = null;
        try {
            ResourceBundle bundle = ResourceBundle.getBundle("datos_belzart");
            driver = bundle.getString("jdbc.driver");
            Class.forName(driver);
            url=bundle.getString("jdbc.url");
            user=bundle.getString("jdbc.user");
            password=bundle.getString("jdbc.password");
        } catch (ClassNotFoundException e) {
			System.out.println("ERROR: Error loading JDBC driver. Class " + driver + "not found.");
        }
    }

	public static Connection getConnection() throws SQLException {
		if (instance == null) {
			instance = new ConnectionHelper();
		}
		try {
			return DriverManager.getConnection(instance.url,user,password);
			
		} catch (SQLException e) {
			System.out.println("\nHubo un error en la conexion\n");
			String msg =  " -- Make sure the JDBC connection parameters in WEB-INF\\classes\\flexdemodb.properties are correct and that you successfully started the database.";
			System.out.println("ERROR: " + e.getMessage() + msg);
			throw new SQLException(e.getMessage() + msg);
		}
	}

	public static void close(Connection connection) {
        try {
        	if (connection != null) {
        		connection.close();
        	}
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

}