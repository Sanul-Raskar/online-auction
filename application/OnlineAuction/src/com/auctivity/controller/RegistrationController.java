package com.auctivity.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.auctivity.model.beans.User;
import com.auctivity.model.dao.IUserDao;
import com.auctivity.model.dao.UserDaoImpl;
import com.auctivity.model.service.IUserService;
import com.auctivity.model.service.UserServiceImpl;
import com.auctivity.utility.PasswordEncrypter;
import com.auctivity.utility.ObjectFactory;

/**
 * Servlet implementation class RegistrationController
 */
@WebServlet("/register")
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistrationController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/accounts/registration.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String mobile = request.getParameter("mobile");
		// parsing date in required format
		LocalDate dob = LocalDate.parse(request.getParameter("dob"));
		// java.sql.Date sDate = java.sql.Date.valueOf(formatter.format(dob));

		String password = request.getParameter("password");
		String address = request.getParameter("address");
		int usertype = Integer.valueOf(request.getParameter("userType"));
		double walletAmount = Double.valueOf(request.getParameter("walletAmount"));

		ObjectFactory objectFactory = new ObjectFactory();
		IUserService userService = objectFactory.createUserServiceImplObj();

		User user = new User();
		user.setName(name);
		user.setUsername(username.toLowerCase());
		user.setEmail(email.toLowerCase());
		user.setPhonenumber(mobile);
		user.setDob(dob);
		user.setPassword(PasswordEncrypter.getSHA(password));
		user.setAddress(address);
		user.setUserType(usertype);
		user.setWallet(walletAmount);
		response.setStatus(userService.addUser(user) == 1 ? 200 : 999);

	}

}
