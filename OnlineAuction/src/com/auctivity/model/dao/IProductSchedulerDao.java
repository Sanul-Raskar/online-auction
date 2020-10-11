package com.auctivity.model.dao;

import com.auctivity.model.beans.ProductForAuction;

public interface IProductSchedulerDao {
	int scheduleAuction(ProductForAuction productAuction);
}
