/*
  * This java file is a class that model the class User
 */
package com.auctivity.model;

import java.time.LocalDate;

public class User {
	
	private int userid;
	private String name;
	private LocalDate dob;
	private String email;
	private String phonenumber;
	private String username;
	private String password;
	private String address;
	private int usertype;
	private double wallet;
	/**
	 * Constructor of Super class
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
			String password, String address, int usertype, double wallet) {
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
	 * @return the usertype
	 */
	public int getUsertype() {
		return usertype;
	}
	/**
	 * @param usertype the usertype to set
	 */
	public void setUsertype(int usertype) {
		this.usertype = usertype;
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
