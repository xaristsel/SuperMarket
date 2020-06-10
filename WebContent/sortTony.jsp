<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<!-- SuperMarketApp -->
		<title>Super Market App</title>

		<link rel="shortcut icon" href="images/fav.ico">
		<link rel="stylesheet" type="text/css" href="css/styleA.css"></li>
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


		<div class="container">
			<section id="main">
			<h1>Query A</h1>
			<p>Please select the store id you are interested into and select any other criteria from the Form (such as Date, Total Amount etc) to get information about the transactions.</p>
			<form class="my-form" action="SortStoreServlet"   method="post">
				<div class="form-group">
					<label>Stores: </label>
					<input type="number" name="Stores" id="Stores" value="1" min="1" max="10">
				</div>
				
				<div class="form-group">
					<label>Category: </label>
					<input type="number" name="Category" id="Category" min="1" max="6">
				</div>
				
				<div class="form-group">
					<label>Total Amount: </label>
					<input type="number" name="TotalAmount" id="TotalAmount" step="0.5" min="0.5" max="100">
				</div> 
				
					<div class="form-group">
					<label>Total Pieces: </label>
					<input type="number" name="totalPieces" id="totalPieces" step="1" min="0" max="100">
				</div>
				
				<div class="form-group" >
					<label>Payment Method: </label>
					<select name="paymentMethod" id="paymentMethod">
						<option value=""> </option>
						<option value="Cash">Cash</option>
						<option value="Card">Card</option>
					</select>
				</div>
				
				<div class="form-group">
					<label>date: </label>
					<input type="date" name="date" id="date">
				</div>
				
				<input class="button1" type="submit" value="Submit" name="">
			</form>
			</section>
<% 	        ArrayList<A1> SearchedItems=(ArrayList<A1>)request.getAttribute("SearchedItems");
	if(SearchedItems!=null){
%>		
	<aside id="side">
	<table class='table'>
	<tr class='Headtr'>
		<th>Id</th>
		<th>Total Price</th>
		<th>Total Amount</th>
		<th>Store Id</th>
		<th>Customer Id</th>
		<th>Payment Method</th>
		<th>Date</th>
		<th>Time</th>
	</tr>
	<%@ page import="com.company.Data.A1,java.util.Iterator,java.util.ArrayList"%>

    <%
        Iterator it=SearchedItems.iterator();
        while(it.hasNext())
        {
            A1 Item=(A1)it.next();
    %>
    <tr>
        <th><%=Item.getId()%></th>
        <th><%=Item.getTotalPieces()%></th>
        <th><%=Item.getTotalAmount()%></th>
        <th><%=Item.getStore()%></th>
        <th><%=Item.getCustomer()%></th>
        <th><%=Item.getPaymentMethod()%></th>    
        <th><%=Item.getDate()%></th>    
        <th><%=Item.getTime()%></th>    
           
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