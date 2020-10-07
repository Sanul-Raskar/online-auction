package com.auctivity.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

import com.auctivity.dao.SellerDao;
import com.auctivity.dao.SellerDaoImpl;
import com.auctivity.exceptions.CustomException;
import com.auctivity.model.Product;

/**
 * Servlet implementation class SellerController
 */
@WebServlet("/addProduct")
@MultipartConfig
public class SellerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/*
	 * Creating object of @SellerDaoImpl
	 */
	SellerDaoImpl sellerDao = new SellerDaoImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SellerController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Product> products = new ArrayList<Product>();
		try {
			products = sellerDao.readSellerData();
			System.out.println(products + "\t");

		} catch (SQLException e) {
			e.printStackTrace();
		}

		request.setAttribute("products", products);
		request.getRequestDispatcher("/seller/SellerPage.jsp").include(request, response);

		for (Product p : products) {
			p.getProductName();
		}

		System.out.println("sysout in servlet");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String BASE_DIR = "/Users/sanul/Documents/uploads/";
		String currentTime = Long.toString((int) (new Date().getTime() / 10000));

		List<FileItem> items = new ServletFileUpload(new DiskFileItemFactory())
				.parseRequest(new ServletRequestContext(request));
		
		HashMap<String, String> data = new HashMap<String, String>();


		try {
			for (FileItem item : items) {
				if (item.isFormField()) {
					// Normal form fields
					String fieldName = item.getFieldName();
					String fieldValue = item.getString();
					System.out.println("" + fieldName + " : " + fieldValue);
					data.put(fieldName, fieldValue);
				} else {
					// Image file
					Part filePart = request.getPart("file");
					String fileName = filePart.getName();
					String imgName = fileName + currentTime;
					String uploadLocation = BASE_DIR + imgName;
					System.out.println("Upload location: "+uploadLocation);
					filePart.write(uploadLocation);
					System.out.println("file uploaded successfully");
					data.put("Image", imgName);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		Product product = new Product(201, data.get("productName"), "Electronics", data.get("productDescription"),
				Double.parseDouble(data.get("actualPrice")), Integer.parseInt(data.get("quantity")), data.get("Image"),
				100);
		System.out.println(product);

		SellerDao sellerImplobj = new SellerDaoImpl();

		try {
			sellerImplobj.addProduct(product);
		} catch (CustomException e) {

			e.printStackTrace();
		}

	}

}
