package com.auctivity.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.auctivity.exceptions.UserNotFoundException;
import com.auctivity.model.beans.User;
import com.auctivity.utility.DBConnection;
import com.auctivity.utility.PasswordEncrypter;

public class UserDaoImpl implements IUserDao {
	static Connection conn = null;
	@Override
	public int addUser(User user) {
		int status=0;
		boolean ifUserExist = getUserIfExist(user.getUsername(), user.getEmail());
		
		if(!ifUserExist) {
			Connection conn = DBConnection.getConnectionId();	
			PreparedStatement ps;
			try {
				//ps = conn.prepareStatement("insert into OnlineAuctionDB.Usertable values (next value for OnlineAuctionDB.user_sequence,?,?,?,?,?,?,?,?,?)");
				ps = conn.prepareStatement("insert into OnlineAuctionDB.Usertable values (next value for onlineauctiondb.user_sequence,?,?,?,?,?,?,?,?,?)");

				ps.setString(1, user.getName());
				ps.setDate(2,  java.sql.Date.valueOf(user.getDob()));
				ps.setString(3, user.getEmail());
				ps.setString(4, user.getPhonenumber());
				ps.setString(5, user.getUsername());
				ps.setString(6, user.getPassword());
				ps.setString(7, user.getAddress());
				ps.setInt(8, user.getUserType());
				ps.setDouble(9, user.getWallet());
				status = ps.executeUpdate();
				System.out.println("Register status::"+status);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			
		}
		return status;
	}

	@Override
	public User getUser(String username, String password) throws UserNotFoundException {
		conn = DBConnection.getConnectionId();
		ResultSet rs = null;
		User u = new User();
		try {	
			String getQuery = "select * from OnlineAuctionDB.usertable where username=? and password=?";
			PreparedStatement ps = conn.prepareStatement(getQuery);
			ps.setString(1, username.toLowerCase());
			ps.setString(2, PasswordEncrypter.getSHA(password));
			rs = ps.executeQuery();
			while(rs.next()) {
				u.setUserid(rs.getInt("userid"));
				u.setName(rs.getString("Name"));
				u.setDob(rs.getDate("dob").toLocalDate());
				u.setEmail(rs.getString("email"));
				u.setPhonenumber(rs.getString("phonenumber"));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				u.setAddress(rs.getString("address"));
				u.setUserType(rs.getInt("user_type"));
				u.setWallet(rs.getDouble("wallet"));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		System.out.println("u.getuuu:"+u.getUserid());
		if(u.getUserid()!=0)
			return u;
		else
		 throw new UserNotFoundException("User not found in DB");
	}


	@Override
	public int updateUser() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int deleteUser() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean getUserIfExist(String username, String email){
		conn = DBConnection.getConnectionId();
		ResultSet rs = null;
		User u = new User();
		try {	
			String getQuery = "select * from OnlineAuctionDB.usertable where username=?";
			PreparedStatement ps = conn.prepareStatement(getQuery);
			ps.setString(1, username.toLowerCase());
			rs = ps.executeQuery();
			while(rs.next()) {
				u.setUserid(rs.getInt("userid"));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		try {	
			String getQuery = "select * from OnlineAuctionDB.usertable where email=?";
			PreparedStatement ps = conn.prepareStatement(getQuery);
			ps.setString(1, email.toLowerCase());
			rs = ps.executeQuery();
			while(rs.next()) {
				u.setUserid(rs.getInt("userid"));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		if(u.getUserid()!=0)
			return true;
		else
		 return false;
	}


}
