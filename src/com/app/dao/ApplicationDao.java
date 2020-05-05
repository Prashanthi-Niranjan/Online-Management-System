package com.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.app.databaseconnection.DBConnection;
import com.app.user.Student;

public class ApplicationDao {
	
	public int registerUser(Student student) {
		int rowsEffefted=0;
		try {
			//create connection
			Connection connection=DBConnection.getConnectionToDatabase();
			
			String sql="insert into student values(?,?,?,?,?)";
			PreparedStatement pstmt=connection.prepareStatement(sql);
			pstmt.setInt(1, student.getId());
			pstmt.setString(2, student.getFirstName());
			pstmt.setString(3, student.getLastName());
			pstmt.setString(4, student.getContactEmail());
			pstmt.setString(5, student.getAddress());
			
			rowsEffefted=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowsEffefted;
	}
	
	
	public String userCheck(String email) {
		try {
			//create connection
			Connection connection=DBConnection.getConnectionToDatabase();
			
			String sql="insert into student values(?,?,?,?,?)";
			PreparedStatement pstmt=connection.prepareStatement(sql);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
}
