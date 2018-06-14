package edu.thi.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import edu.thi.bean.Product;

/**
 * Servlet implementation class ProduktformServlet
 */
@WebServlet("/produktformservlet")
public class ProduktformServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Product form = new Product();
		form.setProductid(request.getParameter("productid"));
		form.setProductname(request.getParameter("productname"));
		form.setQuantity(Integer.valueOf(request.getParameter("quantity")));
		form.setSupplier(request.getParameter("supplier"));
		
		// Scope "Request"
		request.setAttribute("myProductForm", form);
		
		// Weiterleiten an JSP
		final RequestDispatcher dispatcher = request.getRequestDispatcher("uebung_4_Aufg1/produktform.jsp");
		dispatcher.forward(request, response);	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
