<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Login</title>
    <style><%@include file="../resources/css/style.css"%></style>
    <style><%@include file="../resources/css/accounts/login.css"%></style>
    <style>#footer{
    position: fixed;
    left:0;bottom: 0;
    }</style>
   
  </head>
  <body>
  	<%@ include file="../common/navbar.jsp"%>
 
  <div class="text-center">
      <h1>User Login</h1>
      <h3>Login using your Auctivity account</h3>
    </div>


	<!-- Login Form -->
  	<div class="wrapper">
  	<div class="login-container">
    <form id="loginForm" method="post">
      <div class="login-box">
        <label style="font-weight:bold;">Username:</label>
        <input
          class="inputField"
          id="username"
          type="text"
          name="username"
          placeholder="Enter username or email"
          required
        />
        <p id="usernameError" style="margin-top:4px;color:red"></p>
        <br />
        <label style="font-weight:bold;">Password: </label>
        <input
          class="inputField"
          id="password"
          type="password"
          name="password"
          placeholder="Enter password"
          required
        />  
        <a href="/OnlineAuction/error/comingSoon.jsp" style="color: #404040;">Forgot Username/Email?</a>
		<p id="passwordError" style="margin-top:4px;color:red"></p>
		<p id="authenticationError" style="margin-top:4px;margin-botton:4px;color:red"></p>
        <input class="login-button" type="submit" name="submit" value="Login" />

        <br />
        <h4 class="text-center">
          Don't have a account?
          <span class="font-bold"
            ><a href="/OnlineAuction/register" style="color: #404040;">Sign Up</a></span
          >
        </h4>
      </div>
    </form>
    </div></div>
    <div style="height:80px"></div>
 	<%@ include file="../common/footer.jsp" %>
    <script> <%@include file="../resources/js/utility/inputValidation.js"%></script>
    <script> <%@include file="../resources/js/accounts/login.js"%></script>
    
  </body>
</html>
