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

@WebServlet("/ValidateCustomerUpdateServlet")
public class ValidateCustomerUpdateServlet  extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
  /**
   * @see HttpServlet#HttpServlet()
   */
  public ValidateCustomerUpdateServlet() {
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
		
		String x1=(String) request.getParameter("Name");
		
		
		String x2=(String) request.getParameter("BirthDate");

		String x3=(String) request.getParameter("Points");
		Integer points1=Integer.parseInt(x3);
		int points=(int) points1;
		
		String x4=(String) request.getParameter("Street");
		
		
		String x5=(String) request.getParameter("Number");
		

		
		String x6=(String) request.getParameter("PostalCode");
		Integer postalCode1=Integer.parseInt(x6);
		int postalCode=(int) postalCode1;
		
		String x7=(String) request.getParameter("City");
		
		String x8=(String) request.getParameter("FamilyMembers");
		Integer familyMembers1=Integer.parseInt(x8);
		int familyMembers=(int) familyMembers1;
		
		String x9=(String) request.getParameter("Pet");
		Integer pet1=Integer.parseInt(x9);
		int pet=(int) pet1;

		String x10=(String) request.getParameter("Card");
		
		String x11=(String) request.getParameter("Age");
		Integer age1=Integer.parseInt(x11);
		int age=(int) age1;

		
		
		String x12=(String) request.getParameter("Phone");
		

		Customers newCustomer=new Customers();


		newCustomer.updateCustomers(newCustomer.idCopy,x1,x2,points,x4,x5,postalCode,x7,familyMembers,pet,x10,age,x12);
        response.sendRedirect("Customers.jsp");
        }
      


	}

