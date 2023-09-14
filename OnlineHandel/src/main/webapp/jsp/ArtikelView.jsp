<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="../css/Artikel.css" />
</head>
<body>
<jsp:useBean id="ab" class="de.hwg_lu.bwi520.beans.ArtikelBean" scope="session" />
<form action="" method="get">

<table>
	<tr>
		<td rowspan="2">
			<img src="../img/cart.png"/>
		</td>
		<td colspan="2">
			<p>Beschreibung:</p><br>
			<p><jsp:getProperty name="ab" property="" /></p>
		</td>
	</tr>
	<tr>
	
		<td colspan="2">
			<p>Rezensionen:</p><br>
			<p><jsp:getProperty name="ab" property="" /></p>
		</td>
	</tr>
	<tr>
		<td></td>
		<td>Anzahl: </td>
		<td><input type="submit" name="zumWK" value="In den Warenkorb"/></td>
	</tr>
	





</table>




</form>






</body>
</html>