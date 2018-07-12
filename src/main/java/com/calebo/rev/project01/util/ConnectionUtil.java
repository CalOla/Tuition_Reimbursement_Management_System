package com.calebo.rev.project01.util;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
	
	private static ConnectionUtil cu = null;
	private static Boolean build = true;
	
	private ConnectionUtil(){
		
		super();
		
	}
	
	public synchronized static ConnectionUtil getInstance(){
		
		if(build){
			
			cu = new ConnectionUtil();
			build = false;
			
		}
		
		return cu;
		
	}
	
	public Connection getConnection(){
		
		Properties prop = new Properties();
		Connection conn = null;
		try {
//			src\main\java\resources
			
			prop.load(new FileReader("database.properties"));
			String url = prop.getProperty("url");
			String username = prop.getProperty("usr");
			String password = prop.getProperty("pwd");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, username, password);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("class error");
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return conn;
	
	}

}