package com.auctivity.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.auctivity.controller.GetConnection;
import com.auctivity.model.User;

public class SellerProfileDaoImpl implements SellerProfileDao {

	@Override
	public List<User> getUsers() {
List<User> userList = new ArrayList<User>();
		
		Connection connection = GetConnection.getConnectionId();
		String getData = "select * from ONLINEAUCTIONDB.USERTABLE where user_type=0" ;
		try {
			PreparedStatement ps = connection.prepareStatement(getData);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int userID = rs.getInt("UserID");
	            String name = rs.getString("Name");
	            Date dob = rs.getDate("dob");
	            ZoneId defaultZoneId = ZoneId.systemDefault();
	    		
	        	//Converting the date to Instant
	        	Instant instant = dob.toInstant();
	        		
	        	//Converting the Date to LocalDate
	        	LocalDate localDate = instant.atZone(defaultZoneId).toLocalDate();
	            String emailID = rs.getString("email");
	            String phoneNum = rs.getString("phonenumber");
	            String userName = rs.getString("username");
	            String password = rs.getString("password");
	            String address = rs.getString("address");
	            int userType = rs.getInt("user_type");
	            double amt = rs.getDouble("wallet");
	            String userType1=null;
	            if(userType==0) {
	            	userType1 = "Seller";
	            }else {
	            	userType1 = "Buyer";
	            }
	            User user1 = new User( userID,name, localDate, emailID, phoneNum, userName,
	        			password, address, userType, amt);
	            userList.add(user1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userList;
	}

}
