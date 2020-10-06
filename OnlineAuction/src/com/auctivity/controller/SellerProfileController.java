package com.auctivity.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.auctivity.dao.BuyerProfileDao;
import com.auctivity.dao.BuyerProfileDaoImpl;
import com.auctivity.dao.SellerProfileDao;
import com.auctivity.dao.SellerProfileDaoImpl;
import com.auctivity.model.User;

/**
 * Servlet implementation class SellerProfileController
 */
@WebServlet({ "/SellerProfileController", "/sellerProfile" })
public class SellerProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SellerProfileController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		SellerProfileDao dao = new SellerProfileDaoImpl();
		List<User> userList = dao.getUsers();
		//String temp=userList.toString();
		//response.getWriter().append(temp);
		request.setAttribute("users", userList);
		request.getRequestDispatcher("/seller/SellerProfile.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
