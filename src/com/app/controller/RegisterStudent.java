package com.app.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.dao.ApplicationDao;
import com.app.user.Student;

@WebServlet(urlPatterns = "/register")
public class RegisterStudent extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id=Integer.parseInt(req.getParameter("id"));
		String firstname=req.getParameter("firstname");
		String lastname=req.getParameter("flastname");
		String contactEmail=req.getParameter("contactEmail");
		String address=req.getParameter("address");
		//String 
		
		Student student=new Student(id, firstname, lastname, contactEmail, address, null);
		
		ApplicationDao dao=new ApplicationDao();
		int rows=dao.registerUser(student);
		
		if(rows==0) {
			resp.sendRedirect("/index.html");
		}
		else {
			
			resp.sendRedirect("html/register.html");
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd=req.getRequestDispatcher("/html/register.html");
		rd.forward(req, resp);
	}
	
	public String getHTMLString(String filePath,String message) {
		return null;
	}
	
}
