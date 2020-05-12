package com.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.app.admin.Admin;
import com.app.databaseconnection.DBConnection;
import com.app.user.Student;

public class ApplicationDao {

	Connection connection=DBConnection.getConnectionToDatabase();

	public int registerUser(Student student) {
		int rowsEffefted=0;
		try {
			String sql="insert into student(id,firstname,lastname,email,address,modules) values(?,?,?,?,?,?)";
			PreparedStatement pstmt=connection.prepareStatement(sql);
			for (String str : student.getModules()) {				
				pstmt.setInt(1, student.getId());
				pstmt.setString(2, student.getFirstName());
				pstmt.setString(3, student.getLastName());
				pstmt.setString(4, student.getContactEmail());
				pstmt.setString(5, student.getAddress());
				pstmt.setString(6,str);
				rowsEffefted=pstmt.executeUpdate();
			}


		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowsEffefted;
	}

	public int registerAdmin(Admin admin) {
		int rowsEffefted=0;
		try {
			String sql="insert into admin(username,email,password) values(?,?,?)";
			PreparedStatement pstmt=connection.prepareStatement(sql);
			pstmt.setString(1, admin.getUsername());
			pstmt.setString(2, admin.getEmail());
			pstmt.setString(3, admin.getPassword());
			rowsEffefted=pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowsEffefted;
	}

	public boolean loginAdmin(Admin admin) {
		boolean valid=false;
		String email=null,password=null;
		try {
			String sql="SELECT email,password FROM admin WHERE email=?";
			PreparedStatement pstmt=connection.prepareStatement(sql);
			pstmt.setString(1, admin.getUsername());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				email=rs.getString("email");
				System.out.println(email);
				password=rs.getString("password");
				System.out.println(password);
				if(admin.getUsername().equals(email)&&admin.getPassword().equals(password)) {
					valid=true;
				}
				else {
					valid=false;
				}
			}

		}catch (SQLException e) {
			e.printStackTrace();
		}
		return valid;
	}
	public boolean loginAdmin1(Admin admin) {
		boolean valid=false;
		String username=null,password=null;
		try {
			String sql="SELECT username,password FROM admin WHERE username=?";
			PreparedStatement pstmt=connection.prepareStatement(sql);
			pstmt.setString(1, admin.getUsername());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				username=rs.getString("username");
				password=rs.getString("password");
			}
			if(admin.getUsername().equals(username)&&admin.getPassword().equals(password)) {
				valid=true;
			}
			else {
				valid=false;
			}

		}catch (SQLException e) {
			e.printStackTrace();
		}
		return valid;
	}


	public int insertStudent(Student student) throws SQLException {
		int rowInserted=0;
		String sql = "INSERT INTO student (id, firstname, lastName, contactEmail, address, modules)"
				+ " VALUES (?, ?, ?, ?, ?, ?)";
		PreparedStatement pstmt = connection.prepareStatement(sql);
		for (String str : student.getModules()) {				
			pstmt.setInt(1, student.getId());
			pstmt.setString(2, student.getFirstName());
			pstmt.setString(3, student.getLastName());
			pstmt.setString(4, student.getContactEmail());
			pstmt.setString(5, student.getAddress());
			pstmt.setString(6,str);
			rowInserted=pstmt.executeUpdate();
		}
		return rowInserted;
	}

	public List<Student> listAllStudents() throws SQLException {
		List<Student> studentlist = new ArrayList<>();
		String sql = "SELECT * FROM student";
		
		int temp=0;
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		List<String> mod=new ArrayList<>();
		Student student = null;
		while (resultSet.next()) {
			int id = resultSet.getInt("id");
			String firstName = resultSet.getString("firstName");
			String lastName = resultSet.getString("lastName");
			String contactEmail = resultSet.getString("email");
			String address = resultSet.getString("address");
			String str=resultSet.getString("modules");
			if(id!=temp&&temp!=0) {
				studentlist.add(student);
				mod=new ArrayList<>();
			}
			mod.add(str);
			temp=id;
			student = new Student(id, firstName, lastName, contactEmail, address, mod);
		}
		return studentlist;
	}

	public boolean deleteBook(Student student) throws SQLException {
		String sql = "DELETE FROM student where id = ?";

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, student.getId());

		boolean rowDeleted = statement.executeUpdate() > 0;
		return rowDeleted;     
	}

	public boolean updateStudent(Student student) throws SQLException {
		String sql = "UPDATE student SET firstName = ?, lastName = ?, contactEmail = ?, address=?, modules=?";
		sql += " WHERE id = ?";

		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, student.getFirstName() );
		statement.setString(2, student.getLastName());
		statement.setString(3, student.getContactEmail());
		statement.setString(4, student.getAddress());
		statement.setString(5, String.valueOf(student.getModules()));

		boolean rowUpdated = statement.executeUpdate() > 0;
		return rowUpdated;     
	}

	public Student getStudentById(int id) throws SQLException {
		Student student = null;
		String sql = "SELECT * FROM student WHERE id = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, id);

		ResultSet resultSet = statement.executeQuery();

		if (resultSet.next()) {
			String firstName = resultSet.getString("firstName");
			String lastName = resultSet.getString("lastName");
			String contactEmail = resultSet.getString("contactEmail");
			String address = resultSet.getString("address");
			String str= resultSet.getString("module");
			List<String> mod=new ArrayList<>();
			mod.add(str);
			student=new Student(id, firstName, lastName, contactEmail, address, mod);
		}
		return student;
	}
}