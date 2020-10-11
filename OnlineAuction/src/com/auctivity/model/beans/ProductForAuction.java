/**
 * This java file is a class that that model the class Products for auction 
 * ProducForAuction is a child class extending Product as Super class
 */
package com.auctivity.model.beans;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.auctivity.model.beans.User.type;

public class ProductForAuction extends Product {

	public enum status {
		NEW(0), OPEN(1), UNSOLD(2), SOLD(3);
		
		private final int statusCode;
		private static Map map = new HashMap<>();
		
		status(int statusCode) {
			this.statusCode = statusCode;
		}
				
		static {
	        for (status bidStatus : status.values()) {
	            map.put(bidStatus.statusCode, bidStatus);
	        }
	    }

	    public static status valueOf(int bidStatus) {
	        return (status) map.get(bidStatus);
	    }

	    public int getValue() {
	        return statusCode;
	    }
	}
	
	private int bidProductID;
	private double minBidValue;
	private LocalDate bidStartDate;
	private LocalDate bidEndDate;
	// @buyerId must be registered with @userId
	private int userID;
	private double soldPrice;
	private status bidStatus;
	
	
	/**
	 * 
	 */
	public ProductForAuction() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param bidProductID
	 * @param minBidValue
	 * @param bidStartDate
	 * @param bidEndDate
	 * @param userID
	 * @param soldPrice
	 * @param bidStatus
	 * 
	 */
	public ProductForAuction(int bidProductID, double minBidValue, LocalDate bidStartDate, LocalDate bidEndDate,
			int userID, double soldPrice, status bidStatus) {
		super();
		this.bidProductID = bidProductID;
		this.minBidValue = minBidValue;
		this.bidStartDate = bidStartDate;
		this.bidEndDate = bidEndDate;
		this.userID = userID;
		this.soldPrice = soldPrice;
		this.bidStatus = bidStatus;
	}
	
	public ProductForAuction(int productId, String productName, String productCategory, String productDescription,
			double productPrice, int productQuantity, String productImage,
			double minBidValue, LocalDate bidStartDate, LocalDate bidEndDate, double soldPrice,
			status bidStatus) {
		super(productId, productName, productCategory, productDescription, productPrice, productQuantity, productImage);
		this.minBidValue = minBidValue;
		this.bidStartDate = bidStartDate;
		this.bidEndDate = bidEndDate;
		this.soldPrice = soldPrice;
		this.bidStatus = bidStatus;
	}
	public ProductForAuction(String productName, String productImage,double soldPrice,LocalDate bidEndDate,status bidStatus) {
		super(productName,productImage);
		this.bidEndDate = bidEndDate;
		this.soldPrice = soldPrice;
		this.bidStatus = bidStatus;
	}
	public ProductForAuction(String pName, String img, double sPrice, LocalDate sDate, LocalDate eDate, status cond) {
		// TODO Auto-generated constructor stub
		super(pName,img);
		this.bidStartDate = sDate;
		this.bidEndDate = eDate;
		this.soldPrice = sPrice;
		this.bidStatus = cond;
	}
	/**
	 * @return the bidProductID
	 */
	public int getBidProductID() {
		return bidProductID;
	}
	/**
	 * @param bidProductID the bidProductID to set
	 */
	public void setBidProductID(int bidProductID) {
		this.bidProductID = bidProductID;
	}
	/**
	 * @return the minBidValue
	 */
	public double getMinBidValue() {
		return minBidValue;
	}
	/**
	 * @param minBidValue the minBidValue to set
	 */
	public void setMinBidValue(double minBidValue) {
		this.minBidValue = minBidValue;
	}
	/**
	 * @return the bidStartDate
	 */
	public LocalDate getBidStartDate() {
		return bidStartDate;
	}
	/**
	 * @param bidStartDate the bidStartDate to set
	 */
	public void setBidStartDate(LocalDate bidStartDate) {
		this.bidStartDate = bidStartDate;
	}
	/**
	 * @return the bidEndDate
	 */
	public LocalDate getBidEndDate() {
		return bidEndDate;
	}
	/**
	 * @param bidEndDate the bidEndDate to set
	 */
	public void setBidEndDate(LocalDate bidEndDate) {
		this.bidEndDate = bidEndDate;
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
	 * @return the soldPrice
	 */
	public double getSoldPrice() {
		return soldPrice;
	}
	/**
	 * @param soldPrice the soldPrice to set
	 */
	public void setSoldPrice(double soldPrice) {
		this.soldPrice = soldPrice;
	}
	/**
	 * @return the bidStatus
	 */
	public int getBidStatus() {
		return bidStatus.statusCode;
	}
	/**
	 * @param bidStatus the bidStatus to set
	 */
	public void setBidStatus(int bidStatus) {
		this.bidStatus = status.valueOf(bidStatus);
	}
	
	/**
	 * @param bidStatus the bidStatus to set
	 */
	public void setBidStatus(status bidStatus) {
		this.bidStatus = bidStatus;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bidEndDate == null) ? 0 : bidEndDate.hashCode());
		result = prime * result + bidProductID;
		result = prime * result + ((bidStartDate == null) ? 0 : bidStartDate.hashCode());
		result = prime * result + ((bidStatus == null) ? 0 : bidStatus.hashCode());
		long temp;
		temp = Double.doubleToLongBits(minBidValue);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(soldPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + userID;
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
		ProductForAuction other = (ProductForAuction) obj;
		if (bidEndDate == null) {
			if (other.bidEndDate != null)
				return false;
		} else if (!bidEndDate.equals(other.bidEndDate))
			return false;
		if (bidProductID != other.bidProductID)
			return false;
		if (bidStartDate == null) {
			if (other.bidStartDate != null)
				return false;
		} else if (!bidStartDate.equals(other.bidStartDate))
			return false;
		if (bidStatus != other.bidStatus)
			return false;
		if (Double.doubleToLongBits(minBidValue) != Double.doubleToLongBits(other.minBidValue))
			return false;
		if (Double.doubleToLongBits(soldPrice) != Double.doubleToLongBits(other.soldPrice))
			return false;
		if (userID != other.userID)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ProductForAuction [bidProductID=" + bidProductID + ", minBidValue=" + minBidValue + ", bidStartDate="
				+ bidStartDate + ", bidEndDate=" + bidEndDate + ", userID=" + userID + ", soldPrice=" + soldPrice
				+ ", bidStatus=" + bidStatus + "]";
	}
}
