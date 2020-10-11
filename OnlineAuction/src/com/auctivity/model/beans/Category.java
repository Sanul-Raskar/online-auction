/**
 * This java file is a class that model the class Product Category
 */
package com.auctivity.model.beans;

public class Category {

	private int categoryId;
	private String categoryName;
	private String categoryDescription;
	/**
	 * @return the categoryId
	 */
	public int getCategoryId() {
		return categoryId;
	}
	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	/**
	 * @return the categoryName
	 */
	public String getCategoryName() {
		return categoryName;
	}
	/**
	 * @param categoryName the categoryName to set
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	/**
	 * @return the categoryDescription
	 */
	public String getCategoryDescription() {
		return categoryDescription;
	}
	/**
	 * @param categoryDescription the categoryDescription to set
	 */
	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}
	/**
	 * Constructor of Super class
	 */
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param categoryId
	 * @param categoryName
	 * @param categoryDescription
	 */
	public Category(int categoryId, String categoryName, String categoryDescription) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.categoryDescription = categoryDescription;
	}
	
	
	/**
	 * @param categoryId
	 * @param categoryName
	 */
	public Category(int categoryId, String categoryName) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}
	@Override
	public String toString() {
		return "ProductCategory [categoryId=" + categoryId + ", categoryName=" + categoryName + ", categoryDescription="
				+ categoryDescription + "]";
	}
	
	
	
	

}