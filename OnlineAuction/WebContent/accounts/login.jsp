<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Login</title>
    <style><%@include file="../resources/css/style.css"%></style>
    <style><%@include file="../resources/css/accounts/login.css"%></style>
    
  </head>
  <body>
  	<%@ include file="../common/navbar.jsp"%>
  <br/><br/><br/>
  	<div class="wrapper">
  	<div class="login-container">
    <form id="loginForm" method="post" action="/OnlineAuction/login">
      <div class="login-box">
        <h2>Login Page</h2>
        <hr />
        <label style="font-weight:bold;">Username or Email:</label>
        <input
          class="inputField"
          id="username"
          type="text"
          name="username"
          placeholder="Enter username or email"
          required
        />
        <a href="#" style="color: #404040;">Forgot Username/Email?</a>
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
        <a href="#" style="color: #404040;">Forgot password?</a>
		<p id="passwordError" style="margin-top:4px;color:red"></p>
		<p id="authenticationError" style="margin-top:4px;margin-botton:4px;color:red"></p>
        <input class="login-button" type="submit" name="submit" value="Login" />

        <br /> <br/>
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
