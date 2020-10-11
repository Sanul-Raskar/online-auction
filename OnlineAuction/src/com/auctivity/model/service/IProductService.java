package com.auctivity.model.service;

import java.util.List;

import com.auctivity.model.beans.Product;
import com.auctivity.model.beans.ProductForAuction;

public interface IProductService {
	List<ProductForAuction> getBidProducts();
	List<ProductForAuction> getProductHistory(int user_id);
	List<ProductForAuction> getSellerProducts(int user_id);
}
