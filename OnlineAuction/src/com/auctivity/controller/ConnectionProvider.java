/**
 * This java file is class that returns connection parameter 
 * after establishing connection with database
 */
package com.auctivity.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionProvider {

	public static void main(String[] args) throws SQLException {
		getConnection();
	}
	
	public static Connection getConnection() throws SQLException {
		
		Connection con = null;
		String url = null;
		String driver = null;
		String username = null;
		String password = null;
		
		try {
			Properties properties = new Properties();
			FileInputStream fis = new FileInputStream("/OnlineAuction/WebContent/WEB-INF/properties/connection.properties");
			properties.load(fis);
			driver = properties.getProperty(driver);
			url = properties.getProperty(url);
			username = properties.getProperty(username);
			password = properties.getProperty(password);
			
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			con = DriverManager.getConnection("/Users/sanul/MyDB", "admin", "rby");
			
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
		
	}
}
