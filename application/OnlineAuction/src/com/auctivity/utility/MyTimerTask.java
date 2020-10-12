package com.auctivity.utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Timer;
import java.util.TimerTask;
import com.auctivity.controller.ScheduleAuctionController;
import com.auctivity.model.dao.IProductDao;
import com.auctivity.model.service.IProductService;
import com.auctivity.model.service.ProductServiceImpl;

public class MyTimerTask extends TimerTask{
	IProductService iProductService = new ProductServiceImpl();
	  public void run() {
		 iProductService.scheduleTask();
	  }
	  
		public static void scheduleAcution() {
			System.out.println("in doSchedule");	
			
			//Creating object of class file
		      MyTimerTask myTask = new MyTimerTask();
		      
		      //Timer for scheduling class at specific interval
		      Timer myTimer = new Timer();
		      myTimer.schedule(myTask, 0, 60000);
		}
}
