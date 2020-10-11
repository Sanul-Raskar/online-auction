<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
    <%@page import="com.auctivity.model.beans.Product"%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
       
<!DOCTYPE html>
<html>
<head>
<title>Buyer History</title>
<style><%@include file="../resources/css/style.css"%></style>
<style><%@include file="../resources/css/seller/SellerPage.css"%></style>
</head>
<body>
	<%@ include file="../common/navbar.jsp"%>
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
	

	
	<%@ include file="../common/footer.jsp"%>
	<script> <%@include file="../resources/js/index.js"%></script>
	

</body>
</html>