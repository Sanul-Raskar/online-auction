# Online Auction
#### The web based system which allows bidding for products

<p align="center">
<img style="padding:4px" src="/screenshots/logo.jpg" width="320"/>
</p>
<br/>

## Prerequisite 
<br/>
1. [Java 1.8](https://www.oracle.com/in/java/technologies/javase/javase-jdk8-downloads.html)
2. [Apache Derby 10.13.1.1](https://db.apache.org/derby/releases/release-10.13.1.1.html)
3. [Apache Tomcat 8.5](https://tomcat.apache.org/download-80.cgi)
4. [jstl-1.2.jar](https://mvnrepository.com/artifact/javax.servlet/jstl/1.2)

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
5. Enter *Document Base* and *Path*.
