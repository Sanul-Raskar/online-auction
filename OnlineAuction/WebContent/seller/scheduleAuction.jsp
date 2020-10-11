<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="java.sql.*, com.auctivity.utility.DBConnection" %>
<%ResultSet resultset =null;Statement ps=null;%>
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
		<% try
		{
			//Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection connection = DBConnection.getConnectionId();
			ps=connection.createStatement();
			resultset =ps.executeQuery("select * from  OnlineAuctionDB.Product") ;
		%>

			<h2>Schedule An Auction</h2>
			<div>
			<select class="product-dropdown" name="products" required>
				<option value="" disabled selected hidden>Choose a product</option>
				<%  while(resultset.next()){ %>
            	<option><%= resultset.getString(2)%></option>
      			<% } %>
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
		    <%
		        }
		        catch(Exception e)
		        {
		             out.println("wrong entry"+e);
		        }
			%>
		    
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