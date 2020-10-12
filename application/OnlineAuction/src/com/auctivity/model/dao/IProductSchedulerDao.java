package com.auctivity.model.dao;

import java.util.List;

import com.auctivity.model.beans.Product;
import com.auctivity.model.beans.ProductForAuction;

public interface IProductSchedulerDao {
	int scheduleAuction(ProductForAuction productAuction);
	List<Product> getProductList(int sellerId);
	boolean checkIfBidScheduled(int productId);
}
