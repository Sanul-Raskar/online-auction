<p align="center">
<img style="padding:4px" src="/video/logo.jpg" width="320"/>
</p>
<br/>

# Online Auction
#### The web based system which allows bidding for products

## Prerequisite 
<br/>

1. [Java 1.8](https://www.oracle.com/in/java/technologies/javase/javase-jdk8-downloads.html)
2. [Apache Derby 10.13.1.1](https://db.apache.org/derby/releases/release-10.13.1.1.html)
3. [Apache Tomcat 8.5](https://tomcat.apache.org/download-80.cgi)
4. [jstl-1.2.jar](https://mvnrepository.com/artifact/javax.servlet/jstl/1.2)
5. [Log4J](https://logging.apache.org/log4j/1.2/download.html)

## Serving static files from local file system in Apache Tomcat
Seller can add product image. The images are saved on local file system of server outside of the WAR. Image name is saved in database corresponding to the product. Tomcat can be configured to read files from anywhere on disk and serve them on a specific URL.

Add the ```Context``` tag in the ```conf/server.xml``` file, ```docBase``` attribute is the absolute path to the folder on your local file system and ```path``` attribute will be used by Tomcat to access that folder. Make sure Tomcat has permissions to read/write the specified location.

``` xml
<Host appBase="webapps"
        autoDeploy="false" name="localhost" unpackWARs="true"
        xmlNamespaceAware="false" xmlValidation="false">
    ...
    <Context docBase="/Users/sanul/Documents/uploads/" path="/media" />

</Host>
```

For example, If I store ```myImage.jpg``` in ```/Users/sanul/Documents/uploads/``` folder then using Tomcat server I can access that file in my browser using the following link

``` 
http://localhost:8080/media/myImage.jpg
```
<br/>

### Configure ```server.xml``` using Eclipse
1. Go to *Servers* view.
2. Double click *Tomcat v8.5 Server at localhost*.
3. Click on the *Modules* tab.
4. Select *Add External Web Module*.
5. Enter *Document Base* as the path of folder you created and *Path* as /media.

**Note** : Create folder to upload images outside workspace.

## Add Apache Derby database credentials
```bash
$ cd OnlineAuction/src/com/auctivity/utility
$ vim DBConnection.java
```

Add derby URL, username and password
```java
con = DriverManager.getConnection(url,username,password);
```

## Add Image upload path
```bash
$ cd OnlineAuction/src/com/auctivity/controller
$ vim AddProductController.java
```

Add ```BASE_DIR``` as the image upload folder path in doPost method
```java
String BASE_DIR = "/Users/sanul/Documents/";
```
<br/>

## Create tables in database
Run the ```/OnlineAuction/AuctivitySchema.sql```
<br/>

## Layered Architecture

```bash
.
├── AuctivitySchema.sql
├── WebContent
│   ├── META-INF
│   │   └── MANIFEST.MF
│   ├── WEB-INF
│   │   ├── properties
│   │   │   └── log4j.properties
│   │   └── web.xml
│   ├── accounts
│   │   ├── login.jsp
│   │   ├── profile.jsp
│   │   └── registration.jsp
│   ├── buyer
│   │   └── buyerHistory.jsp
│   ├── common
│   │   ├── footer.jsp
│   │   └── navbar.jsp
│   ├── error
│   │   ├── comingSoon.jsp
│   │   ├── forbiddenAccessError.jsp
│   │   └── pageNotFoundError.jsp
│   ├── index.jsp
│   ├── resources
│   │   ├── css
│   │   │   ├── accounts
│   │   │   │   ├── login.css
│   │   │   │   ├── profile.css
│   │   │   │   └── registration.css
│   │   │   ├── buyer
│   │   │   │   └── buyerPagePurchasedProducts1.css
│   │   │   ├── home.css
│   │   │   ├── seller
│   │   │   │   ├── SellerNavbar.css
│   │   │   │   ├── SellerPage.css
│   │   │   │   └── addProducts.css
│   │   │   └── style.css
│   │   ├── img
│   │   │   └── logo.jpg
│   │   └── js
│   │       ├── accounts
│   │       │   ├── login.js
│   │       │   └── register.js
│   │       ├── buyer
│   │       ├── home.js
│   │       ├── index.js
│   │       ├── seller
│   │       │   ├── addProducts.js
│   │       │   └── scheduleAuction.js
│   │       └── utility
│   │           └── inputValidation.js
│   └── seller
│       ├── addProduct.jsp
│       ├── scheduleAuction.jsp
│       └── sellerHistory.jsp
├── derby.log
└── src
    └── com
        └── auctivity
            ├── controller
            │   ├── AddProductController.java
            │   ├── BuyerHistoryController.java
            │   ├── DefaultController.java
            │   ├── ExceptionController.java
            │   ├── LogOutController.java
            │   ├── LoginController.java
            │   ├── ProfileController.java
            │   ├── RegistrationController.java
            │   ├── ScheduleAuctionController.java
            │   └── SellerHistoryController.java
            ├── exceptions
            │   ├── ForbiddenAccessException.java
            │   ├── InsufficientBalanceException.java
            │   ├── InvalidDataFormatException.java
            │   └── UserNotFoundException.java
            ├── model
            │   ├── beans
            │   │   ├── Bid.java
            │   │   ├── Category.java
            │   │   ├── Product.java
            │   │   ├── ProductForAuction.java
            │   │   └── User.java
            │   ├── dao
            │   │   ├── IProductDao.java
            │   │   ├── IProductSchedulerDao.java
            │   │   ├── IUserDao.java
            │   │   ├── ProductDaoImpl.java
            │   │   ├── ProductSchedulerDaoImpl.java
            │   │   └── UserDaoImpl.java
            │   └── service
            │       ├── IProductSchedulerService.java
            │       ├── IProductService.java
            │       ├── IUserService.java
            │       ├── ProductSchedulerServiceImpl.java
            │       ├── ProductServiceImpl.java
            │       └── UserServiceImpl.java
            └── utility
                ├── ContextListener.java
                ├── DBConnection.java
                ├── InputValidation.java
                ├── MyTimerTask.java
                ├── ObjectFactory.java
                └── PasswordEncrypter.java

```
