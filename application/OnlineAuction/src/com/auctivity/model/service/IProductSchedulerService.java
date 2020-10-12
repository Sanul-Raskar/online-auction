package com.auctivity.model.service;

import java.util.List;

import com.auctivity.model.beans.Product;
import com.auctivity.model.beans.ProductForAuction;

public interface IProductSchedulerService {
	int scheduleAuction(ProductForAuction productAuction);
	List<Product> getProductList(int sellerId);
}
