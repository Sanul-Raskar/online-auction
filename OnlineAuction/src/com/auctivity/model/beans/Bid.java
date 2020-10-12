/**
 *
 * This java file is a class that model the class Bid
 */

package com.auctivity.model.beans;

import java.util.HashMap;
import java.util.Map;

public class Bid {

	public enum status {
		OPEN (0), LOST (1), WON (2);
		
		private final int statusCode;
		private static Map map = new HashMap<>();
		
		status(int statusCode) {
			this.statusCode = statusCode;
		}
		
		static {
	        for (status userstatus : status.values()) {
	            map.put(userstatus.statusCode, userstatus);
	        }
	    }

	    public static status valueOf(int userstatus) {
	        return (status) map.get(userstatus);
	    }

	    public int getValue() {
	        return statusCode;
	    }

	}

	private int bidID;
	// @bidderID must be registered as @userId
	private int bidderID;
	// @biddedProductId must be same as the @productId in DB
	private int bidProductID;
	private double bidValue;
	private status bidStatus;

	/**
	 * @param bidID
	 * @param bidderID
	 * @param bidProductID
	 * @param bidValue
	 * @param bidStatus
	 */
	public Bid(int bidID, int bidderID, int bidProductID, double bidValue, status bidStatus) {
		super();
		this.bidID = bidID;
		this.bidderID = bidderID;
		this.bidProductID = bidProductID;
		this.bidValue = bidValue;
		this.bidStatus = bidStatus;
	}

	public Bid() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the bidID
	 */
	public int getBidID() {
		return bidID;
	}

	/**
	 * @param bidID the bidID to set
	 */
	public void setBidID(int bidID) {
		this.bidID = bidID;
	}

	/**
	 * @return the bidderID
	 */
	public int getBidderID() {
		return bidderID;
	}

	/**
	 * @param bidderID the bidderID to set
	 */
	public void setBidderID(int bidderID) {
		this.bidderID = bidderID;
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
	 * @return the bidValue
	 */
	public double getBidValue() {
		return bidValue;
	}

	/**
	 * @param bidValue the bidValue to set
	 */
	public void setBidValue(double bidValue) {
		this.bidValue = bidValue;
	}

	/**
	 * @return the bidStatus
	 */
	public int getBidStatus() {
		return bidStatus.statusCode;
	}

	/**
	 * @param status the bidStatus to set
	 */
	public void setBidStatus(int bidstatus) {
		this.bidStatus = status.valueOf(bidstatus);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bidID;
		result = prime * result + bidProductID;
		result = prime * result + ((bidStatus == null) ? 0 : bidStatus.hashCode());
		long temp;
		temp = Double.doubleToLongBits(bidValue);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + bidderID;
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
		Bid other = (Bid) obj;
		if (bidID != other.bidID)
			return false;
		if (bidProductID != other.bidProductID)
			return false;
		if (bidStatus != other.bidStatus)
			return false;
		if (Double.doubleToLongBits(bidValue) != Double.doubleToLongBits(other.bidValue))
			return false;
		if (bidderID != other.bidderID)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Bid [bidID=" + bidID + ", bidderID=" + bidderID + ", bidProductID=" + bidProductID + ", bidValue="
				+ bidValue + ", bidStatus=" + bidStatus + "]";
	}

	

}