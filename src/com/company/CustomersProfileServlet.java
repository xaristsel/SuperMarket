package com.company;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import com.company.Data.BestCustomerProducts;
import com.company.Data.CustomersProfile;
import com.company.Data.TransactionPerMonth;
import com.company.Data.TransactionsPerWeek;
import com.company.Data.model.Customers;
import com.company.Data.model.Stores;
import com.company.Data.model.Transactions;
/**
* Servlet implementation class logserv
*/

@WebServlet("/CustomersProfileServlet")
public class CustomersProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
  /**
   * @see HttpServlet#HttpServlet()
   */
  public CustomersProfileServlet() {
      super();
      // TODO Auto-generated constructor stub
  }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			processRequest(request, response);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void processRequest(HttpServletRequest request,
			HttpServletResponse response) throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {

//		HttpSession session=request.getSession(); 
//		session.setAttribute("Stores", request.getParameter("Stores"));
		
		
//		HttpSession session1=request.getSession(); 
//		session1.setAttribute("Category", request.getParameter("Category"));
//		HttpSession session2=request.getSession(); 
//		session2.setAttribute("TotalAmount", request.getParameter("TotalAmount"));
//		HttpSession session3=request.getSession(); 
//		session3.setAttribute("totalPieces", request.getParameter("totalPieces"));
//		HttpSession session4=request.getSession(); 
//		session4.setAttribute("date", request.getParameter("date"));
//		HttpSession session5=request.getSession(); 
//		session5.setAttribute("paymentMethod", request.getParameter("paymentMethod"));
		
	    String driver = "com.sqlite.jdbc.Driver"; 
		Datasource datasource=new Datasource();
		
		Integer id=null;
		String x=(String) request.getParameter("id");
		System.out.print(x);
		if(x.equals("")) {
        	response.sendRedirect("CustomersProfileTony.jsp");
		}
		else id=Integer.parseInt(x);
		Customers customer;
		CustomersProfile customersProfile=new CustomersProfile();
		customer=customersProfile.getCustomerProfile(id);
		if(customer.equals(null)) {
        	response.sendRedirect("CustomersProfileTony.jsp");
		}else {
        	request.setAttribute("customer", customer); 
		}
		List<Transactions> customersTransactions=new ArrayList<>(customersProfile.getCustomerTransactions(id));
    	request.setAttribute("customersTransactions", customersTransactions); 
    	
    	List<BestCustomerProducts> bestCustomerProducts=new ArrayList<>(customersProfile.getCustomerBestProducts(id));
    	request.setAttribute("bestCustomerProducts", bestCustomerProducts); 
    	
    	int counter=customersProfile.getCustomersStoresCount(id);
    	request.setAttribute("counter", counter); 
    	
    	List<Stores> storesVisited=new  ArrayList<>(customersProfile.getCustomersStore(id));
    	request.setAttribute("storesVisited", storesVisited);
    	
    	String x1="visitingRatios";
    	List<Double> visitingRatios;
        for(int i=1;i<11;i++) {
            visitingRatios = new ArrayList<>(customersProfile.getRatioPerHours(id,i));
        	request.setAttribute(x, visitingRatios.get(i));
        	x1=x1+"i";

        }
    	
    	List<TransactionsPerWeek> transactionPerWeek=new ArrayList<>(customersProfile.getCustomersTransactionsPerWeek(id));
    	request.setAttribute("transactionPerWeek", transactionPerWeek);
    	
    	List<TransactionPerMonth> transactionPerMonth=new ArrayList<>(customersProfile.getCustomersTransactionsPerMonth(id));
    	request.setAttribute("transactionPerMonth", transactionPerMonth); 

		
        	ServletContext context= getServletContext();
        	RequestDispatcher rd= context.getRequestDispatcher("/CustomersProfile.jsp");
        	try {
				rd.forward(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
      


	}
