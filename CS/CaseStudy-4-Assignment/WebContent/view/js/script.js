/**
 * 
 */

function showLogin() {
	document.getElementById("mainArticle").style.visibility = "Hidden";
	document.getElementById("loginBackground").style.visibility = "visible";
}
function showSignup() {
	document.getElementById("mainArticle").style.visibility = "Hidden";
	document.getElementById("signupBackground").style.visibility = "visible";
}

function hide() {
	document.getElementById("mainArticle").style.visibility = "Visible";
	document.getElementById("loginBackground").style.visibility = "hidden";
	document.getElementById("signupBackground").style.visibility = "hidden";
	
}
function createVehicle() {
	document.getElementById("createVehicle").style.visibility = "Visible";
}

function createTable() {
	var table = document.getElementById("dataTable");
	table.style.visibility = "visible";
	table.innerHTML = string;
	return false;
}

function editable(rowNumber) {
	document.getElementById("update"+rowNumber).disabled = false;
	document.getElementById("make"+rowNumber).readOnly = false;
	document.getElementById("model"+rowNumber).readOnly = false;
	document.getElementById("engineCapacity"+rowNumber).readOnly = false;
	document.getElementById("fuelCapacity"+rowNumber).readOnly = false;
	document.getElementById("milage"+rowNumber).readOnly = false;
	document.getElementById("price"+rowNumber).readOnly = false;
	document.getElementById("roadTax"+rowNumber).readOnly = false;
}