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

@WebServlet("/InsertStoreServlet")
public class InsertStoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
  /**
   * @see HttpServlet#HttpServlet()
   */
  public InsertStoreServlet() {
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
		System.out.println(x1);
		
		
		String x2=(String) request.getParameter("Street");
		System.out.println(x2);

		String x3=(String) request.getParameter("Number");
		System.out.println(x3);
		
		String x4=(String) request.getParameter("PostalCode");
		System.out.println(x4);
		
		Integer postalCode1=Integer.parseInt(x4);
		int postalcode=(int) postalCode1;
		
		String x5=(String) request.getParameter("Size");
		System.out.println(x5);
		
		Integer size=Integer.parseInt(x5);

		
		String x6=(String) request.getParameter("Phone");
		System.out.println(x6);
		
		String x7=(String) request.getParameter("OperatingHours");
		System.out.println(x3);

		Stores newStore=new Stores();


		boolean bool=newStore.insertStores(x1,x2,x3,postalcode,size,x6,x7);
		System.out.println(bool);


		
        	ServletContext context= getServletContext();
        	RequestDispatcher rd= context.getRequestDispatcher("/Stores.jsp");
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
