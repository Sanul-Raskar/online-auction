<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Online Auction</title>
		<style><%@include file="../resources/css/style.css"%></style>
		<style><%@include file="../resources/css/buyerProfile.css"%></style>
	
</head>
<body>
	
	<%@ include file="../Common/navbar.jsp" %>
	<%@page import="java.util.ArrayList"%>
	<%@page import="java.util.List"%>
	<%@page import="com.auctivity.model.User"%>
	
	<% 
		List<User> list = (ArrayList<User>)request.getAttribute("users");
 	%>

	<form id="buyerDetails" method="post" class="details">
      <div class="detail-box">
        <h2 style="font-family: Arial">Buyer Details</h2>
        <hr />
        <label>Name :</label>
        <p><%= list.get(0).getUsername() %></p>

        <br />
        <label>Date of Birth : </label>
        <p><%= list.get(0).getDob() %></p>
        
        <br />
        <label>Email ID : </label>
        <p><%= list.get(0).getEmail() %></p>
	
		<br />
        <label>Phone Number :</label>
        <p><%= list.get(0).getPhonenumber() %></p>
        
        <br />
        <label>Wallet Amount : </label>
        <p><%= list.get(0).getWallet()%></p>

        <br />
      </div>
    </form>
	
	<%@ include file="../Common/footer.jsp" %>
	<script> <%@include file="../resources/js/index.js"%></script>
	
	
</body>
</html>