package org.bunny.register;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Registration
 */
@WebServlet(description = "Register your self to get login", urlPatterns = { "/RegistrationPath" })
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userName = request.getParameter("userName");
		String Password = request.getParameter("Password");
		String email = request.getParameter("email");
		String First_Name = request.getParameter("First_Name");
		String Last_Name = request.getParameter("Last_Name");
		try{  
			
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost/ServletDB","root","root");  
			 
			
			PreparedStatement ps=con.prepareStatement(  
			"insert into Registration values(?,?,?,?,?)");  
			  
			ps.setString(1,userName);  
			ps.setString(2,Password);  
			ps.setString(3,First_Name);  
			ps.setString(4,Last_Name);
			ps.setString(5,email);
			int i=ps.executeUpdate();  
			if(i>0){
			    //out.print("You are successfully registered...");  
				request.getRequestDispatcher("login.html").include(request, response);    
			    out.print("You are successfully registered...");  

			}      
			}catch (Exception e2) {System.out.println(e2);}  
			          
			out.close();  
			}  
			  
			
	}
	


