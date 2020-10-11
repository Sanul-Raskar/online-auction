package com.auctivity.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	public static void main(String[] args) {
		getConnectionId();
	}
	
	public static Connection getConnectionId() {
		
		Connection con = null;
		
		try {
			
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");

			con=DriverManager.getConnection("jdbc:derby:C:\\Users\\hp\\MyDB;create=true","admin","derby");
			 
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
		
	}
}
