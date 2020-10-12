<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Registration</title>
    <style><%@include file="../resources/css/style.css"%></style>
    <style><%@include file="../resources/css/accounts/registration.css"%></style>
    
  </head>
	<%@ include file="../common/navbar.jsp"%>  
    <body>
    <div class="text-center">
      <h1>User Registration</h1>
      <h3>Create your Auctivity account</h3>
    </div>
    <br />
    <section class="wrapper">
      <div class="form-container">
        <form id="userRegisterForm" method="post">
        <div class="register-box">
          <div class="form-group">
            <label for="name">Name<span style="color:red">*</span> </label><br />
            <input
              id="name"
              class="form-input"
              type="text"
              name="name"
              required
            /><br/>
             <p id="nameError" style="margin-top:4px;color:red"></p>
          </div>
          
          <div class="form-group">
            <label for="email">Email<span style="color:red">*</span></label><br />
            <input
              class="form-input"
              type="email"
              name="email"
              id="email"
              required
            /><br />
            <p id="emailError" style="margin-top:4px;color:red"></p>
          </div>

          <div class="form-group">
            <label for="uname">Username<span style="color:red">*</span></label><br />
            <input
              class="form-input"
              type="text"
              name="username"
              id="uname"
              required
            /><br />
            <p id="unameError" style="margin-top:4px;color:red"></p>
          </div>

          <div class="form-group">
            <label for="mobile">Phone Number<span style="color:red">*</span></label><br />
            <input
              class="form-input"
              type="text"
              name="mobile"
              id="mobile"
              required
            /><br />
            <p id="mobileError" style="margin-top:4px;color:red"></p>
          </div>

          <div class="form-group">
            <label for="dob">Date of Birth<span style="color:red">*</span></label><br />
            <input
              class="form-input"
              type="date"
              name="dob"
              id="dob"
              required
            /><br />
            <p id="dobError" style="margin-top:4px;color:red"></p>
          </div>

          <div class="form-group">
            <label for="password">Password<span style="color:red">*</span></label><br />
            <input
              class="form-input"
              type="password"
              name="password"
              id="password"
              required
            /><br />
            <p id="passwordError" style="margin-top:4px;color:red"></p>
          </div>

          <div class="form-group">
            <label for="confirmPassword">Confirm Password<span style="color:red">*</span></label><br />
            <input
              class="form-input"
              type="password"
              name="confirmPassword"
              id="confirmPassword"
              required
            /><br />
            <p id="confirmPasswordError" style="margin-top:4px;color:red"></p>
          </div>

          <div class="form-group">
            <label for="address">Address<span style="color:red">*</span></label><br />
            <textarea
              class="form-input"
              id="address"
              name="address"
              rows="4"
              cols="30"
              form="userRegisterForm"
              required
            ></textarea
            ><br />
            <p id="addressError" style="margin-top:4px;color:red"></p>
          </div>

          <div class="form-group">
            <label for="userType">How do you want to use Auctivity? <span style="color:red">*</span></label><br />
            <select class="form-input" name="userType" id="userType" required>
              <option value="0">Buy products</option>
              <option value="1">Sell products</option>
            </select>
            <p id="userTypeError" style="margin-top:4px;color:red"></p>
          </div>

          <div class="form-group">
            <label for="walletAmount">Wallet Amount<span style="color:red">*</span></label><br />
            <input
              class="form-input"
              type="text"
              name="walletAmount"
              id="walletAmount"
              required
            /><br />
            <p id="walletError" style="margin-top:4px;color:red"></p>
          </div>
          <br />
          <div class="text-center">
            <button class="signup-btn">Sign Up</button>
          </div>
         </div>
        </form>
        <br />
        <h4 class="text-center">
          Already a member? <span class="font-bold"><a href="/OnlineAuction/login">Log In</a></span>
        </h4>
      </div>
    </section>
    <div style="height: 100px"></div>
    <%@ include file="../common/footer.jsp" %>
    
    <script> <%@include file="../resources/js/utility/inputValidation.js"%></script>
    <script> <%@include file="../resources/js/accounts/register.js"%></script>
    
  </body>
</html>
