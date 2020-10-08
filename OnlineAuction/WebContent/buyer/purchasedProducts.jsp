<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
    <%@page import="com.auctivity.model.Product"%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
       
<!DOCTYPE html>
<html>
<head>
<title>Online Auction</title>
<style><%@include file="../resources/css/style.css"%></style>
<style><%@include file="../resources/css/SellerPage.css"%></style>
</head>
<body>
	<%@ include file="../Common/navbar.jsp"%>
	<script src="../resources/js/buyerPagePurchasedProducts1.js"></script>
	
	<%
			 List<Product> products = new ArrayList<Product>();
			products = (ArrayList<Product> )request.getAttribute("products");
			for(Product p:products){
			%>
			<div class="card">
				<div class="container">
				 	
					 <%= p.getProductName() %>
					 <%= p.getProductPrice() %>
					 <%= p.getProductCategory() %>
					 <%= p.getProductQuantity() %>
					 <%= p.getProductSellerId() %>
				 	</div>
				</div>
			
			</div>
		<%} %>
	

	
	<%@ include file="../Common/footer.jsp"%>
	<script> <%@include file="../resources/js/index.js"%></script>
	

</body>
</html>