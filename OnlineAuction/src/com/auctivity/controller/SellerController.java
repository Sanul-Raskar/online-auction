package com.auctivity.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.MultipartConfigElement;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.derby.tools.sysinfo;
import org.apache.tomcat.util.codec.binary.StringUtils;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.auctivity.dao.SellerDao;
import com.auctivity.dao.SellerDaoImpl;
import com.auctivity.exceptions.CustomException;
import com.auctivity.model.Product;

/**
 * Servlet implementation class SellerAddProduct
 */

@WebServlet({ "/SellerAddProduct", "/addProduct" })
@MultipartConfig(location="/tmp", fileSizeThreshold=1024*1024, 
maxFileSize=1024*1024*5, maxRequestSize=1024*1024*5*5)

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
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());

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
		
		String BASE_DIR = "/Users/sanul/Documents/";
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());

		List<FileItem> items = new ServletFileUpload(new DiskFileItemFactory())
				.parseRequest(new ServletRequestContext(request));
		HashMap<String, String> data = new HashMap<String, String>();

		System.out.println(timestamp);
		System.out.println(BASE_DIR);
		try {

			for (FileItem item : items) {
				System.out.println(item);
				if (item.isFormField()) {
					// Normal form fields
					String fieldName = item.getFieldName();
					String fieldValue = item.getString();
					System.out.println("" + fieldName + " : " + fieldValue);
					System.out.println("Hello from if");
					data.put(fieldName, fieldValue);
				} else {

					Part filePart = request.getPart("file");
					System.out.println("filepart: "+filePart.toString());

					String fileName = null;
					for (Part part : request.getParts()) {
						System.out.println("hello");
						fileName = getFileName(part);
						String uploadLocation = BASE_DIR + timestamp.getTime() + fileName;
						System.out.println(uploadLocation);
						part.write(uploadLocation);
						System.out.println("file uploaded successfully");
					}
				}
			}

		} catch (Exception e) {
			System.out.println(e);
		}


//		Product product = new Product(201, data.get("productName"), "Electronics", data.get("productDescription"),
//				Double.parseDouble(data.get("actualPrice")), Integer.parseInt(data.get("quantity")),
//				"/sample/path/logo.jpg", 100);
		// System.out.println(product);

		/*
		 * SellerDao sellerImplobj = new SellerDaoImpl();
		 * 
		 * try { sellerImplobj.addProduct(product); } catch (CustomException e) {
		 * 
		 * e.printStackTrace(); }
		 */

	}

	private String getFileName(final Part part) {
	    final String partHeader = part.getHeader("content-disposition");
	 
	    for (String content : part.getHeader("content-disposition").split(";")) {
	        if (content.trim().startsWith("filename")) {
	            return content.substring(
	                    content.indexOf('=') + 1).trim().replace("\"", "");
	        }
	    }
	    return null;
	}

}
