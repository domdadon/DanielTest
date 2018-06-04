<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
	uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Meine 1. Formularausgabe mit JavaBean, Servlet und JSP</title>
	</head>
<body>
	<h1>Meine 1. Formularausgabe mit JavaBean, Servlet und JSP</h1>
	<hr>
	<b>Vorname: </b>${form.firstname}
	<br>
	<b>Nachname: </b>${form.lastname}
</body>
</html>