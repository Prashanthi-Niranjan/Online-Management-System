package com.app.databaseconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	public static Connection getConnectionToDatabase() {
		Connection connection=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Jdbc driver working");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/Prashanthi","root","root");
			System.out.println("connection created successfully");			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(connection != null) {
			System.out.println("connection made success");
		}
		return connection;
	}
}
