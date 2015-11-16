package com.metacube.webservices.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.MetaHRMSystemException;


public class ConnectionFactory {

	private final static String URL ="jdbc:mysql://localhost/employee";
	private final static String DRIVER="com.mysql.jdbc.Driver";
	private final static String USERNAME="root";
	private final static String PASSWORD="mysql";

	public static Connection getConnection() throws MetaHRMSystemException {
		Connection connection = null;

		try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
		} catch (ClassNotFoundException e) {
			System.out.println("Could not load driver class, please add mysql jdbc driver to classpath.");
			throw new MetaHRMSystemException("Could not load driver class, please add mysql jdbc driver to classpath.",e);
		} catch (SQLException e) {
			System.out.println("Coult not create connection with database, ["+ e.getMessage() + "]");
			throw new MetaHRMSystemException("Coult not create connection with database, ["+ e.getMessage() + "]", e);
		}
		return connection;
	}

	public static void closeConnection(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				System.out.println("Could not close connection due to following error, ["+ e.getMessage() + "]");
			}
		}
	}
}
