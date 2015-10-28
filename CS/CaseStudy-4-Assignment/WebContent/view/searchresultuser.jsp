<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="model.Vehicle" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Welcome User</title>
<link href="./view/css/custom.css" rel="stylesheet">
</head>
<body>
		<%
			String table = "<tr><th>Vehicle Id</th><th>Make Year</th><th>Model</th><th>Engine Capacity</th>"
							+"<th>Fuel Capacity</th><th>Milage</th><th>Price</th><th>Road Tax</th>";
			String visible = "hidden";
			if(request.getAttribute("visible") != null) {
				visible = (String) request.getAttribute("visible");
			}
			List<Vehicle> vehicleList = (List<Vehicle>) request.getAttribute("detail");
			for(Vehicle vehicle : vehicleList) {
				int vehicleId = vehicle.getVehicleId();
				int makeYear = vehicle.getMake();
				String model = vehicle.getModel();
				double engineCapacity = vehicle.getEngineInCC();
				double fuelCapacity = vehicle.getFuelCapacity();
				double milage = vehicle.getMilage();
				double price = vehicle.getPrice();
				double roadTax = vehicle.getRoadTax();
				table += "<TR><TD>"+vehicleId+"</TD><TD>"+makeYear+"</TD><TD>"+model+"</TD><TD>"
						 +engineCapacity+"</TD><TD>"+fuelCapacity+"</TD><TD>"+milage+"</TD><TD>"
						 +price+"</TD><TD>"+roadTax+"</TD></TR>";
			}
		%>
	<jsp:include page="./master.jsp"></jsp:include>
	<article>
		<table class="dataTable" id="dataTable" style="visibility:<%=visible%>">
		<%=table%>
		</table>
	</article>
	<footer>
				Copyright (c)  <a href="http://www.metacube.com">Metacube Software Pvt. Ltd.</a> From 2015 - 20xx <br>
				Design & Developed By <a href="http://www.girdhariagrawal.com">Girdhari Agrawal </a>
	</footer>
	<%visible="hidden";%>
	</body>
<script src="./view/js/script.js"></script>
</html> 