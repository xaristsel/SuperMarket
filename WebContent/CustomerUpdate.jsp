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
				<marquee behavior="scroll" direction="left"><h1> Best App for Super Market Database!</h1></marquee>
			</div>
		</section>
		
		<div class="container">
			<h1>Query E</h1>
			<p>Here you can update any data you want about the customers.</p>
		</div>
		</br>
		<div class="container">
			<section id="main">
			<form class="my-form" action="ValidateCustomerUpdateServlet" method="post">
			<%@ page import="com.company.Data.model.Customers" %>
			<%
			Customers customer=(Customers) request.getAttribute("customer");
						
			%>
			<form class="my-form" action="ValidateCustomerUpdateServlet" method="post">
			
				<div class="form-group">
					<label>Name: </label>
					<input type="text" name="Name" id="Name" value=<%=customer.getName()%> >
				</div>
				<div class="form-group">
					<label>Birth Date: </label>
					<input type="date" name="BirthDate" id="BirthDate" value=<%=customer.getBirthDay()%>>
				</div>
				<div class="form-group">
					<label>Points: </label>
					<input type="number" name="Points" id="Points" min="0" value=<%=customer.getPoints()%>>
				</div>
				<div class="form-group">
					<label>Street: </label>
					<input type="text" name="Street" id="Street" value=<%=customer.getStreet()%>>
				</div>
				<div class="form-group">
					<label>Number: </label>
					<input type="text" name="Number" id="Number" value=<%=customer.getNumber()%>>
				</div>
				<div class="form-group">
					<label>Postal Code: </label>
					<input type="text" name="PostalCode" id="PostalCode" value=<%=customer.getPostalCode()%>>
				</div>
				<div class="form-group">
					<label>City: </label>
					<input type="text" name="City" id="City" value=<%=customer.getCity()%>>
				</div>
				<div class="form-group">
					<label>Family Members: </label>
					<input type="number" name="FamilyMembers" id="FamilyMembers" min="1" value=<%=customer.getFamilyMember()%>>
				</div>
				<div class="form-group">
					<label>Pet: </label>
					<input type="number" name="Pet" id="Pet" min="0" value=<%=customer.getPet()%>>
				</div>
				<div class="form-group">
					<label>Card: </label>
					<input type="text" name="Card" id="Card" value=<%=customer.getCard()%>>
				</div>
				<div class="form-group">
					<label>Age: </label>
					<input type="number" name="Age" id="Age" min="0" value=<%=customer.getAge()%>>
				</div>
				<div class="form-group">
					<label>Phone: </label>
					<input type="text" name="Phone" id="Phone"value=<%=customer.getPhone()%>>
				</div>
				<input class="button2" type="submit" value="Submit" name="">
			</form>
			</br>
			</section>

				</table>
			</aside>
		</div>
		
    	<footer id="main-footer">
			<p>Database 2020, EMP</p>
		</footer>
	</body>
</html>
