package com.auctivity.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Timer;
import java.util.TimerTask;

import com.auctivity.connection.ConnectionProvider;

//This class implements ISchedule interface
public class ScheduleAuction implements ISchedule{

	@Override
	public void scheduleAcution() {
		System.out.println("HEYYY doSchedule");	
		
		//Creating object of class file
	      MyTimerTask myTask = new MyTimerTask();
	      
	      //Timer for scheduling class at specific interval
	      Timer myTimer = new Timer();
	      myTimer.schedule(myTask, 0, 60000);
	}
	public static int getTime(Timestamp bidStartDate) {
	 	int hour = LocalDateTime.now().getHour(); 
	 	int minute = LocalDateTime.now().getMinute();
	 	int day = LocalDateTime.now().getDayOfMonth();
	 	int month = LocalDateTime.now().getMonthValue();
	 	int year = LocalDateTime.now().getYear();
	 	
	 	Date productDate = new Date(bidStartDate.getTime());
	 	int dayProduct = bidStartDate.getDate();
	 	int monthProduct = bidStartDate.getMonth() + 1;
	 	int yearProduct = productDate.getYear() + 1900;
	 	int hourProduct = bidStartDate.getHours();
	 	int minuteProduct = bidStartDate.getMinutes();
	    System.out.println("Product date is: "+dayProduct+"::"+monthProduct+"::"+yearProduct+" "+hourProduct+"::"+minuteProduct);  
	    System.out.println("Today date: "+day+"::"+month+"::"+year+" "+hour+"::"+minute);  
	
	    if(day==dayProduct && month==monthProduct && year==yearProduct && hour==hourProduct && minute==minuteProduct) {
	    	return 1;
	    }
	    else
	    	return 0;
	}
}

class MyTimerTask extends TimerTask {
	Statement stmt,stmt1 = null;
	PreparedStatement pstmt=null;
	Connection con  = ConnectionProvider.getConnection();
      String sql = "SELECT * FROM OnlineAuctionDb.productbid";
	  public void run() {
	    System.out.println("Timer task executed.");
	    try {
			stmt = con.createStatement();
		      ResultSet rs = stmt.executeQuery(sql);
		      while(rs.next()) {
		    		double minimumBidValue = rs.getDouble("minbidvalue");
		    		Timestamp bidStartDate = rs.getTimestamp("bidstartdate");
		    		Timestamp bidEndDate = rs.getTimestamp("bidenddate");
		    		// @buyerId must be registered with @userId
		    		int buyerId = rs.getInt("buyerid");
		    		double soldPrice = rs.getDouble("soldprice");
		    		int auctionStatus = rs.getInt("status");
		    		int productId = rs.getInt("productid");
		    		int response = ScheduleAuction.getTime(bidStartDate);
		    		System.out.println("response::"+response);
		    		if(response==1) {
			    		System.out.println("productId inner::"+productId);
			    		pstmt = con.prepareStatement("update OnlineAuctionDb.productbid set status=4 where productid=?");
		    			pstmt.setInt(1,productId);
			    		int i = pstmt.executeUpdate();
		    			System.out.println(i>0?"Bid started successfull "+i:"Error starting bid:"+i);
		    		}
		      }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
	}
