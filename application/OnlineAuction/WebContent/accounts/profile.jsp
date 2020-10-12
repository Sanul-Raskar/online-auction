<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>My Profile</title>
    <style><%@include file="../resources/css/style.css"%></style>
	<style><%@include file="../resources/css/accounts/profile.css"%></style>
</head>
<body>
	<%@ include file="../common/navbar.jsp" %>
	<%@page import="java.util.ArrayList"%>
	<%@page import="java.util.List"%>
	<%@page import="com.auctivity.model.beans.User"%>
	
	
 	<form id="Details" method="post" class="details">
      <div class="detail-box">
        <%
        	User sessionUser = (User) session.getAttribute("user");
        	if(sessionUser.getUserType() == 0){
        %>
        		<h2 style="font-family: Arial"><b>Hey There Buyer!</b></h2>
        <%
        	}else{
        %>
        		<h2 style="font-family: Arial"><b>Hey There Seller!</b></h2>
        <%
        	}
        	
        %>
        <hr />
        <br />
        <label>Your Name : </label>
        <p><%= sessionUser.getName() %></p>

        <br />
        <label>Your Date of Birth : </label>
        <p><%= sessionUser.getDob() %></p>
        
        <br />
        <label>Your Email ID : </label>
        <p><%= sessionUser.getEmail() %></p>
	
		<br />
        <label>Your Phone Number :</label>
        <p><%= sessionUser.getPhonenumber() %></p>
        
        <br />
        <label>Your Username :</label>
        <p><%= sessionUser.getUsername() %></p>
        
        <br />
        <label>Your Address :</label>
        <p><%= sessionUser.getAddress() %></p>
        
        <br />
        <label>Your Wallet Amount : </label>
        <p><%= sessionUser.getWallet() %></p>

        <br />
      </div>
    </form>
	
	<%@ include file="../common/footer.jsp" %>
	<script> <%@include file="../resources/js/index.js"%></script>
 	
</body>
</html>