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
			<h1>Query E</h1>
			<p>Here you can insert, update or delete any data you want about the stores.</p>
		</div>
		</br>
		<div class="container">
			<section id="main">
			<form class="my-form" action="InsertStoreServlet" method="post">
				<div class="form-group">
					<label>City: </label>
					<input type="text" name="City" id="City" required>
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
					<label>Size: </label>
					<input type="number" name="Size" min="0" id="Size" required>
				</div>
				<div class="form-group">
					<label>Phone: </label>
					<input type="text" name="Phone" id="Phone" required>
				</div>
				<div class="form-group">
					<label>Operating Hours: </label>
					<input type="text" name="OperatingHours" id="OperatingHours" required>
				</div>
				<input class="button1" type="submit" value="Insert" name="">
			</form>
			</br>
			<form class="my-form" action="DeleteStoreServlet" method="post">
				<div class="form-group">
					<label>Store id: </label>
					<input type="number" name="id" min="1" placeholder="Choose existing id" id="id" required>
				</div>
				<input class="button3" type="submit" value="Delete" name="">
			</form>
			</br>
			<form class="my-form" action="UpdateStoresServlet" method="post">
				<div class="form-group">
					<label>Store id: </label>
					<input type="number" name="id" min="1"  placeholder="Choose existing id" id="id" required>
				</div>
				<input class="button2" type="submit" value="Update" name="">
			</form>
			</section>
			<aside id="side">
				<h3>Stores</h3>
				<table class='table'>
					<tr class='Headtr'>
						<th>Id</th>
						<th>City</th>
						<th>Street</th>
						<th>Number</th>
						<th>Postal Code</th>
						<th>Size</th>
						<th>Phone</th>
						<th>Operating Hours</th>
					</tr>
					<%@ page import="com.company.Data.model.Stores,java.util.List,java.util.ArrayList,java.util.Iterator" %>					
<%
	Stores store=new Stores();
	List<Stores> stores=new ArrayList<>();
	stores=store.getAllStores();
	if(stores!=null){
	Iterator it=stores.iterator();
	while(it.hasNext()){
		Stores store1=(Stores) it.next();
%>
			<tr>
						<th><%=store1.getId()%></th>
						<th><%=store1.getCity()%></th>
						<th><%=store1.getStreet()%></th>
						<th><%=store1.getNumber()%></th>
						<th><%=store1.getPostalCode()%></th>
						<th><%=store1.getSize()%></th>
						<th><%=store1.getPhone()%></th>
						<th><%=store1.getOppeningHour()%></th>				
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

			