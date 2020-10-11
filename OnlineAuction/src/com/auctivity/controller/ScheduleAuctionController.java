package com.auctivity.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.auctivity.model.beans.ProductForAuction;
import com.auctivity.model.beans.ProductForAuction.status;
import com.auctivity.model.service.IProductSchedulerService;
import com.auctivity.model.service.IUserService;
import com.auctivity.utility.ObjectFactory;


/**
 * Servlet implementation class ScheduleAuctionController
 */
@WebServlet("/scheduleauction")
public class ScheduleAuctionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final status OPEN = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ScheduleAuctionController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/seller/scheduleAuction.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
		String products=request.getParameter("products");
		double minimumBidValue=Double.parseDouble(request.getParameter("minimumBidValue"));
		
		//parsing date in required format
		LocalDate sDate = LocalDate.parse(request.getParameter("startDate"));
		//java.sql.Date startDate = java.sql.Date.valueOf(formatter.format(sDate));
		
		LocalDate eDate = LocalDate.parse(request.getParameter("endDate"));
//		LocalTime timePart = LocalTime.parse("07:00:00");
//	    LocalDateTime edt = LocalDateTime.of(eDate, timePart);
		//String endTime = String.valueOf(eDate+);
		//java.sql.Date endDate = java.sql.Date.valueOf(formatter.format(eDate));
		
		
		
       // Timestamp endDateTime = Timestamp.valueOf(endTime);

		//response.getWriter().append(products);
		System.out.println(products);
		System.out.println(minimumBidValue);
//		System.out.println(request.getParameter("startDate"));
//		System.out.println(request.getParameter("endDate"));
		System.out.println(sDate);
		System.out.println(eDate);
			
		System.out.println("Obj Created");
		
		ObjectFactory objectFactory = new ObjectFactory();
		IProductSchedulerService productSchedule = objectFactory.createProductSchedulerServiceImplObj(); 
	
		ProductForAuction productAuction=new ProductForAuction();
		productAuction.setProductName(products);
		productAuction.setProductId(101);
		productAuction.setMinBidValue(minimumBidValue);
		productAuction.setBidStartDate(sDate.now());
		productAuction.setBidEndDate(eDate);
		productAuction.setBidStatus(1);
		
		response.setStatus(productSchedule.scheduleAuction(productAuction) == 1 ? 200 : 999);
	}

}
