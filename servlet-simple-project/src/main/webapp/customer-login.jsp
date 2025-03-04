<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<%
			String message=(String)request.getAttribute("msg");
			if(message!=null){
		%>
		<h4 style="color: red;"><%=message%></h4>
		<%}%>
		<form action="loginCustomer" method="get">
			<label>USERNAME:</label><br>
			<input type="email" placeholder="enter customer email" name="email"><br>
			
			<label>Password:</label><br>
			<input type="password" placeholder="enter customer password" name="password"><br>
			
			<input type="submit" value="Login">
		</form>
</body>
</html>