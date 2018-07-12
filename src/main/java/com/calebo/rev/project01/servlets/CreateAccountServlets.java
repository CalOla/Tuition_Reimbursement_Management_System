package com.calebo.rev.project01.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.calebo.rev.project01.pojos.Employee;
import com.calebo.rev.project01.util.ConnectionUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CreateAccountServlets extends HttpServlet
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NullPointerException
	{
		ObjectMapper mapper = new ObjectMapper();
//		System.out.println("hello "+request.getReader().readLine());
		Employee emp = mapper.readValue(request.getReader().readLine(), Employee.class);
		System.out.println(emp);
		System.out.println(emp.getEmail());
		System.out.println(emp.getPassword());
		
//		Query database
		String sql = "INSERT INTO TREG_EMPLOYEE(FNAME,LNAME,EMAIL,PASSWORD,PHONE,DOB,ADDRESS, POSITION, SUPERVISOR, DEPARTMENT,DEPARTMENT_HEAD, BALANCE)VALUES('" + emp.getFirstname() + "', '"+emp.getLastname()+"', '"+emp.getEmail()+"', '"+ emp.getPassword()+"', '"+emp.getPhoneNumber()+"', '"+emp.getDob()+"', '"+emp.getAddress()+"', '"+emp.getPosition()+"', '"+emp.getSupervisor()+"','"+emp.getDepartment()+"', '"+emp.getDepartmentHead()+"', '"+emp.getBalance()+"')";
		System.out.println(sql);
		try
		{
			Connection con = ConnectionUtil.getInstance().getConnection();
			Statement stmt = con.createStatement();
			int numOfRowAffected = stmt.executeUpdate(sql);
		}
		catch(SQLException esql)
		{
			esql.printStackTrace();
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		//System.out.println(request.getParameter("position"));
		System.out.println("yo yo yo");
		Employee emp = new Employee();
		emp.setFirstname("Joe");
		emp.setLastname("cool");
		emp.setEmail("joe@gmail.com");
		emp.setPassword("jboy987");
		emp.setPhoneNumber("919687246");
		emp.setDob("21-DEC-90");
		emp.setAddress("main street");
		emp.setPosition("team member");
		emp.setBalance(1000.0);
		emp.setDepartment("closers");
		emp.setSupervisor("jess");
		emp.setDepartmentHead("tom");
		String sql = "INSERT INTO TREG_EMPLOYEE(FNAME,LNAME,EMAIL,PASSWORD,PHONE,DOB,ADDRESS, POSITION, SUPERVISOR, DEPARTMENT,DEPARTMENT_HEAD, BALANCE)VALUES('" + emp.getFirstname() + "', '"+emp.getLastname()+"', '"+emp.getEmail()+"', '"+ emp.getPassword()+"', '"+emp.getPhoneNumber()+"', '"+emp.getDob()+"', '"+emp.getAddress()+"', '"+emp.getPosition()+"', '"+emp.getSupervisor()+"','"+emp.getDepartment()+"', '"+emp.getDepartmentHead()+"', '"+emp.getBalance()+"')";
		
		try
		{
			Connection con = ConnectionUtil.getInstance().getConnection();
			Statement stmt = con.createStatement();
			int numOfRowAffected = stmt.executeUpdate(sql);
		}
		catch(SQLException esql)
		{
			esql.printStackTrace();
		}
	}

}
