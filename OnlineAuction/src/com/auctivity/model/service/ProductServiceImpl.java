package com.auctivity.model.service;

import java.util.List;

import com.auctivity.model.beans.Category;
import com.auctivity.model.beans.Product;
import com.auctivity.model.beans.ProductForAuction;
import com.auctivity.model.dao.IProductDao;
import com.auctivity.model.dao.IUserDao;
import com.auctivity.model.dao.ProductDaoImpl;
import com.auctivity.model.dao.UserDaoImpl;
import com.auctivity.utility.ObjectFactory;

public class ProductServiceImpl implements IProductService{
	ObjectFactory objectFactory = new ObjectFactory();
	IProductDao productDao = objectFactory.createProductDaoImplObj();

	@Override
	public List<ProductForAuction> getBidProducts() {
		// TODO Auto-generated method stub
		return productDao.getBidProducts();
	}

	@Override
	public List<ProductForAuction> getProductHistory(int user_id) {
		// TODO Auto-generated method stub
		return productDao.getProductHistory(user_id);
	}

	@Override
	public List<ProductForAuction> getSellerProducts(int user_id) {
		// TODO Auto-generated method stub
		return productDao.getSellerProducts(user_id);
	}
	
	public int addProducts(Product product) {
		return productDao.addProducts(product);
	}

	@Override
	public List<Category> getCategoryList() {
		// TODO Auto-generated method stub
		return productDao.getCategoryList();
	}

}
