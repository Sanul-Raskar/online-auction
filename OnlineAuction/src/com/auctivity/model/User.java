/*
 * This java file is a class that model the class User
 */
package com.auctivity.model;

import java.util.Date;

public class User {
	
	private int userId;
	private String userName;
	private Date userDob;
	private String userEmail;
	private String userPhoneNumber;
	private String userUserName;
	private String userPassword;
	private String userAddress;
	private String userType;
	private double userWalletAmount;
	
	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the userDob
	 */
	public Date getUserDob() {
		return userDob;
	}
	/**
	 * @param userDob the userDob to set
	 */
	public void setUserDob(Date userDob) {
		this.userDob = userDob;
	}
	/**
	 * @return the userEmail
	 */
	public String getUserEmail() {
		return userEmail;
	}
	/**
	 * @param userEmail the userEmail to set
	 */
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	/**
	 * @return the userPhoneNumber
	 */
	public String getUserPhoneNumber() {
		return userPhoneNumber;
	}
	/**
	 * @param userPhoneNumber the userPhoneNumber to set
	 */
	public void setUserPhoneNumber(String userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
	}
	/**
	 * @return the userUserName
	 */
	public String getUserUserName() {
		return userUserName;
	}
	/**
	 * @param userUserName the userUserName to set
	 */
	public void setUserUserName(String userUserName) {
		this.userUserName = userUserName;
	}
	/**
	 * @return the userPassword
	 */
	public String getUserPassword() {
		return userPassword;
	}
	/**
	 * @param userPassword the userPassword to set
	 */
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	/**
	 * @return the userAddress
	 */
	public String getUserAddress() {
		return userAddress;
	}
	/**
	 * @param userAddress the userAddress to set
	 */
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	/**
	 * @return the userType
	 */
	public String getUserType() {
		return userType;
	}
	/**
	 * @param userType the userType to set
	 */
	public void setUserType(String userType) {
		this.userType = userType;
	}
	/**
	 * @return the userWalletAmount
	 */
	public double getUserWalletAmount() {
		return userWalletAmount;
	}
	/**
	 * @param userWalletAmount the userWalletAmount to set
	 */
	public void setUserWalletAmount(double userWalletAmount) {
		this.userWalletAmount = userWalletAmount;
	}
	
	/**
	 * @param userName
	 * @param userId
	 * @param userDob
	 * @param userEmail
	 * @param userPhoneNumber
	 * @param userUserName
	 * @param userPassword
	 * @param userAddress
	 * @param userType
	 * @param userWalletAmount
	 */
	public User(String userName, int userId, Date userDob, String userEmail, String userPhoneNumber, String userUserName,
			String userPassword, String userAddress, String userType, double userWalletAmount) {
		super();
		this.userName = userName;
		this.userId = userId;
		this.userDob = userDob;
		this.userEmail = userEmail;
		this.userPhoneNumber = userPhoneNumber;
		this.userUserName = userUserName;
		this.userPassword = userPassword;
		this.userAddress = userAddress;
		this.userType = userType;
		this.userWalletAmount = userWalletAmount;
	}
	
	/**
	 * Constructor of Super class
	 */
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userDob=" + userDob + ", userEmail=" + userEmail
				+ ", userPhoneNumber=" + userPhoneNumber + ", userUserName=" + userUserName + ", userPassword="
				+ userPassword + ", userAddress=" + userAddress + ", userType=" + userType + ", userWalletAmount="
				+ userWalletAmount + "]";
	}
	
	

}
