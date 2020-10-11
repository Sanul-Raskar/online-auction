package com.auctivity.model.dao;

import java.util.List;

import com.auctivity.model.beans.Bid;
import com.auctivity.model.beans.Product;
import com.auctivity.model.beans.ProductForAuction;

public interface IProductDao {
	public List<ProductForAuction> getBidProducts();
	public List<ProductForAuction> getProductHistory(int user_id);
	public int placeBid(Bid bid);

}
