<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Schedule an Auction</title>
<link rel="stylesheet" href="../resources/css/SellerPage.css" />
<link rel="stylesheet" href="../resources/css/style.css" />

</head>
<body>

	<%@ include file="../Common/navbar.jsp"%>
	
	<div style="height:70px"></div>
	<div class="schedule-form">
		<a href="./SellerPage.jsp">
			<button class="back">Back</button>
		</a>
		<form action="" method="POST">

			<h2>Schedule An Auction</h2>
			<select class="product-dropdown" name="products" required>
				<option value="" disabled selected hidden>Choose a product</option>
				<option value="product 1">product 1</option>
				<option value="product 2">product 2</option>
				<option value="product 3">product 3</option>
			</select> <input class="bid-value" type="text"
				placeholder="Enter Minimum Bid Value"> <input
				class="start-date" type="date" name="StartDate"> <input
				type="date" class="end-date" name="EndDate"> <input
				type="submit" class="submit" name="submit" value="Schedule">
		</form>
	</div>
	<br/><br/>
	<div style="height:150px"></div>
	<%@ include file="../Common/footer.jsp"%>
</body>
</html>