<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>HTML-Formularausgabe mittels JSP</title>
	</head>
	<body>
		<h2>HTML-Formularausgabe mittels JSP</h2>
		
		<%-- Auslesen der Formularfelder --%>
		<%
			final String nachname = request.getParameter("nachname");
			final String vorname = request.getParameter("vorname");
		%>
		
		<%-- Ausgabe der Formulardaten --%>
		<h3>Ihre Formulareingaben</h3>
		<br><b>Nachname: </b><%= nachname %>
		<br><b>Vorname: </b><%= vorname %>
		<br>
		<footer>
			<a href="./uebung2_aufgabe5_startseite.html">Startseite</a>
		</footer>
	</body>
</html>