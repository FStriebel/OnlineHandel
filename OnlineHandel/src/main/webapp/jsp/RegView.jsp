

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="../css/Reg.css" />
<script type="text/javascript" src="../js/OH.js" ></script>
</head>
<body>
<h1>Head</h1>
----------------------------------
<br>
<br>

<form action="./RegAppl.jsp" method="get" onsubmit="return checkInput(this)">
<h3 id="reg">Konto erstellen</h3>
<table>
<tr>
	<td>
		<input type="text" name="bname" value="" placeholder="Benutzername"/><br>
	</td>
	<td id="useridMsg" class="fehlerfeld">
		
	</td>
</tr>
<tr>
	<td>
		<input type="text" name="vorname" value="" placeholder="Vorname"/><br>
	</td>
	<td id="vornameMsg" class="fehlerfeld">
		
	</td>
</tr>
<tr>
	<td>
		<input type="text" name="nachname" value="" placeholder="Nachname"/><br>
	<td id="nachnameMsg" class="fehlerfeld">
		
	</td>
</tr>
<tr>
	<td>
		<input type="text" name="age" value="" placeholder="Alter"/><br>
	</td>
	<td id="ageMsg" class="fehlerfeld">
		
	</td>
</tr>
<tr>
	<td>
		<input type="text" name="email" value="" placeholder="Email"/><br>	
	</td>
	<td id="emailMsg" class="fehlerfeld">
		
	</td>
</tr>
<tr>
	<td>
		<input type="password" name="password" value="" placeholder="Passwort"/><br>
	</td>
	<td id="passwordMsg" class="fehlerfeld">
		
	</td>
</tr>
</table>

<input type="submit" name="erstellen" value="Erstellen" id="button" onclick="setButtonClicked(this.name)"/><br>




</form>
</body>
</html>