
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

@WebServlet("/ValidateProductUpdateServlet")
public class ValidateProductUpdateServlet  extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
  /**
   * @see HttpServlet#HttpServlet()
   */
  public ValidateProductUpdateServlet() {
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
		
		String x2=(String) request.getParameter("BrandName");

		String x3=(String) request.getParameter("Price");
		Double price1=Double.parseDouble(x3);
		double price=(double) price1;
		
		
		String x4=(String) request.getParameter("Category");
		Integer category1=Integer.parseInt(x4);
		int category=(int) category1;

		
		Products newProduct=new Products();
		
		System.out.println("name= "+x1);
		System.out.println("brandname= "+x2);
		System.out.println("price= "+price);
		System.out.println("category= "+category);
		System.out.println("id= "+newProduct.idCopy);

		newProduct.updateProduct(newProduct.idCopy, x1, price, x2, category1);
        response.sendRedirect("Products.jsp");
        }
      


	}

