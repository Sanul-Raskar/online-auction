package com.auctivity.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.auctivity.dao.SellerDao;
import com.auctivity.dao.SellerDaoImpl;
import com.auctivity.exceptions.CustomException;
import com.auctivity.model.Product;

/**
 * Servlet implementation class SellerAddProduct
 */
@WebServlet({ "/SellerAddProduct", "/addProduct" })
public class SellerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SellerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	doGet(request, response);
		
		String productName = request.getParameter("productName");
		String productCategory = request.getParameter("category");
		String productDescription = request.getParameter("productDescription");
		int productPrice = Integer.parseInt(request.getParameter("actualPrice"));
		int productQuantity = Integer.parseInt(request.getParameter("quantity"));
		String productImage = request.getParameter("category");
		
		Product product = new Product(202,productName, productCategory, productDescription, productPrice, productQuantity, productImage, 101);	
		SellerDao object = new SellerDaoImpl();
		
		try {
			object.addProduct(product);
		} catch (CustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
