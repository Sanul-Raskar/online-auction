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
    productImg: "./resources/img/logo.jpg",
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
      <img src=${product.productImg} class="productImg">
      <br/>
      <h2 class="text-center">${product.productName}</h2>
      <p><span style="font-weight:bold">Category:</span> ${product.category}</p>
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
