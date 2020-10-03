
/*validateProductName function is check if product name is not null or empty.
 * If product name is valid then return true else false */
function validateProductName(productName) 
{
  if (productName !== null && productName !== "" && productName !== " ") 
  {
    return true;
  } 
  else
 {
    return false;
  }
}

/*validateProductDescription function is check if product description is not null or empty.
 * If product description is valid then return true else false */
function validateProductDescription(productName) 
{
  if (productName !== null && productName !== "" && productName !== " ") 
  {
    return true;
  } 
  else
 {
    return false;
  }
}


/*validateActualPrice function is check if price is not null or empty.
 * If price is valid then return true else false */
function validateActualPrice(actualPrice)
{
  /*Regular expression pattern to check if price is decimal number. 
    Only upto 3 digits are allowed after decimal point*/
  let pattern = /^\d+(\.\d{1,3})?$/;
  if (actualPrice !== null && actualPrice !== "" && actualPrice !== " " && pattern.test(actualPrice))
  {
    return true;
  } 
  else 
  {
    return false;
  }
}


/*validateUploadImage function is check if price is not null or empty.
 * If price is valid then return true else false */
function validateUploadImage() 
{ 
    var imageInput = document.getElementById('img');   
    var imagePath = imageInput.value; 
  
    //allowed file types
    var imgExtensions =  /(\.jpg|\.jpeg|\.png|\.gif)$/i; 
      
    if (!imgExtensions.exec(imagePath)) 
    { 
        alert('Invalid Image Extension'); 
        imageInput.value = ''; 
        return false; 
    }  
    else  
    { 
         // Image preview 
        if (imageInput.files && imageInput.img[0])
         { 
            var reader = new FileReader(); 
            reader.onload = function(e)
            { 
                document.getElementById('imagePreview').innerHTML ='<img src="' + e.target.result + '"/>'; 
            }; 
              
            reader.readAsDataURL(imageInput.img[0]); 
        } 
    } 
} 