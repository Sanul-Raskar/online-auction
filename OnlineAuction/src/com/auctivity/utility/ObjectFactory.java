package com.auctivity.utility;

import com.auctivity.model.dao.IProductDao;
import com.auctivity.model.dao.IProductSchedulerDao;
import com.auctivity.model.dao.IUserDao;
import com.auctivity.model.dao.ProductDaoImpl;
import com.auctivity.model.dao.ProductSchedulerDaoImpl;
import com.auctivity.model.dao.UserDaoImpl;
import com.auctivity.model.service.IProductSchedulerService;
import com.auctivity.model.service.IProductService;
import com.auctivity.model.service.IUserService;
import com.auctivity.model.service.ProductSchedulerServiceImpl;
import com.auctivity.model.service.ProductServiceImpl;
import com.auctivity.model.service.UserServiceImpl;

public class ObjectFactory {

	public IProductSchedulerDao createProductSchedulerDaoImplObj() {
		return new ProductSchedulerDaoImpl();
	}

	public IProductDao createProductDaoImplObj() {
		return new ProductDaoImpl();
	}

	public IUserDao createUserDaoImplObj() {
		return new UserDaoImpl();
	}

	public IProductSchedulerService createProductSchedulerServiceImplObj() {
		return new ProductSchedulerServiceImpl();
	}

	public IProductService createProductServiceImplObj() {
		return new ProductServiceImpl();
	}

	public IUserService createUserServiceImplObj() {
		return new UserServiceImpl();
	}

}
