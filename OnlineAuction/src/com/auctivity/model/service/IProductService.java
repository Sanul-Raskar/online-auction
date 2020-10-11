package com.auctivity.model.service;

import java.util.List;
import com.auctivity.model.beans.Bid;

import com.auctivity.model.beans.Category;
import com.auctivity.model.beans.Product;
import com.auctivity.model.beans.ProductForAuction;

public interface IProductService {
	public List<ProductForAuction> getBidProducts();
	public List<ProductForAuction> getProductHistory(int user_id);
	public List<ProductForAuction> getSellerProducts(int user_id);
	public int placeBid(Bid bid);
	int addProducts(Product product);
	public List<Category> getCategoryList();
	public void scheduleTask();
}
