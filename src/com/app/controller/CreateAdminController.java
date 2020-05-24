package com.app.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.admin.Admin;
import com.app.dao.ApplicationDao;

@WebServlet("/createAdmin")
public class CreateAdminController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	int rows=0;
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.getRequestDispatcher("html/createAdmin.html").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username=req.getParameter("username");
		String email=req.getParameter("email");
		String password=req.getParameter("password");

		Admin admin=new Admin();
		if(username!=null&&email!=null&&password!=null) {
			admin.setUsername(username);
			admin.setEmail(email);
			admin.setPassword(password);
			ApplicationDao dao=new ApplicationDao();
			rows=dao.registerAdmin(admin);
		}else {
			resp.getWriter().print("User credentials are Invalid");
			req.getRequestDispatcher("html/createAdmin.html").include(req, resp);
		}
		
		if(rows>0) {
			req.getRequestDispatcher("html/LoginAdmin.html").forward(req, resp);
		}
		else {
			resp.getWriter().print("User credentials are Invalid");
			req.getRequestDispatcher("html/createAdmin.html").include(req, resp);
		}

	}
}
