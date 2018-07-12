package com.calebo.rev.project01.servlets;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.calebo.rev.project01.pojos.Employee;
import com.calebo.rev.project01.pojos.Login;
import com.calebo.rev.project01.util.ConnectionUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LoginServlets extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	
//	private static 
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
//		String firstName = request.getParameter("eml");
		ObjectMapper mapper = new ObjectMapper();
		Login login = mapper.readValue(request.getReader().readLine(), Login.class);
		System.out.println(login);
		System.out.println(login.getEmail());
		System.out.println(login.getPassword());
		
		//Query database with login credential
		String sql = "SELECT * FROM TREG_EMPLOYEE WHERE EMAIL = '"+login.getEmail()+"' AND PASSWORD = '"+login.getPassword()+"'";
		System.out.println(sql);
		
		try
		{
			Employee emp = new Employee();
			Connection con = ConnectionUtil.getInstance().getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			int i = 0;
			
			while(rs.next())
			{
				i = rs.getInt(1);
				emp.setEmployeeId(Integer.parseInt(rs.getString(1)));
				emp.setFirstname(rs.getString(2));
				emp.setLastname(rs.getString(3));
				emp.setEmail(rs.getString(4));
				emp.setPassword(rs.getString(5));
				emp.setPhoneNumber(rs.getString(6));
				emp.setDob(rs.getString(7));
				emp.setAddress(rs.getString(8));
				emp.setPosition(rs.getString(9));
				emp.setSupervisor(rs.getString(10));
				emp.setDepartment(rs.getString(11));
				emp.setDepartmentHead(rs.getString(12));
				emp.setBalance(Double.parseDouble(rs.getString(13)));
			}

			con.close();
			if(i > 0)
			{
				String e = mapper.writeValueAsString(emp);
				System.out.println(e);
				response.getWriter().write(e);
			}
			else
			{
				response.getWriter().write("Invalid credentials");
			}
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
//		try
//		{
//			PrintWriter out = response.getWriter();
//			out.write("hello");
//			out.println("result is ");
//		} 
//		catch (IOException e) {
//			
//			e.printStackTrace();
//		}
		
		
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		 
	}
}
