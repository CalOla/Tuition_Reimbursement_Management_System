package com.calebo.rev.project01.servlets;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.HttpServlet;

import com.calebo.rev.project01.util.ConnectionUtil;

public class FormsList extends HttpServlet
{
	public static void main(String[] args)
	{
		String sql = "";
		
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
