<%@ page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index-Page</title>
</head>
<body>
	<h4>Welcome to Servlet API</h4>

	<%
	int a = 10;
	System.out.println(a);
	%>
	<h4 style="color: red;">
		<%
		out.print(a);
		%>
	</h4>

	<h4 style="color: green;"><%=a%></h4>
	<%
	for (int i = 1; i <= 10; i++) {
		if(i%2==0){
	%>

	<h3 style="color:orange;"><%=i%></h3>

	<%
	}else{
	%>
	<h3 style="color:purple;"><%=i%></h3>
	<%}}%>
	
	
	
	<%! public String getTodayeDate(){
	
		return LocalDate.now()+" ";
	}
	%>
	
	<h5><%=getTodayeDate()%></h5>
	
</body>
</html>