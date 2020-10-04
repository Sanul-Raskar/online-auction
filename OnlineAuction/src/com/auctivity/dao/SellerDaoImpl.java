/**
 * 
 */
package com.auctivity.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.auctivity.controller.GetConnection;
import com.auctivity.exceptions.CustomException;
import com.auctivity.model.Product;

/**
 * @author mrunal
 *
 */
public class SellerDaoImpl implements SellerDao {

	@Override
	public void addProduct(Product product) throws CustomException {
		// TODO Auto-generated method stub
		
		String insert="Insert into OnlineAuctionDB.Product (ProductName,ProductCategory,ProductDesc,ActualPrice,Quantity,SellerID) values(?,?,?,?,?,?)";
		PreparedStatement ps;
		Connection connection = GetConnection.getConnectionId();
		
		 try {
			 
			 ps=connection.prepareStatement(insert);
			 ps.setString(1,product.getProductName());
			 ps.setString(2,product.getProductCategory());
			 ps.setString(3,product.getProductDescription());
			 ps.setDouble(4,product.getProductPrice());
			 ps.setInt(5,product.getProductQuantity());
			 ps.setInt(6,product.getProductSellerId());
			 
			int i= ps.executeUpdate();
			if(i>0)
				System.out.println("Record Inserted");
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
