<%@page import="de.hwg_lu.bwi520.beans.RegBean"%>
<%@page import="java.sql.SQLException"%>
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

<%
String userid    = request.getParameter("bname");
String vorname   = request.getParameter("vorname");
String nachname  = request.getParameter("nachname");
String ageString = request.getParameter("age");
String email     = request.getParameter("email");
String password  = request.getParameter("password");
String erstellen = request.getParameter("erstellen");

rb.AccountBean();

if(erstellen == null) erstellen = "";

int age = 0;
try{
	age = Integer.parseInt(ageString);
}catch(NumberFormatException nfe){
	nfe.printStackTrace();
	age = -1;
}

if (erstellen.equals("Erstellen")){
	rb.setUserid(userid);
	rb.setPassword(password);
	rb.setVorname(vorname);
	rb.setNachname(nachname);
	rb.setAge(age);
	rb.setEmail(email);
	
	rb.checkData();
	
	try{
		boolean accountAngelegt = rb.insertAccountIfNotExists();
		System.out.println(accountAngelegt);
		if(accountAngelegt){
			response.sendRedirect("./LoginView.jsp");
		}else{
			response.sendRedirect("./RegView.jsp");
		}
	}catch(SQLException e){
		e.printStackTrace();
		response.sendRedirect("./RegView.jsp");
	}
	
}else{
	response.sendRedirect("./RegView.jsp");
	
}




%>
</body>
</html>