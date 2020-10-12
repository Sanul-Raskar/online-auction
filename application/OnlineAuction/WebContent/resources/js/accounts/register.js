function validateForm(event) {
	// Prevent form from automatic submit
	event.preventDefault()

	/*
	 * Initialize empty js object. This object will store valid form data to
	 * send to server
	 */
	let data = {};
	let registerForm = document.getElementById("userRegisterForm");

	/* Initialize flag variable to check if all data is valid */
	let validData = true;

	if (validateName(registerForm["name"].value)) {
		data.name = registerForm["name"].value;
	} else {
		validData = false;
		document.getElementById("nameError").innerHTML = "Invalid name";
	}

	if (validateEmail(registerForm["email"].value)) {
		data.email = registerForm["email"].value;
	} else {
		validData = false;
		document.getElementById("emailError").innerHTML = "Invalid email";
	}

	if (validateUsername(registerForm["username"].value)) {
		data.username = registerForm["username"].value;
	} else {
		validData = false;
		document.getElementById("unameError").innerHTML = "Invalid username";
	}

	if (validateMobile(registerForm["mobile"].value)) {
		data.mobile = registerForm["mobile"].value;
	} else {
		validData = false;
		document.getElementById("mobileError").innerHTML = "Invalid mobile number";
	}

	if (validateBirthdate(registerForm["dob"].value)) {
		data.dob = registerForm["dob"].value;
	} else {
		validData = false;
		document.getElementById("dobError").innerHTML = "Invalid date format. Date format should be dd/mm/yyyy";
	}

	if (validatePassword(registerForm["password"].value)) {
		data.password = registerForm["password"].value;
	} else {
		validData = false;
		document.getElementById("passwordError").innerHTML = "Invalid password. Password should contain atleast one capital letter, one small letter, one number and one special character. Length of password should be between 8 to 15";
	}

	if (registerForm["confirmPassword"].value === registerForm["password"].value) {
		data.confirmPassword = registerForm["confirmPassword"].value;
	} else {
		validData = false;
		document.getElementById("confirmPasswordError").innerHTML = "Passwords do not match";
	}

	if (validateAddress(registerForm["address"].value)) {
		data.address = registerForm["address"].value;
	} else {
		validData = false;
		document.getElementById("addressError").innerHTML = "Invalid address";
	}

	if (validateUsertype(registerForm["userType"].value)) {
		data.userType = registerForm["userType"].value;
	} else {
		validData = false;
		document.getElementById("userTypeError").innerHTML = "Please select option from dropdown";
	}

	if (validateWalletAmount(registerForm["walletAmount"].value)) {
		data.walletAmount = registerForm["walletAmount"].value;
	} else {
		validData = false;
		document.getElementById("walletError").innerHTML = "Invalid amount";
	}
	if (validData) {
		console.log(data);
		/* Send data variable to server using XMLHttpRequest() */
		var http = new XMLHttpRequest();
		var params = "name=" + data.name + "&email=" + data.email
				+ "&username=" + data.username + "&mobile=" + data.mobile
				+ "&dob=" + data.dob + "&password=" + data.confirmPassword
				+ "&address=" + data.address + "&userType=" + data.userType
				+ "&walletAmount=" + data.walletAmount;

		// Make a POST request to controller with endpoint /register
		http.open('POST', "/OnlineAuction/register", true);

		// Send the proper header information along with the request
		http.setRequestHeader('Content-type',
				'application/x-www-form-urlencoded');

		// Call a function when the state changes.
		http.onreadystatechange = function() {
			if (http.readyState == 4 && http.status == 999) {
				alert("Username/Email already exist")
				location.replace("register")
			}
			if (http.readyState == 4 && http.status == 200) {
				alert("Registration successful");
				location.replace("home")
			}
		}

		console.log(params);
		http.send(params);
	}
}

/*
 * add onSubmit event listener to user registration form so that input field
 * values can be validated before submitting form to server
 */
document.getElementById("userRegisterForm").addEventListener("submit",
		validateForm);
