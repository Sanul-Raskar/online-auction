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
      data.productId = product.id;
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
      
      data.form = "";
      productArray.push(data);
    }
  }
}

createProductArray();



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