package com.app.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.admin.Admin;
import com.app.databaseconnection.DBConnection;

@WebServlet(urlPatterns = "/login")
public class LoginController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd=req.getRequestDispatcher("html/login.html");
		rd.forward(req, resp);
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection connection=DBConnection.getConnectionToDatabase();
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		String username1 = null,password1 = null;
		Admin admin = new Admin();
		admin.setUsername(username);
		admin.setPassword(password);
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT username,password FROM admin WHERE username = ? and password = ? ");
			preparedStatement.setString(1, admin.getUsername());
			preparedStatement.setString(2, admin.getPassword());
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				username1 = rs.getString(1);
				password1 = rs.getString(2);
				System.out.println(username1);
				System.out.println(password1);
			}
			System.out.println(admin.getUsername());
			System.out.println(admin.getPassword());
			if(admin.getUsername().equals(username1)&&admin.getPassword().equals(password1)) {
				RequestDispatcher rd=req.getRequestDispatcher("html/admin.html");
				HttpSession session=req.getSession();
				session.setAttribute("username", username);
				rd.forward(req, resp);
			}
			else {
				req.getRequestDispatcher("index.html").include(req, resp);;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


}
