package uebung5;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class CreateServlet
 */
@WebServlet("/createservlet")
public class CreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(lookup="jdbc/MyTHIPool")
	private DataSource ds;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Auslesen der Formularwerte productname, quantity
		Product form = new Product();
		form.setProductname(request.getParameter("productname"));
		form.setQuantity(Integer.valueOf(request.getParameter("quantity")));
		
		//DB-Zugriff
		persist(form);
	}

	private void persist(Product form) throws ServletException {
		String[] generatedKeys = new String[] {"id"};	// Name der Spalte(n), die automatisch generiert wird(werden)
		
		try (Connection con = ds.getConnection();
			PreparedStatement pstmt = con.prepareStatement(
					"INSERT INTO products (productname,quantity) VALUES (?,?)", 
					generatedKeys)){

			// Zugriff über Klasse java.sql.PreparedStatement
			pstmt.setString(1, form.getProductname());
			pstmt.setInt(2, form.getQuantity());
			pstmt.executeUpdate();
			
			// Generierten Schlüssel auslesen
			ResultSet rs = pstmt.getGeneratedKeys();
			while (rs.next()) {
				form.setId(rs.getLong(1));
			}
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}
		
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
