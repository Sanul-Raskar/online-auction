package com.auctivity.model.service;

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
	
}
