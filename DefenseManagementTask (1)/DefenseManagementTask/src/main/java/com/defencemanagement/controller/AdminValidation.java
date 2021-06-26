package com.defencemanagement.controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.defencemanagement.model.Constants;
import com.defencemanagement.model.Credentials;
public class AdminValidation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdminValidation() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection con=null;////connection
		Statement st=null;// for query execution
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String get_adminname =request.getParameter("adminname");
		String get_password= request.getParameter("adminpassword");
		
	
		if(get_adminname.equals(Credentials.adminname) && get_password.equals(Credentials.adminpassword))
		{
	      
		
			try
			{
				Constants constants=new Constants();//object created for constants class
				constants.loaddriver();//registering the driver
			    con = Constants.getConncetion();//creating a connection to database
			     st=con.createStatement();//creating statement
             ResultSet rs=st.executeQuery("select * from criminalbio");//retreiving the records of all criminals 

			out.println("<center>");
			out.println("<h1><font color=red><b>Thief Details</b></font></h1>");

		    out.println("<html><body><table border='1'><tr><td>CriminalName</td><td>Dateofbirth</td><td>No:of timesarrested</td><td>Address</td><td>Previousattempts</td><td>Id</td></tr>");
			while(rs.next())
			{
				
             out.println("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td><td>"+rs.getString(6)+"</td></tr>");
			}
			out.println("</table></body></html>");
			}
			catch(Exception ae)
			{
				ae.printStackTrace();
			}
		}
		  else
		     {
		    		out.println("<center>");
					   out.println("<font color=red><b>Invalid:Please enter the valid details<b></font>");
					    RequestDispatcher dispatcher = request.getRequestDispatcher("adminlogin.jsp");
					    dispatcher.include(request, response);
				}
	     
	     }
		
	    
	     
	     
				
			
     
     }


	     
	

