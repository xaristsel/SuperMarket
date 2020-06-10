<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<!-- SuperMarketApp -->
		<title>Super Market App</title>
		<link rel="shortcut icon" href="images/fav.ico">
		<link rel="stylesheet" type="text/css" href="css/styleindex.css"></li>
	</head>

	<body>
		<header id="main-header">
			<div class="Head-container">
				<abbr title="Home Page"><a href="index.html"><img src="images/logo.png" width="100" alt="logo" > </a></abbr>
				<h1>Super Market App</h1>
			</div>
		</header>

		<section id="showcase">
			<div class="container">
				<h1> Best App for Super Market Database!</h1>
			</div>
		</section>


		<div class="container">
			<h1>Query E</h1>
			<p>Here you can see the old price of your products and also change the price of any product you want.</p>
		</div>
		</br>
		<div class="container">
			<section id="main">
			<form class="my-form" action="ValidateStoreUpdateServlet" method="post">
			<%@ page import="com.company.Data.model.Stores"%>
			<%
			Stores store=(Stores) request.getAttribute("store1"); 
			%>		
				<div class="form-group">
					<label>City: </label>
					<input type="text" name="City" id="City" value=<%=store.getCity()%>>
				</div>
				<div class="form-group">
					<label>Street: </label>
					<input type="text" name="Street" id="Street" value=<%=store.getStreet()%>>
				</div>
				<div class="form-group">
					<label>Number: </label>
					<input type="text" name="Number" id="Number" value=<%=store.getNumber()%>>
				</div>
				<div class="form-group">
					<label>Postal Code: </label>
					<input type="text" name="PostalCode" id="PostalCode" value=<%=store.getPostalCode()%>>
				</div>
				<div class="form-group">
					<label>Size: </label>
					<input type="number" name="Size" min="0" id="Size" value=<%=store.getSize()%>>
				</div>
				<div class="form-group">
					<label>Phone: </label>
					<input type="text" name="Phone" id="Phone" value=<%=store.getPhone()%>>
				</div>
				<div class="form-group">
					<label>Operating Hours: </label>
					<input type="text" name="OperatingHours" id="OperatingHours" value=<%=store.getOppeningHour()%>>
				</div>
				<input class="button2" type="submit" value="Submit" name="">
			</form>
			</section>
		</div>
		
    	<footer id="main-footer">
			<p>Database 2020, EMP</p>
		</footer>
	</body>
</html>
