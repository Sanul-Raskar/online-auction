<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="../resources/css/style.css"/>
    <link rel="stylesheet" href="../resources/css/addProducts.css"/>
    
</head>
<body>
	<%@ include file="../Common/navbar.jsp" %>  

    <div class="text-center">
        <h1>Add Products</h1>
        <h3>Please fill the product details...</h3>
    </div>

    <div class="form-container">
        <form action="./addProduct" id="addProductForm" method="post" enctype="multipart/form-data" >
            <div class="form-group">
                <label for="productName"><b>Name</b></label>
                <input class="form-input" type="text" placeholder="Product Name" name="productName" id="productName" required> 
            	<p id="productNameError" style="margin-top:4px;color:red"></p>
            </div>

            <div class="form-group">
                <label for="category"><b>Category</b></label>
                <select class="form-input" id="category" name="category" required>
                <option value="category1">Category1</option>
                <option value="category2">Category2</option>
                <option value="category3">Category3</option>
                </select>
                <p id="categoryError" style="margin-top:4px;color:red"></p>
            </div>
            
            <div class="form-group">
                <label for="productDescription"><b>Description</b></label>
                <textarea
	              class="form-input"
	              id="productDescription"
	              name="productDescription"
	              rows="4"
	              cols="30"
	              form="addProductForm"
	              placeholder="Product Description"
	              required
            	></textarea>
            	<p id="descriptionError" style="margin-top:4px;color:red"></p>
            </div>

            <div class="form-group">
                <label for="actualPrice"><b>Price</b></label>
                <input class="form-input" type="text" placeholder="Price" name="actualPrice" id="actualPrice" required>    
            	<p id="actualPriceError" style="margin-top:4px;color:red"></p>
            </div>

            <div class="form-group">
                <label for="quantity"><b>Quantity</b></label>
                <input  class="form-input" type="text" placeholder="Product Quantity" name="quantity" id="quantity" required>
            	<p id="quantityError" style="margin-top:4px;color:red"></p>
            </div>

            <div class="form-group" id='imagePreview'>
                <label for="img"><b>Upload Product Image</b></label>
                <input class="form-input" type="file" id="img" name="img" onchange="return validateUploadImage()">
            	<p id="imageError" style="margin-top:4px;color:red"></p>
            </div>
           
            <div class="text-center">
                <button class="addproduct-btn" type="submit">Add Product</button>
            </div>
        </form>
    </div>
    
    <div style="height:60px"></div>
    
	<%@ include file="../Common/footer.jsp" %>
	<script src="../resources/js/index.js"></script>
	<script src="../resources/js/inputValidation.js"></script>
	<script src="../resources/js/addProducts.js"></script>

</body>
</html>