/*
  * This java file is a class that model the class User
 */
package com.auctivity.model.beans;

import java.time.LocalDate;

import com.auctivity.utility.PasswordEncrypter;

public class User {
	
	public enum type {
		ADMIN, BUYER, SELLER;
	}
	
	private int userID;
	private String userName;
	private LocalDate userDoB;
	private String userEmail;
	private String userContact;	
	private String userLoginName;
	private String userPassword;
	private String userAddress;
	private type userType;
	private double userWallet;
	/**
	 * @param userID
	 * @param userName
	 * @param userDoB
	 * @param userEmail
	 * @param userContact
	 * @param userLoginName
	 * @param userPassword
	 * @param userAddress
	 * @param userType
	 * @param userWallet
	 */
	public User(int userID, String userName, LocalDate userDoB, String userEmail, String userContact,
			String userLoginName, String userPassword, String userAddress, type userType, double userWallet) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.userDoB = userDoB;
		this.userEmail = userEmail;
		this.userContact = userContact;
		this.userLoginName = userLoginName;
		this.userPassword = userPassword;
		this.userAddress = userAddress;
		this.userType = userType;
		this.userWallet = userWallet;
	}
	/**
	 * @return the userID
	 */
	public int getUserID() {
		return userID;
	}
	/**
	 * @param userID the userID to set
	 */
	public void setUserID(int userID) {
		this.userID = userID;
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
	 * @return the userDoB
	 */
	public LocalDate getUserDoB() {
		return userDoB;
	}
	/**
	 * @param userDoB the userDoB to set
	 */
	public void setUserDoB(LocalDate userDoB) {
		this.userDoB = userDoB;
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
	 * @return the userContact
	 */
	public String getUserContact() {
		return userContact;
	}
	/**
	 * @param userContact the userContact to set
	 */
	public void setUserContact(String userContact) {
		this.userContact = userContact;
	}
	/**
	 * @return the userLoginName
	 */
	public String getUserLoginName() {
		return userLoginName;
	}
	/**
	 * @param userLoginName the userLoginName to set
	 */
	public void setUserLoginName(String userLoginName) {
		this.userLoginName = userLoginName;
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
		this.userPassword = PasswordEncrypter.getSHA(userPassword);
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
	public type getUserType() {
		return userType;
	}
	/**
	 * @param userType the userType to set
	 */
	public void setUserType(type userType) {
		this.userType = userType;
	}
	/**
	 * @return the userWallet
	 */
	public double getUserWallet() {
		return userWallet;
	}
	/**
	 * @param userWallet the userWallet to set
	 */
	public void setUserWallet(double userWallet) {
		this.userWallet = userWallet;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userAddress == null) ? 0 : userAddress.hashCode());
		result = prime * result + ((userContact == null) ? 0 : userContact.hashCode());
		result = prime * result + ((userDoB == null) ? 0 : userDoB.hashCode());
		result = prime * result + ((userEmail == null) ? 0 : userEmail.hashCode());
		result = prime * result + userID;
		result = prime * result + ((userLoginName == null) ? 0 : userLoginName.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		result = prime * result + ((userPassword == null) ? 0 : userPassword.hashCode());
		result = prime * result + ((userType == null) ? 0 : userType.hashCode());
		long temp;
		temp = Double.doubleToLongBits(userWallet);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (userAddress == null) {
			if (other.userAddress != null)
				return false;
		} else if (!userAddress.equals(other.userAddress))
			return false;
		if (userContact == null) {
			if (other.userContact != null)
				return false;
		} else if (!userContact.equals(other.userContact))
			return false;
		if (userDoB == null) {
			if (other.userDoB != null)
				return false;
		} else if (!userDoB.equals(other.userDoB))
			return false;
		if (userEmail == null) {
			if (other.userEmail != null)
				return false;
		} else if (!userEmail.equals(other.userEmail))
			return false;
		if (userID != other.userID)
			return false;
		if (userLoginName == null) {
			if (other.userLoginName != null)
				return false;
		} else if (!userLoginName.equals(other.userLoginName))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		if (userPassword == null) {
			if (other.userPassword != null)
				return false;
		} else if (!userPassword.equals(other.userPassword))
			return false;
		if (userType != other.userType)
			return false;
		if (Double.doubleToLongBits(userWallet) != Double.doubleToLongBits(other.userWallet))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "User [userID=" + userID + ", userName=" + userName + ", userDoB=" + userDoB + ", userEmail=" + userEmail
				+ ", userContact=" + userContact + ", userLoginName=" + userLoginName + ", userPassword=" + userPassword
				+ ", userAddress=" + userAddress + ", userType=" + userType + ", userWallet=" + userWallet + "]";
	}
}
