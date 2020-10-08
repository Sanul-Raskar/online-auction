package com.auctivity.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.auctivity.dao.BuyerDaoImpl;
import com.auctivity.exceptions.CustomException;
import com.auctivity.model.Product;


/**
 * Servlet implementation class BuyerController
 */
@WebServlet({ "/BuyerController", "/BC" })
public class BuyerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	BuyerDaoImpl bd = new BuyerDaoImpl();
	public BuyerController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @throws ServletException,IOException 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		
		
		List<Product> products = new ArrayList<Product>();
		try {
		products = bd.getProducts();
			System.out.println(products + "\t");
	
			 
		} catch (CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			request.setAttribute("products", products);
		 request.getRequestDispatcher("buyer/purchasedProducts.jsp").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
