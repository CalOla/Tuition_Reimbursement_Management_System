package com.calebo.rev.project01.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.calebo.rev.project01.pojos.ReimbursementForm;
import com.calebo.rev.project01.util.ConnectionUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReimbursementFormServlet extends HttpServlet
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		System.out.println("rform");
		
		ObjectMapper mapper = new ObjectMapper();
		ReimbursementForm rform = mapper.readValue(request.getReader().readLine(), ReimbursementForm.class);
		System.out.println(rform);
		System.out.println(rform.sqlString());
		
		String sql = "INSERT INTO REIMB_FORM(FORMID, EMPID, TYPE, LOCATION, COST, GRDFORMAT, STIME, ETIME, SDATE, EDATE, MISSEDDAYS,DESCRIPTION, JUSTIFICATION, "
				+ "H_APPR, S_APPR, B_APPR, STATUS) VALUES('1', '1', "+ rform.sqlString() +")";
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
}
