package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnection {
	private static final String URL = "jdbc:mysql://localhost:3306/fruits";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root1234";
	private static dbConnection INSTANCE = new dbConnection();

	private static Connection connection;

	private dbConnection() {
	}

	public static dbConnection getInstance() {
		return INSTANCE;
	}

	public static Connection getConnection() throws SQLException {
		INSTANCE.connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		System.out.println("Connection Successful");

		return connection;
	}

}
