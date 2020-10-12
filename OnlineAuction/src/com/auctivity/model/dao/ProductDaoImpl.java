package com.auctivity.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.auctivity.model.beans.Bid;
import com.auctivity.model.beans.Category;

import com.auctivity.controller.ScheduleAuctionController;

import com.auctivity.model.beans.Product;
import com.auctivity.model.beans.ProductForAuction;
import com.auctivity.model.beans.ProductForAuction.status;
import com.auctivity.utility.DBConnection;

public class ProductDaoImpl implements IProductDao {
	static Connection conn = null;

	@Override
	public List<ProductForAuction> getBidProducts() {
		List<ProductForAuction> prodList = new ArrayList<ProductForAuction>();
		conn = DBConnection.getConnectionId();
		ResultSet rs = null;
		Product pa = new Product();
		try {
			String getQuery = "Select OnlineAuctionDB.Product.ProductID,OnlineAuctionDB.Productbid.MinBidValue,OnlineAuctionDB.ProductBid.BidStartDate,OnlineAuctionDB.ProductBid.BidEndDate,OnlineAuctionDB.Product.ProductName,OnlineAuctionDB.Product.ProductCategory,OnlineAuctionDB.Product.ProductDesc,OnlineAuctionDB.Product.ActualPrice,OnlineAuctionDB.Product.Quantity,OnlineAuctionDB.Product.Image, OnlineAuctionDB.ProductBid.Status From OnlineAuctionDB.ProductBid inner join OnlineAuctionDB.Product on OnlineAuctionDB.ProductBid.ProductID=OnlineAuctionDB.Product.ProductID";
			PreparedStatement ps = conn.prepareStatement(getQuery);
			rs = ps.executeQuery();
			while (rs.next()) {
				int pid = rs.getInt("ProductID");
				int minBid = rs.getInt("MinBidValue");
				LocalDate sDate = rs.getTimestamp("BidStartDate").toLocalDateTime().toLocalDate();
				LocalDate eDate = rs.getTimestamp("BidEndDate").toLocalDateTime().toLocalDate();
				String pName = rs.getString("ProductName");
				String pCat = rs.getString("ProductCategory");
				String pDesc = rs.getString("ProductDesc");
				double price = rs.getDouble("ActualPrice");
				int pQuan = rs.getInt("Quantity");
				String img = rs.getString("Image");
				double sPrice = minBid;

				String DEFAULT_FILENAME = "./resources/img/logo.jpg";
				if (img.compareTo(DEFAULT_FILENAME) != 0) {
					img = "/media/" + img;
				}
				// ProductForAuction pfa= new ProductForAuction();

				int stat = rs.getInt("Status");
				status cond = status.valueOf(stat);

				prodList.add(new ProductForAuction(pid, pName, pCat, pDesc, price, pQuan, img, minBid, sDate, eDate,
						sPrice, cond));
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return prodList;
	}

	@Override
	public List<ProductForAuction> getProductHistory(int user_id) {
		List<ProductForAuction> prodList = new ArrayList<ProductForAuction>();
		conn = DBConnection.getConnectionId();
		ResultSet rs = null;
		Product pa = new Product();
		try {
			String getQuery = "select prod_bid.BidEndDate,prod.ProductName,prod.Image,prod_bid.SoldPrice, prod_bid.Status From OnlineAuctionDB.ProductBid prod_bid inner join OnlineAuctionDB.Product prod on prod_bid.ProductID=prod.ProductID where prod_bid.BuyerID=?";
			PreparedStatement ps = conn.prepareStatement(getQuery);
			ps.setInt(1, user_id);
			rs = ps.executeQuery();
			while (rs.next()) {
				LocalDate eDate = rs.getTimestamp("BidEndDate").toLocalDateTime().toLocalDate();
				LocalDate sDate = rs.getTimestamp("BidStartDate").toLocalDateTime().toLocalDate();
				String pName = rs.getString("ProductName");
				String img = rs.getString("Image");
				double sPrice = rs.getInt("SoldPrice");

				// ProductForAuction pfa= new ProductForAuction();

				int stat = rs.getInt("Status");
				status cond = status.valueOf("stat");

				// prodList.add(new ProductForAuction(pName, img, eDate,sPrice,cond));
				prodList.add(new ProductForAuction(pName, img, sPrice, sDate, eDate, cond));

			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return prodList;
	}

	@Override
	public List<ProductForAuction> getSellerProducts(int user_id) {
		// TODO Auto-generated method stub
		List<ProductForAuction> prodList = new ArrayList<ProductForAuction>();
		conn = DBConnection.getConnectionId();
		ResultSet rs = null;
		Product pa = new Product();
		String getQuery = "select * From OnlineAuctionDB.ProductBid prod_bid inner join OnlineAuctionDB.Product prod on prod_bid.ProductID=prod.ProductID where prod_bid.BuyerID=?";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(getQuery);
			ps.setInt(1, user_id);
			rs = ps.executeQuery();
			while (rs.next()) {
				LocalDate eDate = rs.getTimestamp("BidEndDate").toLocalDateTime().toLocalDate();
				LocalDate sDate = rs.getTimestamp("BidStartDate").toLocalDateTime().toLocalDate();
				// int minBidValue = rs.getInt("MinBidValue");
				String pName = rs.getString("ProductName");
				String img = rs.getString("Image");
				double sPrice = rs.getInt("SoldPrice");

				// ProductForAuction pfa= new ProductForAuction();

				int stat = rs.getInt("Status");
				status cond = status.valueOf(stat);

				prodList.add(new ProductForAuction(pName, img, sPrice, sDate, eDate, cond));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return prodList;
	}

	public int addProducts(Product product) {
		String insert = "insert into OnlineAuctionDB.Product (ProductID,ProductName,ProductCategory,ProductDesc,ActualPrice,Quantity,Image,SellerID) values(next value for OnlineAuctionDB.product_sequence,?,?,?,?,?,?,?)";
		int status = 0;
		conn = DBConnection.getConnectionId();
		try {
			PreparedStatement ps = conn.prepareStatement(insert);
			ps.setString(1, product.getProductName());
			ps.setString(2, product.getProductCategory());

			System.out.println(product.getProductDescription());

			ps.setString(3, product.getProductDescription());
			ps.setDouble(4, product.getProductPrice());
			ps.setInt(5, product.getProductQuantity());
			ps.setString(6, product.getProductImage());
			ps.setInt(7, product.getProductSellerId());

			status = ps.executeUpdate();
			return status;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return status;

	}

	@Override

	public List<Category> getCategoryList() {
		// TODO Auto-generated method stub
		List<Category> cateList = new ArrayList<Category>();
		conn = DBConnection.getConnectionId();
		ResultSet rs = null;
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement("select CategoryID,CategoryName from OnlineAuctionDB.Category");
			rs = ps.executeQuery();
			while (rs.next()) {
				int categoryID = rs.getInt(1);
				String categoryName = rs.getString(2);

				Category category = new Category(categoryID, categoryName);

				System.out.println("Id name ==" + categoryID + "," + categoryName);
				cateList.add(category);
			}

			System.out.println(cateList);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return cateList;
	}

	public void scheduleTask() {
		Statement stmt, stmt1 = null;
		PreparedStatement pstmt = null;
		Connection con = DBConnection.getConnectionId();
		String sql = "SELECT * FROM OnlineAuctionDb.productbid";
		System.out.println("Timer task executed.");
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				// double minimumBidValue = rs.getDouble("minbidvalue");
				Timestamp bidStartDate = rs.getTimestamp("bidstartdate");
				Timestamp bidEndDate = rs.getTimestamp("bidenddate");
				// @buyerId must be registered with @userId
				// int buyerId = rs.getInt("buyerid");
				// double soldPrice = rs.getDouble("soldprice");
				// int auctionStatus = rs.getInt("status");
				int productId = rs.getInt("productid");
				int response = ScheduleAuctionController.getTime(bidStartDate);
				System.out.println("response::" + response);
				if (response == 1) {
					System.out.println("productId inner::" + productId);
					pstmt = con.prepareStatement(
							"update OnlineAuctionDb.productbid set status=4 where productid=? and status!=4");
					pstmt.setInt(1, productId);
					int i = pstmt.executeUpdate();
					System.out.println(i > 0 ? "Bid started successfull " + i : "Error starting bid:" + i);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public int placeBid(Bid bid) {
		int status = 0;
		Connection conn = DBConnection.getConnectionId();
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(
					"insert into OnlineAuctionDB.Bid values (next value for OnlineAuctionDB.bid_sequence,?,?,?,?)");
			ps.setInt(1, bid.getBidderID());
			ps.setInt(2, bid.getBidProductID());
			ps.setDouble(3, bid.getBidValue());
			ps.setInt(4, 4);
			status = ps.executeUpdate();
			System.out.println("Bid success status:" + status);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return status;
	}

}