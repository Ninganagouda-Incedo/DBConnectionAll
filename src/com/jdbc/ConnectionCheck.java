package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionCheck {

	public static void main(String[] args) {
		System.out.println("---------------------- JDBC Connection Started For MySQL ------------------");
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");  
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from Networksytem");  
			while(rs.next())  
			{
				System.out.println(rs.getString(1)+"\t"+rs.getString(2));  
			}
			con.close();  
			System.out.println("---------------------- JDBC Connection Ended For MySQL ------------------");	
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
