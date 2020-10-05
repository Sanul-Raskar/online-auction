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
import com.auctivity.model.User;

/**
 * Servlet implementation class BuyerProfileController
 */
@WebServlet({ "/BuyerProfileController", "/buyerProfile", "/buyerHome" })
public class BuyerProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyerProfileController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		BuyerProfileDao dao = new BuyerProfileDaoImpl();
		List<User> userList = dao.getUsers();
		//String temp=userList.toString();
		//response.getWriter().append(temp);
		request.setAttribute("users", userList);
		request.getRequestDispatcher("/buyer/BuyerProfile.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
