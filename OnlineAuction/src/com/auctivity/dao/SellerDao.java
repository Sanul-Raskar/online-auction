/**
 * 
 */
package com.auctivity.dao;
import java.sql.SQLException;
import java.util.List;

import com.auctivity.exceptions.CustomException;
import com.auctivity.model.Product;
/**
 * @author
 *
 */
public interface SellerDao {
	
	public void addProduct(Product product) throws CustomException;
	public List<Product> readSellerData() throws SQLException;
	
	

}
