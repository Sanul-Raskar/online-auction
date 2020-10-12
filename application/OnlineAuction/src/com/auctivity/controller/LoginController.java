package com.auctivity.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.auctivity.exceptions.UserNotFoundException;
import com.auctivity.model.beans.User;
import com.auctivity.model.service.IUserService;
import com.auctivity.model.service.UserServiceImpl;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    IUserService userService = new UserServiceImpl();
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Get the user session
		HttpSession session = request.getSession();
		User userInSession = (User)session.getAttribute("user");
		
		/**
		 * If the user session type is 1 then it is Seller, if it is 0 then it is Buyer
		 */
		if(userInSession==null)
			request.getRequestDispatcher("/accounts/login.jsp").forward(request, response);
		else {
			if(userInSession.getUserType() == 1) {
				System.out.println("In seller:"+(User)session.getAttribute("user"));
				response.sendRedirect("sellerhistory");
				//request.getRequestDispatcher("sellerhistory").forward(request, response);
			}
			else if(userInSession.getUserType()==0) {
				System.out.println("In buyer:"+(User)session.getAttribute("user"));
				response.sendRedirect("home");
				//request.getRequestDispatcher("home").forward(request, response);
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
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		HttpSession session=request.getSession();  
		User sessionuser = (User) session.getAttribute("user");
		if(sessionuser==null) {
			User temp;
			try {
				temp = userService.getUser(username, password);
				if(temp!=null){
					session.setAttribute("user", temp);
					session.setAttribute("isUserAuthenticated", true);
					session.setAttribute("userType", temp.getUserType());
					if(temp.getUserType() == 1) {
						System.out.println("In seller:"+(User)session.getAttribute("user"));
						response.setStatus(200);
						//response.sendRedirect("sellerhistory");
						//request.getRequestDispatcher("sellerhistory").forward(request, response);
					}
					else if(temp.getUserType()==0) {
						System.out.println("In buyer:"+(User)session.getAttribute("user"));
						response.setStatus(200);
						//response.sendRedirect("home");
						//request.getRequestDispatcher("home").forward(request, response);
						//response.sendRedirect(request.getContextPath() + "/buyer/BuyerProfile.jsp");
					}
					else {
						response.setStatus(999);
						System.out.println("something error from loginservlet");
					}
				}
			} catch (UserNotFoundException e) {
				//USER NOT FOUND
				response.setStatus(999);
				System.out.println("Exception::"+e.getMessage());
				
				//response.sendRedirect("home");
				
			}
			//System.out.println("Taking user object::"+temp);
			
		}
		else {
			System.out.println("session is not null");
//			User userInSession = (User) session.getAttribute("user");
//			if(userInSession.getUserType()==1) {
//				System.out.println("In seller:"+userInSession);
//				request.getRequestDispatcher("/seller/SellerProfile.jsp").forward(request, response);
//			}
//			else if(userInSession.getUserType()==0) {
//				System.out.println("In buyer:"+userInSession);
//
//				request.getRequestDispatcher("/buyer/BuyerProfile.jsp").forward(request, response);
//				//response.sendRedirect(request.getContextPath() + "/buyer/BuyerProfile.jsp");
//			}
		}
	}

}
