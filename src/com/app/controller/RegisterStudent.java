package com.app.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.dao.ApplicationDao;
import com.app.user.Student;

@WebServlet(urlPatterns = "/registerStudent")
public class RegisterStudent extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id=Integer.parseInt(req.getParameter("id"));
		String firstname=req.getParameter("firstname");
		String lastname=req.getParameter("lastname");
		String contactEmail=req.getParameter("contactEmail");
		String address=req.getParameter("address");
		String a=req.getParameter("Java");
		String b=req.getParameter("Python");
		String c=req.getParameter("C++");
		String d=req.getParameter("Spring");
		String e=req.getParameter("SOAP");
		String f=req.getParameter("WebServices");
		String g=req.getParameter("JavaScript");
		String h=req.getParameter("Angular");
		String i=req.getParameter("Dot Net");
		String j=req.getParameter("PHP");
		String k=req.getParameter("HTML");
		String l=req.getParameter("CSS");
		String m=req.getParameter("SQL");
		String n=req.getParameter("PL/SQL");
		String o=req.getParameter("MongoDB");
		String p=req.getParameter("NodeJS");
		String q=req.getParameter("ReactJS");
		String r=req.getParameter("MySQL");
		String[] str= {a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r};
		List<String> list=new ArrayList<>();
		for(String s:str) {
			if(s!=null) {
				list.add(s);
			}
		}
		Student student=new Student(id, firstname, lastname, contactEmail, address, list);
		
		ApplicationDao dao=new ApplicationDao();
		int rows=dao.registerUser(student);
		
		if(rows>0) {
			resp.getWriter().print("Hi "+student.getFirstName()+" you have registered successfully");
			req.getRequestDispatcher("html/studentLogin.html").forward(req, resp);
		}
		else {
			resp.sendRedirect("html/registerStudent.html");
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd=req.getRequestDispatcher("/html/registerStudent.html");
		rd.forward(req, resp);
	}
	
	public String getHTMLString(String filePath,String message) {
		return null;
	}
	
}
