console.log("connected");

/* To display sidebar when clicked on hamburger icon */
function openNav() {
  document.getElementById("mySidebar").style.width = "250px";
  document.getElementById("main").style.marginRight = "250px";
}

/* To hide sidebar when clicked on close icon */
function closeNav() {
  document.getElementById("mySidebar").style.width = "0";
  document.getElementById("main").style.marginRight= "0";
}


function loadProducts() {
    var productsArr = [
      {
        productId: 1,
        productName: "Product 1",
        actualPrice: 56,
        minBidAmount: 70,
        productImg: "./resources/img/logo.jpg",
        startTime: "Sun, 04 Oct 2020 07:14:47 GMT",
        endTime: "Sun, 04 Oct 2020 07:14:47 GMT",
      },
      {
        productId: 2,
        productName: "Product 2",
        actualPrice: 56,
        minBidAmount: 70,
        productImg: "./resources/img/logo.jpg",
        startTime: "Sun, 04 Oct 2020 07:14:47 GMT",
        endTime: "Sun, 04 Oct 2020 07:14:47 GMT",
      },
      {
        productId: 3,
        productName: "Product 3",
        actualPrice: 56,
        minBidAmount: 70,
        productImg: "./resources/img/logo.jpg",
        startTime: "Sun, 04 Oct 2020 07:14:47 GMT",
        endTime: "Sun, 04 Oct 2020 07:14:47 GMT",
      },
      {
        productId: 4,
        productName: "Product 4",
        actualPrice: 56,
        minBidAmount: 70,
        productImg: "./resources/img/logo.jpg",
        startTime: "Sun, 04 Oct 2020 07:14:47 GMT",
        endTime: "Sun, 04 Oct 2020 07:14:47 GMT",
      },
      {
        productId: 5,
        productName: "Product 5",
        actualPrice: 56,
        minBidAmount: 70,
        productImg: "./resources/img/logo.jpg",
        startTime: "Sun, 04 Oct 2020 07:14:47 GMT",
        endTime: "Sun, 04 Oct 2020 07:14:47 GMT",
      },
      {
        productId: 6,
        productName: "Product 6",
        actualPrice: 56,
        minBidAmount: 70,
        productImg: "./resources/img/logo.jpg",
        startTime: "Sun, 04 Oct 2020 07:14:47 GMT",
        endTime: "Sun, 04 Oct 2020 07:14:47 GMT",
      },
      {
        productId: 7,
        productName: "Product 7",
        actualPrice: 56,
        minBidAmount: 70,
        productImg: "./resources/img/logo.jpg",
        startTime: "Sun, 04 Oct 2020 07:14:47 GMT",
        endTime: "Sun, 04 Oct 2020 07:14:47 GMT",
      },
    ];

    productsArr.forEach((product) => {
      let div = document.createElement("div");
      div.id = product.productId;
      div.className = "card";
      div.innerHTML = `
    	  <img src=${product.productImg} class="productImg">
    	  <br/>
    	  <h2 class="text-center">${product.productName}</h2>
    	  <p><span style="font-weight:bold">Actual Price:</span>&nbsp;Rs. ${product.actualPrice}</p>
    	  <p> <span style="font-weight:bold">Min Bid Amount:</span>&nbsp;Rs. ${product.minBidAmount}</p>
    	  <p><span style="font-weight:bold">Bit Start Time:</span> ${product.startTime}</p>
    	  <p><span style="font-weight:bold">Bit Start Time:</span> ${product.endTime}</p>
    	  <br/>
      `;
      document.getElementById("productsContainer").appendChild(div);
    });
  }

  loadProducts();
