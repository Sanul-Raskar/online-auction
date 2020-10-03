/**
 * This java file is a class that that model the class Products for auction 
 * ProducForAuction is a child class extending Product as Super class
 */
package com.auctivity.model;

import java.util.Date;

public class ProductForAuction extends Product {

	private double minimumBidValue;
	private Date bidStartDate;
	private Date bidEndDate;
	//buyerId must be registered with userId
	private int buyerId;
	private double soldPrice;
	private int auctionStatus;
	/**
	 * @return the minimumBidValue
	 */
	public double getMinimumBidValue() {
		return minimumBidValue;
	}
	/**
	 * @param minimumBidValue the minimumBidValue to set
	 */
	public void setMinimumBidValue(double minimumBidValue) {
		this.minimumBidValue = minimumBidValue;
	}
	/**
	 * @return the bidStartDate
	 */
	public Date getBidStartDate() {
		return bidStartDate;
	}
	/**
	 * @param bidStartDate the bidStartDate to set
	 */
	public void setBidStartDate(Date bidStartDate) {
		this.bidStartDate = bidStartDate;
	}
	/**
	 * @return the bidEndDate
	 */
	public Date getBidEndDate() {
		return bidEndDate;
	}
	/**
	 * @param bidEndDate the bidEndDate to set
	 */
	public void setBidEndDate(Date bidEndDate) {
		this.bidEndDate = bidEndDate;
	}
	/**
	 * @return the buyerId
	 */
	public int getBuyerId() {
		return buyerId;
	}
	/**
	 * @param buyerId the buyerId to set
	 */
	public void setBuyerId(int buyerId) {
		this.buyerId = buyerId;
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
	 * @return the auctionStatus
	 */
	public int getAuctionStatus() {
		return auctionStatus;
	}
	/**
	 * @param auctionStatus the auctionStatus to set
	 */
	public void setAuctionStatus(int auctionStatus) {
		this.auctionStatus = auctionStatus;
	}
	/**
	 * 
	 */
	public ProductForAuction() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param productId
	 * @param productName
	 * @param productCategory
	 * @param productDescription
	 * @param productPrice
	 * @param productQuantity
	 * @param productImage
	 * @param productSellerId
	 */
	public ProductForAuction(int productId, String productName, String productCategory, String productDescription,
			double productPrice, int productQuantity, String productImage, int productSellerId) {
		super(productId, productName, productCategory, productDescription, productPrice, productQuantity, productImage,
				productSellerId);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "ProductForAuction [minimumBidValue=" + minimumBidValue + ", bidStartDate=" + bidStartDate
				+ ", bidEndDate=" + bidEndDate + ", buyerId=" + buyerId + ", soldPrice=" + soldPrice
				+ ", auctionStatus=" + auctionStatus + "]";
	}
	
	
	
	
	
	
	
	
	

}
