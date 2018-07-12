package com.calebo.rev.project01.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.calebo.rev.project01.pojos.Employee;
import com.calebo.rev.project01.util.ConnectionUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReadOnlyRFormServlet extends HttpServlet
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String sql = "SELECT * FROM TREG_EMPLOYEE WHERE EMP_ID = 5";
		
		try
		{
			Employee emp = new Employee();
			Connection con = ConnectionUtil.getInstance().getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next())
			{
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
			
			ObjectMapper mapper = new ObjectMapper();
			String e = mapper.writeValueAsString(emp);
			response.getWriter().write(e);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
}
