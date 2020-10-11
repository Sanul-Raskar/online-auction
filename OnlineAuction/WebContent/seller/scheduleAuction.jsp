<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Schedule Auction</title>
<style><%@include file="../resources/css/style.css"%></style>
<style><%@include file="../resources/css/seller/SellerPage.css"%></style>

</head>
<body>
	<%@ include file="../common/navbar.jsp"%>
	
	<div style="height:70px"></div>
	<div class="schedule-form">
		<a href="/OnlineAuction/sellerhistory">
			<button class="back">Back</button>
		</a>
		<form  id="scheduleAuctionForm" method="POST">
		
			<h2>Schedule An Auction</h2>
			<div>
			<select class="product-dropdown" name="products" required>
				<option value="" disabled selected hidden>Choose a product</option>
				<c:forEach items="${productList}" var="product">
       				 <option value="${product.productId}">${product.productName}</option>
    			</c:forEach>
			</select> 
			<p id="productsError" style="margin-top:4px;color:red"></p>
			</div>
			
			<div>
			<input class="bid-value" type="text" name="minimumBidValue" placeholder="Minimum Bid Value">
			<p id="minimumBidValueError" style="margin-top:4px;color:red"></p>
			</div>
			
			<div>
		    <input class="start-date" type="date" name="startDate"> 
		    <p id="startDateError" style="margin-top:4px;color:red"></p>
		    </div>
		    
		    <div>
		    <input type="date" class="end-date" name="endDate"> 
		    <p id="endDateError" style="margin-top:4px;color:red"></p>
		    </div>
		    
		    <div>
		    <button class="submit" type="submit">Schedule Auction</button> 
		    </div>
		    
		</form>
	</div>
	<br/><br/>
	<div style="height:150px"></div>
	<%@ include file="../common/footer.jsp"%>
	<script> <%@include file="../resources/js/index.js"%></script>
	<script> <%@include file="../resources/js/utility/inputValidation.js"%></script>
	<script> <%@include file="../resources/js/seller/scheduleAuction.js"%></script>
	
</body>
</html>