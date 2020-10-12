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
      data.productId = productContainerElement[i].id;
      data.img = product.item(1);
      data.productName = product[3].innerText;
      data.category = product.item(5).innerText.replace("Category: ", "");
      data.description = product.item(7).innerText.replace("Description: ","");
      data.quantity = product.item(9).innerText.replace("Quantity: ","");
   
      let actualPrice = product.item(11).innerText;
      let actualPriceNumber = actualPrice.match(/(\d+)/);
      
      data.actualPrice = actualPriceNumber[0];

      let minBidAmount = product.item(13).innerText;
      let minBidNumber = minBidAmount.match(/(\d+)/);
      
      data.minBidAmount = minBidNumber[0];
      
      data.startTime = product
        .item(15)
        .innerText.replace("Bid Start Time:", "");
      data.endTime = product
        .item(17)
        .innerText.replace("Bid End Time:", "");
      
      let status = product.item(19).innerText.replace("Status:","");
      if(status === "OPEN"){
    	  data.status = 1;
    	  data.statusDes = "OPEN";
      }
      
      let form = product.item(21);
      if(form != null){
    	 data.form = form; 
      }else{
    	  data.form = "";
      }
      
      console.log(data);
      
      productArray.push(data);
    }
  }
}

createProductArray();
console.log();


function loadProducts() {
  productsArr.forEach((product) => {
    let div = document.createElement("div");
    div.id = product.productId;
    div.className = "card";
    div.innerHTML = `
      \${product.img}
      <br/>
     <h2 id="productName\${product.productId}" class="text-center">\${product.productName}</h2>
     <p id="productCategory\${product.productId}"><span style="font-weight:bold">Category:</span> \${product.category}</p>
     <p id="productDescription\${product.productId}"><span style="font-weight:bold;word-wrap: break-word;">Description:</span> \${product.description}</p>
     <p id="productQuantity\${product.productId}"><span style="font-weight:bold">Quantity:</span> \${product.quantity}</p>
	 <p id="productPrice\${product.productId}"><span style="font-weight:bold">Actual Price:</span>&nbsp;Rs. \${product.actualPrice}</p>
	 <p id="minBidAmount\${product.productId}"><span style="font-weight:bold">Min Bid Amount:</span>&nbsp;Rs. \${product.minBidAmount}</p>
	 <p id="startTime\${product.productId}"><span style="font-weight:bold">Bid Start Time:</span> \${product.startTime}</p>
	 <p id="endTime\${product.productId}"><span style="font-weight:bold">Bid End Time:</span> \${product.endTime}</p>
	 <p id="bidStatus\${product.productId}"><span style="font-weight:bold">Status:</span>\${product.statusDes}</p>
    
    \${if(\${product.form} !== ""){
    	<form id="bidForm\${product.productId}" method="post" action="/OnlineAuction/home" onsubmit="return validateBidValue(\${product.productId});">
		      	<div class="bidForm">
		      		<input id="bidValue\${product.productId}" class="" type="number" name="bidValue" required/>
		      		<input hidden name="productId" value="\${product.productId}" type="text"/>
		      		<input hidden name="status" value="\${product.status}"/>
		      		<button id="bidButton\${product.productId}" class="bid-button" type="submit">Make Bid</button>
		      	</div>
		</form>
    }}

      <br/>
  `;
    
   
    document.getElementById("productsContainer").appendChild(div);
  });
}

// loadProducts();




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
	
	return true;
}