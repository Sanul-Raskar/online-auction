//This controller used for Adding product from seller side
package com.auctivity.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

import com.auctivity.model.beans.Category;
import com.auctivity.model.beans.Product;
import com.auctivity.model.beans.User;
import com.auctivity.model.service.IProductService;
import com.auctivity.utility.ObjectFactory;

/**
 * Servlet implementation class AddProductController
 */
@WebServlet("/addproduct")
public class AddProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddProductController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		User userInSession = (User) session.getAttribute("user");

		if (userInSession == null) {
			request.getRequestDispatcher("/accounts/login.jsp").forward(request, response);
		} else {

			if (userInSession.getUserType() == 1) {
				ObjectFactory objectFactory = new ObjectFactory();
				IProductService iProductService = objectFactory.createProductServiceImplObj();
				List<Category> catList = iProductService.getCategoryList();
				request.setAttribute("categoryList", catList);
				for (Category category : catList) {
					System.out.println(category);
				}
				request.getRequestDispatcher("/seller/addProduct.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("/error/forbiddenAccessError.jsp").forward(request, response);
			}

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		User userInSession = (User) session.getAttribute("user");

		if (userInSession == null) {
			request.getRequestDispatcher("/accounts/login.jsp").forward(request, response);
		} else {

			if (userInSession.getUserType() == 1) {
				String BASE_DIR = "/Users/sanul/Documents/uploads/";
				String DEFAULT_FILENAME = "./resources/img/logo.jpg";
				boolean filePresent = false;
				String currentTime = Long.toString((int) (new Date().getTime() / 10000));
				HashMap<String, String> data = new HashMap<String, String>();

				if (ServletFileUpload.isMultipartContent(request)) {
					DiskFileItemFactory factory = new DiskFileItemFactory();
					ServletFileUpload upload = new ServletFileUpload(factory);
					List<FileItem> formItems = upload.parseRequest(new ServletRequestContext(request));

					if (formItems != null && formItems.size() > 0) {
						for (FileItem item : formItems) {
							if (!item.isFormField()) {
								// File Input
								String fileName = new File(item.getName()).getName();
								System.out.println("Filename :" + fileName);
								fileName = fileName.replaceAll("\\s+", "");
								fileName = currentTime + "-" + fileName;
								String filePath = BASE_DIR + fileName;
								File storeFile = new File(filePath);
								try {
									item.write(storeFile);
									data.put("Image", fileName);
									System.out.println("File: " + fileName + " has uploaded successfully!");

								} catch (Exception e) {
									e.printStackTrace();
								}

								filePresent = true;
							} else {
								// Other than file form elements
								String fieldName = item.getFieldName();
								String fieldValue = item.getString();
								System.out.println("" + fieldName + " : " + fieldValue);
								data.put(fieldName, fieldValue);
							}
						}
					}

					if (!filePresent) {
						data.put("Image", DEFAULT_FILENAME);
					}
				}

				Product product = new Product(data.get("productName"), data.get("category"),
						data.get("productDescription"), Double.parseDouble(data.get("actualPrice")),
						Integer.parseInt(data.get("quantity")), data.get("Image"), userInSession.getUserid());
				System.out.println(product);
				ObjectFactory objectFactory = new ObjectFactory();
				IProductService iProductService = objectFactory.createProductServiceImplObj();
				int status = iProductService.addProducts(product);
				if (status > 0) {
					System.out.println("Product Added");
					response.setStatus(200);
				} else {
					System.out.println("HTTP 501 Not Implemented: Product not added/");
					response.setStatus(501);
				}
			} else {
				request.getRequestDispatcher("/error/forbiddenAccessError.jsp").forward(request, response);
			}
		}

	}

}