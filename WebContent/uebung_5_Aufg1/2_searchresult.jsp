<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
	uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Erfolgreiches Suchen von Produkten</title>
		<style>
			table, th, td {
				border: 1px solid; 
				border-collapse: collapse;
				padding: 5px;
				text-align: center;
			}
		</style>
	</head>
	<body>
		<h2>Erfolgreiches Suchen von Produkten</h2>
		<h3>Gelesene Daten</h3>
		<table>
			<tr>
				<th>Id</th>
				<th>Produktname</th>
				<th>Menge</th>
				<th>Aktion</th>
			</tr>
			<c:forEach var="product" items="${products}">
				<tr>
					<td>${product.id}</td>
					<td>${product.productname}</td>
					<td>${product.quantity}</td>
					<td><a href="deleteservlet?id=${product.id}">Löschen</a></td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>