function validateLoginForm(event) {
	// Prevent form from automatic submit
	event.preventDefault()

	/*
	 * Initialize empty js object. This object will store valid form data to
	 * send to server
	 */
	let data = {};

	let loginForm = document.getElementById("loginForm");
	let validData = true;

	if (validateUsername(loginForm["username"].value)) {
		data.username = loginForm["username"].value;
	} else {
		validData = false;
		document.getElementById("usernameError").innerHTML = "Please enter username or email";
	}

	if (validateLoginPassword(loginForm["password"].value)) {
		data.password = loginForm["password"].value;
	} else {
		validData = false;
		document.getElementById("passwordError").innerHTML = "Please enter password";
	}
	if (validData) {
		console.log(data);
		/* Send data variable to server using XMLHttpRequest() */
		var http = new XMLHttpRequest();
		var params = "username=" + data.username + "&password=" + data.password;
		http.open('POST', "/OnlineAuction/login", true);

		// Send the proper header information along with the request
		http.setRequestHeader('Content-type',
				'application/x-www-form-urlencoded');

			// Call a function when the state changes.
		http.onreadystatechange = function() {

			if (http.readyState == 4 && http.status == 999) {
				alert("Invalid credentials")
				location.replace("login")
			}
			if (http.readyState == 4 && http.status == 200) {
				console.log("Login successful");
				location.replace("home")
			}
		}
		console.log(params);
		http.send(params);
	}

}

/*
 * add onSubmit event listener to user login form so that input field values can
 * be validated before submitting form to server
 */

  document.getElementById("loginForm").addEventListener("submit",
  validateLoginForm);
 