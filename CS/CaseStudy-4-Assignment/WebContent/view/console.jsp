<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% if(!session.getAttribute("user").equals("admin")) response.sendRedirect("Home"); %>
<html>
<head>
<title>Welcome Admin</title>
<link href="./view/css/custom.css" rel="stylesheet">
</head>
<body>
	<header>
		<span class="brand"><a href="index.html">myFirstVehicle</a>	</span>
		<a class="signout" href="/CaseStudy-4-Assignment/Signout">Logout </a>
		<a class="create" href="#" onClick="createVehicle()">Create</a>
		
		<form method="post" class="searchForm" action="/CaseStudy-4-Assignment/SearchResult">
			<input type="text" placeholder="Search For Car" name="detail">
			<input src="http://www.clipartbest.com/cliparts/RcG/6j6/RcG6j67Xi.png" type="image">
		</form>
	</header>
	
	<div class="background">
		<div class = "createVehicle" id="createVehicle">
			<div id="form">
				<table>
					<form action="/CaseStudy-4-Assignment/CreateVehicle" method="post">
						<legend><h2>Create Vehicle</h3></legend><hr>
						
						<tr>
							<td>Make: </td><td><input type="text" name="make" placeholder ="Making Year" required></td>
						</tr>
						<tr>
							<td>Model:</td><td><input type="text" name="model" placeholder ="Model Number" required></td>
						</tr><tr>
							<td>Engine Capacity (C.C.)</td><td><input type="number" step="any" name="engineCapacity" placeholder ="Engine Capacity" required></td>
						</tr>
						<tr>
							<td>Fuel Capacity</td><td><input type="number" step="any" name="fuelCapacity" placeholder ="Enter Fuel Capacity" required></td>
						</tr>
						<tr>
							<td>Milage</td><td><input type="number" name="milage" step="Any" placeholder ="Enter Milage" required></td>
						</tr>
						<tr>
							<td>Price</td><td><input type="number" name="price" placeholder ="Price" required></td>
						</tr>
						<tr>
							<td>Road Tax</td><td><input type="number" name="roadTax" placeholder ="Road Tax" required></td>
						</tr>
						<tr>
							<td> <input type="submit" value="Create Vehicle"></td>
							<td> <input type="reset" value="Reset Form"></td>
						</tr>
					</form>
				</table>
			</div>
	</div>
	<footer>
				Copyright (c)  <a href="http://www.metacube.com">Metacube Software Pvt. Ltd.</a> From 2015 - 20xx <br>
				Design & Developed By <a href="http://www.girdhariagrawal.com">Girdhari Agrawal </a>
	</footer>
</body>
<script src="./view/js/script.js"></script>
</html>