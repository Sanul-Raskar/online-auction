<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="addProducts.css"/>
    <%@ include file="SellerNavbar.html" %>
</head>
<body>
    <div class="text-center">
        <h1>Add Products</h1>
        <h3>Please fill the product details...<h3>
    </div>

    <div class="form-container">
        <form >
        
            <div class="form-group">
                <label for="productName"><b>Name</b></label>
                <input class="form-input" type="text" placeholder="Product Name" name="productName" id="productName" required> 
            </div>

            <div  class="form-group">
                <label for="category"><b>Category</b></label>

                <select class="form-input" id="category" name="category">
                <option value="category1">Category1</option>
                <option value="category2">Category2</option>
                <option value="category3">Category3</option>
                </select>
            </div>
            

            <div  class="form-group">
                <label for="productDescription"><b>Description</b></label>
                <input class="form-input" type="text" placeholder="Product Description" name="productDescription" id="productDescription" required>     
            </div>

            
            <div  class="form-group">
                <label for="actualPrice"><b>Price</b></label>
                <input class="form-input" type="text" placeholder="Price" name="actualPrice" id="actualPrice" required>    
            </div>

            <div  class="form-group">
                <label for="quantity"><b>Quantity</b></label>
                <input  class="form-input" type="text" placeholder="Product Quantity" name="quantity" id="quantity" required>
            </div>

            <div  class="form-group" id='imagePreview'>
                <label for="img"><b>Upload Product Image</b></label>
                <input class="form-input" type="file" id="img" name="img" onchange="return validateUploadImage()">
            </div>
            

            <div class="text-center">
                <button class="addproduct-btn" type="submit">Add Product</button>
            </div>
            
      

        </form>
    </div>
<script src="addProducts.js"></script>
</body>
</html>