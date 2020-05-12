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

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.getRequestDispatcher("/html/admin.html").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username=req.getParameter("username");
		String email=req.getParameter("email");
		String password=req.getParameter("password");

		Admin admin=new Admin();
		admin.setUsername(username);
		admin.setEmail(email);
		admin.setPassword(password);

		ApplicationDao dao=new ApplicationDao();
		int rows=dao.registerAdmin(admin);
		
		if(rows>0) {
			req.getRequestDispatcher("html/LoginAdmin.html").forward(req, resp);
		}
		else {
			resp.getWriter().print("User credentials are Invalid");
			req.getRequestDispatcher("html/admin.html").include(req, resp);
		}

	}



}
