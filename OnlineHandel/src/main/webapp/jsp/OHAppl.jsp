<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="rb" class="de.hwg_lu.bwi520.beans.RegBean" scope="session" />
<jsp:useBean id="rb" class="de.hwg_lu.bwi520.beans.LoginBean" scope="session" />

<%
String bname       = request.getParameter("bname");
String passwort    = request.getParameter("password");
String login       = request.getParameter("login");
String bnameReg    = request.getParameter("bnameReg");
String vorname     = request.getParameter("vorname");
String name        = request.getParameter("name");
String email       = request.getParameter("email");
String passwordReg = request.getParameter("passwordReg");
String erstellen   = request.getParameter("erstellen");
if(login == null) login = "";
if(erstellen == null) erstellen = "";

if(login.equals("Anmelden")){
	
	
	response.sendRedirect("");
	
}else if (erstellen.equals("Erstellen")){
	
	rb.setBenutzername(bnameReg);
	rb.setPassword(passwordReg);
	rb.setVorname(vorname);
	rb.setNachname(name);
	rb.setEmail(email);
	
	
	
	response.sendRedirect("");
	
	
}else{
	
	
	response.sendRedirect("");
	
}





%>


</body>
</html>