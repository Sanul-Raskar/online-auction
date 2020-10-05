package com.auctivity.connection;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionProvider {
	
	public static void main(String[] args) {
		ConnectionProvider.getConnection();
	}
public static Connection getConnection() {
		
		Connection con = null;
		String url = null;
		String driver = null;
		String username = null;
		String password = null;
		
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			con = DriverManager.getConnection("jdbc:derby:C:\\Users\\hp\\MyDB;create=true");
			System.out.println("Connection established");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		
//		try {
//			Properties properties = new Properties();
//			FileInputStream fis = new FileInputStream("./resources/connection.properties");
//			properties.load(fis);
//			driver = properties.getProperty(driver);
//			url = properties.getProperty(url);
//			username = properties.getProperty(username);
//			password = properties.getProperty(password);
//			
//			Class.forName(driver);
//			con = DriverManager.getConnection(url, username, password);
//			
//		} catch (ClassNotFoundException | IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
		return con;
		
	}
}
