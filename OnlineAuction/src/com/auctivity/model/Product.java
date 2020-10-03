/**
 * This java file is a class that model the class Product
 */
package com.auctivity.model;


public class Product {

	private int productId;
	private String productName;
	private String productCategory;
	private String productDescription;
	private double productPrice;
	private int productQuantity;
	private String productImage;
	//productSellerId must be registered with userId first
	private int productSellerId;
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
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}
	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	/**
	 * @return the productCategory
	 */
	public String getProductCategory() {
		return productCategory;
	}
	/**
	 * @param productCategory the productCategory to set
	 */
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	/**
	 * @return the productDescription
	 */
	public String getProductDescription() {
		return productDescription;
	}
	/**
	 * @param productDescription the productDescription to set
	 */
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	/**
	 * @return the productPrice
	 */
	public double getProductPrice() {
		return productPrice;
	}
	/**
	 * @param productPrice the productPrice to set
	 */
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	/**
	 * @return the productQuantity
	 */
	public int getProductQuantity() {
		return productQuantity;
	}
	/**
	 * @param productQuantity the productQuantity to set
	 */
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	/**
	 * @return the productImage
	 */
	public String getProductImage() {
		return productImage;
	}
	/**
	 * @param productImage the productImage to set
	 */
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	/**
	 * @return the productSellerId
	 */
	public int getProductSellerId() {
		return productSellerId;
	}
	/**
	 * @param productSellerId the productSellerId to set
	 */
	public void setProductSellerId(int productSellerId) {
		this.productSellerId = productSellerId;
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
		this.productId = productId;
		this.productName = productName;
		this.productCategory = productCategory;
		this.productDescription = productDescription;
		this.productPrice = productPrice;
		this.productQuantity = productQuantity;
		this.productImage = productImage;
		this.productSellerId = productSellerId;
	}
	
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productCategory="
				+ productCategory + ", productDescription=" + productDescription + ", productPrice=" + productPrice
				+ ", productQuantity=" + productQuantity + ", productImage=" + productImage + ", productSellerId="
				+ productSellerId + "]";
	}
	
	

}
