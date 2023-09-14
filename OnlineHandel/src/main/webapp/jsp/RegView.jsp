

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="../css/Reg.css" />
</head>
<body>
<h1>Head</h1>
----------------------------------
<br>
<br>

<form action="./OHAppl.jsp" method="get">
<h3 id="reg">Konto erstellen</h3>

<input type="text" name="bnameReg" value="" placeholder="Benutzername"/><br>
<input type="text" name="vorname" value="" placeholder="Vorname"/><br>
<input type="text" name="name" value="" placeholder="Nachname"/><br>
<input type="text" name="email" value="" placeholder="Email"/><br>
<input type="text" name="passwordReg" value="" placeholder="Passwort"/><br>
<input type="submit" name="erstellen" value="Erstellen" id="button"/><br>




</form>
</body>
</html>