package com.app.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.dao.ApplicationDao;

@WebServlet("/deleteStudent")
public class DeleteStudent extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		
		String sid=req.getParameter("id");
		int id=Integer.parseInt(sid);
		try {
			new ApplicationDao().deleteStudent(id);
			out.println("<html><body><h1>record deleted<h1><body><html>");
			req.getRequestDispatcher("html/profile.html").forward(req, resp);
		} catch (SQLException err) {
			err.printStackTrace();
		}
		out.println("Sorry! unable to update record");
		out.close();
	}
	
}
