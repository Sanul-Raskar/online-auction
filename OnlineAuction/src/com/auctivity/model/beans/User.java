/*
  * This java file is a class that model the class User
 */
package com.auctivity.model.beans;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import com.auctivity.utility.PasswordEncrypter;

public class User {
	
	public enum type {
		ADMIN (2), BUYER (0), SELLER (1);
		
		private final int typeCode;
		private static Map map = new HashMap<>();
		
		type(int typeCode) {
			this.typeCode = typeCode;
		}
		
		static {
	        for (type usertype : type.values()) {
	            map.put(usertype.typeCode, usertype);
	        }
	    }

	    public static type valueOf(int usertype) {
	        return (type) map.get(usertype);
	    }

	    public int getValue() {
	        return typeCode;
	    }
	}
	private int userid;
	private String name;
	private LocalDate dob;
	private String email;
	private String phonenumber;
	private String username;
	private String password;
	private String address;
	private type usertype;
	private double wallet;
	/**
	 * 
	 */
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param userid
	 * @param name
	 * @param dob
	 * @param email
	 * @param phonenumber
	 * @param username
	 * @param password
	 * @param address
	 * @param usertype
	 * @param wallet
	 */
	public User(int userid, String name, LocalDate dob, String email, String phonenumber, String username,
			String password, String address, type usertype, double wallet) {
		super();
		this.userid = userid;
		this.name = name;
		this.dob = dob;
		this.email = email;
		this.phonenumber = phonenumber;
		this.username = username;
		this.password = password;
		this.address = address;
		this.usertype = usertype;
		this.wallet = wallet;
	}
	/**
	 * @return the userid
	 */
	public int getUserid() {
		return userid;
	}
	/**
	 * @param userid the userid to set
	 */
	public void setUserid(int userid) {
		this.userid = userid;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the dob
	 */
	public LocalDate getDob() {
		return dob;
	}
	/**
	 * @param dob the dob to set
	 */
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the phonenumber
	 */
	public String getPhonenumber() {
		return phonenumber;
	}
	/**
	 * @param phonenumber the phonenumber to set
	 */
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the userType
	 */
	public int getUserType() {
		return usertype.typeCode;
	}
	/**
	 * @param userType the userType to set
	 */
	public void setUserType(int userType) {
		this.usertype = type.valueOf(userType);
	}
	/**
	 * @return the wallet
	 */
	public double getWallet() {
		return wallet;
	}
	/**
	 * @param wallet the wallet to set
	 */
	public void setWallet(double wallet) {
		this.wallet = wallet;
	}
	@Override
	public String toString() {
		return "User [userid=" + userid + ", name=" + name + ", dob=" + dob + ", email=" + email + ", phonenumber="
				+ phonenumber + ", username=" + username + ", password=" + password + ", address=" + address
				+ ", usertype=" + usertype + ", wallet=" + wallet + "]";
	}

	
}
