<!DOCTYPE html>
<html>
	<head>
		<!-- SuperMarketApp -->
		<title>Super Market App</title>
		<link rel="shortcut icon" href="images/fav.ico">
		<link rel="stylesheet" type="text/css" href="css/styleB.css"></li>
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
			<h1>Query B</h1>
			<p id="main-p">Please select the Customer id you are interested into to get information about this Customer.</p>
			<section id="main">
				<form class="my-form" action="CustomersProfileServlet" method="post">
					<div>
						<label>Customer: </label>
						<input type="number" name="id" id="id" min="1">
					</div>
					<input class="button1" type="submit" value="Submit" name="">
				</form>
			</section>
			<aside id="side">
				<h3>Customer Info</h3>
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
				<%@ page import="com.company.Data.model.Customers,com.company.Data.model.Transactions,java.util.ArrayList,java.util.Iterator,java.util.List,com.company.Data.BestCustomerProducts,com.company.Data.model.Stores"%>
			<%
	    	Customers customer=(Customers) request.getAttribute("customer");  
			if(customer!=null){
			%>
			<tr>
						<th><%=customer.getId()%></th>
						<th><%=customer.getName()%></th>
						<th><%=customer.getBirthDay()%></th>
						<th><%=customer.getPoints()%></th>
						<th><%=customer.getStreet()%></th>
						<th><%=customer.getNumber()%></th>
						<th><%=customer.getPostalCode()%></th>
						<th><%=customer.getCity()%></th>
						<th><%=customer.getFamilyMember()%></th>
						<th><%=customer.getPet()%></th>
						<th><%=customer.getCard()%></th>
						<th><%=customer.getAge()%></th>
						<th><%=customer.getPhone()%></th>
					</tr>
					<%
			}
					%>
				</table>
				<h3>Customer Transactions</h3>
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
				<%

		List<Transactions> customersTransactions=(ArrayList<Transactions>)request.getAttribute("customersTransactions");
		if(customersTransactions!=null){
		Iterator it=customersTransactions.iterator();
		while(it.hasNext()){
    		Transactions Item=(Transactions)it.next();

%>
	<tr>
		<th><%=Item.getId()%></th>
		<th><%=Item.getTotalAmount()%></th>
		<th><%=Item.getTotalPieces()%></th>
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
		<div class="container">
			<div class="block">
				<h4>10 most bought products:</h4>
				<table class='table'>
					<tr class='Headtr'>
						<th>Name</th>
					</tr>
									<%
		List<BestCustomerProducts> bestCustomerProducts=(ArrayList<BestCustomerProducts>)request.getAttribute("bestCustomerProducts");
		if(bestCustomerProducts!=null){		
		Iterator it=bestCustomerProducts.iterator();
		while(it.hasNext()){
			BestCustomerProducts bestProducts=(BestCustomerProducts)it.next();

%>
	<tr>
		<th><%=bestProducts.getProductName()%></th>
	</tr>
<%
}
		}
%>
				</table>
			</div>
			<div class="block">
				<h4>Visited stores:</h4>
				<table class='table'>
					<tr class='Headtr'>
						<th>Id</th>
					</tr>
				<% 
				List<Stores> storesVisited=(ArrayList<Stores>) request.getAttribute("storesVisited");
				if(storesVisited!=null){
					Iterator it=storesVisited.iterator();
					while(it.hasNext()){
						Stores store=(Stores)it.next();

			%>
				<tr>
					<th><%=store.getId()%></th>
				</tr>
			<%
			}
				}
			%>
				</table>
				<h4>Total Stores:</h4>
				<table class='table'>
					<%
			Integer counter=(Integer) request.getAttribute("counter");
			if(counter!=null){
			%>		
			<tr>
						<th><%=counter%></th>
					</tr>
					<%
					}
					%>
				</table>			
			</div>
			<div class="block">
				<h4>Month Average:</h4>
				<table class='table'>
					<tr class='Headtr'>
						<th>Month</th>
						<th>Avg</th>
					</tr>
					<%@ page import="com.company.Data.TransactionPerMonth,com.company.Data.CustomersProfile,java.util.Iterator"%>
					<%
					CustomersProfile customersProfile=new CustomersProfile();
					List<TransactionPerMonth> customersMonthlyTransactions=(List<TransactionPerMonth>) request.getAttribute("transactionPerMonth");
					if(customersMonthlyTransactions!=null){
					Iterator it=customersMonthlyTransactions.iterator();
					while(it.hasNext()){
						TransactionPerMonth transactionsPerMonth=(TransactionPerMonth) it.next();
					%>
					<tr>
						<th><%=transactionsPerMonth.getMonthDate()%></th>
						<th><%=transactionsPerMonth.getAverageAmount()%></th>
					</tr>
					<%
					}
					}
					%>
				</table>
			</div>
			<div class="block">
				<h4>Week Average:</h4>
				<table class='table'>
					<tr class='Headtr'>
						<th>Week</th>
						<th>Avg</th>
					</tr>
					<%@ page import="com.company.Data.TransactionsPerWeek,com.company.Data.CustomersProfile,java.util.Iterator"%>
					<%
					customersProfile=new CustomersProfile();
					List<TransactionsPerWeek> customersWeeklyTransactions=(List<TransactionsPerWeek>) request.getAttribute("transactionPerWeek");
					if(customersWeeklyTransactions!=null){
					Iterator it=customersWeeklyTransactions.iterator();
					while(it.hasNext()){
						TransactionsPerWeek transactionsPerWeek=(TransactionsPerWeek) it.next();
					%>
					<tr>
						<th><%=transactionsPerWeek.getWeek()%></th>
						<th><%=transactionsPerWeek.getAvg()%></th>
					</tr>
					<%
					}
					}
					%>
				</table>
			</div>	
		</div>
    <div>
   		<footer id="main-footer">
			<p>Database 2020, EMP</p>
		</footer>	
	</div>	
	</body>
</html>