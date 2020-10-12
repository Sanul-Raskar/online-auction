<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Add Product | Online Auction</title>

<!-- Including CSS files -->
<style><%@include file="../resources/css/style.css"%></style>
<style><%@include file="../resources/css/seller/addProducts.css"%></style>


</head>
<body>
	<%@ include file="../common/navbar.jsp"%>

		<!-- Add product form -->
	
	<div class="text-center">
		<h1>Add Product</h1>
		<h3>Please fill the product details...</h3>
	</div>

	<div class="form-container">
		<form id="addProductForm" method="post" enctype="multipart/form-data">
			<div class="form-group">
				<label for="productName"><b>Name</b></label> <input
					class="form-input" type="text" placeholder="Product Name"
					name="productName" id="productName" required>
				<p id="productNameError" style="margin-top: 4px; color: red"></p>
			</div>

			<div class="form-group">
				<label for="category"><b>Category</b></label> 
				<select	class="form-input" id="category" name="category" required>
					<option value="" disabled selected hidden>Choose a category</option>
				<c:forEach items="${categoryList}" var="cat">
       				 <option value="${cat.categoryName}">${cat.categoryName}</option>
    			</c:forEach>	
					</select>
				<p id="categoryError" style="margin-top: 4px; color: red"></p>
			</div>

			<div class="form-group">
				<label for="productDescription"><b>Description</b></label>
				<textarea class="form-input" id="productDescription"
					name="productDescription" rows="4" cols="30" form="addProductForm"
					placeholder="Product Description" required></textarea>
				<p id="descriptionError" style="margin-top: 4px; color: red"></p>
			</div>

			<div class="form-group">
				<label for="actualPrice"><b>Price</b></label> <input
					class="form-input" type="text" placeholder="Price"
					name="actualPrice" id="actualPrice" required>
				<p id="actualPriceError" style="margin-top: 4px; color: red"></p>
			</div>

			<div class="form-group">
				<label for="quantity"><b>Quantity</b></label> <input
					class="form-input" type="text" placeholder="Product Quantity"
					name="quantity" id="quantity" required>
				<p id="quantityError" style="margin-top: 4px; color: red"></p>
			</div>

			<div class="form-group" id='imagePreview'>
				<label for="img"><b>Upload Product Image</b></label> <input
					class="form-input" type="file" id="file" name="file">
				<p id="imageError" style="margin-top: 4px; color: red"></p>
			</div>

			<div class="text-center">
				<button class="addproduct-btn" type="submit">Add Product</button>
			</div>
		</form>
	</div>

	<div style="height: 100px"></div>
	
	<!-- Including footer and Validaiton javascript files -->

	<%@ include file="../common/footer.jsp"%>
	<script> <%@include file="../resources/js/index.js"%></script>
	<script> <%@include file="../resources/js/utility/inputValidation.js"%></script>
	<script> <%@include file="../resources/js/seller/addProducts.js"%></script>

</body>
</html>