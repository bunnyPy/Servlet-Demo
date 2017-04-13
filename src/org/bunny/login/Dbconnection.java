package org.bunny.login;


import java.sql.*;
public class Dbconnection {

	
	private static Connection conn;
	
	static   {
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ServletDB","root","root");
			
		}
		catch(Exception E)
		{
			E.printStackTrace();
		}
	}
	
	public static Connection getConnection(){
		return conn;
		
	}
}