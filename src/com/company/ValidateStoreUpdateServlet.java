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
import com.company.Data.model.Products;
import com.company.Data.model.Stores;
import com.company.Data.model.Transactions;
/**
* Servlet implementation class logserv
*/

@WebServlet("/ValidateStoreUpdateServlet")
public class ValidateStoreUpdateServlet  extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
  /**
   * @see HttpServlet#HttpServlet()
   */
  public ValidateStoreUpdateServlet() {
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
		
	    String driver = "com.sqlite.jdbc.Driver"; 
		Datasource datasource=new Datasource();
		
		
		String x1=(String) request.getParameter("City");
		
		String x2=(String) request.getParameter("Street");

		String x3=(String) request.getParameter("Number");
	
		
		
		String x4=(String) request.getParameter("PostalCode");
		Integer postalCode1=Integer.parseInt(x4);
		int postalCode=(int) postalCode1;
		
		String x5=(String) request.getParameter("Size");
		Integer size1=Integer.parseInt(x5);
		int size=(int) size1;
		
		String x6=(String) request.getParameter("Phone");
		String x7=(String) request.getParameter("OperatingHours");
		System.out.print(x7);
		
		
		Stores newStore=new Stores();
		
	

		newStore.updateStores(newStore.idCopy, x1, x2,x3, postalCode, size,x6,x7);
        response.sendRedirect("Stores.jsp");
        }
      


	}

