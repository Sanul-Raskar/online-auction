<%@page import="com.auctivity.model.beans.ProductForAuction.status"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList" %>
<%@page import="com.auctivity.model.beans.ProductForAuction"%>
<%@page import="com.auctivity.model.beans.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Seller History</title>
<style><%@include file="../resources/css/style.css"%></style>
<style><%@include file="../resources/css/home.css"%></style>

</head>
<body>
	<%@ include file="../common/navbar.jsp"%>
	<% List<ProductForAuction> products = (ArrayList<ProductForAuction>)session.getAttribute("products");
		boolean emptyProductList = false;
		if(products == null || products.isEmpty()){
			emptyProductList=true;
		}
		User user = (User)session.getAttribute("user");
	%>
	
	<h1 style="text-align:center;">Seller Products History</h1>
	<% if(emptyProductList){ %>
		<h1 style ="text-align:center;margin-top:100px;">No items available to display</h1>
		<div style="height: 80vh;"></div>
	<%}else{ %>
		<div class="container">
			<div id="productsContainer" class="grid-row">
			<%for(ProductForAuction product: products){ %>
				<div class="card">
				  <img src="<%=product.getProductImage()%>" class="productImg">
			      <h2 class="text-center"><%= product.getProductName()%></h2>
			      <p><span style="font-weight:bold">Sold Price:</span>&nbsp;Rs. <%=product.getSoldPrice() %></p>
			      <p><span style="font-weight:bold">Bid Start Time:</span> <%=product.getBidStartDate() %></p>
			      <p><span style="font-weight:bold">Bid End Time:</span> <%=product.getBidEndDate() %></p>
			      <%int bidStat = product.getBidStatus();
			      	status bidstatus = status.valueOf(bidStat);
			      %>
			      <p><span style="font-weight:bold">Status:</span><%=bidstatus%></p>
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