<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link type= "text/css" rel= "stylesheet" href= "../css/Startseite.css"/>
</head>
<body>
	<!-- Navbar oben ungestyled und noch nicht fertig aber Anfang -->
	
	<div class= "navbar">
	<!-- select mit Bean Methode automatisch machen alle Kategorien aus DB háuflisten -->
		<label>Kategorien:
			<select name="Überschrift" size= 1 id="katAuswahl">
				<option value="kat1">Tiere</option>
				<option value="kat2">Menschen</option>
				<option value="kat3">Pflanzen</option>
			</select>
		</label>
		<input type="text" name="suchfeld" value="" placeholder= "Suchen Sie etwas!" id= "suchFeld"/>
		<input type= "button" name = "btnSuchen" value= "suchen" id= "suchKnopf"/>
		<a href= "https://de.wikipedia.org/wiki/Wikipedia:Hauptseite" id= "warenKorb"> <img src="../img/cart.png" class= "icons"/></a>
		<a href= "https://instagram.com" id= "benutzer"> <img src="../img/user.png" class= "icons"/></a>
		
	</div>

		<form>
			<table>
				<tr>
					<td></td>
				</tr>	
			</table>
		</form>

</body>
</html>