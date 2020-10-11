<!DOCTYPE html>
<%@page import="com.auctivity.model.beans.User"%>
<html>
<head>
<meta charset="UTF-8">
<title>Home | Online Auction</title>
<style><%@include file="./resources/css/style.css"%></style>
<style><%@include file="./resources/css/home.css"%></style>


</head>
<body>
	<%@ include file="./common/navbar.jsp"%>
	<br /><br/>
	<%-- <h1><% 
		User u= (User)session.getAttribute("user");
    String name="";
	if(u!=null)
		name = u.getName();
		System.out.println("In INDEX JSP ::"+u+":::errorcode:"+request.getAttribute("errorcode"));
 	%></h1>
			<h3>Welcome:<%=name%></h3> --%>


	<div class="customizeWrapper">
		<div style="margin:6px;">
			<label for="sortProducts">Sort products by:</label>
			<select class="inputField" name="sortProduct" id="sortProducts">
				<option value="name">Name</option>
				<option value="category">Category</option>
				<option value="bidEndDate">Bid End Date</option>
			</select>
		</div>
		<div style="margin:6px;">
			<label for="filterCategory">Filter products by category:</label>
			<select class="inputField" name="filterCategory" id="filterCategory">
				<option value="name">Category1</option>
				<option value="category">Category2</option>
				<option value="bidEndDate">Category3</option>
			</select>
		</div>
	</div>
	
	<div class="container">
		<div id="productsContainer" class="grid-row"></div>
	</div>
	<br />
	<%@ include file="./common/footer.jsp"%>
	<script> <%@include file="./resources/js/index.js"%></script>
	<script> <%@include file="./resources/js/home.js"%></script>

</body>
</html>