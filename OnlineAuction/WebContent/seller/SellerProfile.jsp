<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Online Auction</title>
	<link rel="stylesheet" href="../resources/css/style.css"/>
	<link rel="stylesheet" href="../resources/css/buyerProfile.css"/>
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
        <input
        id="name"
          type="text"
          name="name"
          value="<%= list.get(0).getUsername() %>"
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
          value="<%= list.get(0).getEmail() %>"
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
	
	<%@ include file="../Common/footer.jsp" %>
 	
</body>
</html>