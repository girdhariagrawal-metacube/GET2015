package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	private static final String DATABASE_PATH = "jdbc:mysql://localhost:3306/vehicle";
	private static final String USERNAME= "root";
	private static final String PASSWORD = "mysql";
	
	public static Connection getConnection() {
		Connection connectionObject = null;
		/* Register Driver */
		try {
//			Class.forName(DRIVER_NAME);
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		} catch(SQLException exception) {
			System.out.println("The Class Specified is not present!!");
		}

		/* Opening connection */
		try {
			connectionObject = DriverManager.getConnection(DATABASE_PATH,USERNAME,PASSWORD);
		} catch(SQLException exception) {
			System.out.println("There is a SQL related error!!");
		}

		return connectionObject;
	}
}
