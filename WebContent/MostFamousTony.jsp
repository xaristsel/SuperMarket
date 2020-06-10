<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<!-- SuperMarketApp -->
		<title>Super Market App</title>
		<link rel="shortcut icon" href="images/fav.ico">
		<link rel="stylesheet" type="text/css" href="css/styleC.css"></li>
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
			<h1>Query C</h1>
			<p id="main-p">More information from your data.</p>
		</div>
<%@ page import="com.company.Data.model.Customers,com.company.Data.model.Transactions,java.util.ArrayList,java.util.Iterator,java.util.List,
com.company.Data.BestCustomerProducts,com.company.Data.model.Stores,com.company.Data.BestPair,
com.company.Data.model.Transaction,com.company.Data.BrandNameProductsPerCategory,com.company.Data.CountAlleyShelf,
com.company.Data.RatioOfVisitsByAge"%>
		
		<div class="container">
			<div class="block">
				<h4>Most famous pairs of Products</h4>
				<table class='table'>
					<tr class='Headtr'>
						<th>1st Product Id</th>
						<th>2nd Product Id</th>
					</tr>
					<% 
					Transaction transaction=new Transaction();
			        List<BestPair> bestPairs;
			        bestPairs=new ArrayList<>(transaction.getAllPairs());
					Iterator it=bestPairs.iterator();
					while(it.hasNext()){
						BestPair Item=(BestPair)it.next();
					%>
					<tr>
						<th><%=Item.getId1()%></th>
						<th><%=Item.getid2()%></th>
					</tr>
					<%
					}
					%>
				</table>
			</div>
			<%
			BrandNameProductsPerCategory brandNameProductPerCategory=new BrandNameProductsPerCategory(
					transaction.getProductsBrandNamePerCategory(1)*100,
					transaction.getProductsBrandNamePerCategory(2)*100,transaction.getProductsBrandNamePerCategory(3)*100,
					transaction.getProductsBrandNamePerCategory(4)*100,transaction.getProductsBrandNamePerCategory(5)*100,
					transaction.getProductsBrandNamePerCategory(6)*100);
			%>
			<div class="block">
				<h4>The preferance of your Brandname in every Category:</h4>
				<table class='table'>
					<tr class='Headtr'>
						<th>Category 1</th>
						<th>Category 2</th>
						<th>Category 3</th>
						<th>Category 4</th>
						<th>Category 5</th>
						<th>Category 6</th>
					</tr>
					<tr>
						<th><%=brandNameProductPerCategory.getFreska()%>%</th>
						<th><%=brandNameProductPerCategory.getPsugiou()%>%</th>
						<th><%=brandNameProductPerCategory.getKavas()%>%</th>
						<th><%=brandNameProductPerCategory.getPeripoiisis()%>%</th>
						<th><%=brandNameProductPerCategory.getSpitiou()%>%</th>
						<th><%=brandNameProductPerCategory.getKatoikidiwn()%>%</th>
					</tr>
				</table>
			</div>
			
			<div class="block1">
				<h4>Most famous Alley and Shelf for every store</h4>
				<table class='table'>
					<tr class='Headtr'>
						<th>Alley</th>
						<th>Shelf</th>
					</tr>
			<%
			Integer id=(Integer) request.getAttribute("id");
			List<CountAlleyShelf> countAlleyShelfList;
			if(id!=null){			
			countAlleyShelfList=new ArrayList<>(transaction.getAlleyShelf(id));
			}
			else{
			countAlleyShelfList=new ArrayList<>(transaction.getAlleyShelf(1));
			}
			if(countAlleyShelfList!=null){
			it=countAlleyShelfList.iterator();
			while(it.hasNext()){
				CountAlleyShelf Item=(CountAlleyShelf)it.next();
			%>
				<tr>
					<th><%=Item.getId1()%></th>
					<th><%=Item.getId2()%></th>
				</tr>
			
			<%
			}
			
			%>
				</table>	
				<form class="my-form" action="MostFamousTonyServlet" method="post">
					<div>
						<label>Store: </label>
						<input type="number" name="id" id="id"  value="1" min="1" max="10">
					</div>
					<input class="button1" type="submit" value="Submit" name="">
				</form>
				<%
			}
				%>
						
			</div>
			
			<div class="block2">
				<h4>Hours of biggest Transactions:</h4>
				<table class='table'>
					<tr class='Headtr'>
						<th>Hour</th>
						<th>Total Amount</th>
					</tr>
					<%
			Transactions transactions=new Transactions();
			List<String> strings=new ArrayList<>(transactions.getTimesSpentMostMoney());
			it=strings.iterator();
			while(it.hasNext()){
				String Item=(String)it.next();
				if(Item!=null){
			%>
					<tr>
						<th><%=Item%></th>
					</tr>
					<%
					}
			}
			%>
				</table>
			</div>
			<div class="block2">
				<h4>Customer's age per Hour:</h4>
				<table class='table'>
					<tr class='Headtr'>
						<th>Hour</th>
						<th><25</th>
					    <th>26-45</th>
					    <th>46-74</th>
					    <th>75<</th>
					</tr>
					<%
			        List<RatioOfVisitsByAge> ratioOfVisitsByAges;
					ratioOfVisitsByAges=new ArrayList<>(transactions.getRatios());
					String[] time=new String[13];
			        time[1]="9-10";
			        time[2]="10-11";
			        time[3]="11-12";
			        time[4]="12-13";
			        time[5]="13-14";
			        time[6]="14-15";
			        time[7]="15-16";
			        time[8]="16-17";
			        time[9]="17-18";
			        time[10]="18-19";
			        time[11]="19-20";
			        time[12]="20-21";
			        for(int i=0;i<ratioOfVisitsByAges.size()-1;i++) {
			        	if(ratioOfVisitsByAges.get(i).getAge1()*100!=ratioOfVisitsByAges.get(i).getAge1()*100){
			        		ratioOfVisitsByAges.get(i).setAge1(0.0);
			        	}
			        	if(ratioOfVisitsByAges.get(i).getAge2()*100!=ratioOfVisitsByAges.get(i).getAge2()*100){
			        		ratioOfVisitsByAges.get(i).setAge2(0.0);
			        	}
			        	if(ratioOfVisitsByAges.get(i).getAge3()*100!=ratioOfVisitsByAges.get(i).getAge3()*100){
			        		ratioOfVisitsByAges.get(i).setAge3(0.0);
			        	}
			        	if(ratioOfVisitsByAges.get(i).getAge4()*100!=ratioOfVisitsByAges.get(i).getAge4()*100){
			        		ratioOfVisitsByAges.get(i).setAge4(0.0);
			        	}
					%>
					<tr>
						<th><%=time[i + 1]%></th>
						<th><%=ratioOfVisitsByAges.get(i).getAge1()*100 %>%</th>
					    <th><%=ratioOfVisitsByAges.get(i).getAge2()*100 %>%</th>
					    <th><%=ratioOfVisitsByAges.get(i).getAge3()*100%>%</th>
					    <th><%=ratioOfVisitsByAges.get(i).getAge4()*100 %>%</th>
					</tr>
					<%
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