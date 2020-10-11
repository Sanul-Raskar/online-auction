package com.auctivity.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.auctivity.model.beans.Bid;
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
				String pName = rs.getString("ProductName");
				String img = rs.getString("Image");
				double sPrice = rs.getInt("SoldPrice");

				// ProductForAuction pfa= new ProductForAuction();

				int stat = rs.getInt("Status");
				status cond = status.valueOf(stat);

				prodList.add(new ProductForAuction(pName, img, eDate,sPrice, cond));
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return prodList;
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