/**
 * 
 */
package com.auctivity.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.auctivity.controller.GetConnection;
import com.auctivity.exceptions.CustomException;
import com.auctivity.model.Product;

/**
 *  
 *
 */
public class SellerDaoImpl implements SellerDao {

	PreparedStatement ps = null;
	Connection connection = GetConnection.getConnectionId();
	
	List<Product> products = new ArrayList<Product>();
	
	@Override
	public void addProduct(Product product) throws CustomException  {
		// TODO Auto-generated method stub
		

		String insert="insert into OnlineAuctionDB.Product (ProductName,ProductCategory,ProductDesc,ActualPrice,Quantity,Image,SellerID) values(?,?,?,?,?,?,?)";
		PreparedStatement ps;
		Connection connection = GetConnection.getConnectionId();

		
		 try {
			 connection = DriverManager.getConnection("jdbc:derby:C:\\Users\\hp\\MyDB;create=true");
			 ps=connection.prepareStatement(insert);
			 ps.setString(1,product.getProductName());
			 ps.setString(2,product.getProductCategory());
			 ps.setString(3,product.getProductDescription());
			 ps.setDouble(4,product.getProductPrice());
			 ps.setInt(5,product.getProductQuantity());
			 ps.setString(6,product.getProductImage());
			 ps.setInt(7,product.getProductSellerId());
			 
			int i= ps.executeUpdate();
			if(i>0)
				System.out.println("Record Inserted");
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 finally {
			 try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		 }
		
	}

	@Override
	public List<Product> readSellerData() throws SQLException {
		
		//Connection connection = DriverManager.getConnection("jdbc:derby:C:\\Users\\hp\\MyDB;create=true");
//		System.out.println("");
//		String readQuery = "select * from ONLINEAUCTIONDB.PRODUCT where SELLERID = 100";
//		ps = connection.prepareStatement(readQuery);
//		ResultSet rs = ps.executeQuery();
//        
//        while (rs.next()) {
//        	
//        	System.out.println("first value : " + rs.getInt("ProductId"));
////        	products.add(new Product(rs.getInt(1),rs.getString(2), rs.getString(3),rs.getString(4),rs.getDouble(5),rs.getInt(6),rs.getString(7),rs.getInt(8)));
////        	products.add(new Product(rs.getInt(0),rs.getString(1), rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getInt(5),rs.getString(6),rs.getInt(7)));
//        }
//		System.out.println(products);
//		
		
		PreparedStatement stmt = null;
		 Connection conn =null;
		 String fetch = "Select * from ONLINEAUCTIONDB.PRODUCT";
		 
		 try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			conn = DriverManager.getConnection("jdbc:derby:C:\\\\Users\\\\hp\\\\MyDB;create=true");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 stmt = conn.prepareStatement(fetch);
		 
		 ResultSet rs = stmt.executeQuery();
		 while(rs.next()) {
			 System.out.println("first value : " + rs.getInt("productId"));
			 System.out.println("second value : " + rs.getString("productName"));
			 products.add(new Product(rs.getInt("productId"),rs.getString("productName"), rs.getString("productCategory"),rs.getString("productDesc"),rs.getDouble("ActualPrice"),rs.getInt("Quantity"),rs.getString("Image"),rs.getInt("SellerId")));
			 
		 }
		
		System.out.println(products);
		return products;
	}

}
