<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%!boolean isUserAuthenticated = false;%>

<div id="bottomHeader">
	<div id="mySidebar" class="sidebar">
		<a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times</a>
		<a href="#">My Products</a> <a href="#">Add Products</a> <a href="#">Start
			Auction</a> <a href="#">Log Out</a>
	</div>

	<%
		if (isUserAuthenticated) {
	%>
	<div id="main">
		<button class="openbtn" onclick="openNav()">&#9776;</button>
	</div>
	<%
		} else {
	%>
	<div id="main">
	<div style="float:right">
	<a href="./accounts/login.html" class="navbarButton">Login</a>
	<a href="./accounts/registration.html" class="navbarButton">Sign Up</a>
	</div>
	</div>
	<%
		}
	%>


</div>