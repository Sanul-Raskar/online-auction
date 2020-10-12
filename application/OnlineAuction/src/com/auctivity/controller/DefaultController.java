package com.auctivity.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.derby.tools.sysinfo;
import com.auctivity.model.beans.Bid;
import com.auctivity.model.beans.Category;
import com.auctivity.model.beans.ProductForAuction;
import com.auctivity.model.beans.User;
import com.auctivity.model.beans.ProductForAuction.status;
import com.auctivity.model.service.IProductService;
import com.auctivity.utility.MyTimerTask;
import com.auctivity.utility.ObjectFactory;

/**
 * Servlet implementation class DefaultController
 */
@WebServlet("/home")
public class DefaultController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	//Initialising scheduler for start schedule
	@Override
	public void init() throws ServletException {
		MyTimerTask.scheduleAcution();
	}
 
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DefaultController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User userInSession = (User) session.getAttribute("user");
		if (userInSession == null) {
			// response.sendRedirect("login");
			System.out.println("session null");
			ObjectFactory objectFactory = new ObjectFactory();
			IProductService productService = objectFactory.createProductServiceImplObj();
			List<ProductForAuction> test = productService.getBidProducts();
			for (ProductForAuction t : test) {
				System.out.println(t); 
			}
			session.setAttribute("products", test);
			
			List<Category> categories = productService.getCategoryList();
			session.setAttribute("categories", categories);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		} else {
			if (userInSession.getUserType() == 1) {
				request.getRequestDispatcher("sellerhistory").forward(request, response);
			} else if (userInSession.getUserType() == 0) {
				System.out.println("In buyer:" + (User) session.getAttribute("user"));
				ObjectFactory objectFactory = new ObjectFactory();
				IProductService productService = objectFactory.createProductServiceImplObj();
				List<ProductForAuction> test = productService.getBidProducts();
				for (ProductForAuction t : test) {
					System.out.println(t);
				}
				session.setAttribute("products", test);
				
				List<Category> categories = productService.getCategoryList();
				session.setAttribute("categories", categories);
				
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			} else {
				System.out.println("something error from loginservlet");
			}
		}

		// request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		User userInSession = (User) session.getAttribute("user");
		if (userInSession == null)
			request.getRequestDispatcher("/accounts/login.jsp").forward(request, response);
		else {

			int bidderId = userInSession.getUserid();
			// int bidderId = Integer.valueOf(request.getParameter(""));
			int bidProductId = Integer.valueOf(request.getParameter("productId"));
			double bidValue = Double.valueOf(request.getParameter("bidValue"));
			int status = Integer.valueOf(request.getParameter("status"));

			ObjectFactory objectFactory = new ObjectFactory();
			IProductService productService = objectFactory.createProductServiceImplObj();
			
			Bid bid = new Bid();
			bid.setBidProductID(bidProductId);
			bid.setBidderID(bidderId);
			bid.setBidValue(bidValue);
			productService.placeBid(bid);
			response.sendRedirect("home");

		}
	}

}
