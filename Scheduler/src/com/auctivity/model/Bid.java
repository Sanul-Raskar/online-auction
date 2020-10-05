/**
 *
 * This java file is a class that model the class Bid
 */

package com.auctivity.model;

public class Bid {
	
	private int bidId;
	// @bidderID must be registered as @userId  
	private int bidderId;
	// @biddedProductId must be same as the @productId in DB
	private int biddedProductId;
	private double bidValue;
	private int bidStatus;
	/**
	 * @return the bidId
	 */
	public int getBidId() {
		return bidId;
	}
	/**
	 * @param bidId the bidId to set
	 */
	public void setBidId(int bidId) {
		this.bidId = bidId;
	}
	/**
	 * @return the bidderId
	 */
	public int getBidderId() {
		return bidderId;
	}
	/**
	 * @param bidderId the bidderId to set
	 */
	public void setBidderId(int bidderId) {
		this.bidderId = bidderId;
	}
	/**
	 * @return the biddedProductId
	 */
	public int getBiddedProductId() {
		return biddedProductId;
	}
	/**
	 * @param biddedProductId the biddedProductId to set
	 */
	public void setBiddedProductId(int biddedProductId) {
		this.biddedProductId = biddedProductId;
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
		return bidStatus;
	}
	/**
	 * @param bidStatus the bidStatus to set
	 */
	public void setBidStatus(int bidStatus) {
		this.bidStatus = bidStatus;
	}
	
	public Bid(int bidId, int bidderId, int biddedProductId, double bidValue, int bidStatus) {
		super();
		this.bidId = bidId;
		this.bidderId = bidderId;
		this.biddedProductId = biddedProductId;
		this.bidValue = bidValue;
		this.bidStatus = bidStatus;
	}
	

	/**
	 * Constructor of Super class 
	 */
	public Bid() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Bid [bidId=" + bidId + ", bidderId=" + bidderId + ", biddedProductId=" + biddedProductId + ", bidValue="
				+ bidValue + ", bidStatus=" + bidStatus + "]";
	}
	
	

}
