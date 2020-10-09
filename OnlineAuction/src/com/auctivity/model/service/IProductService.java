package com.auctivity.model.service;

import java.util.List;

import com.auctivity.model.beans.Product;

public interface IProductService {
	List<Product> getBidProducts();
	List<Product> getProductHistory(int user_type);
}
