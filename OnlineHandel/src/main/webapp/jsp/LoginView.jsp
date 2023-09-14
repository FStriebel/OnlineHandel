
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="../css/Login.css" />
</head>
<body>
<h1>Head</h1>
----------------------------------
<br>
<br>

<form action="./OHAppl.jsp" method="get">
<h3 id="login">Login</h3>

<input type="text" name="bname" value="" placeholder="Benutzername"/><br>
<input type="text" name="password" value="" placeholder="Passwort"/><br>
<input type="submit" name="login" value="Anmelden" id="button"/><br>
<br>
<br>
<a href="./RegView.jsp" id="link">Konto erstellen</a>







</form>

</body>
</html>