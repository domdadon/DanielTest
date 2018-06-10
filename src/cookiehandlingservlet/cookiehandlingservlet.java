package cookiehandlingservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class cookiehandlingservlet
 */
@WebServlet("/cookiehandlingservlet")
public class cookiehandlingservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// HTTP-Header setzen
		response.setStatus(HttpServletResponse.SC_OK);	// nicht zwingend erforderlich; ist der default-Wert
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		final PrintWriter out = response.getWriter();
		String action = request.getParameter("action");
		String vorname = null;
		String nachname = null;
		
		switch (action) {
			case "writeToCookies":
				vorname = request.getParameter("vorname");
				nachname = request.getParameter("nachname");
				Cookie cookie1 = new Cookie("vorname", vorname);
				cookie1.setMaxAge(60 * 60 * 24 * 7);
				cookie1.setPath("/");
				response.addCookie(cookie1);
				
				Cookie cookie2 = new Cookie("nachname", nachname);
				cookie2.setMaxAge(60 * 60 * 24 * 7);
				cookie2.setPath("/");
				response.addCookie(cookie2);
				
				out.println("<!DOCTYPE html>");
				out.println("<html>");
				out.println("<body>");
				out.println("<h3>Schreiben von Daten in Cookies</h3>");
				out.println("Cookiedaten wurden erfolgreich geschrieben!");
				out.println("<form method='post' action='cookiehandlingservlet'>");
				out.println("<div>");
				out.println("<button type='submit' name='action' value='readFromCookies'>Daten aus Cookies lesen</button>");
				out.println("</div>");
				out.println("</form>");
				out.println("</body>");
				out.println("</html>");
				break;
				
			case "readFromCookies":
				Cookie[] cookies = request.getCookies();
				for (Cookie cookie:cookies) {
					switch (cookie.getName()) {
					case "vorname":
						vorname = cookie.getValue();
						break;
					case "nachname":
						nachname = cookie.getValue();
						break;
					}
				}
				out.println("<!DOCTYPE html>");
				out.println("<html>");
				out.println("<body>");
				out.println("<h3>Lesen von Daten aus Cookies</h3>");
				out.println("<b>Gelesene Daten:</b><br>");
				out.println("Vorname: " + vorname + "<br>");
				out.println("Nachname: " + nachname + "<br>");
				out.println("</body>");
				out.println("</html>");
				break;
				
			default:
				out.println("<!DOCTYPE html>");
				out.println("<html>");
				out.println("<body>");
				out.println("<h3>Unbekannte Aktion!</h3>");
				out.println("</body>");
				out.println("</html>");
				break;
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
