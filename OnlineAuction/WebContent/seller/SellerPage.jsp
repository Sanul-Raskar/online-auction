 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
    
    <%@page import="com.auctivity.model.Product"%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
   
 
<!DOCTYPE html>
<html>
<head>
<title>Seller Page</title>
<link rel="stylesheet" href="../resources/css/style.css" />
<link rel="stylesheet" href="../resources/css/SellerPage.css" />


</head>
<body>
 
	<%@ include file="../Common/navbar.jsp"%>  
	 
	<%
		 	 List<Product> products = new ArrayList<Product>();
			products = (ArrayList<Product> )request.getAttribute("products");
			
			for(Product p:products){
				
				out.println("Id" + p.getProductId());
				out.println("Name" + p.getProductName());
			}

		%>
 
		  
	<div class="row">
		
		
	
		<div class="card">
			<div class="container">
				<img src="auctivity-01.png" alt="Product image"
					style="width: 130px; height: 130px;">
				<h2>
					<b>Diamond Ring</b>
				</h2>
				<p>Highest Current bid: $2000</p>
				<p>Number of bidders: 500</p>
				<p>Bid end date: 05/10/2020</p>
			</div>
		</div>

		<div class="card2">
			<div class="container">
				<img src="auctivity-01.png" alt="Product image"
					style="width: 130px; height: 130px;">
				<h2>
					<b>Diamond Ring</b>
				</h2>
				<p>Highest Current bid: $2000</p>
				<p>Number of bidders: 500</p>
				<p>Bid end date: 05/10/2020</p>
			</div>
		</div>


		<div class="card3">
			<div class="container">
				<img src="auctivity-01.png" alt="Product image"
					style="width: 130px; height: 130px;">
				<h2>
					<b>Diamond Ring</b>
				</h2>
				<p>Highest Current bid: $2000</p>
				<p>Number of bidders: 500</p>
				<p>Bid end date: 05/10/2020</p>
			</div>
		</div>
	</div>
	<!-- row end -->

	<div class="row2">
		<div class="card">
			<div class="container">
				<img src="auctivity-01.png" alt="Product image"
					style="width: 130px; height: 130px;">
				<h2>
					<b>Diamond Ring</b>
				</h2>
				<p>Highest Current bid: $2000</p>
				<p>Number of bidders: 500</p>
				<p>Bid end date: 05/10/2020</p>
			</div>
		</div>

		<div class="card2">
			<div class="container">
				<img src="auctivity-01.png" alt="Product image"
					style="width: 130px; height: 130px;">
				<h2>
					<b>Diamond Ring</b>
				</h2>
				<p>Highest Current bid: $2000</p>
				<p>Number of bidders: 500</p>
				<p>Bid end date: 05/10/2020</p>
			</div>
		</div>


		<div class="card3">
			<div class="container">
				<img src="auctivity-01.png" alt="Product image"
					style="width: 130px; height: 130px;">
				<h2>
					<b>Diamond Ring</b>
				</h2>
				<p>Highest Current bid: $2000</p>
				<p>Number of bidders: 500</p>
				<p>Bid end date: 05/10/2020</p>
			</div>
		</div>
	</div>
	<!-- row end -->
	<%@ include file="../Common/footer.jsp"%>
</body>
</html>