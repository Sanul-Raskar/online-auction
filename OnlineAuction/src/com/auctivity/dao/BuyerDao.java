package com.auctivity.dao;

import java.util.List;

import com.auctivity.exceptions.CustomException;
import com.auctivity.model.Product;

public interface BuyerDao {

	public List<Product> getProducts() throws CustomException;
}
