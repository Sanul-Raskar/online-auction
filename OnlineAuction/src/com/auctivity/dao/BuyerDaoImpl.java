package com.auctivity.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.auctivity.controller.GetConnection;
import com.auctivity.exceptions.CustomException;
import com.auctivity.model.Product;

public class BuyerDaoImpl implements BuyerDao {

	@Override
	public List<Product> getProducts() throws CustomException {
		List<Product> prodList= new ArrayList<Product>();

		Connection connection = GetConnection.getConnectionId();
		String getData = "select * from ONLINEAUCTIONDB.PRODUCT";
		try {
		PreparedStatement ps = connection.prepareStatement(getData);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			 int prodID=rs.getInt("ProductID");
			 String pname=rs.getString("ProductName");
			 String pcat=rs.getString("ProductCategory");
			 String pdesc=rs.getString("ProductDesc");
			 double price=rs.getInt("ActualPrice");
			 int quan=rs.getInt("Quantity");
			 String img=rs.getString("Image");
			 int pid=rs.getInt("SellerID");
			 Product prod= new Product(prodID, pname, pcat, pdesc, price, quan, img, pid);
			 prodList.add(prod);
			// System.out.println(pcat);
			
		}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return prodList;
	}

}
