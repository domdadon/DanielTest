<!DOCTYPE html>
<html>
	<head>
		<title>HTML-Formularausgabe direkt mittels JSP-Expression Language</title>
	</head>
	<body>
		<h2>HTML-Formularausgabe direkt mittels JSP-Expression Language</h2>
		
		<h3>Ihre Formulareingaben</h3>
		<br><b>Produkt-ID: </b>${myProductForm.productid}
		<br><b>Produktname: </b>${myProductForm.productname}
		<br><b>Menge: </b>${myProductForm.quantity}
		<br><b>Lieferant: </b>${myProductForm.supplier}

	</body>
</html>