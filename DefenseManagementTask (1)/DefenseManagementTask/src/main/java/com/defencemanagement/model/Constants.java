package com.defencemanagement.model;

import java.sql.Connection;
import java.sql.DriverManager;
public class Constants {
	 // User name  for accessing the database

	public static String DB_USR_NAME = "root";
	 // password for accessing the database

	public static String DB_PWD = "root";
	public static String DB_URL ="jdbc:mysql://localhost:3306/mysql";
	public  void loaddriver()
	{
		try
		{
			// Registering the DRIVER
			Class.forName("com.mysql.jdbc.Driver");

		}
		catch(Exception ae)
		{
			ae.printStackTrace();
		}
	

		
	}
	public static Connection getConncetion()
	{
		Connection con=null;
		try
		{ // Creating a connection to the database

			con=DriverManager.getConnection(DB_URL,DB_USR_NAME,DB_PWD );
		}
		catch(Exception ae)
		{
			ae.printStackTrace();
		}
		return con;
		
	}
}


