package org.bunny.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class Login
 */
@WebServlet(description = "authorize user can login", urlPatterns = { "/LoginPath" })
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
try{
	    PrintWriter out = response.getWriter();
	    Class.forName("com.mysql.jdbc.Driver");  
	    Connection con=DriverManager.getConnection(  
	    "jdbc:mysql://localhost/ServletDB","root","root"); 	
		String userName =request.getParameter("userName");
		String Password =request.getParameter("Password");
		//out.println(userName + Password);
		//request.setAttribute("user", userName);
		PreparedStatement ps=con.prepareStatement(  
				"select * from Registration where userName=? and Password=?");
	//	PreparedStatement ps=con.prepareStatement("select * from Registration where userName=? and Password=?");
	    ps.setString(1,userName);
	    ps.setString(2,Password);
	    ResultSet rs=ps.executeQuery();
	   
	    
	    if(rs.next()){
	    	HttpSession session = request.getSession();
	    	session.setAttribute("name", userName);
	    	request.getRequestDispatcher("welcome.jsp").forward(request, response);

	    }
	    else {
	    	
	    	request.getRequestDispatcher("login.html").include(request,response);
	    	out.print("sorry username or password is wrong");
	    }
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		
	          
			
	}

}
