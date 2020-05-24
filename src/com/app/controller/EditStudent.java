package com.app.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.dao.ApplicationDao;
import com.app.user.Student;

@WebServlet("/editStudent")
public class EditStudent extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<h1>Update Student</h1>");
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		
		Student student=null;
		try {
			student = new ApplicationDao().getStudentById(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		out.print("<html lang='en'>");
		out.print("<head>");
		out.print("<meta charset='UTF-8'>");
		out.print("<title>Uclan University</title>");
		out.print("<link rel='stylesheet' href='css/style.css'>");
		out.print("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
		out.print("</head><body>");
		out.print("<header id='home' class='header'>");
		out.print("<nav class=\"nav\" role=\"navigation\">\r\n" + 
				"			<div class=\"container nav-elements\">\r\n" + 
				"				<div class=\"branding\">\r\n" + 
				"					<a href=\"home\"><img src=\"images/uclan.svg\"\r\n" + 
				"						alt=\"Uclan University\"></a>\r\n" + 
				"				</div>\r\n" + 
				"				<ul class=\"navbar\">\r\n" + 
				"					<li><a href=\"logout\">logout</a></li>\r\n" + 
				"					<li><a href=\"student\">linkedIn</a></li>\r\n" + 
				"				</ul>\r\n" + 
				"			</div>\r\n" + 
				"		</nav>\r\n" + 
				"	</header>");
		out.print("<section id=\"registration\" class=\"section\">\r\n" + 
				"	 <div class=\"container tagline\">\r\n" + 
				"	 <em>Update Student</em><br/>\r\n" + 
				"	 <em>-------------</em>");
		out.print("<form action='editStudent' method='post'>");
		out.print("<table border='1' width='100%'>");
		out.print("<tr><td></td><td><input type='hidden' name='id' value='"+student.getId()+"'/></td></tr>");
		out.print("<tr><td>FirstName:</td><td><input type='text' name='firstname' value='"+student.getFirstName()+"'/></td></tr>");
		out.print("<tr><td>LastName:</td><td><input type='text' name='lastname' value='"+student.getLastName()+"'/></td></tr>");
		out.print("<tr><td>Email:</td><td><input type='text' name='email' value='"+student.getContactEmail()+"'/></td></tr>");
		out.print("<tr><td>Address:</td><td><input type='text' name='address' value='"+student.getAddress()+"'/></td></tr>");
		out.print("<tr><td><textarea name=\"address\" cols=\"30\" rows=\"5\" maxlength=\"200\" ></textarea><br>\r\n" + 
				"			<label><em>Select The Courses Which You want To Do ? </em></label><br> \r\n" + 
				"			<table><tr>\r\n" + 
				"			<td><input type=\"checkbox\" name=\"Java\" value=\"Java\">Java Rs.120		\r\n" + 
				"			<input type=\"checkbox\" name=\"Python\" value=\"Python\">Python Rs.130	\r\n" + 
				"			<input type=\"checkbox\" name=\"C++\" value=\"C++\">C++ Rs.140	\r\n" + 
				"			<input type=\"checkbox\" name=\"Spring\" value=\"Spring\">Spring Rs.150		\r\n" + 
				"			<input type=\"checkbox\" name=\"SOAP\" value=\"SOAP\">SOAP Rs.160\r\n" + 
				"			<input type=\"checkbox\" name=\"WebServices\" value=\"WebServices\">WebServices Rs.170<br>\r\n" + 
				"			<input type=\"checkbox\" name=\"Javascript\" value=\"JavaScript\">JavaScript Rs.180\r\n" + 
				"			<input type=\"checkbox\" name=\"Angular\" value=\"Angular\">Angular Rs.190\r\n" + 
				"			<input type=\"checkbox\" name=\"Dot Net\" value=\"Dot Net\">Dot Net Rs.200\r\n" + 
				"			<input type=\"checkbox\" name=\"PHP\" value=\"PHP\">PHP Rs.210\r\n" + 
				"			<input type=\"checkbox\" name=\"HTML\" value=\"HTML\">HTML Rs.220	\r\n" + 
				"			<input type=\"checkbox\" name=\"CSS\" value=\"CSS\">CSS Rs.230<br>\r\n" + 
				"			<input type=\"checkbox\" name=\"SQL\" value=\"SQL\">SQL Rs.240\r\n" + 
				"			<input type=\"checkbox\" name=\"PL/SQL\" value=\"PL/SQL\">PL/SQL Rs.250\r\n" + 
				"			<input type=\"checkbox\" name=\"MongoDB\" value=\"MongoDB\">MongoDB Rs.260\r\n" + 
				"			<input type=\"checkbox\" name=\"NodeJS\" value=\"NodeJS\">NodeJS Rs.270\r\n" + 
				"			<input type=\"checkbox\" name=\"ReactJS\" value=\"ReactJS\">NodeJS Rs.280	\r\n" + 
				"			<input type=\"checkbox\" name=\"MySQL\" value=\"MySQL\">MySQL Rs.290<br>\r\n" + 
				"			</td>\r\n" + 
				"			</tr>\r\n" + 
				"			</table>\r\n" + 
				"			<input type=\"submit\" value=\"Submit\" id=\"submit\">\r\n" + 
				"		</form>\r\n" + 
				"		</div>\r\n" + 
				"	</section></td></tr>");
		out.print("</td></tr>");
		out.print("</table>");
		out.print("</form>");
		out.close();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		String firstname=request.getParameter("firstname");
		String lastname=request.getParameter("lastname");
		String contactEmail=request.getParameter("contactEmail");
		String address=request.getParameter("address");
		String a=request.getParameter("Java");
		String b=request.getParameter("Python");
		String c=request.getParameter("C++");
		String d=request.getParameter("Spring");
		String e=request.getParameter("SOAP");
		String f=request.getParameter("WebServices");
		String g=request.getParameter("JavaScript");
		String h=request.getParameter("Angular");
		String i=request.getParameter("Dot Net");
		String j=request.getParameter("PHP");
		String k=request.getParameter("HTML");
		String l=request.getParameter("CSS");
		String m=request.getParameter("SQL");
		String n=request.getParameter("PL/SQL");
		String o=request.getParameter("MongoDB");
		String p=request.getParameter("NodeJS");
		String q=request.getParameter("ReactJS");
		String r=request.getParameter("MySQL");
		String[] str= {a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r};
		List<String> list=new ArrayList<>();
		for(String s:str) {
			if(s!=null) {
				list.add(s);
			}
		}
		Student student=new Student(id, firstname, lastname, contactEmail, address, list);
		
		try {
			new ApplicationDao().updateStudent(student,id);
			out.println("<html><body><h1>record updated<h1><body><html>");
			request.getRequestDispatcher("html/profile.html").forward(request, response);
		} catch (SQLException err) {
			err.printStackTrace();
		}
		out.println("Sorry! unable to update record");
		out.close();
	}
	
}
