package com.auctivity.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.auctivity.model.beans.ProductForAuction;
import com.auctivity.model.beans.User;
import com.auctivity.model.service.IProductService;
import com.auctivity.utility.ObjectFactory;

/**
 * Servlet implementation class SellerHistoryController
 */
@WebServlet("/sellerhistory")
public class SellerHistoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SellerHistoryController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User userInSession = (User)session.getAttribute("user");
		if(userInSession==null) {
			request.getRequestDispatcher("/accounts/login.jsp").forward(request, response);
		}
		else {
			if(userInSession.getUserType() == 0) {
				System.out.println("In Buyer:"+(User)session.getAttribute("user"));
				request.getRequestDispatcher("/error/forbiddenAccessError.jsp").forward(request, response);
			}
			else if(userInSession.getUserType()==1) {
				System.out.println("In Seller:"+(User)session.getAttribute("user"));
				int uid=userInSession.getUserid();
				ObjectFactory objectFactory = new ObjectFactory();
				IProductService productService = objectFactory.createProductServiceImplObj();
				List<ProductForAuction> test=productService.getSellerProducts(uid);
				for(ProductForAuction t : test ) {
					System.out.println(t);
				}
				
				request.setAttribute("products",test);
				request.getRequestDispatcher("/seller/sellerHistory.jsp").forward(request, response);
			}
			else {
				System.out.println("something error from loginservlet");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
