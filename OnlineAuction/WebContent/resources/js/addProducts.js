function validateAddProductForm(event) {
	// Prevent form from automatic submit
	event.preventDefault()

	let formData = new FormData();

	let addProductForm = document.getElementById("addProductForm");
	let validData = true;

	if (validateProductName(addProductForm["productName"].value)) {
		formData.append("name", addProductForm["productName"].value);
	} else {
		validData = false;
		document.getElementById("productNameError").innerHTML = "Please enter product name";
	}

	if (validateProductDescription(addProductForm["productDescription"].value)) {
		formData.append("description",
				addProductForm["productDescription"].value);
	} else {
		validData = false;
		document.getElementById("descriptionError").innerHTML = "Please enter product description";
	}

	if (validateActualPrice(addProductForm["actualPrice"].value)) {
		formData.append("actualPrice", addProductForm["actualPrice"].value);
	} else {
		validData = false;
		document.getElementById("actualPriceError").innerHTML = "Please enter product actual price";
	}

	if (validateProductQuantity(addProductForm["quantity"].value)) {
		formData.append("quantity", addProductForm["quantity"].value);
	} else {
		validData = false;
		document.getElementById("quantityError").innerHTML = "Please enter product quantity";
	}

//	if (validateUploadImage()) {
//		formData.append("image", addProductForm["img"].files[0]);
//	} else {
//		validData = false;
//		document.getElementById("imageError").innerHTML = "Accepted image formats are jpg, jpeg, png and gif";
//	}

	if (validData) {
		console.log(formData);
		/* Send data variable to server using XMLHttpRequest() */
		var http = new XMLHttpRequest();
		http.open('POST', "./addProduct", true);

		// Send the proper header information along with the request
		http.setRequestHeader('Content-type', 'multipart/form-data');

		// Call a function when the state changes.
		http.onreadystatechange = function() {
			if (http.readyState == 4 && http.status == 200) {
				alert(http.responseText);
			}
		}
		console.log(formData);
		// http.send(formData);
	}

}

/*
 * add onSubmit event listener to add product form so that input field values
 * can be validated before submitting form to server
 */
document.getElementById("addProductForm").addEventListener("submit",
		validateAddProductForm);