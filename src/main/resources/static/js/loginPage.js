var errorMsg = document.querySelector("h5").textContent;
function onSubmit(){
    var userNameText  = document.getElementById("username").value.trim();
    var passwordText = document.getElementById("password").value.trim();
    var returnValue=true;
    if(userNameText !=null && passwordText != null && userNameText.length > 0 && passwordText.length > 0){
        returnValue = true;
    }else{
       if(userNameText.length === 0){
        	document.getElementById("user").innerHTML = "* Please enter valid username";
       }
        if(passwordText.length === 0){
        	document.getElementById("pass").innerHTML = "* Please enter valid password";
        }
        returnValue = false;
    }
    if(errorMsg !== null && errorMsg.length>0){
       document.querySelector("h5").classList.add("alert-danger");
       errorMsg ="";
    }else{
        document.querySelector("h5").classList.remove("alert-danger");
    }
    return returnValue;
}

$('html').click(function(){
    document.querySelector("h5").textContent ="";
    document.querySelector("h5").classList.remove("alert-danger");
    document.getElementById("user").innerHTML="";
    document.getElementById("pass").innerHTML="";
  });

