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

public class ThiefDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con=null;//connection
		Statement st=null;// for query execution
		ResultSet rs=null;// for storing the result of query
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		String id_number=request.getParameter("idno");
		try
		{
			Constants constants=new Constants();//object created for constants
		
			constants.loaddriver();//calling this method for registering driver
		    con = Constants.getConncetion();//creating a connection to database
		     st=con.createStatement();
				

		 rs=st.executeQuery("select * from criminalbio where id="+id_number);//retreiving the details of criminal


		out.println("<center>");

		if(rs.next())
		{
	      out.println("<html><body><table border='1'><tr><td>CriminalName</td><td>Dateofbirth</td><td>No:of timesarrested</td><td>Address</td><td>Previousattempts</td><td>Id</td></tr>");

	
      out.println("<h1><font color=red><b>Thief Profile</b></font></h1>");
         out.println("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td><td>"+rs.getString(6)+"</td></tr>");
 		out.println("</table></body></html>");

		}
       else 
       {
			
			out.println("<center>");
		   out.println("<font color=red><b>Invalid:Please enter the valid details<b></font>");
		    RequestDispatcher dispatcher = request.getRequestDispatcher("findthief.jsp");
		    dispatcher.include(request, response);
	  }
         
		}
		catch(Exception ae)
		{
			ae.printStackTrace();
		}
		}
		
}




