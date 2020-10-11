package com.auctivity.model.dao;

import java.util.List;

import com.auctivity.model.beans.Category;
import com.auctivity.model.beans.Product;
import com.auctivity.model.beans.ProductForAuction;

public interface IProductDao {
	List<ProductForAuction> getBidProducts();
	List<ProductForAuction> getProductHistory(int user_id);
	List<ProductForAuction> getSellerProducts(int user_id);
	int addProducts(Product product);
	List<Category> getCategoryList();
}
