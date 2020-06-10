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
import com.company.Data.model.OlderPrices;
import com.company.Data.model.Products;
import com.company.Data.model.Stores;
import com.company.Data.model.Transactions;
/**
* Servlet implementation class logserv
*/

@WebServlet("/UpdateProductPriceServlet")
public class UpdateProductPriceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
  /**
   * @see HttpServlet#HttpServlet()
   */
  public UpdateProductPriceServlet() {
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
		
		String x1=(String) request.getParameter("ProductId");
		System.out.println(x1);
		int id=Integer.parseInt(x1);
		
		String x2=(String) request.getParameter("Price");
		System.out.println(x2);
		double price=Double.parseDouble(x2);
		
		Products products=new Products();
		Products product1=products.getProductById(id);
		
		OlderPrices olderPrices=new OlderPrices();
		olderPrices.insertOlderPrices(id,"","", product1.getPrice());
		
		products.updateProductPrice(id,price);


		
        	ServletContext context= getServletContext();
        	RequestDispatcher rd= context.getRequestDispatcher("/OldPrices.jsp");
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
