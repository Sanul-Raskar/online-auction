package com.auctivity.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.auctivity.model.beans.Product;
import com.auctivity.model.beans.ProductForAuction;
import com.auctivity.model.beans.ProductForAuction.status;
import com.auctivity.utility.DBConnection;

/**
 * 
 * Implementation of Product Scheduler from Product Interface Scheduler 
 *
 */
public class ProductSchedulerDaoImpl implements IProductSchedulerDao {

	/**
	 * Function to add data into the database while scheduling an auction
	 */
	@Override
	public int scheduleAuction(ProductForAuction productAuction) {

		int status=0;
		
		Connection conn = DBConnection.getConnectionId();	
		PreparedStatement ps,ps1;
		ResultSet resultset;
		int productId = 0;
		if(checkIfBidScheduled(productAuction.getProductId())) {
			status=999;
			return status;
		}
		else {
			try {
				ps = conn.prepareStatement("insert into OnlineAuctionDB.ProductBid(MinBidValue,BidStartDate,BidEndDate,ProductID,Status) values(?,?,?,?,?)");
				//ps1=conn.prepareStatement("select ProductID from OnlineAuctionDB.Product where ProductName = '"+productAuction.getProductName()+"'");
//				
//				resultset=ps1.executeQuery();
//				while(resultset.next())
//				{
//					productId=resultset.getInt(1);
//			    }
				LocalDate startDate = productAuction.getBidStartDate();
				LocalDate endDate = productAuction.getBidEndDate();
				LocalDateTime startDateTime = LocalDateTime.of(startDate.getYear(), startDate.getMonth(), startDate.getDayOfMonth(), LocalDateTime.now().getHour(), LocalDateTime.now().getMinute());
				LocalDateTime endDateTime = LocalDateTime.of(endDate.getYear(), endDate.getMonth(), endDate.getDayOfMonth(), 19, 0);
//				System.out.println(productId+","+productAuction.getProductName());
				ps.setDouble(1,productAuction.getMinBidValue());		
				ps.setTimestamp(2,Timestamp.valueOf(startDateTime));
				ps.setTimestamp(3,Timestamp.valueOf(endDateTime));
				//ps.setInt(4,300);
				ps.setInt(4,productAuction.getProductId());
				//ps.setDouble(6,0);
				ps.setInt(5,productAuction.getBidStatus());
				status = ps.executeUpdate();
				System.out.println("Schedule Auction status::"+status);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	
		return status;
	}

	/**
	 * Function to get the list of Products based on Seller Id
	 */
	@Override
	public List<Product> getProductList(int sellerId) 
	{
		 
		List<Product> productList = new ArrayList<Product>();
		Connection conn = DBConnection.getConnectionId();	
		PreparedStatement ps;
		ResultSet resultset;

		try
		{
			//Query to get thhe product Id and Name 
			ps = conn.prepareStatement("select ProductID,ProductName from OnlineAuctionDB.Product where SellerID=?");
			ps.setInt(1,sellerId);
			resultset = ps.executeQuery();
			while (resultset.next())
			{
				int productId = resultset.getInt(1);
                String productName = resultset.getString(2);
                Product product = new Product(productId, productName);
                    
                System.out.println("Id name =="+productId+","+productName);
                productList.add(product);
			}
//			System.out.println(sellerId);
//			System.out.println(productList);
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return productList;
	}

	/**
	 * Function to check if the bid was scheduled or not based on product Id
	 */
	@Override
	public boolean checkIfBidScheduled(int productId) {
		Connection conn = DBConnection.getConnectionId();	
		PreparedStatement ps12 = null;
		ResultSet resultset;
		try {
			String query = "select * from OnlineAuctionDB.ProductBid where ProductID=?";
			ps12 = conn.prepareStatement(query);

			ps12.setInt(1,productId);
			resultset = ps12.executeQuery();
			while (resultset.next())
			{
                String productName12 = resultset.getString(2);
                    
                System.out.println("Product name exist::"+productName12);
                return true;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Product id NOT EXIST:"+productId);
		return false;
	}
}
