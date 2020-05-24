package com.app.databaseconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	public static Connection getConnectionToDatabase() {
		Connection connection=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/Prashanthi","root","root");
			System.out.println("connection created successfully");			
		} catch (ClassNotFoundException |SQLException e) {
			e.printStackTrace();
		}return connection;
	}
}
