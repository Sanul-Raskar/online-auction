<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
    <%@page import="com.auctivity.model.beans.Product"%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<%@page import="com.auctivity.model.beans.ProductForAuction"%>
<%@page import="com.auctivity.model.beans.User"%>
       
<!DOCTYPE html>
<html>
<head>
<title>Buyer History</title>
<style><%@include file="../resources/css/style.css"%></style>
<style><%@include file="../resources/css/seller/SellerPage.css"%></style>
<style><%@include file="../resources/css/home.css"%></style>

</head>
<body>
	<%@ include file="../common/navbar.jsp"%>
	<script src="../resources/js/buyerPagePurchasedProducts1.js"></script>
	
	<%
			List<Product> products = new ArrayList<Product>();
			products = (ArrayList<Product> )request.getAttribute("products");
			boolean emptyProductList = false;
			if(products == null || products.isEmpty()){
				emptyProductList=true;
			}
	%>
			
			<h1 style="text-align:center;">Buyer Products History</h1>
				<% if(emptyProductList){ %>
					<h1 style ="text-align:center;margin-top:100px;">No items available to display</h1>
					<div style="height: 80vh;"></div>
				<%}else{ %>
			<div class="container">
			<div id="productsContainer" class="grid-row">
			<%for(Product product: products){ %>
				<div class="card">
			      <h2 class="text-center"><%= product.getProductName()%></h2>
			      <p><span style="font-weight:bold">Price:</span>&nbsp;Rs. <%=product.getProductPrice() %></p>
			      <p><span style="font-weight:bold">Category:</span> <%=product.getProductCategory() %></p>
			      <p><span style="font-weight:bold">Quantity:</span> <%=product.getProductQuantity() %></p>
			      <p><span style="font-weight:bold">Seller ID:</span><%=product.getProductSellerId()%></p>
			      <br/>
				</div>
			<%} %>
			</div>
		</div>
	<%} %>
	
	<div style="height: 100px"></div>
			
	<%@ include file="../common/footer.jsp"%>
	<script> <%@include file="../resources/js/index.js"%></script>
	

</body>
</html>