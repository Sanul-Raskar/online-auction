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
 * Servlet implementation class DefaultController
 */
@WebServlet("/home")
public class DefaultController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DefaultController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*HttpSession session = request.getSession();
		User userInSession = (User)session.getAttribute("user");
		if(userInSession==null)
			request.getRequestDispatcher("/accounts/login.jsp").forward(request, response);
		else {
			if(userInSession.getUserType() == 1) {
				//request.getRequestDispatcher("sellerhistory").forward(request, response);
			}
			else if(userInSession.getUserType()==0) {
				System.out.println("In buyer:"+(User)session.getAttribute("user"));
				ObjectFactory objectFactory = new ObjectFactory();
				IProductService productService = objectFactory.createProductServiceImplObj();
				List<ProductForAuction> test=productService.getBidProducts();
				for(ProductForAuction t : test ) {
					System.out.println(t);
				}
				//response.sendRedirect("home");
				//request.getRequestDispatcher("home").forward(request, response);
			}
			else {
				System.out.println("something error from loginservlet");
			}
		}
		 */
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
