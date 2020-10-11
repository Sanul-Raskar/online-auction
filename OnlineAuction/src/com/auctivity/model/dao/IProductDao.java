package com.auctivity.model.dao;

import java.util.List;

import com.auctivity.model.beans.Product;

public interface IProductDao {
	List<Product> getBidProducts();
	List<Product> getProductHistory(int user_type);
}
