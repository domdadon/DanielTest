package uebung3;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HeaderServlet
 */
@WebServlet("/HeaderServlet")
public class HeaderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String output = "<!DOCTYPE html><html><head><title>Header-Informationen</title></head><body>";
		output += "<h1>Ausgabe Header eines HTTP-Requests</h1>";
		output += "<table border=\"1\"><tr><th>Header-Name</th><th>Header-Inhalt</th></tr>";
		Enumeration<String> headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String headerName = headerNames.nextElement();
			output += "<tr><td>" + headerName + "</td><td>"; 
			Enumeration<String> values = request.getHeaders(headerName);
			while (values.hasMoreElements()) {
				String value = values.nextElement();
				output += value + "; ";
			}
			output += "</td></tr>";
		}
		output += ("</table></body></html>");
		
		// HTTP-Header setzen
		response.setStatus(HttpServletResponse.SC_OK);	// nicht zwingend erforderlich; ist der default-Wert
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		// HTML-Ergebnis senden
		response.getWriter().println(output);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
