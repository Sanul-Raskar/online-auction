<!DOCTYPE html>
<%@page import="com.auctivity.model.beans.Category"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList" %>
<%@page import="com.auctivity.model.beans.ProductForAuction"%>
<%@page import="com.auctivity.model.beans.User"%>
<html>
<head>
<meta charset="UTF-8">
<title>Home | Online Auction</title>
<!-- Including the CSS files -->
<style><%@include file="./resources/css/style.css"%></style>
<style><%@include file="./resources/css/home.css"%></style>
</head>
<body>
	<%@ include file="./common/navbar.jsp"%>
	<br /><br/>
	
	<!-- Displaying the products from the database -->
	<% List<ProductForAuction> products = (ArrayList<ProductForAuction>)session.getAttribute("products");
	 List<Category> categories = (ArrayList<Category>)session.getAttribute("categories");

	boolean showBidInput = false;	
	User user = (User)session.getAttribute("user");
		if(user != null){
			showBidInput = true;
		}
	%>

	<div class="customizeWrapper">
		<div style="margin:6px;">
			<label for="sortProducts">Sort products by:</label>
			<select class="inputField" name="sortProduct" id="sortProducts">
				<option value="" disabled">Select option to sort</option>
				<option value="name">Name</option>
				<option value="category">Category</option>
				<option value="bidEndDate">Bid End Date</option>
			</select>
		</div>
		<div style="margin:6px;">
			<label for="filterCategory">Filter products by category:</label>
			<select class="inputField" name="filterCategory" id="filterCategory">
			<option value="" disabled">Select Category</option>
			<%for(Category category: categories){ %>
				<option value="<%=category.getCategoryName()%>"><%=category.getCategoryName()%></option>
			<%} %>
			</select>
		</div>
	</div>
	
	
	<!-- Displaying the products from the database -->
	<div class="container">
		<div id="productsContainer" class="grid-row">
		<%for(ProductForAuction product: products){ %>
			<div id="product<%=product.getProductId()%>" class="card">
			  <img id="productImg<%=product.getProductId()%>" src="<%=product.getProductImage()%>" class="productImg">
		      <h2 id="productName<%=product.getProductId()%>" class="text-center"><%= product.getProductName()%></h2>
		      <p id="productCategory<%=product.getProductId()%>"><span style="font-weight:bold">Category:</span> <%=product.getProductCategory()%></p>
		      <p id="productDescription<%=product.getProductId()%>"><span style="font-weight:bold;word-wrap: break-word;">Description:</span> <%=product.getProductDescription() %></p>
		      <p id="productQuantity<%=product.getProductId()%>"><span style="font-weight:bold">Quantity:</span> <%=product.getProductQuantity() %></p>
		      <p id="productPrice<%=product.getProductId()%>"><span style="font-weight:bold">Actual Price:</span>&nbsp;Rs. <%=product.getProductPrice() %></p>
		      <p id="minBidAmount<%=product.getProductId()%>"><span style="font-weight:bold">Min Bid Amount:</span>&nbsp;Rs. <%=product.getMinBidValue() %></p>
		      <p id="startTime<%=product.getProductId()%>"><span style="font-weight:bold">Bid Start Time:</span> <%=product.getBidStartDate() %></p>
		      <p id="endTime<%=product.getProductId()%>"><span style="font-weight:bold">Bid End Time:</span> <%=product.getBidEndDate() %></p>
		    
		      <%-- <%if(product.getBid().getBidStatus() == 0){ %>
		      	<p id="bidStatus<%=product.getProductId()%>"><span style="font-weight:bold">Status:</span>OPEN</p>
		      <%}else if(product.getBid().getBidStatus() == 1){ %>
		      	<p id="bidStatus<%=product.getProductId()%>"><span style="font-weight:bold">Status:</span>LOST</p>
		      <%}else if(product.getBid().getBidStatus() == 3){ %>
		      	<p id="bidStatus<%=product.getProductId()%>"><span style="font-weight:bold">Status:</span>WON</p>
		      <%}else if(product.getBid().getBidStatus() == 4){ %>
		      	<p id="bidStatus<%=product.getProductId()%>"><span style="font-weight:bold">Status:</span>PLACED</p>
		      <%} %> --%>
		      
		      <%-- <% if(showBidInput && product.getBid().getBidStatus() == 0){ %> 
		      	<form id="bidForm<%=product.getProductId()%>" method="post" action="/OnlineAuction/home" onsubmit="return validateBidValue(<%=product.getProductId()%>);">
		      	<div class="bidForm">
		      		<input id="bidValue<%=product.getProductId()%>" class="" type="number" name="bidValue" required/>
		      		<input hidden name="productId" value="<%=product.getProductId()%>" type="text"/>
		      		<input hidden name="status" value="<%=product.getBidStatus() %>"/>
		      		<button id="bidButton<%=product.getProductId()%>" class="bid-button" type="submit">Make Bid</button>
		      	</div>
		      	</form>
		      <%} %> --%>
		      
		      	<p id="bidStatus<%=product.getProductId()%>"><span style="font-weight:bold">Status:</span>OPEN</p>
		      	<form id="bidForm<%=product.getProductId()%>" method="post" action="/OnlineAuction/home" onsubmit="return validateBidValue(<%=product.getProductId()%>);">
		      	<div class="bidForm">
		      		<input id="bidValue<%=product.getProductId()%>" class="" type="number" name="bidValue" required/>
		      		<input hidden name="productId" value="<%=product.getProductId()%>" type="text"/>
		      		<input hidden name="status" value="<%=product.getBidStatus() %>"/>
		      		<button id="bidButton<%=product.getProductId()%>" class="bid-button" type="submit">Make Bid</button>
		      	</div>
		      	</form>
		      
		      <br/>
			</div>
		<%} %>
		</div>
	</div>
	<br />
	
	<!-- Including the footer and Javascript files -->
	<%@ include file="./common/footer.jsp"%>
	<script> <%@include file="./resources/js/index.js"%></script>
	<script> <%@include file="./resources/js/home.js"%></script>

</body>
</html>