function validateScheduleAuctionForm(event) 
{
	// Prevent form from automatic submit
	event.preventDefault()

	//let formData=new FormData();
	
	let formData={};

	let scheduleAuctionForm= document.getElementById("scheduleAuctionForm");
	let validData = true;

	formData.products=scheduleAuctionForm["products"].value;
	
	if (validateMinimumBidValue(scheduleAuctionForm["minimumBidValue"].value)) 
	{
		formData.minimumBidValue= scheduleAuctionForm["minimumBidValue"].value;
	}
	else 
	{
		validData = false;
		document.getElementById("minimumBidValueError").innerHTML = "Please enter minimum bid value";
	}

//	if (validateDate(scheduleAuctionForm["startDate"].value)) 
//	{
//		formData.startDate=scheduleAuctionForm["startDate"].value;
//	}
//	else
//	{
//		validData = false;
//		document.getElementById("startDateError").innerHTML = "Please select the start date";
//	}
//
//	if (validateDate(scheduleAuctionForm["endDate"].value)) 
//	{
//		formData.endDate=scheduleAuctionForm["endDate"].value;
//	}
//	else
//	{
//		validData = false;
//		document.getElementById("endDateError").innerHTML = "Please select the end date";
//	}
	
	formData.startDate=scheduleAuctionForm["startDate"].value;
	formData.endDate=scheduleAuctionForm["endDate"].value;

	
	if (validData) 
	{
		console.log(formData);
		/* Send data variable to server using XMLHttpRequest() */
		var http = new XMLHttpRequest();
		var param="products="+formData.products+"&minimumBidValue="+formData.minimumBidValue
					+"&startDate="+formData.startDate+"&endDate="+formData.endDate;
		
		http.open('POST', "/OnlineAuction/scheduleauction", true);
		
		// Send the proper header information along with the request
		http.setRequestHeader('Content-type','application/x-www-form-urlencoded');

		// Call a function when the state changes.
		http.onreadystatechange = function() 
		{
			if (http.readyState == 4 && http.status == 999) {
				alert("Product already scheduled/Error occured")
				document.getElementById("scheduleAuctionForm").reset();
				//location.replace("register")
			}
			if (http.readyState == 4 && http.status == 200) 
			{
				document.getElementById("scheduleAuctionForm").reset();
				alert("Scheduling successful");
			}
		}
		console.log(param);
		http.send(param);
	}

}

/*
 * add onSubmit event listener to schedule auction form so that input field values
 * can be validated before submitting form to server
 */
document.getElementById("scheduleAuctionForm").addEventListener("submit",validateScheduleAuctionForm);
