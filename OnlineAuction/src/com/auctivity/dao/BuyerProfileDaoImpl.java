package com.auctivity.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.auctivity.controller.GetConnection;
import com.auctivity.model.User;

public class BuyerProfileDaoImpl implements BuyerProfileDao{

	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		List<User> userList = new ArrayList<User>();
		
		Connection connection = GetConnection.getConnectionId();
		String getData = "select * from ONLINEAUCTIONDB.USERTABLE where user_type=1" ;
		try {
			PreparedStatement ps = connection.prepareStatement(getData);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int userID = rs.getInt("UserID");
	            String name = rs.getString("Name");
	            Date dob = rs.getDate("dob");
	            String emailID = rs.getString("email");
	            String phoneNum = rs.getString("phonenumber");
	            String userName = rs.getString("username");
	            String password = rs.getString("password");
	            String address = rs.getString("address");
	            int userType = rs.getInt("user_type");
	            String userType1=null;
	            if(userType==0) {
	            	userType1 = "Seller";
	            }else {
	            	userType1 = "Buyer";
	            }
	            double amt = rs.getDouble("wallet");
	            User user1 = new User( name,userID, dob, emailID, phoneNum, userName,
	        			password, address, userType1, amt);
	            userList.add(user1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userList;
	}

}