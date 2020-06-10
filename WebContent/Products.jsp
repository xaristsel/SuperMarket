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
			<p>Here you can insert, update or delete any data you want about the products.</p>
		</div>
		</br>
		<div class="container">
			<section id="main">
			<form class="my-form" action="insertProductServlet" method="post">
				<div class="form-group">
					<label>Name: </label>
					<input type="text" name="Name" id="Name" required>
				</div>
				<div class="form-group">
					<label>BrandName: </label>
					<select name="BrandName" id="BrandName" required>
						<option value=""> </option>
						<option value="YES">YES</option>
						<option value="NO">NO</option>
					</select>
				</div>
				<div class="form-group">
					<label>Price: </label>
					<input type="number" name="Price" id="Price" step="0.5" min="0.5" max="100" required>
				</div>
				<div class="form-group">
					<label>Category: </label>
					<input type="text" name="Category" id="Category" required>
				</div>
				<input class="button1" type="submit" value="Insert" name="">
			</form>
			</br>
			<form class="my-form" action="DeleteProductServlet" method="post">
				<div class="form-group">
					<label>Product id: </label>
					<input type="number" name="id" id="id"  min="1" required>
				</div>
				<input class="button3" type="submit" value="Delete" name="">
			</form>
			<form class="my-form" action="UpdateProductServlet" method="post">
				<div class="form-group">
					<label>Product id: </label>
					<input type="number" name="id" id="id"  min="1" required>
				</div>
				<input class="button3" type="submit" value="Update" name="">
			</form>
			</br>
			</section>
			<aside id="side">
				<h3>Products</h3>
				<table class='table'>
					<tr class='Headtr'>
						<th>Id</th>
						<th>Name</th>
						<th>BrandName</th>
						<th>Price</th>
						<th>Category</th>
					</tr>
<%@ page import="com.company.Data.model.Products,java.util.List,java.util.ArrayList,java.util.Iterator" %>					
<%
	Products product=new Products();
	List<Products> products=new ArrayList<>();
	products=product.getAllProducts();
	if(products!=null){
	Iterator it=products.iterator();
	while(it.hasNext()){
		Products product1=(Products) it.next();
%>
			<tr>
						<th><%=product1.getId()%></th>
						<th><%=product1.getName()%></th>
						<th><%=product1.getBrandName()%></th>
						<th><%=product1.getPrice()%></th>
						<th><%=product1.getCategory()%></th>
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