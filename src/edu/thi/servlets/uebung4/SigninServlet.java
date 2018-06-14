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
 * Servlet implementation class SigninServlet
 */
@WebServlet("/signinservlet")
public class SigninServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Called via direct access --> forward to signin.jsp
		HttpSession session = request.getSession();
		
		// if it is a new session, set "en" as default language
		String lang = null;
		if (session.isNew()) {
			session.setAttribute("lang", "en");
			lang = "en";
		}
		else
			lang = (String)session.getAttribute("lang");
		
		// Set the right TranslationBean for JSP
		HashMap<String, HashMap<String,String>> languageMap = (HashMap<String, HashMap<String,String>>) getServletContext().getAttribute(lang);
		request.setAttribute("tb", languageMap.get("signin_"+lang));
		RequestDispatcher dispatcher = request.getRequestDispatcher("uebung_4_Aufg3/signin.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
