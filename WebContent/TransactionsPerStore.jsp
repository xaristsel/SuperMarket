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
			<h1>Query G</h1>
			<p id="main-p">Extra information about your database.</p>
			<section id="main-up">
				<div>
				<h3>Transactions related to Payment Method in every store</h3>
				<table class='table'>
					<tr class='Headtr'>
						<th>Store</th>
						<th>Card</th>
						<th>Cash</th>
					</tr>
					<%@ page import="com.company.Data.model.Transactions,com.company.Data.TransactionsPerStore,java.util.List,java.util.ArrayList" %>
					<%
					Transactions transactions=new Transactions();
					List<TransactionsPerStore> transactionsPerStore=
					new ArrayList<TransactionsPerStore>(transactions.getAllPayments());
					int count=1;
					int countCard=0;
					int countCash=0;
					double ratioCard;
					double ratioCash;
					for(int i=0;i<transactionsPerStore.size();i++){						
					
					%>
					<tr>
						<th><%=transactionsPerStore.get(i).getStoreId() %></th>
						<th><%=transactionsPerStore.get(i).getratioCard()%>%</th>
						<th><%=transactionsPerStore.get(i).getratioCash() %>%</th>
					</tr>
					<%
					}
					%>
				</table>

				</div>
			</section>
			<section id="main">
			<div>
				<h3>Customer Category preference with Pets </h3>
				<table class='table'>
					<tr class='Headtr'>
						<th>Name</th>
						<th>Count</th>
					</tr>
				<%@ page import="com.company.Data.CountPerCategory,java.util.List,java.util.ArrayList" %>
				<%
				List<CountPerCategory> counts=new ArrayList<>(transactions.getCountsPerCategoryWithPet());
				for(int i=0;i<counts.size();i++){
				%>
				<tr>
					<th><%=counts.get(i).getName()%></th>
					<th><%=counts.get(i).getCount()%></th>
				</tr>	
				<%
				}
				%>
				</table>
			</div>
			</section>
			<section id="main">
			<div>
				<h3>Customer Category preference without Pets </h3>
				<table class='table'>
					<tr class='Headtr'>
						<th>Name</th>
						<th>Count</th>
					</tr>
					<%@ page import="com.company.Data.CountPerCategory,java.util.List,java.util.ArrayList" %>
				<%
				List<CountPerCategory> count1=new ArrayList<>(transactions.getCountsPerCategoryWithoutPet());
				for(int i=0;i<count1.size();i++){
				%>
				<tr>
					<th><%=count1.get(i).getName()%></th>
					<th><%=count1.get(i).getCount()%></th>
				</tr>	
				<%
				}
				%>
				</table>
			</div>
			</section>
		</div>
		
   		<footer id="main-footer">
			<p>Database 2020, EMP</p>
		</footer>	
	</div>	
	</body>
</html>