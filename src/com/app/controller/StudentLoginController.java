package com.app.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.dao.ApplicationDao;
import com.app.user.Student;

@WebServlet("/studentLogin")
public class StudentLoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("html/studentLogin.html").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id=Integer.parseInt(req.getParameter("id"));
		ApplicationDao dao=new ApplicationDao();
		Student student=null;
		try {
			student=dao.getStudentById(id);			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(student!=null) {
			req.setAttribute("student", student);
			req.getRequestDispatcher("html/studentResults.html").forward(req, resp);
		}
		else {
			resp.getWriter().print("<html><body><h1>Student credentials are Invalid please enter valid</h1></body></html>");
			req.getRequestDispatcher("html/studentLogin.html").include(req, resp);
		}
	}
	
}
