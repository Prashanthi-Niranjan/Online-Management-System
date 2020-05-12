package com.app.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.dao.ApplicationDao;
import com.app.user.Student;

@WebServlet("/getStudents")
public class StudentController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		try {
			new ApplicationDao().getStudentById(id);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			ApplicationDao dao=new ApplicationDao();
			List<Student> studentList=dao.listAllStudents();
			req.setAttribute("studentList", studentList);
			System.out.println(studentList);
			resp.getWriter().print(studentList);
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
