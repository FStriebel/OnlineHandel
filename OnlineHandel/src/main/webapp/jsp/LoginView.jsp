
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="../css/Login.css" />
<script type="text/javascript" src="../js/OH.js" ></script>
</head>
<body>
<jsp:useBean id="lb" class="de.hwg_lu.bwi520.beans.LoginBean" scope="session" />
<h1>Head</h1>
----------------------------------
<br>
<br>

<form action="./LoginAppl.jsp" method="get">
<h3 id="login">Login</h3>

<input type="text" name="bname" value="" placeholder="Benutzername"/><br>
<input type="password" name="password" value="" placeholder="Passwort"/><br>
<input type="submit" name="login" value="Anmelden" id="button"/><br>
<p id="loginMsg"><jsp:getProperty name="lb" property="loginMsg"/></p>
<br>
<br>
<a href="./LoginAppl.jsp?zurReg=zurReg" id="link">Konto erstellen</a>







</form>

</body>
</html>