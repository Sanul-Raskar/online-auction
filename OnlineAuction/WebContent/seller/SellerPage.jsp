 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%@page import="com.auctivity.model.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
   
 
<!DOCTYPE html>
<html>
<head>
<title>Seller Page</title>
<style><%@include file="../resources/css/style.css"%></style>
<style><%@include file="../resources/css/SellerPage.css"%></style>

</head>
<body>
 
	<%@ include file="../Common/navbar.jsp"%>  
	 
	<%
		 	 /*  List<Product> products1 = new ArrayList<Product>();
			products = (ArrayList<Product> )request.getAttribute("products");
			
			for(Product p:products){
				
				out.println("Id" + p.getProductId());
				out.println("Name" + p.getProductName());
			} */

			%>	
			
			<%
			 List<Product> products = new ArrayList<Product>();
			products = (ArrayList<Product> )request.getAttribute("products");
			for(Product p:products){
			%>
			<div class="card">
				<div class="container">
				 	
					 <%= p.getProductName() %>
					 <%= p.getProductPrice() %>
				 
				</div>
			
			</div>
		<%} %>
		
		
 	<%-- <c:forEach items="${products}" var="product" >
            
          <div class="card">
			<div class="container">
				<img src="auctivity-01.png" alt="Product image"
					style="width: 130px; height: 130px;">
				<h2>
					<b>${product.productName}</b>
				</h2>
				<p>${product.productPrice}</p>
				<!-- <p>Number of bidders: 500</p>
				<p>Bid end date: 05/10/2020</p> -->
			</div>
		</div>
		
       </c:forEach> --%>
		  
	<div class="row">
		
		
	<%-- <%for ( fontSize = 1; fontSize <= 3; fontSize++){ %>
         <font color = "green" size = "<%= fontSize %>">
            JSP Tutorial
         </font><br />
      <%}%> --%>
	
	
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
		<script> <%@include file="../resources/js/index.js"%></script>
	
</body>
</html>