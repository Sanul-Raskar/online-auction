<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>My Profile</title>
    <style><%@include file="../resources/css/style.css"%></style>
	<style><%@include file="../resources/css/buyer/buyerProfile.css"%></style>
</head>
<body>
	<%@ include file="../common/navbar.jsp" %>
	<%@page import="java.util.ArrayList"%>
	<%@page import="java.util.List"%>
	<%@page import="com.auctivity.model.beans.User"%>
	
	<% 
		List<User> list = (ArrayList<User>)request.getAttribute("users");
 	%>
 	
 	
 	<form id="sellerDetails" method="post" class="details">
      <div class="detail-box">
        <h2 style="font-family: Arial">Seller Details</h2>
        <hr />
        <label>Name :</label>
        <input
        id="name"
          type="text"
          name="name"
          value="<%= list.get(0).getName() %>"
        />

        <br />
        <label>Date of Birth : </label>
        <input
          id="dob"
          type="text"
          name="dob"
          value ="<%= list.get(0).getDob() %>"
        />
        
        <br />
        <label>Email ID : </label>
        <input
          id="email"
          type="text"
          name="email"
          value="<%= list.get(0).getEmail()%>"
        />
	
		<br />
        <label>Phone Number :</label>
        <input
          id="phnNumber"
          type="text"
          name="phnNumber"
          value="<%= list.get(0).getPhonenumber() %>"
        />
        
        <br />
        <label>Wallet Amount : </label>
        <input
          id="amount"
          type="text"
          name="amount"
          value="<%= list.get(0).getWallet()%>"
        />

        <br />
      </div>
    </form>
	
	<%@ include file="../common/footer.jsp" %>
	<script> <%@include file="../resources/js/index.js"%></script>
 	
</body>
</html>