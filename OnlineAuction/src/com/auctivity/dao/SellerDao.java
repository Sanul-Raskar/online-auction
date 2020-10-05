/**
 * 
 */
package com.auctivity.dao;
import com.auctivity.exceptions.CustomException;
import com.auctivity.model.Product;
/**
 * @author mrunal
 *
 */
public interface SellerDao {
	
	public void addProduct(Product product) throws CustomException;

}
