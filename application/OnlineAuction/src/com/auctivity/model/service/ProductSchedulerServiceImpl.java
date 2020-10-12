package com.auctivity.model.service;

import java.util.List;

import com.auctivity.model.beans.Product;
import com.auctivity.model.beans.ProductForAuction;
import com.auctivity.model.dao.IProductSchedulerDao;
import com.auctivity.model.dao.ProductSchedulerDaoImpl;

/**
 * Implementation of Service Product Scheduler from Product Scheduler Interface
 */
public class ProductSchedulerServiceImpl implements IProductSchedulerService {
	
	 
	IProductSchedulerDao productSchedulerDao= new ProductSchedulerDaoImpl();
	
	/*
	 * Function to schedule an auction
	 */
	@Override
	public int scheduleAuction(ProductForAuction productAuction) {
		 
		return productSchedulerDao.scheduleAuction(productAuction);
	}
	
	/*
	 * Function returning product list provided Seller Id 
	 */
	@Override
	public List<Product> getProductList(int sellerId) {
		 
		return productSchedulerDao.getProductList(sellerId);
	}
	
}
