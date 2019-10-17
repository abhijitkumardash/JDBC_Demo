package org.abhijit.jdbcApp;

import java.sql.*;

public class UpdateJDBCDemo 
{
	public static void main(String[] args) 
	{
		Connection conn=null;
		Statement stmt=null;
		
		String qry="update demodata1.studentdetails.set id=4 where name='abhijit'";
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver class Loaded & Registered");
			
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=abhijit");
			System.out.println("Connection Established with DB Server");
			
			stmt=conn.createStatement();
			System.out.println("Platform Created");
			
			stmt.executeUpdate(qry);
			System.out.println("Data Updated");
		} 
		catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		
		finally
		{
			if(stmt!=null)
			{
				try 
				{
					stmt.close();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
			if(conn!=null)
			{
				try 
				{
					conn.close();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
}
