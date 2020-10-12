package com.auctivity.model.service;

import java.util.List;
import com.auctivity.model.beans.Bid;
import com.auctivity.model.beans.Category;
import com.auctivity.model.beans.Product;
import com.auctivity.model.beans.ProductForAuction;
import com.auctivity.model.dao.IProductDao;
import com.auctivity.model.dao.IUserDao;
import com.auctivity.model.dao.ProductDaoImpl;
import com.auctivity.model.dao.UserDaoImpl;
import com.auctivity.utility.ObjectFactory;

/**
 * 
 * Product Service Implementation from Product Service Interface 
 *
 */
public class ProductServiceImpl implements IProductService{
	
	//Creating Object of ObjectFactory
	ObjectFactory objectFactory = new ObjectFactory();
	IProductDao productDao = objectFactory.createProductDaoImplObj();
	
	/*
	 * Function returning list of bid products
	 */
	@Override
	public List<ProductForAuction> getBidProducts() {
		return productDao.getBidProducts();
	}
	
	/*
	 * Function returning list of History products
	 */
	@Override
	public List<ProductForAuction> getProductHistory(int user_id) {
		return productDao.getProductHistory(user_id);
	}
	
	/*
	 * Function for placing a bid
	 */
	@Override
	public int placeBid(Bid bid) {
		return productDao.placeBid(bid);
	}
	public List<ProductForAuction> getSellerProducts(int user_id) {
		 
		return productDao.getSellerProducts(user_id);
	}
	
	/*
	 * Function to insert/add products
	 */
	public int addProducts(Product product) {
		return productDao.addProducts(product);
	}
	
	/*
	 * Function returning list of Categories
	 */
	@Override
	public List<Category> getCategoryList() {
		 
		return productDao.getCategoryList();
	}
	
	/*
	 * Function to schedule a task
	 */
	public void scheduleTask() {
		productDao.scheduleTask();
	}

}
