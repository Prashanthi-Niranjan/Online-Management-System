package com.app.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.admin.Admin;
import com.app.dao.ApplicationDao;

@WebServlet("/admin")
public class AdminController  extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		boolean valid=false;
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		Admin admin=new Admin();
		admin.setUsername(username);
		admin.setPassword(password);
		resp.setContentType("text/html");
		ApplicationDao dao=new ApplicationDao();
		if(username.contains("@gmail.com")) {
			valid=dao.loginAdmin(admin);
			if(valid) {
				HttpSession session=req.getSession();
				if(session!=null){  
					String name=(String)session.getAttribute("username");  
					resp.getWriter().print("Hello, "+name+" Welcome to Admin Page");  
					req.getRequestDispatcher("html/profile.html").forward(req, resp);
				}  
			}
		}
		else if(!username.contains("@gmail.com")) {
			valid=dao.loginAdmin1(admin);
			if(valid) {
				HttpSession session=req.getSession();
				if(session!=null){  
					String name=(String)session.getAttribute("username");  
					resp.getWriter().print("Hello, "+name+" Welcome to Admin Page");  
					req.getRequestDispatcher("html/profile.html").forward(req, resp);
				}  
			}
		}
		else {
			resp.getWriter().print("User credentials are Not valid");
			req.getRequestDispatcher("html/LoginAdmin.html").include(req, resp);
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		resp.getWriter().print("User created successfully");
		req.getRequestDispatcher("html/LoginAdmin.html").forward(req, resp);
	}

}
