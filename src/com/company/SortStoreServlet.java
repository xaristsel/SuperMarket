package com.company;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.company.Data.A1;
import com.company.Data.CustomersProfile;
import com.company.Data.SortStoreTransactions;
import com.company.Data.model.Customers;
/**
* Servlet implementation class logserv
*/

@WebServlet("/SortStoreServlet")
public class SortStoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
  /**
   * @see HttpServlet#HttpServlet()
   */
  public SortStoreServlet() {
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


		Integer id=null;
		Double totalAmount=null;
		Integer totalPieces=null;
		Integer category=null;
		String date=null;
		String paymentMethod=null;
		
	    String driver = "com.sqlite.jdbc.Driver"; 
		Datasource datasource=new Datasource();
		
		String x=(String) request.getParameter("Stores");
		id=Integer.parseInt(request.getParameter("Stores"));
		x=(String) request.getParameter("TotalAmount");
		if(x.equals("")) {
			totalAmount=null;
		}
		else totalAmount=Double.parseDouble(x);
		x=(String) request.getParameter("totalPieces");
		if(x.equals("")) {
			totalPieces=null;
		}
		else totalPieces=Integer.parseInt(x);
		x=(String) request.getParameter("category");
		if(x==null) {
			category=null;
		}
		else category=Integer.parseInt(x);
		date=(String) request.getParameter("date");
		if(date.equals("")) {
			date=null;
		}
		paymentMethod=(String) request.getParameter("paymentMethod");
		if(paymentMethod.equals("")){
			paymentMethod=null;
		}
		
        SortStoreTransactions sortStoreTransactions=new SortStoreTransactions();
        List<A1> SearchedItems;
        SearchedItems=new ArrayList<A1>(sortStoreTransactions.sortTransactions(id,totalAmount,totalPieces,category,paymentMethod,date));
        
        if(id!=null) {
        	request.setAttribute("SearchedItems", SearchedItems); 
        	ServletContext context= getServletContext();
        	RequestDispatcher rd= request.getRequestDispatcher("/sortTony.jsp");
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
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}