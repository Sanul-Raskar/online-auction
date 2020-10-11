/**
 * This java file is a class that model the class Product Category
 */
package com.auctivity.model.beans;

public class Category {

	private int CategoryId;
	private String CategoryName;
	private String CategoryDescription;
	/**
	 * @return the categoryId
	 */
	public int getCategoryId() {
		return CategoryId;
	}
	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(int categoryId) {
		this.CategoryId = categoryId;
	}
	/**
	 * @return the categoryName
	 */
	public String getCategoryName() {
		return CategoryName;
	}
	/**
	 * @param categoryName the categoryName to set
	 */
	public void setCategoryName(String categoryName) {
		this.CategoryName = categoryName;
	}
	/**
	 * @return the categoryDescription
	 */
	public String getCategoryDescription() {
		return CategoryDescription;
	}
	/**
	 * @param categoryDescription the categoryDescription to set
	 */
	public void setCategoryDescription(String categoryDescription) {
		this.CategoryDescription = categoryDescription;
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
		this.CategoryId = categoryId;
		this.CategoryName = categoryName;
		this.CategoryDescription = categoryDescription;
	}
	
	@Override
	public String toString() {
		return "ProductCategory [categoryId=" + CategoryId + ", categoryName=" + CategoryName + ", categoryDescription="
				+ CategoryDescription + "]";
	}
	
	
	
	

}
