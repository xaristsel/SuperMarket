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
			<form class="my-form" action="UpdateProductPriceServlet" method="post">
				<div class="form-group">
					<label>Product Id: </label>
					<input type="number" name="ProductId" id="ProductId" min="1" placeholder="Choose existing id"  required>
				</div>
				<div class="form-group">
					<label>Price: </label>
					<input type="number" name="Price" id="Price" step="0.5" min="0" max="100"  required>
				</div>
				<input class="button1" type="submit" value="Submit" name="">
			</form>
			</br>
			</section>
			<aside id="side">
				<h3>Old Prices</h3>
				<table class='table'>
					<tr class='Headtr'>
						<th>Product Id</th>
						<th>Start Date</th>
						<th>End Date</th>
						<th>Price</th>
					</tr>
					<%@ page import="java.util.List,java.util.ArrayList,com.company.Data.model.OlderPrices,java.util.Iterator"%>
					<%
					OlderPrices olderPrice=new OlderPrices();
					List<OlderPrices> olderPrices=new ArrayList<OlderPrices>(olderPrice.getOlderPrices());
					Iterator it=olderPrices.iterator();
					while(it.hasNext()){
						
						OlderPrices Item=(OlderPrices) it.next();
					%>
						<tr>
							<th><%=Item.getProduct()%></th>
							<th><%=Item.getStartDate()%></th>
							<th><%=Item.getEndDate()%></th>
							<th><%=Item.getPrice()%></th>								
						</tr>
						<%
					}
						%>
					
					
					
				</table>
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
	it=products.iterator();
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