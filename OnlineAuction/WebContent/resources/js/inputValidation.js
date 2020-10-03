/*validateName function is check if name is not null or empty and test with given regex pattern.
 * If name is valid then return true else false */
function validateName(name) {
  /*Regular expression pattern to check if name contains only uppercase,lowercase alphabets and white spaces */
  let pattern = /^[A-Za-z ]+$/;
  if (name !== null && name !== "" && name !== " " && pattern.test(name)) {
    return true;
  } else {
    return false;
  }
}

/*validateEmail function is check if email is not null or empty and test with given regex pattern.
 * If email is valid then return true else false */
function validateEmail(email) {
  /*Regular expression pattern to check email is valid or not*/
  let pattern = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;
  if (email !== null && email !== "" && email !== " " && pattern.test(email)) {
    return true;
  } else {
    return false;
  }
}

/*validateUsername function is check if email is not null or empty.
 * If username is valid then return true else false */
function validateUsername(uname) {
  if (uname !== null && uname !== "" && uname !== " ") {
    return true;
  } else {
    return false;
  }
}

/*validateMobile function is check if email is not null or empty and test with given regex pattern.
 * If mobile number is valid then return true else false */
function validateMobile(mobile) {
  /*Regular expression pattern to check if mobile number contains only 10 digits*/
  let pattern = /^\d{10}$/;
  if (mobile !== null && pattern.test(mobile)) {
    return true;
  } else {
    return false;
  }
}

/*validateBirthdate function is check if birthdate is not null or empty.
 * If birthdate is valid then return true else false */
function validateBirthdate(dob) {
  if (dob !== null && dob !== "" && dob !== " ") {
    return true;
  } else {
    return false;
  }
}

/*validatePassword function is check if password is not null or empty and test with given regex pattern.
 * If password is valid then return true else false */
function validatePassword(password) {
  /*Password should contain atleast one capital letter, one small letter, one number and one special character. Length of password should be between 8 to 15*/
  let pattern = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?!.*\s).{8,15}$/;
  if (password !== null && pattern.test(password)) {
    return true;
  } else {
    return false;
  }
}

/*validateAddress function is check if address is not null or empty.
 * If address is valid then return true else false */
function validateAddress(address) {
  if (address !== null && address !== "" && address !== " ") {
    return true;
  } else {
    return false;
  }
}

/*validateUsertype function is check if userType is not null or empty.
 * If userType is valid then return true else false */
function validateUsertype(userType) {
  /*userType should be either buyer or seller*/
  const types = ["buyer", "seller"];
  if (
    userType !== null &&
    userType !== "" &&
    userType !== " " &&
    types.includes(userType)
  ) {
    return true;
  } else {
    return false;
  }
}

/*validateWalletAmount function is check if amount is not null or empty.
 * If amount is valid then return true else false */
function validateWalletAmount(amount) {
  /*Regular expression pattern to check if amount is decimal number. Only upto 3 digits are allowed after decimal point*/
  let pattern = /^\d+(\.\d{1,3})?$/;
  if (amount !== null && amount !== "" && amount !== " " && pattern.test(amount)) {
    return true;
  } else {
    return false;
  }
}
