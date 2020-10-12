package com.auctivity.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.auctivity.model.beans.Product;
import com.auctivity.model.beans.ProductForAuction;
import com.auctivity.model.beans.User;
import com.auctivity.model.beans.ProductForAuction.status;
import com.auctivity.model.service.IProductSchedulerService;
import com.auctivity.model.service.IProductService;
import com.auctivity.model.service.IUserService;
import com.auctivity.utility.DBConnection;
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

		HttpSession session = request.getSession();
		User userInSession = (User)session.getAttribute("user");
		if(userInSession==null)
		{
			request.getRequestDispatcher("/accounts/login.jsp").forward(request, response);
		}
		else 
		{
			if(userInSession.getUserType() == 0) 
			{
				response.sendRedirect("home");

			}
			else if(userInSession.getUserType()==1) {
				System.out.println("Seller:"+(User)session.getAttribute("user"));
				int sellerId=userInSession.getUserid();
				
				ObjectFactory objectFactory = new ObjectFactory();
				IProductSchedulerService productSchedule = objectFactory.createProductSchedulerServiceImplObj(); 
				List<Product> productList=productSchedule.getProductList(sellerId);
				request.setAttribute("productList", productList);
//				for(Product product : productList ) {
//					System.out.println(product);
//				}
			}
			else {
				System.out.println("Error");
			}
		}
		request.getRequestDispatcher("/seller/scheduleAuction.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//doGet(request, response);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
		//String products=request.getParameter("products");
		int productId=Integer.parseInt(request.getParameter("products"));
		double minimumBidValue=Double.parseDouble(request.getParameter("minimumBidValue"));
		
		//parsing date in required format
		LocalDate sDate = LocalDate.parse(request.getParameter("startDate"));
		LocalDate eDate = LocalDate.parse(request.getParameter("endDate"));
	
		System.out.println(productId);
		System.out.println(minimumBidValue);
//		System.out.println(request.getParameter("startDate"));
//		System.out.println(request.getParameter("endDate"));
		System.out.println(sDate);
		System.out.println(eDate);
			
		System.out.println("Obj Created");
		
		ObjectFactory objectFactory = new ObjectFactory();
		IProductSchedulerService productSchedule = objectFactory.createProductSchedulerServiceImplObj(); 
	
		ProductForAuction productAuction=new ProductForAuction();
		productAuction.setProductId(productId);
		productAuction.setMinBidValue(minimumBidValue);
		productAuction.setBidStartDate(sDate.now());
		productAuction.setBidEndDate(eDate);
		productAuction.setBidStatus(1);
		
		response.setStatus(productSchedule.scheduleAuction(productAuction) == 1 ? 200 : 999);
	}
	
	//For background task Scheduling
	public static int getTime(Timestamp bidStartDate) {
	 	int hour = LocalDateTime.now().getHour(); 
	 	int minute = LocalDateTime.now().getMinute();
	 	int day = LocalDateTime.now().getDayOfMonth();
	 	int month = LocalDateTime.now().getMonthValue();
	 	int year = LocalDateTime.now().getYear();
	 	
	 	LocalDateTime productDate = bidStartDate.toLocalDateTime();
	 //	LocalDateTime l = bidStartDate.toLocalDateTime();
	 	int dayProduct = productDate.getDayOfMonth();
	 	int monthProduct = productDate.getMonthValue();
	 	int yearProduct = productDate.getYear();
	 	int hourProduct = productDate.getHour();
	 	int minuteProduct = productDate.getMinute();
	    System.out.println("Product date is: "+dayProduct+"::"+monthProduct+"::"+yearProduct+" "+hourProduct+"::"+minuteProduct);  
	    System.out.println("Today date: "+day+"::"+month+"::"+year+" "+hour+"::"+minute);  
	
	    if(day==dayProduct && month==monthProduct && year==yearProduct && hour==hourProduct && minute==minuteProduct) {
	    	return 1;
	    }
	    else
	    	return 0;
	}

}
