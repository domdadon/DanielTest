package edu.thi.servlets.uebung4;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DispatcherServlet
 */
@WebServlet("/dispatcherservlet")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Called via link --> forward to same page, just with different language
		String lang = request.getParameter("lang");
		String uri = request.getParameter("uri");
		
		// if param lang not set, use default "en"
		if (lang == null || lang.equals(""))
			lang="en";
		
		// if param uri is not set, use register-page as default forward page
		if (uri == null || uri.equals(""))
			uri = "uebung_4_Aufg3/register.jsp";
		else
			uri = uri.substring(uri.indexOf('/', 1)+1);		// Cut off contextPath
		
		HttpSession session = request.getSession();
		session.setAttribute("lang", lang);

		// Set the right TranslationBean for JSP depending on target page (derived from URI)
		String pagename = uri.substring(uri.lastIndexOf('/')+1, uri.lastIndexOf('.'));
		HashMap<String, HashMap<String,String>> languageMap = (HashMap<String, HashMap<String,String>>) getServletContext().getAttribute(lang);
		request.setAttribute("tb", languageMap.get(pagename + "_" + lang));
		
		// log("Dispatching to: " + uri);
		RequestDispatcher dispatcher = request.getRequestDispatcher(uri);
		dispatcher.forward(request, response);
	}

}
