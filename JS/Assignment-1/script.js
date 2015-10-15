function activateSubmit() {
	if(document.getElementById("acceptCondition").checked == true) {
		document.getElementById("submitButton").disabled = false;
	}
	else {
		document.getElementById("submitButton").disabled = true;
	}
}
function validate() {
	returnValue = true;
	if(document.getElementById("firstName").value.trim() == "") {
		document.getElementById("fNameError").innerHTML = "First Name Is Empty";
		returnValue = false;
	} else {
		document.getElementById("fNameError").innerHTML = "";
	}
	
	if(document.getElementById("lastName").value.trim() == "") {
		document.getElementById("lNameError").innerHTML = "Last Name Is Empty";
		returnValue = false;
	} else {
		document.getElementById("lNameError").innerHTML = "";
	}
	
	if(document.getElementById("passwd").value.length < 8 ){
		document.getElementById("passwordError").innerHTML = "Password Length should be greater than 8";
		returnValue = false;
	} else {
		document.getElementById("passwordError").innerHTML = "";
	}
	
	if(document.getElementById("passwd").value != document.getElementById("confirmPasswd").value) {
		document.getElementById("confirmPasswordError").innerHTML = "Password & Confirm Password mismatch!!";
		returnValue = false;
	} else {
		document.getElementById("confirmPasswordError").innerHTML = "";
	}
	if(document.getElementById("age").value == "") {
		document.getElementById("ageError").innerHTML = "Age field can't be empty";
	} else {
		document.getElementById("ageError").innerHTML = "";
	}
	if(document.getElementById("state").selectedIndex == 0 || document.getElementById("city").selectedIndex == 0 ) {
		document.getElementById("stateError").innerHTML = "State or City are not Selected!!";
	}
	else {
		alert(document.getElementById("textBox").value);
	}
	if(document.getElementById("address").value == "") {
		document.getElementById("addressError").innerHTML = "Address field can't be empty";
	} else {
		document.getElementById("addressError").innerHTML = "";
	}
	return returnValue;
	
}
function createCity() {
	var cityObject = document.getElementById("city");
	var stateObject = document.getElementById("state");
	switch(stateObject.value) {
		case "Rajsthan" :
			cityObject.innerHTML = "<option>Select City</option><Option value='Jaipur'>Jaipur</option><Option value='Bikaner'>Bikaner</option><Option value='Kota'>Kota</option><Option value='Ajmer'>Ajmer</option>";
			break;
		case "MP" :
			cityObject.innerHTML = "<option>Select City</option><Option value='Bilaspur'>Bilaspur</option><Option value='Bhopal'>Bhopal</option><Option value='Gwalior'>Gwalior</option><Option value='Mandi'>Mandi</option>";
			break;
		case "UP" :
			cityObject.innerHTML = "<option>Select City</option><Option value='Agra'>Agra</option><Option value='Kanpur'>Kanpur</option><Option value='Aligarh'>Aligarh</option><Option value='Mathura'>Mathura</option>";
			break;
		case "Maharastra":
			cityObject.innerHTML = "<option>Select City</option><Option value='Mumbai'>Mumbai</option><Option value='Pune'>Pune</option><Option value='Aurangabad'>Aurangabad</option><Option value='Thane'>Thane</option>";
			break;
	}
}
		
