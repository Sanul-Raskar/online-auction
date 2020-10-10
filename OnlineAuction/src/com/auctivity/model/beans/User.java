/*
  * This java file is a class that model the class User
 */
package com.auctivity.model.beans;

import java.time.LocalDate;

import com.auctivity.utility.PasswordEncrypter;

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
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = PasswordEncrypter.getSHA(password);
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getUsertype() {
		return usertype;
	}
	public void setUsertype(int usertype) {
		this.usertype = usertype;
	}
	public double getWallet() {
		return wallet;
	}
	public void setWallet(double wallet) {
		this.wallet = wallet;
	}
	
	
}
