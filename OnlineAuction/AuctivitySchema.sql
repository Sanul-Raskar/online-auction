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

create sequence OnlineAuctionDB.user_sequence as int start with 100;
create sequence OnlineAuctionDB.category_sequence as int start with 200;
create sequence OnlineAuctionDB.product_sequence as int start with 300;
create sequence OnlineAuctionDB.bid_sequence as int start with 400;

create table OnlineAuctionDB.Usertable (
	UserID INTEGER PRIMARY KEY,
    Name varchar(255) NOT NULL,
    dob date,
    email varchar(255) NOT NULL,
    phonenumber varchar(12) NOT NULL,
    username varchar(255) NOT NULL,
    password varchar(255) NOT NULL,
    address varchar(255) NOT NULL,
    user_type int NOT NULL,
    wallet double
);
--insert into OnlineAuctionDB.usertable values(next value for OnlineAuctionDB.user_sequence,"Jayesh","Jayesh@123");

create table OnlineAuctionDB.Category (
	CategoryID INTEGER  PRIMARY KEY,
	CategoryName varchar(255) NOT NULL,
	CategoryDesc varchar(255) NOT NULL,
	PRIMARY KEY(CategoryName)
);

create table OnlineAuctionDB.Product (
	ProductID INTEGER PRIMARY KEY,
	ProductName varchar(255) NOT NULL,
	ProductCategory varchar(255) NOT NULL references OnlineAuctionDB.Category(CategoryName),
	ProductDesc varchar(255) NOT NULL,
	ActualPrice double NOT NULL,
	Quantity INTEGER NOT NULL,
	Image varchar(255) NOT NULL,
	SellerID INTEGER NOT NULL references OnlineAuctionDB.Usertable(UserID),
);

create table OnlineAuctionDB.Bid (
	BidID INTEGER PRIMARY KEY,
	BidderID INTEGER NOT NULL references OnlineAuctionDB.Usertable(UserID),
	BidProductID INTEGER NOT NULL references OnlineAuctionDB.Product(ProductID),
	BidValue double NOT NULL,
	Status INTEGER NOT NULL
	--Status has 3 values : 1 -> Bid is Open; 2 -> Bid is Lost; 3 -> Bid is Won.
);

create table OnlineAuctionDB.ProductBid (
	MinBidValue INTEGER NOT NULL,
	BidStartDate timestamp,
	BidEndDate timestamp,
	BuyerID INTEGER NOT NULL references OnlineAuctionDB.Usertable(UserID),
	ProductID INTEGER NOT NULL references OnlineAuctionDB.Product(ProductID),
	SoldPrice double NOT NULL,
	Status INTEGER NOT NULL
	-- Status has 4 values : 1 -> New Product for bid;
	--                       2 -> Product bid is completed and unsold
	--                       3 -> Product bid is completed and sold;
	--                       4 -> Product bid is open and accepting bids.	
);