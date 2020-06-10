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
			<form class="my-form" action="ValidateProductUpdateServlet" method="post">	
			<%@ page import="com.company.Data.model.Products"%>
			<%
			Products product=(Products) request.getAttribute("product1"); 
			%>		
				<div class="form-group">
					<label>Name: </label>
					<input type="text" name="Name" id="Name" value=<%=product.getName()%>>
				</div>
				<div class="form-group">
					<label>BrandName: </label>
					<select name="BrandName" id="BrandName" value=<%=product.getBrandName()%>>
						<option value="YES">YES</option>
						<option value="NO">NO</option>
					</select>
				</div>
				<div class="form-group">
					<label>Price: </label>
					<input type="number" name="Price"  id="Price" step="0.5" min="0.5" max="100"  value=<%=product.getPrice()%>>
				</div>
				<div class="form-group">
					<label>Category: </label>
					<input type="text" name="Category" id="Category" value=<%=product.getCategory()%>>
				</div>
				<input class="button2" type="submit" value="Submit" name="" >
			</form>
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
	Products product2=new Products();
	List<Products> products=new ArrayList<>();
	products=product2.getAllProducts();
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
