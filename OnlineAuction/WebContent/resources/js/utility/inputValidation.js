/*validateName function is check if name is not null or empty and test with given regex pattern.
 * If name is valid then return true else false */
function validateName(name) {
	/*
	 * Regular expression pattern to check if name contains only
	 * uppercase,lowercase alphabets and white spaces
	 */
	let pattern = /^[A-Za-z ]+$/;
	if (name !== null && name !== "" && name !== " " && pattern.test(name)) {
		return true;
	} else {
		return false;
	}
}

/*
 * validateEmail function is check if email is not null or empty and test with
 * given regex pattern. If email is valid then return true else false
 */
function validateEmail(email) {
	/* Regular expression pattern to check email is valid or not */
	let pattern = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;
	if (email !== null && email !== "" && email !== " " && pattern.test(email)) {
		return true;
	} else {
		return false;
	}
}

/*
 * validateUsername function is check if username is not null or empty. If username
 * is valid then return true else false
 */
function validateUsername(uname) {
	if (uname !== null && uname !== "" && uname !== " ") {
		return true;
	} else {
		return false;
	}
}

/*
 * validateMobile function is check if mobile number is not null or empty and test with
 * given regex pattern. If mobile number is valid then return true else false
 */
function validateMobile(mobile) {
	/*
	 * Regular expression pattern to check if mobile number contains only 10
	 * digits
	 */
	let pattern = /^\d{10}$/;
	if (mobile !== null && pattern.test(mobile)) {
		return true;
	} else {
		return false;
	}
}

/*
 * validateBirthdate function is check if birth date is not null or empty and
 * test with given regex pattern. If birthdate is valid then return true else
 * false
 */
function validateBirthdate(dob) {
	/* Regular expression pattern to check if birth date is in format yyyy/mm/dd */
	let pattern = /^[0-9]{4}\-(1[0-2]|0[1-9])\-(3[01]|[12][0-9]|0[1-9])$/;
	if (dob !== null && dob !== "" && dob !== " " && pattern.test(dob)) {
		return true;
	} else {
		return false;
	}
}

/*
 * validatePassword function is check if password is not null or empty and test
 * with given regex pattern. If password is valid then return true else false
 */
function validatePassword(password) {
	/*
	 * Password should contain atleast one capital letter, one small letter, one
	 * number and one special character. Length of password should be between 8
	 * to 15
	 */
	let pattern = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?!.*\s).{8,15}$/;
	if (password !== null && pattern.test(password)) {
		return true;
	} else {
		return false;
	}
}

/*
 * validateAddress function is check if address is not null or empty. If address
 * is valid then return true else false
 */
function validateAddress(address) {
	if (address !== null && address !== "" && address !== " ") {
		return true;
	} else {
		return false;
	}
}

/*
 * validateUsertype function is check if userType is not null or empty. If
 * userType is valid then return true else false
 */
function validateUsertype(userType) {
	/* userType should be either buyer or seller */
	const types = [ "0", "1" ];
	if (userType !== null && userType !== "" && userType !== " "
			&& types.includes(userType)) {
		return true;
	} else {
		return false;
	}
}

/*
 * validateWalletAmount function is check if amount is not null or empty. If
 * amount is valid then return true else false
 */
function validateWalletAmount(amount) {
	/*
	 * Regular expression pattern to check if amount is decimal number. Only
	 * upto 3 digits are allowed after decimal point
	 */
	let pattern = /^\d+(\.\d{1,3})?$/;
	if (amount !== null && amount !== "" && amount !== " "
			&& pattern.test(amount)) {
		return true;
	} else {
		return false;
	}
}


/*
 * validateLoginPassword function is check if password enter during login is not null or empty.
 */
function validateLoginPassword(loginPassword){
	if (loginPassword !== null && loginPassword !== "" && loginPassword !== " ") {
		return true;
	} else {
		return false;
	}
}


/*validateProductName function is check if product name is not null or empty.
 * If product name is valid then return true else false */
function validateProductName(productName) {
	if (productName !== null && productName !== "" && productName !== " ") {
		return true;
	} else {
		return false;
	}
}


/*
 * validateProductDescription function is check if product description is not
 * null or empty. If product description is valid then return true else false
 */
function validateProductDescription(productDesp) {
	if (productDesp !== null && productDesp !== "" && productDesp !== " ") {
		return true;
	} else {
		return false;
	}
}


/*
 * validateActualPrice function is check if price is not null or empty. If price
 * is valid then return true else false
 */
function validateActualPrice(actualPrice) {
	/*
	 * Regular expression pattern to check if price is decimal number. Only upto
	 * 3 digits are allowed after decimal point
	 */
	let pattern = /^\d+(\.\d{1,3})?$/;
	if (actualPrice !== null && actualPrice !== "" && actualPrice !== " "
			&& pattern.test(actualPrice)) {
		return true;
	} else {
		return false;
	}
}


/*
 * validateProductQuantity function is check if quantity is not null or empty. If quantity
 * is valid then return true else false
 */
function validateProductQuantity(productQuantity) {
	/*
	 * Regular expression pattern to check if quantity is digit
	 */
	let pattern = /^[0-9]*$/;
	if (productQuantity !== null && productQuantity !== "" && productQuantity !== " "
			&& pattern.test(productQuantity)) {
		return true;
	} else {
		return false;
	}
}

/*
 * validateUploadImage function is check if price is not null or empty. If price
 * is valid then return true else false
 */
function validateUploadImage() {
	let imageInput = document.getElementById('img');
	let imagePath = imageInput.value;

	// allowed file types
	let imgExtensions = /(\.jpg|\.jpeg|\.png|\.gif)$/i;

	if (!imgExtensions.exec(imagePath)) {
		//alert('Invalid Image Extension');
		imageInput.value = '';
		return false;
	} else {
		// Image preview
		/*
		if (imageInput.files && imageInput.img[0]) {
			let reader = new FileReader();
			reader.onload = function(e) {
				document.getElementById('imagePreview').innerHTML = '<img src="'
						+ e.target.result + '"/>';
			};

			reader.readAsDataURL(imageInput.img[0]);
		}*/
		
		return true;
	}
}

/*
 * validateMinimumBidValue function is check if minimumBidValue is not null or empty. If minimumBidValue
 * is valid then return true else false
 */
function validateMinimumBidValue(minimumBidValue) 
{
	/*
	 * Regular expression pattern to check if minimumBidValue is digit
	 */
	let pattern = /^[0-9]*$/;
	if (minimumBidValue !== null && minimumBidValue !== "" && minimumBidValue !== " "&& pattern.test(minimumBidValue)) 
	{
		return true;
	} 
	else 
	{
		return false;
	}
}


/*
 * validateDate function is check if start date is not null or empty and
 * test with given regex pattern. If start & end Date are valid then return true else
 * false
 */
function validateDate(scheduleDate) 
{
	/* Regular expression pattern to check if birth date is in format yyyy/mm/dd */
	let pattern = /^[0-9]{4}\-(1[0-2]|0[1-9])\-(3[01]|[12][0-9]|0[1-9])$/;
	if (scheduleDate !== null && scheduleDate !== "" && scheduleDate !== " " && pattern.test(scheduleDate)) 
	{
		return true;
	} 
	else 
	{
		return false;
	}
}