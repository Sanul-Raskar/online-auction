-- Database Understanding : 1) The database name is OnlineAuctionDB with 5 tables under it namely:
--                                             (i) User; 
--                                             (ii) Category; 
--                                             (iii) Product; 
--                                             (iv) Bid;
--                                             (v) ProductBid.   
--                          2) The UserID is unique and has value starting from 100;
--                          3) The CategoryID is unique and has value starting from 200;
--                          4) The ProductID is unique and has value starting from 300;
--                          5) The BidID is unique and has values starting from 400;
--                          6) User.wallet is an optional entity and is not set to "NOT NULL";
--                          7) Primary key of respective tables have been provided at the end of each table;

create table OnlineAuctionDB.User (
	UserID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 100, INCREMENT BY 1),
    Name varchar(255) NOT NULL,
    dob varchar(100) NOT NULL,
    email varchar(255) NOT NULL,
    phonenumber varchar(12) NOT NULL,
    username varchar(255) NOT NULL,
    password varchar(255) NOT NULL,
    address varchar(255) NOT NULL,
    user_type int NOT NULL,
    wallet int,
    PRIMARY KEY (Personid)
);

create table OnlineAuctionDB.Category (
	CategoryID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 200, INCREMENT BY 1),
	CategoryName varchar(255) NOT NULL,
	CategoryDesc varchar(255) NOT NULL,
	PRIMARY KEY(CategoryName)
);

create table OnlineAuctionDB.Product (
	ProductID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 300, INCREMENT BY 1),
	ProductName varchar(255) NOT NULL,
	ProductCategory varchar(255) NOT NULL references OnlineAuctionDB.Category(CategoryName),
	ProductDesc varchar(255) NOT NULL,
	ActualPrice INTEGER NOT NULL,
	Quantity INTEGER NOT NULL,
	Image varchar(255) NOT NULL,
	SellerID INTEGER NOT NULL references OnlineAuctionDB.User(UserID),
	PRIMARY KEY(ProductID)
);

create table OnlineAuctionDB.Bid (
	BidID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 400, INCREMENT BY 1),
	BidderID INTEGER NOT NULL references OnlineAuctionDB.User(UserID),
	BidProductID INTEGER NOT NULL references OnlineAuctionDB.Product(ProductID),
	BidValue INTEGER NOT NULL,
	Status INTEGER NOT NULL,
	--Status has 3 values : 1 -> Bid is Open; 2 -> Bid is Lost; 3 -> Bid is Won.
);

create table OlineAuctionDB.ProductBid (
	MinBidValue INTEGER NOT NULL,
	BidStartDate Date,
	BidEndDate Date,
	BuyerID INTEGER NOT NULL references OnlineAuctionDB.User(UserID),
	SoldPrice INTEGER NOT NULL,
	Status INTEGER NOT NULL,
	-- Status has 4 values : 1 -> New Product for bid;
	--                       2 -> Product bid is completed and unsold
	--                       3 -> Product bid is completed and sold;
	--                       4 -> Product bid is open and accepting bids.	
);