package edu.thi.servlets.uebung4;

import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 * Servlet implementation class TranslationServlet
 */
@WebServlet(urlPatterns = {"/translationservlet"}, loadOnStartup = 1)
public class TranslationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	@Override
	public void init() throws ServletException {
		log("TranslationServlet: initializing translation hashmaps");
		
		// Normally the properties would be read here
		// For simplicity reasons it has been hard-coded
		
		// Filling Hashmaps for page "register.jsp"
		// German
		HashMap<String, String> register_de = new HashMap<>();
		register_de.put("lang", "de");
		register_de.put("headline", "Bücher-Onlineshop - Registrierung");
		register_de.put("register", "Registrieren");
		register_de.put("login", "Einloggen");
		register_de.put("switchToLanguage", "English");
		register_de.put("switchToLang", "en");
		register_de.put("legend", "Registrieren");
		register_de.put("password", "Passwort");
		register_de.put("password_title", "6-10 Zeichen");
		register_de.put("password_placeholder", "Passwort eingeben");
		register_de.put("email_title", "demo@beispiel.de");
		register_de.put("email_placeholder", "E-Mail eingeben");
		register_de.put("bt_send", "Absenden");
		register_de.put("bt_reset", "Zurücksetzen");
		register_de.put("copyright", "Copyright: Hugo Habicht und Susi Sorglos, Düsseldorf");
		
		// English
		HashMap<String, String> register_en = new HashMap<>();
		register_en.put("lang", "en");
		register_en.put("headline", "Books Onlinestore - Registration");
		register_en.put("register", "Register");
		register_en.put("login", "Login");
		register_en.put("switchToLanguage", "Deutsch");
		register_en.put("switchToLang", "de");
		register_en.put("legend", "Register");
		register_en.put("password", "Password");
		register_en.put("password_title", "6-10 characters");
		register_en.put("password_placeholder", "Enter Password");
		register_en.put("email_title", "demo@example.com");
		register_en.put("email_placeholder", "Enter Email");
		register_en.put("bt_send", "Send");
		register_en.put("bt_reset", "Reset");
		register_en.put("copyright", "Copyright: Hugo Habicht and Susi Sorglos, Düsseldorf");

		// Filling Hashmaps for page "signin.jsp"
		// German
		HashMap<String, String> signin_de = new HashMap<>();
		signin_de.put("lang", "de");
		signin_de.put("headline", "Bücher-Onlineshop - Login");
		signin_de.put("register", "Registrieren");
		signin_de.put("login", "Einloggen");
		signin_de.put("switchToLanguage", "English");
		signin_de.put("switchToLang", "en");
		signin_de.put("legend", "Einloggen");
		signin_de.put("password", "Passwort");
		signin_de.put("password_title", "6-10 Zeichen");
		signin_de.put("password_placeholder", "Passwort eingeben");
		signin_de.put("email_title", "demo@beispiel.de");
		signin_de.put("email_placeholder", "E-Mail eingeben");
		signin_de.put("bt_send", "Absenden");
		signin_de.put("bt_reset", "Zurücksetzen");
		signin_de.put("copyright", "Copyright: Hugo Habicht und Susi Sorglos, Düsseldorf");
		
		// English
		HashMap<String, String> signin_en = new HashMap<>();	
		signin_en.put("lang", "en");
		signin_en.put("headline", "Books Onlinestore - Login");
		signin_en.put("register", "Register");
		signin_en.put("login", "Login");
		signin_en.put("switchToLanguage", "Deutsch");
		signin_en.put("switchToLang", "de");
		signin_en.put("legend", "Login");
		signin_en.put("password", "Password");
		signin_en.put("password_title", "6-10 characters");
		signin_en.put("password_placeholder", "Enter Password");
		signin_en.put("email_title", "demo@example.com");
		signin_en.put("email_placeholder", "Enter Email");
		signin_en.put("bt_send", "Send");
		signin_en.put("bt_reset", "Reset");
		signin_en.put("copyright", "Copyright: Hugo Habicht and Susi Sorglos, Düsseldorf");
		
		// Hashmap for all German translations
		HashMap<String, HashMap<String,String>> de = new HashMap<>();
		de.put("register_de", register_de);
		de.put("signin_de", signin_de);
		
		// Hashmap for all English translations
		HashMap<String, HashMap<String,String>> en = new HashMap<>();
		en.put("signin_en", signin_en);
		en.put("register_en", register_en);

		// Storing all translations in application scope
		getServletContext().setAttribute("en", en);
		getServletContext().setAttribute("de", de);
		
		log("TranslationServlet: initializing translation hashmaps finished");
	}

}
