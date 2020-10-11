package com.auctivity.model.service;

import java.util.List;

import com.auctivity.model.beans.Product;
import com.auctivity.model.beans.ProductForAuction;
import com.auctivity.model.dao.IProductSchedulerDao;
import com.auctivity.model.dao.ProductSchedulerDaoImpl;

public class ProductSchedulerServiceImpl implements IProductSchedulerService {

	IProductSchedulerDao productSchedulerDao= new ProductSchedulerDaoImpl();
	@Override
	public int scheduleAuction(ProductForAuction productAuction) {
		// TODO Auto-generated method stub
		return productSchedulerDao.scheduleAuction(productAuction);
	}
	@Override
	public List<Product> getProductList(int sellerId) {
		// TODO Auto-generated method stub
		return productSchedulerDao.getProductList(sellerId);
	}
	
}
