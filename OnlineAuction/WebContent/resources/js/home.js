var productsArr = [
  {
    productId: 1,
    productName: "iPhone X",
    category: "Mobile",
    actualPrice: 56,
    minBidAmount: 70,
    productImg: "./resources/img/logo.jpg",
    startTime: "Sun, 04 Oct 2020 07:14:47 GMT",
    endTime: "Sun, 04 Oct 2020 07:14:47 GMT",
  },
  {
    productId: 2,
    productName: "MacBook Pro",
    category: "Laptop",
    actualPrice: 56,
    minBidAmount: 70,
    productImg: "./resources/img/logo.jpg",
    startTime: "Sun, 04 Oct 2020 07:14:47 GMT",
    endTime: "Sun, 04 Oct 2020 07:14:47 GMT",
  },
  {
    productId: 3,
    productName: "ViewSonic VW567",
    category: "Monitor",
    actualPrice: 56,
    minBidAmount: 70,
    productImg: "./resources/img/logo.jpg",
    startTime: "Sun, 04 Oct 2020 07:14:47 GMT",
    endTime: "Sun, 04 Oct 2020 07:14:47 GMT",
  },
  {
    productId: 4,
    productName: "Jabra V56",
    category: "Headphone",
    actualPrice: 56,
    minBidAmount: 70,
    productImg: "./resources/img/logo.jpg",
    startTime: "Sun, 04 Oct 2020 07:14:47 GMT",
    endTime: "Sun, 04 Oct 2020 07:14:47 GMT",
  },
  {
    productId: 5,
    productName: "Lenovo Thinkpad",
    category: "Laptop",
    actualPrice: 56,
    minBidAmount: 70,
    productImg: "/resources/img/logo.jpg",
    startTime: "Sun, 04 Oct 2020 07:14:47 GMT",
    endTime: "Sun, 04 Oct 2020 07:14:47 GMT",
  },
  {
    productId: 6,
    productName: "Mi A2",
    category: "Mobile",
    actualPrice: 56,
    minBidAmount: 70,
    productImg: "./resources/img/logo.jpg",
    startTime: "Sun, 04 Oct 2020 07:14:47 GMT",
    endTime: "Sun, 04 Oct 2020 07:14:47 GMT",
  },
  {
    productId: 7,
    productName: "Product 7",
    category: "Mobile",
    actualPrice: 56,
    minBidAmount: 70,
    productImg: "./resources/img/logo.jpg",
    startTime: "Sun, 04 Oct 2020 07:14:47 GMT",
    endTime: "Sun, 04 Oct 2020 07:14:47 GMT",
  },
];

function loadProducts() {
  productsArr.forEach((product) => {
    let div = document.createElement("div");
    div.id = product.productId;
    div.className = "card";
    div.innerHTML = `
      <img src=\${product.productImg} class="productImg">
      <br/>
      <h2 class="text-center">\${product.productName}</h2>
      <p><span style="font-weight:bold">Category:</span> \${product.category}</p>
      <p><span style="font-weight:bold">Actual Price:</span>&nbsp;Rs. \${product.actualPrice}</p>
      <p> <span style="font-weight:bold">Min Bid Amount:</span>&nbsp;Rs. \${product.minBidAmount}</p>
      <p><span style="font-weight:bold">Bit Start Time:</span> \${product.startTime}</p>
      <p><span style="font-weight:bold">Bit Start Time:</span> \${product.endTime}</p>
      <br/>
  `;
    document.getElementById("productsContainer").appendChild(div);
  });
}

// loadProducts();

var productArray = [];
function createProductArray() {
  let arr = [];

  let productContainerElement = document.getElementById(
    "productsContainer"
  ).childNodes;
  for (let i = 0; i < productContainerElement.length; i++) {
    let product = productContainerElement[i].childNodes;

    if (product.length != 0) {
      let data = {};
      console.log(product);
      data.productName = product[3].innerText;
      data.category = product.item(5).innerText.replace("Category:", "");
      data.description = product.item(7).innerText.replace("Description:","");
      data.quantity = product.item(9).innerText("Quantity:","");
      data.actualPrice = product
        .item(11)
        .innerText.replace("Actual Price:", "");
      data.minBidAmount = product
        .item(13)
        .innerText.replace("Min Bid Amount:", "");
      data.startTime = product
        .item(15)
        .innerText.replace("Bit Start Time:", "");
      data.endTime = product
        .item(17)
        .innerText.replace("Bit End Time:", "");
      console.log(data);
      productArray.push(data);
    }
  }
}

createProductArray();


function filterByCategory(category) {
    let result = productArray.filter((el) => el.category == category);
    return result;
}



function sortProducts() {
  let sortType = document.getElementById("sortProducts").value;
  let domNodes = document.getElementById("productsContainer");

  switch (sortType) {
    case "name":
      productsArr.sort(function (product1, product2) {
        // Use toUpperCase() to ignore character casing
        const p1 = product1.productName.toUpperCase();
        const p2 = product2.productName.toUpperCase();

        if (p1 > p2) {
          return 1;
        } else if (p1 < p2) {
          return -1;
        } else {
          return 0;
        }
      });

      // remove all child nodes of productContainer
      while (domNodes.firstChild) {
        domNodes.firstChild.remove();
      }

      // append nodes from sorted array to productContainer
      loadProducts();
      break;

    case "category":
      productsArr.sort(function (product1, product2) {
        // Use toUpperCase() to ignore character casing
        const p1 = product1.category.toUpperCase();
        const p2 = product2.category.toUpperCase();

        if (p1 > p2) {
          return 1;
        } else if (p1 < p2) {
          return -1;
        } else {
          return 0;
        }
      });

      while (domNodes.firstChild) {
        domNodes.firstChild.remove();
      }

      loadProducts();
      break;

    case "bidEndDate":
      productsArr.sort(function (product1, product2) {
        // Use toUpperCase() to ignore character casing
        const p1 = product1.endTime.toUpperCase();
        const p2 = product2.endTime.toUpperCase();

        if (p1 > p2) {
          return 1;
        } else if (p1 < p2) {
          return -1;
        } else {
          return 0;
        }
      });
      break;
  }
}

document
  .getElementById("sortProducts")
  .addEventListener("change", sortProducts);


function validateBidValue(productId){
	console.log("hello");
	let bidInputValue = document.getElementById(`bidValue\${productId}`).value;
	let minBidValue = document.getElementById(`minBidAmount\${productId}`).textContent;
	console.log(minBidValue);
	var minBidNumber = minBidValue.match(/(\d+)/); 
	if(parseInt(bidInputValue,10) < parseInt(minBidNumber[0],10)){
		alert("Enter amount greater than minimum bid amount");
		return false;
	}
	else{
		let bidStatus= document.getElementById(`bidStatus\${productId}`).textContent;
		bidStatus = bidStatus.replace("Status:","");
		console.log(bidStatus);
		var http = new XMLHttpRequest();
		var params = "productId="+productId+"&bidStatus="+bidStatus;

		// Make a POST request to controller with endpoint /register
		http.open('POST', "/OnlineAuction/placebid", true);

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
			}
		}

		console.log(params);
		//http.send(params);

	}
	
	//return true;
}