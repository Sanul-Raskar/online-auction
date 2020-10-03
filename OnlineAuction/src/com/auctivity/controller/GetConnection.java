/**
 * This java file is class that returns connection parameter 
 * after establishing connection with database
 */
package com.auctivity.controller;

import java.sql.Connection;

public class GetConnection {

	public static void main(String[] args) {
		
	}
	
	public static Connection getConnectionId() {
		
		Connection con = null;
		
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
		
	}
}
