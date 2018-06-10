<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Fehlerseite</title>
	</head>
	<body>
		<h1>Fehlerseite</h1>
		Es ist ein Fehler aufgetreten!
		<br>Bitte benachrichtigen Sie den Web-Administrator unter <b>admin@demo.org</b>.
		<br>Die Fehlermeldung lautet:<br>
		<%= exception %>
	</body>
</html>