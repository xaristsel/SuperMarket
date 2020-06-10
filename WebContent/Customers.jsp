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

<nav id="navbar">
			<div class="container">
				<ul> 
					<li><a class="button" href="homeTony.jsp">Home</a></li>
					<li><a class="button" href="sortTony.jsp">Query A</a></li>
					<li><a class="button" href="CustomersProfile.jsp">Query B</a></li>
					<li><a class="button" href="MostFamousTony.jsp">Query C</a></li>
					<li><a class="button" href="Customers.jsp">Customers</a></li>
					<li><a class="button" href="Stores.jsp">Stores</a></li>
					<li><a class="button" href="Products.jsp">Products</a></li>
					<li><a class="button" href="OldPrices.jsp">OldPrices</a></li>
					<li><a class="button" href="TransactionsPerStore.jsp">Query G</a></li>
					<li><a class="button" href="Diagram.jsp">Diagram</a></li>
				</ul>
			</div>
		</nav>
		<section id="showcase">
			<div class="container">
				<marquee behavior="scroll" direction="left"><h1> Best App for Super Market Database!</h1></marquee>
			</div>
		</section>

<div class="container">
			<section id="main">
			<form class="my-form" action="InsertCustomerServlet" method="post">
				<div class="form-group">
					<label>Name: </label>
					<input type="text" name="Name" id="Name" required>
				</div>
				<div class="form-group">
					<label>Birth Date: </label>
					<input type="date" name="BirthDate" id="BirthDate" required>
				</div>
				<div class="form-group">
					<label>Points: </label>
					<input type="number" name="Points" min="0" id="Points" required>
				</div>
				<div class="form-group">
					<label>Street: </label>
					<input type="text" name="Street" id="Street" required>
				</div>
				<div class="form-group">
					<label>Number: </label>
					<input type="text" name="Number" id="Number" required>
				</div>
				<div class="form-group">
					<label>Postal Code: </label>
					<input type="text" name="PostalCode" id="PostalCode" required>
				</div>
				<div class="form-group">
					<label>City: </label>
					<input type="text" name="City" id="City" required>
				</div>
				<div class="form-group">
					<label>Family Members: </label>
					<input type="number" name="FamilyMembers" min="1" id="FamilyMembers" required>
				</div>
				<div class="form-group">
					<label>Pet: </label>
					<input type="number" name="Pet" min="0" id="Pet" required>
				</div>
				<div class="form-group">
					<label>Card: </label>
					<input type="text" name="Card" id="Card" required>
				</div>
				<div class="form-group">
					<label>Age: </label>
					<input type="number" name="Age" min="0" id="Age" required>
				</div>
				<div class="form-group">
					<label>Phone: </label>
					<input type="text" name="Phone" id="Phone" required>
				</div>
				<input class="button1" type="submit" value="Insert" name="">
			</form>
			</br>
			<form class="my-form" action="DeleteCustomerServlet" method="post">
				<div class="form-group">
					<label>Customer id: </label>
					<input type="number" name="id" min="1" placeholder="Choose existing id" id="id" required>
				</div>
				<input class="button3" type="submit" value="Delete" name="">
			</form>
			</br>
			<form class="my-form" action="UpdateCustomerServlet" method="post">
				<div class="form-group">
					<label>Customer id: </label>
					<input type="number" name="id" min="1"  placeholder="Choose existing id" id="id" required>
				</div>
				<input class="button2" type="submit" value="Update" name="">
			</form>
			</br>
			</section>
			<aside id="side">
				<h3>Customers</h3>
				<table class='table'>
					<tr class='Headtr'>
						<th>Id</th>
						<th>Name</th>
						<th>Birth Date</th>
						<th>Points</th>
						<th>Street</th>
						<th>Number</th>
						<th>Postal Code</th>
						<th>City</th>
						<th>Family Members</th>
						<th>Pet</th>
						<th>Card</th>
						<th>Age</th>
						<th>Phone</th>
					</tr>
					<%@ page import="com.company.Data.model.Customers,java.util.List,java.util.ArrayList,java.util.Iterator" %>					
<%
Customers customer=new Customers();
	List<Customers> customers=new ArrayList<>();
	customers=customer.getAllProducts();
	if(customers!=null){
	Iterator it=customers.iterator();
	while(it.hasNext()){
		Customers customer1=(Customers) it.next();
%>
			<tr>
						<th><%=customer1.getId()%></th>
						<th><%=customer1.getName()%></th>
						<th><%=customer1.getBirthDay()%></th>
						<th><%=customer1.getPoints()%></th>
						<th><%=customer1.getStreet()%></th>
						<th><%=customer1.getNumber()%></th>
						<th><%=customer1.getPostalCode()%></th>
						<th><%=customer1.getCity()%></th>
						<th><%=customer1.getFamilyMember()%></th>				
						<th><%=customer1.getPet()%></th>				
						<th><%=customer1.getCard()%></th>				
						<th><%=customer1.getAge()%></th>				
						<th><%=customer1.getPhone()%></th>			
			</tr>
					<%
	}
	}
					%>
				</table>
			</aside>
		</div>
		
    	<footer id="main-footer">
			<p>Database 2020, EMP</p>
		</footer>
	</body>
</html>
			