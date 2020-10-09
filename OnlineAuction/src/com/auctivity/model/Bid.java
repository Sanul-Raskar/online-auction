/**
 *
 * This java file is a class that model the class Bid
 */

package com.auctivity.model;

public class Bid {
	
	private int BidId;
	// @bidderID must be registered as @userId  
	private int BidderId;
	// @biddedProductId must be same as the @productId in DB
	private int BiddedProductId;
	private double BidValue;
	private int Status;
	private int bidStatus;
	/**
	 * @return the bidId
	 */
	public int getBidId() {
		return BidId;
	}
	/**
	 * @param bidId the bidId to set
	 */
	public void setBidId(int bidId) {
		this.BidId = bidId;
	}
	/**
	 * @return the bidderId
	 */
	public int getBidderId() {
		return BidderId;
	}
	/**
	 * @param bidderId the bidderId to set
	 */
	public void setBidderId(int bidderId) {
		this.BidderId = bidderId;
	}
	/**
	 * @return the biddedProductId
	 */
	public int getBiddedProductId() {
		return BiddedProductId;
	}
	/**
	 * @param biddedProductId the biddedProductId to set
	 */
	public void setBiddedProductId(int biddedProductId) {
		this.BiddedProductId = biddedProductId;
	}
	/**
	 * @return the bidValue
	 */
	public double getBidValue() {
		return BidValue;
	}
	/**
	 * @param bidValue the bidValue to set
	 */
	public void setBidValue(double bidValue) {
		this.BidValue = bidValue;
	}
	/**
	 * @return the bidStatus
	 */
	public int getBidStatus() {
		return getBidStatus();
	}
	/**
	 * @param bidStatus the bidStatus to set
	 */
	public void setBidStatus(int bidStatus) {
		this.bidStatus = bidStatus;
	}
	
	public Bid(int bidId, int bidderId, int biddedProductId, double bidValue, int bidStatus) {
		super();
		this.BidId = bidId;
		this.BidderId = bidderId;
		this.BiddedProductId = biddedProductId;
		this.BidValue = bidValue;
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
		return "Bid [bidId=" + BidId + ", bidderId=" + BidderId + ", biddedProductId=" + BiddedProductId + ", bidValue="
				+ BidValue + ", bidStatus=" + bidStatus + "]";
	}
	
	

}
