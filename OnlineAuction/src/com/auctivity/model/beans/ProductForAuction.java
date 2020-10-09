/**
 * This java file is a class that that model the class Products for auction 
 * ProducForAuction is a child class extending Product as Super class
 */
package com.auctivity.model.beans;

import java.sql.Timestamp;
import java.util.Date;

public class ProductForAuction extends Product {

	private double MinBidValue;
	private Timestamp BidStartDate;
	private Timestamp BidEndDate;
	// @buyerId must be registered with @userId
	private int BuyerId;
	private double SoldPrice;
	private int Status;
	private int productId;
	/**
	 * @return the minimumBidValue
	 */
	public double getMinimumBidValue() {
		return MinBidValue;
	}
	/**
	 * @param minimumBidValue the minimumBidValue to set
	 */
	public void setMinimumBidValue(double minimumBidValue) {
		this.MinBidValue = minimumBidValue;
	}
	/**
	 * @return the bidStartDate
	 */
	public Date getBidStartDate() {
		return BidStartDate;
	}
	/**
	 * @param bidStartDate the bidStartDate to set
	 */
	public void setBidStartDate(Timestamp bidStartDate) {
		this.BidStartDate = bidStartDate;
	}
	/**
	 * @return the bidEndDate
	 */
	public Date getBidEndDate() {
		return BidEndDate;
	}
	/**
	 * @param bidEndDate the bidEndDate to set
	 */
	public void setBidEndDate(Timestamp bidEndDate) {
		this.BidEndDate = bidEndDate;
	}
	/**
	 * @return the buyerId
	 */
	public int getBuyerId() {
		return BuyerId;
	}
	/**
	 * @param buyerId the buyerId to set
	 */
	public void setBuyerId(int buyerId) {
		this.BuyerId = buyerId;
	}
	/**
	 * @return the soldPrice
	 */
	public double getSoldPrice() {
		return SoldPrice;
	}


	/**
	 * @param soldPrice the soldPrice to set
	 */
	public void setSoldPrice(double soldPrice) {
		this.SoldPrice = soldPrice;
	}
	/**
	 * @return the auctionStatus
	 */
	public int getAuctionStatus() {
		return Status;
	}
	/**
	 * @param auctionStatus the auctionStatus to set
	 */
	public void setAuctionStatus(int auctionStatus) {
		this.Status = auctionStatus;
	}
	
	/**
	 * @return the productId
	 */
	public int getProductId() {
		return productId;
	}
	/**
	 * @param productId the productId to set
	 */
	public void setProductId(int productId) {
		this.productId = productId;
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
		return "ProductForAuction [minimumBidValue=" + MinBidValue + ", bidStartDate=" + BidStartDate
				+ ", bidEndDate=" + BidEndDate + ", buyerId=" + BuyerId + ", soldPrice=" + SoldPrice
				+ ", auctionStatus=" + Status + ", productId=" + productId + "]";
	}


}
