package com.auctivity.utility;

import com.auctivity.model.dao.ProductSchedulerDaoImpl;
import com.auctivity.model.dao.UserDaoImpl;
import com.auctivity.model.service.ProductSchedulerServiceImpl;
import com.auctivity.model.service.ProductServiceImpl;
import com.auctivity.model.service.UserServiceImpl;
import com.auctivity.model.dao.ProductDaoImpl;

public class ObjectFactory {

	public static ProductSchedulerDaoImpl createProductSchedulerDaoImplObj() {
		return new ProductSchedulerDaoImpl();
	}

	public static ProductDaoImpl createProductDaoImplObj() {
		return new ProductDaoImpl();
	}

	public static UserDaoImpl createUserDaoImplObj() {
		return new UserDaoImpl();
	}

	public static ProductSchedulerServiceImpl createProductSchedulerServiceImplObj() {
		return new ProductSchedulerServiceImpl();
	}

	public static ProductServiceImpl createProductServiceImplObj() {
		return new ProductServiceImpl();
	}

	public static UserServiceImpl createUserServiceImplObj() {
		return new UserServiceImpl();
	}

}
