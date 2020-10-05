<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
          value="<%= list.get(0).getUserName() %>"
        />

        <br />
        <label>Date of Birth : </label>
        <input
          id="dob"
          type="text"
          name="dob"
          value ="<%= list.get(0).getUserDob() %>"
        />
        
        <br />
        <label>Email ID : </label>
        <input
          id="email"
          type="text"
          name="email"
          value="<%= list.get(0).getUserEmail() %>"
        />
	
		<br />
        <label>Phone Number :</label>
        <input
          id="phnNumber"
          type="text"
          name="phnNumber"
          value="<%= list.get(0).getUserPhoneNumber() %>"
        />
        
        <br />
        <label>Wallet Amount : </label>
        <input
          id="amount"
          type="text"
          name="amount"
          value="<%= list.get(0).getUserWalletAmount() %>"
        />

        <br />
      </div>
    </form>
	
	<%@ include file="../Common/footer.jsp" %>
	
</body>
</html>