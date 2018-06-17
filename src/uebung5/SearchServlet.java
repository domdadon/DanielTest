package uebung5;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import uebung5.Product;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/searchservlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(lookup="jdbc/MyTHIPool")
	private DataSource ds;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Servlet zur Entgegennahme von Formularinhalten, Lesen der Daten in einer DB und Generierung
		// eines Beans zur Weitergabe der Formulardaten an eine JSP
		
		request.setCharacterEncoding("UTF-8");	// In diesem Format erwartet das Servlet jetzt die Formulardaten
		String productname = request.getParameter("productname");
		
		// DB-Zugriff
		List<Product> products = search(productname);
				
		// Scope "Request"
		request.setAttribute("products", products);
		
		// Weiterleiten an JSP
		final RequestDispatcher dispatcher = request.getRequestDispatcher("uebung_5_Aufg1/2_searchresult.jsp");
		dispatcher.forward(request, response);	
	}

	private List<Product> search(String productname) throws ServletException {
		productname = (productname == null || productname == "") ? "%" : "%" + productname + "%";
		List<Product> products = new ArrayList<Product>();
		
		// DB-Zugriff
		try (Connection con = ds.getConnection();
			 PreparedStatement pstmt = con.prepareStatement("SELECT * FROM products WHERE productname LIKE ?")) {

			pstmt.setString(1, productname);
			try (ResultSet rs = pstmt.executeQuery()) {
			
				while (rs.next()) {
					Product product = new Product();
					product.setId(Long.valueOf(rs.getLong("id")));
					product.setProductname(rs.getString("productname"));
					product.setQuantity(rs.getInt("quantity"));
					
					products.add(product);
				} // while rs.next()
			}
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}
		
		return products;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
