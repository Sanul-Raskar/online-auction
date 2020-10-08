package com.auctivity.controller;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet( {"/registration" })
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */ 
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			int status = 0;	
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String username = request.getParameter("username");
			String mobile = request.getParameter("mobile");
			//parsing date in required format
			LocalDate dob = LocalDate.parse(request.getParameter("dob"));
			java.sql.Date sDate = java.sql.Date.valueOf(formatter.format(dob));
			System.out.println("request.getParameter(\"dob\"):"+dob);
			System.out.println("sDate:"+sDate);

			String password = request.getParameter("password");
			String address = request.getParameter("address");
			String usertype = request.getParameter("userType");
			
			System.out.println(""+name+" "+email+" "+" "+username+" "+mobile+" "+dob+" "+password+" "+address+" "+usertype);
			
			int type;
			if(usertype.equals("buyer"))
				{
				 type=0;
				}
			else {
				type = 1;
			}
			int walletamount = Integer.parseInt(request.getParameter("walletAmount"));
				//Connection conn = ConnectionProvider.getConnection();
				//FileInputStream fis = new FileInputStream("/User/sanul/github/OnlineAuction/WebContent/WEB-INF/properties/queries.properties");
				//Properties props = new Properties();
				//props.load(fis);
			Connection conn = GetConnection.getConnectionId();	
			PreparedStatement ps = conn.prepareStatement("insert into OnlineAuctionDB.Usertable (Name,dob,email,phonenumber,username,password,address,user_type,wallet) values (?,?,?,?,?,?,?,?,?)");
				ps.setString(1, name);
				ps.setDate(2, sDate);
				ps.setString(3, email);
				ps.setString(4, mobile);
				ps.setString(5, username);
				ps.setString(6, password);
				ps.setString(7, address);
				ps.setInt(8, type);
				ps.setDouble(9, walletamount);
				status = ps.executeUpdate();
				response.getWriter().println("Database entered with status :" + status);
				
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
