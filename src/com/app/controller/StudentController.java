package com.app.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
			PrintWriter out=resp.getWriter();
			out.println("<a href='index.html'>Home</a>");
			out.println("<h1>Employees List</h1>");
			out.print("<table border='1' width='70%'");
			out.print("<tr><th>Id</th><th>FirstName</th><th>LastName</th><th>Email</th><th>Address</th><th>Modules</th><th>Edit</th><th>Delete</th></tr>");
			for(Student e:studentList){
				out.print("<center><tr><td>"+e.getId()+"</td><td>"+e.getFirstName()+"</td><td>"+e.getLastName()+"</td><td>"
						+e.getContactEmail()+"</td><td>"+e.getAddress()+"</td><td>"+e.getModules()+"</td><td><a href='EditServlet?id="+e.getId()
						+"'>edit</a></td><td><a href='DeleteServlet?id="+e.getId()+"'>delete</a></td></tr>");
			}
			out.print("</center>"+"</table>");
			req.setAttribute("studentList", studentList);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
