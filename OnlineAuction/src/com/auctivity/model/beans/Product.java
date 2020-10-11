/**
 * This java file is a class that model the class Product
 */
package com.auctivity.model.beans;


public class Product {

	private int ProductId;
	private String ProductName;
	private String ProductCategory;
	private String ProductDesc;
	private double ActualPrice;
	private int Quantity;
	private String Image;
	// @SellerId must be registered with @userId first
	private int SellerId;
	/**
	 * @return the productId
	 */
	public int getProductId() {
		return ProductId;
	}
	/**
	 * @param productId the productId to set
	 */
	public void setProductId(int productId) {
		this.ProductId = productId;
	}
	/**
	 * @return the productName
	 */
	public String getProductName() {
		return ProductName;
	}
	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.ProductName = productName;
	}
	/**
	 * @return the productCategory
	 */
	public String getProductCategory() {
		return ProductCategory;
	}
	/**
	 * @param productCategory the productCategory to set
	 */
	public void setProductCategory(String productCategory) {
		this.ProductCategory = productCategory;
	}
	/**
	 * @return the productDescription
	 */
	public String getProductDescription() {
		return ProductDesc;
	}
	/**
	 * @param productDescription the productDescription to set
	 */
	public void setProductDescription(String productDescription) {
		this.ProductDesc = productDescription;
	}
	/**
	 * @return the productPrice
	 */
	public double getProductPrice() {
		return ActualPrice;
	}
	/**
	 * @param productPrice the productPrice to set
	 */
	public void setProductPrice(double productPrice) {
		this.ActualPrice = productPrice;
	}
	/**
	 * @return the productQuantity
	 */
	public int getProductQuantity() {
		return Quantity;
	}
	/**
	 * @param productQuantity the productQuantity to set
	 */
	public void setProductQuantity(int productQuantity) {
		this.Quantity = productQuantity;
	}
	/**
	 * @return the productImage
	 */
	public String getProductImage() {
		return Image;
	}
	/**
	 * @param productImage the productImage to set
	 */
	public void setProductImage(String productImage) {
		this.Image = productImage;
	}
	/**
	 * @return the productSellerId
	 */
	public int getProductSellerId() {
		return SellerId;
	}
	/**
	 * @param productSellerId the productSellerId to set
	 */
	public void setProductSellerId(int productSellerId) {
		this.SellerId = productSellerId;
	}
	/**
	 * Constructor of Super class
	 */
	public Product() {
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
	public Product(int productId, String productName, String productCategory, String productDescription,
			double productPrice, int productQuantity, String productImage, int productSellerId) {
		super();
		this.ProductId = productId;
		this.ProductName = productName;
		this.ProductCategory = productCategory;
		this.ProductDesc = productDescription;
		this.ActualPrice = productPrice;
		this.Quantity = productQuantity;
		this.Image = productImage;
		this.SellerId = productSellerId;
	}
	
	
	public Product(int productId, String productName, String productCategory, String productDesc, double actualPrice,
			int quantity, String image) {
		super();
		this.ProductId = productId;
		this.ProductName = productName;
		this.ProductCategory = productCategory;
		this.ProductDesc = productDesc;
		this.ActualPrice = actualPrice;
		this.Quantity = quantity;
		this.Image = image;
	}
	public Product(String productName, String image)
	{
		super();
		this.Image=image;
		this.ProductName=productName;
	}
	@Override
	public String toString() {
		return "Product [productId=" + ProductId + ", productName=" + ProductName + ", productCategory="
				+ ProductCategory + ", productDescription=" + ProductDesc + ", productPrice=" + ActualPrice
				+ ", productQuantity=" + Quantity + ", productImage=" + Image + ", productSellerId="
				+ SellerId + "]";
	}
	
	

}
