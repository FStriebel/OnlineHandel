<%@page import="de.hwg_lu.bwi520.beans.LoginBean"%>
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
<jsp:useBean id="lb" class="de.hwg_lu.bwi520.beans.LoginBean" scope="session" />

<%
String bname    = request.getParameter("bname");
String password = request.getParameter("password");
String login    = request.getParameter("login");
String zurReg   = request.getParameter("zurReg");

if(login == null) login = "";
if(zurReg == null) zurReg = "";

if(login.equals("Anmelden")){
	lb.setUserid(bname);
	lb.setPassword(password);
	try{
		boolean loginGeklappt = lb.checkUseridPassword();
		if(loginGeklappt){
			lb.setLoggedIn(true);
			response.sendRedirect("./Startseite.jsp");
		}else{
			lb.setLoggedIn(false);
			response.sendRedirect("./LoginView.jsp");
		}
	}catch(SQLException e){
		e.printStackTrace();
		lb.setLoggedIn(false);
		response.sendRedirect("./LoginView.jsp");
	}
}else if(zurReg.equals("zurReg")){
	response.sendRedirect("./RegView.jsp");	
}else{
	lb.setLoggedIn(false);
	response.sendRedirect("./LoginView.jsp");
	
}


%>


</body>
</html>