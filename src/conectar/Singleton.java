package conectar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Singleton {

	private static Connection conn = null;
	private String driver;
	private String url;
	private String usuario;
	private String password;
	
	private Singleton() {
		url = "jdbc:oracle:thin:@localhost:1521:xe";
		driver = "oracle.jdbc.driver.OracleDriver";
		usuario = "coffeejava";
		password = "talentodigital123";
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, usuario, password);	
		}
		catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		if (conn == null) {
			new Singleton();
		}
		return conn;
	}
}
