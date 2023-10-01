package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
	private static String username = "root";
	private static String password = "";
	private static String url = "jdbc:mysql://localhost:3306/db_studyunity";
	public static Connection connector;
	
	private DBConnector() {}
	
	public static Connection getInstance() throws SQLException, ClassNotFoundException {
		if(connector==null ) {
			Class.forName("com.mysql.jdbc.Driver");
			connector = DriverManager.getConnection(url, username, password);
		}
		
		return connector;
	}
}
