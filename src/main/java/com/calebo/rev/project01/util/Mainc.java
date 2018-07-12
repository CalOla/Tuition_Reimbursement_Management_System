package com.calebo.rev.project01.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.calebo.rev.project01.pojos.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Mainc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String sql = "SELECT * FROM TREG_EMPLOYEE WHERE EMAIL = 'ckolaoye@aggies.ncat.edu' AND PASSWORD = 'uijhg'";
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
			
			ObjectMapper mapper = new ObjectMapper();

			String e = mapper.writeValueAsString(emp);
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		catch(JsonProcessingException e)
		{
			
		}
		
	}

}
